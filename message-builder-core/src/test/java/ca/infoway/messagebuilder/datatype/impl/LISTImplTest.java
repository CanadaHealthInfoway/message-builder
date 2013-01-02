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

package ca.infoway.messagebuilder.datatype.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.StandardDataType;

/**
 * @sharpen.ignore - datatype - translated manually
 */
public class LISTImplTest {

	@Test
	public void shouldBeAbleToCreateList() {
		LIST<ST, String> testList = new LISTImpl<ST, String>(STImpl.class);
		
		assertEquals(StandardDataType.LIST, testList.getDataType());
		assertTrue(testList.getValue().isEmpty());
		assertNull(testList.getNullFlavor());
	}
	
	@Test
	public void shouldBeAbleToAddToList() {
		LIST<ST, String> testList = new LISTImpl<ST, String>(STImpl.class);

		List<String> rawList = testList.rawList(String.class);
		boolean result = rawList.add("newString");
		
		assertTrue(result);
		assertFalse(testList.getValue().isEmpty());
		assertEquals(1, testList.getValue().size());
		assertEquals(1, testList.rawList().size());
		assertEquals("newString", getElement(testList, 0).getValue());
		assertEquals("newString", testList.rawList().get(0));
		assertNull(getElement(testList, 0).getNullFlavor());
	}

	private ST getElement(LIST<ST, String> testList, int index) {
		return ((List<ST>) testList.getValue()).get(index);
	}
	
	@Test
	public void shouldBeAbleToAddMultipleElementsToList() {
		LIST<ST, String> testList = new LISTImpl<ST, String>(STImpl.class);

		List<String> rawList = testList.rawList(String.class);
		rawList.add("newString1");
		rawList.add("newString2");
		
		assertFalse(testList.getValue().isEmpty());
		assertEquals(2, testList.getValue().size());
		assertEquals("newString1", getElement(testList, 0).getValue());
		assertEquals("newString2", getElement(testList, 1).getValue());
		assertNull(getElement(testList, 0).getNullFlavor());
		assertNull(getElement(testList, 1).getNullFlavor());
		
		rawList.add(0, "newString3");
		assertEquals(3, testList.getValue().size());
		assertEquals("newString3", getElement(testList, 0).getValue());
		
		boolean result = rawList.addAll(Arrays.asList("newString4", "newString5"));
		assertTrue(result);
		assertEquals(5, testList.getValue().size());
		assertEquals("newString4", getElement(testList, 3).getValue());
		assertEquals("newString5", getElement(testList, 4).getValue());
		
		result = rawList.addAll(2, Collections.<String>emptyList());
		assertFalse(result);
		assertEquals(5, testList.getValue().size());
		
		result = rawList.addAll(2, Arrays.asList("newString6", "newString7"));
		assertTrue(result);
		assertEquals(7, testList.getValue().size());
		assertEquals("newString3", getElement(testList, 0).getValue());
		assertEquals("newString1", getElement(testList, 1).getValue());
		assertEquals("newString6", getElement(testList, 2).getValue());
		assertEquals("newString7", getElement(testList, 3).getValue());
		assertEquals("newString2", getElement(testList, 4).getValue());
		assertEquals("newString4", getElement(testList, 5).getValue());
		assertEquals("newString5", getElement(testList, 6).getValue());
		
		assertTrue(testList.rawList().containsAll(Arrays.asList("newString1", "newString2", "newString3", "newString4", "newString5", "newString6", "newString7")));
	}
	
	@Test
	public void shouldBeAbleToRemoveMultipleElementsFromList() {
		LIST<ST, String> testList = new LISTImpl<ST, String>(STImpl.class);
		
		List<String> rawList = testList.rawList();
		rawList.add("newString1");
		rawList.add("newString2");
		rawList.add("newString3");
		rawList.add("newString4");
		rawList.add("newString5");
		rawList.add("newString6");
		
		assertTrue(testList.rawList().contains("newString2"));
		String result = rawList.remove(1);
		assertEquals(5, testList.getValue().size());
		assertEquals("newString2", result);
		assertFalse(testList.rawList().contains("newString2"));
		
		assertTrue(testList.rawList().contains("newString6"));
		boolean booleanResult = rawList.remove("newString6");
		assertEquals(4, testList.getValue().size());
		assertTrue(booleanResult);
		assertFalse(testList.rawList().contains("newString6"));
		
		booleanResult = rawList.remove("newString123");
		assertFalse(booleanResult);
		assertEquals(4, testList.getValue().size());
		
		booleanResult = rawList.removeAll(Collections.<String>emptyList());
		assertFalse(booleanResult);
		assertEquals(4, testList.getValue().size());
		
		booleanResult = rawList.removeAll(Arrays.asList("newString3", "newString5"));
		assertTrue(booleanResult);
		assertEquals(2, testList.getValue().size());
		assertEquals("newString1", getElement(testList, 0).getValue());
		assertEquals("newString4", getElement(testList, 1).getValue());
		
		booleanResult = rawList.removeAll(Arrays.asList("newString3", "newString5"));
		assertFalse(booleanResult);
		assertEquals(2, testList.getValue().size());
		assertEquals("newString1", getElement(testList, 0).getValue());
		assertEquals("newString4", getElement(testList, 1).getValue());

		booleanResult = rawList.retainAll(Arrays.asList("newString4", "newString1"));
		assertFalse(booleanResult);
		assertEquals(2, testList.getValue().size());
		assertEquals("newString1", getElement(testList, 0).getValue());
		assertEquals("newString4", getElement(testList, 1).getValue());

		booleanResult = rawList.retainAll(Arrays.asList("newString4"));
		assertTrue(booleanResult);
		assertEquals(1, testList.getValue().size());
		assertEquals("newString4", getElement(testList, 0).getValue());
		
		rawList.clear();
		assertTrue(testList.getValue().isEmpty());
		assertTrue(testList.rawList().isEmpty());
	}
	
	@Test
	public void shouldBeAbleToDetectLastIndexOf() {
		LIST<ST, String> testList = new LISTImpl<ST, String>(STImpl.class);
		
		List<String> rawList = testList.rawList();
		rawList.add("newString1");
		rawList.add("newString1");
		rawList.add("newString1");
		rawList.add("newString2");
		
		assertEquals(2, testList.rawList().lastIndexOf("newString1"));
	}
	
	@Test
	public void shouldBeAbleToIterateRawList() {
		LIST<ST, String> testList = new LISTImpl<ST, String>(STImpl.class);
		
		List<String> rawList = testList.rawList();
		rawList.add("newString0");
		rawList.add("newString1");
		rawList.add("newString2");
		rawList.add("newString3");
		
		int i = 0;
		for (Iterator<String> iterator = rawList.iterator(); iterator.hasNext(); i++) {
			String string = iterator.next();
			assertEquals("newString"+i, string);
		}
	}
	
	@Test
	public void shouldBeAbleToSetValueInList() {
		LIST<ST, String> testList = new LISTImpl<ST, String>(STImpl.class);
		
		List<String> rawList = testList.rawList();
		rawList.add("newString0");
		rawList.add("newString1");
		rawList.add("newString2");
		rawList.add("newString3");

		rawList.set(2, "newString4");
		assertEquals(4, testList.getValue().size());
		assertEquals("newString0", getElement(testList, 0).getValue());
		assertEquals("newString1", getElement(testList, 1).getValue());
		assertEquals("newString4", getElement(testList, 2).getValue());
		assertEquals("newString3", getElement(testList, 3).getValue());
	}
	
	@Test
	public void shouldBeAbleToObtainPartOfList() {
		LIST<ST, String> testList = new LISTImpl<ST, String>(STImpl.class);
		
		List<String> rawList = testList.rawList();
		rawList.add("newString0");
		rawList.add("newString1");
		rawList.add("newString2");
		rawList.add("newString3");
		
		List<String> subList = rawList.subList(1, 3);
		assertEquals(2, subList.size());
		assertEquals("newString1", subList.get(0));
		assertEquals("newString2", subList.get(1));
		
		Object[] array = rawList.toArray();
		assertEquals(4, array.length);
		assertEquals("newString0", array[0]);
		assertEquals("newString1", array[1]);
		assertEquals("newString2", array[2]);
		assertEquals("newString3", array[3]);
		
		String[] array2 = rawList.toArray(new String[0]);
		assertEquals(4, array.length);
		assertEquals("newString0", array2[0]);
		assertEquals("newString1", array2[1]);
		assertEquals("newString2", array2[2]);
		assertEquals("newString3", array2[3]);
	}

	@Test
	public void shouldBeAbleToSetObtainListIterator() {
		LIST<ST, String> testList = new LISTImpl<ST, String>(STImpl.class);
		
		List<String> rawList = testList.rawList();
		rawList.add("newString0");
		rawList.add("newString1");
		
		ListIterator<String> listIterator = rawList.listIterator();
		assertTrue(listIterator.hasNext());
		assertEquals("newString0", listIterator.next());
		assertTrue(listIterator.hasNext());
		assertEquals("newString1", listIterator.next());
		assertFalse(listIterator.hasNext());
		
		ListIterator<String> listIterator2 = rawList.listIterator(1);
		assertTrue(listIterator2.hasNext());
		assertEquals("newString1", listIterator2.next());
		assertFalse(listIterator2.hasNext());
	}
}
