package ca.infoway.messagebuilder.generator.java;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.MessageFormat;

import ca.infoway.messagebuilder.generator.java.PropertyGeneratorBuilder.Setter;
import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;

public enum SetterBodyStyle implements MethodBody {
	DEFAULT() {
		@Override
		public void create(PropertyGeneratorBuilder builder, Setter setter, Writer writer, BaseRelationshipNameResolver resolver) throws IOException {
			writer.write(MessageFormat.format(getBodyFormat(builder.language), 
					builder.nameProvider.getName(resolver), setter.nameProvider.getName(resolver) ));
		}

		public String getBodyFormat(ProgrammingLanguage language) {
			return language.isJava() ? "this.{0} = {1};" : "this.{0} = value;";
		}
	},
	ATTRIBUTE() {
		@Override
		public void create(PropertyGeneratorBuilder builder, Setter setter, Writer writer, BaseRelationshipNameResolver resolver) throws IOException {
			writer.write(MessageFormat.format(getBodyFormat(builder.language), 
					builder.nameProvider.getName(resolver), setter.nameProvider.getName(resolver) ));
		}

		public String getBodyFormat(ProgrammingLanguage language) {
			return language.isJava() ? "this.{0}.setValue({1});" : "this.{0}.Value = value;";
		}
	},
	COLLECTION_ELEMENT() {
		@Override
		public void create(PropertyGeneratorBuilder builder, Setter setter, Writer writer, BaseRelationshipNameResolver resolver) throws IOException {
			writer.write(MessageFormat.format(
					getBodyFormat(builder.language), 
					PropertyGeneratorBuilder.capitalize(builder.nameProvider.getName(resolver)), setter.nameProvider.getName(resolver) ));
		}
		public String getBodyFormat(ProgrammingLanguage language) {
			return language.isJava() ? "get{0}().clear(); get{0}().add({1});" : "get{0}().clear(); get{0}().Add(value);";
		}
		@Override
		public boolean useTypeDecorator() {
			return false;
		}
	};
	public abstract String getBodyFormat(ProgrammingLanguage language);
	public abstract void create(PropertyGeneratorBuilder builder, Setter setter, Writer writer, BaseRelationshipNameResolver resolver) throws IOException;
	public String create(PropertyGeneratorBuilder builder, Setter setter, BaseRelationshipNameResolver resolver) throws IOException {
		StringWriter writer = new StringWriter();
		create(builder, setter, writer, resolver);
		return writer.toString();
	}
	public boolean useTypeDecorator() {
		return true;
	}
}