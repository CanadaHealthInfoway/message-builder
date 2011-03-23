package ca.infoway.messagebuilder.terminology.codeset;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.resolver.CodeResolver;
import ca.infoway.messagebuilder.terminology.codeset.dao.CodeSetDao;
import ca.infoway.messagebuilder.terminology.codeset.domain.CodedValue;
import ca.infoway.messagebuilder.terminology.codeset.domain.ValueSetEntry;
import ca.infoway.messagebuilder.terminology.codeset.domain.VocabularyDomain;
import ca.infoway.messagebuilder.terminology.proxy.TypedCodeFactory;

/**
 * Knows how to provide database-backed Codes.
 *
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class DatabaseCodeResolver implements CodeResolver {

	private final CodeSetDao dao;
	private final TypedCodeFactory codeFactory;

	/**
	 * <p>Instantiates a new database code resolver.
	 *
	 * @param dao the dao
	 * @param codeFactory the code factory
	 */
	public DatabaseCodeResolver(CodeSetDao dao, TypedCodeFactory codeFactory) {
		this.dao = dao;
		this.codeFactory = codeFactory;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public <T extends Code> T lookup(Class<T> type, String code) {
		List<ValueSetEntry> codedValues = dao.selectValueSetsByCode(type, code);
		return (codedValues.isEmpty()) ? null : createCode(type, codedValues.get(0));
	}

	/**
	 * {@inheritDoc}
	 */
	public <T extends Code> T lookup(Class<? extends T> type, String code, String codeSystemOid) {
		ValueSetEntry valueSet = this.dao.findValueByCodeSystem(type, code, codeSystemOid);
		return valueSet == null ? null : createCode(type, valueSet);
	}

	/**
	 * {@inheritDoc}
	 */
	public <T extends Code> Collection<T> lookup(Class<T> type) {
		List<ValueSetEntry> values = dao.selectValueSetsByVocabularyDomain(type);
		return convertValuesToCodes(type, values);
	}

	private <T extends Code> Collection<T> convertValuesToCodes(Class<T> type, List<ValueSetEntry> values) {
		List<T> result = new ArrayList<T>();
		for (ValueSetEntry valueSet : values) {
			result.add(createCode(type, valueSet));
		}
		return result;
	}

	<T extends Code> T createCode(Class<T> type, ValueSetEntry value) {
		return createCode(type, value.getCodedValue(), getImplementedTypes(value));
	}
	
	private Set<Class<?>> getImplementedTypes(ValueSetEntry value) {
		Set<Class<?>> typeList = new HashSet<Class<?>>();
		Collection<VocabularyDomain> vocabularyDomains = value.getValueSet().getVocabularyDomains();
		for (VocabularyDomain vocabularyDomain : vocabularyDomains) {
			typeList.add(vocabularyDomain.getTypeAsClass());
		}
		return typeList;
	}

	private <T extends Code> T createCode(Class<T> type, CodedValue value, Set<Class<?>> implementedTypes) {
		return type.cast(this.codeFactory.create(type, implementedTypes, value.getCode(), 
				value.getCodeSystem().getOid(), 
				new HashMap<String, String>(value.getDescriptions()), 
				new Integer(1), Boolean.TRUE, Boolean.TRUE));
	}

	/**
	 * <p>Lookup.
	 *
	 * @param <T> the generic type
	 * @param type the type
	 * @param nullFlavor the null flavor
	 * @return the t
	 */
	public <T extends Code> T lookup(Class<T> type, NullFlavor nullFlavor) {
		//TODO: accept nullflavours
		return null;
	}

	/**
	 * <p>Lookup.
	 *
	 * @param <T> the generic type
	 * @param arg0 the arg0
	 * @param code the code
	 * @param codeSystemOid the code system oid
	 * @param arg3 the arg3
	 * @return the t
	 */
	public <T extends Code> T lookup(Class<T> arg0, String code, String codeSystemOid, NullFlavor arg3) {
		//TODO: accept nullflavours
		return lookup(arg0, code, codeSystemOid);
	}
}
