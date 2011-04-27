/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.marshalling;

import java.util.Arrays;
import java.util.List;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.TypeName;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionService;

/**
 * @sharpen.ignore - test - translated manually.
 */
@RunWith(JMock.class)
public class PathBuilderTest {

	private static final String VERSION = SpecificationVersion.R02_04_02.getVersionLiteral();
	
	private Mockery jmock = new Mockery();
	private MessageDefinitionService mockService;
	private PathBuilder pathBuilder;

	@Before
	public void setUp() throws Exception {
		this.mockService = this.jmock.mock(MessageDefinitionService.class);
		this.pathBuilder = new PathBuilder(this.mockService, VERSION);
	}
	
	@Test(expected=IllegalStateException.class)
	public void shouldFailWithBadStartType() {
		this.pathBuilder.findPathTo(null, new TypeName("PRPA_MT101103CA.ParameterList"));
	}
	
	@Test(expected=IllegalStateException.class)
	public void shouldFailWithBadStartTypeName() {
		this.pathBuilder.findPathTo(new TypeName(null), new TypeName("PRPA_MT101103CA.ParameterList"));
	}
	
	@Test(expected=IllegalStateException.class)
	public void shouldFailWithBadEndType() {
		this.pathBuilder.findPathTo(new TypeName("PRPA_MT101103CA.ParameterList"), null);
	}
	
	@Test(expected=IllegalStateException.class)
	public void shouldFailWithBadEndTypeName() {
		this.pathBuilder.findPathTo(new TypeName("PRPA_MT101103CA.ParameterList"), new TypeName(null));
	}
	
	@Test
	public void shouldHandleIdenticalTypes() {
		TypeName typeName = new TypeName("PRPA_MT101103CA.ParameterList");
		List<TypeName> results = this.pathBuilder.findPathTo(typeName, new TypeName("PRPA_MT101103CA.ParameterList"));
		Assert.assertFalse(results.isEmpty());
		Assert.assertEquals(1, results.size());
		Assert.assertEquals(typeName, results.get(0));
	}
	
	@Test
	public void shouldHandleSameType() {
		TypeName typeName = new TypeName("PRPA_MT101103CA.ParameterList");
		List<TypeName> results = this.pathBuilder.findPathTo(typeName, typeName);
		Assert.assertFalse(results.isEmpty());
		Assert.assertEquals(1, results.size());
		Assert.assertEquals(typeName, results.get(0));
	}
	
	@Test
	public void shouldHandleSimpleTypePath() {
		String endType = "PRPA_MT101103CA.AssignedEntity";
		TypeName endTypeName = new TypeName(endType);
		createPartWithChilds(endType, false);
		
		String startType = "PRPA_MT101103CA.Author";
		TypeName startTypeName = new TypeName(startType);
		createPartWithChilds(startType, true, endType);
		
		List<TypeName> results = this.pathBuilder.findPathTo(startTypeName, endTypeName);
		Assert.assertFalse(results.isEmpty());
		Assert.assertEquals(2, results.size());
		Assert.assertEquals(startTypeName, results.get(0));
		Assert.assertEquals(endTypeName, results.get(1));
	}
	
	@Test
	public void shouldHandleComplexTypePath() {
		//A (start) 
		// -> B
		// -> C -> E        -> G,H
		//      -> F* (end) -> I*,J*
		// -> D*
		//
		// * = won't be looked up via service
		// result path will be A, C, F
		
		String gType = "PRPA_MT101103CA.BeanG";
		createPartWithChilds(gType, true);

		String hType = "PRPA_MT101103CA.BeanH";
		createPartWithChilds(hType, true);

		String iType = "PRPA_MT101103CA.BeanI";
		createPartWithChilds(iType, false);

		String jType = "PRPA_MT101103CA.BeanJ";
		createPartWithChilds(jType, false);

		String eType = "PRPA_MT101103CA.BeanE";
		createPartWithChilds(eType, true, gType, hType);

		String fType = "PRPA_MT101103CA.BeanF";
		TypeName fTypeName = new TypeName(fType);
		createPartWithChilds(fType, false, iType, jType);
		
		String bType = "PRPA_MT101103CA.BeanB";
		createPartWithChilds(bType, true);

		String cType = "PRPA_MT101103CA.BeanC";
		TypeName cTypeName = new TypeName(cType);
		createPartWithChilds(cType, true, eType, fType);

		String dType = "PRPA_MT101103CA.BeanD";
		createPartWithChilds(dType, false);

		String aType = "PRPA_MT101103CA.BeanA";
		TypeName aTypeName = new TypeName(aType);
		createPartWithChilds(aType, true, bType, cType, dType);
		
		List<TypeName> results = this.pathBuilder.findPathTo(aTypeName, fTypeName);
		Assert.assertFalse(results.isEmpty());
		Assert.assertEquals(3, results.size());
		Assert.assertEquals(aTypeName, results.get(0));
		Assert.assertEquals(cTypeName, results.get(1));
		Assert.assertEquals(fTypeName, results.get(2));
	}
	
	private MessagePart createPartWithChilds(final String type, boolean expectServiceCall, String... childs) {
		final MessagePart part = new MessagePart(type);
		part.setSpecializationChilds(Arrays.asList(childs));
		
		if (expectServiceCall) {
			this.jmock.checking(new Expectations() {{
				one(mockService).getMessagePart(VERSION, type); 
					will(returnValue(part));
			}});
		}
		
		return part;
	}
}
