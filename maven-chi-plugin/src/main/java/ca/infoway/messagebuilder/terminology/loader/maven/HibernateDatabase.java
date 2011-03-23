package ca.infoway.messagebuilder.terminology.loader.maven;

import java.util.Collection;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.ImprovedNamingStrategy;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.terminology.codeset.dao.HibernateCodeSetDao;
import ca.infoway.messagebuilder.terminology.codeset.dao.MutableCodeSetDao;
import ca.infoway.messagebuilder.terminology.codeset.domain.CodeSystem;
import ca.infoway.messagebuilder.terminology.codeset.domain.CodedValue;
import ca.infoway.messagebuilder.terminology.codeset.domain.ValueSet;
import ca.infoway.messagebuilder.terminology.codeset.domain.ValueSetEntry;
import ca.infoway.messagebuilder.terminology.codeset.domain.VocabularyDomain;

class HibernateDatabase implements Database {

	private MutableCodeSetDao dao;
	private SessionFactory factory;
	private Transaction transaction;
	
	HibernateDatabase(Properties properties) {
		initialize(properties);
	}

	private void initialize(Properties properties) {
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.setNamingStrategy(new ImprovedNamingStrategy());
		configuration.setProperties(properties);
		configuration.addAnnotatedClass(VocabularyDomain.class);
		configuration.addAnnotatedClass(CodeSystem.class);
		configuration.addAnnotatedClass(CodedValue.class);
		configuration.addAnnotatedClass(ValueSet.class);
		configuration.addAnnotatedClass(ValueSetEntry.class);
		
		this.factory = configuration.buildSessionFactory();
		this.dao = new HibernateCodeSetDao(this.factory);
	}
	
	public void startTransaction() {
		Session session = this.factory.openSession();
        TransactionSynchronizationManager.bindResource(this.factory, new SessionHolder(session));
		this.transaction = session.beginTransaction();
	}

	public VocabularyDomain getVocabularyDomainByName(String vocabularyDomainName) {
		return this.dao.selectVocabularyDomain(vocabularyDomainName);
	}

	public void saveVocabularyDomains(Collection<VocabularyDomain> vocabularyDomain) {
		this.dao.saveAll(vocabularyDomain);
	}
	
	public void commitTransaction() {
		this.transaction.commit();
		this.transaction = null;
        SessionHolder holder = (SessionHolder) TransactionSynchronizationManager.getResource(
                this.factory);
        Session session = holder.getSession();
        TransactionSynchronizationManager.unbindResource(this.factory);
        session.close();
	}

	public CodeSystem getCodeSystem(String oid) {
		return this.dao.findCodeSystem(oid);
	}

	public CodedValue findCodedValue(Code code) {
		return this.dao.findCodedValue(code);
	}

	public void saveCodedValues(Collection<CodedValue> values) {
		this.dao.saveAllCodedValues(values);
	}

	public ValueSetEntry findValueSetEntry(String valueSetName, Code code) {
		return this.dao.findValueSetEntry(valueSetName, code);
	}

	public void saveValueSetEntry(ValueSetEntry valueSet) {
		this.dao.save(valueSet);
	}

	public ValueSet findValueSet(String name) {
		return this.dao.findValueSet(name);
	}

	public void saveValueSet(ValueSet valueSet) {
		this.dao.saveValueSet(valueSet);
	}
}
