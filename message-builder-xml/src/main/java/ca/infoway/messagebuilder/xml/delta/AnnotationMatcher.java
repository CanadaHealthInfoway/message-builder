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

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.util.text.RenderUtils;
import ca.infoway.messagebuilder.xml.Annotation;
import ca.infoway.messagebuilder.xml.AnnotationType;
import ca.infoway.messagebuilder.xml.Documentation;

public class AnnotationMatcher {
	
	public AnnotationMatcher() {
	}

	public Annotation getAnnotation(Documentation documentation, AnnotationConstraint constraint) {
		return getAnnotation(documentation.getAnnotations(), constraint);
	}
	
	public Annotation getAnnotation(List<Annotation> annotations, AnnotationConstraint constraint) {
		AnnotationWrapper annotationWrapper = getAnnotationWrapper(wrap(annotations), constraint);
		return annotationWrapper == null ? null : annotationWrapper.getAnnotation();
	}
	
	// attempts to obtain the original annotation (inside a delegate) that the constraint was made against 
	public AnnotationDelegate findDelegate(List<AnnotationDelegate> delegates, AnnotationConstraint constraint) {
		AnnotationWrapper annotationWrapper = getAnnotationWrapper(wrapDelegates(delegates), constraint);
		return annotationWrapper == null ? null : annotationWrapper.getAnnotationDelegate();
	}

	private List<AnnotationWrapper> wrap(List<Annotation> annotations) {
		List<AnnotationWrapper> wrappers = new ArrayList<AnnotationWrapper>();
		for (Annotation annotation : annotations) {
			wrappers.add(new AnnotationWrapper(annotation));
		}
		return wrappers;
	}

	private List<AnnotationWrapper> wrapDelegates(List<AnnotationDelegate> annotationDelegates) {
		List<AnnotationWrapper> wrappers = new ArrayList<AnnotationWrapper>();
		for (AnnotationDelegate annotationDelegate : annotationDelegates) {
			if (annotationDelegate.hasAnnotation()) {
				wrappers.add(new AnnotationWrapper(annotationDelegate));
			}
		}
		return wrappers;
	}

	// attempts to obtain the original annotation that the constraint was made against 
	private AnnotationWrapper getAnnotationWrapper(List<AnnotationWrapper> annotations, AnnotationConstraint constraint) {
		AnnotationWrapper result = null;
		// don't bother looking for a match if the constraint is an "add"; callers should have weeded this check out already, but this is a safety check
		if (!constraint.isAdd()) {
			for (AnnotationWrapper annotation : annotations) {
				// type/otherType/sourceName is not a unique way of identifying an annotation; many annotation types can appear as duplicates using this method
				// it is difficult to know for sure if we have a match, as nothing uniquely identifies an annotation; this becomes potentially impossible if the original message set the constraint was based on has been changed  
				AnnotationType annotationTypeAsEnum = annotation.getAnnotationTypeAsEnum();
				if (StringUtils.equals(annotation.getSourceName(), constraint.getSourceName()) //possibly null
						&& StringUtils.equals(annotation.getOtherAnnotationType(), constraint.getOtherAnnotationType()) //possibly null
						&& annotationTypeAsEnum == constraint.getAnnotationType()) {
					// Unfortunately, a group of annotations can have duplicate sourceNames and, in many cases, types. 
					// Our last check now is to go based on text, unless the type only allows one annotation or the documentation only has one instance of the type.
					// FIXME - ANNOTATION MATCHING - TM - this can still miss an annotation match, especially if the underlying message set has been changed
					if (typeAllowedOnce(annotationTypeAsEnum) || typeOccursOnce(annotations, annotationTypeAsEnum) || matchesText(annotation, constraint)) {
						result = annotation;
						break;
					}
				}
			}
		}
		return result;
	}

	private boolean typeOccursOnce(List<AnnotationWrapper> annotations, AnnotationType annotationType) {
		boolean occursOnce = false;
		for (AnnotationWrapper annotation : annotations) {
			if (annotation.getAnnotationTypeAsEnum() == annotationType) {
				if (occursOnce) {
					occursOnce = false;
					break;
				}
				occursOnce = true;
			}
		}
		return occursOnce;
	}

	private boolean matchesText(AnnotationWrapper annotation, AnnotationConstraint constraint) {
		return StringUtils.equals(clean(annotation.getText()), constraint.getOriginalValue());
	}

	private boolean typeAllowedOnce(AnnotationType annotationType) {
		System.out.println(AnnotationType.typesAllowingMultipleCardinality.size());
		return !AnnotationType.typesAllowingMultipleCardinality.contains(annotationType);
	}

	private String clean(String text) {
		return RenderUtils.removeJavaEscapedCharacters(text);
	}

	
	private class AnnotationWrapper {
		private Annotation annotation;
		private AnnotationDelegate delegate;

		public AnnotationWrapper(Annotation annotation) {
			this.annotation = annotation;
		}
		
		public AnnotationWrapper(AnnotationDelegate delegate) {
			this.delegate = delegate;
		}
		
		Annotation getAnnotation() {
			if (this.annotation == null) { 
				throw new IllegalStateException("No annotation contained in wrapper");
			}
			return this.annotation;
		}
		
		AnnotationDelegate getAnnotationDelegate() {
			if (this.delegate == null) {
				throw new IllegalStateException("No annotation delegate contained in wrapper");
			}
			return this.delegate;
		}

		String getText() {
			return this.annotation != null ? this.annotation.getText() : this.delegate.getOrigValue();
		}
		
		AnnotationType getAnnotationTypeAsEnum() {
			return this.annotation != null ? this.annotation.getAnnotationTypeAsEnum() : this.delegate.getTypeFromAnnotation();
		}
		
		String getSourceName() {
			return this.annotation != null ? this.annotation.getSourceName() : this.delegate.getSourceName();
		}
		
		String getOtherAnnotationType() {
			return this.annotation != null ? this.annotation.getOtherAnnotationType() : this.delegate.getOtherAnnotationType();
		}
		
	}
	
}
