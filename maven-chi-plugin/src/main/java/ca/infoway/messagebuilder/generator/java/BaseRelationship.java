package ca.infoway.messagebuilder.generator.java;

import static org.apache.commons.lang.StringUtils.isNotBlank;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.Named;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.Difference;
import ca.infoway.messagebuilder.xml.DifferenceType;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.Relationship;

public abstract class BaseRelationship implements PropertyGeneratorProvider, Named {

    private final String type;
    private final String wrappedType;
	protected Relationship relationship;

    public BaseRelationship(Relationship relationship, String wrappedType, String type) {
		this.relationship = relationship;
		this.wrappedType = wrappedType;
		this.type = type;
    }

    public String getFixedValue() {
        return this.relationship.getFixedValue();
    }

    public String getName() {
        return this.relationship.getName();
    }

    String getXmlMapping() {
        return this.relationship.getName();
    }
    
    public String[] getAllXmlMappings() {
    	return new String[] { getXmlMapping() };
    }

    public boolean isMandatory() {
        return this.relationship.isMandatory();
    }

    public boolean isStructural() {
        return this.relationship.isStructural();
    }

    /**
     * It might include type variables for generics.
     * @return
     */
    public String getTypeParameters() {
        return StringUtils.EMPTY;  
    }
    public String getType() {
        return this.type;
    }

    // I don't think we should expose this
    @Deprecated
	public String getWrappedType() {
		return this.wrappedType;
	}
    
    public boolean isTemplateType() {
        return false;
    }

    public boolean isChoice() {
        return this.relationship.isChoice();
    }

    public boolean isFixed() {
        return isNotBlank(getFixedValue());
    }

    public int getSortKey() {
        return this.relationship.getSortOrder();
    }
    public abstract RelationshipType getRelationshipType();

    public Cardinality getCardinality() {
   		return this.relationship.getCardinality();
    }

    public boolean isCardinalityMultiple() {
        return getCardinality() != null && getCardinality().isMultiple();
    }

	public boolean hasDomainType() {
		return StringUtils.isNotBlank(getDomainType());
	}

	public String getDomainType() {
		return this.relationship.getDomainType();
	}

	public ConformanceLevel getConformanceLevel() {
		return this.relationship.getConformance();
	}

	public void setConformanceLevel(ConformanceLevel conformanceLevel) {
		this.relationship.setConformance(conformanceLevel);
	}
	
	public Set<Object> getImportTypes() {
		Set<Object> result = new HashSet<Object>();
		result.add("ca.infoway.messagebuilder.annotation.Hl7XmlMapping");
		if (requiresMapByPartTypeAnnotation()) {
			result.add("ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes");
			result.add("ca.infoway.messagebuilder.annotation.Hl7MapByPartType");
		}
		return result;
	}
	
	public Documentation getDocumentation() {
		return this.relationship.getDocumentation();
	}

	public void setDocumentation(Documentation documentation) {
		this.relationship.setDocumentation(documentation);
	}
	
	public Relationship getRelationship() {
		return this.relationship;
	}

	public List<Relationship> getAllRelationships() {
		return this.relationship == null 
				? Collections.<Relationship>emptyList() 
				: Arrays.asList(this.relationship);
	}
	
	public boolean isWriteable() {
		return !isCardinalityMultiple();
	}
	
	public String getBusinessName() {
		return getDocumentation()!=null ? getDocumentation().getBusinessName() : null; 
	}
	
	boolean requiresMapByPartTypeAnnotation() {
		boolean result = false;
		outer: for (Relationship relationship : getAllRelationships()) {
			for (Difference difference : relationship.getDifferences()) {
				if (difference.getType() == DifferenceType.RELATIONSHIP_RENAMED) {
					result = true;
					break outer;
				}
			}
		}
		return result;
	}
	String getOriginalType() {
		return this.relationship.getType();
	}	
}
