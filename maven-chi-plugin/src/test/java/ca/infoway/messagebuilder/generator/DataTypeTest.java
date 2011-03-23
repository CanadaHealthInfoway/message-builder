package ca.infoway.messagebuilder.generator;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Set;

import org.junit.Test;

import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;


public class DataTypeTest {
	
	@Test
	public void shouldGetBasicWrappedType() throws Exception {
		DataType dataType = new DataType(DataTypeGenerationDetails.ST, null);
		assertEquals("ST", "ST", dataType.getShortWrappedName());
	}
	
	@Test
	public void shouldGetParameterizedWrappedType() throws Exception {
		DataType dataType = new DataType(DataTypeGenerationDetails.LIST, null, new DataType(DataTypeGenerationDetails.ST,String.class.getName()));
		assertEquals("LIST<ST, String>", "LIST<ST, String>", dataType.getShortWrappedName());
	}
	
	@Test
	public void shouldGetParameterizedWrappedAnyType() throws Exception {
		DataType dataType = new DataType(DataTypeGenerationDetails.ANY, null);
		assertEquals("Wrapper", "ANY<Object>", dataType.getShortWrappedName());
		assertEquals("Wrapper impl", "ANYImpl<Object>", dataType.getShortWrappedNameImpl());
		assertEquals("Underlying type", "Object", dataType.getShortName());
	}
	
	@Test
	public void shouldGetBasicType() throws Exception {
		DataType dataType = new DataType(DataTypeGenerationDetails.ST, String.class.getName());
		assertEquals("String", "String", dataType.getShortName());
		assertEquals("String", "String", dataType.getShortName(ProgrammingLanguage.C_SHARP));
	}
	
	@Test
	public void shouldGetParameterizedType() throws Exception {
		DataType dataType = new DataType(DataTypeGenerationDetails.LIST, List.class.getName(), new DataType(DataTypeGenerationDetails.ST, String.class.getName()));
		assertEquals("List<String>", "List<String>", dataType.getShortName());
	}

	@Test
	public void shouldGetCodeType() throws Exception {
		DataType dataType = new DataType(DataTypeGenerationDetails.CD, "ca.infoway.messagebuilder.domainvalue.ActStatus");
		assertEquals("CD", "CD", dataType.getShortWrappedName());
		assertEquals("CD", "ActStatus", dataType.getShortName());
		assertEquals("CD", "ActStatus", dataType.getUnparameterizedShortName());
	}
	
	@Test
	public void shouldGetImportsForWrappedSimpleType() throws Exception {
		DataType dataType = new DataType(DataTypeGenerationDetails.ST, "java.lang.String");
		Set<String> types = dataType.getImportTypes();
		assertThat("ST", types, hasItem("ca.infoway.messagebuilder.datatype.ST"));
		assertThat("STImpl", types, hasItem("ca.infoway.messagebuilder.datatype.impl.STImpl"));
		assertThat("String", types, hasItem("java.lang.String"));
	}

	// private LIST<II, Identifier> identifiers = new LISTImpl<II, Identifier>(IIImpl.class);
	@Test
	public void shouldGetImportsForCollectionType() throws Exception {
		DataType dataType = new TypeConverter().convertToType("LIST<II.OID>", null);
		Set<String> types = dataType.getImportTypes();
		
		System.out.println(types);
		assertThat("II", types, hasItem("ca.infoway.messagebuilder.datatype.II"));
		assertThat("Identifier", types, hasItem("ca.infoway.messagebuilder.datatype.lang.Identifier"));
		assertThat("IIImpl", types, hasItem("ca.infoway.messagebuilder.datatype.impl.IIImpl"));
	}
	
	@Test
	public void shouldGetImportsForWrappedCd() throws Exception {
		DataType dataType = new DataType(DataTypeGenerationDetails.CD, "ca.infoway.messagebuilder.domainvalue.ActStatus");
		Set<String> types = dataType.getImportTypes();
		assertThat("CD", types, hasItem("ca.infoway.messagebuilder.datatype.CD"));
		assertThat("CDImpl", types, hasItem("ca.infoway.messagebuilder.datatype.impl.CDImpl"));
		assertThat("String", types, hasItem("ca.infoway.messagebuilder.domainvalue.ActStatus"));
	}
	
}
