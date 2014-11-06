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
 * Last modified: $LastChangedDate: 2013-05-16 20:53:38 -0400 (Thu, 16 May 2013) $
 * Revision:      $LastChangedRevision: 6878 $
 */

package ca.infoway.messagebuilder.marshalling.hl7.formatter.r2;

import static ca.infoway.messagebuilder.xml.ConformanceLevel.OPTIONAL;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorCode;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7ErrorLevel;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatContextImpl;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterTestCase;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.ConstrainedDatatype;
import ca.infoway.messagebuilder.xml.Relationship;

public class ListIiR2PropertyFormatterTest extends FormatterTestCase {

	@Test
	public void testFormatValueNull() throws Exception {
		String result = new ListR2PropertyFormatter().format(
				new FormatContextImpl(this.result, null, "ids", "LIST<II>", OPTIONAL, null), 
				(BareANY) new LISTImpl<II, Identifier>(IIImpl.class));
		assertTrue(this.result.isValid());
		assertEquals(0, this.result.getHl7Errors().size());
		assertXml("null", "", result);
	}
	
	@Test
	public void testFormatValueNonNull() throws Exception {
		String result = new ListR2PropertyFormatter().format(
				new FormatContextImpl(this.result, null, "ids", "LIST<II>", OPTIONAL, Cardinality.create("0-4"), false, SpecificationVersion.R02_04_03, null, null, null), 
				(BareANY) LISTImpl.<II, Identifier>create(
						IIImpl.class, 
						createIdentifierList()));
		assertTrue(this.result.isValid());
		assertEquals(0, this.result.getHl7Errors().size());
		assertXml("non null", "<ids extension=\"123\" root=\"1.2.3\"/>" + 
							  "<ids extension=\"256\" root=\"2.5.6\"/>", result);
	}

	@Test
	public void testFormatWithMatchingConstraint() throws Exception {
		Relationship rootConstraint = new Relationship();
		rootConstraint.setName("root");
		rootConstraint.setFixedValue("2.5.6");
		Relationship extConstraint = new Relationship();
		extConstraint.setName("extension");
		extConstraint.setFixedValue("256");
		ConstrainedDatatype constraints = new ConstrainedDatatype("iiConstraint", "II");
		constraints.getRelationships().add(rootConstraint);
		constraints.getRelationships().add(extConstraint);
		
		String result = new ListR2PropertyFormatter().format(
				new FormatContextImpl(this.result, null, "ids", "LIST<II>", null, OPTIONAL, Cardinality.create("0-4"), false, SpecificationVersion.R02_04_03, null, null, null, constraints), 
				(BareANY) LISTImpl.<II, Identifier>create(
						IIImpl.class, 
						createIdentifierList()));
		assertTrue(this.result.isValid());
		assertEquals(0, this.result.getHl7Errors().size());
		assertXml("non null", "<ids extension=\"123\" root=\"1.2.3\"/>" + 
							  "<ids extension=\"256\" root=\"2.5.6\"/>", result);
	}

	@Test
	public void testFormatWithMissingConstraint() throws Exception {
		Relationship rootConstraint = new Relationship();
		rootConstraint.setName("root");
		rootConstraint.setFixedValue("1.22.33.44");
		Relationship extConstraint = new Relationship();
		extConstraint.setName("extension");
		extConstraint.setFixedValue("1223344");
		ConstrainedDatatype constraints = new ConstrainedDatatype("iiConstraint", "II");
		constraints.getRelationships().add(rootConstraint);
		constraints.getRelationships().add(extConstraint);
		
		String result = new ListR2PropertyFormatter().format(
				new FormatContextImpl(this.result, null, "ids", "LIST<II>", null, OPTIONAL, Cardinality.create("0-4"), false, SpecificationVersion.R02_04_03, null, null, null, constraints), 
				(BareANY) LISTImpl.<II, Identifier>create(
						IIImpl.class, 
						createIdentifierList()));
		assertTrue(this.result.isValid());
		assertEquals(1, this.result.getHl7Errors().size());
		assertEquals(Hl7ErrorLevel.INFO, this.result.getHl7Errors().get(0).getHl7ErrorLevel());
		assertEquals(Hl7ErrorCode.CDA_FIXED_CONSTRAINT_PROVIDED, this.result.getHl7Errors().get(0).getHl7ErrorCode());
		assertEquals("A fixed constraint was added for compliance: root={1.22.33.44},extension={1223344}", this.result.getHl7Errors().get(0).getMessage());
		assertXml("non null", "<ids extension=\"123\" root=\"1.2.3\"/>" + 
							  "<ids extension=\"256\" root=\"2.5.6\"/>" +
							  "<ids extension=\"1223344\" root=\"1.22.33.44\"/>", result);
	}

	private List<Identifier> createIdentifierList() {
		ArrayList<Identifier> result = new ArrayList<Identifier>();
		result.add(new Identifier("1.2.3", "123"));
		result.add(new Identifier("2.5.6", "256"));
		return result;
	}

}
