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

package ca.infoway.messagebuilder.terminology.proxy;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.Test;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.AcknowledgementDetailType;
import ca.infoway.messagebuilder.domainvalue.ActIssuePriority;


public class TypedCodeFactoryTest {

	@Test
	public void shouldProduceResultThatImplementsAllInterfaces() throws Exception {
		
		Code code = new TypedCodeFactory().create(AcknowledgementDetailType.class, 
				new HashSet<Class<?>>(Arrays.asList(
						AcknowledgementDetailType.class, ActIssuePriority.class)),
				"E", CodeSystem.VOCABULARY_ACKNOWLEDGEMENT_DETAIL_TYPE.getRoot(), 
				new HashMap<String,String>(), 0, true, true);
		
		assertTrue("AcknowledgementDetailType", code instanceof AcknowledgementDetailType);
		assertTrue("ActIssuePriority", code instanceof ActIssuePriority);
	}
}
