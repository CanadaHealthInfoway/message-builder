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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

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

public abstract class XmlFilterImplTest extends XmlFilterTest {
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void that_newInstance_handles_delete() throws SAXException, IOException {
		XmlFilter obj = XmlFilterImpl.newInstance(null, "delete /outer/inner2");
		
		performFilterTest(obj,
			"<outer><inner1/><inner2/></outer>",
			"<outer><inner1/></outer>",
			new Message[0]);
		
	}
	
	@Test
	public void that_newInstance_handles_resequence() throws SAXException, IOException {
		XmlFilter obj = XmlFilterImpl.newInstance(null, "resequence k /outer/inner");
		
		performFilterTest(obj,
				"<outer><inner k='7' v='y'/><inner k='5' v='x'/></outer>",
				"<outer><inner k='1' v='x'/><inner k='2' v='y'/></outer>",
			new Message[0]);
		
	}		

	@Test
	public void that_newInstance_handles_unknown_filter_name() throws SAXException, IOException {
		exception.expect(FatalConditionException.class);
		exception.expectMessage("Unknown XmlFilter type: \"no-such-filter\"");
		XmlFilter obj = XmlFilterImpl.newInstance(null, "no-such-filter /outer/inner");
	}

	@Test
	public void that_newInstance_handles_unknown_class_name() throws Exception {
		exception.expect(RuntimeException.class);
		exception.expectMessage("Can't instantiate filter class \"NonExistentClassName\" for filter \"the filter defn\"");
		XmlFilter obj = XmlFilterImpl.instantiate("the filter defn", "NonExistentClassName", (NamespaceContext)null, new String[0]);
	}
	
	@Test
	public void that_tokenize_tokenizes_on_whitespace() {
		String input = "this  is    a    test";
		String[] exp = { "this", "is", "a", "test" };
		
		List<String> act = XmlFilterImpl.tokenize(input);
		
		assertEquals(exp, act.toArray(new String[0]));
	}	
	
	@Test
	public void that_tokenize_ignores_leading_whitespace() {
		String input = "   this  is    a    test";
		String[] exp = { "this", "is", "a", "test" };
		
		List<String> act = XmlFilterImpl.tokenize(input);
		
		assertEquals(exp, act.toArray(new String[0]));
	}	
	
	@Test
	public void that_tokenize_ignores_trailing_whitespace() {
		String input = "this  is    a    test  ";
		String[] exp = { "this", "is", "a", "test" };
		
		List<String> act = XmlFilterImpl.tokenize(input);
		
		assertEquals(exp, act.toArray(new String[0]));
	}	
	
	@Test
	public void that_tokenize_treats_dquoted_string_as_one_token() {
		String input = "this  is    \" a b  c \"    test  ";
		String[] exp = { "this", "is", " a b  c ", "test" };
		
		List<String> act = XmlFilterImpl.tokenize(input);
		
		assertEquals(exp, act.toArray(new String[0]));
	}	
	
	@Test
	public void that_tokenize_treats_squoted_string_as_one_token() {
		String input = "this  is    ' a b  c '    test  ";
		String[] exp = { "this", "is", " a b  c ", "test" };
		
		List<String> act = XmlFilterImpl.tokenize(input);
		
		assertEquals(exp, act.toArray(new String[0]));
	}
}
