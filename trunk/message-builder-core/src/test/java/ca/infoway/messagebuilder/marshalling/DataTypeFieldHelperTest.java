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

package ca.infoway.messagebuilder.marshalling;

import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.jmock.Expectations;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;

import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.impl.ANYImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.junit.JMockMockeryRule;
import ca.infoway.messagebuilder.marshalling.DataTypeFieldHelper.ErrorLogger;
import ca.infoway.messagebuilder.model.MessagePartBean;

/**
 * @sharpen.ignore - test - translated manually.
 */
public class DataTypeFieldHelperTest {
	
    public JMockMockeryRule jmock = new JMockMockeryRule() {{
       setImposteriser(ClassImposteriser.INSTANCE);
    }};
    
	private final ErrorLogger errorLogger = this.jmock.mock(ErrorLogger.class);
	
	@Test
	public void shouldReturnNullAndLogErrorWhenBeanIsNotMessagePartBean() throws Exception {
		final Object bean = new Object();
		
		DataTypeFieldHelper extractor = new DataTypeFieldHelper(bean, "property", this.errorLogger);
		
		this.jmock.checking(new Expectations(){{
			one(DataTypeFieldHelperTest.this.errorLogger).logNotMessagePartBean(with(any(Log.class)), with(equal(bean)));
		}});
		
		assertNull(extractor.get(ANY.class));
	}
	
	@Test
	public void shouldReturnNullAndLogErrorWhenFieldIsNotFound() throws Exception {
		@SuppressWarnings({"serial", "unused"})
		class FooBean extends MessagePartBean {
			private final ANY<Date> field = new ANYImpl<Date>();
		}
		
		final FooBean bean = new FooBean();
		
		DataTypeFieldHelper extractor = new DataTypeFieldHelper(bean, "otherField", this.errorLogger);
		
		this.jmock.checking(new Expectations(){{
			one(DataTypeFieldHelperTest.this.errorLogger).logFieldNotFound(with(any(Log.class)), with(equal(bean)), with(equal("otherField")));
		}});
		
		assertNull(extractor.get(ANY.class));
	}

	@Test
	public void shouldReturnNullAndLogErrorWhenFieldIsNotOfSpecifiedType() throws Exception {
		@SuppressWarnings({"serial", "unused"})
		class FooBean extends MessagePartBean {
			private final CD field = new CDImpl();
		}
		
		final FooBean bean = new FooBean();
		
		DataTypeFieldHelper extractor = new DataTypeFieldHelper(bean, "field", this.errorLogger);
		
		this.jmock.checking(new Expectations(){{
			one(DataTypeFieldHelperTest.this.errorLogger).logInvalidFieldType(with(any(Log.class)), with(equal(bean)), with(equal("field")), with((INT.class)), with(false));
		}});
		
		assertNull(extractor.get(INT.class));
	}
	
	@Test
	public void shouldReturnNullAndLogInfoMessageWhenFieldIsNotOfSpecifiedTypeButIsCollection() throws Exception {
		@SuppressWarnings({"serial", "unused"})
		class FooBean extends MessagePartBean {
			private final List<PN> field = new ArrayList<PN>();
		}
		
		final FooBean bean = new FooBean();
		
		DataTypeFieldHelper extractor = new DataTypeFieldHelper(bean, "field", this.errorLogger);
		
		this.jmock.checking(new Expectations(){{
			one(DataTypeFieldHelperTest.this.errorLogger).logInvalidFieldType(with(any(Log.class)), with(equal(bean)), with(equal("field")), with((PN.class)), with(true));
		}});
		
		assertNull(extractor.get(PN.class));
	}
	
}
