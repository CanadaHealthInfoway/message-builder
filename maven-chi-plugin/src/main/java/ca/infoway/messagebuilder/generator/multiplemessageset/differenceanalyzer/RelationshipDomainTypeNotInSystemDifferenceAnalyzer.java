package ca.infoway.messagebuilder.generator.multiplemessageset.differenceanalyzer;

public class RelationshipDomainTypeNotInSystemDifferenceAnalyzer extends TrivialDifferenceAnalyzer {

	// We need to fall back to using the Code interface to resolve this difference.
	// Still allowing difference to make it through to here so we can track it.
	
	public RelationshipDomainTypeNotInSystemDifferenceAnalyzer() {
		super(true);
	}

}
