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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.generator.OutputUI;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.ConstrainedDatatype;
import ca.infoway.messagebuilder.xml.DomainSource;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.cda.vocabulary.ValueSetDefinition;
import ca.infoway.messagebuilder.xml.cda.vocabulary.ValueSetDefinitionSystem;

public class CdaXsdFormatter {
	
	private static class InferredComplexContent {
		
		private String name;
		private String baseType;
		private List<InferredAttribute> attributes = new ArrayList<InferredAttribute>();

		public String getName() {
			return name;
		}

		public String getBaseType() {
			return baseType;
		}

		public List<InferredAttribute> getAttributes() {
			return attributes;
		}
		
	}
	
	private static class InferredAttribute {
		private String name;
		private String type;
		private String use;
		private String fixed;
		public InferredAttribute(String name, String type, String use,
				String fixed) {
			super();
			this.name = name;
			this.type = type;
			this.use = use;
			this.fixed = fixed;
		}
		public String getName() {
			return name;
		}
		public String getType() {
			return type;
		}
		public String getUse() {
			return use;
		}
		public String getFixed() {
			return fixed;
		}
		
	}

	private OutputUI outputUI;
	
	private Map<String, String> codeSystemMap = new HashMap<String, String>();
	private Map<String, Object> complexTypes;
	
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

	public CdaXsdFormatter(OutputUI outputUI, ValueSetDefinition valueSetDefinition) {
		this.outputUI = outputUI;
		
		for (ValueSetDefinitionSystem system : valueSetDefinition.getSystems()) {
			if (StringUtils.isNotBlank(system.getCodeSystemName())) {
				this.codeSystemMap.put(system.getCodeSystemName(), system.getCodeSystemOid());
			}
		}
	}

	public void formatSchema(Schema schema, MessageSet messageSet, String packageName) {
		complexTypes = new TreeMap<String, Object>(new ComplexTypeNameComparitor());
		
		PackageLocation packageLocation = messageSet.getPackageLocation(packageName);

		if (messageSet.getSchemaMetadata() != null) {
			schema.setTargetNamespace(messageSet.getSchemaMetadata().getTargetNamespace());
			schema.setElementFormDefault(messageSet.getSchemaMetadata().getElementFormDefault());
			
			schema.setAnnotation(new Annotation());
			Documentation documentation = new Documentation();
			documentation.setText("Generated using message builder version 2.0.");
			schema.getAnnotation().getDocumentation().add(documentation);

			for (String schemaLocation : gatherSchemaDependencies(packageLocation, packageName)) {
				schema.getIncludes().add(new Include(schemaLocation + ".xsd"));
			}
		}
		
		Interaction interaction = messageSet.getInteractions().get(packageName);
		if (interaction != null) {
			XsElement rootElement = new XsElement();
			rootElement.setName(StringUtils.substringAfterLast(interaction.getSuperTypeName(), "."));
			rootElement.setType(interaction.getSuperTypeName());
			schema.addElement(rootElement);
		}
		
		if (packageLocation != null) {
			for (MessagePart messagePart : packageLocation.getMessageParts().values()) {
				if (messagePart.getSpecializationChilds().size() == 0) {
					// the parts representing choice blocks do not appear as types in the output
					complexTypes.put(messagePart.getName(), messagePart);
					for (Relationship relationship : messagePart.getRelationships()) {
						if (isCandidate(relationship)) {
							InferredComplexContent content = create(relationship, messagePart);
							complexTypes.put(content.getName(), content);
						}
					}
				}
			}
		}
		
		for (ConstrainedDatatype datatype : messageSet.getAllConstrainedDatatypes()) {
			if (StringUtils.startsWith(datatype.getName(), packageName) && isValidComplexConstraint(datatype)) {
				complexTypes.put(datatype.getName(), datatype);
			}
		}
		
		for (Entry<String,Object> entry : complexTypes.entrySet()) {
			ComplexType complexType = new ComplexType();
			complexType.setName(entry.getKey());
			Object part = entry.getValue();
			if (part instanceof MessagePart) {
				populateComplexType(complexType, (MessagePart) part);
			} else if (part instanceof ConstrainedDatatype) {
				populateComplexType(complexType, (ConstrainedDatatype) part);
			} else if (part instanceof InferredComplexContent) {
				populateComplexType(complexType, (InferredComplexContent) part);
			}
			schema.getComplexTypes().add(complexType);
		}
	}

	private boolean isValidComplexConstraint(ConstrainedDatatype datatype) {
		boolean valid = false;
		
		for (Relationship relationship : datatype.getRelationships()) {
			valid |= relationship.hasFixedValue();
		}
		
		return valid;
	}

	private Set<String> gatherSchemaDependencies(PackageLocation packageLocation, String packageName) {
		TreeSet<String> result = new TreeSet<String>();
		
		for (MessagePart messagePart : packageLocation.getMessageParts().values()) {
			for (Relationship relationship : messagePart.getRelationships()) {
				if (relationship.isAssociation() && !StringUtils.startsWith(relationship.getType(), packageName)) {
					result.add(StringUtils.substringBefore(relationship.getType(), "."));
				}
			}
		}
		
		return result;
	}

	private void populateComplexType(ComplexType complexType, MessagePart part) {
		for (Relationship relationship : insertNullFlavor(part)) {
			if (relationship.isAttribute()) {
				if (relationship.isStructural()) {
					XsAttribute attribute = formatAttribute(relationship);
					complexType.getAttributes().add(attribute);
				} else {
					XsElement element = formatElement(relationship, part);
					addElement(element, complexType);
				}
			} else {
				if (relationship.isChoice()) {
					Choice choice = new Choice();
					if (relationship.getCardinality().isMultiple()) {
						if (relationship.getCardinality().getMin() != 1) {
							choice.setMinOccurs(String.valueOf(relationship.getCardinality().getMin()));
						}
						
						if (relationship.getCardinality().getMax().equals(Integer.MAX_VALUE)) {
							choice.setMaxOccurs("unbounded");
						}
					}
					for (Relationship choiceElement : relationship.getChoices()) {
						choice.getElements().add(formatElementAsChoiceOption(choiceElement, relationship));
					}
					addElement(choice, complexType);
				} else {
					XsElement element = formatElement(relationship, part);
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

	private XsElement formatElement(Relationship relationship, MessagePart part) {
		XsElement element = new XsElement();
		element.setName(relationship.getName());
		
		String constrainedTypeName = relationship.getConstrainedType();
		if (isRenderableConstrainedType(constrainedTypeName) && relationship.getCardinality().isSingle()) {
			element.setType(constrainedTypeName);
		} else if (isCandidate(relationship)) {
			element.setType(formatName(relationship, part));
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

	private boolean isRenderableConstrainedType(String constrainedTypeName) {
		return constrainedTypeName != null && 
				(complexTypes.containsKey(constrainedTypeName) || 
						StringUtils.equals(constrainedTypeName, "StrucDoc.Text") ||	// special case, defined elsewhere
						StringUtils.startsWith(constrainedTypeName, "POCD_MT000040."));	// inherited from base model
	}

	private XsElement formatElementAsChoiceOption(Relationship relationship, Relationship parent) {
		Cardinality choiceBlockCardinality = parent.getCardinality();
		XsElement element = new XsElement();
		if (choiceBlockCardinality.isMultiple()) {
			element.setName(parent.getName());
		} else {
			element.setName(relationship.getName());

			if (choiceBlockCardinality.getMin() != 1) {
				element.setMinOccurs(String.valueOf(choiceBlockCardinality.getMin()));
			}
		}
		
		element.setType(relationship.getType());
		
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
		} else if (StringUtils.isNotBlank(relationship.getConstrainedType()) && relationship.getCardinality().isSingle()) {
			attribute.setType(relationship.getConstrainedType());
		} else if (StringUtils.isBlank(relationship.getType())) {
			if (StringUtils.equals(relationship.getName(), "root")) {
				attribute.setType("uid");
			} else if (StringUtils.equals(relationship.getName(), "extension")) {
				attribute.setType("st");
			} else if (StringUtils.equals(relationship.getName(), "code")) {
				attribute.setType("cs");
			} else if (StringUtils.equals(relationship.getName(), "codeSystem")) {
				attribute.setType("uid");
			} else if (StringUtils.equals(relationship.getName(), "low")) {
				attribute.setType("ts");
			} else if (StringUtils.equals(relationship.getName(), "high")) {
				attribute.setType("ts");
			} else if (StringUtils.equals(relationship.getName(), "operator")) {
				attribute.setType("SetOperator");
			} else if (StringUtils.equals(relationship.getName(), "mediaType")) {
				attribute.setType("cs");
			} else {
				attribute.setType("nil");
			}
		} else {
			attribute.setType(relationship.getType().toLowerCase());
		}
		
		if (relationship.getCardinality().isMandatory() && relationship.getDefaultValue() == null) {
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
		
		StandardDataType standardType = StandardDataType.getByTypeName(part.getBaseType());
		if (standardType != null) {
			child.setBase(standardType.getName());
		} else {
			child.setBase(part.getBaseType());
		}
		
		for (Relationship attribute : part.getRelationships()) {
			if (attribute.hasFixedValue()) {
				child.getAttributes().add(formatAttribute(attribute));
			}
		}
		
		complexType.getComplexContent().setChild(child);
	}

	private void populateComplexType(ComplexType complexType, InferredComplexContent part) {
		complexType.setComplexContent(new ComplexContent());
		ComplexContentChild child = new Restriction();
		
		child.setBase(part.getBaseType());
		
		for (InferredAttribute attribute : part.getAttributes()) {
			child.getAttributes().add(formatAttribute(attribute));
		}
		
		complexType.getComplexContent().setChild(child);
	}

	private XsAttribute formatAttribute(InferredAttribute attribute) {
		XsAttribute result = new XsAttribute();
		result.setName(attribute.getName());
		result.setType(attribute.getType());
		result.setUse(attribute.getUse());
		result.setFixed(attribute.getFixed());
		
		return result;
	}
	
	public boolean isCandidate(Relationship relationship) {
		return !relationship.isStructural() && relationship.isCodedType() && relationship.hasFixedValue();
	}

	public InferredComplexContent create(Relationship relationship, MessagePart messagePart) {
		InferredComplexContent content = new InferredComplexContent();
		content.name = formatName(relationship, messagePart);
		content.baseType = relationship.getType();
		if (relationship.isCodedType()) {
			content.attributes.add(new InferredAttribute("code", "cs", "required", relationship.getFixedValue()));
			if (!StringUtils.equals(relationship.getType(), "CS") && 
					DomainSource.CODE_SYSTEM.equals(relationship.getDomainSource()) && 
					StringUtils.isNotBlank(relationship.getDomainType())) {
				content.attributes.add(new InferredAttribute("codeSystem", "uid", "required", this.codeSystemMap.get(relationship.getDomainType())));
			}
		}
		return content;
	}

	private String formatName(Relationship relationship,	MessagePart messagePart) {
		return messagePart.getName() + "." + relationship.getName();
	}
	

}
