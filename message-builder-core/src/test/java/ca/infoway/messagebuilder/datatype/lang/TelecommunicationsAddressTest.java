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

package ca.infoway.messagebuilder.datatype.lang;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

import ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse;
import ca.infoway.messagebuilder.domainvalue.basic.URLScheme;

/**
 * @sharpen.ignore - datatype - translated manually
 */
public class TelecommunicationsAddressTest {

	@Test
    public void testAddressUseOrdering() throws Exception {
        TelecommunicationAddress address = new TelecommunicationAddress();
        address.addAddressUse(TelecommunicationAddressUse.WORKPLACE);
        address.addAddressUse(TelecommunicationAddressUse.EMERGENCY_CONTACT);
        address.addAddressUse(TelecommunicationAddressUse.ANSWERING_MACHINE);
        address.addAddressUse(TelecommunicationAddressUse.DIRECT);
        
        Iterator<ca.infoway.messagebuilder.domainvalue.TelecommunicationAddressUse> i = address.getAddressUses().iterator();
        assertEquals(i.next().getCodeValue(), TelecommunicationAddressUse.ANSWERING_MACHINE.getCodeValue());
        assertEquals(i.next().getCodeValue(), TelecommunicationAddressUse.DIRECT.getCodeValue());
        assertEquals(i.next().getCodeValue(), TelecommunicationAddressUse.EMERGENCY_CONTACT.getCodeValue());
        assertEquals(i.next().getCodeValue(), TelecommunicationAddressUse.WORKPLACE.getCodeValue());
    }
    
	@Test
    public void testToString() throws Exception {
        assertToStringAsExpected(null, null, "");
        assertToStringAsExpected(null, "monkey", "monkey");

        assertToStringAsExpected(URLScheme.MAILTO, null, "mailto:");
        assertToStringAsExpected(URLScheme.MAILTO, "address@host", "mailto:address@host");

        assertToStringAsExpected(URLScheme.FAX, null, "fax:");
        assertToStringAsExpected(URLScheme.FAX, "1234", "fax:1234");

        assertToStringAsExpected(URLScheme.FILE, null, "file://");
        assertToStringAsExpected(URLScheme.FILE, "c:/monkey", "file://c:/monkey");

        assertToStringAsExpected(URLScheme.FTP, null, "ftp://");
        assertToStringAsExpected(URLScheme.FTP, "somehost", "ftp://somehost");

        assertToStringAsExpected(URLScheme.HTTP, null, "http://");
        assertToStringAsExpected(URLScheme.HTTP, "somehost", "http://somehost");

        assertToStringAsExpected(URLScheme.HTTPS, null, "https://");
        assertToStringAsExpected(URLScheme.HTTPS, "somehost", "https://somehost");

        assertToStringAsExpected(URLScheme.NFS, null, "nfs://");
        assertToStringAsExpected(URLScheme.NFS, "somehost", "nfs://somehost");

        assertToStringAsExpected(URLScheme.TEL, null, "tel:");
        assertToStringAsExpected(URLScheme.TEL, "1234", "tel:1234");
    }

    public void assertToStringAsExpected(
    		ca.infoway.messagebuilder.domainvalue.URLScheme urlScheme, String address, String expectedValue) throws Exception {
        TelecommunicationAddress telecommunicationAddress = new TelecommunicationAddress();
        telecommunicationAddress.setUrlScheme(urlScheme);
        telecommunicationAddress.setAddress(address);
        assertEquals("value", expectedValue, telecommunicationAddress.toString());
    }
}
