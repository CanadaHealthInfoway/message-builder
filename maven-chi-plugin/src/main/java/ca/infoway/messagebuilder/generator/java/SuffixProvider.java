package ca.infoway.messagebuilder.generator.java;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class SuffixProvider {
	
	private Map<String,Integer> suffix = Collections.synchronizedMap(new HashMap<String, Integer>());
	
	String getSuffix(String name) {
		if (!this.suffix.containsKey(name)) {
			this.suffix.put(name, 1);
			return "_" + 1;
		} else {
			int number = this.suffix.get(name) + 1;
			this.suffix.put(name, number);
			return "_" + number;
		}
	}
}
