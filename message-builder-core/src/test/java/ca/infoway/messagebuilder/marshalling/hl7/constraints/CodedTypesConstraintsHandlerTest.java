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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.lang.CodeRole;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.domainvalue.controlact.ActStatus;
import ca.infoway.messagebuilder.marshalling.ErrorLogger;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorLevel;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.ConstrainedDatatype;
import ca.infoway.messagebuilder.xml.Relationship;

public class CodedTypesConstraintsHandlerTest {

	private CodedTypesConstraintsHandler constraintsHandler = new CodedTypesConstraintsHandler();
	private TrivialCodeResolver trivialCodeResolver = new TrivialCodeResolver();
	
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
		
		CodedTypeR2<Code> codedType = createCodedType();
		
		this.constraintsHandler.handleConstraints(null, codedType, this.errorLogger);
		assertTrue(this.errors.isEmpty());
		
		this.constraintsHandler.handleConstraints(null, codedType, this.errorLogger);
		assertTrue(this.errors.isEmpty());
		
		ConstrainedDatatype constraints = new ConstrainedDatatype();
		
		this.constraintsHandler.handleConstraints(constraints, null, this.errorLogger);
		assertTrue(this.errors.isEmpty());
		
		this.constraintsHandler.handleConstraints(constraints, codedType, this.errorLogger);
		assertTrue(this.errors.isEmpty());
		
		codedType.setCode(ActStatus.ACTIVE);
		codedType.getQualifier().add(new CodeRole());
		
		this.constraintsHandler.handleConstraints(constraints, codedType, this.errorLogger);
		assertTrue(this.errors.isEmpty());
	}
	
	@Test
	public void testPassingConstraints() {
		CodedTypeR2<Code> codedType = createCodedType();
		ConstrainedDatatype constraints = createConstraints(true);
		this.constraintsHandler.handleConstraints(constraints, codedType, this.errorLogger);
		assertTrue(this.errors.isEmpty());
	}

	@Test
	public void testTooManyQualifiersWhenQualifierMandatory() {
		ConstrainedDatatype constraints = createConstraints(true);
		CodedTypeR2<Code> codedType = createCodedType();
		codedType.getQualifier().add(new CodeRole());
		
		this.constraintsHandler.handleConstraints(constraints, codedType, this.errorLogger);
		
		assertFalse(this.errors.isEmpty());
		assertEquals(1, this.errors.size());
		assertEquals(Hl7ErrorCode.CDA_CARDINALITY_CONSTRAINT, this.errors.get(0).getHl7ErrorCode());
		assertTrue(this.errors.get(0).getMessage().contains(" qualifier "));
		assertTrue(this.errors.get(0).getMessage().contains("cardinality"));
	}

	@Test
	public void testTooManyQualifiersWhenQualifier0To1() {
		ConstrainedDatatype constraints = createConstraints(false);
		CodedTypeR2<Code> codedType = createCodedType();
		codedType.getQualifier().add(new CodeRole());
		
		this.constraintsHandler.handleConstraints(constraints, codedType, this.errorLogger);
		
		assertFalse(this.errors.isEmpty());
		assertEquals(1, this.errors.size());
		assertEquals(Hl7ErrorCode.CDA_CARDINALITY_CONSTRAINT, this.errors.get(0).getHl7ErrorCode());
		assertTrue(this.errors.get(0).getMessage().contains(" qualifier "));
		assertTrue(this.errors.get(0).getMessage().contains("cardinality"));
	}

	@Test
	public void testMissingQualifierWhenQualifierMandatory() {
		ConstrainedDatatype constraints = createConstraints(true);
		CodedTypeR2<Code> codedType = createCodedType();
		codedType.getQualifier().clear();
		
		this.constraintsHandler.handleConstraints(constraints, codedType, this.errorLogger);
		
		assertFalse(this.errors.isEmpty());
		assertEquals(1, this.errors.size());
		assertEquals(Hl7ErrorCode.CDA_MANDATORY_CONSTRAINT_MISSING, this.errors.get(0).getHl7ErrorCode());
		assertTrue(this.errors.get(0).getMessage().contains(" qualifier "));
	}

	@Test
	public void testMissingQualifierPassesWhenQualifier0To1() {
		ConstrainedDatatype constraints = createConstraints(false);
		CodedTypeR2<Code> codedType = createCodedType();
		codedType.getQualifier().clear();
		
		this.constraintsHandler.handleConstraints(constraints, codedType, this.errorLogger);
		
		assertTrue(this.errors.isEmpty());
	}

	@Test
	public void testMissingQualifierName() {
		ConstrainedDatatype constraints = createConstraints(true);
		CodedTypeR2<Code> codedType = createCodedType();
		codedType.getQualifier().get(0).setName(null);
		
		this.constraintsHandler.handleConstraints(constraints, codedType, this.errorLogger);
		
		assertFalse(this.errors.isEmpty());
		assertEquals(1, this.errors.size());
		assertEquals(Hl7ErrorCode.CDA_MANDATORY_CONSTRAINT_MISSING, this.errors.get(0).getHl7ErrorCode());
		assertTrue(this.errors.get(0).getMessage().contains(" qualifier.name "));
	}

	@Test
	public void testMissingQualifierNameCodeAndQualifierNameCodeSystem() {
		ConstrainedDatatype constraints = createConstraints(true);
		CodedTypeR2<Code> codedType = createCodedType();
		codedType.getQualifier().get(0).setName(new CodedTypeR2<Code>());
		
		this.constraintsHandler.handleConstraints(constraints, codedType, this.errorLogger);
		
		assertTrue(this.errors.isEmpty());
		assertEquals("121139", codedType.getQualifier().get(0).getName().getCodeValue());
		assertEquals("1.2.840.10008.2.16.4", codedType.getQualifier().get(0).getName().getCodeSystem());
	}

	@Test
	public void testIncorrectQualifierNameCodeAndQualifierNameCodeSystem() {
		Code incorrectName = this.trivialCodeResolver.lookup(ca.infoway.messagebuilder.domainvalue.ActStatus.class, "badCode", "badCodeSystem");

		ConstrainedDatatype constraints = createConstraints(true);
		CodedTypeR2<Code> codedType = createCodedType();
		codedType.getQualifier().get(0).setName(new CodedTypeR2<Code>(incorrectName));
		
		this.constraintsHandler.handleConstraints(constraints, codedType, this.errorLogger);
		
		assertFalse(this.errors.isEmpty());
		assertEquals(2, this.errors.size());
		assertEquals(Hl7ErrorCode.CDA_FIXED_CONSTRAINT_MISSING, this.errors.get(0).getHl7ErrorCode());
		assertTrue(this.errors.get(0).getMessage().contains(" qualifier.name.code "));
		assertEquals(Hl7ErrorCode.CDA_FIXED_CONSTRAINT_MISSING, this.errors.get(1).getHl7ErrorCode());
		assertTrue(this.errors.get(1).getMessage().contains(" qualifier.name.codeSystem "));
		
		assertEquals("badCode", codedType.getQualifier().get(0).getName().getCodeValue());
		assertEquals("badCodeSystem", codedType.getQualifier().get(0).getName().getCodeSystem());
	}

	@Test
	public void testMissingQualifierValue() {
		ConstrainedDatatype constraints = createConstraints(true);
		CodedTypeR2<Code> codedType = createCodedType();
		codedType.getQualifier().get(0).setValue(null);
		
		this.constraintsHandler.handleConstraints(constraints, codedType, this.errorLogger);
		
		assertFalse(this.errors.isEmpty());
		assertEquals(1, this.errors.size());
		assertEquals(Hl7ErrorCode.CDA_MANDATORY_CONSTRAINT_MISSING, this.errors.get(0).getHl7ErrorCode());
		assertTrue(this.errors.get(0).getMessage().contains(" qualifier.value "));
	}

	@Test
	public void testMissingQualifierValueCodeAndCodeSystemPasses() {
		ConstrainedDatatype constraints = createConstraints(true);
		CodedTypeR2<Code> codedType = createCodedType();
		codedType.getQualifier().get(0).setValue(new CodedTypeR2<Code>());
		
		this.constraintsHandler.handleConstraints(constraints, codedType, this.errorLogger);
		
		assertTrue(this.errors.isEmpty());
		assertNull(codedType.getQualifier().get(0).getValue().getCodeValue());
		assertNull(codedType.getQualifier().get(0).getValue().getCodeSystem());
	}

	@Test
	public void testMissingCodeSystem() {
		Code codeMissingCodeSystem = this.trivialCodeResolver.lookup(ca.infoway.messagebuilder.domainvalue.ActStatus.class, "okCode", null);

		ConstrainedDatatype constraints = createConstraints(true);
		CodedTypeR2<Code> codedType = createCodedType();
		codedType.setCode(codeMissingCodeSystem);
		
		this.constraintsHandler.handleConstraints(constraints, codedType, this.errorLogger);
		
		assertFalse(this.errors.isEmpty());
		assertEquals(1, this.errors.size());
		assertEquals(Hl7ErrorCode.CDA_FIXED_CONSTRAINT_MISSING, this.errors.get(0).getHl7ErrorCode());
		assertTrue(this.errors.get(0).getMessage().contains(" codeSystem "));
		assertTrue(this.errors.get(0).getMessage().contains(" not provided"));
		
		// these checks may eventually change
		assertEquals("okCode", codedType.getCodeValue());
		assertNull(codedType.getCodeSystem());
//		assertEquals("1.2.840.10008.2.6.1", codedType.getCodeSystem());
	}

	@Test
	public void testIncorrectCodeSystem() {
		Code incorrectCode = this.trivialCodeResolver.lookup(ca.infoway.messagebuilder.domainvalue.ActStatus.class, "badCode", "badCodeSystem");

		ConstrainedDatatype constraints = createConstraints(true);
		CodedTypeR2<Code> codedType = createCodedType();
		codedType.setCode(incorrectCode);
		
		this.constraintsHandler.handleConstraints(constraints, codedType, this.errorLogger);
		
		assertFalse(this.errors.isEmpty());
		assertEquals(1, this.errors.size());
		assertEquals(Hl7ErrorCode.CDA_FIXED_CONSTRAINT_MISSING, this.errors.get(0).getHl7ErrorCode());
		assertTrue(this.errors.get(0).getMessage().contains(" codeSystem "));
		
		assertEquals("badCode", codedType.getCodeValue());
		assertEquals("badCodeSystem", codedType.getCodeSystem());
	}

	private CodedTypeR2<Code> createCodedType() {
		Code codeWithFixedCodeSystem = this.trivialCodeResolver.lookup(ca.infoway.messagebuilder.domainvalue.ActStatus.class, "aCode", "1.2.840.10008.2.6.1");
		
		Code name = this.trivialCodeResolver.lookup(ca.infoway.messagebuilder.domainvalue.ActStatus.class, "121139", "1.2.840.10008.2.16.4");
		Code value = this.trivialCodeResolver.lookup(ca.infoway.messagebuilder.domainvalue.ActStatus.class, "anotherCode", "1.2.88888888");
		
		CodeRole qualifier = new CodeRole(new CodedTypeR2<Code>(name), new CodedTypeR2<Code>(value));
		
		CodedTypeR2<Code> codedType = new CodedTypeR2<Code>(codeWithFixedCodeSystem);
		codedType.getQualifier().add(qualifier);
		
		return codedType;
	}

	private ConstrainedDatatype createConstraints(boolean qualifierMandatory) {
//        <relationship name="qualifier" attribute="false" cardinality="0-1"/>
//        <relationship name="qualifier" attribute="false" cardinality="1"/>
//        <relationship name="qualifier.name" attribute="false" cardinality="1"/>
//        <relationship name="qualifier.name.code" attribute="false" cardinality="1" fixedValue="121139"/>
//        <relationship name="qualifier.name.codeSystem" attribute="false" cardinality="1" fixedValue="1.2.840.10008.2.16.4"/>
//        <relationship name="qualifier.value" attribute="false" cardinality="1"/>
//        <relationship name="qualifier.value.code" attribute="false" domainType="TargetSiteQualifiers" domainSource="VALUE_SET" cardinality="0-1"/>
//        <relationship name="codeSystem" attribute="false" cardinality="1" fixedValue="1.2.840.10008.2.6.1"/>

        ConstrainedDatatype constraints = new ConstrainedDatatype("MessagePart.relationshipName", "CD");
		constraints.setRestriction();
		
		Relationship qualifierConstraint = new Relationship("qualifier", null, Cardinality.create(qualifierMandatory ? "1" : "0-1"));
		
		Relationship qualifierNameConstraint = new Relationship("qualifier.name", null, Cardinality.create("1"));
		
		Relationship qualifierNameCodeConstraint = new Relationship("qualifier.name.code", null, Cardinality.create("1"));
		qualifierNameCodeConstraint.setFixedValue("121139");
		
		Relationship qualifierNameCodeSystemConstraint = new Relationship("qualifier.name.codeSystem", null, Cardinality.create("1"));
		qualifierNameCodeSystemConstraint.setFixedValue("1.2.840.10008.2.16.4");
		
		Relationship qualifierValueConstraint = new Relationship("qualifier.value", null, Cardinality.create("1"));
		
		Relationship qualifierValueCodeConstraint = new Relationship("qualifier.value.code", null, Cardinality.create("1"));
		
		Relationship codeSystemConstraint = new Relationship("codeSystem", null, Cardinality.create("1"));
		codeSystemConstraint.setFixedValue("1.2.840.10008.2.6.1");

		constraints.getRelationships().add(qualifierConstraint);
		constraints.getRelationships().add(qualifierNameConstraint);
		constraints.getRelationships().add(qualifierNameCodeConstraint);
		constraints.getRelationships().add(qualifierNameCodeSystemConstraint);
		constraints.getRelationships().add(qualifierValueConstraint);
		constraints.getRelationships().add(qualifierValueCodeConstraint);
		constraints.getRelationships().add(codeSystemConstraint);
		
		return constraints;
	}
	
}
