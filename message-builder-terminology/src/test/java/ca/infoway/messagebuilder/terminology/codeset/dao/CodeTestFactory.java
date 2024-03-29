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

package ca.infoway.messagebuilder.terminology.codeset.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.ClassUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ca.infoway.messagebuilder.terminology.codeset.domain.CodeSystem;
import ca.infoway.messagebuilder.terminology.codeset.domain.CodedValue;
import ca.infoway.messagebuilder.terminology.codeset.domain.ValueSet;
import ca.infoway.messagebuilder.terminology.codeset.domain.ValueSetEntry;
import ca.infoway.messagebuilder.terminology.codeset.domain.VocabularyDomain;

public class CodeTestFactory extends HibernateDaoSupport {
	
	public static int uniqueNameSuffix = 1;
	
	private final List<Object> createdObjects = new ArrayList<Object>();
	private final DaoTestSupport testSupport;
	
	public CodeTestFactory(DaoTestSupport testSupport) {
		this.testSupport = testSupport;
		setSessionFactory(testSupport.getSessionFactory());
	}

	public ValueSetEntry createValueSet(CodedValue codedValue, String version, VocabularyDomain... vocabularyDomain) {
		ValueSet valueSet = new ValueSet();
		valueSet.setName("testValueSetName" + uniqueNameSuffix);
		valueSet.setVersion(version);
		uniqueNameSuffix++;
		
		ValueSetEntry result = new ValueSetEntry();
		result.setCodedValue(codedValue);
		result.setSequence(1);
		result.setActive(Boolean.TRUE);
		result.setCommon(Boolean.TRUE);
		result.setValueSet(valueSet);
		for (VocabularyDomain domain : vocabularyDomain) {
			result.getValueSet().getVocabularyDomains().add(domain);
		}
		
		save(result);
		
		return result;
	}

	public CodedValue createCodedValue(CodedValue code, CodedValue parent, List<CodedValue> children) {
		if (code == null) {
			return code;
		}
		
		if (parent != null) {
			code.getParents().add(parent);
			parent.getChildren().add(code);
		}
		
		if (children != null) {
			for (CodedValue child : children) {
				child.getParents().add(code);
				code.getChildren().add(child);
			}
		}
		
		save(code);
		if (parent != null) {
			save(parent);
		}
		if (children != null) {
			for (CodedValue child : children) {
				save(child);
			}
		}
		
		return code;
	}
	
	public CodedValue createCodedValue(CodeSystem codeSystem, String code) {
		CodedValue result = new CodedValue();
		result.setCode(code);
		result.setCodeSystem(codeSystem);
		result.setCreateUserId("HWNG");
		result.setLastUpdateDatetime(new Date());
		result.setCreateDatetime(new Date());
		save(result);
		
		return result;
	}
	
	public CodeSystem createCodeSystem(String oid) {
		CodeSystem result = new CodeSystem();
		result.setOid(oid);
		save(result);
		
		return result;
	}

	public VocabularyDomain createVocabularyDomain(Class<?> vocabularyDomainType) {
		return createVocabularyDomain(vocabularyDomainType, null, null);
	}

	public VocabularyDomain createVocabularyDomain(Class<?> vocabularyDomainType, String businessName, String description) {
		VocabularyDomain result = new VocabularyDomain();
		result.setType(ClassUtils.getShortClassName(vocabularyDomainType));
		result.setBusinessName(businessName);
		result.setDescription(description);
		save(result);
		return result;
	}
	
	public void tearDown() {
		Collections.reverse(this.createdObjects);
		for (Iterator<Object> iterator = this.createdObjects.iterator(); iterator.hasNext();) {
			Object createdObj = iterator.next();
			getHibernateTemplate().delete(createdObj);
		}
		this.createdObjects.clear();
	}

	private void save(final Object object) {
		this.testSupport.runInTransaction(new Runnable() {
			public void run() {
				getHibernateTemplate().saveOrUpdate(object);
			}
		});
		this.createdObjects.add(object);
	}
}
