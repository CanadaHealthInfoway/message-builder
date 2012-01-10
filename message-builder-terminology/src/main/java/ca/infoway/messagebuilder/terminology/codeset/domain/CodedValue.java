/**
 * Copyright 2012 Canada Health Infoway, Inc.
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.Index;

/**
 * A single term taken from a code system.
 *
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
@Entity
@Table(name="coded_value")
@org.hibernate.annotations.Table(indexes=@Index(name="codeIndex", columnNames={"code", "code_system_id"}), appliesTo = "coded_value")
//@Table(name="coded_value", uniqueConstraints=@UniqueConstraint(columnNames={"code, code_system_id"}))
public class CodedValue {

	private Long id;	
	private String code;
	private CodeSystem codeSystem;
	private String createUserId;
	private Date createDatetime;
	private Date lastUpdateDatetime;
	private Map<String, String> descriptions = Collections.synchronizedMap(new HashMap<String,String>());
	private List<CodedValue> parents = Collections.synchronizedList(new ArrayList<CodedValue>());
	private List<CodedValue> children = Collections.synchronizedList(new ArrayList<CodedValue>());
	
	/**
	 * <p>Instantiates a new coded value.
	 */
	public CodedValue() {
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
	 * <p>Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * <p>Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * <p>Gets the code system.
	 *
	 * @return the code system
	 */
	@ManyToOne(cascade = {CascadeType.ALL},optional=false)
	@JoinColumn(name = "code_system_id")
	public CodeSystem getCodeSystem() {
		return codeSystem;
	}

	/**
	 * <p>Sets the code system.
	 *
	 * @param system the new code system
	 */
	public void setCodeSystem(CodeSystem system) {
		this.codeSystem = system;
	}
	
	/**
	 * <p>Compare to.
	 *
	 * @param obj the obj
	 * @return the int
	 */
	public int compareTo(Object obj) {
		CodedValue that = (CodedValue) obj;
		return new CompareToBuilder()
			.append(this.getCodeSystem(), that.getCodeSystem())					
			.append(this.getCode(), that.getCode())
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
			return equals((CodedValue) o);
		}
	}
	private boolean equals(CodedValue that) {
		return new EqualsBuilder().append(this.id, that.id)
				.append(this.getCodeSystem(), that.getCodeSystem())					
				.append(this.getCode(), that.getCode())
				.append(this.getId(), that.getId())
				.isEquals();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.id)
				.append(this.code)		
				.append(this.codeSystem)
				.toHashCode();
	}

	/**
	 * <p>Gets the creates the datetime.
	 *
	 * @return the creates the datetime
	 */
	public Date getCreateDatetime() {
		return createDatetime;
	}

	/**
	 * <p>Sets the creates the datetime.
	 *
	 * @param createDatetime the new creates the datetime
	 */
	public void setCreateDatetime(Date createDatetime) {
		this.createDatetime = createDatetime;
	}

	/**
	 * <p>Gets the creates the user id.
	 *
	 * @return the creates the user id
	 */
	@Column(name = "create_userid")
	public String getCreateUserId() {
		return createUserId;
	}

	/**
	 * <p>Sets the creates the user id.
	 *
	 * @param createUserId the new creates the user id
	 */
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * <p>Gets the last update datetime.
	 *
	 * @return the last update datetime
	 */
	public Date getLastUpdateDatetime() {
		return lastUpdateDatetime;
	}

	/**
	 * <p>Sets the last update datetime.
	 *
	 * @param lastUpdateDatetime the new last update datetime
	 */
	public void setLastUpdateDatetime(Date lastUpdateDatetime) {
		this.lastUpdateDatetime = lastUpdateDatetime;
	}

	/**
	 * <p>Gets the descriptions.
	 *
	 * @return the descriptions
	 */
	@CollectionOfElements
	@org.hibernate.annotations.MapKey(columns={@Column(name="for_language",length=2)})
	@JoinTable(name = "coded_value_description",joinColumns=@JoinColumn(name="coded_value_id"))
	@Column(name="description")
	@BatchSize(size=25)
	public Map<String, String> getDescriptions() {
		return this.descriptions;
	}

	/**
	 * <p>Sets the descriptions.
	 *
	 * @param descriptions the descriptions
	 */
	public void setDescriptions(Map<String, String> descriptions) {
		this.descriptions = descriptions;
	}
	
	/**
	 * <p>Gets the parents.
	 *
	 * @return the parents
	 */
	@ManyToMany(cascade={CascadeType.ALL})
	@JoinTable(name="coded_value_to_coded_value",
				joinColumns=@JoinColumn(name="child_id"),
				inverseJoinColumns=@JoinColumn(name="parent_id"))
	public List<CodedValue> getParents() {
		return this.parents;
	}
	
	/**
	 * <p>Sets the parents.
	 *
	 * @param parents the new parents
	 */
	public void setParents(List<CodedValue> parents) {
		this.parents = parents;
	}

	/**
	 * <p>Gets the children.
	 *
	 * @return the children
	 */
	@ManyToMany(cascade={CascadeType.ALL}, mappedBy="parents")
	public List<CodedValue> getChildren() {
		return this.children;
	}
	
	/**
	 * <p>Sets the children.
	 *
	 * @param children the new children
	 */
	public void setChildren(List<CodedValue> children) {
		this.children = children;
	}

}
