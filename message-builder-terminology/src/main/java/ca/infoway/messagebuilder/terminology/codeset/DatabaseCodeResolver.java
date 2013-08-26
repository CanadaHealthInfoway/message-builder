/**
 * Copyright 2013 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.terminology.codeset;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

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
	private final String version;

	/**
	 * <p>Instantiates a new database code resolver.
	 *
	 * @param dao the dao
	 * @param codeFactory the code factory
	 * @param version the valueset version to match against in the database
	 */
	public DatabaseCodeResolver(CodeSetDao dao, TypedCodeFactory codeFactory, String version) {
		this.dao = dao;
		this.codeFactory = codeFactory;
		this.version = version;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public <T extends Code> T lookup(Class<? extends T> type, String code) {
		List<ValueSetEntry> codedValues = dao.selectValueSetsByCode(type, code, this.version);
		return (codedValues.isEmpty()) ? null : createCode(type, codedValues.get(0));
	}

	/**
	 * {@inheritDoc}
	 */
	public <T extends Code> T lookup(Class<? extends T> type, String code, String codeSystemOid) {
		// RM 15390 (and others) - TM: The lookup won't work if no code system is provided.
		// An argument could be made that if this method is called then we should expect the code system to be valid,
		// but let's err on the side of caution and do our best to find a matching code.
		if (StringUtils.isBlank(codeSystemOid)) {
			return lookup(type, code);
		} else {
			ValueSetEntry valueSet = this.dao.findValueByCodeSystem(type, code, codeSystemOid, this.version);
			return valueSet == null ? null : createCode(type, valueSet);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("deprecation")
	public <T extends Code> Collection<T> lookup(Class<? extends T> type) {
		List<ValueSetEntry> values = dao.selectValueSetsByVocabularyDomain(type, this.version);
		return convertValuesToCodes(type, values);
	}

	private <T extends Code> Collection<T> convertValuesToCodes(Class<? extends T> type, List<ValueSetEntry> values) {
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
