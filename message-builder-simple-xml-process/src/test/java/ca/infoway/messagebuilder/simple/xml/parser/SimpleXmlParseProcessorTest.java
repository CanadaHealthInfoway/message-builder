package ca.infoway.messagebuilder.simple.xml.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang.StringUtils;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.r02_04_02.common.merged.SenderBean;
import ca.infoway.messagebuilder.model.r02_04_02.interaction.FindCandidatesQueryBean;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParseContext;
import ca.infoway.messagebuilder.simple.xml.SimpleXmlParser;

@SuppressWarnings("unchecked")
@RunWith(JMock.class)
public class SimpleXmlParseProcessorTest {
	
	private Mockery jmock = new Mockery();
	private ParserFactory factory = this.jmock.mock(ParserFactory.class);
	private SimpleXmlParser<ANY<?>> parser = this.jmock.mock(SimpleXmlParser.class);
	
	@Test
	public void shouldWalkThroughMessageParts() throws Exception {
		this.jmock.checking(new Expectations() {{
			one(factory).create(StandardDataType.II); will(returnValue(parser));
			allowing(factory).create(with(any(StandardDataType.class))); will(returnValue(null));
			allowing(parser).parse(with(any(SimpleXmlParseContext.class)), with(any(ANY.class))); 
			will(returnValue("<deviceId root=\"123\" extension=\"asdf\" />"));
		}});
		
		StringBuilder builder = new StringBuilder();
		new SimpleXmlParseProcessor(factory).process("sender", createSender(), builder, 0);
		
		String xml = StringUtils.trim(builder.toString());
		System.out.println(xml);
		assertTrue("start tag", xml.startsWith("<sender "));
		assertTrue("end tag", xml.endsWith("</sender>"));
	}

	@Test
	public void shouldProcessAll() throws Exception {
		StringBuilder builder = new StringBuilder();
		new SimpleXmlParseProcessor().process("sender", createSender(), builder, 0);
		
		String xml = StringUtils.trim(builder.toString());
		System.out.println(xml);
		assertTrue("start tag", xml.startsWith("<sender "));
		assertTrue("end tag", xml.endsWith("</sender>"));
	}
	
	private SenderBean createSender() {
		SenderBean sender = new SenderBean();
		sender.setSendingApplicationIdentifier(new Identifier("1.2.3.4", "senderId"));
		return sender;
	}
	
	@Test
	public void shouldDetermineInteractionName() throws Exception {
		String interactionName = new SimpleXmlParseProcessor().getInteractionName(FindCandidatesQueryBean.class);
		assertEquals("name", "findCandidatesQuery", interactionName);
	}
}
