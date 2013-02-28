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

package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static ca.infoway.messagebuilder.marshalling.WhitespaceUtil.normalizeWhitespace;
import static org.apache.commons.lang.SystemUtils.LINE_SEPARATOR;
import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.junit.After;
import org.junit.Before;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.marshalling.hl7.CeRxDomainTestValues;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.configurator.DefaultCodeResolutionConfigurator;

public abstract class FormatterTestCase {
	
	@Before
	public void setup() {
		DefaultCodeResolutionConfigurator.configureCodeResolversWithTrivialDefault();
	}
	
	@After
	public void tearDown() {
		CodeResolverRegistry.unregisterAll();
	}
	
	protected ModelToXmlResult result = new ModelToXmlResult();

	protected void assertXml(String description, String expected, String actual) {
		if (actual.contains("<!--")) {
			String first = StringUtils.substringBefore(actual, "<!--");
			String rest = StringUtils.substringAfter(StringUtils.substringAfter(actual, "<!--"), "-->");
			actual = first + rest;
		}
		assertEquals(description, normalizeWhitespace(expected), normalizeWhitespace(actual));
	}

	protected Date parseDate(String date) throws ParseException {
		return DateUtils.parseDate(date, new String[] {"yyyy-MM-dd", "yyyy-MM-dd'T'HH:mm:ss"});
	}

	protected FormatContext getContext(String name) {
		return getContext(name, null);
	}

	protected FormatContext getContext(String name, String type) {
		return getContext(name, type, SpecificationVersion.R02_04_03);
	}

	protected FormatContext getContext(String name, String type, VersionNumber version) {
		return new FormatContextImpl(this.result, null, name, type, null, false, version, null, null, null);
	}

    protected final Set<Code> makeSet(Code... codes) {
    	// leave TreeSet fully qualified for translation purposes 
        return new TreeSet<Code>(Arrays.asList(codes));
    }

	protected final Set<String> makeSet(String... strings) {
    	// leave TreeSet fully qualified for translation purposes 
		return new TreeSet<String>(Arrays.asList(strings));
	}

	protected final Set<TelecommunicationAddress> makeTelecommunicationAddressSet(String... strings) {
		Set<TelecommunicationAddress> result = new HashSet<TelecommunicationAddress>();
		for (String s : strings) {
			TelecommunicationAddress address = new TelecommunicationAddress();
			address.setAddress(s);
			address.setUrlScheme(CeRxDomainTestValues.MAILTO);
			result.add(address);
		}
		return result;
	}

	protected String addLineSeparator(String value) {
		return value + LINE_SEPARATOR;
	}

	protected String removeErrorComments(String result) {
		return result.replaceAll("<!--(.*?)-->" + LINE_SEPARATOR, "");
	}
	
}
