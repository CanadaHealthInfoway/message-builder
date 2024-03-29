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

package ca.infoway.messagebuilder.acceptance;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.acceptance.runner.AcceptanceTestRunner;
import ca.infoway.messagebuilder.acceptance.runner.javadoc.JavadocAcceptanceTestRunner;
import ca.infoway.messagebuilder.acceptance.runner.javadoc.JavadocChecker;
import ca.infoway.messagebuilder.acceptance.runner.javadoc.JavadocCheckerResult;
import ca.infoway.messagebuilder.acceptance.runner.javadoc.ProjectFilesProvider;
import ca.infoway.messagebuilder.util.iterator.NodeListIterator;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.util.xml.NodeUtil;

public class JavadocProjectCheckTest {

	private static final String JAVADOCS_GROUP_NAME = "Javadocs";
	
	private final Set<String> projectExclusions = new HashSet<String>();
	{
		this.projectExclusions.add("message-builder-simple-xml-process-web");
	}
	
	private final List<String> projectsWithFullJavadocs = Arrays.asList(
//			"chi-maven-plugin",
//			"message-builder-core", 
			"message-builder-terminology"
//			"message-builder-merge-comparator",
//			"message-builder-generator-tools",
//			"message-builder-release-newfoundland",
//			"message-builder-hl7v3-release-pcs_mr2009_r02_04_02",
//			"message-builder-hl7v3-release-pcs_cerx_v01_r04_3",
//			"message-builder-hl7v3-release-pcs_mr2007_v02_r02",
//			"message-builder-sample-messages",
//			"message-builder-example",
//			"message-builder-acceptance",
//			"message-builder-model",
//			"message-builder-developer-tools",
		);

	@Before
	public void initialize() {
		// set up project exclusions here
		this.projectExclusions.add("message-builder-maven-executor");
		this.projectExclusions.add("message-builder-acceptance");
		this.projectExclusions.add("message-builder-release-newfoundland");
		this.projectExclusions.add("message-builder-ccda-r1_1");
		this.projectExclusions.add("message-builder-ccda-pcs-r1_1");
		this.projectExclusions.add("message-builder-pcs-cda-r1_2");
		this.projectExclusions.add("message-builder-hl7v3-release-pcs_mr2009_r02_04_02");
		this.projectExclusions.add("message-builder-hl7v3-release-pcs_mr2009_r02_04_03");
		this.projectExclusions.add("message-builder-hl7v3-release-pcs_mr2009_r02_05_00");
		this.projectExclusions.add("message-builder-hl7v3-release-pcs_cerx_v01_r04_3");
		this.projectExclusions.add("message-builder-hl7v3-release-pcs_cerx_v01_r04_4");
		this.projectExclusions.add("message-builder-hl7v3-release-on_cerx_v01_r04_3");
		this.projectExclusions.add("message-builder-hl7v3-release-pcs_mr2007_v02_r02");
		this.projectExclusions.add("message-builder-hl7v3-release-sk_cerx_v01_r04_3");
		this.projectExclusions.add("message-builder-hl7v3-release-ab_mr2007_v02_r02");
		this.projectExclusions.add("message-builder-hl7v3-release-ab_mr2009_r02_04_03");
		this.projectExclusions.add("message-builder-hl7v3-release-ab_mr2009_r02_04_03_imm");
		this.projectExclusions.add("message-builder-hl7v3-release-nb_drug");
		this.projectExclusions.add("message-builder-hl7v3-release-nb_pr_cr_lr");
		this.projectExclusions.add("message-builder-hl7v3-release-ns_mr2009_r02_04_03");
		this.projectExclusions.add("message-builder-hl7v3-release-ns_cerx_v01_r04_3");
		this.projectExclusions.add("message-builder-mif-comparer");
		this.projectExclusions.add("message-builder-demiftifier");
		this.projectExclusions.add("message-builder-html");
		this.projectExclusions.add("junitUtils");
		this.projectExclusions.add("dependency-analyzer");
		this.projectExclusions.add("stylesheet");
		this.projectExclusions.add("src");
		this.projectExclusions.add("target");
		this.projectExclusions.add(".svn");
		
		// this shouldn't be necessary, but the build server still has a dangling reference
		// to this folder
		this.projectExclusions.add("message-builder-simple-xml-marshaller");
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldProvideJavadocAcceptanceTestRunnerForEveryMessageBuilderProject() throws Exception {
		Set<String> allMessageBuilderProjects = obtainAllMessageBuilderProjectNames();
		Set<String> javadocProjectsInSpringConfig = extractProjectNamesFromSpring();
		
		allMessageBuilderProjects.removeAll(this.projectExclusions);

		List<String> errorMessages = new ArrayList<String>();

		Collection<String> projectsNotReferencedInSpring = ListUtils.removeAll(allMessageBuilderProjects, javadocProjectsInSpringConfig);
		for (String project : projectsNotReferencedInSpring) {
			errorMessages.add("Project exists but is neither listed in MainAcceptanceTestsRunnerContext.xml nor excluded from test: " + project);
		}
		
		Collection<String> projectsNotFoundInMessageBuilder = ListUtils.removeAll(javadocProjectsInSpringConfig, allMessageBuilderProjects);
		for (String project : projectsNotFoundInMessageBuilder) {
			errorMessages.add("Project referenced in MainAcceptanceTestsRunnerContext.xml but is either excluded from test or not found: " + project);
		}
		
		Assert.assertTrue(StringUtils.join(errorMessages, "\n"), errorMessages.isEmpty());
	}

	private Set<String> obtainAllMessageBuilderProjectNames() throws Exception {
		Set<String> result = new HashSet<String>();

		Document document = readParentPom();
		NodeList nodes = document.getElementsByTagNameNS("http://maven.apache.org/POM/4.0.0", "module");
		for (Element element : NodeListIterator.elementIterable(nodes)) {
			result.add(NodeUtil.getTextValue(element));
		}
System.out.println(result);
		return result;
	}
	
	private Document readParentPom() throws SAXException, IOException {
		return new DocumentFactory().createFromFile(new File("../pom.xml"));
	}

	private Set<String> extractProjectNamesFromSpring() {
		Set<String> javadocProjectsInSpringConfig = new HashSet<String>();
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"MainAcceptanceTestsRunnerContext.xml"});
		context.registerShutdownHook();
		
		MainAcceptanceTestsRunner mainRunner = context.getBean("ca.infoway.messagebuilder.acceptance.MainAcceptanceTestsRunner", MainAcceptanceTestsRunner.class);
		List<AcceptanceTestsMetricsProcessor> acceptaneTestsProcessors = mainRunner.getAcceptaneTestsProcessors();
		for (AcceptanceTestsMetricsProcessor processor : acceptaneTestsProcessors) {
			String groupName = processor.getGroupName();
			if (JAVADOCS_GROUP_NAME.equals(groupName)) {
				List<AcceptanceTestRunner> acceptanceTestRunners = processor.getAcceptanceTestRunners();
				for (AcceptanceTestRunner acceptanceTestRunner : acceptanceTestRunners) {
					extractProjectNames(javadocProjectsInSpringConfig, acceptanceTestRunner);
				}
			}
		}
		return javadocProjectsInSpringConfig;
	}

	private void extractProjectNames(Set<String> javadocProjectsInSpringConfig,	AcceptanceTestRunner acceptanceTestRunner) {
		JavadocAcceptanceTestRunner runner = (JavadocAcceptanceTestRunner) acceptanceTestRunner;
		ProjectFilesProvider filesToCheck = (ProjectFilesProvider) runner.getFilesToCheck();
		List<String> projectNames = filesToCheck.getProjectNames();
		javadocProjectsInSpringConfig.addAll(projectNames);
	}

	@Test
	public void shouldEnsureProjectsWithFullJavadocsStayThatWay() {
		ProjectFilesProvider filesProvider = new ProjectFilesProvider(this.projectsWithFullJavadocs);
		JavadocCheckerResult result = new JavadocChecker().process(filesProvider.getFiles());
		if (!result.getFilesMissingJavadoc().isEmpty()) {
			Assert.fail("Expected to find no missing javadocs in fully-documented projects. Errors:\n" + generateErrorMessage(result.getAllMessages()));
		}
	}

	private String generateErrorMessage(List<String> allMessages) {
		StringBuffer sb = new StringBuffer();
		for (String message : allMessages) {
			sb.append('\n').append(message);
		}
		return sb.toString();
	}
	
}
