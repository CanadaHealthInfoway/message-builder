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

package ca.infoway.messagebuilder.acceptance.runner.javadoc;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.mutable.MutableDouble;
import org.apache.commons.lang.mutable.MutableObject;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.acceptance.runner.AcceptanceTestResultCallback;

@RunWith(JMock.class)
public class JavadocAcceptanceTestRunnerTest {

	private final Mockery jmock = new JUnit4Mockery() {{
		setImposteriser(ClassImposteriser.INSTANCE);
	}};
	
	private final JavadocChecker checker = jmock.mock(JavadocChecker.class);
	private final FilesProvider filesToCheck = jmock.mock(FilesProvider.class);
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldCheckClassJavadoc() throws Exception {
		JavadocAcceptanceTestRunner runner = new JavadocAcceptanceTestRunner("name", this.checker, this.filesToCheck);
		final Map<String, List<String>> filesWithErrors = new HashMap<String, List<String>>();
		filesWithErrors.put("file1", Arrays.asList("msg1"));
		filesWithErrors.put("file2", Arrays.asList("msg2"));
		
		final List<File> files = Collections.emptyList();
		
		this.jmock.checking(new Expectations(){{
			one(filesToCheck).getFiles(); will(returnValue(files));
			one(checker).process(files); 
			will(returnValue(new JavadocCheckerResult(
					10, 
					filesWithErrors)));
		}});

		final MutableObject actualName = new MutableObject(); 
		final MutableDouble actualPercentSuccessful = new MutableDouble();
		final MutableObject actualMessages = new MutableObject();

		runner.run(new AcceptanceTestResultCallback() {
			public void done(String name, int numSuccessful, int numTotal, List<String> messages) {
				actualName.setValue(name);
				actualPercentSuccessful.setValue(numSuccessful * 100.0 / numTotal);
				actualMessages.setValue(messages);
			}
		});
		
		assertThat("name", equalTo(actualName.getValue()));
		assertThat(80.0, equalTo(actualPercentSuccessful.getValue()));
		assertThat((List<String>) actualMessages.getValue(), hasItem("msg1"));
		assertThat((List<String>) actualMessages.getValue(), hasItem("msg2"));
	}
	
	@Test
	public void checkstyleIsConfiguredCorrectly() throws Exception {
		final File fileWithAllJavadocs = new File(getClass().getResource("ClassWithAllJavadocs.java1").getFile());
		final File fileMissingJavadocs = new File(getClass().getResource("ClassMissingJavadocs.java1").getFile());
		
		final MutableDouble actualPercentSuccessful = new MutableDouble();
		
		new JavadocAcceptanceTestRunner("test", new FilesProvider(){
			public List<File> getFiles() {
				return Arrays.asList(fileWithAllJavadocs, fileMissingJavadocs);
			}
			
		}).run(new AcceptanceTestResultCallback() {
			public void done(String name, int numSuccessful, int numTotal, List<String> messages) {
				actualPercentSuccessful.setValue(numSuccessful * 100.0 / numTotal);
			}
		});
		
		assertThat(50.0, equalTo(actualPercentSuccessful.getValue()));
		 
	}
	
}
