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

package ca.infoway.messagebuilder.acceptance.runner.javadoc;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.mutable.MutableInt;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.puppycrawl.tools.checkstyle.Checker;
import com.puppycrawl.tools.checkstyle.ConfigurationLoader;
import com.puppycrawl.tools.checkstyle.DefaultConfiguration;
import com.puppycrawl.tools.checkstyle.PropertiesExpander;
import com.puppycrawl.tools.checkstyle.api.AuditEvent;
import com.puppycrawl.tools.checkstyle.api.AuditListener;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration;

public class JavadocChecker {
	
	private final Log log = LogFactory.getLog(this.getClass());

	public JavadocCheckerResult process(List<File> files) {
		
		final MutableInt totalCandidateLocations = new MutableInt(0);
		final Map<String, List<String>> locationsMissingJavadoc = new HashMap<String, List<String>>();
		
		Checker checker = createChecker(new AuditListener() {
			public void fileStarted(AuditEvent event) {
				totalCandidateLocations.increment();
			}
			public void fileFinished(AuditEvent event) {
			}
			public void auditStarted(AuditEvent event) {
			}
			public void auditFinished(AuditEvent event) {
			}
			public void addException(AuditEvent event, Throwable aThrowable) {
			}
			public void addError(AuditEvent event) {
				String fileName = event.getFileName();
				List<String> msgs = locationsMissingJavadoc.get(fileName);
				if (msgs == null) {
					msgs = new ArrayList<String>();
					locationsMissingJavadoc.put(fileName, msgs);
				}
				msgs.add(fileName + ": " + event.getMessage());
			}
		});
		
		checker.process(files.toArray(new File[files.size()]));
		
		return new JavadocCheckerResult(totalCandidateLocations.intValue(), locationsMissingJavadoc);
	}
	
	private Checker createChecker(AuditListener listener) {
		Configuration configuration;
		try {
			configuration = ConfigurationLoader.loadConfiguration(
					getClass().getResourceAsStream("checkstyle-configuration.xml"), 
					new PropertiesExpander(new Properties()), 
					true);
		} catch (CheckstyleException e) {
			log.error("Unable to read checkstyle configuration, using default configuration instead.", e);
			configuration = new DefaultConfiguration("DEFAULT-" + getClass().getName());
		}
		
		Checker checker = null;
		try {
			checker = new Checker();
			checker.configure(configuration);
			checker.addListener(listener);
		} catch (final Exception e) {
			log.error("Unable to create Checkstyle checker", e);
		}
		return checker;
	}

}
