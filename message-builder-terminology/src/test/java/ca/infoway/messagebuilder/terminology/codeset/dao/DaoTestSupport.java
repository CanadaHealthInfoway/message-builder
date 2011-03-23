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
