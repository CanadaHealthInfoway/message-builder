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

package ca.infoway.messagebuilder.model.newfoundland;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;

public class MessagePartBeanTest {
	
	private Bean bean;

	@SuppressWarnings("serial")
	class BaseBean extends MessagePartBean {
		private final II identifierInBase = new IIImpl();
		
		public Identifier getIdInBase() {
			return this.identifierInBase.getValue();
		}
	}
	
	@SuppressWarnings("serial")
	class Bean extends BaseBean {
		private final II identifier = new IIImpl();
		private final LIST<II, Identifier> ids = new LISTImpl<II, Identifier>(IIImpl.class);
		
		public List<Identifier> getIds() {
			return this.ids.rawList();
		}
		public II getIdentifier() {
			return this.identifier;
		}
	}

	@Before
	public void setUp() {
		bean = new Bean();
	}

	@Test
	public void getAsHl7DataTypeShouldRetrieveCorrectHl7DataTypeWhenInSuperClass() throws Exception {
		assertNotNull(bean.getField("identifierInBase"));
	}

	@Test
	public void getAsHl7DataTypeShouldRetrieveCorrectHl7DataType() throws Exception {
		assertNotNull(bean.getField("identifier"));
	}

	@Test
	public void getAsHl7DataTypeShouldHandleLISTCorrectly() throws Exception {
		bean.getIds().add(new Identifier("root", "extension"));
		assertNotNull(bean.getField("ids[0]"));
	}

	@Test
	public void getAsHl7DataTypeShouldReturnNullAnyWhenPropertyIsNotFound() throws Exception {
		Object field = bean.getField("invisible");
		assertNull(field);
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void getAsHl7DataTypeShouldHandleListIndexOutOfBounds() throws Exception {
		bean.getIds().add(new Identifier("root", "extension"));
		assertNull(bean.getField("ids[1]"));
	}

}

