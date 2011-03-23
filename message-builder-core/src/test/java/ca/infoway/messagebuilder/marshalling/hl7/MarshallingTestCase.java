package ca.infoway.messagebuilder.marshalling.hl7;

import static org.apache.commons.lang.SystemUtils.LINE_SEPARATOR;
import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

public abstract class MarshallingTestCase {
	
	protected static final String FULL_DATE_TIME = "yyyy-MM-dd'T'HH:mm:ss";
	protected static final String FULL_DATE = "yyyy-MM-dd";
	protected XmlToModelResult xmlJavaResult;
	protected TrivialCodeResolver resolver;
	
	@Before
	public void setUp() throws Exception {
		this.resolver = new TrivialCodeResolver();
		CodeResolverRegistry.register(resolver);
		this.xmlJavaResult = new XmlToModelResult();
	}
	
	@After
	public void tearDown() throws Exception {
		CodeResolverRegistry.unregisterAll();
	}

	protected Node createNode(String string) throws SAXException {
		return new DocumentFactory().createFromString(string).getDocumentElement();
	}
	
	protected static void assertXml(String description, String expected, String actual) {
		if (actual.contains("<!--")) {
			String first = StringUtils.substringBefore(actual, "<!--");
			String rest = StringUtils.substringAfter(StringUtils.substringAfter(actual, "<!--"), "-->");
			actual = first + rest;
		}
		assertEquals(description, formatXml(expected), formatXml(actual.replaceAll("\\s+<", "<")));
	}

	private static String formatXml(String value) {
		return value.replaceAll("><", ">" + LINE_SEPARATOR + "<").trim();
	}
	
	protected void assertDateEquals(String description, String pattern, Date expected, Date actual) {
		Assert.assertNotNull(description + " not null", actual);
		DateFormat format = DateUtil.instance(pattern);
		assertEquals(description, format.format(expected), format.format(actual));
	}
}
