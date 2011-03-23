package ca.infoway.messagebuilder.marshalling;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.Relationship;

public class TealBeanRenderWalkerTest {
	
	private TealBeanRenderWalker walker;
	private MockVisitor visitor;
	private MockMessageBean message;
	private MockBridgeFactory bridgeFactory;
	
	@Before
	public void setUp() throws Exception {
		
		this.bridgeFactory = new MockBridgeFactory();
		this.message = new MockMessageBean();
		this.walker = new TealBeanRenderWalker(this.message, null, this.bridgeFactory);
		this.visitor = new MockVisitor();
		this.bridgeFactory.interaction = new Interaction();
	}
	
	@Test
	public void shouldPerformTrivialWalk() throws Exception {
		this.bridgeFactory.partBridge = new MockPartBridge();
		this.walker.accept(this.visitor);
		
		assertTrue("started", this.visitor.isRootStarted());
		assertTrue("started", this.visitor.isRootEnded());
	}

	@Test
	public void shouldVisitAttribute() throws Exception {
		MockAttributeBridge bridge = new MockAttributeBridge();
		bridge.relationship = new Relationship();
		
		this.walker.processRelationship(this.bridgeFactory.interaction, bridge, this.visitor);
		
		assertTrue("visited", this.visitor.isAttributeVisited());
	}
}
