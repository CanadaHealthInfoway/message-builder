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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import ca.infoway.messagebuilder.xml.AnnotationType;

/**
 * Contains the information for making a change to the annotations.
 *
 * @sharpen.ignore - only used at runtime by maven-chi-plugin - no need to translate to .NET 
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name="annotation_change")
public class AnnotationConstraint extends Constraint {

	private static final long serialVersionUID = -7219001966303259961L;

	@Column(length=32492)
	private String newValue;
	@Column(length=32492)
	private String originalValue;
	
	@Type(type="ca.infoway.smct.usertype.EnumPatternUserType",
		parameters = { @Parameter(name="returnedClass", value="ca.infoway.messagebuilder.xml.AnnotationType")})
	@Column(length=25, nullable=false)
	private AnnotationType annotationType = AnnotationType.DESCRIPTION;

	private String otherAnnotationType;
	private String sourceName;
	
	public AnnotationConstraint() {
	}
	
	public AnnotationConstraint(AnnotationConstraint constraint) {
		super(constraint);
		this.newValue = constraint.getNewValue();
		this.originalValue = constraint.getOriginalValue();
		this.annotationType = constraint.getAnnotationType();
		this.otherAnnotationType = constraint.getOtherAnnotationType();
		this.sourceName = constraint.getSourceName();
		if (this.annotationType == null) {
			this.annotationType = AnnotationType.DESCRIPTION;
		}
	}

	public String getOriginalValue() {
		return originalValue;
	}
	public void setOriginalValue(String oldValue) {
		this.originalValue = oldValue;
	}
	public String getNewValue() {
		return newValue;
	}
	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}
	public AnnotationType getAnnotationType() {
		return annotationType;
	}
	public void setAnnotationType(AnnotationType annotationType) {
		if (annotationType != null) {
			this.annotationType = annotationType;
		}
	}
	public String getAsString() {
		return "annotationType=" + getAnnotationType() + 
			"\nnewValue=" + getNewValue(); 
	}
	
	@Override
	public boolean hasChange() {
		// TM - after some digging, I guess I can understand why only the text fields are checked (other fields can't be changed on edit; for add, original value always null)
		if (!StringUtils.equals(this.newValue, this.originalValue)) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean hasChange(Constraint compareConstraint) {
		boolean result = false;
		if (compareConstraint instanceof AnnotationConstraint) {
			AnnotationConstraint compareAnnotation = (AnnotationConstraint) compareConstraint;
			result = !new EqualsBuilder()
						.append(this.annotationType, compareAnnotation.annotationType)
						.append(this.originalValue, compareAnnotation.originalValue)
						.append(this.newValue, compareAnnotation.newValue)
						.append(this.otherAnnotationType, compareAnnotation.otherAnnotationType)
						.append(this.sourceName, compareAnnotation.sourceName)
						.isEquals();
		}
		return result;
	}
	
	public boolean isAdd() {
		return StringUtils.isEmpty(originalValue);
	}
	public boolean isRemove() {
		return StringUtils.isEmpty(newValue);
	}
	public boolean isEdit() {
		return !isAdd() && !isRemove();
	}
	
	@Override
	public ConstraintChangeType getChange() {
		return ConstraintChangeType.ANNOTATION;
	}

	public String getDescription() {
		if (isAdd()) {
			return "ADD";
		} else if (isEdit()) {
			return "EDIT";
		} else if (isRemove()) {
			return "REMOVE";
		} else {
			return null;
		}
	}
	public String getOtherAnnotationType() {
		return otherAnnotationType;
	}
	public void setOtherAnnotationType(String otherAnnotationType) {
		this.otherAnnotationType = otherAnnotationType;
	}
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	@Override
	public Constraint clone(String originalPackageName, String newPackageName) {
		return new AnnotationConstraint(this);
	}
}
