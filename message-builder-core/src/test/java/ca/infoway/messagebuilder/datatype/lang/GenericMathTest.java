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

package ca.infoway.messagebuilder.datatype.lang;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;

/**
 * @sharpen.ignore - datatype - translated manually
 */
public class GenericMathTest {
	
	public void testAddIntegers() throws Exception {
		assertAdd(12, 15);
		assertAdd(129, 88);
		assertAdd(null, 256);
	}

	@Test
	public void testAddIntegersDiff() throws Exception {
		assertAdd(12, new Diff<Integer>(15));
		assertAdd(129, new Diff<Integer>(88));
		assertAdd(null, new Diff<Integer>(256));
	}
	
	@Test
	public void testAddDateAndDiff() throws Exception {
		Date low = new Date(0);
		Date add = GenericMath.add(low, new Diff<Date>(null));
		assertEquals(low, add);
	}
	
	@Test
	public void testPhysicalQuantityHalf() throws Exception {
		assertEquals(new BigDecimal("1.50"), GenericMath.half(new PhysicalQuantity(new BigDecimal("3.0"), UnitsOfMeasureCaseSensitive.KILOGRAM)).getQuantity());
	}
	
	public void testPhysicalQuantityDiff() throws Exception {
		assertEquals(new BigDecimal("1.0"), GenericMath.diff(
				new PhysicalQuantity(new BigDecimal("2.0"), UnitsOfMeasureCaseSensitive.KILOGRAM),
				new PhysicalQuantity(new BigDecimal("3.0"), UnitsOfMeasureCaseSensitive.KILOGRAM)).getValue().getQuantity());
	}
	
	public void testAddPhysicalQuantities() throws Exception {
		assertAdd(new PhysicalQuantity(new BigDecimal("123"), UnitsOfMeasureCaseSensitive.MILLIMETER), new PhysicalQuantity(new BigDecimal("88"), UnitsOfMeasureCaseSensitive.MILLIMETER));
		try {
			GenericMath.add(new PhysicalQuantity(new BigDecimal("123"), UnitsOfMeasureCaseSensitive.MILLIMETER), new PhysicalQuantity(new BigDecimal("88"), DefaultTimeUnit.DAY));
			fail("mismatched units");
		} catch (IllegalArgumentException e) {
			// expected
		}
	}
	
	private void assertAdd(PhysicalQuantity quantity, PhysicalQuantity quantity2) {
		assertEquals(quantity.getQuantity().add(quantity2.getQuantity()), GenericMath.add(quantity, quantity2).getQuantity());
	}

	@SuppressWarnings("deprecation")
	public void testAddDateDiff() throws Exception {
		assertAdd(parseDate("2006-02-15"), parseDate("2006-01-15"), new DateDiff(1, DefaultTimeUnit.MONTH));
		assertAdd(parseDate("2006-03-15"), parseDate("2006-02-15"), new DateDiff(1, DefaultTimeUnit.MONTH));
		
		assertAdd(parseDate("2006-02-16"), parseDate("2006-02-15"), new DateDiff(1, DefaultTimeUnit.DAY));
		assertAdd(parseDate("2006-02-20"), parseDate("2006-02-15"), new DateDiff(5, DefaultTimeUnit.DAY));
		assertAdd(parseDate("2006-02-22"), parseDate("2006-02-15"), new DateDiff(1, DefaultTimeUnit.WEEK));
	}
	
	private void assertAdd(Date expected, Date date, DateDiff diff) {
		assertEquals(expected, GenericMath.add(date, diff));
	}

	private Date parseDate(String string) throws ParseException {
		return DateUtils.parseDate(string, new String[] { "yyyy-MM-dd" });
	}

	private void assertAdd(Integer i, Diff<Integer> j) {
		assertEquals(new Integer((i == null ? 0 : i) + (j == null ? 0 : j.getValue())), GenericMath.add(i, j));
	}

	public void testAddLong() throws Exception {
		assertAdd(12L, 15L);
		assertAdd(129L, 88L);
		assertAdd(129L, null);
	}
	
	private void assertAdd(Integer i, Integer j) {
		assertEquals(new Integer((i == null ? 0 : i) + (j == null ? 0 : j)), GenericMath.add(i, j));
	}
	
	private void assertAdd(Long i, Long j) {
		assertEquals(new Long((i == null ? 0 : i) + (j == null ? 0 : j)), GenericMath.add(i, j));
	}
	
}
