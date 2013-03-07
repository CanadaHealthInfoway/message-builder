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

package ca.infoway.messagebuilder.xml.service;

import static java.util.Arrays.asList;
import static org.apache.commons.lang.StringUtils.split;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.j5goodies.EnumeratedIterable;

/**
 * @sharpen.ignore - xml.service - translated manually
 */
public class ManifestMessageDefinitionService extends BaseMessageDefinitionService {

	public static final String MANIFEST_META_INF_MANIFEST_MF_FILE = "META-INF/MANIFEST.MF";
	public static final String MANIFEST_MBT_MESSAGE_SET_ATTRIBUTE = "MBT-Message-Set";
	public static final String MANIFEST_MBT_MODEL_VERSION_NUMBERS_ATTRIBUTE = "MBT-Model-Version-Numbers";

	@Override
	protected List<String> getNames() {
		return getResourceNamesFromManifests();
	}

	private List<String> getResourceNamesFromManifests() {
		List<String> manifests = new ArrayList<String>();
		try {
			Enumeration<URL> resources = getClass().getClassLoader().getResources(MANIFEST_META_INF_MANIFEST_MF_FILE);
			for (URL url : EnumeratedIterable.iterable(resources)) {
				InputStream input = url.openStream();
				try {
					Manifest manifest = new Manifest(input);
					Attributes attributes = manifest.getMainAttributes();
					String messageSets = attributes.getValue(MANIFEST_MBT_MESSAGE_SET_ATTRIBUTE);
					if (StringUtils.isNotBlank(messageSets)) {
						manifests.addAll(asList(split(messageSets)));
					}
				} finally {
					IOUtils.closeQuietly(input);
				}
			}
		} catch (IOException e) {
			// quietly swallow the error
		}
		return manifests;
	}
}
