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
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.generator.lang;

import static ca.infoway.messagebuilder.generator.util.ProgrammingLanguage.C_SHARP;
import static ca.infoway.messagebuilder.generator.util.ProgrammingLanguage.JAVA;
import static org.junit.Assert.assertEquals;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.xml.TypeName;

@RunWith(JMock.class)
public class SimpleNameTranslatorTest {

	private Mockery jmock = new JUnit4Mockery();
	private NameCoordinator nameCoordinator = this.jmock.mock(NameCoordinator.class);
	private SimpleNameTranslator javaTranslator;
	private TypeName typeName;
	private TypeName interactionName;
	private TypeNameHelper helper;
	private SimpleNameTranslator csharpTranslator;

	@Before
	public void setup() {
		this.helper = this.jmock.mock(TypeNameHelper.class);
		this.jmock.checking(new Expectations() {{
			allowing(helper).getTypes();
		}});
		this.javaTranslator = new SimpleNameTranslator(JAVA, "ca.infoway.test", this.helper, this.nameCoordinator);
		this.csharpTranslator = new SimpleNameTranslator(C_SHARP, "ca.infoway.test", this.helper, this.nameCoordinator);
		this.typeName = new TypeName("ABCD_MT123456CA.Purple");
		this.interactionName = new TypeName("ABCD_IN123456CA");
	}
	
	@Test
	public void shouldGetPackageName() throws Exception {
		assertEquals("ca.infoway.test.abcd_mt123456ca", this.javaTranslator.getPackageName(this.typeName));
	}
	
	@Test
	public void shouldGetPackageNameOfInteraction() throws Exception {
		assertEquals("ca.infoway.test.interaction", this.javaTranslator.getPackageName(this.interactionName));
	}
	
	@Test
	public void shouldGetClassNameWithoutPackage() throws Exception {
		this.jmock.checking(new Expectations() {{
			allowing(helper).isAbstract(typeName); will(returnValue(false));
			one(nameCoordinator).getName(typeName); will(returnValue("BarneyAndFriends"));
		}});
		
		assertEquals("BarneyAndFriendsBean", this.javaTranslator.getClassNameWithoutPackage(this.typeName));
	}
	
	@Test
	public void shouldGetCsharpClassNameWithoutPackage() throws Exception {
		this.jmock.checking(new Expectations() {{
			allowing(helper).isAbstract(typeName); will(returnValue(false));
			one(nameCoordinator).getName(typeName); will(returnValue("BarneyAndFriends"));
		}});
		
		assertEquals("BarneyAndFriends", this.csharpTranslator.getClassNameWithoutPackage(this.typeName));
	}
	
	@Test
	public void shouldGetCsharpInterfaceNameWithoutPackage() throws Exception {
		this.jmock.checking(new Expectations() {{
			allowing(helper).isAbstract(typeName); will(returnValue(true));
			one(nameCoordinator).getName(typeName); will(returnValue("BarneyAndFriends"));
		}});
		
		assertEquals("IBarneyAndFriends", this.csharpTranslator.getClassNameWithoutPackage(this.typeName));
	}
	
	
	@Test
	public void shouldGetFullyQualifiedClassName() throws Exception {
		this.jmock.checking(new Expectations() {{
			allowing(helper).isAbstract(typeName); will(returnValue(false));
			one(nameCoordinator).getName(typeName); will(returnValue("BarneyAndFriends"));
		}});
		
		assertEquals("ca.infoway.test.abcd_mt123456ca.BarneyAndFriendsBean", this.javaTranslator.getFullyQualifiedClassName(this.typeName));
	}
	
}
