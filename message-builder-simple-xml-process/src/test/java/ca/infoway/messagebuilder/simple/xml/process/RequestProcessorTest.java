/**
 * Copyright 2012 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.simple.xml.process;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Ignore;
import org.junit.Test;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;


public class RequestProcessorTest {
	
	@Test
	@Ignore
	// FIXME - VALIDATION - TM - this test seems broken now; unsure if this is because of validation changes or if it has always been broken (check earlier version)
	public void shouldTransform() throws Exception {
		CodeResolverRegistry.register(new TrivialCodeResolver());
		
		String message = readMessage();
		RequestProcessor processor = new RequestProcessor(SpecificationVersion.R02_04_02);
		String hl7 = processor.process(message);
		
		System.out.println(hl7);
		
	}

	private String readMessage() throws IOException {
		InputStream input = getClass().getResourceAsStream("/findCandidates.xml");
		try {
			return IOUtils.toString(input);
		} finally {
			IOUtils.closeQuietly(input);
		}
	}

}
