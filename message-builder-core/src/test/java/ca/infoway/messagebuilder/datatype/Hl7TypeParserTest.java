package ca.infoway.messagebuilder.datatype;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;


/**
 * @sharpen.ignore - datatype - translated manually
 */
public class Hl7TypeParserTest {

	@Test
	public void shouldParseSimpleCase() throws Exception {
		Hl7TypeName name = new Hl7TypeParser().parse("ST");
		assertEquals("name", "ST", name.toString());
	}
	
	@Test
	public void shouldParseParameterizedTypes() throws Exception {
		Hl7TypeName name = new Hl7TypeParser().parse("SET<ST>");
		assertEquals("name", "SET<ST>", name.toString());
		assertEquals("base", "SET", name.getUnparameterizedName());
	}
	
	@Test
	public void shouldParseComplexParameterizedTypes() throws Exception {
		Hl7TypeName name = new Hl7TypeParser().parse("SET<RTO<PQ,PQ>>");
		assertEquals("name", "SET<RTO<PQ,PQ>>", name.toString());
		assertEquals("base", "SET", name.getUnparameterizedName());
		assertEquals("parameter count", 1, name.getParameters().size());
		
		Hl7TypeName parameter = name.getParameters().get(0);
		assertEquals("parameter name", "RTO", parameter.getUnparameterizedName());
		assertEquals("parameters of parameter count", 2, parameter.getParameters().size());
	}
	
	@Test
	public void shouldStripWhitespace() throws Exception {
		Hl7TypeName name = new Hl7TypeParser().parse("SET<RTO<PQ, PQ>>");
		assertEquals("name", "SET<RTO<PQ,PQ>>", name.toString());
		assertEquals("base", "SET", name.getUnparameterizedName());
		assertEquals("parameter count", 1, name.getParameters().size());
		
		Hl7TypeName parameter = name.getParameters().get(0);
		assertEquals("parameter name", "RTO", parameter.getUnparameterizedName());
		assertEquals("parameters of parameter count", 2, parameter.getParameters().size());
	}
	
	@Test
	public void shouldSplitOnCommas() throws Exception {
		List<String> parts = new Hl7TypeParser().split("PQ.DRUG,PQ.QUANTITY");
		assertEquals("count", 2, parts.size());
		assertEquals("first part", "PQ.DRUG", parts.get(0));
	}
	
	@Test
	public void shouldNotSplitOnNestedCommas() throws Exception {
		List<String> parts = new Hl7TypeParser().split("RTO<PQ.DRUG,PQ.QUANTITY>");
		assertEquals("count", 1, parts.size());
		assertEquals("first part", "RTO<PQ.DRUG,PQ.QUANTITY>", parts.get(0));
	}
}
