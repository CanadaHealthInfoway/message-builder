/**
 * Copyright 2012 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.simple.xml;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSResourceResolver;

public class SimpleXmlSchemaResolver implements LSResourceResolver {

	public LSInput resolveResource(String type, String namespaceURI, String publicId,
			String systemId, String baseURI) {
		
		if ("http://www.w3.org/2001/XMLSchema".equals(type) 
				&& StringUtils.endsWith(systemId, "/simpleDataTypes.xsd")) {
			return new LSInputImpl("/simpleDataTypes.xsd");
		} else if ("http://www.w3.org/2001/XMLSchema".equals(type)) {
			return new LSInputImpl(systemId, "/ca/infoway/messagebuilder/model/" + systemId);
		} else {
			return null;
		}
	}
}
