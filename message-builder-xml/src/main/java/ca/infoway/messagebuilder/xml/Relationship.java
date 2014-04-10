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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.xml;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import ca.infoway.messagebuilder.NamedAndTyped;
import ca.infoway.messagebuilder.lang.EnumPattern;
import ca.infoway.messagebuilder.xml.util.ConformanceLevelUtil;
import ca.infoway.messagebuilder.xml.util.RelationshipComparable;
import ca.infoway.messagebuilder.xml.util.RelationshipComparator;

/**
 * <p>A message part relationship (either an attribute or an association).
 * 
 * <p>Fundamentally, we think of there being four types of relationships:
 * 
 * <ol>
 * <li>Attributes
 * <li>Simple associations
 * <li>Choice associations
 * <li>Template associations
 * </ol>
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
@Root
public class Relationship extends ChoiceSupport implements Documentable, HasDifferences, NamedAndTyped, RelationshipComparable, Comparable<Relationship> {

	private static RelationshipComparator relationshipComparator = new RelationshipComparator();
	
	@Attribute
	private String name;
	@Attribute(required=false)
	private String type;
	@Attribute(required=false)
	private Boolean structural;
	@Attribute(required=false)
	private String domainType;
	@Attribute(required=false)
	private String domainSource;
	@Attribute(required=false)
	private String conformance;
	@Attribute(required=false)
	private String cardinality;
	@Attribute(required=false)
	private Integer sortOrder;
	@Attribute(required=false)
	private String fixedValue;
	@Attribute(required=false)
	private String templateParameterName;
	@Attribute(required=false)
	private Integer length;
	@Attribute(required=false)
	private String codingStrength;
	@Attribute(required=false)
	private String defaultValue;
	@Attribute(required=false)
	private String associationSortKey;
	@Attribute(required=false)
	private String traversableAssociationName;
	@Attribute(required=false)
	private String nontraversableAssociationName;
	@Attribute(required=false)
	private String cmetBindingName;
	@Attribute(required=false)
	private String traversableDerivationClassName;
	@Attribute(required=false)
	private String nontraversableDerivationClassName;
	@Attribute(required=false)
	private String cmetDerivationClassName;
	@Attribute(required=false)
	private String nonFixedVocabularyBinding;
	
	
	@ElementList(inline=true, required=false)
	@Namespace(prefix="regen",reference="regen_ns")
	private List<Difference> differences = new ArrayList<Difference>();
	
	@Element(required=false)
	private UpdateMode updateMode;
	@Element(required=false)
	private Documentation documentation;
	
	@ElementList(entry="choice",inline=true,required=false)
	private List<Relationship> choices = new ArrayList<Relationship>();

	// not guaranteed to be populated
	private String parentType;
	
	/**
	 * <p>Default constructor.
	 */
	public Relationship() {
	}
	
	/**
	 * <p>Standard constructor.
	 * @param name - the relationship name
	 * @param type - the relationship type
	 * @param cardinality - the cardinality.
	 */
	public Relationship(String name, String type, Cardinality cardinality) {
		this.name = name;
		this.type = type;
		this.cardinality = cardinality.toString();
	}
	
	/**
	 * <p>Get the relationship name.
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * <p>Set the name.
	 * @param name - the new value.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * <p>Get the relationship type.  
	 * 
	 * <p>Typical types for an attribute might be "II.OID", "LIST&lt;TS.FULLDATE&gt;" 
	 * or "ST".  
	 * 
	 * <p>Typical types for an association might
	 * be "PRPA_MT101103CA.PatientBirthTime".  This property is blank if the relationship
	 * represents a template relationship.
	 * @return the type
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * <p>Set the type.
	 * @param type - the new value
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * <p>Get the structural flag.
	 * @return - the structural flag
	 */
	public boolean isStructural() {
		return this.structural == null ? false : this.structural.booleanValue();
	}

	/**
	 * <p>Set the structural flag.
	 * @param structural - the new value
	 */
	public void setStructural(boolean structural) {
		this.structural = structural;
	}

	/**
	 * <p>The domain type.  If a relationship is an attribute and the type is a 
	 * coded type (e.g. "CD"), then the domain type represents the domain information
	 * (e.g. "ProcessingMode").
	 * 
	 * @return the domain type.
	 */
	public String getDomainType() {
		return this.domainType;
	}

	/**
	 * <p>Set the domain type.
	 * @param domainType - the new value
	 */
	public void setDomainType(String domainType) {
		this.domainType = domainType;
	}

	/**
	 * <p>Get the conformance level.
	 * @return the conformance level.
	 */
	public ConformanceLevel getConformance() {
		if (this.conformance != null) {
			return EnumPattern.valueOf(ConformanceLevel.class, this.conformance);
		} else if (hasFixedValue()) { // TM - should this also return MANDATORY if min cardinality > 0?
			return ConformanceLevel.MANDATORY;
		} else {
			return ConformanceLevel.OPTIONAL;
		}
	}

	/**
	 * <p>Set the conformance level.
	 * @param conformance the conformance level.
	 */
	public void setConformance(ConformanceLevel conformance) {
		this.conformance = conformance == null ? null : conformance.name();
	}

	/**
	 * <p>Get the cardinality.
	 * @return the cardinality
	 */
	public Cardinality getCardinality() {
		Cardinality temp = Cardinality.create(this.cardinality);
		if (temp != null) {
			return temp;
		// specifically using direct check of conformance value instead of using isMandatory or isPopulated to avoid logic errors
		} else if (getConformance() == ConformanceLevel.MANDATORY || 
				getConformance() == ConformanceLevel.POPULATED) {
			return Cardinality.create("1");
		} else {
			return Cardinality.create("0-1");
		}
	}

	/**
	 * <p>Set the cardinality.
	 * @param cardinality - the new value
	 */
	public void setCardinality(Cardinality cardinality) {
		this.cardinality = cardinality == null ? null : cardinality.toString();
	}

	public String getRawCardinality() {
		return this.cardinality;
	}
	
	/**
	 * <p>Get the sort order.  The sort order represents the order that the 
	 * XML elements appear in.
	 * 
	 * @return - the sort order
	 */
	public int getSortOrder() {
		return this.sortOrder == null ? 0 : this.sortOrder.intValue();
	}

	/**
	 * <p>Set the sort order.
	 * @param sortOrder - the new value
	 */
	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

	/**
	 * <p>Get the fixed value.  Only attributes can have fixed values.  Typically,
	 * fixed values are either code values (e.g. classCode="SBJ") or booleans ("true" or
	 * "false").
	 * @return - the string representation of the fixed value
	 */
	public String getFixedValue() {
		return this.fixedValue;
	}

	/**
	 * <p>Checks if has fixed value.  Only attributes can have fixed values.  Typically,
	 * fixed values are either code values (e.g. classCode="SBJ") or booleans ("true" or
	 * "false").
	 * @return - whether this relationship has a fixed value
	 */
	public boolean hasFixedValue() {
		return StringUtils.isNotBlank(this.fixedValue);
	}

	/**
	 * <p>Set the fixed value.
	 * @param fixedValue - the new value
	 */
	public void setFixedValue(String fixedValue) {
		this.fixedValue = fixedValue;
	}
	
	/**
	 * <p>Get the vocabulary binding
	 */
	public String getVocabularyBinding() {
		if (this.hasFixedValue()) {
			return this.getFixedValue();
		} else {
			return this.getNonFixedVocabularyBinding();
		}
	}

	/**
	 * <p>Get the documentation.
	 * @return the documentation.
	 */
	public Documentation getDocumentation() {
		return this.documentation;
	}

	/**
	 * <p>Set the documentation.
	 * @param documentation - the new value
	 */
	public void setDocumentation(Documentation documentation) {
		this.documentation = documentation;
	}
	
	/**
	 * <p>Get a flag indicating whether or not the relationship is an attribute.
	 * @return true if the relationship is an attribute; false otherwise.
	 */
	// BCH/TM: This might not be the best algorithm...
	public boolean isAttribute() {
		if (hasFixedValue()) {
			return true;
		} else if (isCodedType()) {
			return true;
		} else if (isStructural()) {
			return true;
		} else if (StringUtils.isNotBlank(this.type) && 
				(this.type.length() < 5 || this.type.charAt(4) != '_')) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * <p>Get a flag indicating whether or not the relationship is a fixed value and is mandatory.
	 * @return true if the relationship has a fixed value and is mandatory; false otherwise
	 */
	public boolean isFixed() {
		return hasFixedValue() && isMandatory();
	}
	
	/**
	 * <p>Get a flag indicating whether or not the relationship is an association.
	 * @return true if the relationship is an association; false otherwise.
	 */
	public boolean isAssociation() {
		return !isAttribute();
	}

	/**
	 * <p>Get a flag indicating whether or not the relationship is mandatory.
	 * @return true if the relationship is mandatory; false otherwise.
	 */
	public boolean isMandatory() {
		return ConformanceLevelUtil.isMandatory(this);
	}

	/**
	 * <p>Get a flag indicating whether or not the relationship is populated.
	 * @return true if the relationship is populated; false otherwise.
	 */
	public boolean isPopulated() {
		return ConformanceLevelUtil.isPopulated(this);
	}
	
	/**
	 * <p>Get a flag indicating whether or not the relationship is required.
	 * @return true if the relationship is required; false otherwise.
	 */
	public boolean isRequired() {
		return ConformanceLevelUtil.isRequired(this);
	}
	
	/**
	 * <p>Get a flag indicating whether or not the relationship is optional.
	 * @return true if the relationship is optional; false otherwise.
	 */
	public boolean isOptional() {
		return ConformanceLevelUtil.isOptional(this);
	}
	
	/**
	 * <p>Get a flag indicating whether or not the relationship is ignored.
	 * @return true if the relationship is ignored; false otherwise.
	 */
	public boolean isIgnored() {
		return ConformanceLevelUtil.isIgnored(this);
	}
	
	/**
	 * <p>Get a flag indicating whether or not the relationship is not allowed.
	 * @return true if the relationship is not allowed; false otherwise.
	 */
	public boolean isNotAllowed() {
		return ConformanceLevelUtil.isNotAllowed(this);
	}
	
	/**
	 * <p>Get a flag indicating whether or not the relationship is a coded type.
	 * @return true if the relationship is a coded type; false otherwise.
	 */
	public boolean isCodedType() {
		return StringUtils.isNotBlank(this.domainType) && !"ST".equals(this.type);	// JR: Sometimes, strings get bound to data types in the MIF. We generally want to ignore this.
	}

	/**
	 * <p>Get a flag indicating whether or not the relationship is a template relationship.
	 * 
	 * <p>The implementation of this method used to contain special handling for some
	 * cases where the message set was incomplete. However, message set generation is
	 * much more reliable these days, and the special handling was causing more problems
	 * than it solved, so we took it out. JR - 20130325
	 * 
	 * @return true if the relationship is a template relationship; false otherwise.
	 */
	public boolean isTemplateRelationship() {
		if (StringUtils.isNotBlank(this.templateParameterName)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * <p>Get a list of all choices.
	 * @return the list of choice relationships
	 */
	@Override
	public List<Relationship> getChoices() {
		return this.choices;
	}

	/**
	 * <p>Get the template parameter name.  Only template associations should
	 * have a template parameter name.
	 * @return the template parameter name.
	 */
	public String getTemplateParameterName() {
		return this.templateParameterName;
	}

	/**
	 * <p>Set the template parameter name.
	 * @param templateParameterName - the new value.
	 */
	public void setTemplateParameterName(String templateParameterName) {
		this.templateParameterName = templateParameterName;
	}
	
	/**
	 * <p>Get the maximum string length.
	 * @return the length
	 */
	public Integer getLength() {
		return this.length;
	}

	/**
	 * <p>Set the maximum string length.
	 * @param length - the new value
	 */
	public void setLength(Integer length) {
		this.length = length;
	}

	/**
	 * <p>Get the coding strength.
	 * @return the coding strength
	 */
	public CodingStrength getCodingStrength() {
		return EnumPattern.valueOf(CodingStrength.class, this.codingStrength);
	}

	/**
	 * <p>Set the codeing strength.
	 * @param codingStrength - the new value.
	 */
	public void setCodingStrength(CodingStrength codingStrength) {
		this.codingStrength = codingStrength == null ? null : codingStrength.name();
	}

	/**
	 * <p>Get the default value.  Typically, only boolean fields have default values.
	 * @return - the default value.
	 */
	public String getDefaultValue() {
		return this.defaultValue;
	}

	/**
	 * <p>Set the default value.
	 * @param defaultValue - the new value
	 */
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	
	public String getAssociationSortKey() {
		return associationSortKey;
	}

	public void setAssociationSortKey(String associationSortKey) {
		this.associationSortKey = associationSortKey;
	}

	/**
	 * <p>Standard toString method.
	 * @return a debug string.
	 */
	@Override
	public String toString() {
		return (isAttribute() ? "Attribute: " : "Association: ") + getName();
	}
	
	/**
	 * Records the differences between relationships of different release versions during regen.
	 * 
	 * @return list of differences
	 */
	public List<Difference> getDifferences() {
		return this.differences;
	}
	public void setDifferences(List<Difference> differences) {
		this.differences = differences;
	}
	public void addDifference(Difference difference) {
		this.differences.add(difference);
	}

	/**
	 * <p>Get the vocabulary source.
	 * @return the vocabulary source
	 */
	public DomainSource getDomainSource() {
		return EnumPattern.valueOf(DomainSource.class, this.domainSource);
	}

	/**
	 * <p>Set the vocabulary source.
	 * @param vocabulary source - the new value.
	 */
	public void setDomainSource(DomainSource domainSource) {
		this.domainSource = domainSource == null ? null : domainSource.getName();
	}

	/**
	 * <p>Gets the update mode information that may be used for this element.
	 * @return updateMode;
	 */
	public UpdateMode getUpdateMode() {
		return updateMode;
	}
	/**
	 * <p>Gets the update mode information that may be used for this element.
	 * @param updateMode
	 */
	public void setUpdateMode(UpdateMode updateMode) {
		this.updateMode = updateMode;
	}

	/**
	 * The type containing this relationship
	 * @return parent type
	 */
	public String getParentType() {
		return parentType;
	}
	/**
	 * The type containing this relationship
	 * @param parentType
	 */
	public void setParentType(String parentType) {
		this.parentType = parentType;
	}

	public String getTraversableAssociationName() {
		return traversableAssociationName;
	}

	public void setTraversableAssociationName(String traversableAssociationName) {
		this.traversableAssociationName = traversableAssociationName;
	}

	public String getNontraversableAssociationName() {
		return nontraversableAssociationName;
	}

	public void setNontraversableAssociationName(
			String nontraversableAssociationName) {
		this.nontraversableAssociationName = nontraversableAssociationName;
	}

	public String getCmetBindingName() {
		return cmetBindingName;
	}

	public void setCmetBindingName(String cmetBindingName) {
		this.cmetBindingName = cmetBindingName;
	}

	public String getTraversableDerivationClassName() {
		return traversableDerivationClassName;
	}

	public void setTraversableDerivationClassName(
			String traversableDerivationClassName) {
		this.traversableDerivationClassName = traversableDerivationClassName;
	}

	public String getNontraversableDerivationClassName() {
		return nontraversableDerivationClassName;
	}

	public void setNontraversableDerivationClassName(
			String nontraversableDerivationClassName) {
		this.nontraversableDerivationClassName = nontraversableDerivationClassName;
	}

	public String getCmetDerivationClassName() {
		return cmetDerivationClassName;
	}

	public void setCmetDerivationClassName(String cmetDerivationClassName) {
		this.cmetDerivationClassName = cmetDerivationClassName;
	}

	public String getNonFixedVocabularyBinding() {
		return nonFixedVocabularyBinding;
	}

	public void setNonFixedVocabularyBinding(String nonFixedVocabularyBinding) {
		this.nonFixedVocabularyBinding = nonFixedVocabularyBinding;
	}

	public int compareTo(Relationship rel) {
		return relationshipComparator.compare(this, rel);
	}

}
