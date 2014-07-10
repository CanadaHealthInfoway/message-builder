/**
 * Copyright 2013 Canada Health Infoway, Inc.
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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.generator.lang;

import static org.apache.commons.lang.StringUtils.equalsIgnoreCase;
import static org.apache.commons.lang.StringUtils.trimToEmpty;
import ca.infoway.messagebuilder.generator.util.MatchType;
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

	public MatchType matchesConformance(Relationship relationship) {
		Relationship baselineRelationship = getBaselineRelationship(relationship.getName());
		return this.matcher.matchesConformance(baselineRelationship, relationship);
	}

	public MatchType matchesCardinality(Relationship relationship) {
		Relationship baselineRelationship = getBaselineRelationship(relationship.getName());
		return this.matcher.matchesCardinality(baselineRelationship, relationship);
	}
}
