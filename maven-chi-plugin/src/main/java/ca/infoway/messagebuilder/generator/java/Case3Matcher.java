package ca.infoway.messagebuilder.generator.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


abstract class Case3Matcher {
	
	protected final SimplifiableTypeProvider definitions;
	Case3Matcher(SimplifiableTypeProvider definitions) {
		this.definitions = definitions;
	}
	
	abstract String getDescription();
	abstract boolean performMatching(SimplifiableType type);

	protected List<SimplifiableType> getAllSimplifiableTypes() {
		ArrayList<SimplifiableType> list = new ArrayList<SimplifiableType>(this.definitions.getAllTypes());
		Collections.reverse(list);
		return list;
	}
}
