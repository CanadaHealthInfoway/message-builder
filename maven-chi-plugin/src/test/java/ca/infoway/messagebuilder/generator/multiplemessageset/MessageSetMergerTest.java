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

import ca.infoway.messagebuilder.generator.OutputUI;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;

@RunWith(JMock.class)
public class MessageSetMergerTest {

	private final Mockery jmock = new JUnit4Mockery() {{
		setImposteriser(ClassImposteriser.INSTANCE);
	}};
	
	private OutputUI outputUI;
	private MessageSetMerger merger;
	private MessageSet resultMessageSet;
	private PackageLocationMerger packageLocationMerger; 
	private InteractionMerger interactionMerger;
	
	@Before
	public void setUp() {
		this.outputUI = this.jmock.mock(OutputUI.class);
		this.resultMessageSet = new MessageSet();
		this.packageLocationMerger = this.jmock.mock(PackageLocationMerger.class);
		this.interactionMerger = this.jmock.mock(InteractionMerger.class);
		this.merger = new MessageSetMerger(this.outputUI, this.resultMessageSet, this.packageLocationMerger, this.interactionMerger);
	}
	
	@Test
	public void shouldHandleEmptyMessageSets() {
		this.merger.merge(null, null);
		Assert.assertTrue(this.resultMessageSet.getPackageLocations().isEmpty());
		Assert.assertTrue(this.resultMessageSet.getInteractions().isEmpty());
		Assert.assertNull(this.resultMessageSet.getVersion());
		
		this.merger.merge(new MessageSet(), new MessageSet());
		Assert.assertTrue(this.resultMessageSet.getPackageLocations().isEmpty());
		Assert.assertTrue(this.resultMessageSet.getInteractions().isEmpty());
		Assert.assertNull(this.resultMessageSet.getVersion());
	}
	
	@Test
	public void shouldMergeMessageSetWithOnePrimaryNullSecondary() {
		String version = "myVersion";
		this.resultMessageSet.setVersion(version); // version is pre-set
		
		MessageSet messageSet = new MessageSet();
		
		final PackageLocation plValue = new PackageLocation();
		String plKey = "plKey";
		messageSet.getPackageLocations().put(plKey, plValue);
		
		final Interaction intValue = new Interaction();
		String intKey = "intKey";
		messageSet.getInteractions().put(intKey, intValue);
		
		String component = "myComponent";
		messageSet.setComponent(component);
		
		this.jmock.checking(new Expectations() {{
			one(interactionMerger).merge(intValue, null); will(returnValue(intValue));
			one(packageLocationMerger).merge(plValue, null); will(returnValue(plValue));
		}});

		this.merger.merge(messageSet, null);
		Assert.assertEquals(1, this.resultMessageSet.getPackageLocations().size());
		Assert.assertEquals(plValue, this.resultMessageSet.getPackageLocations().get(plKey));
		Assert.assertEquals(1, this.resultMessageSet.getInteractions().size());
		Assert.assertEquals(intValue, this.resultMessageSet.getInteractions().get(intKey));
		Assert.assertEquals(component, this.resultMessageSet.getComponent());
		Assert.assertEquals(version, this.resultMessageSet.getVersion());
	}
	
	@Test
	public void shouldMergeMessageSetWithNullPrimaryOneSecondary() {
		String version = "myVersion";
		this.resultMessageSet.setVersion(version); // version is pre-set
		
		MessageSet messageSet = new MessageSet();
		
		final PackageLocation plValue = new PackageLocation();
		String plKey = "plKey";
		messageSet.getPackageLocations().put(plKey, plValue);
		
		final Interaction intValue = new Interaction();
		String intKey = "intKey";
		messageSet.getInteractions().put(intKey, intValue);
		
		String component = "myComponent";
		messageSet.setComponent(component);
		
		this.jmock.checking(new Expectations() {{
			one(interactionMerger).merge(null, intValue); will(returnValue(intValue));
			one(packageLocationMerger).merge(null, plValue); will(returnValue(plValue));
		}});

		this.merger.merge(null, messageSet);
		Assert.assertEquals(1, this.resultMessageSet.getPackageLocations().size());
		Assert.assertEquals(plValue, this.resultMessageSet.getPackageLocations().get(plKey));
		Assert.assertEquals(1, this.resultMessageSet.getInteractions().size());
		Assert.assertEquals(intValue, this.resultMessageSet.getInteractions().get(intKey));
		Assert.assertEquals(component, this.resultMessageSet.getComponent());
		Assert.assertEquals(version, this.resultMessageSet.getVersion());
	}
	
	@Test
	public void shouldMergeMessageSetsWithEachHavingUniqueValues() {
		String version = "myVersion";
		this.resultMessageSet.setVersion(version); // version is pre-set
		
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
			one(interactionMerger).merge(intValue1, null); will(returnValue(intValue1));
			one(packageLocationMerger).merge(plValue1, null); will(returnValue(plValue1));
			
			one(interactionMerger).merge(null, intValue2); will(returnValue(intValue2));
			one(packageLocationMerger).merge(null, plValue2); will(returnValue(plValue2));
		}});

		this.merger.merge(messageSet1, messageSet2);
		Assert.assertEquals(2, this.resultMessageSet.getPackageLocations().size());
		Assert.assertTrue(this.resultMessageSet.getPackageLocations().containsKey(plKey1));
		Assert.assertTrue(this.resultMessageSet.getPackageLocations().containsKey(plKey2));
		Assert.assertTrue(this.resultMessageSet.getPackageLocations().containsValue(plValue1));
		Assert.assertTrue(this.resultMessageSet.getPackageLocations().containsValue(plValue2));
		Assert.assertEquals(2, this.resultMessageSet.getInteractions().size());
		Assert.assertTrue(this.resultMessageSet.getInteractions().containsKey(intKey1));
		Assert.assertTrue(this.resultMessageSet.getInteractions().containsKey(intKey2));
		Assert.assertTrue(this.resultMessageSet.getInteractions().containsValue(intValue1));
		Assert.assertTrue(this.resultMessageSet.getInteractions().containsValue(intValue2));
		Assert.assertEquals(component1, this.resultMessageSet.getComponent());
		Assert.assertEquals(version, this.resultMessageSet.getVersion());
	}
	
	@Test
	public void shouldMergeMessageSetsWithEachHavingSame() {
		String version = "myVersion";
		this.resultMessageSet.setVersion(version); // version is pre-set
		
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

		this.merger.merge(messageSet1, messageSet2);
		Assert.assertEquals(1, this.resultMessageSet.getPackageLocations().size());
		Assert.assertTrue(this.resultMessageSet.getPackageLocations().containsKey(plKey1));
		Assert.assertTrue(this.resultMessageSet.getPackageLocations().containsValue(plValue1));
		Assert.assertEquals(1, this.resultMessageSet.getInteractions().size());
		Assert.assertTrue(this.resultMessageSet.getInteractions().containsKey(intKey1));
		Assert.assertTrue(this.resultMessageSet.getInteractions().containsValue(intValue1));
		Assert.assertEquals(component1, this.resultMessageSet.getComponent());
		Assert.assertEquals(version, this.resultMessageSet.getVersion());
	}
}
