package ca.infoway.messagebuilder.datatype.lang;

import org.junit.Test;

public class IntervalFactoryTest {

	@Test
	public void testNullParameters() {
		IntervalFactory.createCentre(null);
		IntervalFactory.createCentre(null, null);
		IntervalFactory.createCentreHigh(null, null);
		IntervalFactory.createCentreHigh(null, null, null, null);
		IntervalFactory.createCentreWidth(null, null);
		IntervalFactory.createCentreWidth(null, null, null);
		IntervalFactory.createHigh(null);
		IntervalFactory.createHigh(null, null);
		IntervalFactory.createLow(null);
		IntervalFactory.createLow(null, null);
		IntervalFactory.createLowCentre(null, null);
		IntervalFactory.createLowCentre(null, null, null, null);
		IntervalFactory.createLowHigh(null, null);
		IntervalFactory.createLowHigh(null, null, null, null);
		IntervalFactory.createLowWidth(null, null);
		IntervalFactory.createLowWidth(null, null, null);
		IntervalFactory.createSimple(null);
		IntervalFactory.createWidth(null);
		IntervalFactory.createWidthHigh(null, null);
		IntervalFactory.createWidthHigh(null, null, null);
	}
	
}
