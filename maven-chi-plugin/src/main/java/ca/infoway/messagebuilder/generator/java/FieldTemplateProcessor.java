package ca.infoway.messagebuilder.generator.java;

import java.io.IOException;
import java.io.Writer;
import java.text.MessageFormat;

import ca.infoway.messagebuilder.generator.lang.CodeTemplate;
import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;
import ca.infoway.messagebuilder.generator.lang.StringArrayToAnnotationDecorator;

abstract class FieldTemplateProcessor {

	private final FieldDefinition fieldDefinition;

	public FieldTemplateProcessor(FieldDefinition fieldDefinition) {
		this.fieldDefinition = fieldDefinition;
	}

	protected void write(CodeTemplate template, int indent, Writer writer) throws IOException {
		template.write(writer, indent, 
				decorate(this.fieldDefinition.getXmlPathName()),
				this.fieldDefinition.getFieldType(),
				this.fieldDefinition.getCapitalizedPropertyName(),
				populate(this.fieldDefinition.getGetterBodyStyle()),
				this.fieldDefinition.getFieldName(),
				populate(this.fieldDefinition.getSetterBodyStyle()),
				this.fieldDefinition.getFieldImplementationType(),
				this.fieldDefinition.getInitializationArguments(),
				this.fieldDefinition.getPropertyType(),
				this.fieldDefinition.getPropertyElementImplementationType(),
				populate(this.fieldDefinition.getDerivedChoiceHasBodyStyle()),
				generateMapByPartTypeAnnotations(indent, this.fieldDefinition.getXmlPathName(),
						 this.fieldDefinition.getBaseRelationship(), 
						 this.fieldDefinition.getProgrammingLanguage())
				);
	}

	protected String populate(MethodBody body) {
		if (body == null) {
			return "";
		} else {
			return MessageFormat.format(body.getBodyFormat(this.fieldDefinition.getProgrammingLanguage()), 
					this.fieldDefinition.getFieldName(), 
					this.fieldDefinition.getFieldName(),
					this.fieldDefinition.getFieldElementImplementationType(),
					this.fieldDefinition.getPropertyElementImplementationType(),
					this.fieldDefinition.getCollectionOfCodedPropertyElementType(),
					this.fieldDefinition.getFieldElementType(),
					this.fieldDefinition.getPropertyType());
		}
	}

	private String decorate(String[] strings) {
		return new StringArrayToAnnotationDecorator(strings).render();
	}

	String generateMapByPartTypeAnnotations(int indent, String[] xmlPathName, BaseRelationship baseRelationship, ProgrammingLanguage programmingLanguage) {
		return new MapByPartTypeAnnotationDecorator(indent, baseRelationship, programmingLanguage).render();
	}

	protected FieldDefinition getFieldDefinition() {
		return this.fieldDefinition;
	}
}
