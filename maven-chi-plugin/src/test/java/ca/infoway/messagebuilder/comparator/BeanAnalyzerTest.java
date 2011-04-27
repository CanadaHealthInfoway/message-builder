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

package ca.infoway.messagebuilder.comparator;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.List;

import org.junit.Test;

import ca.infoway.messagebuilder.comparator.BeanAnalyzer.ErrorType;

public class BeanAnalyzerTest {

	@Test
	public void analyze() throws Exception {
		 BeanAnalysisResult result = new BeanAnalyzer(
				 convertPathString("./src/test/java/ca/infoway/messagebuilder/comparator/oldbean/"),
						 convertPathString("./src/test/java/ca/infoway/messagebuilder/comparator/newbean/")
				 ).analyze();
		 System.out.println(result.getBeanAnalysisReport());
		 System.out.println("DONE!");
	}
	
	@Test
	public void shouldFindErrorsForOneBeanInSuiteRun() throws Exception {
		BeanAnalysisResult result = new BeanAnalyzer(
				convertPathString("./src/test/java/ca/infoway/messagebuilder/comparator/oldbean/"),
				convertPathString("./src/test/java/ca/infoway/messagebuilder/comparator/newbean/")
		).analyze();
		List<BeanAnalysisError> errors = result.getBeanAnalysisErrors(convertPathString("./src/test/java/ca/infoway/messagebuilder/comparator/oldbean/SampleBean.java"));
		assertEquals(3, errors.size());
		assertEquals(ErrorType.EXTENDS, errors.get(0).getErrorType());
		assertEquals(ErrorType.IMPLEMENTS, errors.get(1).getErrorType());
		assertEquals(ErrorType.METHOD_NOT_FOUND, errors.get(2).getErrorType());
	}
	
	@Test
	public void shouldFindErrorsForOneBean() throws Exception {
		List<BeanAnalysisError> errors = 
			new BeanAnalyzer(
					convertPathString("./src/test/java/ca/infoway/messagebuilder/comparator/oldbean/"),
					convertPathString("./src/test/java/ca/infoway/messagebuilder/comparator/newbean/")
			).analyzeFile(new File("./src/test/java/ca/infoway/messagebuilder/comparator/oldbean/SampleBean.java"));
		assertEquals(3, errors.size());
		assertEquals(ErrorType.EXTENDS, errors.get(0).getErrorType());
		assertEquals(ErrorType.IMPLEMENTS, errors.get(1).getErrorType());
		assertEquals(ErrorType.METHOD_NOT_FOUND, errors.get(2).getErrorType());
	}
	
    private String convertPathString(String path) {
        return path.replace('/', System.getProperty("file.separator").charAt(0));
    }
}
