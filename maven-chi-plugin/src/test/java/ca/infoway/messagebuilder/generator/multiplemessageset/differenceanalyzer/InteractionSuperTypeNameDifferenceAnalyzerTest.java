package ca.infoway.messagebuilder.generator.multiplemessageset.differenceanalyzer;

import static ca.infoway.messagebuilder.generator.multiplemessageset.differenceanalyzer.InteractionSuperTypeNameDifferenceAnalyzer.MESSAGE_0100;
import static ca.infoway.messagebuilder.generator.multiplemessageset.differenceanalyzer.InteractionSuperTypeNameDifferenceAnalyzer.MESSAGE_0200;
import static ca.infoway.messagebuilder.generator.multiplemessageset.differenceanalyzer.InteractionSuperTypeNameDifferenceAnalyzer.MESSAGE_0300;
import static ca.infoway.messagebuilder.generator.multiplemessageset.differenceanalyzer.InteractionSuperTypeNameDifferenceAnalyzer.MESSAGE_2100;
import static ca.infoway.messagebuilder.generator.multiplemessageset.differenceanalyzer.InteractionSuperTypeNameDifferenceAnalyzer.MESSAGE_2200;
import static ca.infoway.messagebuilder.generator.multiplemessageset.differenceanalyzer.InteractionSuperTypeNameDifferenceAnalyzer.MESSAGE_2300;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.xml.Difference;
import ca.infoway.messagebuilder.xml.DifferenceValue;

public class InteractionSuperTypeNameDifferenceAnalyzerTest {

	private InteractionSuperTypeNameDifferenceAnalyzer fixture;
	
	@Before
	public void setup() {
		this.fixture = new InteractionSuperTypeNameDifferenceAnalyzer();
	}
	
	@Test
	public void shouldNotMatchRandomDifferences() {
		Difference difference = createDifference("aaa", "bbb");
		
		Assert.assertFalse(difference.isOk());
		this.fixture.analyze(difference);
		Assert.assertFalse(difference.isOk());
	}

	@Test
	public void shouldProperlyAcceptOrRejectMessageSuperTypes() {
		testDifference(MESSAGE_0100, MESSAGE_0100, true);		
		testDifference(MESSAGE_0100, MESSAGE_0200, false);		
		testDifference(MESSAGE_0100, MESSAGE_0300, true);		
		testDifference(MESSAGE_0100, MESSAGE_2100, true);		
		testDifference(MESSAGE_0100, MESSAGE_2200, false);		
		testDifference(MESSAGE_0100, MESSAGE_2300, true);
		
		testDifference(MESSAGE_0200, MESSAGE_0100, false);		
		testDifference(MESSAGE_0300, MESSAGE_0100, true);		
		testDifference(MESSAGE_2100, MESSAGE_0100, true);		
		testDifference(MESSAGE_2200, MESSAGE_0100, false);		
		testDifference(MESSAGE_2300, MESSAGE_0100, true);
		
		testDifference(MESSAGE_0200, MESSAGE_0200, true);		
		testDifference(MESSAGE_0200, MESSAGE_0300, false);		
		testDifference(MESSAGE_0200, MESSAGE_2100, false);		
		testDifference(MESSAGE_0200, MESSAGE_2200, true);		
		testDifference(MESSAGE_0200, MESSAGE_2300, false);
		
		testDifference(MESSAGE_0300, MESSAGE_0200, false);		
		testDifference(MESSAGE_2100, MESSAGE_0200, false);		
		testDifference(MESSAGE_2200, MESSAGE_0200, true);		
		testDifference(MESSAGE_2300, MESSAGE_0200, false);
		
		testDifference(MESSAGE_0300, MESSAGE_0300, true);		
		testDifference(MESSAGE_0300, MESSAGE_2100, true);		
		testDifference(MESSAGE_0300, MESSAGE_2200, false);		
		testDifference(MESSAGE_0300, MESSAGE_2300, true);
		
		testDifference(MESSAGE_2100, MESSAGE_0300, true);		
		testDifference(MESSAGE_2200, MESSAGE_0300, false);		
		testDifference(MESSAGE_2300, MESSAGE_0300, true);		
		
		testDifference(MESSAGE_2100, MESSAGE_2100, true);		
		testDifference(MESSAGE_2100, MESSAGE_2200, false);		
		testDifference(MESSAGE_2100, MESSAGE_2300, true);
		
		testDifference(MESSAGE_2200, MESSAGE_2100, false);		
		testDifference(MESSAGE_2300, MESSAGE_2100, true);		
		
		testDifference(MESSAGE_2200, MESSAGE_2200, true);		
		testDifference(MESSAGE_2200, MESSAGE_2300, false);
		
		testDifference(MESSAGE_2300, MESSAGE_2200, false);		
		
		testDifference(MESSAGE_2300, MESSAGE_2300, true);
		
	}

	private void testDifference(String superType1, String superType2, boolean isOk) {
		Difference difference = createDifference(superType1, superType2);
		this.fixture.analyze(difference);
		Assert.assertEquals(isOk, difference.isOk());
	}

	private Difference createDifference(String superType1, String superType2) {
		DifferenceValue differenceValue1 = new DifferenceValue();
		differenceValue1.setVersion("version1");
		differenceValue1.setValue(superType1);
		DifferenceValue differenceValue2 = new DifferenceValue();
		differenceValue2.setVersion("version2");
		differenceValue2.setValue(superType2);
		Difference difference = new Difference();
		difference.getDifferences().add(differenceValue1);
		difference.getDifferences().add(differenceValue2);
		return difference;
	}
	
}
