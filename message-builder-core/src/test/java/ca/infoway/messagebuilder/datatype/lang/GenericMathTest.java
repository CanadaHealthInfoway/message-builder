/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
	
	@Test
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
		Date add = GenericMath.add(low, new Diff<Date>((Date)null));
		assertEquals(low, add);
	}
	
	@SuppressWarnings("deprecation")
	@Test
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

	@Test
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

	///////////////  Physical Quantities test
	
	@Test
	public void testPhysicalQuantityHalf() throws Exception {
		assertEquals(new BigDecimal("1.50"), GenericMath.half(new PhysicalQuantity(new BigDecimal("3.0"), UnitsOfMeasureCaseSensitive.KILOGRAM)).getQuantity());
	}
	
	@Test
	public void testPhysicalQuantityAverage() throws Exception {
		assertEquals(new BigDecimal("2.00"), GenericMath.average(new PhysicalQuantity(new BigDecimal("3.0"), UnitsOfMeasureCaseSensitive.KILOGRAM),new PhysicalQuantity(new BigDecimal("1.0"), UnitsOfMeasureCaseSensitive.KILOGRAM)).getQuantity());
	}
	
	@Test
	public void testPhysicalQuantityDiff() throws Exception {
		assertEquals(new BigDecimal("1.0"), GenericMath.diff(
				new PhysicalQuantity(new BigDecimal("2.0"), UnitsOfMeasureCaseSensitive.KILOGRAM),
				new PhysicalQuantity(new BigDecimal("3.0"), UnitsOfMeasureCaseSensitive.KILOGRAM)).getValue().getQuantity());
	}
	
	@Test
	public void testAddPhysicalQuantities() throws Exception {
		assertAdd(new PhysicalQuantity(new BigDecimal("123"), UnitsOfMeasureCaseSensitive.MILLIMETER), new PhysicalQuantity(new BigDecimal("88"), UnitsOfMeasureCaseSensitive.MILLIMETER));
		
		Diff<PhysicalQuantity> diff = new Diff<PhysicalQuantity>( new PhysicalQuantity(new BigDecimal("88"), UnitsOfMeasureCaseSensitive.MILLIMETER));
		assertEquals(new BigDecimal(211), GenericMath.add(new PhysicalQuantity(new BigDecimal("123"), UnitsOfMeasureCaseSensitive.MILLIMETER), diff).getQuantity());
		
		try {
			GenericMath.add(new PhysicalQuantity(new BigDecimal("123"), UnitsOfMeasureCaseSensitive.MILLIMETER), new PhysicalQuantity(new BigDecimal("88"), DefaultTimeUnit.DAY));
			fail("mismatched units");
		} catch (IllegalArgumentException e) {
			// expected
		}
	}

	@Test
	public void testPhysicalQuantitiesAsNull() throws Exception {
		assertEquals(null, GenericMath.add((PhysicalQuantity) null, (PhysicalQuantity) null));
		assertEquals(new BigDecimal(123), GenericMath.add(new PhysicalQuantity(new BigDecimal("123"), UnitsOfMeasureCaseSensitive.MILLIMETER), (PhysicalQuantity) null).getQuantity());
		assertEquals(new BigDecimal(123), GenericMath.add((PhysicalQuantity) null, new PhysicalQuantity(new BigDecimal("123"), UnitsOfMeasureCaseSensitive.MILLIMETER)).getQuantity());
		
		assertEquals(null, GenericMath.add((PhysicalQuantity) null, (Diff<PhysicalQuantity>) null));
		assertEquals(new BigDecimal(123), GenericMath.add(new PhysicalQuantity(new BigDecimal("123"), UnitsOfMeasureCaseSensitive.MILLIMETER), (Diff<PhysicalQuantity>) null).getQuantity());
		assertEquals(new BigDecimal(123), GenericMath.add((PhysicalQuantity) null, new PhysicalQuantity(new BigDecimal("123"), UnitsOfMeasureCaseSensitive.MILLIMETER)).getQuantity());
		
		assertEquals(null, GenericMath.average((PhysicalQuantity) null, (PhysicalQuantity) null));
		assertEquals(new BigDecimal(61.50), GenericMath.average(new PhysicalQuantity(new BigDecimal("123"), UnitsOfMeasureCaseSensitive.MILLIMETER), (PhysicalQuantity) null).getQuantity());
		assertEquals(new BigDecimal(61.50), GenericMath.average((PhysicalQuantity) null, new PhysicalQuantity(new BigDecimal("123"), UnitsOfMeasureCaseSensitive.MILLIMETER)).getQuantity());
		
		assertEquals(null, GenericMath.diff((PhysicalQuantity) null, (PhysicalQuantity) null));
		assertEquals(null, GenericMath.diff(new PhysicalQuantity(new BigDecimal("123"), UnitsOfMeasureCaseSensitive.MILLIMETER), (PhysicalQuantity) null));
		assertEquals(null, GenericMath.diff((PhysicalQuantity) null, new PhysicalQuantity(new BigDecimal("123"), UnitsOfMeasureCaseSensitive.MILLIMETER)));
		
		assertEquals(null, GenericMath.half(((PhysicalQuantity) null)));
	}
	
	
	private void assertAdd(PhysicalQuantity quantity, PhysicalQuantity quantity2) {
		assertEquals(quantity.getQuantity().add(quantity2.getQuantity()), GenericMath.add(quantity, quantity2).getQuantity());
	}

	
	@Test
	public void testPhysicalQuantitiesWithInnerValuesAsNull() throws Exception {
		PhysicalQuantity pqBothOk = new PhysicalQuantity(new BigDecimal("123"), UnitsOfMeasureCaseSensitive.MILLIMETER);
		PhysicalQuantity pqUnitsNull = new PhysicalQuantity(new BigDecimal("123"), null);
		PhysicalQuantity pqValueNull = new PhysicalQuantity(null, UnitsOfMeasureCaseSensitive.MILLIMETER);
		PhysicalQuantity pqBothNull = new PhysicalQuantity(null, null);
		
		// add
		assertEquals(null, GenericMath.add(pqBothNull, pqBothNull).getQuantity());
		assertEquals(new BigDecimal(123), GenericMath.add(pqBothNull, pqUnitsNull).getQuantity());
		assertPhysicalQuantityAddFails(pqBothNull, pqValueNull);
		assertPhysicalQuantityAddFails(pqBothNull, pqBothOk);
		
		assertEquals(new BigDecimal(123), GenericMath.add(pqUnitsNull, pqBothNull).getQuantity());
		assertEquals(new BigDecimal(246), GenericMath.add(pqUnitsNull, pqUnitsNull).getQuantity());
		assertPhysicalQuantityAddFails(pqUnitsNull, pqValueNull);
		assertPhysicalQuantityAddFails(pqUnitsNull, pqBothOk);

		assertPhysicalQuantityAddFails(pqValueNull, pqBothNull);
		assertPhysicalQuantityAddFails(pqValueNull, pqUnitsNull);
		assertEquals(null, GenericMath.add(pqValueNull, pqValueNull).getQuantity());
		assertEquals(new BigDecimal(123), GenericMath.add(pqValueNull, pqBothOk).getQuantity());

		assertPhysicalQuantityAddFails(pqBothOk, pqBothNull);
		assertPhysicalQuantityAddFails(pqBothOk, pqUnitsNull);
		assertEquals(new BigDecimal(123), GenericMath.add(pqBothOk, pqValueNull).getQuantity());
		assertEquals(new BigDecimal(246), GenericMath.add(pqBothOk, pqBothOk).getQuantity());

		// add diff
		assertEquals(null, GenericMath.add(pqBothNull, new Diff<PhysicalQuantity>(pqBothNull)).getQuantity());
		assertEquals(new BigDecimal(123), GenericMath.add(pqBothNull, new Diff<PhysicalQuantity>(pqUnitsNull)).getQuantity());
		assertPhysicalQuantityAddFails(pqBothNull, new Diff<PhysicalQuantity>(pqValueNull));
		assertPhysicalQuantityAddFails(pqBothNull, new Diff<PhysicalQuantity>(pqBothOk));
		
		assertEquals(new BigDecimal(123), GenericMath.add(pqUnitsNull, new Diff<PhysicalQuantity>(pqBothNull)).getQuantity());
		assertEquals(new BigDecimal(246), GenericMath.add(pqUnitsNull, new Diff<PhysicalQuantity>(pqUnitsNull)).getQuantity());
		assertPhysicalQuantityAddFails(pqUnitsNull, new Diff<PhysicalQuantity>(pqValueNull));
		assertPhysicalQuantityAddFails(pqUnitsNull, new Diff<PhysicalQuantity>(pqBothOk));

		assertPhysicalQuantityAddFails(pqValueNull, new Diff<PhysicalQuantity>(pqBothNull));
		assertPhysicalQuantityAddFails(pqValueNull, new Diff<PhysicalQuantity>(pqUnitsNull));
		assertEquals(null, GenericMath.add(pqValueNull, new Diff<PhysicalQuantity>(pqValueNull)).getQuantity());
		assertEquals(new BigDecimal(123), GenericMath.add(pqValueNull, new Diff<PhysicalQuantity>(pqBothOk)).getQuantity());

		assertPhysicalQuantityAddFails(pqBothOk, new Diff<PhysicalQuantity>(pqBothNull));
		assertPhysicalQuantityAddFails(pqBothOk, new Diff<PhysicalQuantity>(pqUnitsNull));
		assertEquals(new BigDecimal(123), GenericMath.add(pqBothOk, new Diff<PhysicalQuantity>(pqValueNull)).getQuantity());
		assertEquals(new BigDecimal(246), GenericMath.add(pqBothOk, new Diff<PhysicalQuantity>(pqBothOk)).getQuantity());

		// average
		assertEquals(null, GenericMath.average(pqBothNull, pqBothNull).getQuantity());
		assertEquals(new BigDecimal(61.5), GenericMath.average(pqBothNull, pqUnitsNull).getQuantity());
		assertPhysicalQuantityAverageFails(pqBothNull, pqValueNull);
		assertPhysicalQuantityAverageFails(pqBothNull, pqBothOk);
		
		assertEquals(new BigDecimal(61.5), GenericMath.average(pqUnitsNull, pqBothNull).getQuantity());
		assertEquals(new BigDecimal(123).setScale(1), GenericMath.average(pqUnitsNull, pqUnitsNull).getQuantity());
		assertPhysicalQuantityAverageFails(pqUnitsNull, pqValueNull);
		assertPhysicalQuantityAverageFails(pqUnitsNull, pqBothOk);

		assertPhysicalQuantityAverageFails(pqValueNull, pqBothNull);
		assertPhysicalQuantityAverageFails(pqValueNull, pqUnitsNull);
		assertEquals(null, GenericMath.average(pqValueNull, pqValueNull).getQuantity());
		assertEquals(new BigDecimal(61.5), GenericMath.average(pqValueNull, pqBothOk).getQuantity());

		assertPhysicalQuantityAverageFails(pqBothOk, pqBothNull);
		assertPhysicalQuantityAverageFails(pqBothOk, pqUnitsNull);
		assertEquals(new BigDecimal(61.5), GenericMath.average(pqBothOk, pqValueNull).getQuantity());
		assertEquals(new BigDecimal(123).setScale(1), GenericMath.average(pqBothOk, pqBothOk).getQuantity());

		// diff
		assertEquals(null, GenericMath.diff(pqBothNull, pqBothNull));
		assertEquals(null, GenericMath.diff(pqBothNull, pqUnitsNull));
		assertPhysicalQuantityDiffFails(pqBothNull, pqValueNull);
		assertPhysicalQuantityDiffFails(pqBothNull, pqBothOk);
		
		assertEquals(null, GenericMath.diff(pqUnitsNull, pqBothNull));
		assertEquals(new BigDecimal(0), GenericMath.diff(pqUnitsNull, pqUnitsNull).getValue().getQuantity());
		assertPhysicalQuantityDiffFails(pqUnitsNull, pqValueNull);
		assertPhysicalQuantityDiffFails(pqUnitsNull, pqBothOk);

		assertPhysicalQuantityDiffFails(pqValueNull, pqBothNull);
		assertPhysicalQuantityDiffFails(pqValueNull, pqUnitsNull);
		assertEquals(null, GenericMath.diff(pqValueNull, pqValueNull));
		assertEquals(null, GenericMath.diff(pqValueNull, pqBothOk));

		assertPhysicalQuantityDiffFails(pqBothOk, pqBothNull);
		assertPhysicalQuantityDiffFails(pqBothOk, pqUnitsNull);
		assertEquals(null, GenericMath.diff(pqBothOk, pqValueNull));
		assertEquals(new BigDecimal(0), GenericMath.diff(pqBothOk, pqBothOk).getValue().getQuantity());
		
		// half
		assertEquals(null, GenericMath.half(pqBothNull).getQuantity());
		assertEquals(new BigDecimal(61.50), GenericMath.half(pqUnitsNull).getQuantity());
		assertEquals(null, GenericMath.half(pqValueNull).getQuantity());
		assertEquals(new BigDecimal(61.50), GenericMath.half(pqBothOk).getQuantity());
	}
	
	private void assertPhysicalQuantityDiffFails(PhysicalQuantity pq1, PhysicalQuantity pq2) {
		try {
			GenericMath.diff(pq1, pq2);
			fail("expected PQ diff to throw exception due to mismatching units");
		} catch(IllegalArgumentException e) {
			// expected
		}
	}

	private void assertPhysicalQuantityAverageFails(PhysicalQuantity pq1, PhysicalQuantity pq2) {
		try {
			GenericMath.average(pq1, pq2);
			fail("expected PQ average to throw exception due to mismatching units");
		} catch(IllegalArgumentException e) {
			// expected
		}
	}

	private void assertPhysicalQuantityAddFails(PhysicalQuantity pq, Diff<PhysicalQuantity> diff) {
		assertPhysicalQuantityAddFails(pq, diff.getValue());
	}

	private void assertPhysicalQuantityAddFails(PhysicalQuantity pq1, PhysicalQuantity pq2) {
		try {
			GenericMath.add(pq1, pq2);
			fail("expected PQ add to throw exception due to mismatching units");
		} catch(IllegalArgumentException e) {
			// expected
		}
	}
	
	
}
