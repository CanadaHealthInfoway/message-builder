package ca.infoway.messagebuilder.generator.java;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import ca.infoway.messagebuilder.xml.Difference;
import ca.infoway.messagebuilder.xml.DifferenceType;
import ca.infoway.messagebuilder.xml.DifferenceValue;
import ca.infoway.messagebuilder.xml.Relationship;

class XmlMappingHelper {
	
	private static final String WILDCARD = "*";
	private Map<String,String> versionToName = new HashMap<String,String>();
	private Set<NameAndType> nameAndTypes = new HashSet<NameAndType>();

	XmlMappingHelper(Relationship relationship) {
		for (Difference difference : relationship.getDifferences()) {
			if (difference.getType() == DifferenceType.RELATIONSHIP_RENAMED) {
				for (DifferenceValue value : difference.getDifferences()) {
					this.versionToName.put(value.getVersion(), value.getValue());
					if (relationship.isAssociation()) {
						this.nameAndTypes.add(new NameAndType(value.getValue(), relationship.getType()));
					}
				}
			}
		}
		this.versionToName.put(WILDCARD,relationship.getName());
		if (relationship.isAssociation()) {
			this.nameAndTypes.add(new NameAndType(relationship.getName(), relationship.getType()));
		}
	}
	private XmlMappingHelper(Map<String,String> map, Set<NameAndType> nameAndTypes) {
		this.versionToName = map;
		this.nameAndTypes = nameAndTypes;
	}

	String[] getAllXmlMappings() {
		Set<String> result = new TreeSet<String>(this.versionToName.values());
		return result.toArray(new String[result.size()]);
	}
	
	XmlMappingHelper concat(XmlMappingHelper helper) {
		Map<String,String> temp = new HashMap<String,String>();
		Set<NameAndType> set = new HashSet<NameAndType>(this.nameAndTypes);
		Set<String> keys = new HashSet<String>(this.versionToName.keySet());
		keys.addAll(helper.versionToName.keySet());
		
		for (String version : keys) {
			String firstNamePart = getNameForVersion(version);
			String secondNamePart = helper.getNameForVersion(version);
			temp.put(version, firstNamePart + "/" + secondNamePart);
			
			for (NameAndType nameAndType : helper.nameAndTypes) {
				if (secondNamePart.equals(nameAndType.getName()) || secondNamePart.startsWith(nameAndType.getName() + "/")) {
					set.add(new NameAndType(firstNamePart + "/" + nameAndType.getName(), nameAndType.getType()));
				}
			}
		}
		return new XmlMappingHelper(temp, set);
	}
	private String getNameForVersion(String version) {
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
