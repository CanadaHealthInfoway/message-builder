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
import japa.parser.JavaParser;
import japa.parser.ast.CompilationUnit;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

import org.junit.Test;


public class BeanVisitorTest {

	@Test
	public void shouldFind4Methods() throws Exception {
		BeanVisitor myVisitor = new BeanVisitor();
		CompilationUnit oldCompilationUnit = JavaParser.parse(new FileInputStream(new File("./src/test/java/ca/infoway/messagebuilder/comparator/oldbean/SampleBean.java")));
		myVisitor.visit(oldCompilationUnit, oldCompilationUnit);
		Map<String, String> methodMap = myVisitor.getSignatureToReturnTypeMap();
		assertEquals(4, methodMap.size());
	}

	@Test
	public void shouldFind3Methods() throws Exception {
		BeanVisitor myVisitor = new BeanVisitor();
		CompilationUnit oldCompilationUnit = JavaParser.parse(new FileInputStream(new File("./src/test/java/ca/infoway/messagebuilder/comparator/newbean/SampleBean.java")));
		myVisitor.visit(oldCompilationUnit, oldCompilationUnit);
		Map<String, String> methodMap = myVisitor.getSignatureToReturnTypeMap();
		assertEquals(3, methodMap.size());
	}
}
