package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.LogLevel.DEBUG;

import java.util.ArrayList;
import java.util.List;

import ca.infoway.messagebuilder.generator.LogUI;


abstract class Case3Matcher {
	
	private final LogUI log;
	protected final SimplifiableTypeProvider definitions;
	
	Case3Matcher(LogUI log, SimplifiableTypeProvider definitions) {
		this.log = log;
		this.definitions = definitions;
	}
	
	abstract String getDescription();
	abstract boolean performMatching(SimplifiableType type, List<SimplifiableType> types);

	private List<SimplifiableType> getAllSimplifiableTypes() {
		return new ArrayList<SimplifiableType>(this.definitions.getAllTypes());
	}

	boolean matchAllTypes() {
		boolean changes = false;
		List<SimplifiableType> types = getAllSimplifiableTypes();
		while (!types.isEmpty()) {
			SimplifiableType type = types.remove(0);
			
			changes |= performMatching(type, types);
			this.log.log(DEBUG, "Simplification case 3: Now analyzing " + type.getTypeName() + ". " +
					(changes ? "Candidate for simplification" : ""));
		}
		return changes;
	}
}
