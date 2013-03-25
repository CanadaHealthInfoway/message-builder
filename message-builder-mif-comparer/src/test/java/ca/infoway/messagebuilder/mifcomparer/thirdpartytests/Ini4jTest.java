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

package ca.infoway.messagebuilder.mifcomparer.thirdpartytests;

import static org.junit.Assert.*;
import static ca.infoway.messagebuilder.mifcomparer.Assert.*;

import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

import org.ini4j.Config;
import org.ini4j.Ini;
import org.ini4j.InvalidFileFormatException;
import org.ini4j.Profile.Section;
import org.junit.Test;

public class Ini4jTest {

	@Test
	public void that_constructor_with_Reader_does_not_require_load_call() throws InvalidFileFormatException, IOException {
		String input =
				"[section1]\n" +
				"foo = bar\n";
		
		Ini obj = new Ini(new StringReader(input));
		String value = obj.get("section1", "foo");
		
		assertEquals("bar", value);
	}

	@Test
	public void that_get_on_multi_value_returns_one_of_the_values_as_String() throws InvalidFileFormatException, IOException {
		String input =
				"[section1]\n" +
				"foo = bar\n" +
				"foo = baz\n" +
				"";
		
		Ini obj = new Ini(new StringReader(input));
		String value = obj.get("section1", "foo");
		
		// Not sure whether there's any order guarantee, so don't overspecify what we expect
		assertTrue("expecting \"bar\" or \"baz\", but got \"" + value + "\"",  value.equals("bar") || value.equals("baz")); 
	}
	

	@Test
	public void that_getAll_on_multi_value_returns_all_values_as_List() throws InvalidFileFormatException, IOException {
		String input =
				"[section1]\n" +
				"foo = bar\n" +
				"foo = baz\n";
		List<String> expValues = Arrays.asList(new String[] {"bar", "baz"});
		
		Ini obj = new Ini(new StringReader(input));
		Section s1 = obj.get("section1");
		List<String> actValues = s1.getAll("foo");
		
		assertEqualsUnordered(expValues, actValues);
	}
}
