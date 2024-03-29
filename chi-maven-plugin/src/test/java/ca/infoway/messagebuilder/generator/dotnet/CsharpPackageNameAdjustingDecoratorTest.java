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

package ca.infoway.messagebuilder.generator.dotnet;

import static org.junit.Assert.assertEquals;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.generator.lang.NameTranslator;
import ca.infoway.messagebuilder.xml.TypeName;


@RunWith(JMock.class)
public class CsharpPackageNameAdjustingDecoratorTest {

	private Mockery jmock = new Mockery();
	
	@Test
	public void shouldCapitalizePackageName() throws Exception {
		
		final NameTranslator translator = this.jmock.mock(NameTranslator.class);
		this.jmock.checking(new Expectations() {{
			allowing(translator).getPackageName(with(any(TypeName.class))); will(returnValue("ca.infoway.messagebuilder.something"));
		}});
		
		CsharpPackageNameAdjustingDecorator fixture = new CsharpPackageNameAdjustingDecorator(translator);
		assertEquals("package name", "Ca.Infoway.Messagebuilder.Something", fixture.getPackageName(new TypeName("")));
	}
	
}
