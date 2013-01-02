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

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.junit.Test;

public class MifToXmlGeneratorTest {

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
	
	@Test
	public void shouldFindFirstMif() throws Exception {
		MifToXmlGenerator generator = new MifToXmlGenerator(null, "someVersion", null, null);
		List<MifReference> list = new ArrayList<MifReference>();
		list.add(new MifReferenceImpl(new File("sldjf.dmif")));
		list.add(new MifReferenceImpl(new File("sldjf2.dmif")));
		list.add(new MifReferenceImpl(new File("blorf.mif")));
		list.add(new MifReferenceImpl(new File("hubbahubba.mif")));
		MifReference mifFile = generator.getFirstMifFile(list);
		assertEquals("extension", "mif", FilenameUtils.getExtension(mifFile.asFile().getName()));
		assertEquals("name", "blorf.mif", mifFile.asFile().getName());
	}
}
