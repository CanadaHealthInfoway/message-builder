package ca.infoway.messagebuilder.generator.multiplemessageset.differenceanalyzer;

import ca.infoway.messagebuilder.xml.Difference;

public class ComponentMissingDifferenceAnalyzer implements DifferenceAnalyzer {

	public void analyze(Difference difference) {
		// pass through - the difference in this case is set on creation to "ok", but some cases can flip this
		//              - leave as is on difference, i.e. do nothing here
	}

}
