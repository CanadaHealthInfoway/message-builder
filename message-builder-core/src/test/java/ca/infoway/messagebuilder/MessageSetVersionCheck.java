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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
package ca.infoway.messagebuilder;

import static ca.infoway.messagebuilder.xml.service.ManifestMessageDefinitionService.MANIFEST_MBT_MESSAGE_SET_ATTRIBUTE;
import static ca.infoway.messagebuilder.xml.service.ManifestMessageDefinitionService.MANIFEST_MBT_MODEL_VERSION_NUMBERS_ATTRIBUTE;
import static ca.infoway.messagebuilder.xml.service.ManifestMessageDefinitionService.MANIFEST_META_INF_MANIFEST_MF_FILE;

import java.io.File;
import java.io.FileInputStream;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import org.junit.Assert;

import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.MessageSetMarshaller;

/**
 * 
 * @sharpen.ignore - translated manually
 *
 */
public class MessageSetVersionCheck {

	private static final String pathToResourcesDirectory = "./src/main/resources";

	// This is not marked as a test; each HL7v3 release API should have a test which calls this method.
	// This method will fail if the manifest or message set cannot be found. This is intentional.
	public void testVersionMatches() throws Exception {
		File manifestFile = new File(pathToResourcesDirectory + "/" + MANIFEST_META_INF_MANIFEST_MF_FILE);
		Manifest manifest = new Manifest(new FileInputStream(manifestFile));
		Attributes mainAttributes = manifest.getMainAttributes();
		String manifestVersion = mainAttributes.getValue(MANIFEST_MBT_MODEL_VERSION_NUMBERS_ATTRIBUTE);
		String messageSetFileName = mainAttributes.getValue(MANIFEST_MBT_MESSAGE_SET_ATTRIBUTE);
		
		File messageSetFile = new File(pathToResourcesDirectory + messageSetFileName);
		MessageSet messageSet = new MessageSetMarshaller().unmarshall(messageSetFile);
		String messageSetVersion = messageSet.getVersion();

		Assert.assertEquals("Message set version must match manifest version", manifestVersion, messageSetVersion);
	}
	
}
