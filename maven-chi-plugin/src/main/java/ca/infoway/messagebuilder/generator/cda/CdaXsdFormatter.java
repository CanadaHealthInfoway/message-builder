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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.generator.cda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.ConstrainedDatatype;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.Relationship;

public class CdaXsdFormatter {
	
	/*
	 * We need to override standard alphabetical order in order to force the constrained datatypes to appear in the
	 * right places in the sequence. "Infrastructure Root" datatypes are global, and must appear at the very top of the file.
	 * Datatypes that are specific to a particular element must appear immediately before that element.
	 *
	 */
	private static class ComplexTypeNameComparitor implements Comparator<String> {

		private static final String INFRASTRUCTURE_MARKER = ".InfrastructureRoot.";
		
		@Override
		public int compare(String arg0, String arg1) {
			// Force infrastructure constrained types to float to the top
			if (arg0.contains(INFRASTRUCTURE_MARKER) && !arg1.contains(INFRASTRUCTURE_MARKER)) {
				return -1;
			}
			if (!arg0.contains(INFRASTRUCTURE_MARKER) && arg1.contains(INFRASTRUCTURE_MARKER)) {
				return 1;
			}
			
			// class-specific types
			if (isExtensionOf(arg0, arg1)) {
				return -1;
			}
			if (isExtensionOf(arg1, arg0)) {
				return 1;
			}
			
			// sort order should be case insensitive
			return arg0.toLowerCase().compareTo(arg1.toLowerCase());
		}
		
		private boolean isExtensionOf(String arg0, String arg1) {
			int length = arg1.length();
			return arg0.length() > length && 
					arg0.startsWith(arg1) && 
					arg0.charAt(length) == '.';
		}
		
	}

	public void formatSchema(Schema schema, MessageSet messageSet) {
		Map<String, Object> complexTypes = new TreeMap<String, Object>(new ComplexTypeNameComparitor());
		
		if (messageSet.getSchemaMetadata() != null) {
			schema.setTargetNamespace(messageSet.getSchemaMetadata().getTargetNamespace());
			schema.setElementFormDefault(messageSet.getSchemaMetadata().getElementFormDefault());
			if (messageSet.getSchemaMetadata().getDocumentation() != null) {
				schema.setAnnotation(new Annotation());
				schema.getAnnotation().setDocumentation(new Documentation());
				schema.getAnnotation().getDocumentation().setText(messageSet.getSchemaMetadata().getDocumentation());
			}
			for (String schemaLocation : messageSet.getSchemaMetadata().getSchemaLocations()) {
				schema.getIncludes().add(new Include(schemaLocation));
			}
		}
		
		for (MessagePart messagePart : messageSet.getAllMessageParts()) {
			if (messagePart.getSpecializationChilds().size() == 0) {
				// the parts representing choice blocks do not appear as types in the output
				complexTypes.put(messagePart.getName(), messagePart);
			}
		}
		
		for (ConstrainedDatatype datatype : messageSet.getAllConstrainedDatatypes()) {
			complexTypes.put(datatype.getName(), datatype);
		}
		
		for (String typeName : complexTypes.keySet()) {
			ComplexType complexType = new ComplexType();
			complexType.setName(typeName);
			Object part = complexTypes.get(typeName);
			if (part instanceof MessagePart) {
				populateComplexType(complexType, (MessagePart) part);
			} else if (part instanceof ConstrainedDatatype) {
				populateComplexType(complexType, (ConstrainedDatatype) part);
			}
			schema.getComplexTypes().add(complexType);
		}
	}

	private void populateComplexType(ComplexType complexType, MessagePart part) {
		for (Relationship relationship : insertNullFlavor(part)) {
			if (relationship.isAttribute()) {
				if (relationship.isStructural()) {
					XsAttribute attribute = formatAttribute(relationship);
					complexType.getAttributes().add(attribute);
				} else {
					XsElement element = formatElement(relationship);
					addElement(element, complexType);
				}
			} else {
				if (relationship.isChoice()) {
					Choice choice = new Choice();
					for (Relationship choiceElement : relationship.getChoices()) {
						choice.getElements().add(formatElement(choiceElement));
					}
					addElement(choice, complexType);
				} else {
					XsElement element = formatElement(relationship);
					addElement(element, complexType);
				}
			}
		}
	}

	private List<Relationship> insertNullFlavor(MessagePart part) {
		// During parsing, we had to filter out the attribute representing the nullFlavor
		// When exporting an XSD, we need to restore it
		Relationship nullFlavorRelationship = new Relationship("nullFlavor", "NullFlavor", new Cardinality(0, 1));
		nullFlavorRelationship.setStructural(true);
		
		ArrayList<Relationship> result = new ArrayList<Relationship>();
		List<Relationship> relationships = part.getRelationships();
		result.addAll(relationships);
		if (relationships.size() > 0 && StringUtils.equals(relationships.get(0).getName(), "ID")) {
			result.add(1, nullFlavorRelationship);
		} else {
			result.add(0, nullFlavorRelationship);
		}
		return result;
	}

	private XsElement formatElement(Relationship relationship) {
		XsElement element = new XsElement();
		element.setName(relationship.getName());
		
		if (relationship.getConstrainedType() != null) {
			element.setType(relationship.getConstrainedType());
		} else {
			if (relationship.getCardinality().isMultiple() && StandardDataType.isSetOrList(relationship.getType())) {
				element.setType(StandardDataType.getTemplateArgument(relationship.getType()).getName());
			} else {
				StandardDataType standardType = StandardDataType.getByTypeName(relationship.getType());
				if (standardType != null) {
					element.setType(standardType.getName());
				} else {
					element.setType(relationship.getType());
				}
			}
		}
		
		if (relationship.getCardinality().getMin() != 1) {
			element.setMinOccurs(String.valueOf(relationship.getCardinality().getMin()));
		}

		if (relationship.getCardinality().getMax().equals(Integer.MAX_VALUE)) {
			element.setMaxOccurs("unbounded");
		}
		
		return element;
	}

	private void addElement(SequenceChild element, ComplexType complexType) {
		if (complexType.getSequence() == null) {
			complexType.setSequence(new Sequence());
		}
		complexType.getSequence().getChildren().add(element);
	}

	private XsAttribute formatAttribute(Relationship relationship) {
		XsAttribute attribute = new XsAttribute();
		attribute.setName(relationship.getName());
		
		if ("CS".equals(relationship.getType())) {
			attribute.setType(relationship.getDomainType());
		} else if ("NullFlavor".equals(relationship.getType())) {
			attribute.setType(relationship.getType());
		} else if (StringUtils.isNotBlank(relationship.getConstrainedType())) {
			attribute.setType(relationship.getConstrainedType());
		} else {
			attribute.setType(relationship.getType().toLowerCase());
		}
		
		if (relationship.getCardinality().isMandatory()) {
			attribute.setUse("required");
		} else {
			attribute.setUse("optional");
		}
		
		attribute.setFixed(relationship.getFixedValue());
		attribute.setDefaultValue(relationship.getDefaultValue());
		
		return attribute;
	}

	private void populateComplexType(ComplexType complexType, ConstrainedDatatype part) {
		complexType.setComplexContent(new ComplexContent());
		ComplexContentChild child = null;
		
		if (part.isRestriction()) {
			child = new Restriction();
		} else if (part.isExtension()) {
			child = new Extension();
		} else {
			throw new IllegalArgumentException("Constrained datatype " + part.getName() + " is not valid.");
		}
		
		child.setBase(part.getBaseType());
		
		for (Relationship attribute : part.getRelationships()) {
			child.getAttributes().add(formatAttribute(attribute));
		}
		
		complexType.getComplexContent().setChild(child);
	}
}
