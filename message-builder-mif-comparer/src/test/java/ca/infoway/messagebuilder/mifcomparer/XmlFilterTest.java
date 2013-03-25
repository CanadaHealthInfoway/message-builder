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

import static ca.infoway.messagebuilder.mifcomparer.UtilsForTesting.*;
import static org.custommonkey.xmlunit.XMLAssert.*;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.NamespaceContext;

import org.custommonkey.xmlunit.DetailedDiff;
import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public abstract class XmlFilterTest {
	/**
	 * Maps prefix "x" to "http://www.example.com/ns/x", and similarly "y" and "z".
	 * This is available for those tests that want it; it is <b>not</b> used unless the individual test explicitly does so.
	 */
	MapBasedNamespaceContext testNsContext;
	
	@Before
	public void saveXmlunitState() {
		XmlunitState.save();
	}
	
	@After
	public void restoreXmlunitState() {
		XmlunitState.restore();
	}
	
	@Before
	public void createTestNsContext() {
			Map<String,String> map = new HashMap<String,String>();

			map.put("x", "http://www.example.com/ns/x");
			map.put("y", "http://www.example.com/ns/y");
			map.put("z", "http://www.example.com/ns/z");

			testNsContext = new MapBasedNamespaceContext(map);
	}

	public void performFilterTest(XmlFilter filter, String inXML, String expXML, Message[] expMsgs) throws SAXException, IOException {
		XMLUnit.setIgnoreWhitespace(this.getIgnoreWhitespace());
		
		Document domToTransform = xml2DOM(inXML);
		Document expDOM = xml2DOM(expXML);
		MessageList msgs = new MessageList();
		System.out.println(String.format("Input:%n%s%n", dom2XML(domToTransform)));
		
		// Action
		filter.apply(new File("the-file"), domToTransform, msgs);
		
		// Test
		System.out.println(String.format("Actual:%n%s%n", dom2XML(domToTransform)));
		System.out.println(String.format("Expected:%n%s%n", dom2XML(expDOM)));
		
		Diff d = new Diff(expDOM, domToTransform);
		
		assertXMLIdentical("Transformed DOM: " + d.toString(), d, true);

		String expMsgStrings = messagesToSortedString(expMsgs);
		String actMsgStrings = messagesToSortedString(msgs.getMessages());
		
		assertEquals(expMsgStrings, actMsgStrings);
	}
	
	/**
	 * Determine whether XMLUnit should ignore whitespace (as if by a call to {@code XMLUnit.setIgnoreWhitespace(true)).
	 * This superclass method provides the default, {@code true}, but subclasses can override it.
	 * 
	 * @return {@code true} iff XMLUnit should ignore whitespace
	 */
	boolean getIgnoreWhitespace() {
		return true;
	}
}
