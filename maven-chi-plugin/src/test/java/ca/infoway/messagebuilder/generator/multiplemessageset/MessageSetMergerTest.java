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

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;

@RunWith(JMock.class)
public class MessageSetMergerTest {

	private final Mockery jmock = new JUnit4Mockery() {{
		setImposteriser(ClassImposteriser.INSTANCE);
	}};

	private MergeContext mergeContext;
	private MessageSetMerger merger;
	private PackageLocationMerger packageLocationMerger; 
	private InteractionMerger interactionMerger;
	
	@Before
	public void setUp() {
		this.mergeContext = this.jmock.mock(MergeContext.class);
		this.jmock.checking(new Expectations() {{
			allowing(mergeContext).getPrimaryVersion(); will(returnValue("1"));
			allowing(mergeContext).getSecondaryVersion(); will(returnValue("2"));
			allowing(mergeContext).setCurrentInteraction("intKey");
			allowing(mergeContext).setCurrentInteraction("");
			allowing(mergeContext).setCurrentMessagePart("");
			allowing(mergeContext).setCurrentPackageLocation("plKey");
		}});
		
		this.packageLocationMerger = this.jmock.mock(PackageLocationMerger.class);
		this.interactionMerger = this.jmock.mock(InteractionMerger.class);
		this.merger = new MessageSetMerger(this.mergeContext, this.packageLocationMerger, this.interactionMerger);
		
	}
	
	@Test
	public void shouldHandleEmptyMessageSets() {
		MessageSet resultMessageSet = this.merger.merge(null, null);
		Assert.assertNull(resultMessageSet);
		
		resultMessageSet = this.merger.merge(new MessageSet(), new MessageSet());
		Assert.assertTrue(resultMessageSet.getPackageLocations().isEmpty());
		Assert.assertTrue(resultMessageSet.getInteractions().isEmpty());
		Assert.assertNull(resultMessageSet.getVersion());
	}
	
	@Test
	public void shouldMergeMessageSetWithOnePrimaryNullSecondary() {
		MessageSet messageSet = new MessageSet();
		
		final PackageLocation plValue = new PackageLocation();
		String plKey = "plKey";
		messageSet.getPackageLocations().put(plKey, plValue);
		
		final Interaction intValue = new Interaction();
		String intKey = "intKey";
		messageSet.getInteractions().put(intKey, intValue);
		
		String component = "myComponent";
		messageSet.setComponent(component);
		
		MessageSet resultMessageSet = this.merger.merge(messageSet, null);
		Assert.assertEquals(1, resultMessageSet.getPackageLocations().size());
		Assert.assertEquals(plValue, resultMessageSet.getPackageLocations().get(plKey));
		Assert.assertEquals(1, resultMessageSet.getInteractions().size());
		Assert.assertEquals(intValue, resultMessageSet.getInteractions().get(intKey));
		Assert.assertEquals(component, resultMessageSet.getComponent());
	}
	
	@Test
	public void shouldMergeMessageSetWithNullPrimaryOneSecondary() {
		MessageSet messageSet = new MessageSet();
		
		final PackageLocation plValue = new PackageLocation();
		String plKey = "plKey";
		messageSet.getPackageLocations().put(plKey, plValue);
		
		final Interaction intValue = new Interaction();
		String intKey = "intKey";
		messageSet.getInteractions().put(intKey, intValue);
		
		String component = "myComponent";
		messageSet.setComponent(component);
		
		MessageSet resultMessageSet = this.merger.merge(null, messageSet);
		Assert.assertEquals(1, resultMessageSet.getPackageLocations().size());
		Assert.assertEquals(plValue, resultMessageSet.getPackageLocations().get(plKey));
		Assert.assertEquals(1, resultMessageSet.getInteractions().size());
		Assert.assertEquals(intValue, resultMessageSet.getInteractions().get(intKey));
		Assert.assertEquals(component, resultMessageSet.getComponent());
	}
	
	@Test
	public void shouldMergeMessageSetsWithEachHavingUniqueValues() {
		
		MessageSet messageSet1 = new MessageSet();
		
		final PackageLocation plValue1 = new PackageLocation();
		String plKey1 = "plKey1";
		messageSet1.getPackageLocations().put(plKey1, plValue1);
		
		final Interaction intValue1 = new Interaction();
		String intKey1 = "intKey1";
		messageSet1.getInteractions().put(intKey1, intValue1);
		
		String component1 = "myComponent1";
		messageSet1.setComponent(component1);
		
		MessageSet messageSet2 = new MessageSet();
		
		final PackageLocation plValue2 = new PackageLocation();
		String plKey2 = "plKey2";
		messageSet2.getPackageLocations().put(plKey2, plValue2);
		
		final Interaction intValue2 = new Interaction();
		String intKey2 = "intKey2";
		messageSet2.getInteractions().put(intKey2, intValue2);
		
		String component2 = "myComponent2";
		messageSet2.setComponent(component2);
		
		this.jmock.checking(new Expectations() {{
			one(mergeContext).setCurrentInteraction("intKey1");
			one(mergeContext).setCurrentPackageLocation("plKey1");
			one(mergeContext).setCurrentInteraction("intKey2");
			one(mergeContext).setCurrentPackageLocation("plKey2");

			one(interactionMerger).merge(intValue1, null); will(returnValue(intValue1));
			one(packageLocationMerger).merge(plValue1, null); will(returnValue(plValue1));
			
			one(interactionMerger).merge(null, intValue2); will(returnValue(intValue2));
			one(packageLocationMerger).merge(null, plValue2); will(returnValue(plValue2));
		}});

		MessageSet resultMessageSet = this.merger.merge(messageSet1, messageSet2);
		Assert.assertEquals(2, resultMessageSet.getPackageLocations().size());
		Assert.assertTrue(resultMessageSet.getPackageLocations().containsKey(plKey1));
		Assert.assertTrue(resultMessageSet.getPackageLocations().containsKey(plKey2));
		Assert.assertTrue(resultMessageSet.getPackageLocations().containsValue(plValue1));
		Assert.assertTrue(resultMessageSet.getPackageLocations().containsValue(plValue2));
		Assert.assertEquals(2, resultMessageSet.getInteractions().size());
		Assert.assertTrue(resultMessageSet.getInteractions().containsKey(intKey1));
		Assert.assertTrue(resultMessageSet.getInteractions().containsKey(intKey2));
		Assert.assertTrue(resultMessageSet.getInteractions().containsValue(intValue1));
		Assert.assertTrue(resultMessageSet.getInteractions().containsValue(intValue2));
		Assert.assertEquals(component1, resultMessageSet.getComponent());
	}
	
	@Test
	public void shouldMergeMessageSetsWithEachHavingSame() {
		MessageSet messageSet1 = new MessageSet();
		
		final PackageLocation plValue1 = new PackageLocation();
		String plKey1 = "plKey";
		messageSet1.getPackageLocations().put(plKey1, plValue1);
		
		final Interaction intValue1 = new Interaction();
		String intKey1 = "intKey";
		messageSet1.getInteractions().put(intKey1, intValue1);
		
		String component1 = "myComponent1";
		messageSet1.setComponent(component1);
		
		MessageSet messageSet2 = new MessageSet();
		
		final PackageLocation plValue2 = new PackageLocation();
		String plKey2 = "plKey";
		messageSet2.getPackageLocations().put(plKey2, plValue2);
		
		final Interaction intValue2 = new Interaction();
		String intKey2 = "intKey";
		messageSet2.getInteractions().put(intKey2, intValue2);
		
		String component2 = "myComponent2";
		messageSet2.setComponent(component2);
		
		this.jmock.checking(new Expectations() {{
			one(interactionMerger).merge(intValue1, intValue2); will(returnValue(intValue1));
			one(packageLocationMerger).merge(plValue1, plValue2); will(returnValue(plValue1));
		}});

		MessageSet resultMessageSet = this.merger.merge(messageSet1, messageSet2);
		Assert.assertEquals(1, resultMessageSet.getPackageLocations().size());
		Assert.assertTrue(resultMessageSet.getPackageLocations().containsKey(plKey1));
		Assert.assertTrue(resultMessageSet.getPackageLocations().containsValue(plValue1));
		Assert.assertEquals(1, resultMessageSet.getInteractions().size());
		Assert.assertTrue(resultMessageSet.getInteractions().containsKey(intKey1));
		Assert.assertTrue(resultMessageSet.getInteractions().containsValue(intValue1));
		Assert.assertEquals(component1, resultMessageSet.getComponent());
	}
}
