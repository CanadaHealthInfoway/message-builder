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

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.infoway.messagebuilder.xml.AnnotationType;

/**
 * @sharpen.ignore - related class is only used at runtime by maven-chi-plugin - no need to translate to .NET 
 */
public class AnnotationConstraintTest {

	@Test
	public void testAnnotationConstraintAnnotationConstraint() {
		AnnotationConstraint origConstraint = new AnnotationConstraint();
		origConstraint.setAnnotationType(AnnotationType.CONSTRAINT);
		origConstraint.setId(new Long(2));
		origConstraint.setNewValue("newValue");
		origConstraint.setOriginalValue("origValue");
		origConstraint.setSourceName("sourceName");
		origConstraint.setOtherAnnotationType("other");
		
		AnnotationConstraint copied = new AnnotationConstraint(origConstraint);
		assertEquals(AnnotationType.CONSTRAINT, copied.getAnnotationType());
		assertEquals("newValue", copied.getNewValue());
		assertEquals("origValue", copied.getOriginalValue());
		assertEquals("sourceName", copied.getSourceName());
		assertEquals("other", copied.getOtherAnnotationType());
		
		// TM - ANNOTATION_RETAINS_ID - 1/3 - I changed annotation constraints to retain id when copied; this may be a mistake but everything appears to be working fine
		assertEquals(new Long(2), copied.getId());
	}

}
