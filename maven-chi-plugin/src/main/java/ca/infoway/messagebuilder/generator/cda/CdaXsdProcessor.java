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
import java.util.List;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.ConstrainedDatatype;
import ca.infoway.messagebuilder.xml.DomainSource;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.SchemaMetadata;
import ca.infoway.messagebuilder.xml.SpecializationChild;
import ca.infoway.messagebuilder.xml.TypeName;

public class CdaXsdProcessor {

	public void processSchema(Schema schema, MessageSet messageSet) {
		
		messageSet.setGeneratedAsR2(true);	// temporary - eventually, this should be specified as a parameter.
		
		messageSet.setSchemaMetadata(parseMetadata(schema));

		// first, parse all the constrained datatypes
		for (ComplexType complexType : schema.getComplexTypes()) {
			ComplexContent complexContent = complexType.getComplexContent();
			if (complexContent != null) {
				ConstrainedDatatype constrainedDatatype = new ConstrainedDatatype(complexType.getName(),
						complexContent.getChild().getBase());
				
				if (complexContent.getChild() instanceof Extension) {
					constrainedDatatype.setExtension();
				}
				
				List<Relationship> attributeRelationships = parseAttributes(complexContent.getChild().getAttributes());
				
				for (Relationship attributeRelationship : attributeRelationships) {
					constrainedDatatype.getRelationships().add(attributeRelationship);
				}
				
				messageSet.addConstrainedDatatype(constrainedDatatype);
			}
		}
		
		// then parse all the rest, excluding the constrained datatypes
		for (ComplexType complexType : schema.getComplexTypes()) {
			if (complexType.getComplexContent() == null) {
				String name = complexType.getName();
				
				TypeName typeName = new TypeName(name);
				String packageName = typeName.getRootName().getName();
				if (!messageSet.getPackageLocations().containsKey(packageName)) {
					messageSet.getPackageLocations().put(packageName, new PackageLocation(packageName));
				}
				
				MessagePart messagePart = new MessagePart(complexType.getName());
				
				List<Relationship> attributeRelationships = parseAttributes(complexType.getAttributes());
				
				int sortOrder = 1;
				for (Relationship attributeRelationship : attributeRelationships) {
					attributeRelationship.setSortOrder(sortOrder++);
					
					messagePart.getRelationships().add(attributeRelationship);
				}
				
				Sequence sequence = complexType.getSequence();
				if (sequence != null) {
					for (SequenceChild child : sequence.getChildren()) {
						if (child instanceof XsElement) {
							XsElement element = (XsElement) child;
							Relationship relationship = parseElement(element, messageSet);
							relationship.setSortOrder(sortOrder++);
							messagePart.getRelationships().add(relationship);
						} else if (child instanceof Choice) {
							Choice choice = (Choice) child;
							Relationship relationship = new Relationship();
							String choiceName = typeName.getUnqualifiedName() + "Choice";
							String choiceClassName = typeName.getParent().getName() + "." + choiceName;
							relationship.setName(StringUtils.uncapitalize(choiceName));
							relationship.setType(choiceClassName);
							relationship.setSortOrder(sortOrder++);
							int min = minimumOfMinimums(choice.getElements());
							int max = maximumOfMaximums(choice.getElements());
							Cardinality cardinality = new Cardinality(min, max);
							relationship.setCardinality(cardinality);
							relationship.setConformance(cardinality.isMandatory() ? ConformanceLevel.MANDATORY : ConformanceLevel.OPTIONAL);
							
							MessagePart choicePart = new MessagePart(choiceClassName);
							choicePart.setAbstract(true);
							
							for (XsElement choiceElement : choice.getElements()) {
								relationship.getChoices().add(parseElement(choiceElement, messageSet));
								choicePart.addSpecializationChild(new SpecializationChild(choiceElement.getType()));
							}
							messagePart.getRelationships().add(relationship);
							
							messageSet.addMessagePart(choicePart);
						}
					}
				}
				
				messageSet.addMessagePart(messagePart);
			}
		}
	}

	private int minimumOfMinimums(List<XsElement> elements) {
		int min = 1;
		for (XsElement element : elements) {
			int lowerBound = parseLowerBound(element.getMinOccurs());
			if (lowerBound < min) {
				min = lowerBound;
			}
		}
		return min;
	}

	private int maximumOfMaximums(List<XsElement> elements) {
		int max = 1;
		for (XsElement element : elements) {
			int upperBound = parseUpperBound(element.getMaxOccurs());
			if (upperBound < max) {
				max = upperBound;
			}
		}
		return max;
	}
	
	private SchemaMetadata parseMetadata(Schema schema) {
		SchemaMetadata schemaMetadata = new SchemaMetadata();
		schemaMetadata.setTargetNamespace(schema.getTargetNamespace());
		schemaMetadata.setElementFormDefault(schema.getElementFormDefault());
		
		if (schema.getAnnotation() != null && schema.getAnnotation().getDocumentation() != null) {
			schemaMetadata.setDocumentation(schema.getAnnotation().getDocumentation().getText());
		}
		
		for (Include include : schema.getIncludes()) {
			schemaMetadata.getSchemaLocations().add(include.getSchemaLocation());
		}
		
		return schemaMetadata;
	}

	private List<Relationship> parseAttributes(List<XsAttribute> attributes) {
		List<Relationship> attributeRelationships = new ArrayList<Relationship>();
		for (XsAttribute attribute : attributes) {
			if (StringUtils.equals("nullFlavor", attribute.getName())) {
				// exception - the nullFlavor attribute is special, and should not be parsed
				//  we already have a built-in null flavor mechanism in the legacy code to handle message models derived from MIFs
				//  parsing this attribute when it occurs in the XSD causes a conflict
				continue;
			}
				
			Cardinality cardinality = new Cardinality(
					isAttributeRequired(attribute) ? 1 : 0, 
					1);
			String typeName = attribute.getType();
			
			StandardDataType standardType = StandardDataType.getByTypeNameIgnoreCase(typeName);
			boolean isStandardType = standardType != null;
			boolean namespaceType = typeName.contains(":");
			String dataType;
			if (namespaceType) {
				// special handling for the particular cases we've seen so far
				if (typeName.contains("boolean")) {
					dataType = "BL";
				} else { 
					dataType = "ST";
				}
			} else if (isStandardType) {
				dataType = standardType.getType();
			} else if (isAllLowerCase(typeName)) {
				// an all lower case name is unlikely to be a code system name
				dataType = typeName;
			} else {
				dataType = "CS";
			}
			
			Relationship relationship = new Relationship(attribute.getName(), dataType, cardinality);
			relationship.setStructural(true);
			if (namespaceType) {
				relationship.setConstrainedType(typeName);
			} else if (!isStandardType) {
				relationship.setDomainSource(DomainSource.VALUE_SET);
				relationship.setDomainType(typeName);
			}
			relationship.setConformance(createConformance(attribute));
			relationship.setFixedValue(attribute.getFixed());
			relationship.setDefaultValue(attribute.getDefaultValue());
			attributeRelationships.add(relationship);
		}
		return attributeRelationships;
	}

	private boolean isAllLowerCase(String name) {
		return StringUtils.lowerCase(name).equals(name);
	}

	private Relationship parseElement(XsElement element, MessageSet messageSet) {
		Cardinality cardinality = new Cardinality(
				parseLowerBound(element.getMinOccurs()), 
				parseUpperBound(element.getMaxOccurs()));
		String type = element.getType();
		String baseType;
		String constrainedType = null;
		if (messageSet.hasConstrainedDatatype(type)) {
			baseType = messageSet.getConstrainedDatatype(type).getBaseType();
			constrainedType = type;
		} else if ("StrucDoc.Text".equals(type)) {
			// special handling - structured narrative should be handled as a BLOB
			baseType = "ED";
			constrainedType = type;
		} else {
			baseType = type;
		}
		
		StandardDataType standardType = StandardDataType.valueOf(StandardDataType.class, baseType);
		if (standardType != null) {
			baseType = standardType.getType();
		}
		
		if (cardinality.isMultiple() && standardType != null) {
			baseType = "LIST<" + baseType + ">";
		}
		
		Relationship relationship = new Relationship(element.getName(), baseType, cardinality);
		relationship.setConformance(cardinality.isMandatory() ? ConformanceLevel.MANDATORY : ConformanceLevel.OPTIONAL);
		relationship.setConstrainedType(constrainedType);
		return relationship;
	}

	private int parseLowerBound(String minOccurs) {
		return StringUtils.isNumeric(minOccurs) ? Integer.valueOf(minOccurs) : 1;
	}

	private int parseUpperBound(String maxOccurs) {
		int value = 1;
		
		if (StringUtils.isBlank(maxOccurs)) {
			value = 1;	// standard default when the attribute is not provided
		} else if ("unbounded".equals(maxOccurs)) {
			value = Integer.MAX_VALUE;
		} else if (StringUtils.isNumeric(maxOccurs)) {
			value = Integer.valueOf(maxOccurs);
		}
		
		return value; 
	}

	protected boolean isAttributeRequired(XsAttribute attribute) {
		return "required".equals(attribute.getUse());
	}

	protected ConformanceLevel createConformance(XsAttribute attribute) {
		if (isAttributeRequired(attribute)) {
			return ConformanceLevel.REQUIRED;
		} else {
			return ConformanceLevel.OPTIONAL;
		}
	}

}
