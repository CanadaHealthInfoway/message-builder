package ca.infoway.messagebuilder.generator.java;

public class Choice {
	
	private final String name;
	private final Type type;

	Choice(String name, Type type) {
		this.name = name;
		this.type = type;
	}
	public String getName() {
		return this.name;
	}
	public Type getType() {
		return this.type;
	}
}
