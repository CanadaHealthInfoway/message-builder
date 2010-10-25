package ca.infoway.messagebuilder.generator.multiplemessageset;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.Difference;
import ca.infoway.messagebuilder.xml.HasDifferences;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.intelliware.commons.dependency.DependencyManager;
import ca.intelliware.commons.dependency.Layer;
import ca.intelliware.commons.dependency.Node;


public class ExciserTest {
	
	@Test
	public void shouldMarkDependencyInAssociation() throws Exception {
		
		MessageSet messageSet = new MessageSet();
		messageSet.getPackageLocations().put("ABCD_MT123456CA", new PackageLocation("ABCD_MT123456CA"));
		MessagePart body = new MessagePart("ABCD_MT123456CA.Body");
		body.getRelationships().add(new Relationship("arm", "ABCD_MT123456CA.Arm", Cardinality.create("1")));
		messageSet.addMessagePart(body);
		MessagePart arm = new MessagePart("ABCD_MT123456CA.Arm");
		messageSet.addMessagePart(arm);
		
		DependencyManager<String> map = new Exciser(messageSet).buildUpDependencyMap();
		
		printNodes(map);
		
		assertEquals("package", 0, map.getLayeredGraph().getLayer("ABCD_MT123456CA"));
		assertEquals("arm layer", 1, map.getLayeredGraph().getLayer("ABCD_MT123456CA.Arm"));
		assertEquals("body layer", 2, map.getLayeredGraph().getLayer("ABCD_MT123456CA.Body"));
	}
	
	@Test
	public void shouldMarkDependencyInSuperType() throws Exception {
		
		MessageSet messageSet = new MessageSet();
		messageSet.getPackageLocations().put("ABCD_MT123456CA", new PackageLocation("ABCD_MT123456CA"));
		messageSet.addMessagePart(new MessagePart("ABCD_MT123456CA.Message"));
		
		Interaction interaction = new Interaction();
		interaction.setName("ABCD_IN123456CA");
		interaction.setSuperTypeName("ABCD_MT123456CA.Message");
		messageSet.getInteractions().put(interaction.getName(), interaction);
		
		DependencyManager<String> map = new Exciser(messageSet).buildUpDependencyMap();
		
		assertEquals("package", 0, map.getLayeredGraph().getLayer("ABCD_MT123456CA"));
		assertEquals("message layer", 1, map.getLayeredGraph().getLayer("ABCD_MT123456CA.Message"));
		assertEquals("interaction layer", 2, map.getLayeredGraph().getLayer("ABCD_IN123456CA"));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldMarkDependencyInArgument() throws Exception {
		
		MessageSet messageSet = createInteractionWithArguments();
		
		DependencyManager<String> map = new Exciser(messageSet).buildUpDependencyMap();
		
		printNodes(map);
		
		assertEquals("package", 0, map.getLayeredGraph().getLayer("ABCD_MT123456CA"));
		assertEquals("trigger event layer", 1, map.getLayeredGraph().getLayer("ABCD_MT123456CA.ControlAct"));
		assertEquals("payload layer", 1, map.getLayeredGraph().getLayer("ABCD_MT123456CA.ParameterList"));
		assertEquals("interaction layer", 2, map.getLayeredGraph().getLayer("ABCD_IN123456CA"));

		Set<Node<String>> set = map.getNodeLayers().get(2).getContents();
		Node<String> node = (Node<String>) CollectionUtils.get(set, 0);
		assertTrue("depends on control act", node.getEfferentCouplings().contains("ABCD_MT123456CA.ControlAct"));
		assertTrue("depends on payload", node.getEfferentCouplings().contains("ABCD_MT123456CA.ParameterList"));
	}

	private MessageSet createInteractionWithArguments() {
		MessageSet messageSet = new MessageSet();
		messageSet.getPackageLocations().put("ABCD_MT123456CA", new PackageLocation("ABCD_MT123456CA"));
		messageSet.addMessagePart(new MessagePart("ABCD_MT123456CA.Message"));
		messageSet.addMessagePart(new MessagePart("ABCD_MT123456CA.ControlAct"));
		messageSet.addMessagePart(new MessagePart("ABCD_MT123456CA.ParameterList"));
		
		Interaction interaction = new Interaction();
		interaction.setName("ABCD_IN123456CA");
		interaction.setSuperTypeName("ABCD_MT123456CA.Message");
		Argument argument1 = new Argument();
		argument1.setName("ABCD_MT123456CA.ControlAct");
		interaction.getArguments().add(argument1);
		
		Argument argument2 = new Argument();
		argument2.setName("ABCD_MT123456CA.ParameterList");
		argument1.getArguments().add(argument2);
		messageSet.getInteractions().put(interaction.getName(), interaction);
		return messageSet;
	}

	private void printNodes(DependencyManager<String> map) {
		for (Layer<Node<String>> layer : map.getNodeLayers()) {
			System.out.println(layer.getLevel() + " -> " + layer.getContents());
		}
	}
	
	@Test
	public void shouldMarkDependencyInInterfaceType() throws Exception {
		
		MessageSet messageSet = new MessageSet();
		messageSet.getPackageLocations().put("ABCD_MT123456CA", new PackageLocation("ABCD_MT123456CA"));
		MessagePart appendage = new MessagePart("ABCD_MT123456CA.Appendage");
		appendage.getSpecializationChilds().add("ABCD_MT123456CA.Arm");
		messageSet.addMessagePart(appendage);
		MessagePart arm = new MessagePart("ABCD_MT123456CA.Arm");
		messageSet.addMessagePart(arm);
		
		DependencyManager<String> map = new Exciser(messageSet).buildUpDependencyMap();
		
		assertEquals("package", 0, map.getLayeredGraph().getLayer("ABCD_MT123456CA"));
		assertEquals("appendage layer", 1, map.getLayeredGraph().getLayer("ABCD_MT123456CA.Appendage"));
		assertEquals("arm layer", 2, map.getLayeredGraph().getLayer("ABCD_MT123456CA.Arm"));
	}
	
	@Test
	public void shouldRemoveInteractionsWithDifferences() throws Exception {
		MessageSet messageSet = createInteractionWithArguments();
		
		createDifference(messageSet.getInteractions().get("ABCD_IN123456CA"));
		
		new Exciser(messageSet).execute();
		
		assertNull("interaction", messageSet.getInteractions().get("ABCD_IN123456CA"));
		assertNotNull("payload", messageSet.getMessagePart("ABCD_MT123456CA.ParameterList"));
	}
	
	@Test
	public void shouldRemoveInteractionsWithArgumentDifferences() throws Exception {
		MessageSet messageSet = createInteractionWithArguments();
		
		createDifference(messageSet.getInteractions().get("ABCD_IN123456CA").getArguments().get(0).getArguments().get(0));
		
		new Exciser(messageSet).execute();
		
		assertNull("interaction", messageSet.getInteractions().get("ABCD_IN123456CA"));
		assertNotNull("payload", messageSet.getMessagePart("ABCD_MT123456CA.ParameterList"));
	}
	
	@Test
	public void shouldRemoveAllDependenciesIfWeRemovePayload() throws Exception {
		MessageSet messageSet = createInteractionWithArguments();
		
		createDifference(messageSet.getMessagePart("ABCD_MT123456CA.ParameterList"));
		
		new Exciser(messageSet).execute();
		
		assertNull("interaction", messageSet.getInteractions().get("ABCD_IN123456CA"));
		assertNull("payload", messageSet.getMessagePart("ABCD_MT123456CA.ParameterList"));
	}
	
	@Test
	public void shouldRemoveAllDependenciesIfWeRemovePackageLocation() throws Exception {
		MessageSet messageSet = createInteractionWithArguments();
		
		createDifference(messageSet.getPackageLocations().get("ABCD_MT123456CA"));
		
		new Exciser(messageSet).execute();
		
		assertNull("package location", messageSet.getPackageLocations().get("ABCD_MT123456CA"));
		assertNull("payload", messageSet.getMessagePart("ABCD_MT123456CA.ParameterList"));
		assertNull("interaction", messageSet.getInteractions().get("ABCD_IN123456CA"));
	}

	@Test
	public void shouldRemoveAllDependenciesIfWeHaveCyclicDependency() throws Exception {
		MessageSet messageSet = createInteractionWithArguments();
		MessagePart location = new MessagePart("ABCD_MT123456CA.Location");
		MessagePart place = new MessagePart("ABCD_MT123456CA.Place");
		location.getRelationships().add(new Relationship("place", "ABCD_MT123456CA.Place", Cardinality.create("0-1")));
		place.getRelationships().add(new Relationship("location", "ABCD_MT123456CA.Location", Cardinality.create("0-1")));
		
		messageSet.addMessagePart(location);
		messageSet.addMessagePart(place);
		MessagePart parameterList = messageSet.getMessagePart("ABCD_MT123456CA.ParameterList");
		parameterList.getRelationships().add(new Relationship("location", "ABCD_MT123456CA.Location", Cardinality.create("0-1")));
		
		createDifference(messageSet.getPackageLocations().get("ABCD_MT123456CA"));
		
		new Exciser(messageSet).execute();
		
		assertNull("package location", messageSet.getPackageLocations().get("ABCD_MT123456CA"));
		assertNull("payload", messageSet.getMessagePart("ABCD_MT123456CA.ParameterList"));
		assertNull("interaction", messageSet.getInteractions().get("ABCD_IN123456CA"));
	}
	
	private void createDifference(HasDifferences differences) {
		Difference difference = new Difference();
		difference.setOk(false);
		differences.addDifference(difference);
	}
	
	@Test
	public void shouldRemoveDependenciesWithChoiceDifference() throws Exception {
		Relationship choiceNotOk = new Relationship("otherPlace", "ABCD_MT123456CA.OtherPlace", Cardinality.create("0-1"));
		createDifference(choiceNotOk);
		
		Relationship choiceOk = new Relationship("anotherPlace", "ABCD_MT123456CA.AnotherPlace", Cardinality.create("0-1"));

		Relationship rel = new Relationship("place", "ABCD_MT123456CA.Place", Cardinality.create("0-1"));
		rel.getChoices().add(choiceNotOk);
		rel.getChoices().add(choiceOk);
		
		MessagePart part = new MessagePart("ABCD_MT123456CA.Message");
		part.getRelationships().add(rel);
		
		PackageLocation packageLocation = new PackageLocation("ABCD_MT123456CA");
		packageLocation.setRootType(part.getName());
		
		MessageSet messageSet = new MessageSet();
		messageSet.getPackageLocations().put("ABCD_MT123456CA", packageLocation);
		messageSet.addMessagePart(part);
		
		Interaction interaction = new Interaction();
		interaction.setName("ABCD_IN123456CA");
		interaction.setSuperTypeName("ABCD_MT123456CA.Message");
		messageSet.getInteractions().put(interaction.getName(), interaction);
		
		new Exciser(messageSet).execute();
		
		assertNull("interaction", messageSet.getInteractions().get("ABCD_IN123456CA"));
		// we have decided that leaving an empty package location (or one containing orphaned parts) is acceptable
		assertNotNull("package location", messageSet.getPackageLocations().get("ABCD_MT123456CA"));
		assertNull("message part", messageSet.getMessagePart("ABCD_MT123456CA.Message"));
	}
	
}
