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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.generator;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.COLLECTION;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.generator.util.ProgrammingLanguage;


public class DataTypeTest {
	
	@Test
	public void shouldGetBasicWrappedType() throws Exception {
		DataType dataType = new DataType(DataTypeGenerationDetails.ST, null, false);
		assertEquals("ST", "ST", dataType.getShortWrappedName());
	}
	
	@Test
	public void shouldGetNonPanCanadianType() throws Exception {
		DataType dataType = new TypeConverter(false).convertToType("AD", null);
		assertEquals("AD", "AD", dataType.getShortWrappedName());
		assertEquals("AD - Java", "AD", dataType.getShortWrappedName(ProgrammingLanguage.JAVA));
		assertEquals("AD class", AD.class.getName(), dataType.getHl7ClassName());
		assertEquals("type", DataTypeGenerationDetails.AD, dataType.getType());
		assertEquals("Java type", PostalAddress.class.getName(), dataType.getType().getJavaTypeName());
		
		dataType = new TypeConverter(false).convertToType("BAG<AD>", null);
		assertEquals("BAG<AD>", "COLLECTION<AD>", dataType.getShortWrappedName());
		assertEquals("BAG - Java", "COLLECTION<AD>", dataType.getShortWrappedName(ProgrammingLanguage.JAVA));
		assertEquals("BAG class", COLLECTION.class.getName(), dataType.getHl7ClassName());
		assertEquals("type", DataTypeGenerationDetails.BAG, dataType.getType());
		assertEquals("Java type", Collection.class.getName(), dataType.getType().getJavaTypeName());
	}
	
	@Test
	public void shouldGetParameterizedWrappedType() throws Exception {
		DataType dataType = new DataType(DataTypeGenerationDetails.LIST, null, false, new DataType(DataTypeGenerationDetails.ST,String.class.getName(), false));
		assertEquals("LIST<ST, String>", "LIST<ST, String>", dataType.getShortWrappedName());
	}
	
	@Test
	public void shouldGetParameterizedWrappedAnyType() throws Exception {
		DataType dataType = new DataType(DataTypeGenerationDetails.ANY, null, false);
		assertEquals("Wrapper", "ANY<Object>", dataType.getShortWrappedName());
		assertEquals("Wrapper impl", "ANYImpl<Object>", dataType.getShortWrappedNameImpl());
		assertEquals("Underlying type", "Object", dataType.getShortName(ProgrammingLanguage.JAVA));
	}
	
	@Test
	public void shouldGetBasicType() throws Exception {
		DataType dataType = new DataType(DataTypeGenerationDetails.ST, String.class.getName(), false);
		assertEquals("String", "String", dataType.getShortName(ProgrammingLanguage.JAVA));
		assertEquals("String", "String", dataType.getShortName(ProgrammingLanguage.C_SHARP));
	}
	
	@Test
	public void shouldGetParameterizedType() throws Exception {
		DataType dataType = new DataType(DataTypeGenerationDetails.LIST, List.class.getName(), false, new DataType(DataTypeGenerationDetails.ST, String.class.getName(), false));
		assertEquals("List<String>", "List<String>", dataType.getShortName(ProgrammingLanguage.JAVA));
	}

	@Test
	public void shouldGetCodeType() throws Exception {
		DataType dataType = new DataType(DataTypeGenerationDetails.CD, "ca.infoway.messagebuilder.domainvalue.ActStatus", false);
		assertEquals("CD", "CD", dataType.getShortWrappedName());
		assertEquals("CD", "ActStatus", dataType.getShortName(ProgrammingLanguage.JAVA));
		assertEquals("CD", "ActStatus", dataType.getUnparameterizedShortName(ProgrammingLanguage.JAVA));
	}
	
	@Test
	public void shouldGetCodeTypeR2() throws Exception {
		DataType dataType = new DataType(DataTypeGenerationDetails.CD, "ca.infoway.messagebuilder.domainvalue.ActStatus", true);
		assertEquals("CD", "CD<ActStatus>", dataType.getShortWrappedName());
		assertEquals("CD", "CodedTypeR2<ActStatus>", dataType.getShortName(ProgrammingLanguage.JAVA));
		assertEquals("CD", "ActStatus", dataType.getUnparameterizedShortName(ProgrammingLanguage.JAVA));
	}
	
	@Test
	public void shouldGetListCodeTypeR2() throws Exception {
		DataType dataType = new DataType(DataTypeGenerationDetails.LIST, List.class.getName(), true, new DataType(DataTypeGenerationDetails.CD, "ca.infoway.messagebuilder.domainvalue.ActStatus", true));
		assertEquals("LIST<CD>", "LIST<CD<ActStatus>, CodedTypeR2<ActStatus>>", dataType.getShortWrappedName());
		assertEquals("LIST<CD>", "List<CodedTypeR2<ActStatus>>", dataType.getShortName(ProgrammingLanguage.JAVA));
		assertEquals("LIST<CD>", "List", dataType.getUnparameterizedShortName(ProgrammingLanguage.JAVA));
	}
	
	@Test
	public void shouldGetCodeTypeBxitR2() throws Exception {
		DataType dataType = new DataType(DataTypeGenerationDetails.BXIT_CD_R2, "ca.infoway.messagebuilder.domainvalue.ActStatus", true, new DataType(DataTypeGenerationDetails.CD, "ca.infoway.messagebuilder.domainvalue.ActStatus", true));
		assertEquals("BXIT", "BXIT<CodedTypeR2<ActStatus>>", dataType.getShortWrappedName());
		assertEquals("BXIT", "CodedTypeR2<ActStatus>", dataType.getShortName(ProgrammingLanguage.JAVA));
		assertEquals("BXIT", "ActStatus", dataType.getUnparameterizedShortName(ProgrammingLanguage.JAVA));
	}
	
	@Test
	public void shouldGetListCodeTypeBxitR2() throws Exception {
		DataType dataType = new DataType(DataTypeGenerationDetails.LIST, List.class.getName(), true, new DataType(DataTypeGenerationDetails.BXIT_CD_R2, "ca.infoway.messagebuilder.domainvalue.ActStatus", true, new DataType(DataTypeGenerationDetails.CD, "ca.infoway.messagebuilder.domainvalue.ActStatus", true)));
		assertEquals("LIST<BXIT>", "LIST<BXIT<CodedTypeR2<ActStatus>>, CodedTypeR2<ActStatus>>", dataType.getShortWrappedName());
		assertEquals("LIST<BXIT>", "List<CodedTypeR2<ActStatus>>", dataType.getShortName(ProgrammingLanguage.JAVA));
		assertEquals("LIST<BXIT>", "List", dataType.getUnparameterizedShortName(ProgrammingLanguage.JAVA));
	}
	
	@Test
	public void shouldGetImportsForWrappedSimpleType() throws Exception {
		DataType dataType = new DataType(DataTypeGenerationDetails.ST, "java.lang.String", false);
		Set<String> types = dataType.getImportTypes();
		
		assertThat("ST", types, hasItem("ca.infoway.messagebuilder.datatype.ST"));
		assertThat("STImpl", types, hasItem("ca.infoway.messagebuilder.datatype.impl.STImpl"));
		assertThat("String", types, hasItem("java.lang.String"));
	}

	// private LIST<II, Identifier> identifiers = new LISTImpl<II, Identifier>(IIImpl.class);
	@Test
	public void shouldGetImportsForCollectionType() throws Exception {
		DataType dataType = new TypeConverter(false).convertToType("LIST<II.OID>", null);
		Set<String> types = dataType.getImportTypes();
		
		assertThat("II", types, hasItem("ca.infoway.messagebuilder.datatype.II"));
		assertThat("Identifier", types, hasItem("ca.infoway.messagebuilder.datatype.lang.Identifier"));
		assertThat("IIImpl", types, hasItem("ca.infoway.messagebuilder.datatype.impl.IIImpl"));
	}
	
	@Test
	public void shouldGetImportsForWrappedCd() throws Exception {
		DataType dataType = new DataType(DataTypeGenerationDetails.CD, "ca.infoway.messagebuilder.domainvalue.ActStatus", false);
		Set<String> types = dataType.getImportTypes();
		assertThat("CD", types, hasItem("ca.infoway.messagebuilder.datatype.CD"));
		assertThat("CDImpl", types, hasItem("ca.infoway.messagebuilder.datatype.impl.CDImpl"));
		assertThat("String", types, hasItem("ca.infoway.messagebuilder.domainvalue.ActStatus"));
	}
	
	@Test
	public void shouldGetIvlR2Type() throws Exception {
		DataType tsDataType = new DataType(DataTypeGenerationDetails.TS, DataTypeGenerationDetails.TS.getJavaTypeName(), true);
		DataType dataType = new DataType(DataTypeGenerationDetails.IVL_TS_R2, DataTypeGenerationDetails.IVL_TS_R2.getJavaTypeName(), true, tsDataType);
		assertEquals("DateInterval", dataType.getShortName(ProgrammingLanguage.JAVA));
		assertEquals("IVL_TSImpl", dataType.getShortWrappedNameImpl());
		assertEquals("IVL_TS", dataType.getUnparameterizedShortWrappedName());
		assertEquals("IVL_TSImpl", dataType.getParameterizedImplementationType(ProgrammingLanguage.JAVA));
		assertEquals("ca.infoway.messagebuilder.datatype.impl.IVL_TSImpl", dataType.getUnparameterizedImplementationType());
		assertEquals("ca.infoway.messagebuilder.datatype.lang.DateInterval", dataType.getTypeName());
		assertEquals(DataTypeGenerationDetails.IVL_TS_R2, dataType.getType());
		
		Set<String> importTypes = dataType.getImportTypes();
//		assertEquals(3, importTypes.size()); // IVL_TSImpl, IVL_TS, DateInterval (specifically, there should not be TS or Date)
	}
}
