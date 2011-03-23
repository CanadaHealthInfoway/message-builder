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
	
	private final List<Object> createdObjects = new ArrayList<Object>();
	private final DaoTestSupport testSupport;
	
	public CodeTestFactory(DaoTestSupport testSupport) {
		this.testSupport = testSupport;
		setSessionFactory(testSupport.getSessionFactory());
	}

	public ValueSetEntry createValueSet(CodedValue codedValue, VocabularyDomain... vocabularyDomain) {
		ValueSetEntry result = new ValueSetEntry();
		result.setCodedValue(codedValue);
		result.setSequence(1);
		result.setActive(Boolean.TRUE);
		result.setCommon(Boolean.TRUE);
		result.setValueSet(new ValueSet());
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
