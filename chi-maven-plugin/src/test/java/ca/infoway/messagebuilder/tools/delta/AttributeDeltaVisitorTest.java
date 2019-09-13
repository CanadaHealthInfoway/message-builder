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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
package ca.infoway.messagebuilder.tools.delta;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.delta.AttributeDelta;
import ca.infoway.messagebuilder.xml.delta.DatatypeConstraint;
import ca.infoway.messagebuilder.xml.delta.DefaultValueConstraint;
import ca.infoway.messagebuilder.xml.delta.FixedConstraint;


public class AttributeDeltaVisitorTest {

	private MessageSet messageSet;
	private MessagePart part;
	private Relationship relationship;

	@Before
	public void setUp() {
		this.messageSet = new MessageSet();
		this.messageSet.getPackageLocations().put("ABCD_MT123456CA", new PackageLocation("ABCD_MT123456CA"));
		this.part = new MessagePart("ABCD_MT123456CA.Patient");
		this.messageSet.addMessagePart(this.part);

		this.relationship = new Relationship("age", "INT", Cardinality.create("1"));
		this.relationship.setConformance(ConformanceLevel.MANDATORY);
		this.part.getRelationships().add(this.relationship);
	}

	@Test
	public void shouldUpdateDatatype() throws Exception {
		AttributeDelta delta = new AttributeDelta();
		delta.setClassName("ABCD_MT123456CA.Patient");
		delta.setRelationshipName("age");
		DatatypeConstraint constraint = new DatatypeConstraint();
		constraint.setOriginalValue("INT.ANY");
		constraint.setNewValue("INT.POS");
		
		new AttributeDeltaVisitor(delta, this.messageSet).visit(constraint);
		
		assertEquals("type", "INT.POS", relationship.getType());
	}
	
	@Test
	public void shouldUpdateFixedValue() {
		AttributeDelta delta = new AttributeDelta();
		delta.setClassName("ABCD_MT123456CA.Patient");
		delta.setRelationshipName("age");
		
		FixedConstraint constraint = new FixedConstraint("before", "after");
		
		this.relationship.setFixedValue("before");
		
		new AttributeDeltaVisitor(delta, this.messageSet).visit(constraint);
		
		assertEquals("fixed", "after", relationship.getFixedValue());
	}
	
	@Test
	public void shouldReplaceDefaultValuewithFixedValue() {
		AttributeDelta delta = new AttributeDelta();
		delta.setClassName("ABCD_MT123456CA.Patient");
		delta.setRelationshipName("age");
		
		FixedConstraint constraint = new FixedConstraint(null, "after");
		
		this.relationship.setDefaultValue("before");
		
		new AttributeDeltaVisitor(delta, this.messageSet).visit(constraint);
		
		assertEquals("fixed", "after", relationship.getFixedValue());
		assertNull("default", relationship.getDefaultValue());
	}
	
	@Test
	public void shouldUpdateDefaultValue() {
		AttributeDelta delta = new AttributeDelta();
		delta.setClassName("ABCD_MT123456CA.Patient");
		delta.setRelationshipName("age");
		
		DefaultValueConstraint constraint = new DefaultValueConstraint("before", "after");
		
		this.relationship.setDefaultValue("before");
		
		new AttributeDeltaVisitor(delta, this.messageSet).visit(constraint);
		
		assertEquals("default", "after", relationship.getDefaultValue());
	}
	
	@Test
	public void shouldReplaceFixedValueWithDefaultValue() {
		AttributeDelta delta = new AttributeDelta();
		delta.setClassName("ABCD_MT123456CA.Patient");
		delta.setRelationshipName("age");
		
		DefaultValueConstraint constraint = new DefaultValueConstraint(null, "after");
		
		this.relationship.setFixedValue("before");
		
		new AttributeDeltaVisitor(delta, this.messageSet).visit(constraint);
		
		assertEquals("default", "after", relationship.getDefaultValue());
		assertNull("fixed", relationship.getFixedValue());
	}
}
