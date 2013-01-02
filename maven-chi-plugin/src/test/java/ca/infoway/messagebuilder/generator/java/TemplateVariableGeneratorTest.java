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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.generator.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class TemplateVariableGeneratorTest {
	
	@Test
	public void shouldFindVariableNameBasedOnTemplateParameterName() throws Exception {
		TemplateVariableGenerator generator = new TemplateVariableGenerator();
		TemplateVariable v1 = generator.getNext("RegisteredRole");
		assertEquals("v1", "RR", v1.getType());
		
		TemplateVariable v2 = generator.getNext("Act");
		assertEquals("v2", "ACT", v2.getType());
		
		TemplateVariable v3 = generator.getNext("RamblingRoomba");
		assertEquals("v3", "T", v3.getType());
		
		TemplateVariable v4 = generator.getNext("ReversibleRobe");
		assertEquals("v4", "U", v4.getType());
	}
	
	@Test
	public void shouldNotCollideWithStandardDataTypeName() throws Exception {
		TemplateVariableGenerator generator = new TemplateVariableGenerator();
		TemplateVariable v1 = generator.getNext("CorrectiveDiscussion");
		assertEquals("v1", "T", v1.getType());
	}
}
