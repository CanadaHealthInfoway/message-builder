package ca.infoway.messagebuilder.xml;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>A class that models the annotation documentation.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
@Root
public class Annotation {

	@Element(required=false, data=true)
	private String text;
	
	@Attribute(required=false)
	private String annotationType;
	
	/**
	 * <p>Standard constructor.
	 */	
	public Annotation() {
	}
	
	/**
	 * <p>Standard constructor.
	 * @param text - The text description of the annotation.
	 */	
	public Annotation(String text) {
		this.text = text;
	}

	/**
	 * <p>Get the text.
	 * @return - the text.
	 */	
	public String getText() {
		return text;
	}

	/**
	 * <p> Set the text
	 * @param text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * <p>Get the annotation Type
	 * @return annotation Type
	 */
	public AnnotationType getAnnotationType() {
		if (this.annotationType != null) {
			return EnumPattern.valueOf(AnnotationType.class, this.annotationType);
		}
		return null;
	}

	/**
	 * <p>Set the annotation Type
	 * @param annotationType
	 */
	public void setAnnotationType(AnnotationType annotationType) {
		this.annotationType = annotationType == null ? null : annotationType.getName();
	}
}
