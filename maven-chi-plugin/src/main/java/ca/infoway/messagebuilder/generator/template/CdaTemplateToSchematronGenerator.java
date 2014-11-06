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
 * Author:        $LastChangedBy: jroberts $
 * Last modified: $LastChangedDate: 2014-07-10 12:26:14 -0400 (Thu, 10 Jul 2014) $
 * Revision:      $LastChangedRevision: 8803 $
 */

package ca.infoway.messagebuilder.generator.template;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;

import com.helger.schematron.pure.model.PSAssertReport;
import com.helger.schematron.pure.model.PSNS;
import com.helger.schematron.pure.model.PSPattern;
import com.helger.schematron.pure.model.PSRule;
import com.helger.schematron.pure.model.PSSchema;

import ca.infoway.messagebuilder.GeneratorException;
import ca.infoway.messagebuilder.generator.OutputUI;
import ca.infoway.messagebuilder.maven.util.OutputUIImpl;

public class CdaTemplateToSchematronGenerator {

	private final OutputUI outputUI;
	private static Serializer serializer = new Persister(new AnnotationStrategy());
	
	public CdaTemplateToSchematronGenerator(OutputUIImpl outputUI, boolean useR2Datatypes) {
		this.outputUI = outputUI;
		
	}

	public void processAllCdaFiles(File templateFile) throws GeneratorException, IOException {
		try {
			TemplateExport templateExport = (TemplateExport) serializer.read(TemplateExport.class, templateFile);
			
			PSSchema schema = new PSSchema();
			PSNS namespace = new PSNS();
			namespace.setPrefix("cda");
			namespace.setUri("urn:hl7-org:v3");
			schema.addNS(namespace);
			
			for (CdaTemplate template : templateExport.getTemplates()) {
				List<String> tests = new ArrayList<String>();
				gatherTests(template.getConstraints(), tests);
				if (!tests.isEmpty()) {
					PSPattern pattern = new PSPattern();
					schema.addPattern(pattern);
					
					PSRule rule = new PSRule();
					rule.setContext(formatRuleContext(template));
					pattern.addRule(rule);
					
					for (String test : tests) {
						PSAssertReport assertReport = new PSAssertReport(true);
						assertReport.setTest(test);
						rule.addAssertReport(assertReport);
					}
				}
			}
			
		} catch (Exception e) {
			throw new GeneratorException(e);
		}

	}

	private String formatRuleContext(CdaTemplate template) {
		return "//cda:" + template.getContext() + "[templateId/@root=" + template.getOid() + "]";
	}

	private void gatherTests(List<CdaConstraint> constraints, List<String> tests) {
		for (CdaConstraint constraint : constraints) {
			if (isInteresting(constraint.getSchematronTest())) {
				tests.add(constraint.getSchematronTest().getTest());
			}
			gatherTests(constraint.getConstraints(), tests);
		}
	}

	private boolean isInteresting(SchematronTest schematronTest) {
		if (schematronTest == null) {
			return false;
		}
		
		if (schematronTest.getTest() == null) {
			return false;
		}
		
		String test = schematronTest.getTest();
		if (StringUtils.equals(test, ".")) {
			return false;
		}
		if (StringUtils.equals(test, "not(tested)")) {
			return false;
		}
		if (StringUtils.equals(test, "not(tested-here)")) {
			return false;
		}
		if (StringUtils.equals(test, "not(testable)")) {
			return false;
		}
		
		return true;
	}

}
