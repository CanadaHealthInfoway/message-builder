package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;

import org.junit.Test;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.Representation;
import ca.infoway.messagebuilder.datatype.lang.UncertainRange;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainValueTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;

public class UrgPqElementParserTest extends CeRxDomainValueTestCase {

	@Test
	public void testParse() throws Exception {
		Node node = createNode(
				"<range><low value=\"123\" unit=\"kg\" /><high value=\"567\" unit=\"kg\" /></range>");
		UncertainRange<PhysicalQuantity> range = (UncertainRange<PhysicalQuantity>) new UrgPqElementParser().parse(null, node, null).getBareValue();
		assertNotNull("null", range);
	
		assertEquals("low", new BigDecimal("123"), range.getLow().getQuantity());
		assertEquals("high", new BigDecimal("567"), range.getHigh().getQuantity());
		assertEquals("centre", new BigDecimal("345.0"), range.getCentre().getQuantity());
		assertEquals("width", new BigDecimal("444"), range.getWidth().getValue().getQuantity());
		assertEquals("representation", Representation.LOW_HIGH, range.getRepresentation());
	}
	
	@Test
	public void testReportError() throws Exception {
		XmlToModelResult xmlToJavaResult = new XmlToModelResult();
		
		Node node = createNode(
				"<range><low value=\"123\" unit=\"m\" /><high value=\"567\" unit=\"HOUR\" /></range>");
		UncertainRange<PhysicalQuantity> range = (UncertainRange<PhysicalQuantity>) new UrgPqElementParser().parse(null, node, xmlToJavaResult).getBareValue();
		
		assertNull("null", range);
		assertFalse("has error", xmlToJavaResult.getHl7Errors().isEmpty());
		assertEquals("syntax error", 
				new Hl7Error(Hl7ErrorCode.SYNTAX_ERROR, "Can't add two quantities of different units: m and HOUR"), 
				xmlToJavaResult.getHl7Errors().get(0));
	}
	
}
