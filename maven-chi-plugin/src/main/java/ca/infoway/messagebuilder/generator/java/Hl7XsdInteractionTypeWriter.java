package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.java.BusinessNameUtil.cleanUpBusinessName;
import static org.apache.commons.lang.WordUtils.uncapitalize;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.generator.GeneratorException;
import ca.infoway.messagebuilder.generator.java.InteractionType.ArgumentType;
import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.TypeName;


public class Hl7XsdInteractionTypeWriter extends Hl7XsdTypeWriter {

	private final InteractionType interactionType;
	
	public Hl7XsdInteractionTypeWriter(InteractionType interactionType, TypeAnalysisResult typeResults) {
		super(typeResults);
		this.interactionType = interactionType;
	}

	@Override
	protected void writeContents(Element schema) throws GeneratorException {
		addInteractionToSchema(schema);
	}

	@Override
	protected String getTypeName() {
		return this.interactionType.getName().getName();
	}

	private void addInteractionToSchema(Element schema) {
		Document document = schema.getOwnerDocument();
		Element typeElement = document.createElement("xs:element");
		typeElement.setAttribute("name", getNodeName());
		typeElement.setAttribute("type", "chi:" + getTypeName());
		String parentName = this.interactionType.getParentType().getName();
		List<ArgumentType> arguments = this.interactionType.getArguments();
		addTemplateTypes(schema, parentName, arguments, this.interactionType.getParentType(), true);
		schema.appendChild(typeElement);
	}

	private String getNodeName() {
		String businessName = this.interactionType.getBusinessName();
		if (StringUtils.isNotBlank(businessName)) {
			return uncapitalize(cleanUpBusinessName(businessName));
		} else {
			return this.interactionType.getName().getName();
		}
	}

	private void addTemplateTypes(Element schema, String parentName, List<ArgumentType> argumentTypes, TypeName typeName, boolean top) {
		if (!argumentTypes.isEmpty()) {
			Document document = schema.getOwnerDocument();
			Element complexType = document.createElement("xs:complexType");
			complexType.setAttribute("name", getTypeName() + (top ? "" : "." + parentName));
			Element complexContent = document.createElement("xs:complexContent");
			Element extension = document.createElement("xs:extension");
			extension.setAttribute("base", "chi:" + parentName);
			addInclude(schema, new TypeName(parentName).getParent().getName());
			Element sequence = document.createElement("xs:sequence");
			complexType.appendChild(complexContent);
			complexContent.appendChild(extension);
			extension.appendChild(sequence);
			addConcreteFormOfTemplateRelationships(schema, sequence, typeName, argumentTypes);
			schema.appendChild(complexType);
		}		
	}

	private void addConcreteFormOfTemplateRelationships(Element schema, Element sequence, TypeName typeName, List<ArgumentType> argumentTypes) {
		
		Type type = getType(typeName);
		
		for (BaseRelationship relationship : type.getRelationships()) {
			if (relationship.getRelationshipType() != RelationshipType.ASSOCIATION) {
				// skip it
			} else if (relationship.isTemplateType()) {
			// Simple Case
				ArgumentType argumentType = getCorrespondingArgumentType(relationship.getRelationship().getTemplateParameterName(), argumentTypes);
				addTemplateType(schema,	sequence, 
						argumentType.getArgument().getTemplateParameterName(),
						argumentType.getArgument().getName(),
						argumentType.getArgumentTypes().isEmpty());
				addTemplateTypes(schema, 
						argumentType.getArgument().getName(), 
						argumentType.getArgumentTypes(), 
						argumentType.getType(), 
						false);				
			} else if (((Association) relationship).getAssociationType().isTemplateType()) {
			// Complicated Case
				Association association = (Association) relationship;
				addTemplateType(schema,	sequence,
						association.getName(),
						association.getAssociationType().getName().getName(),
						argumentTypes.isEmpty());
				addTemplateTypes(schema, 
						association.getAssociationType().getName().getName(), 
						argumentTypes, 
						association.getAssociationType().getName(), 
						false);
			}
		}
	}

	private ArgumentType getCorrespondingArgumentType(String templateParameterName,	List<ArgumentType> argumentTypes) {
		ArgumentType result = null;
		for (ArgumentType argumentType : argumentTypes) {
			Argument argument = argumentType.getArgument();
			if (argument != null && StringUtils.equals(argument.getTemplateParameterName(), templateParameterName)) {
				result = argumentType;
				break;
			}
		}
		return result;
	}

	private void addTemplateType(Element schema, Element sequence, String name, String typeName, boolean include) {
		Document document = sequence.getOwnerDocument();
		Element element = document.createElement("xs:element");
		sequence.appendChild(element);
		element.setAttribute("name", WordUtils.uncapitalize(name));
		if (include) {
			element.setAttribute("type", "chi:" + typeName);
			addInclude(schema, new TypeName(typeName).getParent().getName());
		} else {
			element.setAttribute("type", "chi:" + getTypeName() + "." + typeName);
		}
	}
}
