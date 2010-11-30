package ca.infoway.messagebuilder.generator.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import ca.infoway.messagebuilder.xml.Difference;
import ca.infoway.messagebuilder.xml.DifferenceType;
import ca.infoway.messagebuilder.xml.DifferenceValue;
import ca.infoway.messagebuilder.xml.Relationship;

class XmlMappingHelper {
	
	private static final String WILDCARD = "*";
	private Map<String,Set<String>> versionToName = new HashMap<String,Set<String>>();
	private Set<NameAndType> nameAndTypes = new HashSet<NameAndType>();

	XmlMappingHelper(Relationship relationship) {
		processRelationship(relationship);
	}
	XmlMappingHelper(Relationship... relationships) {
		this(Arrays.asList(relationships));
	}
	XmlMappingHelper(List<Relationship> relationships) {
		for (Relationship relationship : relationships) {
			processRelationship(relationship);
		}
	}
	private void processRelationship(Relationship relationship) {
		for (Difference difference : relationship.getDifferences()) {
			if (difference.getType() == DifferenceType.RELATIONSHIP_RENAMED) {
				for (DifferenceValue value : difference.getDifferences()) {
					addVersion(value.getVersion(), value.getValue());
					if (relationship.isAssociation()) {
						this.nameAndTypes.add(new NameAndType(value.getValue(), relationship.getType()));
					}
				}
			}
		}
		addVersion(WILDCARD,relationship.getName());
		if (relationship.isAssociation()) {
			this.nameAndTypes.add(new NameAndType(relationship.getName(), relationship.getType()));
		}
	}
	private void addVersion(String version, String value) {
		if (!this.versionToName.containsKey(version)) {
			this.versionToName.put(version, new HashSet<String>());
		}
		this.versionToName.get(version).add(value);
		
	}
	private XmlMappingHelper(Map<String,Set<String>> map, Set<NameAndType> nameAndTypes) {
		this.versionToName = map;
		this.nameAndTypes = nameAndTypes;
	}

	String[] getAllXmlMappings() {
		Set<String> result = new TreeSet<String>();
		for (Set<String> names : this.versionToName.values()) {
			result.addAll(names);
		}
		return result.toArray(new String[result.size()]);
	}
	
	XmlMappingHelper concat(XmlMappingHelper helper) {
		Map<String,Set<String>> temp = new HashMap<String,Set<String>>();
		Set<NameAndType> set = new HashSet<NameAndType>(this.nameAndTypes);
		Set<String> keys = new HashSet<String>(this.versionToName.keySet());
		keys.addAll(helper.versionToName.keySet());
		
		for (String version : keys) {
			Set<String> firstNamePart = getNameForVersion(version);
			Set<String> secondNamePart = helper.getNameForVersion(version);
			temp.put(version, concat(firstNamePart, secondNamePart));
			
			for (NameAndType nameAndType : helper.nameAndTypes) {
				if (secondNamePart.contains(nameAndType.getName()) || containsPrefix(secondNamePart, nameAndType)) {
					for (String first : firstNamePart) {
						set.add(new NameAndType(first + "/" + nameAndType.getName(), nameAndType.getType()));
					}
				}
			}
		}
		return new XmlMappingHelper(temp, set);
	}
	private boolean containsPrefix(Set<String> parts, NameAndType nameAndType) {
		boolean result = false;
		for (String part : parts) {
			if (part.startsWith(nameAndType.getName() + "/")) {
				result = true;
				break;
			}
		}
		return result;
	}
	private Set<String> concat(Set<String> firstNamePart, Set<String> secondNamePart) {
		Set<String> result = new HashSet<String>();
		
		for (String first : firstNamePart) {
			for (String second : secondNamePart) {
				result.add(first + "/" + second);
			}
		}
		return result;
	}
	private Set<String> getNameForVersion(String version) {
		if (this.versionToName.containsKey(version)) {
			return this.versionToName.get(version);
		} else {
			return this.versionToName.get(WILDCARD);
		}
	}
	Set<NameAndType> getMapByPartTypeMappings() {
		return this.nameAndTypes.size() == 1 
					? Collections.<NameAndType>emptySet()
					: this.nameAndTypes;
	}
}
