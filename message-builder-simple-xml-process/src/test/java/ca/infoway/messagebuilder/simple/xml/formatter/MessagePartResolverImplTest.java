package ca.infoway.messagebuilder.simple.xml.formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.model.r02_04_02.common.merged.SenderBean;

public class MessagePartResolverImplTest {
	
	@Test
	public void shouldResolveBasicType() throws Exception {
		MessagePartWrapper bean = new MessagePartResolverImpl().resolve(SpecificationVersion.R02_04_02, "MCCI_MT002100CA.Sender", null);
		assertNotNull("bean", bean);
		assertEquals("type", SenderBean.class, bean.unwrap().getClass());
	}

}
