/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.terminology.codeset.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * <p>A system of coded values that describe alternatives for a particular concept.
 *
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
@Entity
@Table(name="code_system",
	    uniqueConstraints = {@UniqueConstraint(columnNames={"oid"})}
		)
public class CodeSystem {

	private Long id;	
	private String oid;
	private String name;
	private String description;
	
	private String owningOrganization;
	
	/**
	 * <p>Instantiates a new code system.
	 */
	public CodeSystem() {
	}
	
	/**
	 * <p>Gets the id.
	 *
	 * @return the id
	 */
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return this.id;
	}
	
	/**
	 * <p>Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * <p>Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * <p>Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * <p>Gets the oid.
	 *
	 * @return the oid
	 */
	public String getOid() {
		return this.oid;
	}

	/**
	 * <p>Sets the oid.
	 *
	 * @param oid the new oid
	 */
	public void setOid(String oid) {
		this.oid = oid;
	}

	/**
	 * <p>Gets the description.
	 *
	 * @return the description
	 */
	@Column(length=2048)
	public String getDescription() {
		return this.description;
	}

	/**
	 * <p>Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * <p>Compare to.
	 *
	 * @param obj the obj
	 * @return the int
	 */
	public int compareTo(Object obj) {
		CodeSystem that = (CodeSystem) obj;
		return new CompareToBuilder()
			.append(this.getOid(), that.getOid())					
			.append(this.getName(), that.getName())
			.append(this.getId(), that.getId())
			.toComparison();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		} else if (o.getClass() != getClass()) {
			return false;
		} else {
			return equals((CodeSystem) o);
		}
	}
	private boolean equals(CodeSystem that) {
		return new EqualsBuilder().append(this.getOid(), that.getOid())					
				.append(this.getName(), that.getName())
				.append(this.getId(), that.getId())
				.isEquals();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.id)
				.append(this.name)		
				.append(this.oid)
				.toHashCode();
	}

	/**
	 * <p>The name of the organization that has responsibility for the 
	 * code system.  For example, the list of Alpha-2 language codes
	 * that represent <tt>HumanLanguage</tt> is associated with code system
	 * <tt>2.16.840.1.113883.6.84</tt> is controlled by IETF.  Thus, the
	 * owning organization name is "IETF".
	 * 
	 * @return the name of the owning organization.
	 */
	public String getOwningOrganization() {
		return this.owningOrganization;
	}

	/**
	 * <p>Sets the owning organization.
	 *
	 * @param owningOrganization the new owning organization
	 */
	public void setOwningOrganization(String owningOrganization) {
		this.owningOrganization = owningOrganization;
	}
	
}
