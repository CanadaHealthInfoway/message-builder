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
package ca.infoway.messagebuilder.marshalling.hl7.constraints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.lang.DateInterval;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.error.ErrorLogger;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.error.Hl7ErrorLevel;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.ConstrainedDatatype;
import ca.infoway.messagebuilder.xml.Relationship;

public class IvlTsConstraintsHandlerTest {

	private IvlTsConstraintsHandler constraintsHandler = new IvlTsConstraintsHandler();
	
	private final List<Hl7Error> errors = new ArrayList<Hl7Error>();
	private ErrorLogger errorLogger = new ErrorLogger() {
		public void logError(Hl7ErrorCode errorCode, Hl7ErrorLevel errorLevel, String message) {
			errors.add(new Hl7Error(errorCode, errorLevel, message, ""));
		}
	}; 
	
	@Test
	public void testNullCases() {
		this.constraintsHandler.handleConstraints(null, null, this.errorLogger);
		assertTrue(this.errors.isEmpty());
		
		DateInterval dateInterval = new DateInterval();
		
		this.constraintsHandler.handleConstraints(null, dateInterval, this.errorLogger);
		assertTrue(this.errors.isEmpty());
		
		this.constraintsHandler.handleConstraints(null, dateInterval, this.errorLogger);
		assertTrue(this.errors.isEmpty());
		
		ConstrainedDatatype constraints = new ConstrainedDatatype();
		
		this.constraintsHandler.handleConstraints(constraints, null, this.errorLogger);
		assertTrue(this.errors.isEmpty());
		
		this.constraintsHandler.handleConstraints(constraints, dateInterval, this.errorLogger);
		assertTrue(this.errors.isEmpty());

		dateInterval.setInterval(createLowHighInterval(true, true));
		this.constraintsHandler.handleConstraints(constraints, dateInterval, this.errorLogger);
		assertTrue(this.errors.isEmpty());
	}
	
	@Test
	public void testPassingConstraintsLowHigh() {
		DateInterval dateInterval = new DateInterval(createLowHighInterval(true, true));
		ConstrainedDatatype constraints = createLowHighConstraints();
		this.constraintsHandler.handleConstraints(constraints, dateInterval, this.errorLogger);
		assertTrue(this.errors.isEmpty());
	}

	@Test
	public void testMissingLowFailingConstraint() {
		DateInterval dateInterval = new DateInterval(createLowHighInterval(false, true));
		ConstrainedDatatype constraints = createLowHighConstraints();
		this.constraintsHandler.handleConstraints(constraints, dateInterval, this.errorLogger);
		assertFalse(this.errors.isEmpty());
		assertEquals(1, this.errors.size());
		assertEquals(Hl7ErrorCode.CDA_MANDATORY_CONSTRAINT_MISSING, this.errors.get(0).getHl7ErrorCode());
		assertTrue(this.errors.get(0).getMessage().contains("low"));
		
		Interval<Date> originalInterval = createLowHighInterval(false, true);
		assertEquals(originalInterval.getLow(), dateInterval.getInterval().getLow());
		assertEquals(originalInterval.getHigh(), dateInterval.getInterval().getHigh());
	}

	@Test
	public void testMissingHighFailingConstraint() {
		DateInterval dateInterval = new DateInterval(createLowHighInterval(true, false));
		ConstrainedDatatype constraints = createLowHighConstraints();
		this.constraintsHandler.handleConstraints(constraints, dateInterval, this.errorLogger);
		assertFalse(this.errors.isEmpty());
		assertEquals(1, this.errors.size());
		assertEquals(Hl7ErrorCode.CDA_MANDATORY_CONSTRAINT_MISSING, this.errors.get(0).getHl7ErrorCode());
		assertTrue(this.errors.get(0).getMessage().contains("high"));
		
		Interval<Date> originalInterval = createLowHighInterval(true, false);
		assertEquals(originalInterval.getLow(), dateInterval.getInterval().getLow());
		assertEquals(originalInterval.getHigh(), dateInterval.getInterval().getHigh());
	}

	private ConstrainedDatatype createLowHighConstraints() {
		ConstrainedDatatype constraints = new ConstrainedDatatype("MessagePart.relationshipName", "IVL<TS>");
		constraints.setRestriction();
		
		Relationship lowConstraint = new Relationship("low", null, Cardinality.create("1"));
		Relationship highConstraint = new Relationship("high", null, Cardinality.create("1"));
		
		constraints.getRelationships().add(lowConstraint);
		constraints.getRelationships().add(highConstraint);
		
		return constraints;
	}
	
	@Test
	public void testPassingSimpleValueConstraints() {
		DateInterval dateInterval = new DateInterval(createSimpleValueInterval());
		ConstrainedDatatype constraints = createSimpleValueConstraints();
		this.constraintsHandler.handleConstraints(constraints, dateInterval, this.errorLogger);
		assertTrue(this.errors.isEmpty());
	}

	@Test
	public void testMissingSimpleValueConstraints() {
		DateInterval dateInterval = new DateInterval(createLowHighInterval(true, true));
		ConstrainedDatatype constraints = createSimpleValueConstraints();
		this.constraintsHandler.handleConstraints(constraints, dateInterval, this.errorLogger);
		assertFalse(this.errors.isEmpty());
		assertEquals(3, this.errors.size());
		assertEquals(Hl7ErrorCode.CDA_PROHIBITED_CONSTRAINT, this.errors.get(0).getHl7ErrorCode());
		assertTrue(this.errors.get(0).getMessage().contains("Property low"));
		assertEquals(Hl7ErrorCode.CDA_PROHIBITED_CONSTRAINT, this.errors.get(1).getHl7ErrorCode());
		assertTrue(this.errors.get(1).getMessage().contains("Property high"));
		assertEquals(Hl7ErrorCode.CDA_MANDATORY_CONSTRAINT_MISSING, this.errors.get(2).getHl7ErrorCode());
		assertTrue(this.errors.get(2).getMessage().contains("Property value"));
	}

	private Interval<Date> createLowHighInterval(boolean hasLow, boolean hasHigh) {
		Date low = hasLow ? DateUtil.getDate(2010, 2, 22) : null;
		Date high = hasHigh ? DateUtil.getDate(2013, 7, 11) : null;
		return IntervalFactory.createLowHigh(low, high);
	}

	private Interval<Date> createSimpleValueInterval() {
		Date value = DateUtil.getDate(2013, 11, 7);
		return IntervalFactory.createSimple(value);
	}

	private ConstrainedDatatype createSimpleValueConstraints() {
		ConstrainedDatatype constraints = new ConstrainedDatatype("MessagePart.relationshipName", "IVL<TS>");
		constraints.setRestriction();
		
		Relationship simpleValueConstraint = new Relationship("value", null, Cardinality.create("1"));
		Relationship lowConstraint = new Relationship("low", null, Cardinality.create("0"));
		Relationship highConstraint = new Relationship("high", null, Cardinality.create("0"));
		
		constraints.getRelationships().add(simpleValueConstraint);
		constraints.getRelationships().add(lowConstraint);
		constraints.getRelationships().add(highConstraint);
		
		return constraints;
	}
	
}
