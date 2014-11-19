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
import java.util.List;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.marshalling.ErrorLogger;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorLevel;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.ConstrainedDatatype;
import ca.infoway.messagebuilder.xml.Relationship;

public class IiConstraintsHandlerTest {

	private IiConstraintsHandler constraintsHandler = new IiConstraintsHandler();
	
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
		
		Identifier identifier = new Identifier();
		
		this.constraintsHandler.handleConstraints(null, identifier, this.errorLogger);
		assertTrue(this.errors.isEmpty());
		
		this.constraintsHandler.handleConstraints(null, identifier, this.errorLogger);
		assertTrue(this.errors.isEmpty());
		
		ConstrainedDatatype constraints = new ConstrainedDatatype();
		
		this.constraintsHandler.handleConstraints(constraints, null, this.errorLogger);
		assertTrue(this.errors.isEmpty());
		
		this.constraintsHandler.handleConstraints(constraints, identifier, this.errorLogger);
		assertTrue(this.errors.isEmpty());
		
		identifier.setRoot("1.2.3");
		identifier.setExtension("123");
		this.constraintsHandler.handleConstraints(constraints, identifier, this.errorLogger);
		assertTrue(this.errors.isEmpty());
	}
	
	@Test
	public void testPassingConstraints() {
		Identifier identifier = new Identifier("1.2.3.4", "1234");
		ConstrainedDatatype constraints = createConstraints();
		this.constraintsHandler.handleConstraints(constraints, identifier, this.errorLogger);
		assertTrue(this.errors.isEmpty());
	}

	@Test
	public void testExistingRootFailingConstraint() {
		Identifier identifier = new Identifier("1.7777", "1234");
		ConstrainedDatatype constraints = createConstraints();
		this.constraintsHandler.handleConstraints(constraints, identifier, this.errorLogger);
		assertFalse(this.errors.isEmpty());
		assertEquals(1, this.errors.size());
		assertEquals(Hl7ErrorCode.CDA_FIXED_CONSTRAINT_MISSING, this.errors.get(0).getHl7ErrorCode());
		assertEquals("1.7777", identifier.getRoot());
		assertEquals("1234", identifier.getExtension());
	}

	@Test
	public void testExistingExtensionFailingConstraint() {
		Identifier identifier = new Identifier("1.2.3.4", "12347777");
		ConstrainedDatatype constraints = createConstraints();
		this.constraintsHandler.handleConstraints(constraints, identifier, this.errorLogger);
		assertFalse(this.errors.isEmpty());
		assertEquals(1, this.errors.size());
		assertEquals(Hl7ErrorCode.CDA_FIXED_CONSTRAINT_MISSING, this.errors.get(0).getHl7ErrorCode());
		assertEquals("1.2.3.4", identifier.getRoot());
		assertEquals("12347777", identifier.getExtension());
	}

	@Test
	public void testMissingRootFailingConstraint() {
		Identifier identifier = new Identifier((String) null, "1234");
		ConstrainedDatatype constraints = createConstraints();
		this.constraintsHandler.handleConstraints(constraints, identifier, this.errorLogger);
		assertTrue(this.errors.isEmpty());
		assertEquals("1.2.3.4", identifier.getRoot());
		assertEquals("1234", identifier.getExtension());
	}

	@Test
	public void testMissingExtensionFailingConstraint() {
		Identifier identifier = new Identifier("1.2.3.4", (String) null);
		ConstrainedDatatype constraints = createConstraints();
		this.constraintsHandler.handleConstraints(constraints, identifier, this.errorLogger);
		assertTrue(this.errors.isEmpty());
		assertEquals("1.2.3.4", identifier.getRoot());
		assertEquals("1234", identifier.getExtension());
	}

	private ConstrainedDatatype createConstraints() {
		ConstrainedDatatype constraints = new ConstrainedDatatype("MessagePart.relationshipName", "II");
		constraints.setRestriction();
		
		Relationship rootConstraint = new Relationship("root", null, Cardinality.create("1"));
		rootConstraint.setFixedValue("1.2.3.4");
		
		Relationship extensionConstraint = new Relationship("extension", null, Cardinality.create("1"));
		extensionConstraint.setFixedValue("1234");
		
		constraints.getRelationships().add(rootConstraint);
		constraints.getRelationships().add(extensionConstraint);
		
		return constraints;
	}
	
}
