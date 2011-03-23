package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.Set;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class SetTsElementParserTest extends ParserTestCase {
	
	@Test
	public void testParse() throws Exception {
		Node node = createNode("<top>" +
				"<something value=\"20000407123059\" />" +
				"<something value=\"20020628010101\" />" +
				"</top>");
		
		BareANY result = new SetElementParser().parse(
				ParserContextImpl.create("SET<TS>", null, SpecificationVersion.V02R02.getVersionLiteral(), ConformanceLevel.MANDATORY), 
				asList(node.getChildNodes()), 
				null);
		Set<Date> set = ((SET<TS,Date>) result).rawSet();
		
		assertNotNull("null", set);
		assertEquals("size", 2, set.size());
        
		Date expectedCalendar = DateUtil.getDate(2000, 3, 7, 12, 30, 59, 0);
        assertTrue("first date", set.contains(expectedCalendar));
        
        expectedCalendar = DateUtil.getDate(2002, 5, 28, 1, 1, 1, 0);
        assertTrue("second date", set.contains(expectedCalendar));
	}
}
