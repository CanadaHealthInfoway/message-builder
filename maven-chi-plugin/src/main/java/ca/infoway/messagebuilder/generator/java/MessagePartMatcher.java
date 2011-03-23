package ca.infoway.messagebuilder.generator.java;

import static org.apache.commons.lang.StringUtils.equalsIgnoreCase;
import static org.apache.commons.lang.StringUtils.trimToEmpty;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.Relationship;

public class MessagePartMatcher {

	private final MessagePart baseline;
	private Matcher matcher = new Matcher();

	public MessagePartMatcher(MessagePart baseline) {
		this.baseline = baseline;
	}

	public MatchType matchesBusinessName(Relationship relationship) {
		Relationship baselineRelationship = getBaselineRelationship(relationship.getName());
		return matchesBusinessName(
				baselineRelationship == null ? null : baselineRelationship.getDocumentation(), 
				relationship.getDocumentation());
	}
	
	private Relationship getBaselineRelationship(String name) {
		return this.baseline.getRelationship(name);
	}
	
	public MatchType matchesBusinessName(Documentation other) {
		Documentation base = this.baseline.getDocumentation();
		return matchesBusinessName(other, base);
	}

	private MatchType matchesBusinessName(Documentation other, Documentation base) {
		if (base == null && other == null) {
			return MatchType.EXACT;
		} else if (base == null) {
			return MatchType.REMOVED;
		} else if (other == null) {
			return MatchType.ADDED;
		} else {
			return equalsIgnoreCase(trimToEmpty(base.getBusinessName()), trimToEmpty(other.getBusinessName()))
					? MatchType.EXACT : MatchType.MINOR_DIFFERENCE;
		}
	}

	public MatchType matchesType(Relationship relationship) {
		Relationship baselineRelationship = getBaselineRelationship(relationship.getName());
		return this.matcher.matchesType(baselineRelationship, relationship);
	}
}
