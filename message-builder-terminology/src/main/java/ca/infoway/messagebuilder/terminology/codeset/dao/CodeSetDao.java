package ca.infoway.messagebuilder.terminology.codeset.dao;

import java.util.List;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.terminology.codeset.domain.CodedValue;
import ca.infoway.messagebuilder.terminology.codeset.domain.ValueSetEntry;
import ca.infoway.messagebuilder.terminology.codeset.domain.VocabularyDomain;

/**
 * <p>Defines the interface for performing database searches against the Code Set model.
 *
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public interface CodeSetDao {
	
	/**
	 * <p>Find value by code system.
	 *
	 * @param vocabularyDomainType the vocabulary domain type
	 * @param code the code
	 * @param codeSystemOid the code system oid
	 * @return the value set entry
	 */
	public ValueSetEntry findValueByCodeSystem(Class<?> vocabularyDomainType, String code, String codeSystemOid);
	
	/**
	 * <p>Select value sets by code.
	 *
	 * @param vocabularyDomainType the vocabulary domain type
	 * @param code the code
	 * @return the list
	 */
	public List<ValueSetEntry> selectValueSetsByCode(Class<?> vocabularyDomainType, String code);
	
	/**
	 * <p>Select value sets by vocabulary domain.
	 *
	 * @param vocabularyDomainType the vocabulary domain type
	 * @return the list
	 */
	@Deprecated
	public List<ValueSetEntry> selectValueSetsByVocabularyDomain(Class<?> vocabularyDomainType);
	
	/**
	 * <p>Select value sets by vocabulary domain.
	 *
	 * @param vocabularyDomainType the vocabulary domain type
	 * @return the list
	 */
	public List<ValueSetEntry> selectValueSetsByVocabularyDomain(String vocabularyDomainType);
	
	/**
	 * <p>Select value sets by vocabulary domain.
	 *
	 * @param jurisdictionCode the jurisdiction code
	 * @param vocabularyDomainType the vocabulary domain type
	 * @return the list
	 */
	public List<ValueSetEntry> selectValueSetsByVocabularyDomain(String jurisdictionCode, VocabularyDomain vocabularyDomainType);
	
	/**
	 * <p>Select coded values by vocabulary domain.
	 *
	 * @param vocabularyDomainType the vocabulary domain type
	 * @return the list
	 */
	@Deprecated
	public List<CodedValue> selectCodedValuesByVocabularyDomain(Class<?> vocabularyDomainType);
	
	/**
	 * <p>Select all vocabulary domains.
	 *
	 * @return the list
	 */
	public List<VocabularyDomain> selectAllVocabularyDomains();
	
	/**
	 * <p>Select vocabulary domain.
	 *
	 * @param type the type
	 * @return the vocabulary domain
	 */
	public VocabularyDomain selectVocabularyDomain(String type);
	
	/**
	 * <p>Select vocabulary domains.
	 *
	 * @param searchCriteria the search criteria
	 * @return the list
	 */
	public List<VocabularyDomain> selectVocabularyDomains(CodeSearchCriteria searchCriteria);
	
	/**
	 * <p>Find coded value.
	 *
	 * @param code the code
	 * @return the coded value
	 */
	public CodedValue findCodedValue(Code code);
}
