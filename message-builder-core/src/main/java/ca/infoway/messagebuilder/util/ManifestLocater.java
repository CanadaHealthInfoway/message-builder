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
 * Author:        $LastChangedBy: jroberts $
 * Last modified: $LastChangedDate: 2014-11-06 15:40:43 -0500 (Thu, 06 Nov 2014) $
 * Revision:      $LastChangedRevision: 9058 $
 */

package ca.infoway.messagebuilder.util;

import static ca.infoway.messagebuilder.j5goodies.EnumeratedIterable.iterable;
import static ca.infoway.messagebuilder.xml.service.ManifestMessageDefinitionService.MANIFEST_MBT_MODEL_VERSION_NUMBERS_ATTRIBUTE;
import static java.util.Arrays.asList;
import static org.apache.commons.lang.StringUtils.split;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
/**
 * <p>This utility depends on the fact that every jar that contains generated model classes will include a Manifest
 * file that has an attribute, MBT-Model-Version-Numbers, which lists the version
 * numbers that the model classes are valid for.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore platform
 */
public class ManifestLocater {

	public Map<URL, List<String>> getManifestsWithVersionAttribute() {
		Map<URL, List<String>> manifests = new HashMap<URL, List<String>>();
		try {
			Enumeration<URL> resources = getClass().getClassLoader().getResources("META-INF/MANIFEST.MF");
			for (URL url : iterable(resources)) {
				InputStream input = url.openStream();
				try {
					Manifest manifest = new Manifest(input);
					Attributes attributes = manifest.getMainAttributes();
					String versionNumbers = attributes.getValue(MANIFEST_MBT_MODEL_VERSION_NUMBERS_ATTRIBUTE);
					if (StringUtils.isNotBlank(versionNumbers)) {
						manifests.put(url, asList(split(versionNumbers)));
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
