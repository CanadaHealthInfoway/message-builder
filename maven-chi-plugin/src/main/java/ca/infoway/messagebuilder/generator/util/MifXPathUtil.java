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

package ca.infoway.messagebuilder.generator.util;
import static ca.infoway.messagebuilder.generator.util.Namespaces.isMif1;

import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Document;


/**
 * <p>A utility to make XPath operations easier.
 * 
 */
public class MifXPathUtil {
    
	public static String getMifVersion(Document document) throws XPathExpressionException {
		String mifVersion = null;
		String namespace = getMifNamespace(document);
		String version = new XPathHelper().getAttributeValue(document, "/mif2:staticModel/@schemaVersion", Namespaces.MIF2_NAMESPACE);
		if (isMif1(namespace)) {
			mifVersion = "1.x";
		} else {
			mifVersion = version;
		}
		return mifVersion;
	}
	
	public static String getMifNamespace(Document document) {
		return document.getDocumentElement().getNamespaceURI();
	}
	
}