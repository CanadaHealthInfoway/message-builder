package ca.infoway.messagebuilder.generator.multiplemessageset.differenceanalyzer;

public class RelationshipDomainTypesIncompatibleDifferenceAnalyzer extends TrivialDifferenceAnalyzer {

	// for incompatible codes we currently use the Code interface to resolve them.
	// left as a detectable difference as we may want to investigate these changes
	
	public RelationshipDomainTypesIncompatibleDifferenceAnalyzer() {
		super(true);
	}
}
