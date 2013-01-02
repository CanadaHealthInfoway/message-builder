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
 * Author:        $LastChangedBy: gng $
 * Last modified: $LastChangedDate: 2012-09-12 12:46:14 -0400 (Wed, 12 Sep 2012) $
 * Revision:      $LastChangedRevision: 6076 $
 */

package ca.infoway.messagebuilder.generator;

import java.util.Comparator;

import org.w3c.dom.Element;

public class AssociationComparator implements Comparator<Element> {

	private final boolean isMifv2;

	public AssociationComparator(boolean isMifv2) {
		this.isMifv2 = isMifv2;
	}
	
	public int compare(Element arg0, Element arg1) {
		Element targetConnection0 = (this.isMifv2 ? Mif2XPathHelper.getTraversableConnection(arg0) : MifXPathHelper.getTargetConnection(arg0));
		Element targetConnection1 = (this.isMifv2 ? Mif2XPathHelper.getTraversableConnection(arg1) : MifXPathHelper.getTargetConnection(arg1));
		
		String sortKey0 = targetConnection0.getAttribute("sortKey");
		String sortKey1 = targetConnection1.getAttribute("sortKey");
		
		String name0 = targetConnection0.getAttribute("name");
		String name1 = targetConnection1.getAttribute("name");
		
		int sortKeyResult = sortKey0.compareTo(sortKey1);
		
		return sortKeyResult != 0 ? sortKeyResult : name0.compareTo(name1);
	}

}
