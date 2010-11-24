package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createAssociation;
import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createSimplifiableAssociation;
import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createAttribute;
import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createSimplifiableAttribute;
import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createInlinedAttribute;
import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createMergedAssociation;
import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createRootType;
import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createType;
import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createSimplifiableType;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Ignore;
import org.junit.Test;

import ca.infoway.messagebuilder.generator.SysoutLogUI;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.TypeName;


public class Case2SimplifierTest {

	private TypeAnalysisResult result = new TypeAnalysisResult();
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
		new Case2Simplifier(new SysoutLogUI(), this.result, this.definitions).execute();
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
		
		new Case2Simplifier(new SysoutLogUI(), this.result, this.definitions).execute();
		
		assertTrue("elided", this.definitions.getType(deviceType.getName()).isInlined());
	}

	@Test @Ignore
	public void shouldInlineMergedTypeAndAlsoInlineRelationshipOnMergedType() throws Exception {

		Type innerType = createType(this.result, "Device1", false,
				createAttribute("id", new Cardinality(0,1), "II")
				);
		Type unmergedType = createType(this.result, "UnmergedType", false,
				createAssociation("relBeforeAttributes", 
				          new Cardinality(1,1), 
				          innerType),
				createAttribute("name", new Cardinality(0,1), "ST"),
				createAttribute("desc", new Cardinality(0,1), "ST")
			);
		TemporaryTypeName temporaryTypeName = TemporaryTypeName.create("merged");
		Type mergedType = createType(this.result, temporaryTypeName, false,
						createAssociation("relBeforeAttributes", 
								new Cardinality(1,1), 
								innerType),
						createAttribute("name", new Cardinality(0,1), "ST"),
						createAttribute("desc", new Cardinality(0,1), "ST")
		);
		mergedType.getMergedTypes().add(unmergedType);
		createRootType(this.result,
				"Sender", 
				createAttribute("telecom", new Cardinality(1, 1), "TEL.URI"),
				createMergedAssociation("device", 
						          new Cardinality(1,1), 
						          unmergedType,
						          mergedType,
								  null),
				createAssociation("device2", 
				          new Cardinality(1,1),
				          innerType
							)
			  );

		// unmerged version of merged types should be removed
		this.result.removeType(unmergedType);

		assertTrue("not yet elided", this.result.getTypes().containsKey(temporaryTypeName));
		assertTrue("not yet elided", this.result.getTypes().containsKey(innerType.getTypeName()));
		
		new Case2Simplifier(new SysoutLogUI(), this.result, this.definitions).execute();
		
		assertFalse("elided", this.result.getTypes().containsKey(temporaryTypeName));
		assertFalse("elided", this.result.getTypes().containsKey(innerType.getTypeName()));
		
		assertEquals("number of properties", 5, 
				this.result.getTypes().get(new TypeName("ABCD_MT123456CA.Sender")).getRelationships().size());

		assertTrue("xml mappings", getXmlMappings(this.result.getTypes().get(
				new TypeName("ABCD_MT123456CA.Sender"))).containsAll(
				Arrays.asList("telecom", "device/relBeforeAttributes/id", "device/name", "device/desc", "device2/id")));
	}

	@Test @Ignore
	public void shouldInlineMergedTypeButOnlyInlineApplicableRelationships() throws Exception {

		// TypeA has id
		// TypeB has id and name
		// TypeC is the merge of A and B
		// TypeD is root type and has an association to TypeA which has been replaced with an association to TypeC
		// after Case2, TypeD should now have id (from TypeA) but *not* name
		
		TemporaryTypeName temporaryTypeName = TemporaryTypeName.create("merged");
		
		Type unmergedType = createType(this.result, "UnmergedType", false,
					createAttribute("id", new Cardinality(0,1), "II")
				);
		Type mergedType = createType(this.result, temporaryTypeName, false,
				createAttribute("id", new Cardinality(0,1), "II"),
				createAttribute("name", new Cardinality(0,1), "ST")
			);
		mergedType.getMergedTypes().add(unmergedType);
		createRootType(this.result,
				"Sender", 
				createAttribute("telecom", new Cardinality(1, 1), "TEL.URI"),
				createMergedAssociation("device", 
						          new Cardinality(1,1), 
						          unmergedType,
						          mergedType,
								  null)
			  );
		
		this.result.removeType(unmergedType);

		assertTrue("not yet elided", this.result.getTypes().containsKey(temporaryTypeName));
		
		new Case2Simplifier(new SysoutLogUI(), this.result, this.definitions).execute();
		
		assertFalse("elided", this.result.getTypes().containsKey(temporaryTypeName));
		
		assertEquals("number of properties", 2, 
				this.result.getTypes().get(new TypeName("ABCD_MT123456CA.Sender")).getRelationships().size());
		
		assertTrue("xml mappings", getXmlMappings(this.result.getTypes().get(
				new TypeName("ABCD_MT123456CA.Sender"))).containsAll(
				Arrays.asList("telecom", "device/id")));
	}

	@Test @Ignore
	public void shouldInlineNestedMergedTypesButOnlyInlineApplicableRelationshipsForEach() throws Exception {

		// This one gets complicated...
		
		// TypeA has id and typeDAssoc
		// TypeB has id and name and typeDAssoc
		// TypeC is the merge of A and B
		// typeDAssoc is an association to TypeD which has been replaced with a merged association to TypeF
		// TypeD has text
		// TypeE has text and roleId
		// TypeF is the merge of D and E
		// TypeG is root type and has an association to TypeA (which has been replaced with a merged association to TypeC)
		// after Case2, TypeG should now have id and typeDAssoc (from TypeA) but *not* name, and should have text (from TypeD) but *not* roleId
		
		TemporaryTypeName temporaryTypeName1 = TemporaryTypeName.create("merged");
		TemporaryTypeName temporaryTypeName2 = TemporaryTypeName.create("merged");
		
		Attribute idAttr = createAttribute("id", new Cardinality(0,1), "II");
		Attribute textAttr = createAttribute("text", new Cardinality(0,1), "ST");
		Attribute nameAttr = createAttribute("name", new Cardinality(0,1), "ST");
		Attribute telecomAttr = createAttribute("telecom", new Cardinality(1, 1), "TEL.URI");
		
		Type typeD = createType(this.result, "UnmergedType2", false,  // TypeD
					textAttr
				);
		
		Type typeF = createType(this.result, temporaryTypeName2, false,  // TypeF
				textAttr,
				createAttribute("roleId", new Cardinality(0,1), "II")
		);
		
		Association mergedAssociation = createMergedAssociation("typeD", new Cardinality(1,1), typeD, typeF, null);
		typeF.getMergedTypes().add(typeD);
		
		Type typeA = createType(this.result, "UnmergedType1", false,  // TypeA
					idAttr,
					mergedAssociation
				);
		
		Type typeC = createType(this.result, temporaryTypeName1, false, // TypeC
				idAttr,
				nameAttr,
				mergedAssociation
			);
		typeC.getMergedTypes().add(typeA);
		
		createRootType(this.result,   // TypeG
				"Sender", 
				telecomAttr,
				createMergedAssociation("device", 
						          new Cardinality(1,1), 
						          typeA,
						          typeC,
								  null)
			  );

		// A and D have been merged, so they should be removed from the collection of types
		this.result.removeType(typeA);
		this.result.removeType(typeD);
		
		assertTrue("not yet elided", this.result.getTypes().containsKey(temporaryTypeName1));
		assertTrue("not yet elided", this.result.getTypes().containsKey(temporaryTypeName2));
		
		new Case2Simplifier(new SysoutLogUI(), this.result, this.definitions).execute();
		
		assertFalse("elided", this.result.getTypes().containsKey(temporaryTypeName1));
		assertFalse("elided", this.result.getTypes().containsKey(temporaryTypeName2));
		
		assertEquals("number of properties", 3, 
				this.result.getTypes().get(new TypeName("ABCD_MT123456CA.Sender")).getRelationships().size());
		
		assertTrue("xml mappings", getXmlMappings(this.result.getTypes().get(
				new TypeName("ABCD_MT123456CA.Sender"))).containsAll(
				Arrays.asList("telecom", "device/id", "device/typeD/text")));
	}

	@Test @Ignore
	public void shouldInlineMergedTypeWithInlinedRelationships() throws Exception {

		TemporaryTypeName temporaryTypeName = TemporaryTypeName.create("merged");
		Attribute id = createAttribute("id", new Cardinality(0,1), "II");
		Type inlinedType = createType(this.result, "Device1", false,
					id
					);
		Type unmergedType = createType(this.result, "NotMerged", false,
				createInlinedAttribute(
						id,
						createAssociation("relBeforeId", new Cardinality(0,1),
						          inlinedType
								)),
				createAttribute("name", new Cardinality(0,1), "ST"),
				createAttribute("desc", new Cardinality(0,1), "ST")
			);
		Type mergedType = createType(this.result, temporaryTypeName, false,
				createInlinedAttribute(
						id,
						createAssociation("relBeforeId", new Cardinality(0,1),
						          inlinedType
								)),
				createAttribute("name", new Cardinality(0,1), "ST"),
				createAttribute("desc", new Cardinality(0,1), "ST")
			);
		mergedType.getMergedTypes().add(unmergedType);
		createRootType(this.result,
				"Sender", 
				createAttribute("telecom", new Cardinality(1, 1), "TEL.URI"),
				createMergedAssociation("device", 
						          new Cardinality(1,1),
						          unmergedType,
						          mergedType,
									null
									));

		// unmergedType will have already been removed when merged (Case3) 
		this.result.removeType(unmergedType);
		
		assertTrue("not yet elided", this.result.getTypes().containsKey(temporaryTypeName));
		
		new Case2Simplifier(new SysoutLogUI(), this.result, this.definitions).execute();
		
		assertFalse("elided", this.result.getTypes().containsKey(temporaryTypeName));
		
		assertEquals("number of properties", 4, 
				this.result.getTypes().get(new TypeName("ABCD_MT123456CA.Sender")).getRelationships().size());
		
		assertTrue("xml mappings", getXmlMappings(this.result.getTypes().get(
				new TypeName("ABCD_MT123456CA.Sender"))).containsAll(
				Arrays.asList("telecom", "device/relBeforeId/id", "device/name", "device/desc")));
	}

	@Test @Ignore
	public void shouldInlineMergedTypeWithDifferentInlinedRelationships() throws Exception {

		TemporaryTypeName temporaryTypeName = TemporaryTypeName.create("merged");
		Type unmergedType1 = createType(this.result, "NotMerged1", false,
				createAttribute("name", new Cardinality(0,1), "ST")
			);
		Type unmergedType2 = createType(this.result, "NotMerged2", false,
				createAttribute("desc", new Cardinality(0,1), "ST")
			);
		Type mergedType = createType(this.result, temporaryTypeName, false,
				createAttribute("name", new Cardinality(0,1), "ST"),
				createAttribute("desc", new Cardinality(0,1), "ST")
			);
		mergedType.getMergedTypes().add(unmergedType1);
		mergedType.getMergedTypes().add(unmergedType2);
		createRootType(this.result,
				"Sender", 
				createAttribute("telecom", new Cardinality(1, 1), "TEL.URI"),
				createMergedAssociation("device", 
						          new Cardinality(1,1),
						          unmergedType1,
						          mergedType,
									null
									));

		// unmergedType will have already been removed when merged (Case3) 
		this.result.removeType(unmergedType1);
		this.result.removeType(unmergedType2);
		
		assertTrue("not yet elided", this.result.getTypes().containsKey(temporaryTypeName));
		
		new Case2Simplifier(new SysoutLogUI(), this.result, this.definitions).execute();
		
		assertFalse("elided", this.result.getTypes().containsKey(temporaryTypeName));
		
		assertEquals("number of properties", 2, 
				this.result.getTypes().get(new TypeName("ABCD_MT123456CA.Sender")).getRelationships().size());
		
		assertTrue("xml mappings", getXmlMappings(this.result.getTypes().get(
				new TypeName("ABCD_MT123456CA.Sender"))).containsAll(
				Arrays.asList("telecom", "device/name")));
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
		
		new Case2Simplifier(new SysoutLogUI(), this.result, this.definitions).execute();
		
		assertFalse("elided", this.definitions.getType("ABCD_MT123456CA.Device1").isInlined());
	}
	
	private Set<String> getXmlMappings(Type type) {
		Set<String> result = new HashSet<String>();
		for (BaseRelationship relationship : type.getRelationships()) {
			result.addAll(Arrays.asList(relationship.getAllXmlMappings()));
		}
		return result;
	}
}
