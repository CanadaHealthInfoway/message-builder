package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createSimplifiableAssociation;
import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createSimplifiableAttribute;
import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createSimplifiableType;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ca.infoway.messagebuilder.generator.SysoutLogUI;
import ca.infoway.messagebuilder.xml.Cardinality;


public class Case2SimplifierTest {

	private SimplifiableDefinitions definitions = new SimplifiableDefinitions();
	
	@Test
	public void shouldElideType() throws Exception {

		createSimplifiableType(this.definitions,
				"Sender", 
				true,
				createSimplifiableAttribute("telecom", new Cardinality(1, 1), "TEL.URI"),
				createSimplifiableAssociation("device", new Cardinality(1,1), 
						createSimplifiableType(this.definitions, "Device1", false,
								createSimplifiableAttribute("id", new Cardinality(0,1), "II"),
								createSimplifiableAttribute("name", new Cardinality(0,1), "ST"),
								createSimplifiableAttribute("desc", new Cardinality(0,1), "ST")
						)));
		assertFalse("definition not yet elided", this.definitions.getType("ABCD_MT123456CA.Device1").isInlined());
		new Case2Simplifier(new SysoutLogUI(), this.definitions).execute();
		assertTrue("definition elided", this.definitions.getType("ABCD_MT123456CA.Device1").isInlined());
	}

	@Test
	public void shouldElideTemporaryType() throws Exception {

		SimplifiableType deviceType = createSimplifiableType(this.definitions, "Device", false,
				createSimplifiableAttribute("id", new Cardinality(0,1), "II"),
				createSimplifiableAttribute("name", new Cardinality(0,1), "ST"),
				createSimplifiableAttribute("desc", new Cardinality(0,1), "ST")
				);
		SimplifiableType device2Type = createSimplifiableType(this.definitions, "Device2", false,
				createSimplifiableAttribute("id", new Cardinality(0,1), "II"),
				createSimplifiableAttribute("name", new Cardinality(0,1), "ST"),
				createSimplifiableAttribute("desc", new Cardinality(0,1), "ST")
		);
		TemporaryTypeName temporaryTypeName = TemporaryTypeName.create("merged");
		createSimplifiableType(this.definitions,
				"Sender", true, 
				createSimplifiableAttribute("telecom", new Cardinality(1, 1), "TEL.URI"),
				createSimplifiableAssociation("device", 
						          new Cardinality(1,1), deviceType));
		
		deviceType.setMergedTypeName(temporaryTypeName);
		deviceType.getMergedWithTypes().add(device2Type);
		
		assertTrue("merged", this.definitions.getType(deviceType.getName()).isMerged());
		assertFalse("not yet elided", this.definitions.getType(deviceType.getName()).isInlined());
		
		new Case2Simplifier(new SysoutLogUI(), this.definitions).execute();
		
		assertTrue("elided", this.definitions.getType(deviceType.getName()).isInlined());
	}

	@Test
	public void shouldNotElideTypeIfUsedInMultipleCardinalityRelationship() throws Exception {
		
		createSimplifiableType(this.definitions,
				"Sender", true,
				createSimplifiableAttribute("telecom", new Cardinality(1, 1), "TEL.URI"),
				createSimplifiableAssociation("device", new Cardinality(1,5), 
						createSimplifiableType(this.definitions, "Device1", false,
								createSimplifiableAttribute("id", new Cardinality(0,1), "II"),
								createSimplifiableAttribute("name", new Cardinality(0,1), "ST"),
								createSimplifiableAttribute("desc", new Cardinality(0,1), "ST")
						)));
		
		new Case2Simplifier(new SysoutLogUI(), this.definitions).execute();
		
		assertFalse("elided", this.definitions.getType("ABCD_MT123456CA.Device1").isInlined());
	}
	
}
