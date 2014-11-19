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

package ca.infoway.messagebuilder.xml.validator;

import static ca.infoway.messagebuilder.marshalling.hl7.Hl7Error.createInvalidFixedValueAttributeError;
import static ca.infoway.messagebuilder.marshalling.hl7.Hl7Error.createMissingMandatoryAttributeError;
import static ca.infoway.messagebuilder.marshalling.hl7.Hl7Error.createMissingNamespace;
import static ca.infoway.messagebuilder.marshalling.hl7.Hl7Error.createUnknownInteractionError;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.Typed;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelTransformationException;
import ca.infoway.messagebuilder.marshalling.hl7.parser.BlElementParser;
import ca.infoway.messagebuilder.marshalling.hl7.parser.CvElementParser;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ElementParser;
import ca.infoway.messagebuilder.marshalling.hl7.parser.NullFlavorHelper;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParserRegistry;
import ca.infoway.messagebuilder.util.xml.NodeUtil;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.util.ConformanceLevelUtil;
import ca.infoway.messagebuilder.xml.visitor.MessageVisitor;

/**
 * @deprecated
 * This validation approach is no longer being used.
 */
@Deprecated
public class ValidatingVisitor implements MessageVisitor {

	private static final String ITS_VERSION_VALUE = "XML_1.0";
	private static final String ITS_VERSION = "ITSVersion";
	private static final String HL7_NAMESPACE = "urn:hl7-org:v3";
	private final XmlToModelResult result = new XmlToModelResult();
	private final VersionNumber version;
	
	public ValidatingVisitor(VersionNumber version) {
		this.version = version;
	}
	
	public MessageValidatorResult getResult() {
		MessageValidatorResult validatorResult = new MessageValidatorResult();
		validatorResult.getHl7Errors().addAll(this.result.getHl7Errors());
		return validatorResult;
	}

	public void visitAssociation(Element base, String xmlName, List<Element> elements, Relationship relationship) {
		if (relationship == null) {
			// shouldn't happen
		} else if (CollectionUtils.isEmpty(elements) && ConformanceLevelUtil.isMandatory(relationship)) {
			this.result.addHl7Error(Hl7Error.createMissingMandatoryAssociationError(xmlName, base));
		} else if (CollectionUtils.isEmpty(elements) && ConformanceLevelUtil.isPopulated(relationship)) {
			this.result.addHl7Error(Hl7Error.createMissingPopulatedAssociationError(xmlName, base));
		} else if (!relationship.getCardinality().contains(elements.size())) {
			this.result.addHl7Error(Hl7Error.createWrongNumberOfAssociationsError(xmlName, base, elements.size(), relationship.getCardinality()));
		} else if (ConformanceLevelUtil.isIgnored(relationship) && ConformanceLevelUtil.isIgnoredNotAllowed()) {
			this.result.addHl7Error(Hl7Error.createIgnoredAsNotAllowedConformanceLevelRelationshipError(xmlName, base));
		} else if (ConformanceLevelUtil.isNotAllowed(relationship)) {
			this.result.addHl7Error(Hl7Error.createNotAllowedConformanceLevelRelationshipError(xmlName, base));
		}
		if (relationship.getCardinality().isSingle() && elements.size() == 1) {
			checkForInvalidNullFlavor(elements.get(0), relationship);
		}
	}

	private void checkForInvalidNullFlavor(Element element, Relationship relationship) {
		NullFlavorHelper nullFlavorHelper = new NullFlavorHelper(relationship.getConformance(), element, this.result, true);
		if (nullFlavorHelper.hasValidNullFlavorAttribute()) {
			nullFlavorHelper.parseNullNode();
		}
	}

	public void visitRoot(Element documentElement, Interaction interaction) {
		if (interaction == null) {
			this.result.addHl7Error(createUnknownInteractionError(
					documentElement == null 
						? "unknown" 
						: NodeUtil.getLocalOrTagName(documentElement),
					documentElement));
		} else {
			if (!documentElement.hasAttribute(ITS_VERSION)) {
				this.result.addHl7Error(createMissingMandatoryAttributeError(ITS_VERSION, documentElement));
			} else if (!StringUtils.equals(ITS_VERSION_VALUE, documentElement.getAttribute(ITS_VERSION))) {
				this.result.addHl7Error(createInvalidFixedValueAttributeError(documentElement.getAttributeNode(ITS_VERSION), ITS_VERSION_VALUE));
			}
			
			if (StringUtils.isBlank(documentElement.getNamespaceURI())
					|| !HL7_NAMESPACE.equals(documentElement.getNamespaceURI())) {
				this.result.addHl7Error(createMissingNamespace(HL7_NAMESPACE, documentElement));
			}
		}
	}
	
	private boolean isHl7Attribute(Attr attr) {
		 return HL7_NAMESPACE.equals(attr.getNamespaceURI()) ||
				StringUtils.isBlank(attr.getNamespaceURI());
	}

	public void visitStructuralAttribute(Element base, Attr attr, Relationship relationship) {
		if (relationship == null && !isHl7Attribute(attr)) {
			// ignore
		} else if (attr != null && "nullFlavor".equals(attr.getName())) {
			// ignore
		} else if (relationship ==  null) {
			this.result.addHl7Error(Hl7Error.createUnknownStructuralAttributeError(base, attr));
		} else if (attr != null && relationship.hasFixedValue()) {
			validateFixedValue(attr, relationship.getFixedValue());
		} else if (attr != null) {
			validateStructuralAttributeValue(base, attr, relationship);
		} else if (relationship.hasFixedValue()) {  // also implies isMandatory()
			// various people suggest that fixed values can be left out
		} else if (ConformanceLevelUtil.isMandatory(relationship)) {
			this.result.addHl7Error(Hl7Error.createMissingMandatoryAttributeError(relationship.getName(), base));
		} else if (ConformanceLevelUtil.isIgnored(relationship) && ConformanceLevelUtil.isIgnoredNotAllowed()) {
			this.result.addHl7Error(Hl7Error.createIgnoredAsNotAllowedConformanceLevelRelationshipError(relationship.getName(), base));
		} else if (ConformanceLevelUtil.isNotAllowed(relationship)) {
			this.result.addHl7Error(Hl7Error.createNotAllowedConformanceLevelRelationshipError(relationship.getName(), base));
		}
	}

	private void validateStructuralAttributeValue(Element base, Attr attr, Relationship relationship) {
		// FIXME - TM - CDA - R2: need to handle BN and BL for R2 here?
		if (StandardDataType.BL == StandardDataType.getByTypeName((Typed) relationship)) {
			new BlElementParser().parseBooleanValue(this.result, attr.getValue(), base, attr);
		} else if (StandardDataType.CS == StandardDataType.getByTypeName((Typed) relationship)) {
			new CvElementParser().doParse(ParseContextImpl.create(relationship, this.version, null), base, this.result, false, attr.getLocalName());
		} else {
			this.result.addHl7Error(Hl7Error.createUnknownStructuralTypeError(relationship.getType(), relationship.getName(), base, attr));
		}
	}

	private void validateFixedValue(Attr attr, String fixedValue) {
		if (!StringUtils.equals(fixedValue, attr.getValue())) {
			this.result.addHl7Error(Hl7Error.createInvalidFixedValueAttributeError(attr, fixedValue));
		}
	}

	public void visitNonStructuralAttribute(Element base, List<Element> elements, Relationship relationship) {
		if (relationship == null && !elements.isEmpty()) {
			this.result.addHl7Error(Hl7Error.createUnknownChildElementError(elements.get(0)));
		} else if (relationship != null) {
			if (CollectionUtils.isEmpty(elements) && ConformanceLevelUtil.isMandatory(relationship)) {
				this.result.addHl7Error(Hl7Error.createMissingMandatoryAttributeError(relationship.getName(), base));
			} else if (CollectionUtils.isEmpty(elements) && ConformanceLevelUtil.isPopulated(relationship)) {
				this.result.addHl7Error(Hl7Error.createMissingPopulatedAttributeError(relationship.getName(), base));
			} else if (ConformanceLevelUtil.isIgnored(relationship) && ConformanceLevelUtil.isIgnoredNotAllowed()) {
				this.result.addHl7Error(Hl7Error.createIgnoredAsNotAllowedConformanceLevelRelationshipError(relationship.getName(), base));
			} else if (ConformanceLevelUtil.isNotAllowed(relationship)) {
				this.result.addHl7Error(Hl7Error.createNotAllowedConformanceLevelRelationshipError(relationship.getName(), base));
			} else {
				try {
					ElementParser parser = ParserRegistry.getInstance().get((Typed) relationship);
					if (parser != null) {
						// not a concern that constraints not passed in - validator will eventually be removed (replaced with a call to the unmarshaller)
						BareANY value = parser.parse(ParseContextImpl.create(relationship, this.version, null), toNodeList(elements), this.result);
						validateNonstructuralFixedValue(relationship, value, elements);
					} else {
						this.result.addHl7Error(
							new Hl7Error(
								Hl7ErrorCode.SYNTAX_ERROR, 
								"Cannot find a parser for type " + relationship.getType(),
								CollectionUtils.isEmpty(elements) ? null : elements.get(0)
							));
					}
				} catch (XmlToModelTransformationException e) {
					this.result.addHl7Error(
						new Hl7Error(
							Hl7ErrorCode.SYNTAX_ERROR, 
							e.getMessage(),
							CollectionUtils.isEmpty(elements) ? null : elements.get(0)
						));
				}
			}
		}
	}

	private void validateNonstructuralFixedValue(Relationship relationship,	BareANY value, List<Element> elements) {
		if (relationship.hasFixedValue()) {
			boolean valid = false;
			boolean valueProvided = (value != null && value.getBareValue() != null);
			if (valueProvided) {
				if ("BL".equals(relationship.getType()) && value instanceof BL) {
					String valueAsString = ((BL) value).getValue().toString();
					valid = relationship.getFixedValue().equalsIgnoreCase(valueAsString);
				} else if ("INT.POS".equals(relationship.getType()) && value instanceof INT) {
					String valueAsString = ((INT) value).getValue().toString();
					valid = relationship.getFixedValue().equalsIgnoreCase(valueAsString);
				} else if (relationship.isCodedType() && value instanceof CD) {
					// FIXME - CDA - TM - the above "if" check will fail on the instanceof check for CDA coded types; the rest of this code block needs refactoring as well
					// removed/inlined reference to Code so that .NET does not confuse it with the xml version
					valid = (((CD) value).getValue().getCodeValue() != null && 
								StringUtils.equals(relationship.getFixedValue(), ((CD) value).getValue().getCodeValue()));
				} else {
					this.result.addHl7Error(
						new Hl7Error(
							Hl7ErrorCode.SYNTAX_ERROR, 
							"Non-structural fixed-value attribute '" + relationship.getName() +"' was of unexpected type '" + relationship.getType() + "'",
							CollectionUtils.isEmpty(elements) ? null : elements.get(0)
						));
				}
			}
			if (!valid) {
				this.result.addHl7Error(
					new Hl7Error(
						Hl7ErrorCode.MANDATORY_FIELD_NOT_PROVIDED, 
						"Fixed-value attribute '" + relationship.getName() +"' must have value '" + relationship.getFixedValue() + "'",
						CollectionUtils.isEmpty(elements) ? null : elements.get(0)
					));
			}
		}
	}

	private List<Node> toNodeList(List<Element> elementList) {
		List<Node> result =  new ArrayList<Node>();
		for (Node node : elementList) {
			result.add(node);
		}
		return result;
	}

	public void addError(String message, Element element) {
		this.result.addHl7Error(
				new Hl7Error(
					Hl7ErrorCode.SYNTAX_ERROR, 
					message,
					element
				));
	}
}
