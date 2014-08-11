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
package ca.infoway.messagebuilder.tools.delta;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.xml.Annotation;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.delta.AddConstraint;
import ca.infoway.messagebuilder.xml.delta.AddInteractionConstraint;
import ca.infoway.messagebuilder.xml.delta.AnnotationConstraint;
import ca.infoway.messagebuilder.xml.delta.AnnotationMatcher;
import ca.infoway.messagebuilder.xml.delta.BusinessNameConstraint;
import ca.infoway.messagebuilder.xml.delta.CardinalityConstraint;
import ca.infoway.messagebuilder.xml.delta.CloneConstraint;
import ca.infoway.messagebuilder.xml.delta.ConformanceConstraint;
import ca.infoway.messagebuilder.xml.delta.Constraint;
import ca.infoway.messagebuilder.xml.delta.RemoveConstraint;

public abstract class ConstraintVisitor {

	private AnnotationMatcher annotationMatcher = new AnnotationMatcher();
	
	public void visit(Constraint constraint) {
		if (constraint instanceof RemoveConstraint) {
			visitRemoveConstraint((RemoveConstraint) constraint);
		} else if (constraint instanceof AnnotationConstraint) {
			visitAnnotationConstraint((AnnotationConstraint) constraint);
		} else if (constraint instanceof BusinessNameConstraint) {
			visitBusinessNameConstraint((BusinessNameConstraint) constraint);
		} else if (constraint instanceof ConformanceConstraint) {
			visitConformanceConstraint((ConformanceConstraint) constraint);
		} else if (constraint instanceof CardinalityConstraint) {
			visitCardinalityConstraint((CardinalityConstraint) constraint);
		}
	}

	void visitBusinessNameConstraint(BusinessNameConstraint constraint) {
		Documentation documentation = getDocumentation();
		documentation.setBusinessName(sanitize(constraint.getNewValue()));
	}

	void visitCardinalityConstraint(CardinalityConstraint constraint) {
	}
	
	void visitConformanceConstraint(ConformanceConstraint constraint) {
	}
	
	void visitAnnotationConstraint(AnnotationConstraint constraint) {
		Documentation documentation = getDocumentation();
		Annotation annotation = this.annotationMatcher.getAnnotation(documentation, constraint);
		
		if (annotation != null && constraint.isRemove()) {
			documentation.getAnnotations().remove(annotation);
		} else if (annotation != null && constraint.isEdit()) {
			// for edits (other than re-edits of an "add"), only text can be changed
			annotation.setText(constraint.getNewValue());
		} else if (annotation == null && constraint.isAdd()) {
			// annotation should always be null for an add, as we don't bother trying to find a match
			annotation = createAnnotation(constraint, documentation);
			documentation.getAnnotations().add(annotation);
		} else {
			// FIXME - ANNOTATION NOT FOUND - TM - constraint is an edit or remove, but no matching annotation found - what to do in this case???
			// do nothing for now - this annotation constraint will not modify the message set
			// the intention here is for the user to run the similarity report and manually correct non-matching annotation constraints
		}
	}

	private Annotation createAnnotation(AnnotationConstraint constraint, Documentation documentation) {
		Annotation annotation = new Annotation();
		annotation.setText(constraint.getNewValue());
		annotation.setAnnotationTypeAsEnum(constraint.getAnnotationType());
		annotation.setOtherAnnotationType(constraint.getOtherAnnotationType());
		annotation.setSourceName(constraint.getSourceName());
		return annotation;
	}
	
	String sanitize(String input) {
		return StringUtils.isBlank(input) ? null : input;
	}
	
	abstract Documentation getDocumentation();

	void visitRemoveConstraint(RemoveConstraint constraint) {}
	void visitCloneConstraint(CloneConstraint constraint) {}
	void visitAddConstraint(AddConstraint constraint) {}
	void visitAddInteractionConstraint(AddInteractionConstraint constraint) {}
	public void postProcess() {}
}
