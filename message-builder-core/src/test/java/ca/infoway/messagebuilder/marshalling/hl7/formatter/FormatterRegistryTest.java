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

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.List;

import org.apache.commons.lang.ClassUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.j5goodies.JavaFileUtil;
import ca.infoway.messagebuilder.platform.ClassUtil;
import ca.infoway.messagebuilder.platform.SourceCodeLocationUtil;


public class FormatterRegistryTest {

    @Test
    @SuppressWarnings("unchecked")
    public void testAllFormattersAreRegistered() throws Exception {
        List<File> files = getAllClasses();
        
        for (File file : files) {
            String javaClassName = JavaFileUtil.convertFileNameToJavaClassName(SourceCodeLocationUtil.SOURCE_DIRECTORY, file);
            try {
	            Class<?> javaClass = Class.forName(javaClassName);
	            if (isFormatter(javaClass)) {
	                assertFormatterIsRegistered((Class<? extends PropertyFormatter>) javaClass);
	            }
            } catch (ClassNotFoundException e) {
            	// this case shouldn't happen in Java, but is useful when the code is 
            	// converted to .Net
            }
        }
    }

    private void assertFormatterIsRegistered(Class<? extends PropertyFormatter> javaClass) throws Exception {
        List<String> keys = FormatterRegistry.getInstance().getRegistrationKey(javaClass);
        for (String string : keys) {
            assertNotNull("register " + javaClass.getName() + " (" + string + ")", 
                    FormatterRegistry.getInstance().get(string));
        }
    }

    private boolean isFormatter(Class<?> javaClass) {
        return PropertyFormatter.class.isAssignableFrom(javaClass) && !ClassUtil.isAbstract(javaClass);
    }

    private List<File> getAllClasses() {
    	return SourceCodeLocationUtil.getAllSourceFiles(ClassUtils.getPackageName(getClass()));
    }

    @Test
    public void testShouldFindListIiOidFormatter() throws Exception {
    	assertNotNull("formatter", FormatterRegistry.getInstance().get("LIST<II.OID>"));
	}
}
