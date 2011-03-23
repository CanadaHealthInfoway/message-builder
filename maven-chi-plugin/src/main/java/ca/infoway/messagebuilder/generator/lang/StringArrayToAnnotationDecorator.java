package ca.infoway.messagebuilder.generator.lang;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

public class StringArrayToAnnotationDecorator implements Decorator {

	private final String[] array;

	public StringArrayToAnnotationDecorator(String... array) {
		this.array = array;
	}
	
	public String render() {
		if (ArrayUtils.getLength(this.array) == 0) {
			return "";
		} else {
			return "\"" + StringUtils.join(this.array,  "\",\"") + "\"";
		}
	}
}
