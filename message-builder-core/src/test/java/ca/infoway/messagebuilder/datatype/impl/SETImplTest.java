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

package ca.infoway.messagebuilder.datatype.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.StandardDataType;

/**
 * @sharpen.ignore - datatype - translated manually
 */
public class SETImplTest {

	@Test
	public void shouldBeAbleToCreateSet() {
		SET<ST, String> testSet = new SETImpl<ST, String>(STImpl.class);
		
		assertEquals(StandardDataType.SET, testSet.getDataType());
		assertTrue(testSet.getValue().isEmpty());
		assertNull(testSet.getNullFlavor());
	}
	
	@Test
	public void shouldBeAbleToAddToSet() {
		SET<ST, String> testSet = new SETImpl<ST, String>(STImpl.class);

		Set<String> rawSet = testSet.rawSet(String.class);
		boolean result = rawSet.add("newString");
		
		assertTrue(result);
		assertFalse(testSet.getValue().isEmpty());
		assertEquals(1, testSet.getValue().size());
		assertEquals(1, testSet.rawSet().size());
		assertEquals("newString", testSet.getValue().iterator().next().getValue());
		assertEquals("newString", testSet.rawSet().iterator().next());
		assertNull(testSet.getValue().iterator().next().getNullFlavor());
	}
	
	@Test
	public void shouldBeAbleToAddMultipleElementsToSet() {
		SET<ST, String> testSet = new SETImpl<ST, String>(STImpl.class);

		Set<String> rawSet = testSet.rawSet();
		rawSet.add("newString1");
		rawSet.add("newString2");
		
		assertFalse(testSet.getValue().isEmpty());
		assertEquals(2, testSet.getValue().size());
		assertTrue(testSet.rawSet().contains("newString1"));
		assertTrue(testSet.rawSet().contains("newString2"));
		
		rawSet.add("newString3");
		assertEquals(3, testSet.getValue().size());
		assertTrue(testSet.rawSet().contains("newString3"));
		
		boolean result = rawSet.addAll(Arrays.asList("newString4", "newString5"));
		assertTrue(result);
		assertEquals(5, testSet.getValue().size());
		assertTrue(testSet.rawSet().contains("newString4"));
		assertTrue(testSet.rawSet().contains("newString5"));
		
		result = rawSet.addAll(Collections.<String>emptySet());
		assertFalse(result);
		assertEquals(5, testSet.getValue().size());
		
		assertTrue(testSet.rawSet().containsAll(Arrays.asList("newString1", "newString2", "newString3", "newString4", "newString5")));
	}
	
	@Test
	public void shouldBeAbleToRemoveMultipleElementsFromSet() {
		SET<ST, String> testSet = new SETImpl<ST, String>(STImpl.class);
		
		Set<String> rawSet = testSet.rawSet();
		rawSet.add("newString1");
		rawSet.add("newString2");
		rawSet.add("newString3");
		rawSet.add("newString4");
		rawSet.add("newString5");
		rawSet.add("newString6");
		
		assertTrue(testSet.rawSet().contains("newString2"));
		boolean result = rawSet.remove("newString2");
		assertEquals(5, testSet.getValue().size());
		assertTrue(result);
		assertFalse(testSet.rawSet().contains("newString2"));
		
		assertTrue(testSet.rawSet().contains("newString6"));
		boolean booleanResult = rawSet.remove("newString6");
		assertEquals(4, testSet.getValue().size());
		assertTrue(booleanResult);
		assertFalse(testSet.rawSet().contains("newString6"));
		
		booleanResult = rawSet.remove("newString123");
		assertFalse(booleanResult);
		assertEquals(4, testSet.getValue().size());
		
		booleanResult = rawSet.removeAll(Collections.<String>emptySet());
		assertFalse(booleanResult);
		assertEquals(4, testSet.getValue().size());
		
		booleanResult = rawSet.removeAll(Arrays.asList("newString3", "newString5"));
		assertTrue(booleanResult);
		assertEquals(2, testSet.getValue().size());
		assertTrue(testSet.rawSet().contains("newString1"));
		assertTrue(testSet.rawSet().contains("newString4"));
		
		booleanResult = rawSet.removeAll(Arrays.asList("newString3", "newString5"));
		assertFalse(booleanResult);
		assertEquals(2, testSet.getValue().size());
		assertTrue(testSet.rawSet().contains("newString1"));
		assertTrue(testSet.rawSet().contains("newString4"));

		booleanResult = rawSet.retainAll(Arrays.asList("newString4", "newString1"));
		assertFalse(booleanResult);
		assertEquals(2, testSet.getValue().size());
		assertTrue(testSet.rawSet().contains("newString1"));
		assertTrue(testSet.rawSet().contains("newString4"));

		booleanResult = rawSet.retainAll(Arrays.asList("newString4"));
		assertTrue(booleanResult);
		assertEquals(1, testSet.getValue().size());
		assertTrue(testSet.rawSet().contains("newString4"));
		
		rawSet.clear();
		assertTrue(testSet.getValue().isEmpty());
		assertTrue(testSet.rawSet().isEmpty());
	}
	
	@Test
	public void shouldBeAbleToIterateRawSet() {
		SET<ST, String> testSet = new SETImpl<ST, String>(STImpl.class);
		
		Set<String> rawSet = testSet.rawSet();
		rawSet.add("newString0");
		rawSet.add("newString1");
		rawSet.add("newString2");
		rawSet.add("newString3");
		
		for (Iterator<String> iterator = rawSet.iterator(); iterator.hasNext();) {
			String string = iterator.next();
			rawSet.contains(string);
		}
	}
	
	@Test
	public void shouldBeAbleToObtainArrayFromSet() {
		SET<ST, String> testSet = new SETImpl<ST, String>(STImpl.class);
		
		Set<String> rawSet = testSet.rawSet();
		rawSet.add("newString0");
		rawSet.add("newString1");
		rawSet.add("newString2");
		rawSet.add("newString3");
		
		Object[] array = rawSet.toArray();
		assertEquals(4, array.length);
		
		assertTrue(Arrays.asList(array).contains("newString0"));
		assertTrue(Arrays.asList(array).contains("newString1"));
		assertTrue(Arrays.asList(array).contains("newString2"));
		assertTrue(Arrays.asList(array).contains("newString3"));
	}

}
