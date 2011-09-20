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

package ca.infoway.messagebuilder.marshalling.hl7.parser;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.apache.commons.lang.ClassUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.j5goodies.JavaFileUtil;
import ca.infoway.messagebuilder.platform.ClassUtil;
import ca.infoway.messagebuilder.platform.SourceCodeLocationUtil;

public class ParserRegistryTest {
	
	@Test
	public void testShouldFindSimpleCase() throws Exception {
		assertNotNull("II", ParserRegistry.getInstance().get("II"));
	}

	@Test
	public void testShouldDefaultToUnqualifiedTypeIfNoSpecificParserExists() throws Exception {
		assertNotNull("II.TOKEN", ParserRegistry.getInstance().get("II.TOKEN"));
	}
	
	@Test
	public void testShouldFindCeParser() throws Exception {
		assertTrue("CE", ParserRegistry.getInstance().get("CE") instanceof CvElementParser);
	}
	
    @Test
    @SuppressWarnings("unchecked")
    public void testAllParsersAreRegistered() throws Exception {
        List<File> files = getAllClasses();
        
        for (File file : files) {
            String className = JavaFileUtil.convertFileNameToJavaClassName(SourceCodeLocationUtil.SOURCE_DIRECTORY, file);
            try {
	            Class<?> otherClassName = Class.forName(className);
	            if (isParser(otherClassName)) {
	                assertParserIsRegistered((Class<? extends ElementParser>) otherClassName);
	            }
            } catch (ClassNotFoundException e) {
            	// this case shouldn't happen, but is useful when the code is 
            	// translated
            }
        }
    }

	private void assertParserIsRegistered(Class<? extends ElementParser> classObj) throws Exception {
        List<String> keys = ParserRegistry.getInstance().getRegistrationKey(classObj);
        for (String string : keys) {
            assertNotNull("register " + classObj.getName() + " (" + string + ")", 
                    ParserRegistry.getInstance().get(string));
        }
    }

    private boolean isParser(Class<?> classObj) {
        return ElementParser.class.isAssignableFrom(classObj) && !ClassUtil.isAbstract(classObj);
    }

    private List<File> getAllClasses() {
        return SourceCodeLocationUtil.getAllSourceFiles(ClassUtils.getPackageName(getClass()));
    }

    
}
