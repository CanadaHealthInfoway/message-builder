package ca.infoway.messagebuilder.generator.multiplemessageset.differenceanalyzer;

import java.util.List;

import ca.infoway.messagebuilder.generator.java.MatchType;
import ca.infoway.messagebuilder.generator.java.NameMatcher;
import ca.infoway.messagebuilder.generator.java.NamedType;
import ca.infoway.messagebuilder.xml.Difference;
import ca.infoway.messagebuilder.xml.DifferenceMatch;
import ca.infoway.messagebuilder.xml.DifferenceValue;
import ca.infoway.messagebuilder.xml.TypeName;

public class AssociationTypeDifferenceAnalyzer implements DifferenceAnalyzer {

	private class NamedTypeImpl implements NamedType {

		private TypeName typeName;

		private NamedTypeImpl(String type) {
			this.typeName = new TypeName(type);
		}
		
		public String getBusinessName() {
			return null;
		}

		public TypeName getTypeName() {
			return this.typeName;
		}
	}
	
	private static final NameMatcher NAME_MATCHER = new NameMatcher(); 
	
	public AssociationTypeDifferenceAnalyzer() {
	}

	public void analyze(Difference difference) {
		boolean result = false;
		List<DifferenceValue> differenceValues = difference.getDifferences();
		if (differenceValues.size() == 2) {
			String type1 = differenceValues.get(0).getValue();
			String type2 = differenceValues.get(1).getValue();
			DifferenceMatch differenceMatch = determineTypeDifference(type1, type2);
			difference.setMatchConfidence(differenceMatch);
			
			// let later process decide on actual merits of match
			result = true;
		}
		difference.setOk(result);
	}

	private DifferenceMatch determineTypeDifference(String type1AsString, String type2AsString) {
		MatchType matchType = NAME_MATCHER.matchNames(new NamedTypeImpl(type1AsString), new NamedTypeImpl(type2AsString));
		return matchType == MatchType.MAJOR_DIFFERENCE ? DifferenceMatch.UNLIKELY_MATCH : DifferenceMatch.POSSIBLE_MATCH;
	}

}
