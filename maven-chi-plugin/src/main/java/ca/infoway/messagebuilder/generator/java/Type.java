package ca.infoway.messagebuilder.generator.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import ca.infoway.messagebuilder.generator.lang.TypeDocumentation;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.TypeName;

public class Type implements RenderedType, NamedType, HierarchicalType {

	private final TypeName name;
    private TypeDocumentation typeDocumentation;
    private List<BaseRelationship> relationships = Collections.synchronizedList(new ArrayList<BaseRelationship>());
    private Set<TypeName> interfaceTypes = Collections.synchronizedSet(new HashSet<TypeName>());
    private Set<TypeName> childTypes = Collections.synchronizedSet(new HashSet<TypeName>());
	private boolean isAbstract = false;
	private String businessName;
	private boolean rootType;
	private String category;
	
    private Set<TypeName> mergedTypes = Collections.synchronizedSet(new HashSet<TypeName>());
	
    public Type(TypeName typeName, boolean rootType) {
    	this.name = typeName;
		this.rootType = rootType;
		this.typeDocumentation = new TypeDocumentation(new Documentation());
	}
    public Type(TypeName typeName) {
    	this(typeName, false);
    }

	public TypeName getTypeName() {
        return this.name;
    }
	
    public TypeDocumentation getTypeDocumentation() {
        return this.typeDocumentation;
    }

    public void setRelationships(List<BaseRelationship> relationship) {
        this.relationships = relationship;
    }

    public List<BaseRelationship> getRelationships() {
        return this.relationships;
    }
    
    public void replace(BaseRelationship oldRelationship, BaseRelationship newRelationship) {
    	int index = this.relationships.indexOf(oldRelationship);
    	if (index >= 0) {
    		this.relationships.set(index, newRelationship);
    	}
    }
    
    public BaseRelationship getRelationship(String name) {
    	BaseRelationship result = null;
    	for (BaseRelationship relationship : this.relationships) {
			if (StringUtils.equals(relationship.getName(), name)) {
				result = relationship;
				break;
			}
		}
    	return result;
    }

    public BaseRelationship getRelationshipByBusinessName(String businessName) {
    	BaseRelationship result = null;
    	for (BaseRelationship relationship : this.relationships) {
			if (StringUtils.isNotBlank(relationship.getBusinessName()) && 
					StringUtils.equals(relationship.getBusinessName(), businessName)) {
				result = relationship;
				break;
			}
		}
    	return result;
    }

    public void setTypeDocumentation(TypeDocumentation description) {
        this.typeDocumentation = description;
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
		for (BaseRelationship relationship : this.relationships) {
			if (relationship.getRelationshipType() == RelationshipType.ASSOCIATION) {
				Association association = (Association) relationship;
				Type associationType = association.getAssociationType();
				if (associationType != null && !visitedTypes.contains(associationType.getTypeName())) {
					visitedTypes.add(associationType.getTypeName());
					if (associationType.isTemplateType(visitedTypes)) {
						result = true;
						break;
					}
				} else if (associationType == null && association.isTemplateType()) {
					result = true;
					break;
				}
			}
		}
		return result;
	}
	@Override
	public String toString() {
		return getTypeName() == null ? "unknown type" : getTypeName().toString();
	}
	
	public boolean isAbstract() {
		return this.isAbstract;
	}

	public void setAbstract(boolean isAbstract) {
		this.isAbstract = isAbstract;
	}

	public boolean isInterface() {
		return this.isAbstract &&  this.relationships.isEmpty();
	}

	public Set<TypeName> getInterfaceTypes() {
		return this.interfaceTypes;
	}
	
	public Set<TypeName> getChildTypes() {
		return this.childTypes;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getBusinessName() {
		return this.businessName;
	}
	public boolean isRootType() {
		return this.rootType;
	}
	public String getCategory() {
		return this.category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	// FIXME TM/AG - equals still needs to check relationships (which needs its own equals())
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (getClass() != obj.getClass()) {
			return false;
		} else {
			Type that = (Type) obj;
			return new EqualsBuilder()
					.append(this.name, that.name)
					.append(this.isAbstract, that.isAbstract)
					.append(this.rootType, that.rootType)
					.append(this.typeDocumentation, that.typeDocumentation)
					.append(this.businessName, that.businessName)
					.append(this.category, that.category)
					.append(this.interfaceTypes, that.interfaceTypes)
					.append(this.childTypes, that.childTypes)
					.isEquals();
		}
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.name)
				.append(this.isAbstract)
				.append(this.rootType)
				.append(this.typeDocumentation)
				.append(this.businessName)
				.append(this.category)
				.append(this.interfaceTypes)
				.append(this.childTypes)
				.toHashCode();
	}

	public List<String> getTemplateVariables() {
		List<String> result = new ArrayList<String>();
		for (BaseRelationship relationship : this.relationships) {
			if (relationship.getRelationshipType() != RelationshipType.ASSOCIATION) {
				// skip it
			} else if (relationship.isTemplateType()) {
				result.add(((Association) relationship).getTemplateVariable().getType());
			} else if (((Association) relationship).getAssociationType().isTemplateType()) {
				List<String> subTypes = ((Association) relationship).getAssociationType().getTemplateVariables();
				for (String string : subTypes) {
					if (result.contains(string)) {
						result.add(string + "_1");
					} else {
						result.add(string);
					}
				}
			}
		}
		Collections.sort(result);
		return result;
	}
	public Set<TypeName> getMergedTypes() {
		return this.mergedTypes;
	}
	public void setMergedTypes(Set<TypeName> mergedTypes) {
		this.mergedTypes = mergedTypes;
	}
	
	public String[] getPartTypeMapping() {
		if (this.mergedTypes.isEmpty()) {
			return new String[] { this.name.toString() };
		} else {
			List<String> result = new ArrayList<String>();
			for (TypeName name : this.mergedTypes) {
				result.add(name.toString());
			}
			Collections.sort(result);
			return result.toArray(new String[result.size()]);
		}
	}
	public void setRootType(boolean rootType) {
		this.rootType = rootType;
	}
}
