package ca.infoway.messagebuilder.xml.visitor;

import java.util.List;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.Relationship;

public interface MessageVisitor {
	public void visitStructuralAttribute(Element base, Attr attr, Relationship relationship);
	public void visitAssociation(Element base, String xmlName, List<Element> elements, Relationship relationship);
	public void visitNonStructuralAttribute(Element base, List<Element> elements, Relationship relationship);
	public void visitRoot(Element documentElement, Interaction interaction);
}
