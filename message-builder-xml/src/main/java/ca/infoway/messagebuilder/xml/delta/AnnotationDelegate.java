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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
package ca.infoway.messagebuilder.xml.delta;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.util.text.RenderUtils;
import ca.infoway.messagebuilder.xml.Annotation;
import ca.infoway.messagebuilder.xml.AnnotationType;

/**
 * Provides the information for the UI to display.
 */
public class AnnotationDelegate implements Serializable {

	private static final long serialVersionUID = -4418728033096054807L;
	
	private static final int LENGTH=25;
	private Long index;
	private final Annotation existingAnnotation;
	private AnnotationConstraint constraint;

	public AnnotationDelegate(Long index, Annotation existingAnnotation) {
		this(index, existingAnnotation, null);
	}

	public AnnotationDelegate(Long index, AnnotationConstraint constraintChange) {
		this(index, null, constraintChange);
	}

	public AnnotationDelegate(Long index, Annotation existingAnnotation, AnnotationConstraint constraint) {
		this.index = index;
		this.existingAnnotation = existingAnnotation;
		this.constraint = constraint;
	}
	
	public AnnotationDelegate(AnnotationConstraint constraintChange) {
		this(null, constraintChange);
	}

	public String getDescription() {
		return (constraint != null) ? constraint.getDescription() : null;
	}
	
	public boolean isEditable() {
		return !(hasConstraint() && getConstraint().isRemove());
	}

	public Long getIndex() {
		return index;
	}

	public String getOrigValue() {
		if (this.constraint != null) {
			return constraint.getOriginalValue();
		} else {
			return clean(existingAnnotation.getText());
		}
	}
	
	private String clean(String text) {
		return RenderUtils.removeJavaEscapedCharacters(text);
	}

	public String getOrigValueTruncated() {
		String value = null;
		if (this.constraint != null) {
			value = constraint.getOriginalValue();
		} else {
			value = clean(existingAnnotation.getText());
		}
		return truncate(value);
	}

	private String truncate(String value) {
		if (!StringUtils.isBlank(value) && value.length() > LENGTH) {
			return StringUtils.substring(value, 0, LENGTH)+"...";
		} else {
			return value;
		}
	}
	public String getNewValueTruncated() {
		return truncate(getNewValue());
	}	
	public String getNewValue() {
		if (this.constraint != null) {
			return constraint.getNewValue();
		} else if (this.existingAnnotation != null) {
			return clean(this.existingAnnotation.getText());
		} else {
			return null;
		}
	}
	
	public AnnotationType getType() {
		if (constraint != null) {
			return constraint.getAnnotationType();
		} else if (existingAnnotation.getAnnotationType() != null) {
			return existingAnnotation.getAnnotationTypeAsEnum();
		} else {
			return AnnotationType.DESCRIPTION;
		}
	}
	
	public AnnotationType getTypeFromAnnotation() {
		return (existingAnnotation != null) ? existingAnnotation.getAnnotationTypeAsEnum() : null;
	}

	public boolean hasConstraint() {
		return constraint!=null;
	}
	
	public AnnotationConstraint getConstraint() {
		return constraint;
	}

	public void setConstraint(AnnotationConstraint constraint) {
		this.constraint = constraint;
	}

	public boolean hasAnnotation() {
		return existingAnnotation != null;
	}

	public void setIndex(Long index) {
		this.index = index;
	}

	public String getSourceName() {
		if (constraint != null) {
			return constraint.getSourceName();
		} else {
			return existingAnnotation.getSourceName();
		}
	}

	public String getOtherAnnotationType() {
		if (constraint != null) {
			return constraint.getOtherAnnotationType();
		} else {
			return existingAnnotation.getOtherAnnotationType();
		}
	}

	public void mergeInto(AnnotationConstraint constraint) {
		// no need to merge into create fields as the original constraint is not removed
		// however, we do need to assess whether an update has been made, in which case we blank out the update fields
		AnnotationConstraint newConstraint = getAsAnnotationConstraint();
		if (newConstraint.hasChange(constraint)) {
			constraint.setUpdated(null);
			constraint.setUpdatedBy(null);
		}
		
		// merge main fields as normal
		constraint.setAnnotationType(getType());
		constraint.setOriginalValue(getOrigValue());
		constraint.setNewValue(handleIllegalXmlEscapeCharacters(getNewValue()));
		constraint.setOtherAnnotationType(getOtherAnnotationType());
		constraint.setSourceName(getSourceName());
	}

	private AnnotationConstraint getAsAnnotationConstraint() {
		AnnotationConstraint result = this.constraint;
		if (result == null) {
			result = new AnnotationConstraint();
			result.setAnnotationType(getType());
			result.setOriginalValue(getOrigValue());
			result.setNewValue(getNewValue());
			result.setOtherAnnotationType(getOtherAnnotationType());
			result.setSourceName(getSourceName());
		}
		return result;
	}
	
	private String handleIllegalXmlEscapeCharacters(String string) {
		return StringUtils.remove(string, "&nbsp;");
	}
}
