package ca.infoway.messagebuilder.generator.multiplemessageset.differenceanalyzer;

public class RelationshipMissingDomainTypeDifferenceAnalyzer extends TrivialDifferenceAnalyzer {

	// all known instances of this difference has indicated an error in the source MIF(s)
	// this has been handled substituting (TBD) either the domain type that is present, or Code
	
	public RelationshipMissingDomainTypeDifferenceAnalyzer() {
		super(true);
	}
	
}
