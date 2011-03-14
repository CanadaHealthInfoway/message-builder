package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.java.DifferenceHelper.getDifferenceByType;
import static ca.infoway.messagebuilder.generator.java.DifferenceHelper.hasDifferenceOfType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.codehaus.plexus.util.StringUtils;

import ca.infoway.messagebuilder.Named;
import ca.infoway.messagebuilder.generator.GeneratorException;
import ca.infoway.messagebuilder.xml.DifferenceType;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;

public class SimplifiableType implements Named, NamedType {

	private List<SimplifiableRelationship> relationships = Collections.synchronizedList(new ArrayList<SimplifiableRelationship>());
	private boolean inlined;
	private Set<SimplifiableType> mergedWithTypes = Collections.synchronizedSet(new HashSet<SimplifiableType>());
	private final MessagePart messagePart;
	private final boolean rootType;
	private TypeName mergedTypeName;
    private Set<String> interfaceTypes = Collections.synchronizedSet(new HashSet<String>());
	private final String category;
	private boolean indicator;

	public SimplifiableType(MessagePart messagePart, boolean rootType, String category) {
		this.messagePart = messagePart;
		this.rootType = rootType;
		this.category = category;
	}
	
	SimplifiableType(MessagePart messagePart, boolean rootType) {
		this(messagePart, rootType, null);
	}
	
	public boolean isInlined() {
		return this.inlined;
	}

	public Set<SimplifiableType> getMergedWithTypes() {
		return this.mergedWithTypes;
	}

	public Map<Fingerprint,Collection<SimplifiableRelationship>> getMatchedRelationships() {
		Map<Fingerprint,Collection<SimplifiableRelationship>> result = new HashMap<Fingerprint, Collection<SimplifiableRelationship>>();
		
		for (SimplifiableRelationship relationship : getRelationships()) {
			Fingerprint fingerprint = relationship.getFingerprint();
			if (!result.containsKey(fingerprint)) {
				result.put(fingerprint, new ArrayList<SimplifiableRelationship>());
			}
			result.get(fingerprint).add(relationship);
		}
		return result;
	}
	public List<SimplifiableRelationship> getRelationships() {
		return this.relationships;
	}
	public SimplifiableRelationship getRelationship(String name) {
		SimplifiableRelationship result = null;
		for (SimplifiableRelationship relationship : this.relationships) {
			if (StringUtils.equals(name, relationship.getRelationship().getName())) {
				result = relationship;
				break;
			}
		}
		return result;
	}

	public MessagePart getMessagePart() {
		return this.messagePart;
	}

	public boolean isRootType() {
		return this.rootType;
	}

	public boolean isMerged() {
		if (isInlined()) {
			return false;
		} else if (this.mergedWithTypes.isEmpty()) {
			return false;
		} else {
//			int count = isInlined() ? 0 : 1;
			int count = 0;
			for (SimplifiableType type : this.mergedWithTypes) {
				count += type.isInlined() ? 0 : 1;
			}
			return count > 1;
		}
	}
	
	public void setInlined(boolean inlined) {
		this.inlined = inlined;
	}
	@Override
	public String toString() {
		return this.messagePart.getName();
	}

	public String getName() {
		return this.messagePart.getName();
	}

	public void setMergedTypeName(TypeName mergedTypeName) {
		this.mergedTypeName = mergedTypeName;
	}

	public TypeName getMergedTypeName() {
		return this.mergedTypeName;
	}

	public Set<String> getInterfaceTypes() {
		return this.interfaceTypes;
	}

	public String getCategory() {
		return this.category;
	}

	public boolean isAbstract() {
		return this.messagePart.isAbstract();
	}
	
	public String getBusinessName() {
		return this.messagePart.getDocumentation() != null ? this.messagePart.getDocumentation().getBusinessName() : null;
	}

	public TypeName getTypeName() {
		return new TypeName(getName());
	}

	public Set<TypeName> getChildTypes() {
		Set<TypeName> result = new HashSet<TypeName>();
		for (String typeName : this.messagePart.getSpecializationChilds()) {
			result.add(new TypeName(typeName));
		}
		return result;
	}

	public boolean isIndicator() {
		return this.indicator;
	}
	
	public void setIndicator(boolean indicator) {
		this.indicator = indicator;
	}

	public boolean isTemplateType() {
		return isTemplateType(new HashSet<TypeName>());
	}
	// BCH: Ideally, we'd want to interrogate each relationship and find out if it is
	//      either a template type or contains something with a template type.  
	//      Unfortunately, that can get us into infinite loops because you can have
	//      cycles.  So, we'll keep track of which types we've already visited.
	boolean isTemplateType(Set<TypeName> visitedTypes) {
		boolean result = false;
		for (SimplifiableRelationship relationship : this.relationships) {
			if (relationship.isAssociation()) {
				SimplifiableType associationType = relationship.getType();
				if (associationType != null && !visitedTypes.contains(associationType.getTypeName())) {
					visitedTypes.add(associationType.getTypeName());
					if (associationType.isTemplateType(visitedTypes)) {
						result = true;
						break;
					}
				} else if (associationType == null && relationship.getRelationship().isTemplateRelationship()) {
					result = true;
					break;
				}
			}
		}
		return result;
	}
	
	// can't cache this information, because the fingerprints will change as new 
	// merges are discovered
	SimplifiableRelationship getRelationshipByFingerprint(Fingerprint fingerprint) {
		SimplifiableRelationship result = null;
		for (SimplifiableRelationship relationship : this.relationships) {
			if (fingerprint.equals(relationship.getFingerprint())) {
				if (result != null) {
					result = chooseMoreUpToDate(result, relationship);
				} else {
					result = relationship;
				}
			}
		}
		return result;
	}

	private SimplifiableRelationship chooseMoreUpToDate(SimplifiableRelationship relationship1,
			SimplifiableRelationship relationship2) {
		
		if (hasDifferenceOfType(relationship1.getRelationship(), DifferenceType.COMPONENT_ONLY_IN_ONE_VERSION)
				&& hasDifferenceOfType(relationship2.getRelationship(), DifferenceType.COMPONENT_ONLY_IN_ONE_VERSION)) {
			Relationship primaryRelationship = DifferenceHelper.choosePrimary(relationship1.getRelationship(), relationship2.getRelationship());
			return relationship1.getRelationship() == primaryRelationship ? relationship1 : relationship2;
		} else if (getDifferenceByType(relationship1.getRelationship(), DifferenceType.ASSOCIATION_TYPE) != null) {
			getDifferenceByType(relationship1.getRelationship(), DifferenceType.ASSOCIATION_TYPE).setOk(false);
			return relationship1;
		} else if (getDifferenceByType(relationship2.getRelationship(), DifferenceType.ASSOCIATION_TYPE) != null) {
			getDifferenceByType(relationship2.getRelationship(), DifferenceType.ASSOCIATION_TYPE).setOk(false);
			return relationship2;
		} else {
			throw new GeneratorException(
					"Duplicate fingerprint found in type, \"" + this.getName() 
					+ ". relationship1 = " + describe(relationship1) 
					+ ", relationship2 = " +describe(relationship2));
		}
	}

	private String describe(SimplifiableRelationship relationship) {
		return relationship.getName() + " (" + 
				(relationship.isTemplateParameterPresent() 
					? relationship.getVariable().getType() 
					: relationship.getType().getName()) 
				+ ")";
	}
}
