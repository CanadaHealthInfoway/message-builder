package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.java.BusinessNameUtil.cleanUpBusinessName;
import static ca.infoway.messagebuilder.generator.java.BusinessNameUtil.toCamelCase;
import static org.apache.commons.lang.StringUtils.isNotEmpty;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.generator.GeneratorException;

public class PropertyNameResolver implements BaseRelationshipNameResolver {

	private Map<BaseRelationship, String> map = new LinkedHashMap<BaseRelationship, String>();
	private final String finalTypeName;

	public PropertyNameResolver(String finalTypeName, List<BaseRelationship> relationships) throws GeneratorException {
		this.finalTypeName = finalTypeName;
		for (BaseRelationship baseRelationship : relationships) {
			registerName(baseRelationship);
		}
		
		for (BaseRelationship baseRelationship : relationships) {
			registerBusinessNameIfPossible(baseRelationship);
		}
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
		String camelCaseRelationshipName = toCamelCase(name);
		if (!isValidCsharpName(camelCaseRelationshipName)) {
			camelCaseRelationshipName += "Value";
		}
		if (this.map.containsValue(camelCaseRelationshipName)) {
			throw new GeneratorException("relationship name collision on type " +
					this.finalTypeName + ". '" + 
					camelCaseRelationshipName + "' already exists in map.");
		}
		this.map.put(baseRelationship, camelCaseRelationshipName);
	}
	

	public String getName(BaseRelationship relationship) {
		return this.map.get(relationship);
	}

}
