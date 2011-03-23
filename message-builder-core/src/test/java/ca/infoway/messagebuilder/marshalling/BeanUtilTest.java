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
