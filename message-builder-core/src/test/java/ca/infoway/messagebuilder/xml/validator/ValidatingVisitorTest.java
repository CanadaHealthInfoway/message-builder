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

package ca.infoway.messagebuilder.xml.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.domainvalue.controlact.ActStatus;
import ca.infoway.messagebuilder.marshalling.XmlRenderingVisitor;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.EnumBasedCodeResolver;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.xml.CodingStrength;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.Relationship;

public class ValidatingVisitorTest {

	public static final ConformanceLevel MANDATORY = ConformanceLevel.MANDATORY;
	public static final ConformanceLevel POPULATED = ConformanceLevel.POPULATED;
	public static final ConformanceLevel IGNORED = ConformanceLevel.IGNORED;
	public static final ConformanceLevel NOT_ALLOWED = ConformanceLevel.NOT_ALLOWED;

	@Test
	public void shouldHaveValidationErrors() throws Exception {
		assertShouldHaveValidationErrorsFor(MANDATORY);
		assertShouldHaveValidationErrorsFor(POPULATED);
	}
	
	public void assertShouldHaveValidationErrorsFor(ConformanceLevel conformanceLevel) throws Exception {
		ValidatingVisitor validatingVisitor = new ValidatingVisitor(SpecificationVersion.R02_04_02);
		Relationship relationship = new Relationship();
		relationship.setName("value");
		relationship.setConformance(conformanceLevel);
		
		validatingVisitor.visitNonStructuralAttribute(createElement("<node/>"), new ArrayList<Element>(), relationship);
		
		List<Hl7Error> hl7Errors = validatingVisitor.getResult().getHl7Errors();
		assertFalse(hl7Errors.isEmpty());
	}
	
	@Test
	public void shouldHaveValidationErrorForFixedNonStructural() throws Exception {
		
		CodeResolverRegistry.register(new EnumBasedCodeResolver(ActStatus.class));
		
		Relationship relationship = new Relationship();
		relationship.setName("statusCode");
		relationship.setConformance(MANDATORY);
		relationship.setFixedValue("completed");
		relationship.setDomainType("ActStatus");
		relationship.setCodingStrength(CodingStrength.CNE);
		relationship.setType("CS");
		relationship.setStructural(false);
		
		ValidatingVisitor validatingVisitor = new ValidatingVisitor(SpecificationVersion.R02_04_02);
		validatingVisitor.visitNonStructuralAttribute(createElement("<node/>"), Arrays.asList(createElement("<statusCode code=\"completed\"/>")), relationship);
		List<Hl7Error> hl7Errors = validatingVisitor.getResult().getHl7Errors();
		assertTrue(hl7Errors.isEmpty());

		validatingVisitor = new ValidatingVisitor(SpecificationVersion.R02_04_02);
		validatingVisitor.visitNonStructuralAttribute(createElement("<node/>"), Arrays.asList(createElement("<statusCode code=\"new\"/>")), relationship);
		hl7Errors = validatingVisitor.getResult().getHl7Errors();
		assertFalse(hl7Errors.isEmpty());

		validatingVisitor = new ValidatingVisitor(SpecificationVersion.R02_04_02);
		validatingVisitor.visitNonStructuralAttribute(createElement("<node/>"), Arrays.asList(createElement("<statusCode code=\"completedABC\"/>")), relationship);
		hl7Errors = validatingVisitor.getResult().getHl7Errors();
		assertFalse(hl7Errors.isEmpty());
		
	}
	
	@Test
	public void shouldHaveNoValidationErrorForFixedNonStructuralWhenBoolean() throws Exception {
		
		CodeResolverRegistry.register(new EnumBasedCodeResolver(ActStatus.class));
		
		Relationship relationship = new Relationship();
		relationship.setName("statusCode");
		relationship.setConformance(MANDATORY);
		relationship.setFixedValue("true");
		relationship.setStructural(false);
		relationship.setType("BL");

		ValidatingVisitor validatingVisitor = new ValidatingVisitor(SpecificationVersion.R02_04_02);
		validatingVisitor.visitNonStructuralAttribute(createElement("<node/>"), Arrays.asList(createElement("<statusCode value=\"true\"/>")), relationship);
		List<Hl7Error> hl7Errors = validatingVisitor.getResult().getHl7Errors();
		assertTrue(hl7Errors.isEmpty());

	}
	
	@Test
	public void shouldHaveNoValidationErrorForFixedNonStructuralWhenIntPos() throws Exception {
		
		CodeResolverRegistry.register(new EnumBasedCodeResolver(ActStatus.class));
		
		Relationship relationship = new Relationship();
		relationship.setName("statusCode");
		relationship.setConformance(MANDATORY);
		relationship.setFixedValue("112233");
		relationship.setStructural(false);
		relationship.setType("INT.POS");

		ValidatingVisitor validatingVisitor = new ValidatingVisitor(SpecificationVersion.R02_04_02);
		validatingVisitor.visitNonStructuralAttribute(createElement("<node/>"), Arrays.asList(createElement("<statusCode value=\"112233\"/>")), relationship);
		List<Hl7Error> hl7Errors = validatingVisitor.getResult().getHl7Errors();
		assertTrue(hl7Errors.isEmpty());

	}
	
	@Test
	public void shouldHaveValidationErrorForFixedNonStructuralWhenNotValidType() throws Exception {
		
		CodeResolverRegistry.register(new EnumBasedCodeResolver(ActStatus.class));
		
		Relationship relationship = new Relationship();
		relationship.setName("statusCode");
		relationship.setConformance(MANDATORY);
		relationship.setFixedValue("123");
		relationship.setStructural(false);
		relationship.setType("INT.NONNEG");

		ValidatingVisitor validatingVisitor = new ValidatingVisitor(SpecificationVersion.R02_04_02);
		validatingVisitor.visitNonStructuralAttribute(createElement("<node/>"), Arrays.asList(createElement("<statusCode value=\"123\"/>")), relationship);
		List<Hl7Error> hl7Errors = validatingVisitor.getResult().getHl7Errors();
		assertFalse(hl7Errors.isEmpty());

	}

	@Test
	public void shouldHaveValidationErrorForIgnoreConformanceAsNotAllowedOnAssociation() throws Exception {
		System.setProperty(XmlRenderingVisitor.IGNORED_AS_NOT_ALLOWED, "true");
		CodeResolverRegistry.register(new EnumBasedCodeResolver(ActStatus.class));
		
		Relationship relationship = new Relationship();
		relationship.setName("admitter");
		relationship.setConformance(IGNORED);
		relationship.setType("COCT_MT011001CA.Admitter");

		ValidatingVisitor validatingVisitor = new ValidatingVisitor(SpecificationVersion.R02_04_02);
		validatingVisitor.visitAssociation(createElement("<node/>"), "admitter", Arrays.asList(createElement("<admitter />")), relationship);
		List<Hl7Error> hl7Errors = validatingVisitor.getResult().getHl7Errors();
		assertFalse(hl7Errors.isEmpty());
		System.clearProperty(XmlRenderingVisitor.IGNORED_AS_NOT_ALLOWED);
	}
	
	@Test
	public void shouldHaveValidationErrorForNotAllowedConformanceOnAssociation() throws Exception {
		CodeResolverRegistry.register(new EnumBasedCodeResolver(ActStatus.class));
		
		Relationship relationship = new Relationship();
		relationship.setName("admitter");
		relationship.setConformance(NOT_ALLOWED);
		relationship.setType("COCT_MT011001CA.Admitter");

		ValidatingVisitor validatingVisitor = new ValidatingVisitor(SpecificationVersion.R02_04_02);
		validatingVisitor.visitAssociation(createElement("<node/>"), "admitter", Arrays.asList(createElement("<admitter />")), relationship);
		List<Hl7Error> hl7Errors = validatingVisitor.getResult().getHl7Errors();
		assertFalse(hl7Errors.isEmpty());
	}
	
	@Test
	public void shouldHaveNoValidationErrorForIgnoreConformanceAsOptionalOnAssociation() throws Exception {
		CodeResolverRegistry.register(new EnumBasedCodeResolver(ActStatus.class));
		
		Relationship relationship = new Relationship();
		relationship.setName("admitter");
		relationship.setConformance(IGNORED);
		relationship.setType("COCT_MT011001CA.Admitter");

		ValidatingVisitor validatingVisitor = new ValidatingVisitor(SpecificationVersion.R02_04_02);
		validatingVisitor.visitAssociation(createElement("<node/>"), "admitter", Arrays.asList(createElement("<admitter />")), relationship);
		List<Hl7Error> hl7Errors = validatingVisitor.getResult().getHl7Errors();
		assertTrue(hl7Errors.isEmpty());
	}
	
	@Test
	public void shouldHaveValidationErrorForIgnoreConformanceAsNotAllowedOnAttribute() throws Exception {
		System.setProperty(XmlRenderingVisitor.IGNORED_AS_NOT_ALLOWED, "true");
		CodeResolverRegistry.register(new EnumBasedCodeResolver(ActStatus.class));
		
		Relationship relationship = new Relationship();
		relationship.setName("statusCode");
		relationship.setConformance(IGNORED);
		relationship.setFixedValue("123");
		relationship.setStructural(false);
		relationship.setType("INT.NONNEG");
		
		ValidatingVisitor validatingVisitor = new ValidatingVisitor(SpecificationVersion.R02_04_02);
		validatingVisitor.visitNonStructuralAttribute(createElement("<node/>"), Arrays.asList(createElement("<statusCode value=\"123\"/>")), relationship);
		List<Hl7Error> hl7Errors = validatingVisitor.getResult().getHl7Errors();
		assertFalse(hl7Errors.isEmpty());
		System.clearProperty(XmlRenderingVisitor.IGNORED_AS_NOT_ALLOWED);
	}
	
	@Test
	public void shouldHaveValidationErrorForNotAllowedConformanceOnAttribute() throws Exception {
		CodeResolverRegistry.register(new EnumBasedCodeResolver(ActStatus.class));
		
		Relationship relationship = new Relationship();
		relationship.setName("statusCode");
		relationship.setConformance(NOT_ALLOWED);
		relationship.setFixedValue("123");
		relationship.setStructural(false);
		relationship.setType("INT.NONNEG");

		ValidatingVisitor validatingVisitor = new ValidatingVisitor(SpecificationVersion.R02_04_02);
		validatingVisitor.visitNonStructuralAttribute(createElement("<node/>"), Arrays.asList(createElement("<statusCode value=\"123\"/>")), relationship);
		List<Hl7Error> hl7Errors = validatingVisitor.getResult().getHl7Errors();
		assertFalse(hl7Errors.isEmpty());
	}
	
	@Test
	public void shouldHaveNoValidationErrorForIgnoreConformanceAsOptionalOnAttribute() throws Exception {
		CodeResolverRegistry.register(new EnumBasedCodeResolver(ActStatus.class));
		
		Relationship relationship = new Relationship();
		relationship.setName("statusCode");
		relationship.setConformance(IGNORED);
		relationship.setFixedValue("123");
		relationship.setStructural(false);
		relationship.setType("INT.NONNEG");

		ValidatingVisitor validatingVisitor = new ValidatingVisitor(SpecificationVersion.R02_04_02);
		validatingVisitor.visitNonStructuralAttribute(createElement("<node/>"), Arrays.asList(createElement("<statusCode value=\"123\"/>")), relationship);
		List<Hl7Error> hl7Errors = validatingVisitor.getResult().getHl7Errors();
		assertTrue(hl7Errors.isEmpty());
	}
	
	private Element createElement(String xml) throws SAXException {
		return new DocumentFactory().createFromString(xml).getDocumentElement();
	}
	
}
