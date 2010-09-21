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
