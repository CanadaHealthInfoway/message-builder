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

package ca.infoway.messagebuilder.generator.multiplemessageset;

import java.util.Collections;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.Interaction;

@RunWith(JMock.class)
public class InteractionMergerTest {

	private MergeContext mergeContext;
	private DocumentationMerger documentationMerger;
	private ArgumentMerger argumentMerger;
	private InteractionMerger merger;
	
	private final Mockery jmock = new JUnit4Mockery() {{
		setImposteriser(ClassImposteriser.INSTANCE);
	}};


	@Before
	public void setup() {
		this.mergeContext = this.jmock.mock(MergeContext.class);
		this.jmock.checking(new Expectations() {{
			allowing(mergeContext).getPrimaryVersion(); will(returnValue("1"));
			allowing(mergeContext).getSecondaryVersion(); will(returnValue("2"));
			allowing(mergeContext).getCurrentInteraction(); will(returnValue("currentInteraction"));
			allowing(mergeContext).getCurrentPackageLocation(); will(returnValue("currentpackageLocation"));
			allowing(mergeContext).getCurrentMessagePart(); will(returnValue("currentMessagePart"));
		}});
		
		this.documentationMerger = this.jmock.mock(DocumentationMerger.class);
		this.argumentMerger = this.jmock.mock(ArgumentMerger.class);
		this.merger = new InteractionMerger(this.mergeContext, this.documentationMerger, this.argumentMerger);
	}

	@Test
	public void shouldHandleEmptyInteractions() {
		this.jmock.checking(new Expectations() {{
			one(documentationMerger).merge(null, null); will(returnValue(null));
		}});

		Interaction result = this.merger.merge(null, null);
		Assert.assertNull(result.getName());
		
		Interaction primaryInteraction = new Interaction();
		Interaction secondaryInteraction = new Interaction();
		
		this.jmock.checking(new Expectations() {{
			one(documentationMerger).merge(null, null); will(returnValue(null));
			one(argumentMerger).merge(Collections.<Argument>emptyList(), Collections.<Argument>emptyList());
		}});

		result = this.merger.merge(primaryInteraction, secondaryInteraction);
		Assert.assertNull(result.getName());
		Assert.assertNotSame(result, primaryInteraction);
		Assert.assertNotSame(result, secondaryInteraction);
	}
	
	@Test
	public void shouldHandleSingleNullInteraction() {
		final Interaction interaction = new Interaction();
		interaction.setName("myName");
		interaction.setBusinessName("myBusinessName");
		interaction.setCategory("myCategory");
		interaction.setSuperTypeName("mySuperTypeName");
		interaction.setDocumentation(new Documentation());
		
		this.jmock.checking(new Expectations() {{
			one(documentationMerger).merge(interaction.getDocumentation(), null); will(returnValue(interaction.getDocumentation()));
			one(mergeContext).logInfo(with(any(String.class)));
		}});

		Interaction result = this.merger.merge(interaction, null);
		Assert.assertNotSame(interaction, result);
		Assert.assertEquals(interaction.getName(), result.getName());
		Assert.assertEquals(interaction.getBusinessName(), result.getBusinessName());
		Assert.assertEquals(interaction.getCategory(), result.getCategory());
		Assert.assertEquals(interaction.getSuperTypeName(), result.getSuperTypeName());
		Assert.assertEquals(interaction.getDocumentation(), result.getDocumentation());
		
		this.jmock.checking(new Expectations() {{
			one(documentationMerger).merge(null, interaction.getDocumentation()); will(returnValue(interaction.getDocumentation()));
			one(mergeContext).logInfo(with(any(String.class)));
		}});

		result = this.merger.merge(null, interaction);
		Assert.assertNotSame(interaction, result);
		Assert.assertEquals(interaction.getName(), result.getName());
		Assert.assertEquals(interaction.getBusinessName(), result.getBusinessName());
		Assert.assertEquals(interaction.getCategory(), result.getCategory());
		Assert.assertEquals(interaction.getSuperTypeName(), result.getSuperTypeName());
		Assert.assertEquals(interaction.getDocumentation(), result.getDocumentation());
	}
	
	@Test
	public void shouldMergeInteractions() {
		final Interaction interaction1 = new Interaction();
		interaction1.setName("myName1");
		interaction1.setBusinessName("myBusinessName1");
		interaction1.setCategory("myCategory1");
		interaction1.setSuperTypeName("mySuperTypeNameSAME");
		interaction1.setDocumentation(new Documentation());
		
		final Interaction interaction2 = new Interaction();
		interaction2.setName("myName2");
		interaction2.setBusinessName("myBusinessName2");
		interaction2.setCategory("myCategory2");
		interaction2.setSuperTypeName("mySuperTypeNameSAME");
		interaction2.setDocumentation(new Documentation());
		
		this.jmock.checking(new Expectations() {{
			one(documentationMerger).merge(interaction1.getDocumentation(), interaction2.getDocumentation()); will(returnValue(interaction1.getDocumentation()));
			one(argumentMerger).merge(Collections.<Argument>emptyList(), Collections.<Argument>emptyList());
		}});

		Interaction result = this.merger.merge(interaction1, interaction2);
		Assert.assertNotSame(interaction1, result);
		Assert.assertNotSame(interaction2, result);
		Assert.assertEquals(interaction1.getName(), result.getName());
		Assert.assertEquals(interaction1.getBusinessName(), result.getBusinessName());
		Assert.assertEquals(interaction1.getCategory(), result.getCategory());
		Assert.assertEquals(interaction1.getSuperTypeName(), result.getSuperTypeName());
		Assert.assertEquals(interaction1.getDocumentation(), result.getDocumentation());
		
		this.jmock.checking(new Expectations() {{
			one(documentationMerger).merge(interaction2.getDocumentation(), interaction1.getDocumentation()); will(returnValue(interaction2.getDocumentation()));
			one(argumentMerger).merge(Collections.<Argument>emptyList(), Collections.<Argument>emptyList());
		}});

		result = this.merger.merge(interaction2, interaction1);
		Assert.assertNotSame(interaction2, result);
		Assert.assertNotSame(interaction1, result);
		Assert.assertEquals(interaction2.getName(), result.getName());
		Assert.assertEquals(interaction2.getBusinessName(), result.getBusinessName());
		Assert.assertEquals(interaction2.getCategory(), result.getCategory());
		Assert.assertEquals(interaction2.getSuperTypeName(), result.getSuperTypeName());
		Assert.assertEquals(interaction2.getDocumentation(), result.getDocumentation());
		
	}
}
