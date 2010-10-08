package ca.infoway.messagebuilder.generator.multiplemessageset.differenceanalyzer;

import ca.infoway.messagebuilder.xml.Difference;

public class TrivialDifferenceAnalyzer implements DifferenceAnalyzer {

	private final boolean alwaysOk;

	public TrivialDifferenceAnalyzer(boolean alwaysOk) {
		this.alwaysOk = alwaysOk;
	}
	
	public void analyze(Difference difference) {
		difference.setOk(this.alwaysOk);
}

}
