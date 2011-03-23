package ca.infoway.messagebuilder.generator.regen;

import java.util.LinkedHashSet;
import java.util.Set;

import ca.infoway.messagebuilder.generator.java.Type;

public class RelationshipsMergerContext {
	
	private final Set<Delta> deltas = new LinkedHashSet<Delta>();
	private final Type mergedType;

	public RelationshipsMergerContext(Type mergedType) {
		this.mergedType = mergedType;
	}

	public Set<Delta> getDeltas() {
		return this.deltas;
	}

	public Type getMergedType() {
		return this.mergedType;
	}

}
