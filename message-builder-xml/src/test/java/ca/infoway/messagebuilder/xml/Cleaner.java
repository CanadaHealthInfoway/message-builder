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

package ca.infoway.messagebuilder.xml;

import java.io.File;

public class Cleaner {
	
	public static void main(String[] args) throws Exception {
		
//		File file = new File("../message-builder-hl7v3-release-pcs_mr2007_v02_r02/src/main/resources/messageSet_v02_r02.xml");
//		File file = new File("../message-builder-hl7v3-release-pcs_cerx_v01_r04_3/src/main/resources/messageSet_v01r04_3.xml");
//		File file = new File("../message-builder-release-newfoundland/src/main/resources/messageSet_NEWFOUNDLAND.xml");
//		File file = new File("../message-builder-hl7v3-release-pcs_mr2009_r02_04_02/src/main/resources/messageSet_r02_04_02.xml");
		File file = new File("../message-builder-xml-validation/src/test/resources/ca/infoway/messagebuilder/xml/validator/messageSet_v02r02.xml");
		MessageSetMarshaller marshaller = new MessageSetMarshaller();
		MessageSet messageSet = marshaller.unmarshall(file);
		
		marshaller.marshall(messageSet, file);
		
	}

}
