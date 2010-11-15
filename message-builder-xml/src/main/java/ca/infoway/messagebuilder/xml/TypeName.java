package ca.infoway.messagebuilder.xml;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * <p>The type name.
 * 
 * <p>A typical name looks like this: <code>REPC_IN002620.ControlActProcess</code> .
 * The parent of this name would be <code>REPC_IN002620</code>
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class TypeName {

	public static final String PART_SEPARATOR = ".";
	private final String name;

	/**
	 * <p>Standard constructor.
	 * @param name - the name of the type
	 */
	public TypeName(String name) {
		this.name = name!=null ? name.replace('$', '.') : name;
	}

	/**
	 * <p>The number of parts (separated by the period character) in the name.
	 * @return - the number of parts
	 */
	public int getPartCount() {
		return StringUtils.split(this.name, PART_SEPARATOR).length;
	}
	
	/**
	 * <p>Get a flag indicating whether or not the type name represents a top-most type.
	 * @return true if the relationship is a top-level type; false otherwise.
	 */
	public boolean isRoot() {
		return getRootName() == this;
	}

	/**
	 * <p>Get the name of the top-level type.  For example the root name of 
	 * "PRPA_MT101103CA.ParameterList" is "PRPA_MT101103CA".  The root name
	 * of "PRPA_MT101103CA" is "PRPA_MT101103CA".
	 * @return the root name.
	 */
	public TypeName getRootName() {
		if (this.name.contains(PART_SEPARATOR)) {
			return new TypeName(StringUtils.substringBefore(this.name, PART_SEPARATOR));
		} else {
			return this;
		}
	}
	/**
	 * <p>Get the name of the parent type.  For example the parent name of 
	 * "PRPA_MT101103CA.ParameterList" is "PRPA_MT101103CA".  The parent name
	 * of "PRPA_MT101103CA" is "".
	 * @return - the parent name
	 */
	public TypeName getParent() {
		if (this.name.contains(PART_SEPARATOR)) {
			return new TypeName(StringUtils.substringBeforeLast(this.name, PART_SEPARATOR));
		} else {
			return new TypeName("");
		}
	}
	
	/**
	 * <p>Standard equals method.
	 * @param obj - the other object
	 * @return true if this object equals the parameter; false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (getClass() != obj.getClass()) {
			return false;
		} else {
			TypeName that = (TypeName) obj;
			return new EqualsBuilder()
					.append(this.name, that.name)
					.isEquals();
		}
	}
	
	/**
	 * <p>Standard hash code method.
	 * @return the hash code
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.name).toHashCode();
	}

	/**
	 * <p>Get the name.
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * <p>Gets the unqualified part name.  For example the unqualified name of 
	 * "PRPA_MT101103CA.ParameterList" is "ParameterList".  The unqualified name
	 * of "PRPA_MT101103CA" is "PRPA_MT101103CA".
	 * @return the unqualified name
	 */
	public String getUnqualifiedName() {
		if (getPartCount() > 1) {
			return StringUtils.substringAfterLast(this.name, PART_SEPARATOR);
		} else if (getPartCount() == 1) {
			return this.name;
		} else {
			return "";
		}
	}
	/**
	 * <p>Standard toString method.
	 * @return the type name
	 */
	@Override
	public String toString() {
		return getName();
	}

	/**
	 * <p>Get a flag indicating whether or not a type name is an interaction.  
	 * Interactions tend to have '_IN' in the middle of the name.  For example, 
	 * "PRPA_IN101103CA" is an interaction name.
	 * 
	 * @return true if the type name is an interaction; false otherwise.
	 */
	public boolean isInteraction() {
		return getPartCount() == 1 && this.name.length() >= 7 
			&& "_IN".equals(this.name.substring(4, 7));
	}
}
