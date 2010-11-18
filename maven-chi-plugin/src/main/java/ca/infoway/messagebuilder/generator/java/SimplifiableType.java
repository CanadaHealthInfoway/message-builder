package ca.infoway.messagebuilder.generator.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.codehaus.plexus.util.StringUtils;

import ca.infoway.messagebuilder.Named;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.TypeName;

class SimplifiableType implements Named, NamedType, HierarchicalType {

	private List<SimplifiableRelationship> relationships = Collections.synchronizedList(new ArrayList<SimplifiableRelationship>());
	private boolean inlined;
	private List<SimplifiableType> mergedWithTypes = Collections.synchronizedList(new ArrayList<SimplifiableType>());
	private final MessagePart messagePart;
	private final boolean rootType;
	private String mergedTypeName;
    private Set<String> interfaceTypes = Collections.synchronizedSet(new HashSet<String>());
	private final String category;

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

	public List<SimplifiableType> getMergedWithTypes() {
		return this.mergedWithTypes;
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
		return !this.mergedWithTypes.isEmpty();
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

	public void setMergedTypeName(String mergedTypeName) {
		this.mergedTypeName = mergedTypeName;
	}

	public String getMergedTypeName() {
		return this.mergedTypeName;
	}

	public Set<String> getInterfaceTypes() {
		return this.interfaceTypes;
	}

	public String getCategory() {
		return this.category;
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
}
