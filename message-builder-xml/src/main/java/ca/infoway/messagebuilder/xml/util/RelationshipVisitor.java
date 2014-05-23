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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
package ca.infoway.messagebuilder.xml.util;

import java.util.ArrayList;
import java.util.List;

import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.DomainSource;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.SpecializationChild;

/**
 * @sharpen.ignore - java-only utility 
 */
public class RelationshipVisitor implements InteractionVisitor {

	public enum RelationshipType {
		ALL,
		ATTRIBUTE,
		ASSOCIATION
	}
	
	public class RelationshipSummary {
		private final String messagePart;
		private final String relationship;
		private final String domainSource;
		private final String domainType;
		private final String type;
		private final String xpath;
		private final String conformance;
		private final Relationship relationshipObject;
		  
		public RelationshipSummary(String messagePart, String relationship, String domainSource, String domainType, String type, String xpath, String conformance, Relationship relationshipObject) {
			this.messagePart = messagePart;
			this.relationship = relationship;
			this.domainSource = domainSource;
			this.domainType = domainType;
			this.type = type;
			this.xpath = xpath;
			this.conformance = conformance;
			this.relationshipObject = relationshipObject;
		}
		  
		public String getMessagePart() {
			return messagePart;
		}
		public String getRelationship() {
			return relationship;
		}
		public Relationship getRelationshipObject() {
			return relationshipObject;
		}
		public String getXpath() {
			return xpath;
		}
		public String getDomainSource() {
			return domainSource;
		}
		public String getDomainType() {
			return domainType;
		}
		public String getType() {
			return type;
		}
		public String getConformance() {
			return conformance;
		}
		
		@Override
		public String toString() {
			return this.xpath + ", " + this.getMessagePart() + "." + this.getRelationship() + ", " + this.getType() + ", " + this.getConformance();
		}
	}
	
	private List<RelationshipSummary> results;
	private final RelationshipType relationshipType;
	
	public RelationshipVisitor() {
		this(RelationshipType.ALL);
	}
	
	public RelationshipVisitor(RelationshipType relationshipType) {
		this.relationshipType = relationshipType;
		this.results = new ArrayList<RelationshipSummary>();
	}
	
	public List<RelationshipSummary> getResults() {
		return this.results;
	}

	public void visitRelationship(Relationship relationship, String xpath) {
		// only interested in relationships that are marked as having a domain
		if (isRelationshipOfInterest(relationship, this.relationshipType)) {
			this.results.add(
					new RelationshipSummary(
							relationship.getParentType(),
							relationship.getName(),
							determineDomainSource(relationship.getDomainSource()), 
							relationship.getDomainType(), 
							relationship.getType(), 
							xpath,
							determineConformance(relationship.getConformance()),
							relationship));
		}
	}

	private boolean isRelationshipOfInterest(Relationship relationship, RelationshipType relationshipType) {
		return relationshipType == RelationshipType.ALL
				|| (relationshipType == RelationshipType.ASSOCIATION && relationship.isAssociation())
				|| (relationshipType == RelationshipType.ATTRIBUTE && relationship.isAttribute());
	}

	private String determineDomainSource(DomainSource domainSource) {
		//cd for concept domain, cs for code system, and vs for value set
		String result = null;
		if (domainSource == DomainSource.CODE_SYSTEM) {
			result = "cs";
		} else if (domainSource == DomainSource.CONCEPT_DOMAIN) {
			result = "cd";
		} else if (domainSource == DomainSource.CODE_SYSTEM) {
			result = "vs";
		}
		return result;
	}
	
	private String determineConformance(ConformanceLevel conformance) {
		//cd for concept domain, cs for code system, and vs for value set
		String result = null;
		if (conformance== ConformanceLevel.IGNORED) {
			result = "I";
		} else if (conformance== ConformanceLevel.MANDATORY) {
			result = "M";
		} else if (conformance== ConformanceLevel.NOT_ALLOWED) {
			result = "NA";
		} else if (conformance== ConformanceLevel.OPTIONAL) {
			result = "O";
		} else if (conformance== ConformanceLevel.POPULATED) {
			result = "P";
		} else if (conformance== ConformanceLevel.REQUIRED) {
			result = "R";
		}	
		
		return result;
	}


	public void visitArgument(Argument argument, String xpath) {
		// not interested
	}

	
	public void visitInteraction(Interaction interaction, String xpath) {
		// not interested
	}

	public void visitMessagePart(MessagePart messagePart, String xpath) {
		// not interested
	}

	public void visitSpecializationChild(SpecializationChild specializationChild, String xpath) {
		// not interested
	}
}
