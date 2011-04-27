/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.simple.xml.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddressUse;
import ca.infoway.messagebuilder.datatype.lang.URLScheme;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

public class TelecomAddressXmlParserTest extends AbstractXmlParserTest<TEL> {
	
	public TelecomAddressXmlParserTest() {
		super(new TelecomAddressXmlParser(), "primaryContact", new TELImpl());
	}
	
	@Test
	public void shouldParseTelUri() throws Exception {
		assertEquals(
				"<primaryContact value=\"https://www.i-proving.ca\"/>",
				this.parser.parse(
						createContext(), createTel(
								new TelecommunicationAddress(URLScheme.HTTPS, "www.i-proving.ca"), 
								StandardDataType.TEL_URI)));
	}

	@Test
	public void shouldParseTelEmail() throws Exception {
		assertEquals(
				"<primaryContact>" +
					"<use>H</use><use>WP</use><mailto>dev@intware.org</mailto>" +
				"</primaryContact>",
				this.parser.parse(
						createContext(), createTel(
								new TelecommunicationAddress(URLScheme.MAILTO, "dev@intware.org", TelecommunicationAddressUse.HOME, TelecommunicationAddressUse.WORKPLACE), 
								StandardDataType.TEL_EMAIL)));
	}
	
	@Test
	public void shouldParseTelPhone() throws Exception {
		assertEquals(
				"<primaryContact type=\"FAX\">" +
					"<use>AS</use><use>H</use><use>WP</use><areaCode>416</areaCode><phoneNumber>7620032</phoneNumber><extension>4321</extension>" +
				"</primaryContact>",
				this.parser.parse(
						createContext(), createTel(
								new TelecommunicationAddress(
										URLScheme.FAX, 
										"+1-416-762-0032 x 4321", 
										TelecommunicationAddressUse.HOME, TelecommunicationAddressUse.WORKPLACE, TelecommunicationAddressUse.ANSWERING_MACHINE), 
								StandardDataType.TEL_PHONE)));
	}

	private TEL createTel(TelecommunicationAddress telecommunicationAddress, StandardDataType dataType) {
		TELImpl tel = new TELImpl(telecommunicationAddress);
		tel.setDataType(dataType);
		return tel;
	}

	@Override
	protected TEL createAnyWithNullFlavor(NullFlavor nullFlavor) {
		return new TELImpl(nullFlavor);
	}

}
