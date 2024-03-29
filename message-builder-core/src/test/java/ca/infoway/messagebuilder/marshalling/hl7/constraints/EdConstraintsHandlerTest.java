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

import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.x_DocumentMediaType;
import ca.infoway.messagebuilder.domainvalue.basic.URLScheme;
import ca.infoway.messagebuilder.domainvalue.basic.X_DocumentMediaType;
import ca.infoway.messagebuilder.error.ErrorLevel;
import ca.infoway.messagebuilder.error.ErrorLogger;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorCode;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.ConstrainedDatatype;
import ca.infoway.messagebuilder.xml.Relationship;

public class EdConstraintsHandlerTest {

	private EdConstraintsHandler constraintsHandler = new EdConstraintsHandler();
	
	private List<Hl7Error> errors;
	
	private ErrorLogger errorLogger = new ErrorLogger() {
		public void logError(Hl7ErrorCode errorCode, ErrorLevel errorLevel, String message) {
			errors.add(new Hl7Error(errorCode, errorLevel, message, ""));
		}
	};
	
	@Before
	public void setUp() {
		//NUnit does not allocate a new instance for each test method. Need to do this in setUp.
		errors = new ArrayList<Hl7Error>();
	}
	
	@Test
	public void testNullCases() throws Exception {
		this.constraintsHandler.handleConstraints(null, null, this.errorLogger);
		assertTrue(this.errors.isEmpty());
		
		EncapsulatedData ed = new EncapsulatedData();
		
		this.constraintsHandler.handleConstraints(null, ed, this.errorLogger);
		assertTrue(this.errors.isEmpty());
		
		this.constraintsHandler.handleConstraints(null, ed, this.errorLogger);
		assertTrue(this.errors.isEmpty());
		
		ConstrainedDatatype constraints = new ConstrainedDatatype();
		
		this.constraintsHandler.handleConstraints(constraints, null, this.errorLogger);
		assertTrue(this.errors.isEmpty());
		
		this.constraintsHandler.handleConstraints(constraints, ed, this.errorLogger);
		assertTrue(this.errors.isEmpty());
		
		ed.setContent("some content");
		ed.setReferenceObj(new TelecommunicationAddress(URLScheme.TEL, "4167620032"));
		ed.setMediaType(X_DocumentMediaType.HTML_TEXT);
		this.constraintsHandler.handleConstraints(constraints, ed, this.errorLogger);
		assertTrue(this.errors.isEmpty());
	}
	
	@Test
	public void testPassingConstraints() throws Exception {
		EncapsulatedData ed = createEd(true, true, X_DocumentMediaType.DICOM);
		ConstrainedDatatype constraints = createConstraints(true);
		this.constraintsHandler.handleConstraints(constraints, ed, this.errorLogger);
		assertTrue(this.errors.isEmpty());
	}

	@Test
	public void testMissingReferenceFailingConstraint() throws Exception {
		EncapsulatedData ed = createEd(false, false, X_DocumentMediaType.DICOM);
		ConstrainedDatatype constraints = createConstraints(true);
		this.constraintsHandler.handleConstraints(constraints, ed, this.errorLogger);
		assertFalse(this.errors.isEmpty());
		assertEquals(1, this.errors.size());
		assertEquals(Hl7ErrorCode.CDA_MANDATORY_CONSTRAINT_MISSING, this.errors.get(0).getHl7ErrorCode());
		assertTrue( this.errors.get(0).getMessage().contains(" reference "));
	}

	@Test
	public void testMissingReferenceValueFailingConstraint() throws Exception {
		EncapsulatedData ed = createEd(true, false, X_DocumentMediaType.DICOM);
		ConstrainedDatatype constraints = createConstraints(true);
		this.constraintsHandler.handleConstraints(constraints, ed, this.errorLogger);
		assertFalse(this.errors.isEmpty());
		assertEquals(1, this.errors.size());
		assertEquals(Hl7ErrorCode.CDA_MANDATORY_CONSTRAINT_MISSING, this.errors.get(0).getHl7ErrorCode());
		assertTrue( this.errors.get(0).getMessage().contains(" reference.value "));
	}

	@Test
	public void testMissingReferenceValuePassesIfReferenceMissingAndNotMandatory() throws Exception {
		EncapsulatedData ed = createEd(true, false, X_DocumentMediaType.DICOM);
		ed.setReferenceObj(null);
		ConstrainedDatatype constraints = createConstraints(false);
		this.constraintsHandler.handleConstraints(constraints, ed, this.errorLogger);
		assertTrue(this.errors.isEmpty());
	}

	@Test
	public void testMissingReferenceValueFailsIfReferenceProvidedAndNotMandatory() throws Exception {
		EncapsulatedData ed = createEd(true, false, X_DocumentMediaType.DICOM);
		ConstrainedDatatype constraints = createConstraints(false);
		this.constraintsHandler.handleConstraints(constraints, ed, this.errorLogger);
		assertFalse(this.errors.isEmpty());
		assertEquals(1, this.errors.size());
		assertEquals(Hl7ErrorCode.CDA_MANDATORY_CONSTRAINT_MISSING, this.errors.get(0).getHl7ErrorCode());
		assertTrue( this.errors.get(0).getMessage().contains(" reference.value "));
	}

	@Test
	public void testIncorrectMediaTypeFailingConstraint() throws Exception {
		EncapsulatedData ed = createEd(true, true, X_DocumentMediaType.HL7_CDA);
		ConstrainedDatatype constraints = createConstraints(true);
		this.constraintsHandler.handleConstraints(constraints, ed, this.errorLogger);
		assertFalse(this.errors.isEmpty());
		assertEquals(1, this.errors.size());
		assertEquals(Hl7ErrorCode.CDA_FIXED_CONSTRAINT_MISSING, this.errors.get(0).getHl7ErrorCode());
		assertTrue(this.errors.get(0).getMessage().contains(" mediaType "));
		assertEquals(X_DocumentMediaType.HL7_CDA, ed.getMediaType());
	}

	@Test
	public void testMissingMediaTypeFailingConstraint() throws Exception {
		EncapsulatedData ed = createEd(true, true, null);
		ConstrainedDatatype constraints = createConstraints(true);
		this.constraintsHandler.handleConstraints(constraints, ed, this.errorLogger);
		assertTrue(this.errors.isEmpty());
		assertEquals(X_DocumentMediaType.DICOM, ed.getMediaType());
	}

	private EncapsulatedData createEd(boolean createReference, boolean createReferenceValue, x_DocumentMediaType mediaType) throws Exception {
		EncapsulatedData ed = new EncapsulatedData();
		if (createReference) {
			ed.setReferenceObj(new TelecommunicationAddress());
			if (createReferenceValue) {
				ed.getReferenceObj().setUrlScheme(URLScheme.TEL);
				ed.getReferenceObj().setAddress("4167620032");
			}
		}
		if (mediaType != null) {
			ed.setMediaType(mediaType);
		}
		ed.setContent("some content");
		return ed;
	}
	
	private ConstrainedDatatype createConstraints(boolean referenceMandatory) {
//        <relationship name="reference" attribute="false" cardinality="1"/>
//        <relationship name="reference.value" attribute="false" cardinality="1"/>
//
//        <relationship name="reference" attribute="false" cardinality="0-1"/>
//        <relationship name="reference.value" attribute="false" cardinality="1"/>
//
//        <relationship name="mediaType" attribute="false" cardinality="1" fixedValue="application/dicom"/>
//        <relationship name="reference" attribute="false" cardinality="1"/>

        ConstrainedDatatype constraints = new ConstrainedDatatype("MessagePart.relationshipName", "ED");
		constraints.setRestriction();

		Relationship referenceConstraint = new Relationship("reference", null, Cardinality.create(referenceMandatory ? "1" : "0-1"));
		constraints.getRelationships().add(referenceConstraint);
		
		Relationship referenceValueConstraint = new Relationship("reference.value", null, Cardinality.create("1"));
		constraints.getRelationships().add(referenceValueConstraint);
		
		Relationship mediaTypeConstraint = new Relationship("mediaType", null, Cardinality.create("1"));
		mediaTypeConstraint.setFixedValue("application/dicom");
		constraints.getRelationships().add(mediaTypeConstraint);
		
		return constraints;
	}
	
}
