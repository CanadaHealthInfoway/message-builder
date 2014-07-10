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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.parser.r2;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.List;

import org.apache.commons.lang.ClassUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.j5goodies.ClassFileUtil;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ElementParser;
import ca.infoway.messagebuilder.platform.ClassUtil;
import ca.infoway.messagebuilder.platform.SourceCodeLocationUtil;

public class ParserR2RegistryTest {
	
//	@Test
//	public void testShouldFindSimpleCase() throws Exception {
//		assertNotNull("II", ParserR2Registry.getInstance().get("II"));
//	}

	@Test
	public void testShouldFindSimpleCaseSt() throws Exception {
		assertNotNull("ST", ParserR2Registry.getInstance().get("ST"));
	}

//	@Test
//	public void testShouldDefaultToUnqualifiedTypeIfNoSpecificParserExists() throws Exception {
//		assertNotNull("II.TOKEN", ParserR2Registry.getInstance().get("II.TOKEN"));
//	}
	
//	@Test
//	public void testShouldFindCeParser() throws Exception {
//		assertTrue("CE", ParserR2Registry.getInstance().get("CE") instanceof CvElementParser);
//	}
	
//	@Test
//	public void testShouldFindSetParser() throws Exception {
//		ElementParser elementParser = ParserR2Registry.getInstance().get("SET<RTO<PQ.DRUG,PQ.TIME>>");
//		assertTrue("SET", elementParser instanceof SetElementParser);
//	}
	
//	@Test
//	public void testShouldFindRtoParsers() throws Exception {
//		ElementParser elementParser = ParserR2Registry.getInstance().get("RTO<PQ.DRUG,PQ.TIME>");
//		assertNotNull(elementParser);
//		assertTrue("RTO<PQ,PQ>", elementParser instanceof RtoPqPqElementParser);
//		
//		elementParser = ParserR2Registry.getInstance().get("RTO<PQ.DRUG,PQ.DRUG>");
//		assertNotNull(elementParser);
//		assertTrue("RTO<PQ,PQ>", elementParser instanceof RtoPqPqElementParser);
//
//		elementParser = ParserR2Registry.getInstance().get("RTO<MO.CAD,PQ.BASIC>");
//		assertNotNull(elementParser);
//		assertTrue("RTO<MO,PQ>", elementParser instanceof RtoMoPqElementParser);
//	}
	
    @Test
    @SuppressWarnings("unchecked")
    public void testAllParsersAreRegistered() throws Exception {
        List<File> files = getAllClasses();
        
        for (File file : files) {
            String className = ClassFileUtil.convertFileNameToClassName(SourceCodeLocationUtil.SOURCE_DIRECTORY, file);
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
        List<String> keys = ParserR2Registry.getInstance().getRegistrationKey(classObj);
        for (String string : keys) {
            assertNotNull("register " + classObj.getName() + " (" + string + ")", 
                    ParserR2Registry.getInstance().get(string));
        }
    }

    private boolean isParser(Class<?> classObj) {
        return ElementParser.class.isAssignableFrom(classObj) && !ClassUtil.isAbstract(classObj) &&
        		ClassUtils.getPackageName(ParserR2Registry.class).equals(ClassUtils.getPackageName(classObj));
    }

    private List<File> getAllClasses() {
        return SourceCodeLocationUtil.getAllSourceFiles(ClassUtils.getPackageName(getClass()));
    }

    
}
