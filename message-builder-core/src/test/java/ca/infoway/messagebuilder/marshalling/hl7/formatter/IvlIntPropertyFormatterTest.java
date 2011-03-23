package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.datatype.QTY;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Diff;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class IvlIntPropertyFormatterTest extends FormatterTestCase {
	
	private IvlIntPropertyFormatter formatter;
	
	@Before
	public void setUp() throws Exception {
		this.formatter = new IvlIntPropertyFormatter();
	}

	@Override
	protected FormatContext getContext(String name) {
		return new FormatContextImpl(name, "IVL<INT>", ConformanceLevel.POPULATED);
	}
	
	@Test
	public void testBasic() throws Exception {
		Interval<Integer> ivl = IntervalFactory.<Integer>createLowHigh(new Integer(1), new Integer(3));
		String result = this.formatter.format(getContext("name"), 
				new IVLImpl<QTY<Integer>, Interval<Integer>>(ivl));
		assertXml("result", "<name><low value=\"1\"/><high value=\"3\"/></name>", result);
	}
	
	@Test
	public void testIntervalLow() throws Exception {
		Interval<Integer> ivl = IntervalFactory.<Integer>createLow(new Integer(1));
		String result = this.formatter.format(getContext("name"), 
				new IVLImpl<QTY<Integer>, Interval<Integer>>(ivl));
		assertXml("result", "<name><low value=\"1\"/></name>", result);
	}

	@Test
	public void testNullCase() throws Exception {
		String result = this.formatter.format(getContext("name"), new IVLImpl<QTY<Integer>, Interval<Integer>>());
		assertXml("result", "<name nullFlavor=\"NI\"/>", result);
	}
	
	@Test
	public void testIntervalWidth() throws Exception {
		Interval<Integer> ivl = IntervalFactory.<Integer>createWidth(new Diff<Integer>(new Integer(2)));
		String result = this.formatter.format(getContext("name"), 
				new IVLImpl<QTY<Integer>, Interval<Integer>>(ivl));
		assertXml("result", "<name><width value=\"2\"/></name>", result);
	}
}
