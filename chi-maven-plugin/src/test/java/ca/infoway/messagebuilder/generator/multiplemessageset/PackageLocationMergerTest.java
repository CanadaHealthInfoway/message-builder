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

import ca.infoway.messagebuilder.xml.DifferenceType;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.PackageLocation;

@RunWith(JMock.class)
public class PackageLocationMergerTest {

	private MessagePartMerger messagePartMerger;
	private PackageLocationMerger merger;
	private MergeContext mergeContext;
	
	private final Mockery jmock = new JUnit4Mockery() {{
		setImposteriser(ClassImposteriser.INSTANCE);
	}};

	@Before
	public void setup() {
		this.mergeContext = this.jmock.mock(MergeContext.class);
		this.jmock.checking(new Expectations() {{
			allowing(mergeContext).getPrimaryVersion(); will(returnValue("1"));
			allowing(mergeContext).getSecondaryVersion(); will(returnValue("2"));
			allowing(mergeContext).setCurrentMessagePart(with(any(String.class)));
			allowing(mergeContext).getCurrentInteraction(); will(returnValue(""));
			allowing(mergeContext).getCurrentMessagePart(); will(returnValue(""));
			allowing(mergeContext).getCurrentPackageLocation(); will(returnValue("aPackageLocation"));
			allowing(mergeContext).logInfo(with(any(String.class)));
		}});
		
		this.messagePartMerger = this.jmock.mock(MessagePartMerger.class);
		this.merger = new PackageLocationMerger(this.mergeContext, this.messagePartMerger);
	}

	@Test
	public void shouldHandleEmptyPackageLocations() {
		PackageLocation result = this.merger.merge(null, null);
		Assert.assertNull(result);
		
		result = this.merger.merge(new PackageLocation(), new PackageLocation());
		Assert.assertNotNull(result);
		Assert.assertNull(result.getName());
	}
	
	@Test
	public void shouldHandleSinglePackageLocation() {
		PackageLocation packageLocation = new PackageLocation();
		packageLocation.setCategory("myCategory");
		packageLocation.setDescriptiveName("myDescName");
		packageLocation.setName("myName");
		packageLocation.setRootType("myRootType");
		
		final MessagePart messagePart = new MessagePart();
		packageLocation.getMessageParts().put("type", messagePart);
		
		this.jmock.checking(new Expectations() {{
			one(messagePartMerger).merge(messagePart, null); will(returnValue(messagePart));
		}});
		
		PackageLocation result = this.merger.merge(packageLocation, new PackageLocation());
		Assert.assertEquals(packageLocation.getCategory(), result.getCategory());
		Assert.assertEquals(packageLocation.getDescriptiveName(), result.getDescriptiveName());
		Assert.assertEquals(packageLocation.getName(), result.getName());
		Assert.assertEquals(packageLocation.getRootType(), result.getRootType());
		
		result = this.merger.merge(packageLocation, null);
		Assert.assertEquals(packageLocation.getCategory(), result.getCategory());
		Assert.assertEquals(packageLocation.getDescriptiveName(), result.getDescriptiveName());
		Assert.assertEquals(packageLocation.getName(), result.getName());
		Assert.assertEquals(packageLocation.getRootType(), result.getRootType());
		
		result = this.merger.merge(null, packageLocation);
		Assert.assertEquals(packageLocation.getCategory(), result.getCategory());
		Assert.assertEquals(packageLocation.getDescriptiveName(), result.getDescriptiveName());
		Assert.assertEquals(packageLocation.getName(), result.getName());
		Assert.assertEquals(packageLocation.getRootType(), result.getRootType());
	}
	
	@Test
	public void shouldMergePackageLocations() {
		PackageLocation packageLocation1 = new PackageLocation();
		packageLocation1.setCategory("myCategory1");
		packageLocation1.setDescriptiveName("myDescName1");
		packageLocation1.setName("myNameCommon");
		packageLocation1.setRootType("myRootType1");
		
		final MessagePart messagePart1 = new MessagePart();
		packageLocation1.getMessageParts().put("typeCommon", messagePart1);
		
		PackageLocation packageLocation2 = new PackageLocation();
		packageLocation2.setCategory("myCategory2");
		packageLocation2.setDescriptiveName("myDescName2");
		packageLocation2.setName("myNameCommon");
		packageLocation2.setRootType("myRootType2");
		
		final MessagePart messagePart2 = new MessagePart();
		packageLocation2.getMessageParts().put("typeCommon", messagePart2);
		
		this.jmock.checking(new Expectations() {{
			one(messagePartMerger).merge(messagePart1, messagePart2); will(returnValue(messagePart1));
		}});
		
		PackageLocation result = this.merger.merge(packageLocation1, packageLocation2);
		Assert.assertEquals(packageLocation1.getCategory(), result.getCategory());
		Assert.assertEquals(packageLocation1.getDescriptiveName(), result.getDescriptiveName());
		Assert.assertEquals(packageLocation1.getName(), result.getName());
		Assert.assertEquals(packageLocation1.getRootType(), result.getRootType());
		Assert.assertEquals(1, result.getMessageParts().size());
		Assert.assertEquals(packageLocation1.getMessageParts().get("typeCommon"), result.getMessageParts().get("typeCommon"));
		Assert.assertFalse(result.getDifferences().isEmpty());
		Assert.assertEquals(1, result.getDifferences().size());
		Assert.assertEquals(DifferenceType.PACKAGE_LOCATION_ROOT_TYPE, result.getDifferences().get(0).getType());
		Assert.assertEquals(2, result.getDifferences().get(0).getDifferences().size());
	}
}
