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

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class DaoTestSupport {
	private static XmlBeanFactory factory;
	private String springContext;
	
	public DaoTestSupport() {
		this("mock-hibernate-spring.xml");
	}
	
	public DaoTestSupport(String springContext) {
		this.springContext = springContext;
	}
	
	private void setUpTransactionManager() {
		Session session = getSessionFactory().openSession();
        TransactionSynchronizationManager.bindResource(getSessionFactory(), new SessionHolder(session));
	}
	
	public void setUp() {
		if (factory == null) {
			factory = new XmlBeanFactory(
					new ClassPathResource(this.springContext));
		}
		setUpTransactionManager();
	}

	public void tearDown() throws Exception {
        SessionHolder holder = (SessionHolder) TransactionSynchronizationManager.getResource(
                getSessionFactory());
        Session session = holder.getSession();
        TransactionSynchronizationManager.unbindResource(getSessionFactory());
        session.close();
	}

	
	public SessionFactory getSessionFactory() {
		return (SessionFactory) getFactory().getBean(SessionFactory.class.getName());
	}

	public BeanFactory getFactory() {
		return factory;
	}
	
	public void runInTransaction(Runnable runnable) {
		Transaction transaction = getSessionFactory().getCurrentSession().beginTransaction();
		runnable.run();
		transaction.commit();
	}
	
	public void executeHqlInTransaction(final String hql) {
		runInTransaction(new Runnable() {
			public void run() {
				getSessionFactory().getCurrentSession().createQuery(hql).executeUpdate();
			}
		});
	}
}
