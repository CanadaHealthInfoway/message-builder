package ca.infoway.messagebuilder.generator.multiplemessageset;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import ca.infoway.messagebuilder.xml.Relationship;

class RelationshipsMerger implements Merger<List<Relationship>> {

	private final MergeContext context;
	private final MessageSetMergeHelper mergeHelper;
	private final boolean forChoice;
	private List<Relationship> result;

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
		
		for (Relationship relationship1 : relationships1) {
			Relationship relationship2 = relationships2Map.remove(relationship1.getName());
			Relationship mergedRelationship = createRelationshipMerger().merge(relationship1, relationship2);
			this.result.add(mergedRelationship);
		}
		
		for (Relationship relationship : relationships2Map.values()) {
			Relationship mergedRelationship = createRelationshipMerger().merge(null, relationship);
			this.result.add(mergedRelationship);
		}
		
		return this.result;
	}

	Merger<Relationship> createRelationshipMerger() {
		return this.forChoice ? new ChoiceMerger(this.context) : new RelationshipMerger(this.context);
	}

}
