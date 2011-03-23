package ca.infoway.messagebuilder.generator.regen;

import static ca.infoway.messagebuilder.generator.regen.BaseRelationshipMatchers.matchingDocumentation;
import static ca.infoway.messagebuilder.generator.regen.BaseRelationshipMatchers.matchingName;
import static org.junit.Assert.assertThat;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.generator.java.Attribute;
import ca.infoway.messagebuilder.generator.java.AttributeBuilder;
import ca.infoway.messagebuilder.generator.java.BaseRelationship;
import ca.infoway.messagebuilder.generator.java.BaseRelationshipNameResolver;
import ca.infoway.messagebuilder.generator.java.ClassNameManager;
import ca.infoway.messagebuilder.generator.java.PropertyGenerator;
import ca.infoway.messagebuilder.generator.java.PropertyGeneratorBuilder;
import ca.infoway.messagebuilder.generator.java.RegeneratedRelationship;
import ca.infoway.messagebuilder.generator.java.RelationshipType;
import ca.infoway.messagebuilder.generator.java.TypeBuilder;
import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;

public class DocumentationDeltaTest {

	private Attribute oldRelationship;

	@Before
	public void setUp() {
		this.oldRelationship = new AttributeBuilder().setName("name").setDocumentation("oldDoc").build();
	}
	
	@Test
	public void shouldSetDocumentationToNewDocumentation() throws Exception {
		DocumentationDelta delta = new DocumentationDelta(
				this.oldRelationship,
				new AttributeBuilder().setName("name").setDocumentation("newDoc").build());
		
		delta.apply(new RelationshipsMergerContext(new TypeBuilder().addRelationship(oldRelationship).build()));
		
		assertThat("newest documentation", this.oldRelationship, matchingNameAndDocumentation("name", "newDoc"));
	}

	@Test
	public void shouldKeepOldDocumentationIfNewOneIsNull() throws Exception {
		DocumentationDelta delta = new DocumentationDelta(
				this.oldRelationship,
				new AttributeBuilder().setName("name").build());
		
		delta.apply(new RelationshipsMergerContext(new TypeBuilder().addRelationship(oldRelationship).build()));
		
		assertThat("old documentation", this.oldRelationship, matchingNameAndDocumentation("name", "oldDoc"));
	}

	@Test
	public void shouldDoNothingIfExistingRelationshipIsRegenerated() throws Exception {
		DocumentationDelta delta = new DocumentationDelta(
				this.oldRelationship,
				new AttributeBuilder().setName("name").build());
		
		
		assertThat("old documentation", this.oldRelationship, matchingNameAndDocumentation("name", "oldDoc"));
	}
	
	@SuppressWarnings("unchecked")
	private Matcher<BaseRelationship> matchingNameAndDocumentation(String name, String documentation) {
		return Matchers.allOf(matchingName(name), matchingDocumentation(documentation));
	}
	
	private static class DummyRegeneratedRelationship extends BaseRelationship implements RegeneratedRelationship {
		private String name;
		DummyRegeneratedRelationship(String name) {
			super(null, null, null);
			this.name = name;
		}
		@Override
		public String getName() {
			return this.name;
		}
		@Override
		public RelationshipType getRelationshipType() {
			return null;
		}
		public BaseRelationship getNewRelationship() {
			return null;
		}
		public BaseRelationship getOriginalRelationship() {
			return null;
		}
		public PropertyGenerator getPropertyGenerator(ProgrammingLanguage language, ClassNameManager representation, BaseRelationshipNameResolver nameResolver) {
			return null;
		}
		public PropertyGeneratorBuilder getBuilder() {
			return null;
		}
		public void setBuilder(PropertyGeneratorBuilder builder) {
		}
	}
	
}
