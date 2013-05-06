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

package ca.infoway.messagebuilder.mifcomparer.xmlunit;

import static ca.infoway.messagebuilder.mifcomparer.UtilsForTesting.stringList2SortedString;
import static ca.infoway.messagebuilder.mifcomparer.UtilsForTesting.xml2DOM;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.custommonkey.xmlunit.Difference;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XmlunitAdapterTest {
	private static final String NEWLINE = System.getProperty("line.separator");

	@Test
	public void compare_identical_xml() throws SAXException, IOException {
		String xml1 = "<outer><inner1/></outer>";
		String xml2 = "<outer><inner1/></outer>";
		String[] expDiffs = {
		};

		performTest(xml1, xml2, true, true, expDiffs);
	}


	@Test
	public void compare_similar_xml() throws SAXException, IOException {
		String xml1 = "<outer><inner1/><inner2/></outer>";
		String xml2 = "<outer><inner2/><inner1/></outer>";
		String[] expDiffs = {
			"Expected sequence of child nodes '0' but was '1' - comparing <inner1...> at /outer[1]/inner1[1] to <inner1...> at /outer[1]/inner1[1]" + NEWLINE,
			"Expected sequence of child nodes '1' but was '0' - comparing <inner2...> at /outer[1]/inner2[1] to <inner2...> at /outer[1]/inner2[1]" + NEWLINE,
		};

		performTest(xml1, xml2, false, true, expDiffs);
	}

	@Test
	public void compare_with_one_difference() throws SAXException, IOException {
		String xml1 = "<outer>left text</outer>";
		String xml2 = "<outer>right text</outer>";
		String[] expDiffs = {
			"Expected text value 'left text' but was 'right text' - comparing <outer ...>left text</outer> at /outer[1]/text()[1] to <outer ...>right text</outer> at /outer[1]/text()[1]" + NEWLINE,
		};
		
		performTest(xml1, xml2, false, false, expDiffs);
	}

	@Test
	public void compare_with_three_differences() throws SAXException, IOException {
		String xml1 = "<outer><inner1left/><inner2 attr='leftval'/>left text</outer>";
		String xml2 = "<outer><inner1right/><inner2 attr='rightval'/>right text</outer>";
		String[] expDiffs = {
			"Expected presence of child node 'inner1left' but was 'null' - comparing <inner1left...> at /outer[1]/inner1left[1] to  at null" + NEWLINE,
			"Expected presence of child node 'null' but was 'inner1right' - comparing  at null to <inner1right...> at /outer[1]/inner1right[1]" + NEWLINE,
			"Expected attribute value 'leftval' but was 'rightval' - comparing <inner2 attr=\"leftval\"...> at /outer[1]/inner2[1]/@attr to <inner2 attr=\"rightval\"...> at /outer[1]/inner2[1]/@attr" + NEWLINE,
			"Expected text value 'left text' but was 'right text' - comparing <outer ...>left text</outer> at /outer[1]/text()[1] to <outer ...>right text</outer> at /outer[1]/text()[1]" + NEWLINE,
		};
		
		performTest(xml1, xml2, false, false, expDiffs);
	}
	
	
	// Utility methods

	private void performTest(String xml1, String xml2, boolean expIsIdentical, boolean expIsSimilar, String[] expDiffs) throws SAXException, IOException {
		Document dom1 = xml2DOM(xml1);
		Document dom2 = xml2DOM(xml2);

		XmlunitAdapter obj = new XmlunitAdapter();
		XmlunitResult result = obj.compare(dom1, dom2);

		assertEquals("isIdentical", expIsIdentical, result.isIdentical());
		assertEquals("isSimilar", expIsSimilar, result.isSimilar());
		assertEqualsUnordered(Arrays.asList(expDiffs), result.getDifferences());
	}
	
	private void assertEqualsUnordered(List<String> expStrs, List<Difference> actDiffs) {
		String expStr = stringList2SortedString(expStrs);
		String actStr = differenceList2SortedString(actDiffs);
		
		assertEquals(expStr, actStr);
	}
	
	private String differenceList2SortedString(List<Difference> diffs) {
		List<String> strList = new LinkedList<String>();
		
		for (Difference d : diffs) {
			strList.add(d.toString() + NEWLINE);
		}
	
		return stringList2SortedString(strList);
	}

}
