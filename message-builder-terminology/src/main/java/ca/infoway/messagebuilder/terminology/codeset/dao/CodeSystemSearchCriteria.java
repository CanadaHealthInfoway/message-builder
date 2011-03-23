package ca.infoway.messagebuilder.terminology.codeset.dao;

import java.util.Collection;

/**
 * <p>The Class CodeSystemSearchCriteria. Used for various Hibernate queries.
 *
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class CodeSystemSearchCriteria {
	
	private String oid;
	private String name;
	private String description;

	private String oidStartsWithExclusion;
	private String nameStartsWithExclusion;
	private Collection<String> oidExlusions; 
	
	/**
	 * <p>Gets the oid.
	 *
	 * @return the oid
	 */
	public String getOid() {
		return this.oid;
	}
	
	/**
	 * <p>Sets the oid.
	 *
	 * @param oid the new oid
	 */
	public void setOid(String oid) {
		this.oid = oid;
	}
	
	/**
	 * <p>Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * <p>Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
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

	/**
	 * <p>Gets the oid starts with exclusion.
	 *
	 * @return the oid starts with exclusion
	 */
	public String getOidStartsWithExclusion() {
		return oidStartsWithExclusion;
	}
	
	/**
	 * <p>Sets the oid starts with exclusion.
	 *
	 * @param oidStartsWithExclusion the new oid starts with exclusion
	 */
	public void setOidStartsWithExclusion(String oidStartsWithExclusion) {
		this.oidStartsWithExclusion = oidStartsWithExclusion;
	}
	
	/**
	 * <p>Gets the name starts with exclusion.
	 *
	 * @return the name starts with exclusion
	 */
	public String getNameStartsWithExclusion() {
		return nameStartsWithExclusion;
	}
	
	/**
	 * <p>Sets the name starts with exclusion.
	 *
	 * @param nameStartsWithExclusion the new name starts with exclusion
	 */
	public void setNameStartsWithExclusion(String nameStartsWithExclusion) {
		this.nameStartsWithExclusion = nameStartsWithExclusion;
	}
	
	/**
	 * <p>Gets the oid exlusions.
	 *
	 * @return the oid exlusions
	 */
	public Collection<String> getOidExlusions() {
		return oidExlusions;
	}
	
	/**
	 * <p>Sets the oid exlusions.
	 *
	 * @param oidExlusions the new oid exlusions
	 */
	public void setOidExlusions(Collection<String> oidExlusions) {
		this.oidExlusions = oidExlusions;
	}
	
	/**
	 * <p>Adds the extra exclusions.
	 *
	 * @param nameStartsWithExclusion the name starts with exclusion
	 * @param oidStartsWithExclusion the oid starts with exclusion
	 * @param oidExlusions the oid exlusions
	 */
	public void addExtraExclusions(String nameStartsWithExclusion, String oidStartsWithExclusion, Collection<String> oidExlusions) {
		this.nameStartsWithExclusion = nameStartsWithExclusion;
		this.oidStartsWithExclusion = oidStartsWithExclusion;
		this.oidExlusions = oidExlusions;
	}
}
