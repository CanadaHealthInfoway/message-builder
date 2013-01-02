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

package ca.infoway.messagebuilder.acceptance.runner.datatype;

import java.util.ArrayList;
import java.util.List;

import ca.infoway.messagebuilder.acceptance.runner.AcceptanceTestResultCallback;
import ca.infoway.messagebuilder.acceptance.runner.AcceptanceTestRunner;
import ca.infoway.messagebuilder.marshalling.hl7.formatter.FormatterRegistry;
import ca.infoway.messagebuilder.marshalling.hl7.parser.ParserRegistry;

public class DataTypeAcceptanceTestRunner implements AcceptanceTestRunner {
	
	private final String name;
	
	private final ParserRegistry parserRegistry = ParserRegistry.getInstance();
	private final FormatterRegistry formatterRegistry = FormatterRegistry.getInstance();

	private final List<String> chiDataTypes;
	
	public DataTypeAcceptanceTestRunner(String name, List<String> chiDataTypes) {
		this.name = name;
		this.chiDataTypes = chiDataTypes;
	}

	public void run(AcceptanceTestResultCallback resultCallback) {
		List<String> messages = new ArrayList<String>();
		int supportedCount = 0;
		for (String dataType : this.chiDataTypes) {
			if (dataTypeFullySupported(dataType)) {
				supportedCount++;
			} else {
				messages.add("Data type " + dataType + " not supported.");
			}
		}
		
		resultCallback.done(
				this.name, 
				supportedCount,
				chiDataTypes.size(),
				messages);
	}

	private boolean dataTypeFullySupported(String dataType) {
		return parserRegistry.get(dataType) != null && formatterRegistry.get(dataType) != null;
	}

}
