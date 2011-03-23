package ca.infoway.messagebuilder.generator.java;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import ca.infoway.messagebuilder.xml.TypeName;


public class ComplexTypePackage {

	protected Map<String,Type> types = Collections.synchronizedMap(new TreeMap<String,Type>());
	private final TypeName name;

    public ComplexTypePackage(TypeName name) {
		this.name = name;
    }

	public void addInnerClass(String typeName, Type type) {
	    this.types.put(typeName, type);
	}

	public Map<String, Type> getTypes() {
	    return this.types;
	}

	public TypeName getName() {
		return this.name;
	}

	public void removeInnerClass(TypeName name) {
		this.types.remove(name.getName());
	}
	
}
