/**
 * Copyright 2011 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.generator.report;

import ca.infoway.messagebuilder.generator.java.MatchType;
import ca.infoway.messagebuilder.generator.java.MessagePartMatcher;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.Relationship;

public class MessagePartReportMatcher {
	
	private MessagePartMatcher matcher;
	private final MessagePart baseline;

	public MessagePartReportMatcher(MessagePart baseline) {
		this.baseline = baseline;
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
	
	public Style getConformanceMatchStyle(Relationship relationship) {
		return toStyle(this.matcher.matchesConformance(relationship));
	}
	
	public Style getCardinalityMatchStyle(Relationship relationship) {
		return toStyle(this.matcher.matchesCardinality(relationship));
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

	protected MessagePart getBaseline() {
		return this.baseline;
	}
}
