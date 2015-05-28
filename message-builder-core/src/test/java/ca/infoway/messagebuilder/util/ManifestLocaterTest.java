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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
package ca.infoway.messagebuilder.util;

import static org.junit.Assert.assertEquals;

import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import ca.infoway.messagebuilder.marshalling.MockVersionNumber;

/**
 * @sharpen.ignore - due to difference in method signature on .NET side
 */
public class ManifestLocaterTest {

	@Test
	public void testLoadVersions() {
		Map<URL, List<String>> manifestsWithVersionAttribute = new ManifestLocater().getManifestsWithVersionAttribute();
		assertEquals(1, manifestsWithVersionAttribute.keySet().size());
		Iterator<URL> iterator = manifestsWithVersionAttribute.keySet().iterator();
		URL url = iterator.next();
		List<String> versions = manifestsWithVersionAttribute.get(url);
		assertEquals(1, versions.size());
		assertEquals(MockVersionNumber.MOCK_MR2009.getVersionLiteral(), versions.get(0));
	}

}
