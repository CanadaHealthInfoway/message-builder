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

package ca.infoway.messagebuilder.marshalling;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.platform.PropertyPath;

public class BeanUtilTest {

	private MockMessageBean testBean;
	
	@Before
	public void initialize() {
		this.testBean = new MockMessageBean();
	}
	
	@Test
	public void shouldHandleNullBean() {
		Assert.assertEquals("", BeanUtil.describeBeanPath(null, "/a/b/c"));
	}
	
	@Test
	public void shouldHandleNullPath() {
		Assert.assertEquals("", BeanUtil.describeBeanPath(new Object(), null));
	}
	
	@Test
	public void shouldHandleEmptyPath() {
		Assert.assertEquals("", BeanUtil.describeBeanPath(new Object(), " "));
	}
	
	@Test
	public void shouldHandlePathNotFound() {
		Assert.assertEquals(PropertyPath.toPath("MockMessageBean"), BeanUtil.describeBeanPath(this.testBean, "/aNotFound/b/c"));
	}
	
	@Test
	public void shouldHandleMassageBeanOnlyPath() {
		String result = BeanUtil.describeBeanPath(this.testBean, "/MOCK_IN123456CA");
		Assert.assertEquals(PropertyPath.toPath("MockMessageBean"), result);
	}
	
	@Test
	public void shouldHandleSimplePath() {
		String result = BeanUtil.describeBeanPath(this.testBean, "/MOCK_IN123456CA/theType");
		Assert.assertEquals(PropertyPath.toPath("MockMessageBean.type"), result);
	}
	
	@Test
	public void shouldHandleComplexPath() {
		String result = BeanUtil.describeBeanPath(this.testBean, "/MOCK_IN123456CA/theType/component/subject3/name");
		Assert.assertEquals(PropertyPath.toPath("MockMessageBean.type.name"), result);
	}
	
	@Test
	public void shouldHandleComplexPathWithoutMessageBean() {
		String result = BeanUtil.describeBeanPath(this.testBean, "theType/component/subject3/name");
		Assert.assertEquals(PropertyPath.toPath("MockMessageBean.type.name"), result);
	}
	
	@Test
	public void shouldHandleComplexPathEndingInNullProperty() {
		String result = BeanUtil.describeBeanPath(this.testBean, "/MOCK_IN123456CA/theType/component/subject3/name");
		Assert.assertEquals(PropertyPath.toPath("MockMessageBean.type.name"), result);
	}
	
}
