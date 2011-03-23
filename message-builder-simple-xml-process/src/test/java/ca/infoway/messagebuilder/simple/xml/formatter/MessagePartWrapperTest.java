package ca.infoway.messagebuilder.simple.xml.formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementDetailCode;
import ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementDetailType;
import ca.infoway.messagebuilder.model.iehr.repc_mt230001ca.AuthorBean;
import ca.infoway.messagebuilder.model.interaction.FindCandidatesQueryBean;
import ca.infoway.messagebuilder.model.merged.AcknowledgementBean;
import ca.infoway.messagebuilder.model.merged.ErrorsOrWarningsBean;
import ca.infoway.messagebuilder.model.merged.SenderBean;


public class MessagePartWrapperTest {
	
	@Test
	public void shouldWriteSimpleCase() throws Exception {
		AcknowledgementBean bean = new AcknowledgementBean();
		MessagePartWrapper wrapper = new MessagePartWrapper(bean);
		wrapper.setField("acknowledgedMessageId", toList(new IIImpl(new Identifier("1.2.3"))));
		assertEquals("target message id", new Identifier("1.2.3"), bean.getAcknowledgedMessageId());
	}

	@Test
	public void shouldGetFieldNamesFromSuperTypes() throws Exception {
		FindCandidatesQueryBean bean = new FindCandidatesQueryBean();
		MessagePartWrapper wrapper = new MessagePartWrapper(bean);
		List<String> fieldNames = wrapper.getFieldNames();
		System.out.println(fieldNames);
		assertTrue("names", fieldNames.contains("messageIdentifier"));
	}

	@Test
	public void shouldUseBusinessNames() throws Exception {
		SenderBean bean = new SenderBean();
		MessagePartWrapper wrapper = new MessagePartWrapper(bean);
		List<String> fieldNames = wrapper.getFieldNames();
		System.out.println(fieldNames);
		assertTrue("names", fieldNames.contains("sendingNetworkAddress"));
	}
	
	@Test
	@Ignore
	public void shouldRecognizeChoices() throws Exception {
		AuthorBean bean = new AuthorBean();
		MessagePartWrapper wrapper = new MessagePartWrapper(bean);
		List<String> fieldNames = wrapper.getFieldNames();
		System.out.println(fieldNames);
		assertTrue("names", fieldNames.containsAll(Arrays.asList("nullAuthorRole", "healthcareWorker")));
	}
	
	@Test
	public void shouldWriteSimpleList() throws Exception {
		ErrorsOrWarningsBean bean = new ErrorsOrWarningsBean();
		MessagePartWrapper wrapper = new MessagePartWrapper(bean);
		wrapper.setField("referencedMessageLocations", toList(new STImpl("location1"), new STImpl("location2")));
		assertEquals("location", 2, bean.getReferencedMessageLocations().size());
		
		assertEquals("location 1", "location1", bean.getReferencedMessageLocations().iterator().next());
	}
	
	@Test
	public void shouldWriteMessagePartList() throws Exception {
		AcknowledgementBean bean = new AcknowledgementBean();
		List<Object> details = new ArrayList<Object>();
		details.add(createErrorsOrWarningsBean(AcknowledgementDetailType.ERROR, AcknowledgementDetailCode.INTERNAL_SYSTEM_ERROR, "I hate you"));
		details.add(createErrorsOrWarningsBean(AcknowledgementDetailType.ERROR, AcknowledgementDetailCode.INTERNAL_SYSTEM_ERROR, "And your little dog, too"));
		MessagePartWrapper wrapper = new MessagePartWrapper(bean);
		wrapper.setField("acknowledgementDetail", details);
		assertEquals("details", 2, bean.getAcknowledgementDetail().size());
	}
	
	private ErrorsOrWarningsBean createErrorsOrWarningsBean(AcknowledgementDetailType error, AcknowledgementDetailCode internalSystemError, String text) {
		ErrorsOrWarningsBean bean = new ErrorsOrWarningsBean();
		bean.setMessageDescription(text);
		bean.setMessageType(error);
		bean.setResponseCode(internalSystemError);
		return bean;
	}

	private List<Object> toList(Object... value) {
		return Arrays.asList(value);
	}

}
