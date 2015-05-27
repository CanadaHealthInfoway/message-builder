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

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.infoway.messagebuilder.xml.Annotation;
import ca.infoway.messagebuilder.xml.AnnotationType;

/**
 * @sharpen.ignore - related class is only used at runtime by maven-chi-plugin - no need to translate to .NET 
 */
public class AnnotationDelegateTest {

	@Test
	public void testGetType() {
		Annotation existingAnnotation = new Annotation();
		existingAnnotation.setAnnotationType(AnnotationType.CONSTRAINT.name());
		
		AnnotationConstraint constraint = new AnnotationConstraint();
		constraint.setAnnotationType(AnnotationType.DESCRIPTION);
		
		assertEquals(AnnotationType.CONSTRAINT, new AnnotationDelegate(Long.valueOf(1), existingAnnotation).getType());
		assertEquals(AnnotationType.DESCRIPTION, new AnnotationDelegate(Long.valueOf(1), constraint).getType());
		assertEquals(AnnotationType.DESCRIPTION, new AnnotationDelegate(Long.valueOf(1), existingAnnotation, constraint).getType());
	}

}