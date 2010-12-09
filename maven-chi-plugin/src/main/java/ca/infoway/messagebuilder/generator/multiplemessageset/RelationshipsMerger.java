package ca.infoway.messagebuilder.generator.multiplemessageset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.generator.java.MatchType;
import ca.infoway.messagebuilder.generator.java.NameMatcher;
import ca.infoway.messagebuilder.xml.Relationship;

class RelationshipsMerger implements Merger<List<Relationship>> {

	private final MergeContext context;
	private final MessageSetMergeHelper mergeHelper;
	private final boolean forChoice;
	private List<Relationship> result;
	
	private static final NameMatcher NAME_MATCHER = new NameMatcher(); 

	RelationshipsMerger(MergeContext context, boolean forChoice) {
		this.context = context;
		this.forChoice = forChoice;
		this.mergeHelper = new MessageSetMergeHelper();
	}

	public List<Relationship> merge(List<Relationship> relationships1, List<Relationship> relationships2) {
		this.result = new ArrayList<Relationship>();
		// hmmm - will order matter? Likely not, as we will only be using this merged messageset for api generation, not to produce a message or for validation 
		Map<String, Relationship> relationships2Map = new LinkedHashMap<String, Relationship>();
		for (Relationship relationship : relationships2) {
			relationships2Map.put(relationship.getName(), relationship);
		}
		
		checkForDuplicateTypes(relationships1);
		
		for (Relationship relationship1 : relationships1) {
			Relationship relationship2 = pullOutMatchingRelationship(relationship1,	relationships2Map);
			Relationship mergedRelationship = createRelationshipMerger().merge(relationship1, relationship2);
			this.result.add(mergedRelationship);
		}
		
		for (Relationship relationship : relationships2Map.values()) {
			Relationship mergedRelationship = createRelationshipMerger().merge(null, relationship);
			this.result.add(mergedRelationship);
		}
		
		return this.result;
	}

	private void checkForDuplicateTypes(List<Relationship> relationships1) {
		Set<String> types = new HashSet<String>();
		for (Relationship relationship : relationships1) {
			if (relationship.isAssociation() && StringUtils.isNotBlank(relationship.getType()) && !types.add(relationship.getType())) {
				this.context.logError("Found more than one type match in primary messageset for relationship " + relationship.getName() + " on part " + this.context.getCurrentMessagePart());
				break;
			}
		}
	}

	private Relationship pullOutMatchingRelationship(Relationship relationship1, Map<String, Relationship> relationships2Map) {
		Relationship matchResult = null;
		
		// first look for a match based on relationship name, but only where type is a true match or small change (package or numeric suffix)
		if (relationships2Map.containsKey(relationship1.getName())) {
			String type1 = relationship1.getType();
			if (relationship1.isAssociation() && StringUtils.isNotBlank(type1)) {
				Relationship relationship2 = relationships2Map.get(relationship1.getName());
				String potentialTypeMatch = relationship2.getType();
				MatchType matchType = NAME_MATCHER.matchNames(new NamedTypeImpl(relationship1.getType()), new NamedTypeImpl(potentialTypeMatch));
				if (matchType == MatchType.EXACT || matchType == MatchType.MINOR_DIFFERENCE) {
					matchResult = relationship2;
				}
			}
		}
		
		// look for a type match next - only for associations, and only if there is a unique match
		if (matchResult == null) {
			String type1 = relationship1.getType();
			if (relationship1.isAssociation() && StringUtils.isNotBlank(type1)) {
				for (Relationship relationship2 : relationships2Map.values()) {
					String type2 = relationship2.getType();
					if (StringUtils.equals(type1, type2)) {
						if (matchResult != null) {
							// found more than one type match. Hmmmm....
							// (but what if relationship1's message part has a duplicated type in its associations???)
							this.context.logError("Found more than one type match in secondary messageset for relationship " + relationship1.getName() + " on part " + this.context.getCurrentMessagePart());
							matchResult = null;
							break;
						}
						matchResult = relationship2;
					}
				}
			}
		}
		
		if (matchResult == null) {
			matchResult = relationships2Map.remove(relationship1.getName());
		} else {
			relationships2Map.remove(matchResult.getName());
		}
		return matchResult;
	}

	Merger<Relationship> createRelationshipMerger() {
		return this.forChoice ? new ChoiceMerger(this.context) : new RelationshipMerger(this.context);
	}

}
