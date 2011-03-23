package ca.infoway.messagebuilder.terminology.codeset.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import ca.infoway.messagebuilder.Describable;

/**
 * An identifier for a business concept that is used in a
 * particular field of an HL7 message.
 *
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
@Entity
@Table(name="vocabulary_domain",
	    uniqueConstraints = {@UniqueConstraint(columnNames={"type"})}
		)
public class VocabularyDomain implements Describable {

	private Long id;	
	private String type;
	private String businessName;
	private String description;
	
	private VocabularyDomain parent;
	private VocabularyDomain root;
	
	/**
	 * <p>Instantiates a new vocabulary domain.
	 */
	public VocabularyDomain() {
	}
	
	/**
	 * <p>Instantiates a new vocabulary domain.
	 *
	 * @param type the type
	 */
	public VocabularyDomain(String type) {
		this.type = type;
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
	 * <p>Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * <p>Gets the type as class.
	 *
	 * @return the type as class
	 */
	@Transient
	public Class<?> getTypeAsClass() {
		try {
			return Class.forName("ca.infoway.messagebuilder.domainvalue." + getType());
		} catch (ClassNotFoundException e) {
			return null;
		}
	}
	
	/**
	 * <p>Gets the unqualified type.
	 *
	 * @return the unqualified type
	 */
	@Transient
	public String getUnqualifiedType() {
		return ClassUtils.getShortClassName(this.type);
	}

	/**
	 * <p>Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * <p>Compare to.
	 *
	 * @param obj the obj
	 * @return the int
	 */
	public int compareTo(Object obj) {
		VocabularyDomain that = (VocabularyDomain) obj;
		return new CompareToBuilder()
			.append(this.getType(), that.getType())
			.append(this.getId(), that.getId())
			.append(this.getBusinessName(), that.getBusinessName())
			.append(this.getDescription(), that.getDescription())
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
			return equals((VocabularyDomain) o);
		}
	}
	private boolean equals(VocabularyDomain that) {
		return new EqualsBuilder().append(this.id, that.id)
				.append(this.getType(), that.getType())
				.append(this.getId(), that.getId())
				.append(this.getBusinessName(), that.getBusinessName())
				.append(this.getDescription(), that.getDescription())
				.isEquals();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.id)
				.append(this.type)
				.append(this.businessName)
				.append(this.description)
				.toHashCode();
	}

	/**
	 * <p>Gets the business name.
	 *
	 * @return the business name
	 */
	public String getBusinessName() {
		return this.businessName;
	}

	/**
	 * <p>Sets the business name.
	 *
	 * @param businessName the new business name
	 */
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	/**
	 * {@inheritDoc}
	 */
	@Column(length=32767)
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
	 * <p>Gets the parent.
	 *
	 * @return the parent
	 */
	@ManyToOne
	@JoinColumn(name="parent_vocabulary_domain_id")
	public VocabularyDomain getParent() {
		return this.parent;
	}

	/**
	 * <p>Sets the parent.
	 *
	 * @param parent the new parent
	 */
	public void setParent(VocabularyDomain parent) {
		this.parent = parent;
	}

	/**
	 * <p>Gets the root.
	 *
	 * @return the root
	 */
	@ManyToOne
	@JoinColumn(name="root_vocabulary_domain_id")
	public VocabularyDomain getRoot() {
		return this.root;
	}

	/**
	 * <p>Sets the root.
	 *
	 * @param root the new root
	 */
	public void setRoot(VocabularyDomain root) {
		this.root = root;
	}
	
	/**
	 * <p>Checks if is root type.
	 *
	 * @return true, if is root type
	 */
	@Transient
	public boolean isRootType() {
		return this.root == null;
	}
}
