package ca.infoway.messagebuilder.generator.java;

import org.apache.commons.lang.WordUtils;

public class RelationshipNameUtils {

	public static String getRelationshipNameCapitalized(BaseRelationshipNameResolver nameResolver, BaseRelationship relationship) {
		return WordUtils.capitalize(nameResolver.getName(relationship));
	}

	public static String getRelationshipNameUncapitalized(BaseRelationshipNameResolver nameResolver, BaseRelationship relationship) {
		return WordUtils.uncapitalize(getRelationshipNameCapitalized(nameResolver, relationship));
	}

}
