package ca.infoway.messagebuilder.generator.report;

import ca.infoway.messagebuilder.generator.java.MatchType;
import ca.infoway.messagebuilder.generator.java.MessagePartMatcher;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.Relationship;

public class MessagePartReportMatcher {
	
	private MessagePartMatcher matcher;

	public MessagePartReportMatcher(MessagePart baseline) {
		this.matcher = new MessagePartMatcher(baseline);
	}
	
	public Style getBusinessNameMatchStyle(MessagePart other) {
		return toStyle(this.matcher.matchesBusinessName(other.getDocumentation())); 
	}

	public Style getBusinessNameMatchStyle(Relationship relationship) {
		return toStyle(this.matcher.matchesBusinessName(relationship));
	}

	public Style getTypeMatchStyle(Relationship relationship) {
		return toStyle(this.matcher.matchesType(relationship));
	}
	
	private Style toStyle(MatchType matchType) {
		switch (matchType) {
		case EXACT:
			return Style.NO_DIFFERENCE;
		case MINOR_DIFFERENCE:
			return Style.MINOR_DIFFERENCE;
		case MAJOR_DIFFERENCE:
		case ADDED:
		case REMOVED:
		default:
			return Style.DIFFERENCE;
		}
	}
}
