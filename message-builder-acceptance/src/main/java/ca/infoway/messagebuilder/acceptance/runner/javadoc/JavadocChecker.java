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
