package ca.infoway.messagebuilder.generator.regen;

import java.util.Set;

import com.google.common.collect.Sets;

public class TypeDeltaApplicators {

	public static Set<TypeDeltaApplicator> allApplicators() {
		return Sets.<TypeDeltaApplicator>newHashSet(
				new DataTypeChangedToFromSetOrListTypeDeltaApplicator());
	}

}
