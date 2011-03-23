package ca.infoway.messagebuilder.generator.regen;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ca.infoway.messagebuilder.generator.java.BaseRelationship;
import ca.infoway.messagebuilder.generator.java.Type;


public abstract class NameBasedDeltaCalculator implements DeltaCalculator {

	public Set<Delta> calculate(RelationshipsMergerContext context, Type oldType, Type newType) {
		Set<Delta> results = new HashSet<Delta>();
		Map<String, BaseRelationship> relationshipsByName = createNameBasedMap(newType.getRelationships());
		for (BaseRelationship oldRelationship : oldType.getRelationships()) {
			BaseRelationship newRelationship = relationshipsByName.get(oldRelationship.getName());
			if (newRelationship != null) {
				Delta delta = doFindDelta(context, oldRelationship, newRelationship);
				if (delta != null) {
					results.add(delta);
				}
			}
		}
		return results;
	}

	private HashMap<String, BaseRelationship> createNameBasedMap(List<BaseRelationship> relationships) {
		HashMap<String, BaseRelationship> map = new HashMap<String, BaseRelationship>();
		for (BaseRelationship relationship : relationships) {
			map.put(relationship.getName(), relationship);
		}
		return map;
	}

	protected abstract Delta doFindDelta(RelationshipsMergerContext context, BaseRelationship oldRelationship, BaseRelationship newRelationship);

}
