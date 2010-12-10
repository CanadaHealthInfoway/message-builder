package ca.infoway.messagebuilder.generator.java;

import java.util.List;

interface Fuzziness {
	boolean isWorthChecking(SimplifiableType type, SimplifiableType otherType);
	boolean isSufficientOverlap(List<MatchType> matchTypes);
}
