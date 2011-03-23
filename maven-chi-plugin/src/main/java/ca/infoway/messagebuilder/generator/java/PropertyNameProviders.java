package ca.infoway.messagebuilder.generator.java;

import org.apache.commons.lang.WordUtils;

import ca.infoway.messagebuilder.generator.java.PropertyGeneratorBuilder.PropertyNameProvider;

public class PropertyNameProviders {

	public static class Relationship implements PropertyNameProvider {
		private final BaseRelationship relationship;
		public Relationship(BaseRelationship relationship) {
			this.relationship = relationship;
		}
		public String getName(BaseRelationshipNameResolver resolver) {
			return WordUtils.uncapitalize(resolver.getName(relationship));
		}
	}

	public static class Identity implements PropertyNameProvider {
		private final String name;
		public Identity(String name) {
			this.name = name;
		}
		public String getName(BaseRelationshipNameResolver resolver) {
			return name;
		}
	}
	
}
