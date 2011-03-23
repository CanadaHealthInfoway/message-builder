package ca.infoway.messagebuilder.marshalling;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.Relationship;

class MockVisitor implements Visitor {

	private boolean rootStarted;
	private boolean rootEnded;
	private boolean attributeVisited;

	public boolean isRootStarted() {
		return rootStarted;
	}

	public void setRootStarted(boolean rootStarted) {
		this.rootStarted = rootStarted;
	}

	public void visitAssociationEnd(PartBridge tealBean,
			Relationship relationship) {
		
	}

	public void visitAssociationStart(PartBridge tealBean,
			Relationship relationship) {
	}

	public void visitAttribute(AttributeBridge tealBean,
			Relationship relationship, VersionNumber version) {
		this.attributeVisited = true;
	}

	public void visitRootEnd(PartBridge tealBean, Interaction interaction) {
		this.rootEnded = true;
	}

	public void visitRootStart(PartBridge tealBean, Interaction interaction) {
		this.rootStarted = true;
	}

	public boolean isRootEnded() {
		return this.rootEnded;
	}

	public boolean isAttributeVisited() {
		return this.attributeVisited;
	}

}
