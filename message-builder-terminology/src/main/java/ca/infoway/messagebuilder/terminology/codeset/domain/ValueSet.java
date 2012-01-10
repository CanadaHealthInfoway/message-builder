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

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * <p>The Class ValueSet.
 *
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
@Entity
@Table
public class ValueSet {

	private Long id;
	private String name;
	private Set<VocabularyDomain> vocabularyDomains = Collections.synchronizedSet(new HashSet<VocabularyDomain>());

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
	 * <p>The name of the value set.
	 *
	 * @return the name
	 */
	@Column(unique=true)
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
	 * <p>Gets the vocabulary domains.
	 *
	 * @return the vocabulary domains
	 */
	@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinTable(name="value_set_to_vocabulary_domain", 
			joinColumns=@JoinColumn(name="value_set_id", nullable=false),
			inverseJoinColumns=@JoinColumn(name="vocabulary_domain_id", nullable=false))
	public Set<VocabularyDomain> getVocabularyDomains() {
		return this.vocabularyDomains;
	}
	
	/**
	 * <p>Sets the vocabulary domains.
	 *
	 * @param vocabularyDomains the new vocabulary domains
	 */
	public void setVocabularyDomains(Set<VocabularyDomain> vocabularyDomains) {
		this.vocabularyDomains = vocabularyDomains;
	}
}
