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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-08-27 12:20:47 -0300 (Tue, 27 Aug 2013) $
 * Revision:      $LastChangedRevision: 7837 $
 */

package ca.infoway.messagebuilder.terminology.codeset;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.resolver.CodeResolver;
import ca.infoway.messagebuilder.resolver.GenericCodeResolverRegistry;
import ca.infoway.messagebuilder.terminology.codeset.dao.CodeSetDao;
import ca.infoway.messagebuilder.terminology.codeset.domain.ValueSet;
import ca.infoway.messagebuilder.terminology.codeset.domain.VocabularyDomain;
import ca.infoway.messagebuilder.terminology.proxy.TypedCodeFactory;

/**
 * 
 * <p>Utility to register all vocabulary domains in a database (that have value sets of a specific version) against a database code resolver. 
 *
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 */
public class DatabaseCodeResolverRegistrationUtility {


	/**
	 * 
	 * <p>Convenience class to hold results of the registration utility.
	 *
	 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
	 *
	 */
	public class DatabaseCodeResolverRegistrationUtilityResults {
		
		/**
		 * <p>Domains that were not registered.
		 */
		public Set<String> domainsFoundInDatabaseButNoMatchingInterface = new TreeSet<String>();
		
		/**
		 * <p>Domains that were successfully registered.
		 */
		public Map<String, Class<? extends Code>> domainsInDatabaseMappedToInterfacesUsedToRegister = new TreeMap<String, Class<? extends Code>>();
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append("Vocabulary Domains successfully registered:\n");
			for (Entry<String, Class<? extends Code>> entry : this.domainsInDatabaseMappedToInterfacesUsedToRegister.entrySet()) {
				sb.append(entry.getKey()).append(" -> ").append(entry.getValue().getName()).append("\n");
			}
			sb.append("\nVocabulary Domains found in database but for which could NOT find a matching interface:\n");
			for (String string : this.domainsFoundInDatabaseButNoMatchingInterface) {
				sb.append(string).append("\n");
			}
			
			return sb.toString();
		}
		
	}

	/**
	 * <p>Find all domains that have value sets for the supplied version and register their matching MB interfaces against a database code resolver. 
	 * 
	 * @param dao the code set DAO
	 * @param codeFactory a code factory
	 * @param version the value set version being used 
	 * @param registry a code resolver registry  
	 * @param releaseSpecificBasePackageName base package name for the specific API release being targeted
	 * @return the results of the registration process
	 */
	public DatabaseCodeResolverRegistrationUtilityResults registerAll(CodeSetDao dao, TypedCodeFactory codeFactory, String version, GenericCodeResolverRegistry registry, String releaseSpecificBasePackageName) {
		
		DatabaseCodeResolverRegistrationUtilityResults results = new DatabaseCodeResolverRegistrationUtilityResults();
		
		Set<String> domainTypes = determineAllDomains(dao, version);
		List<Class<? extends Code>> domainInterfaces = findAllMatchingDomainInterfaces(domainTypes, releaseSpecificBasePackageName, results);
		registerDomainsAgainstDatabaseCodeResolver(dao, codeFactory, version, registry, domainInterfaces);

		return results;
	}

	/**
	 * <p>Determines all domain types that have value sets for the supplied version.
	 * 
	 * @param dao the code set DAO
	 * @param version the value set version to use
	 * @return the set of domain types as strings
	 */
	private Set<String> determineAllDomains(CodeSetDao dao, String version) {
		// use version to determine all applicable ValueSets
		List<ValueSet> valueSets = dao.selectValueSetsByVersion(version);
		
		// pull out all VocabularyDomains referenced by the value sets
		Set<String> domainTypes = new TreeSet<String>();
		
		for (ValueSet valueSet : valueSets) {
			Set<VocabularyDomain> vocabularyDomains = valueSet.getVocabularyDomains();
			for (VocabularyDomain vocabularyDomain : vocabularyDomains) {
				domainTypes.add(vocabularyDomain.getType());
			}
		}
		
		return domainTypes;
	}
	
	/**
	 * <p>Find all domain interfaces that match the supplied domain types. 
	 * 
	 * @param domainTypes the domain types to match against interfaces
	 * @param releaseSpecificBasePackageName base package name for the specific API release being targeted
	 * @param results results object detailing what domains were registered and which could not be matched up to interfaces
	 * @return the matching interfaces
	 */
	private List<Class<? extends Code>> findAllMatchingDomainInterfaces(
			Set<String> domainTypes, 
			String releaseSpecificBasePackageName,
			DatabaseCodeResolverRegistrationUtilityResults results) {
		
		// for each VocabularyDomain type, look for a matching interface
		List<Class<? extends Code>> domainInterfaces = new ArrayList<Class<? extends Code>>();
		
		for (String domainType : domainTypes) {
			
			Class<? extends Code> domainInterface = lookupDomainInterface(domainType, releaseSpecificBasePackageName);
			
			if (domainInterface != null) {
				domainInterfaces.add(domainInterface);
				results.domainsInDatabaseMappedToInterfacesUsedToRegister.put(domainType, domainInterface);
			} else {
				// need to log a problem
				results.domainsFoundInDatabaseButNoMatchingInterface.add(domainType);
			}
			
		}
		
		return domainInterfaces;
		
	}

	/**
	 * <p>For each VocabularyDomain type, looks for a matching interface in one of two places.
	 * 
	 *   1) ca.infoway.messagebuilder.domainvalue.XXXX
	 *   2) ca.infoway.messagebuilder.model.VER.domainvalue.XXXX (VER must be provided manually)
	 *   
	 * @param domainType the domain type to look up
	 * @param releaseSpecificBasePackageName base package name for the specific API release being targeted 
	 * @return the mathcing domain interface, if any
	 */
	@SuppressWarnings("unchecked")
	private Class<? extends Code> lookupDomainInterface(String domainType, String releaseSpecificBasePackageName) {
		
		
		Class<? extends Code> domainInterface = null;
		try {
			domainInterface = (Class<? extends Code>) Class.forName("ca.infoway.messagebuilder.domainvalue." + domainType);
		} catch (ClassNotFoundException cnfe1) {
			if (releaseSpecificBasePackageName != null) {
				try {
					domainInterface = (Class<? extends Code>) Class.forName("ca.infoway.messagebuilder.model." + releaseSpecificBasePackageName + ".domainvalue." + domainType);
				} catch (ClassNotFoundException cnfe2) {
					// do nothing
				}
			}
		}
		
		return domainInterface;
		
	}

	/**
	 * <p>Create a DB resolver from supplied parameters and register all found interfaces.
	 * 
	 * @param dao the code set DAO
	 * @param codeFactory a code factory
	 * @param version the value set version being used 
	 * @param registry a code resolver registry  
	 * @param domainInterfaces the domain interfaces to register resolvers for
	 */
	private void registerDomainsAgainstDatabaseCodeResolver(
			CodeSetDao dao,
			TypedCodeFactory codeFactory, 
			String version,
			GenericCodeResolverRegistry registry,
			List<Class<? extends Code>> domainInterfaces) {
		
		CodeResolver dbResolver = new DatabaseCodeResolver(dao, codeFactory, version);
		for (Class<? extends Code> domainInterface : domainInterfaces) {
			registry.registerResolver(domainInterface, dbResolver);
		}
		
	}

}
