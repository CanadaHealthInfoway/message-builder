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

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.xml.Annotation;
import ca.infoway.messagebuilder.xml.AnnotationType;
import ca.infoway.messagebuilder.xml.Documentation;

public class AnnotationMatcherTest {

	private AnnotationMatcher annotationMatcher;
	private List<Annotation> testAnnotations;
	private List<AnnotationDelegate> testAnnotationDelegates;
	private Documentation testDocumentation;
	
	private Annotation annotation1;
	private Annotation annotation2;
	private Annotation annotation3;
	private Annotation annotation4;
	private Annotation annotation5;
	
	private AnnotationDelegate annotationDelegate1;
	private AnnotationDelegate annotationDelegate2;
	private AnnotationDelegate annotationDelegate3;
	private AnnotationDelegate annotationDelegate4;
	private AnnotationDelegate annotationDelegate5;
	
	@Before
	public void setup() {
		this.annotationMatcher = new AnnotationMatcher();
		
		this.testAnnotations = new ArrayList<Annotation>();
		this.testAnnotationDelegates = new ArrayList<AnnotationDelegate>();
		
		long i = 0;
		
		this.annotation1 = createAnnotation(AnnotationType.CONSTRAINT, "some text 1");
		this.annotationDelegate1 = createDelegate(i++, annotation1);
		
		this.annotation2 = createAnnotation(AnnotationType.MAPPING, "some text 2", "source name 2", null);
		this.annotationDelegate2 = createDelegate(i++, annotation2);
		
		this.annotation3 = createAnnotation(AnnotationType.DESCRIPTION, "some text 3", null, null);
		this.annotationDelegate3 = createDelegate(i++, annotation3);
		
		this.annotation4 = createAnnotation(AnnotationType.OTHER_NOTES, "some text 4", null, "otherType4");
		this.annotationDelegate4 = createDelegate(i++, annotation4);
		
		this.annotation5 = createAnnotation(AnnotationType.CONSTRAINT, "some text 5");
		this.annotationDelegate5 = createDelegate(i++, annotation5);
		
		this.testAnnotations.add(annotation1);
		this.testAnnotations.add(annotation2);
		this.testAnnotations.add(annotation3);
		this.testAnnotations.add(annotation4);
		this.testAnnotations.add(annotation5);
		
		this.testAnnotationDelegates.add(annotationDelegate1);
		this.testAnnotationDelegates.add(annotationDelegate2);
		this.testAnnotationDelegates.add(annotationDelegate3);
		this.testAnnotationDelegates.add(annotationDelegate4);
		this.testAnnotationDelegates.add(annotationDelegate5);
		
		this.testDocumentation = new Documentation();
		this.testDocumentation.setAnnotations(testAnnotations);
	}

	@Test
	public void testMatchAnnotationsOnTypeAllowedOnce() throws Exception {
		AnnotationConstraint constraint = createAnnotationConstraint(AnnotationType.DESCRIPTION, "any value", "any value", null, null);
		assertMatch(this.annotation3, this.annotationMatcher.getAnnotation(this.testAnnotations, constraint));
	}
	
	@Test
	public void testMatchDocumentationOnTypeOccursOnce() throws Exception {
		AnnotationConstraint constraint = createAnnotationConstraint(AnnotationType.MAPPING, "any value", "any value", "source name 2", null);
		assertMatch(this.annotation2, this.annotationMatcher.getAnnotation(this.testDocumentation, constraint));
	}
	
	@Test
	public void testMatchDelegatesOnTextMatch() throws Exception {
		String exactTextToMatch = this.annotation5.getText();
		AnnotationConstraint constraint = createAnnotationConstraint(AnnotationType.CONSTRAINT, exactTextToMatch, "any value", null, null);
		assertMatch(this.annotationDelegate5, this.annotationMatcher.findDelegate(this.testAnnotationDelegates, constraint));
	}
	
	
	@Test
	public void testMatchAnnotationsWhenExactButNotAdd() throws Exception {
		AnnotationType exactTypeToMatch = this.annotation5.getAnnotationTypeAsEnum();
		String exactTextToMatch = this.annotation5.getText();
		String exactOtherTypeToMatch = this.annotation5.getOtherAnnotationType();
		String exactSourceNameToMatch = this.annotation5.getSourceName();
		AnnotationConstraint constraint = createAnnotationConstraint(
				exactTypeToMatch,
				exactTextToMatch,
				"any value", 
				exactSourceNameToMatch,
				exactOtherTypeToMatch);

		assertMatch(this.annotation5, this.annotationMatcher.getAnnotation(this.testAnnotations, constraint));
	}
	
	@Test
	public void testFailMatchAnnotationsWhenExactButIsAdd() throws Exception {
		AnnotationType exactTypeToMatch = this.annotation4.getAnnotationTypeAsEnum();
		String exactOtherTypeToMatch = this.annotation4.getOtherAnnotationType();
		String exactSourceNameToMatch = this.annotation4.getSourceName();
		AnnotationConstraint constraint = createAnnotationConstraint(
				exactTypeToMatch, 
				null, //indicates this constraint is an "add" 
				"any value", 
				exactSourceNameToMatch,
				exactOtherTypeToMatch);

		Assert.assertNull(this.annotationMatcher.getAnnotation(this.testAnnotations, constraint));
	}
	
	@Test
	public void testFailMatchAnnotationsWhenNoMatch() throws Exception {
		AnnotationConstraint constraint = createAnnotationConstraint(AnnotationType.RATIONALE, "any value", "any value", null, null); 
		Assert.assertNull(this.annotationMatcher.getAnnotation(this.testAnnotations, constraint));
	}
	
	private void assertMatch(Annotation expectedAnnotation, Annotation actualAnnotation) {
		Assert.assertNotNull(actualAnnotation);
		Assert.assertSame(expectedAnnotation, actualAnnotation);
	}

	private void assertMatch(AnnotationDelegate expectedAnnotationDelegate, AnnotationDelegate actualAnnotationDelegate) {
		Assert.assertNotNull(actualAnnotationDelegate);
		Assert.assertSame(expectedAnnotationDelegate, actualAnnotationDelegate);
	}

	private Annotation createAnnotation(AnnotationType type, String text) {
		return createAnnotation(type, text, null, null);
	}
	
	private Annotation createAnnotation(AnnotationType type, String text, String sourceName, String otherType) {
		Annotation annotation = new Annotation(text);
		annotation.setAnnotationTypeAsEnum(type);
		annotation.setSourceName(sourceName);
		annotation.setOtherAnnotationType(otherType);
		return annotation;
	}
	
	private AnnotationDelegate createDelegate(Long index, Annotation annotation) {
		return new AnnotationDelegate(index, annotation);
	}

	private AnnotationConstraint createAnnotationConstraint(AnnotationType annotationType, String oldValue, String newValue, String sourceName, String otherAnnotationType) {
		AnnotationConstraint annotationConstraint = new AnnotationConstraint();
		annotationConstraint.setAnnotationType(annotationType);
		annotationConstraint.setNewValue(newValue);
		annotationConstraint.setOriginalValue(oldValue);
		annotationConstraint.setSourceName(sourceName);
		annotationConstraint.setOtherAnnotationType(otherAnnotationType);
		return annotationConstraint;
	}
	
}
