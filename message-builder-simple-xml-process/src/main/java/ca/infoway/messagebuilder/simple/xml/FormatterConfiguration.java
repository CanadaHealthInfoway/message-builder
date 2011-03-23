package ca.infoway.messagebuilder.simple.xml;

public class FormatterConfiguration {

	public FormatterConfiguration() {
		this(false);
	}
	
	public FormatterConfiguration(boolean isPermissive) {
		this.isPermissive = isPermissive;
	}
	
	private boolean isPermissive;

	public boolean isPermissive() {
		return this.isPermissive;
	}

	public void setPermissive(boolean isPermissive) {
		this.isPermissive = isPermissive;
	}
}
