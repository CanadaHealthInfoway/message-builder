package ca.infoway.messagebuilder.marshalling;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.Relationship;

interface Visitor {
	
	public void visitRootStart(PartBridge tealBean, Interaction interaction);
	public void visitRootEnd(PartBridge tealBean, Interaction interaction);
	
	public void visitAttribute(AttributeBridge tealBean, Relationship relationship, VersionNumber version);
	
	public void visitAssociationStart(PartBridge tealBean, Relationship relationship);
	public void visitAssociationEnd(PartBridge tealBean, Relationship relationship);

}
