package ca.infoway.messagebuilder.generator.java;

import java.util.List;
import java.util.Set;

import ca.infoway.messagebuilder.generator.lang.TypeDocumentation;
import ca.infoway.messagebuilder.xml.TypeName;

public interface RenderedType {

	public TypeName getTypeName();
	public List<BaseRelationship> getRelationships();
	public TypeDocumentation getTypeDocumentation();
	public boolean isAbstract();
	public boolean isRootType();
	public boolean isTemplateType();
	public String[] getPartTypeMapping();
	public List<String> getTemplateVariables();
	public Set<TypeName> getInterfaceTypes();

}
