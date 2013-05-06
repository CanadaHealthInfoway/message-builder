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
package ca.infoway.messagebuilder.datatype.mif;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DatatypeMifMarshallerTest {
	private DatatypeMifMarshaller fixture;
	
	@Before
	public void setUp() throws Exception {
		fixture = new DatatypeMifMarshaller();
	}
	
	@Test
	public void testMarshallUVCoreMif() throws Exception {
		InputStream input = getClass().getResourceAsStream("/DEFN=UV=DT=1.1.coremif");
		try {
			MifDatatypeModelLibrary model = this.fixture.unmarshallDatatypeModel(input);
			assertNotNull(model);
		} finally {
			IOUtils.closeQuietly(input);
		}
	}
	
	@Test
	public void testMarshallCACoreMif() throws Exception {
		InputStream input = getClass().getResourceAsStream("/DEFN=CA=DT=R02.04.xx.coremif");
		try {
			MifDatatypeModelLibrary model = this.fixture.unmarshallDatatypeModel(input);
			assertNotNull(model);
		} finally {
			IOUtils.closeQuietly(input);
		}
	}

	@Test
	public void testMarshallMultiDerivedFromElements() throws Exception {
		InputStream input = getClass().getResourceAsStream("/DEFN=UV=DT=1.1.coremif");
		try {
			MifDatatypeModelLibrary model = this.fixture.unmarshallDatatypeModel(input);
			List<MifDatatype> datatypes = model.getDatatypes();
			MifDatatype oidDatatype = null;
			for (MifDatatype mifDatatype : datatypes) {
				if ("OID".equals(mifDatatype.getName())) {
					oidDatatype = mifDatatype;
				}
			}
			assertEquals(2, oidDatatype.getDerivedFrom().size());
			
		} finally {
			IOUtils.closeQuietly(input);
		}
	}
	
	@Test
	public void testMarshallStaticExamples() throws Exception {
		InputStream input = getClass().getResourceAsStream("/DEFN=CA=DT=R02.04.xx.coremif");
		try {
			MifDatatypeModelLibrary model = this.fixture.unmarshallDatatypeModel(input);
			List<MifDatatype> datatypes = model.getDatatypes();
			MifDatatype adBasic = null;
			for (MifDatatype mifDatatype : datatypes) {
				if ("AD.BASIC".equals(mifDatatype.getName())) {
					adBasic = mifDatatype;
				}
			}
			
			assertEquals(1, adBasic.getAnnotations().getAppInfo().getStaticExamples().size());
			assertTrue(adBasic.getAnnotations().getAppInfo().getStaticExamples().get(0).getData().getValue().length() > 0);
			
		} finally {
			IOUtils.closeQuietly(input);
		}
	}
}
