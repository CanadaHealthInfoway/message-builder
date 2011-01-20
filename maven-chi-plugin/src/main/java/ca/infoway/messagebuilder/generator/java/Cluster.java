package ca.infoway.messagebuilder.generator.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

class Cluster {
	
	private final Set<SimplifiableType> types = Collections.synchronizedSet(new LinkedHashSet<SimplifiableType>());

	public Cluster() {
	}
	public Cluster(SimplifiableType... types) {
		this.types.addAll(Arrays.asList(types));
	}

	Set<SimplifiableType> getTypes() {
		return this.types;
	}
}
