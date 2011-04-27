/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.generator.multiplemessageset;

import junit.framework.Assert;

import org.junit.Test;

public class MessageSetMergeHelperTest {

	private MessageSetMergeHelper helper = new MessageSetMergeHelper();
	
	@Test
	public void shouldReturnNullObjectIfBothAreNull() throws Exception {
		Object result = this.helper.standardMerge(null, null);
		Assert.assertNull(result);
	}

	@Test
	public void shouldReturnNonnullObjectIfOtherIsNull() throws Exception {
		Object object = new Object();
		
		Object result = this.helper.standardMerge(object, null);
		Assert.assertEquals(object, result);
		
		result = this.helper.standardMerge(null, object);
		Assert.assertEquals(object, result);
	}
	
	@Test
	public void shouldReturnPrimaryNonnullObject() throws Exception {
		Object object1 = new Object();
		Object object2 = new Object();
		
		Object result = this.helper.standardMerge(object1, object2);
		Assert.assertEquals(object1, result);
		
		result = this.helper.standardMerge(object2, object1);
		Assert.assertEquals(object2, result);
	}
	
	@Test
	public void shouldReturnNullStringIfBothAreNull() throws Exception {
		String result = this.helper.standardMerge((String) null, (String) null);
		Assert.assertNull(result);
	}

	@Test
	public void shouldReturnNonnullStringIfOtherIsNull() throws Exception {
		String string = "a string";
		
		String result = this.helper.standardMerge(string, (String) null);
		Assert.assertEquals(string, result);
		
		result = this.helper.standardMerge(null, string);
		Assert.assertEquals(string, result);
	}
	
	@Test
	public void shouldReturnPrimaryNonnullString() throws Exception {
		String string1 = "a string";
		String string2 = "a different string";
		
		String result = this.helper.standardMerge(string1, string2);
		Assert.assertEquals(string1, result);
		
		result = this.helper.standardMerge(string2, string1);
		Assert.assertEquals(string2, result);
	}
	
	@Test
	public void shouldReturnNonBlankString() throws Exception {
		String string1 = "a string";
		String string2 = "   ";
		
		String result = this.helper.standardMerge(string1, string2);
		Assert.assertEquals(string1, result);
		
		result = this.helper.standardMerge(string2, string1);
		Assert.assertEquals(string1, result);
	}
	
}
