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

package ca.infoway.messagebuilder.simple.xml.formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementDetailCode;
import ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementDetailType;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.AcknowledgementBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.ErrorsOrWarningsBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.SenderBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.repc_mt230001ca.AuthorBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.interaction.FindCandidatesQueryBean;


public class MessagePartWrapperTest {
	
	@Test
	public void shouldWriteSimpleCase() throws Exception {
		AcknowledgementBean bean = new AcknowledgementBean();
		MessagePartWrapper wrapper = new MessagePartWrapper(bean);
		wrapper.setField("targetMessageId", toList(new IIImpl(new Identifier("1.2.3"))));
		assertEquals("target message id", new Identifier("1.2.3"), bean.getTargetMessageId());
	}

	@Test
	public void shouldGetFieldNamesFromSuperTypes() throws Exception {
		FindCandidatesQueryBean bean = new FindCandidatesQueryBean();
		MessagePartWrapper wrapper = new MessagePartWrapper(bean);
		List<String> fieldNames = wrapper.getFieldNames();
		System.out.println(fieldNames);
		assertTrue("names", fieldNames.contains("id"));
	}

	@Test
	public void shouldUseBusinessNames() throws Exception {
		SenderBean bean = new SenderBean();
		MessagePartWrapper wrapper = new MessagePartWrapper(bean);
		List<String> fieldNames = wrapper.getFieldNames();
		System.out.println(fieldNames);
		assertTrue("names", fieldNames.contains("telecom"));
	}
	
	@Test
	@Ignore
	public void shouldRecognizeChoices() throws Exception {
		AuthorBean bean = new AuthorBean();
		MessagePartWrapper wrapper = new MessagePartWrapper(bean);
		List<String> fieldNames = wrapper.getFieldNames();
		System.out.println(fieldNames);
		assertTrue("names", fieldNames.containsAll(Arrays.asList("nullAuthorRole", "healthcareWorker")));
	}
	
	@Test
	public void shouldWriteSimpleList() throws Exception {
		ErrorsOrWarningsBean bean = new ErrorsOrWarningsBean();
		MessagePartWrapper wrapper = new MessagePartWrapper(bean);
		wrapper.setField("location", toList(new STImpl("location1"), new STImpl("location2")));
		assertEquals("location", 2, bean.getLocation().size());
		
		assertEquals("location 1", "location1", bean.getLocation().iterator().next());
	}
	
	@Test
	public void shouldWriteMessagePartList() throws Exception {
		AcknowledgementBean bean = new AcknowledgementBean();
		List<Object> details = new ArrayList<Object>();
		details.add(createErrorsOrWarningsBean(AcknowledgementDetailType.ERROR, AcknowledgementDetailCode.INTERNAL_SYSTEM_ERROR, "I hate you"));
		details.add(createErrorsOrWarningsBean(AcknowledgementDetailType.ERROR, AcknowledgementDetailCode.INTERNAL_SYSTEM_ERROR, "And your little dog, too"));
		MessagePartWrapper wrapper = new MessagePartWrapper(bean);
		wrapper.setField("acknowledgementDetail", details);
		assertEquals("details", 2, bean.getAcknowledgementDetail().size());
	}
	
	private ErrorsOrWarningsBean createErrorsOrWarningsBean(AcknowledgementDetailType error, AcknowledgementDetailCode internalSystemError, String text) {
		ErrorsOrWarningsBean bean = new ErrorsOrWarningsBean();
		bean.setText(text);
		bean.setTypeCode(error);
		bean.setCode(internalSystemError);
		return bean;
	}

	private List<Object> toList(Object... value) {
		return Arrays.asList(value);
	}

}
