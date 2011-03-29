package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.java.BusinessNameUtil.cleanUpBusinessName;
import static ca.infoway.messagebuilder.generator.java.BusinessNameUtil.toCamelCase;
import static org.apache.commons.lang.StringUtils.isNotEmpty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.generator.GeneratorException;
import ca.infoway.messagebuilder.generator.NamingPolicy;

public class PropertyNameResolver implements BaseRelationshipNameResolver {

	private Map<BaseRelationship, String> map = new LinkedHashMap<BaseRelationship, String>();
	private final String finalTypeName;

	public PropertyNameResolver(String finalTypeName, List<BaseRelationship> relationships, NamingPolicy namingPolicy) throws GeneratorException {
		this.finalTypeName = finalTypeName;
		for (BaseRelationship baseRelationship : relationships) {
			registerName(baseRelationship);
		}
		
		if (namingPolicy == NamingPolicy.BUSINESS_NAMES) {
			for (BaseRelationship baseRelationship : relationships) {
				registerBusinessNameIfPossible(baseRelationship);
			}
		}
		if (isDuplicateValue()) {
			removeDuplicates();
		}
	}

	private boolean isDuplicateValue() {
		return new HashSet<String>(this.map.values()).size() != this.map.size();
	}

	private void removeDuplicates() {
		Map<String,List<BaseRelationship>> nameToRelationship = new HashMap<String,List<BaseRelationship>>();
		for (Map.Entry<BaseRelationship,String> entry : this.map.entrySet()) {
			if (!nameToRelationship.containsKey(entry.getValue())) {
				nameToRelationship.put(entry.getValue(), new ArrayList<BaseRelationship>());
			}
			nameToRelationship.get(entry.getValue()).add(entry.getKey());
		}
		
		for (Map.Entry<String, List<BaseRelationship>> entry : nameToRelationship.entrySet()) {
			if (entry.getValue().size() > 1) {
				createSuffixes(entry.getKey(), entry.getValue());
			}
		}
	}

	private void createSuffixes(String name, List<BaseRelationship> relationships) {
		String suffixLeader = "";
		if (Character.isDigit(name.charAt(name.length()-1))){
			suffixLeader = "Association";
		}
		if (isCollision(name, suffixLeader, relationships.size())) {
			suffixLeader = findSuffixLeader(name, suffixLeader, relationships.size());
		}
		
		int number = 1;
		for (BaseRelationship baseRelationship : relationships) {
			this.map.put(baseRelationship, name + suffixLeader + number);
			number++;
		}
	}

	private String findSuffixLeader(String name, String suffixLeader, int size) {
		String result = null;
		String[] choices = new String[] { "Association", "_", "Association_", "AssociationType", "AssociationType_ " };
		
		for (String string : choices) {
			if (!isCollision(name, string, size)) {
				result = string;
				break;
			}
		}
		if (result == null) {
			throw new GeneratorException(
					"Cannot determine a unique name for multiple associations " +
					"with the name " + name);
		}
		return result;
	}

	private boolean isCollision(String name, String suffixLeader, int length) {
		boolean found = false;
		for (int i = 1; i <= length; i++) {
			found |= this.map.containsValue(name + suffixLeader + i);
		}
		return found;
	}

	private void registerBusinessNameIfPossible(BaseRelationship baseRelationship) {
		registerBusinessNameIfPossible(baseRelationship, baseRelationship.getBusinessName());
	}

	private void registerBusinessNameIfPossible(BaseRelationship baseRelationship, String businessName) {
		if (isNotEmpty(businessName)) { 
			String cleanBusinessName = cleanUpBusinessName(businessName);
			if (!this.map.containsValue(cleanBusinessName) && isValidCsharpName(cleanBusinessName)) {
				this.map.put(baseRelationship, cleanBusinessName);
			}
		}
	}

	/**
	 * <p>Ensure that the property name will be accepted by the C# compiler.
	 * 
	 * <p>C# doesn't allow properties to have the same name as the type.
	 * 
	 * @param propertyName - the candidate property name.
	 * @return - true if the name is a valid C# name; false otherwise
	 */
	private boolean isValidCsharpName(String propertyName) {
		return !StringUtils.equals(propertyName, this.finalTypeName);
	}

	private void registerName(BaseRelationship baseRelationship) throws GeneratorException {
		registerName(baseRelationship, baseRelationship.getName());
	}
	
	private void registerName(BaseRelationship baseRelationship, String name) throws GeneratorException {
		String camelCaseRelationshipName = toCamelCase(stripPunctuation(name));
		if (!isValidCsharpName(camelCaseRelationshipName)) {
			camelCaseRelationshipName += "Value";
		}
		this.map.put(baseRelationship, camelCaseRelationshipName);
	}
	

	private String stripPunctuation(String name) {
		StringBuilder builder = new StringBuilder();
		for (char c : name.toCharArray()) {
			if ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_".indexOf(c) < 0) {
				builder.append(" ");
			} else {
				builder.append(c);
			}
		}
		return builder.toString();
	}

	public String getName(BaseRelationship relationship) {
		return this.map.get(relationship);
	}
}
