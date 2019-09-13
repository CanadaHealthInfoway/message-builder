/**
 * Copyright 2013 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.generator.lang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.NamedType;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.TypeName;

public class Type implements RenderedType, NamedType {

	private final TypeName name;
    private TypeDocumentation typeDocumentation;
    private List<BaseRelationship> relationships = Collections.synchronizedList(new ArrayList<BaseRelationship>());
    private Set<RenderedType> interfaceTypes = Collections.synchronizedSet(new HashSet<RenderedType>());
    private Set<Type> childTypes = Collections.synchronizedSet(new HashSet<Type>());
	private boolean isAbstract = false;
	private String businessName;
	private boolean rootType;
	private boolean cdaDocumentRoot;
	private String category;
	private TypeName mergedName;
	
	private LanguageSpecificName languageSpecificName;
	
    private Set<NamedType> mergedTypes = Collections.synchronizedSet(new HashSet<NamedType>());
	
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

	public Set<RenderedType> getInterfaceTypes() {
		return this.interfaceTypes;
	}
	
	public Set<Type> getChildTypes() {
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
	public boolean isCdaDocumentRoot() {
		return cdaDocumentRoot;
	}
	public void setCdaDocumentRoot(boolean cdaDocumentRoot) {
		this.cdaDocumentRoot = cdaDocumentRoot;
	}
	public String getCategory() {
		return this.category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (getClass() != obj.getClass()) {
			return false;
		} else {
			Type that = (Type) obj;
			return this.getTypeName().equals(that.getTypeName());
		}
	}
	
	@Override
	public int hashCode() {
		return this.getTypeName().hashCode();
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
	public Set<NamedType> getMergedTypes() {
		return this.mergedTypes;
	}
	
	public String[] getPartTypeMapping() {
		if (this.mergedTypes.isEmpty()) {
			return new String[] { this.name.toString() };
		} else {
			List<String> result = new ArrayList<String>();
			for (NamedType type : this.mergedTypes) {
				result.add(type.getTypeName().getName());
			}
			Collections.sort(result);
			return result.toArray(new String[result.size()]);
		}
	}
	public void setRootType(boolean rootType) {
		this.rootType = rootType;
	}
	public void setLanguageSpecificName(LanguageSpecificName languageSpecificName) {
		this.languageSpecificName = languageSpecificName;
	}
	public LanguageSpecificName getLanguageSpecificName() {
		return this.languageSpecificName;
	}
	/**
	 * <p>Return the temporary name that was assigned during the case 3 simplification 
	 * process.  
	 * 
	 * <p>The presence or absence of a value in this field does not indicate that the 
	 * final type will be merged.  If it is inlined, we might not care if it is merged.
	 * In reality, the type might have been inlined away.  But we want to remember its
	 * merged-ness when we try to process similar relationships.
	 * @return
	 */
	TypeName getMergedName() {
		return this.mergedName;
	}
	void setMergedName(TypeName mergedName) {
		this.mergedName = mergedName;
	}
}
