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

package ca.infoway.messagebuilder.xml.delta;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import ca.infoway.messagebuilder.xml.DomainSource;

/**
 * Provide information on a change to the CD, CV, CS
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name="vocabulary_binding_change")
public class VocabularyBindingConstraint extends Constraint {

	private static final long serialVersionUID = 2873896598848025184L;

	private String originalDomainType;
	private String newDomainType;
	
	@Type(type="ca.infoway.smct.usertype.EnumPatternUserType",
			parameters = { @Parameter(name="returnedClass", value="ca.infoway.messagebuilder.xml.DomainSource")})	
	private DomainSource newDomainSource;

	@Type(type="ca.infoway.smct.usertype.EnumPatternUserType",
			parameters = { @Parameter(name="returnedClass", value="ca.infoway.messagebuilder.xml.DomainSource")})
	private DomainSource originalDomainSource;
	
	public VocabularyBindingConstraint() {
	}
	public VocabularyBindingConstraint(DomainSource originalDomainSource, DomainSource newDomainSource, String originalDomainType, String newDomainType) {
		this.originalDomainType = originalDomainType;
		this.newDomainType = newDomainType;
		this.originalDomainSource = originalDomainSource;
		this.newDomainSource = newDomainSource;
	}

	@Override
	public ConstraintChangeType getChange() {
		return ConstraintChangeType.CHANGE_VOCABULARY_BINDING;
	}

	@Override
	public boolean hasChange() {
		return !new EqualsBuilder()
		.append(originalDomainSource, newDomainSource)
		.append(originalDomainType, newDomainType)
		.isEquals();
	}

	@Override
	public boolean hasChange(Constraint constraint) {
		boolean result = false;
		if (constraint instanceof VocabularyBindingConstraint) {
			VocabularyBindingConstraint compareConstraint = (VocabularyBindingConstraint) constraint;
			
			result = !new EqualsBuilder()
						.append(this.originalDomainSource, compareConstraint.originalDomainSource)
						.append(this.originalDomainType, compareConstraint.originalDomainType)
						.append(this.newDomainSource, compareConstraint.newDomainSource)
						.append(this.newDomainType, compareConstraint.newDomainType)
						.isEquals();
		}
		return result;
	}
	
	@Override
	public String getAsString() {
		StringBuffer buf = new StringBuffer();
		if (StringUtils.isNotBlank(newDomainType)) {
			if (newDomainSource != null) {
				buf.append("new domain source: ");
				buf.append(newDomainSource.getCode());
			}
			buf.append(" new domain type: ");
			buf.append(newDomainType);
		}
		return buf.toString();
	}

	public DomainSource getOriginalDomainSource() {
		return originalDomainSource;
	}

	public void setOriginalDomainSource(DomainSource originalDomainSource) {
		this.originalDomainSource = originalDomainSource;
	}

	public String getOriginalDomainType() {
		return originalDomainType;
	}

	public void setOriginalDomainType(String originalDomainType) {
		this.originalDomainType = originalDomainType;
	}

	public String getNewDomainType() {
		return newDomainType;
	}

	public void setNewDomainType(String newDomainType) {
		this.newDomainType = newDomainType;
	}

	public DomainSource getNewDomainSource() {
		return newDomainSource;
	}

	public void setNewDomainSource(DomainSource newomainSource) {
		this.newDomainSource = newomainSource;
	}

	public boolean isCodeSystem() {
		return DomainSource.CODE_SYSTEM.equals(newDomainSource);
	}
}
