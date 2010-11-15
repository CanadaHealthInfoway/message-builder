package ca.infoway.messagebuilder.xml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

/**
 * <p>Documentation about a particular HL7 construct.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
@Root
public class Documentation {
	
	@Element(required=false)
	private String title;
	@Element(required=false)
	private String businessName;
	
	@ElementList(required=false,inline=true,entry="p")
	private List<String> paragraphs = new ArrayList<String>();

	/**
	 * <p>Standard constructor.
	 */
	public Documentation() {
	}
	/**
	 * <p>Standard constructor.
	 * @param paragraphs - paragraphs of documentation.
	 */
	public Documentation(List<String> paragraphs) {
		if (paragraphs != null) {
			this.paragraphs.addAll(paragraphs);
		}
	}
	/**
	 * <p>Standard constructor.
	 * @param paragraphs - paragraphs of documentation.
	 */
	public Documentation(String... paragraphs) {
		if (!ArrayUtils.isEmpty(paragraphs)) {
			this.paragraphs.addAll(Arrays.asList(paragraphs));
		}
	}
	
	/**
	 * <p>Get the paragraphs of documentation.
	 * @return - the paragraphs of documentation.
	 */
	public List<String> getParagraphs() {
		return this.paragraphs;
	}

	/**
	 * <p>Set the paragraphs.
	 * @param paragraphs - the new paragraphs of documentation.
	 */
	public void setParagraphs(List<String> paragraphs) {
		this.paragraphs = paragraphs;
	}
	
	/**
	 * <p>Get the title.
	 * @return - the title.
	 */
	public String getTitle() {
		return this.title;
	}
	/**
	 * <p>Set the title.
	 * @param title - the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * <p>Get the business name.
	 * @return the business name
	 */
	public String getBusinessName() {
		return this.businessName;
	}
	/**
	 * <p>Set the business name.
	 * @param businessName - the new business name
	 */
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
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
			Documentation that = (Documentation) obj;
			return new EqualsBuilder()
					.append(this.businessName, that.businessName)
					.append(this.title, that.title)
					.append(this.getParagraphs(), that.getParagraphs())
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
		.append(this.businessName)
		.append(this.title)
		.append(this.getParagraphs())
		.toHashCode();
	}
	
}
