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

package ca.infoway.messagebuilder.dependencyanalyzer;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

import ca.infoway.messagebuilder.dependencyanalyzer.Describer;

public class DescriberTest {

	@Test
	public void testShouldSupportString() throws Exception {
		String string = "This is a string";
		assertEquals("string", string, new Describer().getDescription(string));
	}

	@Test
	public void testShouldSupportFile() throws Exception {
		File file = new File("/temp");
		assertEquals("file", "temp", new Describer().getDescription(file));
	}


}
