/**
 * Copyright 2013 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.generator.dotnet;

import static ca.infoway.messagebuilder.generator.util.ProgrammingLanguage.C_SHARP;
import static org.apache.commons.lang.SystemUtils.LINE_SEPARATOR;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import ca.infoway.messagebuilder.GeneratorException;
import ca.infoway.messagebuilder.generator.NamingPolicy;
import ca.infoway.messagebuilder.generator.lang.Association;
import ca.infoway.messagebuilder.generator.lang.BaseRelationship;
import ca.infoway.messagebuilder.generator.lang.Choice;
import ca.infoway.messagebuilder.generator.lang.Hl7MessageTypeWriter;
import ca.infoway.messagebuilder.generator.lang.Hl7TypeWriter;
import ca.infoway.messagebuilder.generator.lang.ImportTypeUtil;
import ca.infoway.messagebuilder.generator.lang.InteractionType;
import ca.infoway.messagebuilder.generator.lang.InteractionType.ArgumentType;
import ca.infoway.messagebuilder.generator.lang.NameTranslator;
import ca.infoway.messagebuilder.generator.lang.PropertyGenerator;
import ca.infoway.messagebuilder.generator.lang.PropertyGeneratorBuilders;
import ca.infoway.messagebuilder.generator.lang.PropertyNameResolver;
import ca.infoway.messagebuilder.generator.lang.RenderedType;
import ca.infoway.messagebuilder.generator.lang.Type;
import ca.infoway.messagebuilder.generator.lang.TypeDocumentation;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.Relationship;

/**
 * <p>Write out a valid C# message class.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
class Hl7DotNetMessageTypeWriter extends Hl7MessageTypeWriter implements Hl7TypeWriter {

	private final NameTranslator nameTranslator;
	private final DependencyManager manager;
	private PropertyNameResolver nameResolver;
	private String namespace;

	// assuming that this method is not important for passing in removed references
	Hl7DotNetMessageTypeWriter(Type type, NameTranslator nameTranslator, DependencyManager manager, NamingPolicy namingPolicy) throws GeneratorException {
		super(type);
		this.nameTranslator = nameTranslator;
		this.namespace = this.nameTranslator.getPackageName(type.getTypeName());
		this.manager = manager;
		this.nameResolver = new PropertyNameResolver(
				this.type.getLanguageSpecificName().getUnqualifiedClassName(), 
				type.getRelationships(), namingPolicy);
	}
	
	Hl7DotNetMessageTypeWriter(Type type, NameTranslator translator, NamespaceContents contents, NamingPolicy namingPolicy) throws GeneratorException {
		this(type, translator, new UsingManager(type.getTypeName(), ImportTypeUtil.getImports(type, C_SHARP), translator, contents), namingPolicy);
	}

	public void write(Writer writer) throws IOException, GeneratorException {
		writer.write("/* This class was auto-generated by the message builder generator tools. */");
        writer.write(LINE_SEPARATOR);

        writeNamespace(writer);
        
        writer.write(LINE_SEPARATOR);
        this.manager.generate(writer, 1);
		
        writer.write(LINE_SEPARATOR);
        writer.write(LINE_SEPARATOR);
        this.type.getTypeDocumentation().write(C_SHARP, writer, 1);
        writeClassDefinition(writer, 1);

        writeAllRelationships(writer, 2);
        writeClassDefinitionClosure(1, writer);
        writer.write(LINE_SEPARATOR);
        writer.write("}");
        
	}

	private void writeTemplateParameters(Writer writer) throws IOException {
    	
    	writer.write("<");
    	
    	List<String> variables = this.type.getTemplateVariables();
    	boolean first = true;
    	for (String variable : variables) {
    		if (!first) {
    			writer.write(",");
    		}
    		writer.write(variable);
    		first = false;
		}
    	writer.write(">");
	}
	

	@Override
	protected PropertyGenerator createPropertyGenerator(BaseRelationship relationship) {
		return relationship.getPropertyGenerator(C_SHARP, this.manager, this.nameResolver);
	}

	@Override
	protected PropertyGenerator createChoicePropertyGenerator(BaseRelationship rootChoice, Choice choice) {
		return PropertyGeneratorBuilders.newDerivedChoiceBuilder(C_SHARP, (Association) rootChoice, choice).build(this.manager, this.nameResolver);
	}
	
	@Override
	protected boolean writeConstructor(Writer writer, int indentLevel, List<BaseRelationship> relationships) throws IOException {
		
		indent(indentLevel, writer);
		// TODO CDADOTNET In the java generator, if the class is the entry point of a package representing a document template, we create a no-arg protected constructor.
		//   The intention is to prevent end-users from instantiating these beans directly. We want to force them to instantiate the "interaction" class that extends the bean.
		writer.write("public ");
		writer.write(getClassName());
		writer.write("() {");
		writer.write(LINE_SEPARATOR);
		
		for (BaseRelationship baseRelationship : relationships) {
			createPropertyGenerator(baseRelationship).createConstructorInitialization(indentLevel+1, writer);
		}
		
		indent(indentLevel, writer);
		writer.write("}");
		
		return true;
	}

	private void writeClassDefinition(Writer writer, int indent) throws IOException {
        writeHl7PartTypeMapping(writer, indent);
		indent(indent, writer);
        if (this.type.isAbstract()) {
        	writer.write("public interface ");
        } else {
        	writer.write("public class ");
        }
        
        writer.write(getClassName());
        if (this.type.isTemplateType()) {
        	writeTemplateParameters(writer);
        }
        
        if (isInteractionAndHasParent(this.type)) {
   			writeInteractionDeclaration(writer);
        } else {
	    	if (!this.type.isAbstract()) {
	    		writer.write(" : ");
	    		writer.write("MessagePartBean");
	    	}
	        if (!this.type.getInterfaceTypes().isEmpty()) {
	       		boolean first = this.type.isAbstract();
	       		for (RenderedType interfaceType : this.type.getInterfaceTypes()) {
	       			if (!first) {
	       				writer.write(", ");
	       			} else {
	       				writer.write(" : ");
	       			}
	       			writer.write(this.manager.getRepresentationOfClassName(interfaceType.getLanguageSpecificName().getFullyQualifiedName()));
	       			first = false;
				}
	       	}
        }
    	
        writer.write(" {");
        writer.write(LINE_SEPARATOR);
        writer.write(LINE_SEPARATOR);
	}

	private boolean isInteractionAndHasParent(RenderedType type) {
		return type instanceof InteractionType && ((InteractionType) type).getParentType() != null; 
	}
	
	private void writeInteractionDeclaration(Writer writer) throws IOException {
		writer.write(" : ");
		InteractionType interaction = (InteractionType) this.type;
		Type parent = interaction.getParentType();
		writer.write(parent.getLanguageSpecificName().getUnqualifiedClassName());
		
		writeTemplateArguments(writer, interaction.getArguments());
		
		if (interaction.isCda()) {
			writer.write(", IClinicalDocument");
		} else {
			writer.write(", IInteraction");
		}
	}
	
	@SuppressWarnings("deprecation")
	private void writeTemplateArguments(Writer writer, List<ArgumentType> arguments) throws IOException {
		if (!arguments.isEmpty()) {
			arguments = ArgumentType.sort(arguments);
			
			writer.write("<");
			boolean first = true;
			for (ArgumentType argument : arguments) {
				if (!first) {
					writer.write(",");
				}
				writer.write(this.manager.getRepresentationOfTypeName(argument.getType()));
				writeTemplateArguments(writer, argument.getArgumentTypes());
				first = false;
			}
			writer.write(">");
		}
	}

	private void writeHl7PartTypeMapping(Writer writer, int indentLevel) throws IOException {
		indent(indentLevel, writer);
        writer.write("[Hl7PartTypeMappingAttribute(new string[] {");
        boolean first = true;
        for (String mapping : this.type.getPartTypeMapping()) {
        	if (!first) {
        		writer.write(",");
        	}
        	writer.write("\"");
        	writer.write(mapping);
        	writer.write("\"");
        	first = false;
		}
        writer.write("})]");
        writer.write(LINE_SEPARATOR);
		
	}

	private String getClassName() {
		return this.type.getLanguageSpecificName().getUnqualifiedClassName();
	}

	private void writeNamespace(Writer writer) throws IOException {
		writer.write("namespace ");
		writer.write(getNamespaceName());
		writer.write(" {");
	}

	private String getNamespaceName() {
		return this.namespace;
	}

	@Override
	protected void writeDocumentation(Documentation documentation, Relationship relationship, int indentLevel, Writer writer) throws IOException {
		new TypeDocumentation(documentation, relationship).write(C_SHARP, writer, indentLevel);
	}
    
	@Override
	protected void createGettersAndSettersForInterface(Writer writer, int indentLevel, BaseRelationship relationship) throws IOException {
		createPropertyGenerator(relationship).createGettersAndSettersForInterface(indentLevel, writer);
	}

	@Override
	protected void createGettersAndSetters(Writer writer, int indentLevel, BaseRelationship relationship) throws IOException {
		writeDocumentation(relationship.getDocumentation(), getRelationshipForDocumentation(relationship), indentLevel, writer);
		createPropertyGenerator(relationship).createGettersAndSetters(indentLevel, writer);
	}
	
}
