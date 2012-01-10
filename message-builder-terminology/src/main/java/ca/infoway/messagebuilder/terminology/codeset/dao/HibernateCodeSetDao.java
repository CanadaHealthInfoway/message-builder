/**
 * Copyright 2012 Canada Health Infoway, Inc.
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

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.terminology.codeset.domain.CodeSystem;
import ca.infoway.messagebuilder.terminology.codeset.domain.CodedValue;
import ca.infoway.messagebuilder.terminology.codeset.domain.ValueSet;
import ca.infoway.messagebuilder.terminology.codeset.domain.ValueSetEntry;
import ca.infoway.messagebuilder.terminology.codeset.domain.VocabularyDomain;

/**
 * <p>The Class HibernateCodeSetDao.
 * 
 * Implementation using Hibernate of the CodeSetDao interface
 *
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class HibernateCodeSetDao extends HibernateDaoSupport implements MutableCodeSetDao {

	/**
	 * <p>Instantiates a new hibernate code set dao.
	 *
	 * @param sessionFactory the session factory
	 */
	public HibernateCodeSetDao(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<CodedValue> selectCodedValuesByVocabularyDomain(final Class<?> vocabularyDomainType) {
		return convertValueSetsToCodedValues(selectValueSetsByVocabularyDomain(vocabularyDomainType));
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<ValueSetEntry> selectValueSetsByCode(final Class<?> vocabularyDomainType, 
			final String code) {
		List<ValueSetEntry> valueSets = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws SQLException {
				
				Criteria criteriaValueSet = session.createCriteria(ValueSetEntry.class);
				
				Criteria criteriaCodedValue = criteriaValueSet.createCriteria("codedValue");
				criteriaCodedValue.add(Restrictions.eq("code", code));
		
				Criteria criteriaVocabularyDomain = criteriaValueSet.createCriteria("valueSet").createCriteria("vocabularyDomains");
				criteriaVocabularyDomain.add(Restrictions.eq("type", ClassUtils.getShortClassName(vocabularyDomainType)));
		
				return criteriaValueSet.list();
			}
		});
		return valueSets;

	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public ValueSetEntry findValueByCodeSystem(final Class<?> vocabularyDomainType, final String code, final String codeSystemOid) {
		return (ValueSetEntry) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws SQLException {
				
				Criteria criteriaValueSetEntry = session.createCriteria(ValueSetEntry.class);
				
				Criteria criteriaCodedValue = criteriaValueSetEntry.createCriteria("codedValue");
				criteriaCodedValue.add(Restrictions.eq("code", code));

				Criteria criteriaCodeSystem = criteriaCodedValue.createCriteria("codeSystem");
			
				criteriaCodeSystem.add(Restrictions.eq("oid", codeSystemOid));
			
				Criteria criteriaVocabularyDomain = criteriaValueSetEntry.createCriteria("valueSet").createCriteria("vocabularyDomains");
				criteriaVocabularyDomain.add(Restrictions.eq("type", ClassUtils.getShortClassName(vocabularyDomainType)));

				List list = criteriaValueSetEntry.list();
				return list.isEmpty() ? null : list.get(0);
			}
		});
	}

	private List<CodedValue> convertValueSetsToCodedValues(List<ValueSetEntry> valueSets) {
		List<CodedValue> result = new ArrayList<CodedValue>();
		
		for (Iterator<ValueSetEntry> iter = valueSets.iterator(); iter.hasNext();) {
			ValueSetEntry valueSet = iter.next();
			result.add(valueSet.getCodedValue());
		}
		
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<VocabularyDomain> selectAllVocabularyDomains() {
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws SQLException {
				Criteria criteria = session.createCriteria(VocabularyDomain.class);
				criteria.addOrder(Order.asc("type"));
				return criteria.list();
			}});
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public VocabularyDomain selectVocabularyDomain(final String type) {
		return (VocabularyDomain) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws SQLException {
				Criteria criteria = session.createCriteria(VocabularyDomain.class);
				criteria.add(Restrictions.eq("type", type));
				return criteria.uniqueResult();
			}});
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ValueSetEntry> selectValueSetsByVocabularyDomain(
			final Class<?> vocabularyDomainType) {
		return selectValueSetsByVocabularyDomain(ClassUtils.getShortClassName(vocabularyDomainType));
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<ValueSetEntry> selectValueSetsByVocabularyDomain(
			final String domainName) {
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws SQLException {
				
				Criteria criteriaValueSetEntry = session.createCriteria(ValueSetEntry.class);
				
				Criteria criteriaValue = criteriaValueSetEntry.createCriteria("valueSet");
				Criteria criteriaVocabularyDomain = criteriaValue.createCriteria("vocabularyDomains");
				criteriaVocabularyDomain.add(Restrictions.eq("type", domainName));

				return criteriaValueSetEntry.list();
			}
		});
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<VocabularyDomain> selectVocabularyDomains(
			final CodeSearchCriteria searchCriteria) {
		return (List<VocabularyDomain>) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session) throws SQLException {
						Criteria criteria = session.createCriteria(VocabularyDomain.class);
						contrainOnTypeIfRequired(criteria, searchCriteria);
						contrainOnBusinessNameIfRequired(criteria, searchCriteria);
						contrainOnDescriptionIfRequired(criteria, searchCriteria);
						criteria.addOrder(Order.asc("type"));
						return criteria.list();
					}
				});

	}
	
	private void contrainOnTypeIfRequired(Criteria criteria, final CodeSearchCriteria searchCriteria) {
		if (!StringUtils.isEmpty(searchCriteria.getType())) {
			criteria.add(Restrictions.ilike("type", searchCriteria.getType().trim(), MatchMode.ANYWHERE));	
		}
	}

	private void contrainOnBusinessNameIfRequired(Criteria criteria, CodeSearchCriteria searchCriteria) {
		if (!StringUtils.isEmpty(searchCriteria.getBusinessName())) {
			criteria.add(Restrictions.ilike("businessName", searchCriteria.getBusinessName().trim(), MatchMode.ANYWHERE));	
		}
	}
	
	private void contrainOnDescriptionIfRequired(Criteria criteria, CodeSearchCriteria searchCriteria) {
		if (!StringUtils.isEmpty(searchCriteria.getDescription())) {
			criteria.add(Restrictions.ilike("description", searchCriteria.getDescription().trim(), MatchMode.ANYWHERE));	
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<CodeSystem> getAllCodeSystems() {
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws SQLException {
				return session.createCriteria(CodeSystem.class).list();
			}
		});
	}

	/**
	 * {@inheritDoc}
	 */
	public List<CodeSystem> findCodeSystems(CodeSystemSearchCriteria searchCriteria) {
		return findCodeSystems(searchCriteria, -1, -1);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<CodeSystem> findCodeSystems(final CodeSystemSearchCriteria searchCriteria, final int startRow, final int endRow) {
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws SQLException {
				Criteria criteria = createStandardCodeSystemCriteria(searchCriteria, session);
				criteria.addOrder(Order.asc("name").ignoreCase());
				criteria.addOrder(Order.asc("oid").ignoreCase());
				criteria.addOrder(Order.asc("id"));
				if (startRow >= 0 && endRow >= 0) {
					criteria.setFirstResult(startRow);
					criteria.setMaxResults(endRow - startRow); // 0-based; endRow = exclusive
				}
				return criteria.list();
			}

		});
	}

	private Criteria createStandardCodeSystemCriteria(final CodeSystemSearchCriteria searchCriteria, Session session) {
		Criteria criteria = session.createCriteria(CodeSystem.class);
		addOidRestrictionIfRequired(criteria, searchCriteria.getOid());
		addNameRestrictionIfRequired(criteria, searchCriteria.getName());
		addDescriptionRestrictionIfRequired(criteria, searchCriteria.getDescription());
		addExclusionsIfRequired(criteria, searchCriteria);
		return criteria;
	}
	
	private void addExclusionsIfRequired(Criteria criteria, CodeSystemSearchCriteria searchCriteria) {
		String nameExclusion = searchCriteria.getNameStartsWithExclusion();
		if (StringUtils.isNotBlank(nameExclusion)) {
			criteria.add(Restrictions.not(Restrictions.ilike("name", nameExclusion, MatchMode.START)));
		}
		
		String oidExclusion = searchCriteria.getOidStartsWithExclusion();
		if (StringUtils.isNotBlank(oidExclusion)) {
			criteria.add(Restrictions.not(Restrictions.ilike("oid", oidExclusion, MatchMode.START)));
		}
		
		Collection<String> oidExlusions = searchCriteria.getOidExlusions();
		if (CollectionUtils.isNotEmpty(oidExlusions)) {
			criteria.add(Restrictions.not(Restrictions.in("oid", oidExlusions)));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public int countCodeSystems(final CodeSystemSearchCriteria searchCriteria) {
		return (Integer) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws SQLException {
				Criteria criteria = createStandardCodeSystemCriteria(searchCriteria, session);
				criteria.setProjection(Projections.rowCount());
				return criteria.list().get(0);
			}
		});
	}

	private void addDescriptionRestrictionIfRequired(Criteria criteria, String description) {
		if (!StringUtils.isEmpty(description)) {
			criteria.add(Restrictions.ilike("description", description, MatchMode.ANYWHERE));
		}
	}

	private void addNameRestrictionIfRequired(Criteria criteria, String name) {
		if (!StringUtils.isEmpty(name)) {
			criteria.add(Restrictions.ilike("name", name, MatchMode.ANYWHERE));
		}
	}

	private void addOidRestrictionIfRequired(Criteria criteria, String oid) {
		if (!StringUtils.isEmpty(oid)) {
			criteria.add(Restrictions.ilike("oid", oid, MatchMode.START));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ValueSetEntry> selectValueSetsByVocabularyDomain(String jurisdiction,
			VocabularyDomain vocabularyDomain) {
		return selectValueSetsByVocabularyDomain(vocabularyDomain.getType());
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public CodedValue findCodedValue(final Code code) {
		CodedValue result = null;
		
		if (code != null) {
			result = (CodedValue) getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session session) throws SQLException {
					Criteria criteria = session.createCriteria(CodedValue.class);
					criteria.add(Restrictions.eq("code", code.getCodeValue()));
					Criteria codeSystemCriteria = criteria.createCriteria("codeSystem");
					codeSystemCriteria.add(Restrictions.eq("oid", code.getCodeSystem()));
					return criteria.uniqueResult();
				}
			});			
		}
		
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public void saveAll(Collection<VocabularyDomain> vocabularyDomain) {
		getHibernateTemplate().saveOrUpdateAll(vocabularyDomain);
	}

	/**
	 * {@inheritDoc}
	 */
	public void saveAllCodedValues(Collection<CodedValue> values) {
		getHibernateTemplate().saveOrUpdateAll(values);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public ValueSetEntry findValueSetEntry(final String valueSetName, final Code code) {
		return (ValueSetEntry) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws SQLException {
				
				Criteria criteria = session.createCriteria(ValueSetEntry.class);
				criteria.createCriteria("valueSet").add(Restrictions.eq("name", valueSetName));
				
				Criteria codedValueCriteria = criteria.createCriteria("codedValue");
				codedValueCriteria.add(Restrictions.eq("code", code.getCodeValue()));
				codedValueCriteria.createCriteria("codeSystem").add(Restrictions.eq("oid", code.getCodeSystem()));
				
				return criteria.uniqueResult();
			}
		});
	}

	/**
	 * {@inheritDoc}
	 */
	public void save(ValueSetEntry valueSet) {
		getHibernateTemplate().saveOrUpdate(valueSet);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public ValueSet findValueSet(final String name) {
		return (ValueSet) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws SQLException {
				Criteria criteria = session.createCriteria(ValueSet.class);
				criteria.add(Restrictions.eq("name", name));
				return criteria.uniqueResult();
			}
		});
	}

	/**
	 * {@inheritDoc}
	 */
	public void saveValueSet(ValueSet valueSet) {
		getHibernateTemplate().saveOrUpdate(valueSet);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public CodeSystem findCodeSystem(final String oid) {
		return (CodeSystem) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws SQLException {
				Criteria criteria = session.createCriteria(CodeSystem.class);
				criteria.add(Restrictions.eq("oid", oid));
				return criteria.uniqueResult();
			}
		});
	}
}

