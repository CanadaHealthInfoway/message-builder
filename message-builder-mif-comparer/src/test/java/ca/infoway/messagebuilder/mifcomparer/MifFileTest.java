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

package ca.infoway.messagebuilder.mifcomparer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class MifFileTest extends TestCase {
	@Test
	public void that_constructor_accepts_a_mif_pathname_with_description() {
		File f = new File("Volume 4 Client Registry/PRPA_IN101001CA - New Person Added Notification.mif");
		MifFile mf = new MifFile(f);
		
		assertNotNull(mf);
		assertEquals(f, mf.getFile());
		assertEquals("PRPA_IN101001CA", mf.getKey());
		assertEquals("New Person Added Notification", mf.getDescription());
	}
	
	@Test
	public void that_constructor_accepts_a_mif_pathname_without_description() {
		File f = new File("Volume 4 Client Registry/PRPA_IN101001CA.mif");
		MifFile mf = new MifFile(f);
		
		assertNotNull(mf);
		assertEquals(f, mf.getFile());
		assertEquals("PRPA_IN101001CA", mf.getKey());
		assertNull(mf.getDescription());
	}
	
	@Test
	public void that_constructor_accepts_an_ON_key() {
		File f = new File("Volume 4 Client Registry/PRPA_IN101001ON - New Person Added Notification.mif");
		MifFile mf = new MifFile(f);
		
		assertNotNull(mf);
		assertEquals(f, mf.getFile());
		assertEquals("PRPA_IN101001ON", mf.getKey());
		assertEquals("New Person Added Notification", mf.getDescription());
	}
	
	@Test
	public void that_constructor_rejects_an_invalid_key() {
		File f = new File("Volume 4 Client Registry/PRPA_IN10001CA - New Person Added Notification.mif");
		
		exception.expect(IllegalArgumentException.class);
		MifFile mf = new MifFile(f);
	}
	
	@Test
	public void that_constructor_rejects_an_invalid_extension() {
		File f = new File("Volume 4 Client Registry/PRPA_IN101001CA - New Person Added Notification.muff");
		
		exception.expect(IllegalArgumentException.class);
		MifFile mf = new MifFile(f);
	}
	
	@Test
	public void that_getPart_functions_work() {
		File f = new File("dir1/dir2/AAAA_BB111111CA - desc.mif");
		MifFile mf = new MifFile(f);
		
		String exp = new File("dir1/dir2").getPath(); // Coerce this into local dir-sep convention
		assertEquals(exp, mf.getDirname());

		assertEquals("AAAA_BB111111CA - desc.mif", mf.getBasename());
		assertEquals("AAAA_BB111111CA", mf.getKey());
		assertEquals("desc", mf.getDescription());
	}

}
