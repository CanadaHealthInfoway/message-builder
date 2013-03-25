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

package ca.infoway.messagebuilder.mifcomparer;

import static ca.infoway.messagebuilder.mifcomparer.Message.Severity.*;
import static ca.infoway.messagebuilder.mifcomparer.Message.MessageType.*;
import static ca.infoway.messagebuilder.mifcomparer.UtilsForTesting.dom2XML;
import static junit.framework.Assert.assertEquals;
import static org.custommonkey.xmlunit.XMLAssert.assertXMLIdentical;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;

import javax.xml.namespace.NamespaceContext;

import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XmlFilterListTest extends XmlFilterImplTest {

	@Test
	public void that_empty_filter_list_does_nothing() throws SAXException, IOException {
		String xml = "<outer><inner/></outer>";

		XmlFilter obj = new XmlFilterList();
		
		performFilterTest(obj, xml, xml, new Message[0]);
	}
	
	@Test
	public void that_filter_list_with_one_filter_applies_the_filter() throws SAXException, IOException {
		XmlFilterList obj = new XmlFilterList();
		obj.add(new XmlNodeDeleteFilter(null, "/outer/inner"));

		performFilterTest(obj,
			"<outer><inner/></outer>",
			"<outer/>",
			new Message[0]);

	}	
	
	@Test
	public void that_filter_list_with_two_filters_applies_them_both() throws SAXException, IOException {
		XmlFilterList obj = new XmlFilterList();
		obj.add(new XmlNodeDeleteFilter(null, "/outer/inner1"));
		obj.add(new XmlNodeDeleteFilter(null, "/outer/inner2"));

		performFilterTest(obj,
			"<outer><inner1/><inner2/></outer>",
			"<outer/>",
			new Message[0]);
	}
	
	@Test
	public void that_filter_list_from_iterable_constructs_all_requested_filters() throws SAXException, IOException {	
		XmlFilterList obj = new XmlFilterList((NamespaceContext)null, Arrays.asList(new String[] {
				"delete /outer/inner2\n",
				"delete /outer/inner1\n"
				}));

		performFilterTest(obj,
			"<outer><inner1/><inner2/></outer>",
			"<outer/>",
			new Message[0]);
	}	

}
