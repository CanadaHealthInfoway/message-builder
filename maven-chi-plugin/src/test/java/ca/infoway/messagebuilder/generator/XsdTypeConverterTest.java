package ca.infoway.messagebuilder.generator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Assume;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.lang.EnumPattern;
import ca.infoway.messagebuilder.xml.Relationship;

@RunWith(Theories.class)
public class XsdTypeConverterTest {
	
	@DataPoint public static final String[] AD = { "AD", "chi:PostalAddress" };
	@DataPoint public static final String[] AD_BASIC = { "AD.BASIC", "chi:PostalAddress" };
	@DataPoint public static final String[] ST = { "ST", "xs:string" };
	@DataPoint public static final String[] LIST_II = { "LIST<II>", "chi:InstanceIdentifier" };
	@DataPoint public static final String[] INT = { "INT", "xs:integer" };
	@DataPoint public static final String[] IVL_TS = { "IVL<TS>", "chi:DateInterval" };
	@DataPoint public static final String[] IVL_LOW_TS = { "IVL.LOW<TS>", "chi:DateInterval" };
	@DataPoint public static final String[] IVL_TS_FULLDATETIME = { "IVL<TS.FULLDATETIME>", "chi:DateInterval" };
	
	@DataPoints public static final StandardDataType[] DATA_TYPES = EnumPattern.values(StandardDataType.class).toArray(new StandardDataType[0]);
	
	@Theory
	public void shouldResolveSimpleType(String[] parameters) throws Exception {
		XsdDataType type = new XsdTypeConverter().convertToType(createRelationship(parameters[0]));
		assertNotNull("type found: " + parameters[0], type);
		assertEquals("type", parameters[1], type.getQualifiedName());
	}

	@Theory
	public void shouldResolveSimpleTypeToSomething(StandardDataType standardDataType) throws Exception {
		Assume.assumeTrue(!"LIST".equals(standardDataType.getType()));
		Assume.assumeTrue(!"SET".equals(standardDataType.getType()));
		Assume.assumeTrue(!"COLLECTION".equals(standardDataType.getType()));
		Assume.assumeTrue(standardDataType.isPartOfCanadianSpec());

		XsdDataType type = new XsdTypeConverter().convertToType(createRelationship(standardDataType.getType()));
		assertNotNull("type found: " + standardDataType.getType(), type);
	}
	
	private Relationship createRelationship(String type) {
		Relationship relationship = new Relationship();
		relationship.setType(type);
		return relationship;
	}
}
