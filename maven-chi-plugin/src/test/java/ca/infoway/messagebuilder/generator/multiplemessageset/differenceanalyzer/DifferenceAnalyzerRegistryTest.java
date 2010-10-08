package ca.infoway.messagebuilder.generator.multiplemessageset.differenceanalyzer;

import org.junit.Assert;
import org.junit.Test;

import ca.infoway.messagebuilder.xml.DifferenceType;

public class DifferenceAnalyzerRegistryTest {

	@Test
	public void shoudHaveAllDifferencesRegistered() {
		
		DifferenceType[] values = DifferenceType.values();
		
		for (DifferenceType differenceType : values) {
			Assert.assertNotNull(differenceType.toString(), DifferenceAnalyzerRegistry.getInstance().get(differenceType));
		}
		
	}
	
	
}
