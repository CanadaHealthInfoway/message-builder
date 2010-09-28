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

import ca.infoway.messagebuilder.generator.LogLevel;
import ca.infoway.messagebuilder.generator.OutputUI;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.PackageLocation;

@RunWith(JMock.class)
public class PackageLocationMergerTest {

	private OutputUI outputUI;
	private MessagePartMerger messagePartMerger;
	private PackageLocationMerger merger;
	
	private final Mockery jmock = new JUnit4Mockery() {{
		setImposteriser(ClassImposteriser.INSTANCE);
	}};

	@Before
	public void setup() {
		this.outputUI = this.jmock.mock(OutputUI.class);
		this.messagePartMerger = this.jmock.mock(MessagePartMerger.class);
		this.merger = new PackageLocationMerger(this.outputUI, this.messagePartMerger);
	}

	@Test
	public void shouldHandleEmptyPackageLocations() {
		PackageLocation result = this.merger.merge(null, "1", null, "2");
		Assert.assertNull(result.getName());
		
		result = this.merger.merge(new PackageLocation(), "1", new PackageLocation(), "2");
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
			one(messagePartMerger).merge(messagePart, "1", null, "2"); will(returnValue(messagePart));
		}});
		
		PackageLocation result = this.merger.merge(packageLocation, "1", new PackageLocation(), "2");
		Assert.assertEquals(packageLocation.getCategory(), result.getCategory());
		Assert.assertEquals(packageLocation.getDescriptiveName(), result.getDescriptiveName());
		Assert.assertEquals(packageLocation.getName(), result.getName());
		Assert.assertEquals(packageLocation.getRootType(), result.getRootType());
		
		this.jmock.checking(new Expectations() {{
			one(messagePartMerger).merge(messagePart, "1", null, "2"); will(returnValue(messagePart));
		}});
		
		result = this.merger.merge(packageLocation, "1", null, "2");
		Assert.assertEquals(packageLocation.getCategory(), result.getCategory());
		Assert.assertEquals(packageLocation.getDescriptiveName(), result.getDescriptiveName());
		Assert.assertEquals(packageLocation.getName(), result.getName());
		Assert.assertEquals(packageLocation.getRootType(), result.getRootType());
		
		this.jmock.checking(new Expectations() {{
			one(messagePartMerger).merge(null, "1", messagePart, "2"); will(returnValue(messagePart));
		}});
		
		result = this.merger.merge(null, "1", packageLocation, "2");
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
			one(messagePartMerger).merge(messagePart1, "1", messagePart2, "2"); will(returnValue(messagePart1));
			one(outputUI).log(LogLevel.ERROR, "Merging two package locations with different root types: myRootType1 / myRootType2");
		}});
		
		PackageLocation result = this.merger.merge(packageLocation1, "1", packageLocation2, "2");
		Assert.assertEquals(packageLocation1.getCategory(), result.getCategory());
		Assert.assertEquals(packageLocation1.getDescriptiveName(), result.getDescriptiveName());
		Assert.assertEquals(packageLocation1.getName(), result.getName());
		Assert.assertEquals(packageLocation1.getRootType(), result.getRootType());
		Assert.assertEquals(1, result.getMessageParts().size());
		Assert.assertEquals(packageLocation1.getMessageParts().get("typeCommon"), result.getMessageParts().get("typeCommon"));
		Assert.assertNotNull(result.getDifference());
		Assert.assertEquals("rootType", result.getDifference().getType());
		Assert.assertEquals(2, result.getDifference().getDifferences().size());
	}
}
