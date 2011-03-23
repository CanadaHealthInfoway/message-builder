package ca.infoway.messagebuilder.generator.regen;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class DeltaCalculatorsTest {
	
	@Test
	public void ensureBusinessNameIsDeclaredAfterCardinalityAndTypeCalculators() throws Exception {
		List<DeltaCalculator> calculators = DeltaCalculators.allNameBasedCalculators();
		
		int indexOfBusiness = indexOf(calculators, BusinessNameDeltaCalculator.class);
		int indexOfCardinality = indexOf(calculators, CardinalityDeltaCalculator.class);
		int indexOfType = indexOf(calculators, TypeDeltaCalculator.class);
		
		assertTrue("business after cardinality", indexOfBusiness > indexOfCardinality);
		assertTrue("business after type", indexOfBusiness > indexOfType);
		
		
	}

	@Test
	public void ensureDocumentationIsDeclaredLast() throws Exception {
		List<DeltaCalculator> calculators = DeltaCalculators.allNameBasedCalculators();
		
		int indexOfDocumentation = indexOf(calculators, DocumentationDeltaCalculator.class);
		
		assertTrue("documentation is last", indexOfDocumentation == calculators.size()-1);
		
		
	}
	
	private int indexOf(List<DeltaCalculator> calculators, Class<?> calculatorType) {
		int index = 0;
		for (int i=0; i<calculators.size(); i++) {
			if (calculatorType.isInstance(calculators.get(i))) {
				index = i;
				break;
			}
		}
		return index;
	}

}
