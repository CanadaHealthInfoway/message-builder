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

package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage.C_SHARP;
import static org.junit.Assert.assertEquals;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.generator.DataType;
import ca.infoway.messagebuilder.generator.TypeConverter;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.Relationship;

@RunWith(JMock.class)
public class PropertyTypeProvidersTest {
	
	private Mockery jmock = new Mockery();
	private ClassNameManager manager;
	
	@Before
	public void setUp() throws Exception {
		this.manager = this.jmock.mock(ClassNameManager.class);
	}
	
	@Test
	public void shouldUseCsharpConstructs() throws Exception {
		
		this.jmock.checking(new Expectations() {{
			allowing(manager).getRepresentationOfClassName("System.String"); will(returnValue("String"));
		}});
		
		Relationship relationship = new Relationship("text", "ST", Cardinality.create("1"));
		DataType dataType = new TypeConverter().convertToType(relationship);
		
		Attribute attribute = new Attribute(relationship, dataType);
		PropertyTypeProviders.Attribute provider = new PropertyTypeProviders.Attribute(attribute, C_SHARP);
		
		assertEquals("type", "String", provider.getType(this.manager));
	}
}
