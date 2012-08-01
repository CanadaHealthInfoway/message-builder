package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;

public class TsFullDateWithTimePropertyFormatterTest {

	private TsFullDateWithTimePropertyFormatter formatter = new TsFullDateWithTimePropertyFormatter();
	
	@Test
	public void shouldProduceResultWithFullDateSpecializationType() {
		ModelToXmlResult result = new ModelToXmlResult();
		Date date = DateUtil.getDate(1999, 3, 23);
		TS ts = new TSImpl(date);
		ts.setDataType(StandardDataType.TS_FULLDATE);
		FormatContext context = new FormatContextImpl(result, null, "tsValue", "TS.FULLDATEWITHTIME", null, false, SpecificationVersion.R02_04_02, null, null);
		String xmlOutput = this.formatter.format(context, ts);
		assertTrue("no errors", result.getHl7Errors().isEmpty());
		assertEquals("output as expected", "<tsValue specializationType=\"TS.FULLDATE\" value=\"19990423\" xsi:type=\"TS\"/>", xmlOutput.trim());
	}
	
	@Test
	public void shouldProduceResultWithFullDateTimeSpecializationType() {
		ModelToXmlResult result = new ModelToXmlResult();
		Date date = DateUtil.getDate(1999, 3, 23, 1, 2, 3, 0);
		TS ts = new TSImpl(date);
		ts.setDataType(StandardDataType.TS_FULLDATETIME);
		FormatContext context = new FormatContextImpl(result, null, "tsValue", "TS.FULLDATEWITHTIME", null, false, SpecificationVersion.R02_04_02, null, null);
		String xmlOutput = this.formatter.format(context, ts);
		// avoid having to assess the timezone
		assertTrue("no errors", result.getHl7Errors().isEmpty());
		assertTrue(xmlOutput.trim().startsWith("<tsValue specializationType=\"TS.FULLDATETIME\" value=\"19990423010203.0000"));
		assertTrue(xmlOutput.trim().endsWith("\" xsi:type=\"TS\"/>"));
	}
	
	@Test
	public void shouldProduceResultWithMissingSpecializationTypeError() {
		ModelToXmlResult result = new ModelToXmlResult();
		Date date = DateUtil.getDate(1999, 3, 23, 1, 2, 3, 0);
		TS ts = new TSImpl(date);
		FormatContext context = new FormatContextImpl(result, null, "tsValue", "TS.FULLDATEWITHTIME", null, false, SpecificationVersion.R02_04_02, null, null);
		String xmlOutput = this.formatter.format(context, ts);
		assertEquals("1 error", 1, result.getHl7Errors().size());
		assertEquals("No specializationType provided. Value should be TS.FULLDATE or TS.FULLDATETIME. TS.FULLDATETIME will be assumed.", result.getHl7Errors().get(0).getMessage());
		// avoid having to assess the timezone
		assertTrue(xmlOutput.trim().startsWith("<tsValue specializationType=\"TS.FULLDATETIME\" value=\"19990423010203.0000"));
		assertTrue(xmlOutput.trim().endsWith("\" xsi:type=\"TS\"/>"));
	}
	
	@Test
	public void shouldProduceResultWithInvalidSpecializationTypeError() {
		ModelToXmlResult result = new ModelToXmlResult();
		Date date = DateUtil.getDate(1999, 3, 23, 1, 2, 3, 0);
		TS ts = new TSImpl(date);
		ts.setDataType(StandardDataType.TS_DATETIME);
		FormatContext context = new FormatContextImpl(result, null, "tsValue", "TS.FULLDATEWITHTIME", null, false, SpecificationVersion.R02_04_02, null, null);
		String xmlOutput = this.formatter.format(context, ts);
		assertEquals("1 error", 1, result.getHl7Errors().size());
		assertEquals("Invalid specializationType: TS.DATETIME. Value should be TS.FULLDATE or TS.FULLDATETIME. TS.FULLDATETIME will be assumed.", result.getHl7Errors().get(0).getMessage());
		// avoid having to assess the timezone
		assertTrue(xmlOutput.trim().startsWith("<tsValue specializationType=\"TS.FULLDATETIME\" value=\"19990423010203.0000"));
		assertTrue(xmlOutput.trim().endsWith("\" xsi:type=\"TS\"/>"));
	}
}
