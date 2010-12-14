package ca.infoway.messagebuilder.generator.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ca.infoway.messagebuilder.generator.dependency.DependencyTracker;
import ca.infoway.messagebuilder.xml.Difference;
import ca.infoway.messagebuilder.xml.DifferenceType;
import ca.infoway.messagebuilder.xml.DifferenceValue;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.intelliware.commons.dependency.Node;

class ForcedMatchManager implements Fuzziness {

	private final SimplifiableDefinitions definitions;
	Set<String> parts = new HashSet<String>();
	Set<Tuple<String>> specificMatches = new HashSet<Tuple<String>>();
	private final DependencyTracker tracker;

	public ForcedMatchManager(SimplifiableDefinitions definitions) {
		this.definitions = definitions;
		for (SimplifiableType simplifiableType : this.definitions.getAllTypes()) {
			for (Relationship relationship : simplifiableType.getMessagePart().getRelationships()) {
				if (DifferenceHelper.hasDifferenceOfType(relationship, DifferenceType.ASSOCIATION_TYPE)) {
					getAllNecessaryMerges(relationship);
				}
			}
		}
		
		this.tracker = DependencyTracker.create(this.definitions);
		for (String part : new HashSet<String>(this.parts)) {
			Node<String> node = this.tracker.getPrimaryLayeredGraph().getNode(part);
			this.parts.addAll(node.getEfferentCouplings());
		}
	}

	private void getAllNecessaryMerges(Relationship relationship) {
		List<String> differences = new ArrayList<String>();
		Difference difference = DifferenceHelper.getDifferenceByType(relationship, DifferenceType.ASSOCIATION_TYPE);
		for (DifferenceValue value : difference.getDifferences()) {
			this.parts.add(value.getValue());
			differences.add(value.getValue());
		}
		recordRequiredMatches(differences);
	}

	private void recordRequiredMatches(List<String> differences) {
		Collections.sort(differences);
		
		while (!differences.isEmpty()) {
			String element = differences.remove(0);
			for (String other : differences) {
				this.specificMatches.add(new Tuple<String>(element, other));
			}
		}
	}

	public boolean isWorthChecking(SimplifiableType type, SimplifiableType otherType) {
		return isInteresting(type) && isInteresting(otherType);
	}

	private boolean isInteresting(SimplifiableType type) {
		return isInteresting(type.getName());
	}

	private boolean isInteresting(String name) {
		return this.parts.contains(name);
	}

	public boolean isSufficientOverlap(List<MatchType> matchTypes) {
		return matchTypes.contains(MatchType.EXACT) && !matchTypes.contains(MatchType.MAJOR_DIFFERENCE);
	}

	public Set<Tuple<String>> getSpecificMatches() {
		return this.specificMatches;
	}
}
