package ca.infoway.messagebuilder.generator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.xml.Relationship;

@RunWith(Theories.class)
public class TypeConverterTest {
	
//	@DataPoint public static final TypeNameExpectation STRING = new TypeNameExpectation("ST", "ST", "String");
//	@DataPoint public static final TypeNameExpectation II_OID = new TypeNameExpectation("II.OID", "II", "Identifier");
	@DataPoint public static final TypeNameExpectation LIST_OF_STRINGS = new TypeNameExpectation("LIST<ST>", "LIST<ST, String>", "List<String>");
//	@DataPoint public static final TypeNameExpectation RATIO = new TypeNameExpectation("RTO<PQ.DRUG, PQ.TIME>", "RTO<PQ, PQ>", "Ratio<PhysicalQuantity, PhysicalQuantity>");
//	@DataPoint public static final TypeNameExpectation SET_RATIO = new TypeNameExpectation("SET<RTO<PQ.DRUG, PQ.TIME>>", "SET<RTO<PQ, PQ>>", "Set<Ratio<PhysicalQuantity, PhysicalQuantity>>");
//	@DataPoint public static final TypeNameExpectation GTS_BOUNDEDPIVL = new TypeNameExpectation("GTS.BOUNDEDPIVL", "GTS", "GeneralTimingSpecification");
//	@DataPoint public static final TypeNameExpectation BOGUS_DATA_TYPE = new TypeNameExpectation("BOGUS.STEPHEN", "ANY", "Object");
	
	@Theory
	public void shouldTranslateTypeToShortName(TypeNameExpectation expectation) throws Exception {
		Relationship relationship = new Relationship();
		relationship.setType(expectation.getHl7TypeName());
		DataType type = new TypeConverter().convertToType(relationship);
		assertEquals("returned type", expectation.getShortName(), type.getShortName());
	}

	@Theory
	public void shouldTranslateTypeToShortWrappedName(TypeNameExpectation expectation) throws Exception {
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
