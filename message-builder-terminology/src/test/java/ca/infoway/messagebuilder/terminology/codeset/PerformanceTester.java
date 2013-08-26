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

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.StopWatch;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.ImprovedNamingStrategy;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.terminology.codeset.dao.CodeSetDao;
import ca.infoway.messagebuilder.terminology.codeset.dao.HibernateCodeSetDao;
import ca.infoway.messagebuilder.terminology.codeset.domain.CodeSystem;
import ca.infoway.messagebuilder.terminology.codeset.domain.CodedValue;
import ca.infoway.messagebuilder.terminology.codeset.domain.ValueSet;
import ca.infoway.messagebuilder.terminology.codeset.domain.ValueSetEntry;
import ca.infoway.messagebuilder.terminology.codeset.domain.VocabularyDomain;
import ca.infoway.messagebuilder.terminology.proxy.TypedCodeFactory;

/**
 * <p>A class to run some performance measures on database-based code resolution.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class PerformanceTester {

	private SessionFactory factory;
	private CodeSetDao dao;
	private DatabaseCodeResolver resolver;
	private static final String VERSION = "VERSION";
	
	public PerformanceTester(boolean useSecondLevelCache) {
		createDao(useSecondLevelCache);
		this.resolver = new DatabaseCodeResolver(this.dao, new TypedCodeFactory(), VERSION);
	}

	public static void main(String[] args) throws Exception {
		List<String> codes = readSampleCodes();
		
		boolean cache = false;
		for (int i = 0; i < 10; i++) {
			PerformanceTester tester = new PerformanceTester(cache);
			tester.run(codes);
			cache = !cache;
		}
	}

	@SuppressWarnings("unchecked")
	private static List<String> readSampleCodes() throws IOException {
		InputStream input = PerformanceTester.class.getResourceAsStream("sampleCodes.txt");
		try {
			return IOUtils.readLines(input);
		} finally {
			IOUtils.closeQuietly(input);
		}
	}

	private void run(List<String> codes) {
		openSession();
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		for (int i = 0, length = 1000; i < length; i++) {
			if (i % 50 == 0) {
				resetSession();
			}
			lookupCodes(codes);
		}
		
		stopWatch.stop();
        closeSession();
		
		System.out.println(stopWatch.getTime());
	}

	@SuppressWarnings("unchecked")
	private void lookupCodes(List<String> codes) {
		for (int i = 0, length = codes.size(); i < length; i++) {
			String line = codes.get(i);
			String[] words = StringUtils.split(line);
			if (StringUtils.isNotBlank(line) && ArrayUtils.getLength(words) == 3) {
				try {
					Class<? extends Code> c = (Class<? extends Code>) Class.forName("ca.infoway.messagebuilder.domainvalue." + words[0]);
					this.resolver.lookup(c, words[1], words[2]);
				} catch (ClassNotFoundException e) {
					System.out.println(words[0] + " cannot be resolved to a Code type");
				}
			}			
		}
	}

	private void resetSession() {
		closeSession();
		openSession();
	}

	private void openSession() {
		Session session = this.factory.openSession();
        TransactionSynchronizationManager.bindResource(this.factory, new SessionHolder(session));
	}

	private void closeSession() {
		SessionHolder holder = (SessionHolder) TransactionSynchronizationManager.getResource(
                this.factory);
        Session session = holder.getSession();
        TransactionSynchronizationManager.unbindResource(this.factory);
        session.close();
	}

	public Properties createProperties(boolean cache) {
		Properties properties = new Properties();
		properties.setProperty("hibernate.connection.url", "jdbc:postgresql://127.0.0.1:5432/chi");
		properties.setProperty("hibernate.connection.username", "postgres");
		properties.setProperty("hibernate.connection.password", "password");
		properties.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		
		properties.setProperty("hibernate.cache.provider_class", "org.hibernate.cache.HashtableCacheProvider");
		properties.setProperty("hibernate.cache.use_second_level_cache", cache ? "true" : "false");
		properties.setProperty("hibernate.cache.use_query_cache", cache ? "true" : "false");
		return properties;
	}
	
	public void createDao(boolean secondLevelCache) {
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.setNamingStrategy(new ImprovedNamingStrategy());
		configuration.setProperties(createProperties(secondLevelCache));
		configuration.addAnnotatedClass(VocabularyDomain.class);
		configuration.addAnnotatedClass(CodeSystem.class);
		configuration.addAnnotatedClass(CodedValue.class);
		configuration.addAnnotatedClass(ValueSet.class);
		configuration.addAnnotatedClass(ValueSetEntry.class);
		
		this.factory = configuration.buildSessionFactory();
		this.dao = new HibernateCodeSetDao(this.factory);
	}
	
}
