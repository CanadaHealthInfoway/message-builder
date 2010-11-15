package ca.infoway.messagebuilder.xml;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root
@Namespace(prefix="regen",reference="regen_ns")
public class DifferenceValue {

	@Attribute
	private String version;
	@Attribute
	private String value;

	public DifferenceValue() {
	}
	public DifferenceValue(String version, String value) {
		this.version = version;
		this.value = value;
	}
	
	/**
	 * The messageset version this difference applies to .
	 * 
	 * @return the version
	 */
	public String getVersion() {
		return this.version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
	/**
	 * The value that is different.
	 * 
	 * @return the value
	 */
	public String getValue() {
		return this.value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
