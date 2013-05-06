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
package ca.infoway.messagebuilder.html.generator;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ca.infoway.messagebuilder.datatype.mif.DatatypeMifMarshaller;
import ca.infoway.messagebuilder.datatype.mif.MifDatatypeModelLibrary;
import ca.infoway.messagebuilder.datatype.model.Datatype;
import ca.infoway.messagebuilder.datatype.model.DatatypeSet;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.MessageSetMarshaller;

@RunWith(MockitoJUnitRunner.class)
public class DatatypeHtmlTest {

	private DatatypeMifMarshaller marshaller = new DatatypeMifMarshaller();
	private MifDatatypeModelLibrary uvDatatypeModel;
	private MifDatatypeModelLibrary caDatatypeModel;
	private DatatypeSet testUVDatatypeSet;
	private DatatypeSet testCADatatypeSet;
	private MessageSet testMessageSet;
	
	@Before
	public void setUp() throws Exception {
		InputStream input1 = getClass().getResourceAsStream("/DEFN=UV=DT=1.1.coremif");
		uvDatatypeModel = getMifTestModel(input1);
		InputStream input2 = getClass().getResourceAsStream("/DEFN=CA=DT=R02.04.xx.coremif");
		caDatatypeModel = getMifTestModel(input2);
		testUVDatatypeSet = new DatatypeSet(uvDatatypeModel);
		testCADatatypeSet = new DatatypeSet(testUVDatatypeSet, caDatatypeModel);
		
		MessageSetMarshaller marshaller = new MessageSetMarshaller();
		InputStream resourceAsStream = getClass().getResourceAsStream("/test_messageSet.xml");
		testMessageSet = marshaller.unmarshall(resourceAsStream);
	}

	@Test
	public void testWrite() {
		Datatype datatype = testCADatatypeSet.getAllDatatypes().get(0);
		DatatypeHtml html = new DatatypeHtml(datatype, testCADatatypeSet, testMessageSet);
		
		assertNotNull(html.write());
		assertTrue(html.write().length() > 0);
	}
	
	private MifDatatypeModelLibrary getMifTestModel(InputStream input) throws IOException {
		MifDatatypeModelLibrary model = null;
		try {
			model = marshaller.unmarshallDatatypeModel(input);
		} finally {
			IOUtils.closeQuietly(input);
		}
		return model;
	}
}
