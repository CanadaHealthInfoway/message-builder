package ca.infoway.messagebuilder.generator.multiplemessageset.differenceanalyzer;

public class RelationshipTypeDifferenceAnalyzer extends TrivialDifferenceAnalyzer {

	// attribute differences *should* all be handled by this point: ok=false if any get through to here
	// association differences are always ok=false (though might spend some effort looking at matching easy-to-detect "ok" differences)
	
	public RelationshipTypeDifferenceAnalyzer() {
		super(false);
	}

}
