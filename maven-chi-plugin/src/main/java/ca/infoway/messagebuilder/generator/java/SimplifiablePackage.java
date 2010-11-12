package ca.infoway.messagebuilder.generator.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SimplifiablePackage {

	private final String name;
	private final List<SimplifiableType> types = Collections.synchronizedList(new ArrayList<SimplifiableType>());

	SimplifiablePackage(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public List<SimplifiableType> getTypes() {
		return this.types;
	}
	
}
