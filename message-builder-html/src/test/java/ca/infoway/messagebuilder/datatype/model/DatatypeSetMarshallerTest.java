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
package ca.infoway.messagebuilder.datatype.model;

import static junit.framework.Assert.assertNotNull;
import static org.mockito.Mockito.atLeastOnce;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.simpleframework.xml.Serializer;

import ca.infoway.messagebuilder.datatype.mif.DatatypeMifMarshaller;
import ca.infoway.messagebuilder.datatype.mif.MifDatatypeModelLibrary;

@RunWith(MockitoJUnitRunner.class)
public class DatatypeSetMarshallerTest {
	private DatatypeSetMarshaller fixture;
	private DatatypeSet testSet;
	private DatatypeSet parentSet;
	@Mock private OutputStream mockOutputStream;
	@Mock private Serializer mockSerializer;
	
	@Before
	public void setUp() throws IOException {
		DatatypeMifMarshaller dtMifMarshaller = new DatatypeMifMarshaller();
		InputStream input1 = getClass().getResourceAsStream("/DEFN=UV=DT=1.1.coremif");
		MifDatatypeModelLibrary uvLib = dtMifMarshaller.unmarshallDatatypeModel(input1);
		InputStream input2 = getClass().getResourceAsStream("/DEFN=CA=DT=R02.04.xx.coremif");
		MifDatatypeModelLibrary caLib = dtMifMarshaller.unmarshallDatatypeModel(input2);
		parentSet = new DatatypeSet(uvLib);
		testSet = new DatatypeSet(parentSet, caLib);
		
		fixture = new DatatypeSetMarshaller();
	}
	
	@Test
	public void testMarshallDatatypeSet() throws Exception {
		fixture.serializer = mockSerializer;
		fixture.marshall(testSet, mockOutputStream);
		
		Mockito.verify(mockSerializer, atLeastOnce()).write(testSet, mockOutputStream);
	}

	@Test
	public void testUnMashallWithParentDatatypeSet() throws Exception {
		Datatype datatype = parentSet.getDatatype("IVL");
		Datatype derivedSet = testSet.getDatatype("IVL");
		
		assertNotNull(datatype);
		assertNotNull(derivedSet);
	}
	
	@Test
	public void testUnMashallDatatypeSet() throws Exception {
		InputStream inputStream = getClass().getResourceAsStream("/datatypeSet.xml");
		
		DatatypeSet datatypeSet = fixture.unmarshallDatatypeModel(inputStream);
		
		Assert.assertNotNull(datatypeSet);
		
		Assert.assertEquals(120, datatypeSet.getAllDatatypes().size());
	}
}
