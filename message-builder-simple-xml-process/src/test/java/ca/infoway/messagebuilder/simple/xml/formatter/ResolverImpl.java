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

package ca.infoway.messagebuilder.simple.xml.formatter;

import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSResourceResolver;

public class ResolverImpl implements LSResourceResolver {

	private final LSResourceResolver resourceResolver;

	public ResolverImpl(LSResourceResolver resourceResolver) {
		this.resourceResolver = resourceResolver;
	}

	public LSInput resolveResource(String type, String namespaceURI, String publicId,
			String systemId, String baseURI) {
		if ("http://www.w3.org/2001/XMLSchema".equals(type) 
				&& "/simpleDataTypes.xsd".equals(systemId)) {
			return new LSInputImpl(systemId);
		} else {
			return this.resourceResolver == null 
					? null 
					: this.resourceResolver.resolveResource(
							type, namespaceURI, publicId, systemId, baseURI);
		}
	}
}
