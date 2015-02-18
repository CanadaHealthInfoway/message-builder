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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
package ca.infoway.messagebuilder.marshalling.hl7.formatter;

import static org.junit.Assert.fail;

import java.util.Map;

import org.junit.Test;

public class FormatterNullValueTest extends FormatterTestCase {

	@Test
	public void testAllFormattersWithNullValue() throws Exception {
		Map<String, PropertyFormatter> formatters = FormatterRegistry.getInstance().getProtectedRegistryMap();
		for (String key : formatters.keySet()) {
			PropertyFormatter formatter = formatters.get(key);
			FormatContext context = getContext("name", key); 
			try {
				formatter.format(context, null);
				formatter.format(context, null, 0);
			} catch (Exception e) {
				fail(key + " (" + formatter.getClass().getSimpleName() + "): formatter failed when given a null value: " + e.getMessage());
			}
		}
		
	}
	
}
