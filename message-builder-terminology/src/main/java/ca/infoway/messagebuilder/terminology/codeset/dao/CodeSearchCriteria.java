package ca.infoway.messagebuilder.terminology.codeset.dao;

import java.io.Serializable;

/**
 * <p>The Class CodeSearchCriteria. A convenience class for holding multiple code-based search criteria, used 
 * in some code dao methods.
 *
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class CodeSearchCriteria implements Serializable {
	
	private static final long serialVersionUID = -3694921628293905050L;

	private String type;
	private String businessName;
	private String description;

	/**
	 * <p>Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * <p>Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * <p>Gets the business name.
	 *
	 * @return the business name
	 */
	public String getBusinessName() {
		return this.businessName;
	}
	
	/**
	 * <p>Sets the business name.
	 *
	 * @param businessName the new business name
	 */
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	
	/**
	 * <p>Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * <p>Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
}
