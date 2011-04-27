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

package ca.infoway.messagebuilder.generator;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.generator.util.Namespace;

public class Namespaces {

	public static final Namespace XSD_NAMESPACE = new Namespace("xs", "http://www.w3.org/2001/XMLSchema");
	public static final Namespace MIF_NAMESPACE = new Namespace("mif", "urn:hl7-org:v3/mif");
	public static final Namespace MIF2_NAMESPACE = new Namespace("mif2", "urn:hl7-org:v3/mif2");
	public static final Namespace HTML_NAMESPACE = new Namespace("html", "http://www.w3.org/1999/xhtml");
	public static final Namespace CHI_NAMESPACE = new Namespace("chi", "urn:ca.infoway.messagebuilder.simplexml.v1");

	public static boolean isMif1(String nameSpace) {
		return StringUtils.equals(MIF_NAMESPACE.getNamespace(), nameSpace);
	}
	
	public static boolean isMif2(String nameSpace) {
		return StringUtils.equals(MIF2_NAMESPACE.getNamespace(), nameSpace);
	}
}
