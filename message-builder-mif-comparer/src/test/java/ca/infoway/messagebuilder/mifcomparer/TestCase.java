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

import static org.junit.Assert.assertEquals;
import static ca.infoway.messagebuilder.mifcomparer.Assert.*;


import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class TestCase {

	protected String[] expMsgs = {};
	protected MessageList actMsgs = new MessageList();

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@After
	public void checkMessages() {
		List<String> actMsgStrings = new LinkedList<String>();
		
		for (Message m : actMsgs.getMessages()) {
			actMsgStrings.add(m.asText());
		}
		
		assertEqualsUnordered(Arrays.asList(expMsgs), actMsgStrings);
	}

	public TestCase() {
		super();
	}

	/**
	 * Get a resource as a File object
	 */
	protected File getResourceAsFile(String resourceName) {
		URL url = this.getClass().getClassLoader().getResource(resourceName);
		if (url == null) {
			throw new RuntimeException(resourceName + ": Can't find resource");
		}
	
		if (!url.getProtocol().equals("file")) {
			throw new RuntimeException(url + ": Not a file: URL");
		}
	
		URI uri;
		try {
			uri = url.toURI();
		} catch (URISyntaxException e) {
			throw new RuntimeException("Resource \"" + resourceName
					+ "\": Can't convert URL \"" + url + "\" to a URI", e);
		}
	
		return new File(uri);
	}

	@Test
	public void test_that_getResourceAsFile_finds_an_existing_directory() {
		File act = getResourceAsFile("tiny-mif-dir");
	
		assertEquals("tiny-mif-dir", act.getName());
	}

}
