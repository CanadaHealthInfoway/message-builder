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
