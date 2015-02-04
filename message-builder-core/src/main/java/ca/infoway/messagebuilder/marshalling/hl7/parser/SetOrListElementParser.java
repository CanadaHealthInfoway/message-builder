/**
 * Copyright 2013 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import java.lang.reflect.Type;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.error.ErrorLogger;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.error.ErrorLevel;
import ca.infoway.messagebuilder.error.Hl7Errors;
import ca.infoway.messagebuilder.j5goodies.Generics;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7DataTypeName;
import ca.infoway.messagebuilder.marshalling.hl7.Registry;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.marshalling.hl7.constraints.IiCollectionConstraintHandler;
import ca.infoway.messagebuilder.marshalling.hl7.constraints.IiCollectionConstraintHandler.ConstraintResult;
import ca.infoway.messagebuilder.marshalling.polymorphism.PolymorphismHandler;
import ca.infoway.messagebuilder.schema.XmlSchemas;
import ca.infoway.messagebuilder.xml.ConstrainedDatatype;

public abstract class SetOrListElementParser extends AbstractElementParser {

	private final Registry<ElementParser> parserRegistry;
	private final boolean isR2;

	public SetOrListElementParser(Registry<ElementParser> parserRegistry, boolean isR2) {
		this.parserRegistry = parserRegistry;
		this.isR2 = isR2;
	}
	
	// only checking II constraints for now
	private IiCollectionConstraintHandler constraintHandler = new IiCollectionConstraintHandler();
	private PolymorphismHandler polymorphismHandler = new PolymorphismHandler();
	
	@Override
	public BareANY parse(ParseContext context, List<Node> nodes, XmlToModelResult xmlToModelResult) throws XmlToModelTransformationException {
 		String subType = getSubType(context);
		Collection<BareANY> list = getCollectionType(context);
		
		validateCardinality(context, nodes, xmlToModelResult);
		
		for (Node node : nodes) {
			
			String actualType = determineActualType(node, subType, context.isCda(), xmlToModelResult);
			
			ElementParser parser = this.parserRegistry.get(actualType);
			if (parser != null) {
				BareANY result = parser.parse(
						ParseContextImpl.create(
								actualType,
								getSubTypeAsModelType(context),
								context),  // constraints are *not* passed down with collections
						toList(node),
						xmlToModelResult);
				if (result != null) {
					if (!StringUtils.equals(subType, actualType)) {
						result.setDataType(StandardDataType.getByTypeName(actualType));
					}
					if (list.contains(result)) {
						resultAlreadyExistsInCollection(result, (Element) node, xmlToModelResult);
					}
					list.add(result);
				}
			} else {
				xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.INTERNAL_ERROR,
						"No parser type found for " + actualType, (Element) node));
			}
		}
		
		handleConstraints(subType, list, context.getConstraints(), nodes, xmlToModelResult);
		
		return wrapWithHl7DataType(context.getType(), subType, list);
	}

	private String determineActualType(Node node, String subType, boolean isCda, Hl7Errors errors) {
		String newType = ((Element) node).getAttributeNS(XmlSchemas.SCHEMA_INSTANCE, "type");
		return this.polymorphismHandler.determineActualDataTypeFromXsiType(subType, newType, isCda, !this.isR2, createErrorLogger((Element) node, errors));
	}

	private ErrorLogger createErrorLogger(final Element element, final Hl7Errors errors) {
		return new ErrorLogger() {
			public void logError(Hl7ErrorCode errorCode, ErrorLevel errorLevel, String errorMessage) {
				errors.addHl7Error(new Hl7Error(errorCode, errorLevel, errorMessage, (Node) element));
			}
		};
	}

	private void handleConstraints(String type, Collection<BareANY> parsedItems, ConstrainedDatatype constraints, List<Node> nodes, XmlToModelResult xmlToModelResult) {
		ConstraintResult constraintResult = this.constraintHandler.checkConstraints(type, constraints, parsedItems);
		if (constraintResult != null) {
			boolean isTemplateId = constraintResult.isTemplateId();
			if (constraintResult.isFoundMatch()) {
				if (isTemplateId) {
					String msg = MessageFormat.format("Found match for templateId fixed constraint: {0}", constraintResult.getIdentifer());
					xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.CDA_TEMPLATEID_FIXED_CONSTRAINT_MATCH, ErrorLevel.INFO, msg, nodes.size() > 0 ? nodes.get(0) : null));
				}
			} else {
				Hl7ErrorCode errorCode = (isTemplateId ? Hl7ErrorCode.CDA_TEMPLATEID_FIXED_CONSTRAINT_MISSING : Hl7ErrorCode.CDA_FIXED_CONSTRAINT_MISSING);
				String msg = "Expected to find an identifier with: " + constraintResult.getIdentifer();
				xmlToModelResult.addHl7Error(new Hl7Error(errorCode, ErrorLevel.WARNING, msg, nodes.size() > 0 ? nodes.get(0) : null));
			}
		}
	}

	protected void resultAlreadyExistsInCollection(BareANY result, Element node, XmlToModelResult xmlToModelResult) {
		// do nothing; allow subclasses to override if necessary
	}
	
	private void validateCardinality(ParseContext context, List<Node> nodes, XmlToModelResult xmlToModelResult) {
		int size = nodes.size();
		int min = (int) context.getCardinality().getMin();
		int max = (int) context.getCardinality().getMax();
		if (size < min) {
			xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR,
					"Number of elements (" + size + ") is less than the specified minimum (" + min + ")", getFirst(nodes)));
		}
		if (size > max) {
			xmlToModelResult.addHl7Error(new Hl7Error(Hl7ErrorCode.DATA_TYPE_ERROR,
					"Number of elements (" + size + ") is more than the specified maximum (" + max + ")", getFirst(nodes)));
		}
	}

	private Element getFirst(List<Node> nodes) {
		return (Element) (nodes == null || nodes.isEmpty() ? null : nodes.get(0));
	}

	protected void unableToAddResultToCollection(BareANY result, Element node, XmlToModelResult xmlToModelResult) {
		xmlToModelResult.addHl7Error(new Hl7Error(
				Hl7ErrorCode.INTERNAL_ERROR, "Could not add parsed value to collection", (Element) node));
	}
	
	protected abstract BareANY wrapWithHl7DataType(String type, String subType, Collection<BareANY> collection);

	protected abstract Collection<BareANY> getCollectionType(ParseContext context);

	private Type getSubTypeAsModelType(ParseContext context) {
		Type returnType = getReturnType(context);
		try {
			return Generics.getParameterType(returnType);
		} catch (IllegalArgumentException e) {
			return returnType;
		}
	}

	private List<Node> toList(Node node) {
		return Arrays.asList(node);
	}

	private String getSubType(ParseContext context) throws XmlToModelTransformationException {
		String subType = Hl7DataTypeName.getParameterizedType(context.getType());
		if (StringUtils.isNotBlank(subType)) {
			return subType;
		} else {
			throw new XmlToModelTransformationException("Cannot find the sub type for " + context.getType());
		}
	}

}