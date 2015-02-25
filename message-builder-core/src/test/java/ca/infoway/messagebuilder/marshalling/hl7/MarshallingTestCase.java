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

package ca.infoway.messagebuilder.marshalling.hl7;

import static ca.infoway.messagebuilder.marshalling.WhitespaceUtil.normalizeWhitespace;
import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.configurator.DefaultCodeResolutionConfigurator;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

public abstract class MarshallingTestCase {
	
	protected static final String FULL_DATE_TIME = "yyyy-MM-dd'T'HH:mm:ss";
	protected static final String FULL_DATE = "yyyy-MM-dd";
	protected XmlToModelResult xmlResult;
	
	@Before
	public void setUp() throws Exception {
		DefaultCodeResolutionConfigurator.configureCodeResolversWithTrivialDefault();
		this.xmlResult = new XmlToModelResult();
	}
	
	@After
	public void tearDown() throws Exception {
		CodeResolverRegistry.unregisterAll();
	}

	protected Node createNode(String string) throws SAXException {
		return new DocumentFactory().createFromString(string).getDocumentElement();
	}
	
	protected void assertXml(String description, String expected, String actual) {
		assertXml(description, expected, actual, true);
	}
	
	protected void assertXml(String description, String expected, String actual, boolean skipFirstComment) {
		if (skipFirstComment && actual.contains("<!--")) {
			String first = StringUtils.substringBefore(actual, "<!--");
			String rest = StringUtils.substringAfter(StringUtils.substringAfter(actual, "<!--"), "-->");
			actual = first + rest;
		}
		assertEquals(description, normalizeWhitespace(expected, true), normalizeWhitespace(actual, true));
	}
	
	protected void assertDateEquals(String description, String pattern, Date expected, Date actual) {
		Assert.assertNotNull(description + " not null", actual);
		DateFormat format = DateUtil.instance(pattern);
		assertEquals(description, format.format(expected), format.format(actual));
	}
}
