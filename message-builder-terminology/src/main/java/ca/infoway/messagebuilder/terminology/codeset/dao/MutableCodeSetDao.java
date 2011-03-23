package ca.infoway.messagebuilder.terminology.codeset.dao;

import java.util.Collection;
import java.util.List;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.terminology.codeset.domain.CodeSystem;
import ca.infoway.messagebuilder.terminology.codeset.domain.CodedValue;
import ca.infoway.messagebuilder.terminology.codeset.domain.ValueSet;
import ca.infoway.messagebuilder.terminology.codeset.domain.ValueSetEntry;
import ca.infoway.messagebuilder.terminology.codeset.domain.VocabularyDomain;

/**
 * <p>A Data-access-object interface for updating records in the 
 * code tables.  In general, the methods provided by this interface should
 * not be invoked by applications that require only code resolution.  
 * This API exists to support things like loading the values.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public interface MutableCodeSetDao extends CodeSetDao {
	
	/**
	 * <p>Find code system.
	 *
	 * @param oid the oid
	 * @return the code system
	 */
	public CodeSystem findCodeSystem(String oid);
	
	/**
	 * <p>Gets the all code systems.
	 *
	 * @return the all code systems
	 */
	public List<CodeSystem> getAllCodeSystems();
	
	/**
	 * <p>Find code systems.
	 *
	 * @param searchCriteria the search criteria
	 * @return the list
	 */
	public List<CodeSystem> findCodeSystems(CodeSystemSearchCriteria searchCriteria);
	
	/**
	 * <p>Find code systems.
	 *
	 * @param searchCriteria the search criteria
	 * @param startRow the start row
	 * @param endRow the end row
	 * @return the list
	 */
	public List<CodeSystem> findCodeSystems(final CodeSystemSearchCriteria searchCriteria, final int startRow, final int endRow);
	
	/**
	 * <p>Count code systems.
	 *
	 * @param searchCriteria the search criteria
	 * @return the int
	 */
	public int countCodeSystems(final CodeSystemSearchCriteria searchCriteria);
	
	/**
	 * <p>Save all.
	 *
	 * @param vocabularyDomain the vocabulary domain
	 */
	public void saveAll(Collection<VocabularyDomain> vocabularyDomain);
	
	/**
	 * <p>Save all coded values.
	 *
	 * @param values the values
	 */
	public void saveAllCodedValues(Collection<CodedValue> values);
	
	/**
	 * <p>Find value set entry.
	 *
	 * @param valueSetName the value set name
	 * @param code the code
	 * @return the value set entry
	 */
	public ValueSetEntry findValueSetEntry(String valueSetName, Code code);
	
	/**
	 * <p>Find value set.
	 *
	 * @param name the name
	 * @return the value set
	 */
	public ValueSet findValueSet(String name);
	
	/**
	 * <p>Save.
	 *
	 * @param valueSet the value set
	 */
	public void save(ValueSetEntry valueSet);
	
	/**
	 * <p>Save value set.
	 *
	 * @param valueSet the value set
	 */
	public void saveValueSet(ValueSet valueSet);
}
