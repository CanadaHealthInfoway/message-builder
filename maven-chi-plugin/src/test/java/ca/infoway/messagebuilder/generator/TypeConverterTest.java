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

package ca.infoway.messagebuilder.generator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;
import ca.infoway.messagebuilder.xml.Relationship;

public class TypeConverterTest {
	
//	@DataPoint public static final TypeNameExpectation STRING = new TypeNameExpectation("ST", "ST", "String");
//	@DataPoint public static final TypeNameExpectation II_OID = new TypeNameExpectation("II.OID", "II", "Identifier");
	public static final TypeNameExpectation LIST_OF_STRINGS = new TypeNameExpectation("LIST<ST>", "LIST<ST, String>", "List<String>");
	public static final TypeNameExpectation COLLECTION_OF_STRINGS = new TypeNameExpectation("COLLECTION<ST>", "COLLECTION<ST>", "Collection<String>");
//	@DataPoint public static final TypeNameExpectation RATIO = new TypeNameExpectation("RTO<PQ.DRUG, PQ.TIME>", "RTO<PQ, PQ>", "Ratio<PhysicalQuantity, PhysicalQuantity>");
//	@DataPoint public static final TypeNameExpectation SET_RATIO = new TypeNameExpectation("SET<RTO<PQ.DRUG, PQ.TIME>>", "SET<RTO<PQ, PQ>>", "Set<Ratio<PhysicalQuantity, PhysicalQuantity>>");
//	@DataPoint public static final TypeNameExpectation GTS_BOUNDEDPIVL = new TypeNameExpectation("GTS.BOUNDEDPIVL", "GTS", "GeneralTimingSpecification");
//	@DataPoint public static final TypeNameExpectation BOGUS_DATA_TYPE = new TypeNameExpectation("BOGUS.STEPHEN", "ANY", "Object");
	
	void assertTranslateTypeToShortName(TypeNameExpectation expectation) throws Exception {
		Relationship relationship = new Relationship();
		relationship.setType(expectation.getHl7TypeName());
		DataType type = new TypeConverter().convertToType(relationship);
		assertEquals("returned type", expectation.getShortName(), type.getShortName(ProgrammingLanguage.JAVA));
	}

	@Test
	public void shouldTranslateTypeToShortWrappedName() throws Exception {
		assertTranslateTypeToShortName(LIST_OF_STRINGS);
		assertTranslateTypeToShortName(COLLECTION_OF_STRINGS);
		assertShortWrappedName(LIST_OF_STRINGS);
		assertShortWrappedName(COLLECTION_OF_STRINGS);
	}

	private void assertShortWrappedName(TypeNameExpectation expectation) {
		Relationship relationship = new Relationship();
		relationship.setType(expectation.getHl7TypeName());
		DataType type = new TypeConverter().convertToType(relationship);
		assertEquals("returned wrapped type", expectation.getShortWrappedName(), type.getShortWrappedName());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionOnTremendouslyIncorrectInput() throws Exception {
		Relationship relationship = new Relationship();
		relationship.setType("ST,II");
		new TypeConverter().convertToType(relationship);
	}
	
	static class TypeNameExpectation {
		private final String hl7TypeName;
		private final String shortWrappedName;
		private final String shortName;
		public TypeNameExpectation(String hl7TypeName, String shortWrappedName, String shortName) {
			this.hl7TypeName = hl7TypeName;
			this.shortWrappedName = shortWrappedName;
			this.shortName = shortName;
		}
		public String getHl7TypeName() {
			return this.hl7TypeName;
		}
		public String getShortWrappedName() {
			return this.shortWrappedName;
		}
		public String getShortName() {
			return this.shortName;
		}
	}
}
