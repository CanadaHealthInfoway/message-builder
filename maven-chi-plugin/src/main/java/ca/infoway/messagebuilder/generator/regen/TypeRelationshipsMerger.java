package ca.infoway.messagebuilder.generator.regen;

import java.util.List;
import java.util.Set;

import ca.infoway.messagebuilder.generator.java.BaseRelationship;
import ca.infoway.messagebuilder.generator.java.Type;

public class TypeRelationshipsMerger {

	private final Type oldType;
	private final Type newType;
	private final List<DeltaCalculator> deltaCalculators;
	private final DeltaCalculator nameDeltaCalculator;
	
	public TypeRelationshipsMerger(Type oldType, Type newType) {
		this(oldType, newType, DeltaCalculators.allNameBasedCalculators(), new NameDeltaCalculator());
	}

	TypeRelationshipsMerger(Type oldType, Type newType, List<DeltaCalculator> deltaCalculators, DeltaCalculator nameDeltaCalculator) {
		this.oldType = oldType;
		this.newType = newType;
		this.deltaCalculators = deltaCalculators;
		this.nameDeltaCalculator = nameDeltaCalculator;
	}
	
	public void mergeInto(Type mergedType) {
		RelationshipsMergerContext context = new RelationshipsMergerContext(mergedType);
		addOldTypeRelationships(mergedType);
		firstPass(context);
		if (calculateNameDeltas(context)) {
//			secondPass(context);
		}
		applyDeltas(context);
		addUnMergedNewTypeRelationships(mergedType);
	}

	private void addUnMergedNewTypeRelationships(Type type) {
		for (BaseRelationship relationship : this.newType.getRelationships()) {
			if (type.getRelationship(relationship.getName())==null) {
				type.getRelationships().add(relationship);
			}
		}
	}

	private void addOldTypeRelationships(Type type) {
		for (BaseRelationship oldTypeRelationship : this.oldType.getRelationships()) {
			type.getRelationships().add(oldTypeRelationship);
		}
	}

	private boolean calculateNameDeltas(RelationshipsMergerContext context) {
		Set<Delta> deltas = this.nameDeltaCalculator.calculate(context, this.oldType, this.newType);
		context.getDeltas().addAll(deltas);
		return !deltas.isEmpty();
	}

	private void applyDeltas(RelationshipsMergerContext context) {
		for (Delta delta : context.getDeltas()) {
			delta.apply(context);
		}
	}

	private void firstPass(RelationshipsMergerContext context) {
		calculateDeltas(context);
	}

	private void calculateDeltas(RelationshipsMergerContext context) {
		for (DeltaCalculator deltaCalculator : this.deltaCalculators) {
			Set<Delta> deltas = deltaCalculator.calculate(context, this.oldType, this.newType);
			context.getDeltas().addAll(deltas);
		}
	}

//	private void secondPass(RelationshipsMergerContext context) {
//		calculateDeltas(context);
//	}

}
