package ca.infoway.messagebuilder.generator.multiplemessageset.differenceanalyzer;

public class ArgumentTraversalNameDifferenceAnalyzer extends TrivialDifferenceAnalyzer {

	// this should be fine to deal with, just allow for two traversal paths
	// UNLESS there is a name collision - need to investigate
	
	public ArgumentTraversalNameDifferenceAnalyzer() {
		super(true);
	}
}
