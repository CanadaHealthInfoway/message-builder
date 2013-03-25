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

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringReader;

import org.junit.Test;

public class GlobalConfigurationTest {

	@Test
	public void that_can_construct_with_empty_input() throws IOException {
		StringReader input = new StringReader("");
		
		GlobalConfiguration obj = new GlobalConfiguration(input);

		assertEquals("# of namespace mappings", 0, obj.namespaceContext.getMap().size());
		assertEquals("# of filters", 0, obj.xmlFilters.getFilters().size());
	}

	@Test
	public void that_can_construct_with_namespace_and_filter() throws IOException {
		StringReader input = new StringReader(
				"[Filters]\n" +
				"filter = delete /a/b\n" +
				"\n" +
				"[Namespaces]\n" +
				"x = http://www.example.com/ns/x\n" +
				"");
		
		GlobalConfiguration obj = new GlobalConfiguration(input);
		
		assertEquals("# of namespace mappings", 1, obj.namespaceContext.getMap().size());
		assertEquals("# of filters", 1, obj.xmlFilters.getFilters().size());
	}
	
	@Test
	public void that_can_empty_Filters_section_doesnt_throw_NPE() throws IOException {
		StringReader input = new StringReader(
				"[Filters]\n" +
				"[Namespaces]\n" +
				"x = http://www.example.com/ns/x\n" +
				"");
		
		GlobalConfiguration obj = new GlobalConfiguration(input);
		
		assertEquals("# of namespace mappings", 1, obj.namespaceContext.getMap().size());
		assertEquals("# of filters", 0, obj.xmlFilters.getFilters().size());
	}	
	
	@Test
	public void that_can_empty_Namespaces_section_doesnt_throw_NPE() throws IOException {
		StringReader input = new StringReader(
				"[Filters]\n" +
				"filter = delete /a/b\n" +
				"\n" +
				"[Namespaces]\n" +
				"");
		
		GlobalConfiguration obj = new GlobalConfiguration(input);
		
		assertEquals("# of namespace mappings", 0, obj.namespaceContext.getMap().size());
		assertEquals("# of filters", 1, obj.xmlFilters.getFilters().size());
	}
}
