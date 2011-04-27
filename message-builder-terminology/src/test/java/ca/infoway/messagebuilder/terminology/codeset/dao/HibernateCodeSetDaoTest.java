/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.terminology.codeset.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.classic.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.domainvalue.AcknowledgementCondition;
import ca.infoway.messagebuilder.domainvalue.AcknowledgementType;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.Confidentiality;
import ca.infoway.messagebuilder.domainvalue.ProcessingID;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.domainvalue.x_DrugUnitsOfMeasure;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.terminology.codeset.domain.CodeSystem;
import ca.infoway.messagebuilder.terminology.codeset.domain.CodedValue;
import ca.infoway.messagebuilder.terminology.codeset.domain.ValueSetEntry;
import ca.infoway.messagebuilder.terminology.codeset.domain.VocabularyDomain;

public class HibernateCodeSetDaoTest {

	private static final String CODE = "CODE";
	private static final String OTHER_CODE = "OTHER CODE";
	
	private static final Class<?> VOCABULARY_DOMAIN = AcknowledgementCondition.class;
	private static final Class<?> OTHER_VOCABULARY_DOMAIN = ProcessingID.class;
	private static final Class<?> PARENT_VOCABULARY_DOMAIN = UnitsOfMeasureCaseSensitive.class;
	private static final Class<? extends Code> SUB_VOCABULARY_DOMAIN = x_DrugUnitsOfMeasure.class;

	private static int oidDistinguisher = 0;
	private static final String OID_BASE = "1.2.3.4.5";
	private static String OID;
	private static final String OTHER_OID_BASE = "9.7.6.5.4";
	private static String OTHER_OID;
	
	private MutableCodeSetDao dao;
	
	private final DaoTestSupport support = new DaoTestSupport("ca/infoway/messagebuilder/terminology/codeset/dao/mock-hibernate-spring.xml");
	private CodeTestFactory factory;
	private CodeSystem codeSystem;
	
	private final Map<Class<?>,VocabularyDomain> domains = Collections.synchronizedMap(new HashMap<Class<?>,VocabularyDomain>());
	
	@Before
	public void setUp() throws Exception {
		
		CodeResolverRegistry.register(new TrivialCodeResolver());
		
		this.support.setUp();
		this.support.getSessionFactory().getCurrentSession().beginTransaction();
		
		this.dao = new HibernateCodeSetDao(this.support.getSessionFactory());
		this.factory = new CodeTestFactory(this.support);
		OID = OID_BASE + "." + (++oidDistinguisher);
		OTHER_OID = OTHER_OID_BASE + "." + oidDistinguisher;
	}
	
	@After
	public void tearDown() throws Exception {
		tearDownTestData();
		this.support.tearDown();
	}

	private void tearDownTestData() throws SQLException {
		Session session = this.support.getSessionFactory().getCurrentSession();
		Statement statement = session.connection().createStatement();
		statement.execute("delete from value_set_to_vocabulary_domain");
		statement.execute("delete from value_set_entry");
		statement.execute("delete from value_set");
		statement.execute("delete from coded_value_to_coded_value");
		statement.execute("delete from coded_value");
		statement.execute("delete from code_system");
		statement.execute("delete from vocabulary_domain");
	}

	@Test
	public void testSelectCodedValuesByVocabularyDomain_ShouldFindTwoMatchingCodes() throws Exception {
		createCodedValue(CODE, VOCABULARY_DOMAIN);
		createCodedValue(OTHER_CODE, VOCABULARY_DOMAIN);

		List<CodedValue> codedValues = this.dao.selectCodedValuesByVocabularyDomain(VOCABULARY_DOMAIN);
		
		assertEquals(2, codedValues.size());
		assertTrue(codedValueFound(codedValues, CODE));
		assertTrue(codedValueFound(codedValues, OTHER_CODE));
	}

	@Test	
	public void testSelectCodedValuesByVocabularyDomain_ShouldReturnEmptyListWhenThereIsNoData() throws Exception {
		Collection<CodedValue> codedValues = this.dao.selectCodedValuesByVocabularyDomain(VOCABULARY_DOMAIN);
		
		assertTrue(codedValues.isEmpty());
	}

	@Test
	public void testSelectCodedValuesByVocabularyDomain_ShouldNotSelectCodesInOtherVocabularyDomains() throws Exception {
		createCodedValue(CODE, VOCABULARY_DOMAIN);
		createCodedValue(CODE, OTHER_VOCABULARY_DOMAIN);
		
		List<CodedValue> codedValues = this.dao.selectCodedValuesByVocabularyDomain(VOCABULARY_DOMAIN);
		
		assertEquals(1, codedValues.size());
		assertTrue(codedValueFound(codedValues, CODE));
	}
	
	@Test
	public void testSelectCodeSystem() throws Exception {
		this.factory.createCodeSystem(OID);
		this.factory.createCodeSystem(OID + ".1");
		this.factory.createCodeSystem(OID + "01");
		
		CodeSystem codeSystem = this.dao.findCodeSystem(OID);
		
		assertNotNull("code system", codeSystem);
		assertEquals("oid", OID, codeSystem.getOid());
	}
	
	@Test	
	public void testFindCodedValueByCodeSystem_ShouldFindMatchingCodedValue() throws Exception {
		VocabularyDomain vocabularyDomain = this.factory.createVocabularyDomain(Confidentiality.class);
		
		createCodedValue(vocabularyDomain, OID, "N");
		
		ValueSetEntry value = this.dao.findValueByCodeSystem(Confidentiality.class, "N", OID);
		
		assertNotNull("coded value", value);
		assertEquals("N", value.getCodedValue().getCode());
		assertEquals(OID, value.getCodedValue().getCodeSystem().getOid());
	}

	@Test
	public void testFindCodedValueByCodeSystem_ShouldNotFindValuesInOtherCodeSystems() throws Exception {
		VocabularyDomain vocabularyDomain = this.factory.createVocabularyDomain(VOCABULARY_DOMAIN);
		
		createCodedValue(vocabularyDomain, OTHER_OID, CODE);
		
		ValueSetEntry value = this.dao.findValueByCodeSystem(VOCABULARY_DOMAIN, CODE, OID);
		assertNull(value);
	}

	@Test
	public void testFindCodedValueByCodeSystem_ShouldNotFindValueWhenThereIsNoData() throws Exception {
		ValueSetEntry value = this.dao.findValueByCodeSystem(VOCABULARY_DOMAIN, CODE, OID);
		assertNull(value);
	}
	
	@Test
	public void testSelectCodedValuesByCode_ShouldFindMatchingCodedValue() throws Exception {
		createCodedValue(CODE, VOCABULARY_DOMAIN);

		Collection<ValueSetEntry> codedValues = this.dao.selectValueSetsByCode(VOCABULARY_DOMAIN, CODE);
		
		assertEquals(1, codedValues.size());
		
		ValueSetEntry value = codedValues.iterator().next();
		assertEquals(CODE, value.getCodedValue().getCode());
	}

	@Test
	public void testSelectCodedValuesByCode_ShouldFindMatchingCodedValueInSubVocabularyDomains() throws Exception {
		createCodedValue(CODE, SUB_VOCABULARY_DOMAIN, PARENT_VOCABULARY_DOMAIN);
		
		Collection<ValueSetEntry> codedValues = this.dao.selectValueSetsByCode(PARENT_VOCABULARY_DOMAIN, CODE);
		
		assertEquals(1, codedValues.size());
		
		ValueSetEntry value = codedValues.iterator().next();
		assertEquals(CODE, value.getCodedValue().getCode());
	}
	
	@Test
	public void testSelectCodedValuesByCode_ShouldNotFindValuesInOtherVocabularyDomains() throws Exception {
		createCodedValue(CODE, OTHER_VOCABULARY_DOMAIN);
		
		Collection<ValueSetEntry> values = this.dao.selectValueSetsByCode(VOCABULARY_DOMAIN, CODE);
		
		assertTrue(values.isEmpty());
	}

	@Test
	public void testSelectCodedValuesByCode_ShouldNotSelectValuesWhenThereIsNoData() throws Exception {
		Collection<ValueSetEntry> values = this.dao.selectValueSetsByCode(VOCABULARY_DOMAIN, CODE);
		
		assertTrue(values.isEmpty());
	}
	
	@Test
	public void testFindVocabularyDomainsByPartialTypeName() throws Exception {
		this.factory.createVocabularyDomain(AcknowledgementCondition.class);
		this.factory.createVocabularyDomain(AcknowledgementType.class);
		this.factory.createVocabularyDomain(ActCode.class);
		this.factory.createVocabularyDomain(AdministrativeGender.class);
		
		CodeSearchCriteria searchCriteria = new CodeSearchCriteria();
		searchCriteria.setType("Ac");
		List<VocabularyDomain> vocabularyDomains = this.dao.selectVocabularyDomains(searchCriteria);
		
		assertNotNull(vocabularyDomains);
		assertEquals(3, vocabularyDomains.size());
	}	
	
	@Test
	public void testFindVocabularyDomainsByPartialBusinessName() throws Exception {
		this.factory.createVocabularyDomain(AcknowledgementCondition.class, "Bbaaa", null);
		this.factory.createVocabularyDomain(AcknowledgementType.class, "Bbaaa", null);
		this.factory.createVocabularyDomain(ActCode.class, "Bbaaa", null);
		this.factory.createVocabularyDomain(AdministrativeGender.class, "Other", "Other");
		
		CodeSearchCriteria searchCriteria = new CodeSearchCriteria();
		searchCriteria.setBusinessName("Bb");
		List<VocabularyDomain> vocabularyDomains = this.dao.selectVocabularyDomains(searchCriteria);
		
		assertNotNull(vocabularyDomains);
		assertEquals(3, vocabularyDomains.size());
	}	

	@Test
	public void testFindVocabularyDomainsByPartialDescription() throws Exception {
		this.factory.createVocabularyDomain(AcknowledgementCondition.class, "Bbaaa", "Ddeee");
		this.factory.createVocabularyDomain(AcknowledgementType.class, "Bbaaa", "Ddeee");
		this.factory.createVocabularyDomain(ActCode.class, "Bbaaa", "Ddeee");
		this.factory.createVocabularyDomain(AdministrativeGender.class, "Other", "Other");
		
		CodeSearchCriteria searchCriteria = new CodeSearchCriteria();
		searchCriteria.setDescription("Dd");
		List<VocabularyDomain> vocabularyDomains = this.dao.selectVocabularyDomains(searchCriteria);
		
		assertNotNull(vocabularyDomains);
		assertEquals(3, vocabularyDomains.size());
	}	
	
	@Test
	public void testFindVocabularyDomainsByCaseInsensitive() throws Exception {
		this.factory.createVocabularyDomain(AcknowledgementCondition.class, "Bbaaa", "Ddeee");
		this.factory.createVocabularyDomain(AcknowledgementType.class, "Bbaaa", "Ddeee");
		this.factory.createVocabularyDomain(ActCode.class, "Bbaaa", "Eeeee");
		this.factory.createVocabularyDomain(AdministrativeGender.class, "Other", "Other");
		
		CodeSearchCriteria searchCriteria = new CodeSearchCriteria();
		searchCriteria.setType("ac");
		searchCriteria.setBusinessName("bb");
		searchCriteria.setDescription("dd");
		List<VocabularyDomain> vocabularyDomains = this.dao.selectVocabularyDomains(searchCriteria);
		
		assertNotNull(vocabularyDomains);
		assertEquals(2, vocabularyDomains.size());
	}	
	
	private void createCodedValue(VocabularyDomain vocabularyDomain, String oid, String code, String parentCode, List<String> childCodes) {
		CodeSystem codeSystem = this.factory.createCodeSystem(oid);
		CodedValue codeCodedValue = createCodedValue(vocabularyDomain, codeSystem, code);
		CodedValue parentCodeCodedValue = null;
		if (parentCode != null) {
			parentCodeCodedValue = createCodedValue(vocabularyDomain, codeSystem, parentCode);
		}
		List<CodedValue> childCodesCodedValues = new ArrayList<CodedValue>();
		if (childCodes != null) {
			for (String childCode : childCodes) {
				CodedValue childCodedValue = createCodedValue(vocabularyDomain, codeSystem, childCode);
				childCodesCodedValues.add(childCodedValue);
			}
		}
		this.factory.createCodedValue(codeCodedValue, parentCodeCodedValue, childCodesCodedValues);
	}
	
	private CodedValue createCodedValue(VocabularyDomain vocabularyDomain, CodeSystem codeSystem, String code) {
		CodedValue codedValue = this.factory.createCodedValue(codeSystem, code);
		this.factory.createValueSet(codedValue, vocabularyDomain);
		return codedValue;
	}
	
	private CodedValue createCodedValue(VocabularyDomain vocabularyDomain, String oid, String code) {
		CodeSystem codeSystem = this.factory.createCodeSystem(oid);
		CodedValue codedValue = this.factory.createCodedValue(codeSystem, code);
		this.factory.createValueSet(codedValue, vocabularyDomain);
		return codedValue;
	}

	private void createCodedValue(String code, Class<?>... vocabularyDomainType) {
		if (this.codeSystem == null) {
			this.codeSystem = this.factory.createCodeSystem(OID);
		}
		CodedValue codedValue = this.factory.createCodedValue(this.codeSystem, code);

		List<VocabularyDomain> domains = new ArrayList<VocabularyDomain>();
		for (Class<?> domain : vocabularyDomainType) {
			VocabularyDomain vocabularyDomain = this.domains.get(domain);
			if (vocabularyDomain == null) {
				vocabularyDomain = this.factory.createVocabularyDomain(domain);
				this.domains.put(domain, vocabularyDomain);
			}
			domains.add(vocabularyDomain);
		}
		this.factory.createValueSet(codedValue, domains.toArray(new VocabularyDomain[domains.size()]));
	}

	private boolean codedValueFound(List<CodedValue> codedValues, String code) {
		for (Iterator<CodedValue> i = codedValues.iterator(); i.hasNext();) {
			CodedValue value = i.next();
			if (value.getCode().equals(code)) {
				return true;
			}
		}
		return false;
	}

	@Test
	public void testFindCodedValueWithNoChildrenNoParent() {
		createCodedValue(CODE, SUB_VOCABULARY_DOMAIN, PARENT_VOCABULARY_DOMAIN);
		
		x_DrugUnitsOfMeasure code = (x_DrugUnitsOfMeasure) CodeResolverRegistry.lookup(SUB_VOCABULARY_DOMAIN, CODE, OID);
		
		CodedValue codedValue = this.dao.findCodedValue(code);
		
		assertNotNull(codedValue);
		assertTrue(codedValue.getChildren().isEmpty());
		assertTrue(codedValue.getParents().isEmpty());
		
	}

	@Test
	public void testFindCodedValueWithChildrenAndParent() {
		VocabularyDomain vocabularyDomain = this.factory.createVocabularyDomain(Confidentiality.class);
		
		createCodedValue(vocabularyDomain, OID, CODE, "parent", Arrays.asList("child1", "child2", "child3"));
		
		Confidentiality code = (Confidentiality) CodeResolverRegistry.lookup(Confidentiality.class, CODE, OID);
		
		CodedValue codedValue = this.dao.findCodedValue(code);
		
		assertNotNull(codedValue);
		assertFalse(codedValue.getChildren().isEmpty());
		assertEquals(3, codedValue.getChildren().size());
		assertFalse(codedValue.getParents().isEmpty());
		
	}
}
