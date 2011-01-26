package ca.infoway.messagebuilder.xml;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
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
	
	@Attribute(required=false)
	private String sourceName;
	
	@Attribute(required=false)
	private String otherAnnotationType;
	
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

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getOtherAnnotationType() {
		return otherAnnotationType;
	}

	public void setOtherAnnotationType(String otherAnnotationType) {
		this.otherAnnotationType = otherAnnotationType;
	}

	public void setAnnotationType(String annotationType) {
		this.annotationType = annotationType;
	}
	
	/**
	 * <p>Standard equals implementation.
	 * 
	 * @param obj - the other object
	 * @return true if the objects are equal; false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (getClass() != obj.getClass()) {
			return false;
		} else {
			Annotation that = (Annotation) obj;
			return new EqualsBuilder()
					.append(this.text, that.text)
					.append(this.annotationType, that.annotationType)
					.append(this.otherAnnotationType, that.otherAnnotationType)
					.append(this.sourceName, that.sourceName)
					.isEquals();
		}
	}
	
	/**
	 * <p>Standard hash code method.
	 * @return the hash code
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
		.append(this.text)
		.append(this.annotationType)
		.append(this.otherAnnotationType)
		.append(this.sourceName)
		.toHashCode();
	}
}
