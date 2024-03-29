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

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.Named;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;
import ca.infoway.messagebuilder.xml.util.ConformanceLevelUtil;

public abstract class BaseRelationship implements PropertyGeneratorProvider, Named, Fingerprintable {

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

    public final String[] getAllXmlMappings() {
    	return getXmlMappingHelper().getAllXmlMappings();
    }

	XmlMappingHelper getXmlMappingHelper() {
		return new XmlMappingHelper(this.relationship);
	}

    public boolean isMandatory() {
        return ConformanceLevelUtil.isMandatory(this.relationship);
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
        return this.relationship.hasFixedValue();
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
	
	public Set<Object> getImportTypes(boolean parentTypeIsMerged, boolean parentTypeIsAbstract) {
		Set<Object> result = new HashSet<Object>();
		if (!parentTypeIsAbstract) {
			result.add("ca.infoway.messagebuilder.annotation.Hl7XmlMapping");
		}
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

	public boolean isWriteable() {
		return !isCardinalityMultiple();
	}
	
	public String getBusinessName() {
		return getDocumentation()!=null ? getDocumentation().getBusinessName() : null; 
	}
	
	boolean requiresMapByPartTypeAnnotation() {
		return getAllXmlMappings().length > 1 && !isTemplateType();
	}

	final Set<NameAndType> getMapByPartTypeMappings() {
		return getXmlMappingHelper().getMapByPartTypeMappings();
	}

	public abstract Fingerprint getFingerprint(TypeName containingType);
	
}
