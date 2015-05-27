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

import static javax.persistence.CascadeType.ALL;

import static ca.infoway.messagebuilder.xml.delta.ConstraintChangeType.ADD_CHOICE;
import static ca.infoway.messagebuilder.xml.delta.ConstraintChangeType.ANNOTATION;
import static ca.infoway.messagebuilder.xml.delta.ConstraintChangeType.CHANGE_TEMPLATE_PARAMETER;
import static ca.infoway.messagebuilder.xml.delta.ConstraintChangeType.REMOVE;
import static ca.infoway.messagebuilder.xml.delta.ConstraintChangeType.REMOVE_CHOICE;
import static ca.infoway.messagebuilder.xml.delta.ConstraintChangeType.SCHEMATRON;
import static ca.infoway.messagebuilder.xml.delta.ConstraintChangeType.UNSUPPORTED;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.LogFactory;

import ca.infoway.messagebuilder.xml.TypeName;

/**
 * For one class/attribute/association provides all the information regarding to model changes.
 *
 * @sharpen.ignore - only used at runtime by maven-chi-plugin - no need to translate to .NET
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
    name="type",
    discriminatorType=DiscriminatorType.STRING
)
public abstract class Delta implements Serializable {
	
	private static final long serialVersionUID = 6254029325516646333L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false)
	private String className;
	private String relationshipName;
	@OneToMany(cascade = ALL,orphanRemoval=true)
	@OrderBy("id")
	@JoinTable(name="delta_to_constraint", joinColumns=@JoinColumn(name="delta_id", nullable=false),
			inverseJoinColumns=@JoinColumn(name="constraint_id", nullable=false))
	private List<Constraint> constraints = Collections.synchronizedList(new ArrayList<Constraint>());
	@Enumerated(EnumType.STRING)
	@Column(name="changeType", length=20,nullable=false)	
	private DeltaChangeType deltaChangeType;
	@Column(length=1)
	private String deleted = "N";
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public abstract MessagePartType getType();

	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getRelationshipName() {
		return relationshipName;
	}
	public void setRelationshipName(String relationshipName) {
		this.relationshipName = StringUtils.isBlank(relationshipName)? null: relationshipName;
	}
	public List<Constraint> getConstraints() {
		return constraints;
	}
	public void setConstraints(List<Constraint> constraints) {
		this.constraints = constraints;
	}
	public void addConstraints(List<? extends Constraint> constraints) {
		for (Constraint constraint : constraints) {
			addConstraint(constraint);
		}
	}
	
	public String getPackageLocation() {
		return StringUtils.substringBefore(getClassName(), ".");
	}
	public String getClassNameWithoutPackageLocation() {
		return StringUtils.substringAfter(getClassName(), ".");
	}
	
	/**
	 * <p>For most types of constraints, there can be zero or one instances of the 
	 * constraint.  The exceptions are "annotation" and "remove" constraints.
	 * 
	 * @param constraint 
	 * 	- the constraint to add
	 */
	public void addConstraint(Constraint constraint) {
		// TM - 13/6/11 - now allowing multiple constraints to exist for ANNOTAION *and* for REMOVE
		//  and for ADD_CHOICE - JR - 19/7/12
		//  and for REMOVE_CHOICE - JR - 19/7/12
		//  and for UNSUPPORTED - JT - 27/3/13
		if (!isAnnotationConstraint(constraint)
				&& !isRemoveConstraint(constraint)
				&& !isAddChoiceConstraint(constraint)
				&& !isRemoveChoiceConstraint(constraint)
				&& !isTemplateParameterConstraint(constraint)
				&& !isUnsupportedConstraint(constraint)
				&& !isSchematronConstraint(constraint)
				&& getConstraint(constraint.getChange()) != null) {
			Constraint removedConstraint = removeConstraintByType(constraint.getChange());
			if (removedConstraint != null) {
				// need to preserve creation data as this constraint currently exists in database
				constraint.setCreated(removedConstraint.getCreated());
				constraint.setCreatedBy(removedConstraint.getCreatedBy());
				if (!constraint.hasChange(removedConstraint)) {
					// need to preserve update data as this constraint currently exists in database and has *not* been modified
					constraint.setUpdated(removedConstraint.getUpdated());
					constraint.setUpdatedBy(removedConstraint.getUpdatedBy());
				}
			}
		}
		getConstraints().add(constraint);
	}
	private boolean isTemplateParameterConstraint(Constraint constraint) {
		return constraint.getChange() == CHANGE_TEMPLATE_PARAMETER;
	}
	private boolean isUnsupportedConstraint(Constraint constraint) {
		return constraint.getChange() == UNSUPPORTED;
	}
	private boolean isRemoveConstraint(Constraint constraint) {
		return constraint.getChange() == REMOVE;
	}
	private boolean isAnnotationConstraint(Constraint constraint) {
		return constraint.getChange() == ANNOTATION;
	}
	private boolean isAddChoiceConstraint(Constraint constraint) {
		return constraint.getChange() == ADD_CHOICE;
	}
	private boolean isRemoveChoiceConstraint(Constraint constraint) {
		return constraint.getChange() == REMOVE_CHOICE;
	}
	private boolean isSchematronConstraint(Constraint constraint) {
		return constraint.getChange() == SCHEMATRON;
	}
	public DeltaChangeType getDeltaChangeType() {
		return this.deltaChangeType;
	}
	public void setDeltaChangeType(DeltaChangeType type) {
		this.deltaChangeType = type;
	}
	
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	
	public Constraint removeConstraintByType(ConstraintChangeType changeType) {
		for (Constraint constraint : getConstraints()) {
			if (changeType.equals(constraint.getChange())) {
				getConstraints().remove(constraint);
				return constraint;
			}
		}
		return null;
	}
	
	/**
	 * This does NOT work for Annotations. Use getAllAnnotationConstraints() instead.
	 */
	public Constraint getConstraint(ConstraintChangeType changeType) {
		for (Constraint constraint : getConstraints()) {
			if (changeType.equals(constraint.getChange())) {
				return constraint;
			}
		}
		return null;
	}
	
	public List<Constraint> getAllConstraints(ConstraintChangeType changeType) {
		List<Constraint> result = new ArrayList<Constraint>();
		for (Constraint constraint : this.constraints) {
			if (changeType.equals(constraint.getChange())) {
				result.add(constraint);
			}
		}
		return Collections.unmodifiableList(result);
	}
	
	public List<AnnotationConstraint> getAllAnnotationConstraints() {
		List<AnnotationConstraint> result = new ArrayList<AnnotationConstraint>();
		for (Constraint constraint : this.constraints) {
			if (constraint instanceof AnnotationConstraint) {
				result.add((AnnotationConstraint) constraint);
			}
		}
		return Collections.unmodifiableList(result);
	}
	
	public void removeConstraint(Constraint constraint) {
		this.constraints.remove(constraint);
	}
	public Constraint getConstraintById(Long constraintId) {
		Constraint result = null;
		for (Constraint constraint : this.constraints) {
			if (ObjectUtils.equals(constraint.getId(), constraintId)) {
				result = constraint;
				break;
			}
		}
		return result;
	}
	public void assignRealmCode(RealmCode realmCode) {
		this.className = realmCode.substituteRealmCode(this.className);
		for (Constraint constraint : this.constraints) {
			constraint.assignRealmCode(realmCode);
		}
	}
	
	public boolean hasConstraints() {
		return this.constraints.size() > 0;
	}
	public Delta clone(String newPackageName) {
		String originalPackageName = TypeName.determineRootName(className);
		
		try {
			Delta cloneDelta = (Delta) this.getClass().newInstance();
			cloneDelta.setClassName(StringUtils.replace(this.className, originalPackageName, newPackageName));
			cloneDelta.setRelationshipName(relationshipName);
			cloneDelta.setDeltaChangeType(deltaChangeType);
			
			for (Constraint constraint : this.constraints) {
				cloneDelta.addConstraint(constraint.clone(originalPackageName, newPackageName));
			}
			
			return cloneDelta;
		} catch (Exception e) {
			LogFactory.getLog(Delta.class).warn("Unable to clone delta " + className + "." + relationshipName + " [" + deltaChangeType.toString() + "]", e);
		}
		
		return null;
	}
}
