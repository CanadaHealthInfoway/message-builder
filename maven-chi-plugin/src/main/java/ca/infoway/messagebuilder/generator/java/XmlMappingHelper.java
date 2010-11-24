package ca.infoway.messagebuilder.generator.java;

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

	XmlMappingHelper(Relationship relationship) {
		for (Difference difference : relationship.getDifferences()) {
			if (difference.getType() == DifferenceType.RELATIONSHIP_RENAMED) {
				for (DifferenceValue value : difference.getDifferences()) {
					this.versionToName.put(value.getVersion(), value.getValue());
				}
			}
		}
		this.versionToName.put(WILDCARD,relationship.getName());
	}
	private XmlMappingHelper(Map<String,String> map) {
		this.versionToName = map;
	}

	String[] getAllXmlMappings() {
		Set<String> result = new TreeSet<String>(this.versionToName.values());
		return result.toArray(new String[result.size()]);
	}
	
	XmlMappingHelper concat(XmlMappingHelper helper) {
		Map<String,String> temp = new HashMap<String,String>();
		
		Set<String> keys = new HashSet<String>(this.versionToName.keySet());
		keys.addAll(helper.versionToName.keySet());
		
		for (String version : keys) {
			temp.put(version, getNameForVersion(version) + "/" + helper.getNameForVersion(version));
		}
		return new XmlMappingHelper(temp);
	}
	private String getNameForVersion(String version) {
		if (this.versionToName.containsKey(version)) {
			return this.versionToName.get(version);
		} else {
			return this.versionToName.get(WILDCARD);
		}
	}
}
