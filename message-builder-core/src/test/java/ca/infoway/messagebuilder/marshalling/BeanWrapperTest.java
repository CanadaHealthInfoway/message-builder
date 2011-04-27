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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.Relationship;


public class BeanWrapperTest {

	@Test
	public void shouldWriteSimpleAttribute() throws Exception {
		BeanB beanB = new BeanB();
		BeanWrapper wrapper = new BeanWrapper(beanB);
		wrapper.write(new Relationship("text", "ST", Cardinality.create("0-1")), "This is my text");
		assertEquals("text", "This is my text", beanB.getText());
	}
	
	@Test
	public void shouldWriteSimpleAssociation() throws Exception {
		BeanB beanB = new BeanB();
		BeanC beanC = new BeanC();
		BeanWrapper wrapper = new BeanWrapper(beanC);
		wrapper.write(new Relationship("textHolder", "ABCD_IN123456CA.BeanB", Cardinality.create("0-1")), beanB);
		assertNotNull("bean b", beanC.getBeanB());
	}
	
	@Test
	public void shouldWriteMultipleCardinalityAttribute() throws Exception {
		BeanBPrime beanB = new BeanBPrime();
		BeanWrapper wrapper = new BeanWrapper(beanB);
		wrapper.write(new Relationship("text", "ST", Cardinality.create("0-10")), "This is my text");
		assertEquals("text", "This is my text", beanB.getText().get(0));
	}
	
	@Test
	public void shouldWriteNullFlavorOnCollapsedAssociation() throws Exception {
		BeanCPrime beanC = new BeanCPrime();
		BeanWrapper wrapper = new BeanWrapper(beanC);
		wrapper.writeNullFlavor(null, new Relationship("component2", "ABCD_IN123456CA.BeanB", Cardinality.create("0-1")), NullFlavor.NO_INFORMATION);
		assertNull("bean", beanC.getBeanB());
		//assertNull("bean", beanC.getBeanB().getText());
	}
	
}
