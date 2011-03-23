package ca.infoway.messagebuilder.devtools;

import junit.framework.Assert;

import org.junit.Test;

/**
 * @sharpen.ignore missing test
 */
public class MessageBeanFactoryTest {
	
	@Test
	public void shouldPopulateSubBeans() throws Exception {
		PatientDischargeCareSummariesQueryBean bean = new MessageBeanFactory(new DefaultValueHolder()).populate(new PatientDischargeCareSummariesQueryBean());
		Assert.assertNotNull(bean.getReceiver());
		Assert.assertEquals("Receiver Application Name", bean.getReceiver().getReceiverApplicationName());
	}

}
