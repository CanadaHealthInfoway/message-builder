package ca.infoway.messagebuilder.generator.regen;

import java.util.Arrays;
import java.util.List;

public class DeltaCalculators {
	public static List<DeltaCalculator> allNameBasedCalculators() {
		return Arrays.<DeltaCalculator>asList( 
				new CardinalityDeltaCalculator(), 
				new ConformanceDeltaCalculator(),
				new TypeDeltaCalculator(),
				new BusinessNameDeltaCalculator(),
				new DocumentationDeltaCalculator());
	}
}
