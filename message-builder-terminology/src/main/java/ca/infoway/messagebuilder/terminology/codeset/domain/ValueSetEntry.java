package ca.infoway.messagebuilder.terminology.codeset.domain;

import static javax.persistence.EnumType.STRING;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.annotations.Type;

import ca.infoway.messagebuilder.terminology.codeset.support.SupportStatus;

/**
 * <p>A mapping representing the set of coded values that populate
 * a vocabulary domain in a particular jurisdiction.</p>
 *
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
@Entity
@Table(name="value_set_entry")
public class ValueSetEntry {

	private Long id;
	private CodedValue codedValue;
	private Integer sequence;
	private Boolean active;
	private Boolean common;
	private SupportStatus supportStatus;
	private ValueSet valueSet;
	
	/**
	 * <p>Instantiates a new value set entry.
	 */
	public ValueSetEntry() {
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
	 * <p>Gets the coded value.
	 *
	 * @return the coded value
	 */
	@JoinColumn(name = "coded_value_id")
	@ManyToOne(cascade = {CascadeType.ALL},optional=false)
	public CodedValue getCodedValue() {
		return codedValue;
	}

	/**
	 * <p>Sets the coded value.
	 *
	 * @param codedValue the new coded value
	 */
	public void setCodedValue(CodedValue codedValue) {
		this.codedValue = codedValue;
	}

	/**
	 * <p>Gets the sequence.
	 *
	 * @return the sequence
	 */
	public Integer getSequence() {
		return sequence;
	}

	/**
	 * <p>Sets the sequence.
	 *
	 * @param sequence the new sequence
	 */
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	/**
	 * <p>Gets the active.
	 *
	 * @return the active
	 */
	@Column(name = "active_flag")
	@Type(type = "yes_no")
	public Boolean getActive() {
		return active;
	}

	/**
	 * <p>Sets the active.
	 *
	 * @param active the new active
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	/**
	 * <p>Gets the common.
	 *
	 * @return the common
	 */
	@Column(name = "common")
	@Type(type = "yes_no")
	public Boolean getCommon() {
		return common;
	}
	
	/**
	 * <p>Sets the common.
	 *
	 * @param common the new common
	 */
	public void setCommon(Boolean common) {
		this.common = common;
	}
	
	/**
	 * <p>Gets the support status.
	 *
	 * @return the support status
	 */
	@Enumerated(STRING)
	public SupportStatus getSupportStatus() {
		return supportStatus;
	}

	/**
	 * <p>Sets the support status.
	 *
	 * @param supportStatus the new support status
	 */
	public void setSupportStatus(SupportStatus supportStatus) {
		this.supportStatus = supportStatus;
	}

	/**
	 * <p>Compare to.
	 *
	 * @param obj the obj
	 * @return the int
	 */
	public int compareTo(Object obj) {
		ValueSetEntry that = (ValueSetEntry) obj;
		return new CompareToBuilder()
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
			return equals((ValueSetEntry) o);
		}
	}
	private boolean equals(ValueSetEntry that) {
		return new EqualsBuilder().append(this.id, that.id)
				.isEquals();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.id)
				.toHashCode();
	}

	/**
	 * <p>Gets the value set.
	 *
	 * @return the value set
	 */
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="value_set_id",nullable=false)
	public ValueSet getValueSet() {
		return this.valueSet;
	}

	/**
	 * <p>Sets the value set.
	 *
	 * @param valueSet the new value set
	 */
	public void setValueSet(ValueSet valueSet) {
		this.valueSet = valueSet;
	}
}
