/**
 * 
 */
package ca.infoway.messagebuilder.generator.java;

import java.util.ArrayList;
import java.util.List;

import ca.infoway.messagebuilder.xml.TypeName;

public class TypeBuilder {
	private String name;
	private List<BaseRelationship> relationships = new ArrayList<BaseRelationship>();
	public TypeBuilder() {
	}
	public TypeBuilder setName(String name) {
		this.name = name;
		return this;
	}
	public TypeBuilder addRelationship(BaseRelationship relationship) {
		this.relationships.add(relationship);
		return this;
	}
	public Type build() {
		Type type = new Type(new TypeName(this.name));
		type.getRelationships().addAll(this.relationships);
		return type;
	}
}