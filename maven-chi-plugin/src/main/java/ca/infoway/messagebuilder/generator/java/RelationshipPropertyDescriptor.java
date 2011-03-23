package ca.infoway.messagebuilder.generator.java;

import ca.infoway.messagebuilder.xml.Documentation;

public interface RelationshipPropertyDescriptor {
	
	public Documentation getDocumentation();
	public String[] getXmlMappings();
	public String getType();
	public boolean isCardinalityMultiple();
	public String getRelationshipNameUncapitalized();
	public String getRelationshipNameCapitalized();

}
