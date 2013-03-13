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

package ca.infoway.messagebuilder.generator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.util.xml.DocumentFactory;

@RunWith(MockitoJUnitRunner.class)
public class Mif2ProcessorTest {
	
	@Mock 
	private MifRegistry mifRegistry;
	
	@Mock 
	private OutputUI outputUi;
	
	private Mif2Processor fixture;
	
	@Before
	public void setUp() throws Exception {
		fixture = new Mif2Processor(mifRegistry, outputUi);
	}
	
	@Test
	public void shouldParseCmetDefinitionCoremif() throws Exception {
		
		String testCoremif = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
				"<mif:staticModelInterfacePackage xmlns:mif=\"urn:hl7-org:v3/mif2\" name=\"CMETinfo\" packageKind=\"name\"" +
				"                                 schemaVersion=\"2.1.3\">" +
				"   <mif:packageLocation root=\"DEFN\" artifact=\"IFC\" realmNamespace=\"CA\" version=\"R02.04.xx\"/>" +
				"   <mif:header>" +
				"      <mif:renderingInformation application=\"v3-generator\"/>" +
				"   </mif:header>" +
				"   <mif:commonModelElementDefinition name=\"A_AnnotationUniversal\" attributionLevel=\"universal\" entryKind=\"Act\">" +
				"      <mif:definingVocabulary>" +
				"         <mif:code code=\"ACT\" codeSystem=\"2.16.840.1.113883.5.6\"/>" +
				"      </mif:definingVocabulary>" +
				"      <mif:annotations>" +
				"         <mif:documentation>" +
				"            <mif:description>" +
				"               <mif:text>Allows notes to be attached to clinical objects</mif:text>" +
				"            </mif:description>" +
				"         </mif:documentation>" +
				"      </mif:annotations>" +
				"      <mif:boundStaticModel root=\"DEFN\" section=\"IM\" subSection=\"CO\" domain=\"CT\" artifact=\"MT\"" +
				"                            realmNamespace=\"CA\"" +
				"                            id=\"120600\"/>" +
				"      <mif:entryClass name=\"Annotation\"/>" +
				"   </mif:commonModelElementDefinition>" +
				"   <mif:commonModelElementDefinition name=\"A_CareEventIdentified\" attributionLevel=\"identified\" entryKind=\"Act\">" +
				"      <mif:definingVocabulary>" +
				"         <mif:code code=\"ACT\" codeSystem=\"2.16.840.1.113883.5.6\"/>" +
				"      </mif:definingVocabulary>" +
				"      <mif:annotations>" +
				"         <mif:documentation>" +
				"            <mif:description>" +
				"               <mif:text>Allows linking health service events to encounters, episodes, etc.</mif:text>" +
				"            </mif:description>" +
				"         </mif:documentation>" +
				"      </mif:annotations>" +
				"      <mif:boundStaticModel root=\"DEFN\" section=\"IM\" subSection=\"CO\" domain=\"CT\" artifact=\"MT\"" +
				"                            realmNamespace=\"CA\"" +
				"                            id=\"011001\"/>" +
				"      <mif:entryClass name=\"PatientCareProvisionEvent\"/>" +
				"   </mif:commonModelElementDefinition>" +
				"</mif:staticModelInterfacePackage>";
		Document mif = new DocumentFactory().createFromString(testCoremif);
		
		fixture.processStaticModel(mif);
		
		ArgumentCaptor<CmetDefinition> argument = ArgumentCaptor.forClass(CmetDefinition.class);
		verify(mifRegistry, times(2)).registerCmet(argument.capture());
		
		List<CmetDefinition> definitions = argument.getAllValues();
		
		CmetDefinition definition1 = definitions.get(0);
		assertNotNull(definition1);
		assertEquals("A_AnnotationUniversal", definition1.getCmetName());
		assertEquals("universal", definition1.getAttributionLevel());
		assertEquals("DEFN=CA=IFC=R02.04.xx", definition1.getDefinitionPackage());
		assertEquals("ACT", definition1.getCode());
		assertEquals("2.16.840.1.113883.5.6", definition1.getCodeSystemOid());
		assertEquals("COCT_MT120600CA.Annotation", definition1.getBoundClass());
		assertEquals(1, definition1.getDocumentation().getAnnotations().size());
		assertEquals("DESCRIPTION", definition1.getDocumentation().getAnnotations().get(0).getAnnotationType());
		assertEquals("<p>Allows notes to be attached to clinical objects</p>", definition1.getDocumentation().getAnnotations().get(0).getText());
		
		CmetDefinition definition2 = definitions.get(1);
		assertNotNull(definition2);
		assertEquals("A_CareEventIdentified", definition2.getCmetName());
		assertEquals("identified", definition2.getAttributionLevel());
		assertEquals("DEFN=CA=IFC=R02.04.xx", definition2.getDefinitionPackage());
		assertEquals("ACT", definition2.getCode());
		assertEquals("2.16.840.1.113883.5.6", definition2.getCodeSystemOid());
		assertEquals("COCT_MT011001CA.PatientCareProvisionEvent", definition2.getBoundClass());
		assertEquals(1, definition2.getDocumentation().getAnnotations().size());
		assertEquals("DESCRIPTION", definition2.getDocumentation().getAnnotations().get(0).getAnnotationType());
		assertEquals("<p>Allows linking health service events to encounters, episodes, etc.</p>", definition2.getDocumentation().getAnnotations().get(0).getText());
	}

	
}
