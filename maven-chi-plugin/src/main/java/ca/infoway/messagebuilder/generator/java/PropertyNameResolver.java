package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.java.BusinessNameUtil.cleanUpBusinessName;
import static ca.infoway.messagebuilder.generator.java.BusinessNameUtil.toCamelCase;
import static org.apache.commons.lang.StringUtils.isNotEmpty;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.generator.DataType;
import ca.infoway.messagebuilder.generator.GeneratorException;
import ca.infoway.messagebuilder.xml.Cardinality;

public class PropertyNameResolver implements BaseRelationshipNameResolver {

	private Map<BaseRelationship, String> map = new LinkedHashMap<BaseRelationship, String>();
	private final String finalTypeName;

	public PropertyNameResolver(String finalTypeName, List<BaseRelationship> relationships) throws GeneratorException {
		
		this.finalTypeName = finalTypeName;
		// first put in relationship names
		for (BaseRelationship baseRelationship : relationships) {
			if (baseRelationship instanceof RegeneratedRelationship) {
				registerNameForRegeneratedRelationship(baseRelationship);
			} else {
				registerName(baseRelationship);
			}
		}
		
		// then change to business names if possible
		for (BaseRelationship baseRelationship : relationships) {
			if (baseRelationship instanceof RegeneratedRelationship) {
				registerBusinessNameForRegeneratedRelationship(baseRelationship);
			} else {
				registerBusinessNameIfPossible(baseRelationship);
			}
		}
	}

	private void registerBusinessNameForRegeneratedRelationship(BaseRelationship baseRelationship) throws GeneratorException {
		RegeneratedRelationship mergedRelationship = (RegeneratedRelationship) baseRelationship;
		if (hasCardinalityChanged(mergedRelationship)) {
			registerBusinessNameForRegeneratedRelationship(pickMultiple(mergedRelationship), pickSingle(mergedRelationship));
		} else {
			registerBusinessNameIfPossible(mergedRelationship.getOriginalRelationship());
			registerBusinessNameIfPossible(mergedRelationship.getNewRelationship());
		}
	}

	private boolean hasCardinalityChanged(RegeneratedRelationship mergedRelationship) {
		BaseRelationship original = mergedRelationship.getOriginalRelationship();
		BaseRelationship newRelationship = mergedRelationship.getNewRelationship();

		return hasCardinalityChanged(original.getCardinality(), newRelationship.getCardinality())
		    || hasAttributeCardinalityChanged(original, newRelationship);
	}

	private boolean hasAttributeCardinalityChanged(BaseRelationship original, BaseRelationship newRelationship) {
		boolean changed = false;
		if (original instanceof Attribute && newRelationship instanceof Attribute) {
			DataType orginalDataType = ((Attribute) original).getDataType();
			DataType newDataType = ((Attribute) newRelationship).getDataType();
			changed = orginalDataType.isTypeCollection() != newDataType.isTypeCollection();
		}
		return changed;
	}

	private boolean hasCardinalityChanged(Cardinality original, Cardinality newCardinality) {
		return (original!=null && newCardinality!=null) 
	        && (original.isMultiple() != newCardinality.isMultiple());
	}
	
	private void registerNameForRegeneratedRelationship(BaseRelationship baseRelationship) throws GeneratorException {
		RegeneratedRelationship mergedRelationship = (RegeneratedRelationship) baseRelationship;
		if (hasCardinalityChanged(mergedRelationship)) {
			registerNameForRegeneratedRelationship(pickMultiple(mergedRelationship), pickSingle(mergedRelationship));
		} else {
			registerName(mergedRelationship.getOriginalRelationship());
		}
	}

	private void registerNameForRegeneratedRelationship(BaseRelationship multiple, BaseRelationship single) throws GeneratorException {
		registerName(multiple, pluralize(multiple.getName()));
		registerName(single, singularize(single.getName()));
	}

	private void registerBusinessNameForRegeneratedRelationship(BaseRelationship multiple, BaseRelationship single) throws GeneratorException {
		if (StringUtils.equals(multiple.getBusinessName(), single.getBusinessName())) {
			registerBusinessNameIfPossible(multiple, pluralize(multiple.getBusinessName()));
			registerBusinessNameIfPossible(single, singularize(single.getBusinessName()));
		} else {
			registerBusinessNameIfPossible(multiple, multiple.getBusinessName());
			registerBusinessNameIfPossible(single, single.getBusinessName());
		}
	}

	private String singularize(String name) {
		return name!=null && name.endsWith("s") ? StringUtils.removeEnd(name, "s") : name;
	}

	private String pluralize(String name) {
		return name!=null && !name.endsWith("s") ? name + "s" : name;	
	}

	private BaseRelationship pickMultiple(RegeneratedRelationship mergedRelationship) {
		BaseRelationship originalRelationship = mergedRelationship.getOriginalRelationship();
		return originalRelationship.getCardinality().isMultiple() ? originalRelationship : mergedRelationship.getNewRelationship();
	}

	private BaseRelationship pickSingle(RegeneratedRelationship mergedRelationship) {
		BaseRelationship originalRelationship = mergedRelationship.getOriginalRelationship();
		return originalRelationship.getCardinality().isSingle() ? originalRelationship : mergedRelationship.getNewRelationship();
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
			throw new GeneratorException("relationship name collision. '" + 
					camelCaseRelationshipName + "' already exists in map.");
		}
		this.map.put(baseRelationship, camelCaseRelationshipName);
	}
	

	public String getName(BaseRelationship relationship) {
		return this.map.get(relationship);
	}

}
