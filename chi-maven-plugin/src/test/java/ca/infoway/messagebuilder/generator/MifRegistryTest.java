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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.GeneratorException;
import ca.infoway.messagebuilder.generator.transform.MifTransform;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

@RunWith(JMock.class)
public class MifRegistryTest implements LogUI {
	
	private static final String CMET_DEFINING_PACKAGE_NAME = "DEFN=UV=IFC=1.8.3";

	private Mockery jmock = new JUnit4Mockery() {{
       setImposteriser(ClassImposteriser.INSTANCE);
    }}; 
	
	private MifRegistry registry;
	private DocumentFactory factory;
	private MifTransform mifTransformer;

	@Before
	public void setUp() throws Exception {
		this.factory = this.jmock.mock(DocumentFactory.class);
		this.mifTransformer = this.jmock.mock(MifTransform.class);
		
		this.registry = new MifRegistry(this.factory, this.mifTransformer, this);
	}
	
	private MifRegistry createMifRegistryForMifTransform(MifTransform mifTransform) throws Exception {
		return new MifRegistry(this.factory, mifTransform, this) {
			@Override
			void checkVersion(Document document, File file) throws GeneratorException {
				this.namespace = "urn:hl7-org:v3/mif2";			
			}
			@Override
			String extractName(Document mif) throws GeneratorException {
				return "mifName";
			}
		};
	}
	
	
	@Test
	public void shouldDetectMif2VersionNumber() throws Exception {
		this.registry.checkVersion(
				createDocument("COCT_MT011001CA - Care Event identified.mif"), 
				new File("some file.txt"));
		assertEquals("version", "2.1.3", this.registry.getMifVersion());
	}

	@Test
	public void shouldRegisterNameOfMif() throws Exception {
		Document document = createDocument("COCT_MT011001CA - Care Event identified.mif");
		this.registry.checkVersion(document, new File("some file.txt"));
		this.registry.register("COCT_MT011001CA - Care Event identified.mif", document, "myCategory");
		Mif mif = this.registry.getMif("COCT_MT011001CA");
		
		assertNotNull("mif", mif);
		assertEquals("name", "CareEventIdentified", mif.getName());
//		assertNotNull("by name", this.registry.getMifByName(CMET_DEFINING_PACKAGE_NAME, mif.getName())); // this may not be supported anymore
	}
	
	@Test
	public void shouldRecognizeMifAliases() throws Exception {
		Document document = createDocument("COCT_MT011001CA - Care Event identified.mif");
		this.registry.checkVersion(document, new File("some file.txt"));
		this.registry.register("COCT_MT011001CA - Care Event identified.mif", document, "myCategory");
		CmetDefinition cmet = new CmetDefinition();
		cmet.setDefinitionPackage(CMET_DEFINING_PACKAGE_NAME);
		cmet.setCmetName("A_CocteauTwins");
		cmet.setBoundClass("COCT_MT011001CA");
		this.registry.registerCmet(cmet);
		Mif mif = this.registry.getMif("COCT_MT011001CA");
		
		assertNotNull("mif", mif);
		assertEquals("name", "CareEventIdentified", mif.getName());
		assertNotNull("by name", this.registry.getMifByName(CMET_DEFINING_PACKAGE_NAME, "A_CocteauTwins"));
	}
	
//	@Test
//	public void shouldHandleNamesWithAnnoyingPrefix() throws Exception {
//		Document document = createDocument("COCT_MT011001CA - Care Event identified.mif");
//		this.registry.checkVersion(document, new File("some file.txt"));
//		this.registry.register("COCT_MT011001CA - Care Event identified.mif", document, "myCategory");
//
//		assertNotNull("get R_CareEventIdentified", this.registry.getMifByName(CMET_DEFINING_PACKAGE_NAME, "R_CareEventIdentified"));
//	}
//	
	private Document createDocument(String resourceName) throws IOException, SAXException {
		return new DocumentFactory().createFromResource(
				new ClasspathResource(getClass(), resourceName));
	}

	@Test(expected=MifVersionException.class)
	public void shouldThrowException () throws Exception {
		this.registry.checkVersion(
				createDocument("COCT_MT011001CA - Care Event identified.mif"), 
				new File("some file.txt"));
		this.registry.checkVersion(
				createDocument("COCT_MT050007CA - Patient Person Lab informational.mif"), 
				new File("some other file.txt"));
	}

	@Test
	public void shouldGetCachedMif() throws Exception {
		Mif mifExepected = this.registry.new MifImpl(null, null, null, null);
		this.registry.packageLocationToMif.put("PRPA_MT000041CA", mifExepected);
		Mif mif = this.registry.getMif(new MifReferenceImpl(new File("PRPA_MT000041CA - Patient.mif")));
		Assert.assertNotNull(mif);
		Assert.assertEquals(mifExepected, mif);
	}
	
	@Test
	public void shouldRegisterMif() throws Exception {
		final File mifFile = new File("PRPA_MT000041CA - Patient.mif");
		final Document mifDoc = this.jmock.mock(Document.class);
		
		this.jmock.checking(new Expectations() {{
			one(factory).createFromFile(mifFile); will(returnValue(mifDoc));
			one(mifTransformer).shouldBeTransformed(mifDoc); will(returnValue(true));
			one(mifTransformer).transform(mifDoc); will(returnValue(mifDoc));
		}});
		
		Mif mif = createMifRegistryForMifTransform(this.mifTransformer).getMif(new MifReferenceImpl(mifFile));
		
		Assert.assertNotNull(mif);
		Assert.assertEquals("PRPA_MT000041CA", mif.getPackageLocation());
		Assert.assertEquals("mifName", mif.getName());
	}
	
	@Test
	public void shouldNotTryToTransformMifIfNoTransformXslProvided() throws Exception {
		final File mifFile = new File("PRPA_MT000041CA - Patient.mif");
		final Document mifDoc = this.jmock.mock(Document.class);
		
		this.jmock.checking(new Expectations() {{
			one(factory).createFromFile(mifFile); will(returnValue(mifDoc));
		}});
		
		Mif mif = createMifRegistryForMifTransform(null).getMif(new MifReferenceImpl(mifFile));
		
		Assert.assertNotNull(mif);
		Assert.assertEquals("PRPA_MT000041CA", mif.getPackageLocation());
		Assert.assertEquals("mifName", mif.getName());
	}
	
	public void log(LogLevel level, String message) {
		// no op
	}
	
	class MifReferenceImpl implements MifReference {
		private final File file;

		public MifReferenceImpl(File file) {
			this.file = file;
		}
		public File asFile() {
			return this.file;
		}
		public String getCategory() {
			return null;
		}
	}
}
