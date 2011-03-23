package ca.infoway.messagebuilder.simple.xml.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.TN;
import ca.infoway.messagebuilder.datatype.impl.TNImpl;
import ca.infoway.messagebuilder.datatype.lang.TrivialName;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

public class TrivialNameXmlParserTest  extends AbstractXmlParserTest<TN> {
	
	public TrivialNameXmlParserTest() {
		super(new TrivialNameXmlParser(), "name", new TNImpl());
	}
	
	@Test
	public void shouldParse() throws Exception {
		assertEquals(
				"<name>Mary</name>",
				this.parser.parse(createContext(), new TNImpl(new TrivialName("Mary"))));
	}

	@Test
	public void shouldParseReservedXmlChars() throws Exception{
		assertEquals(
				"<name>&lt;cats think they&apos;re &gt; humans &amp; dogs 99% of the time/&gt;</name>",
				this.parser.parse(createContext(), new TNImpl(new TrivialName("<cats think they're > humans & dogs 99% of the time/>"))));
	}
	
	@Override
	protected TN createAnyWithNullFlavor(NullFlavor nullFlavor) {
		return new TNImpl(nullFlavor);
	}

}
