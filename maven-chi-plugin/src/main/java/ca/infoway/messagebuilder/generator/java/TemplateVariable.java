package ca.infoway.messagebuilder.generator.java;


public class TemplateVariable {

	private final String type;

	public TemplateVariable(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}
	@Override
	public String toString() {
		return "<" + getType() + ">";
	}

}
