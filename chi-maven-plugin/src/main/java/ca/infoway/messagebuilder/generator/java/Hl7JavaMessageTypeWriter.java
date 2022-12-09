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

package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.util.ProgrammingLanguage.JAVA;
import static org.apache.commons.lang.SystemUtils.LINE_SEPARATOR;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.time.DateFormatUtils;

import ca.infoway.messagebuilder.GeneratorException;
import ca.infoway.messagebuilder.generator.NamingPolicy;
import ca.infoway.messagebuilder.generator.SourceFileWriter;
import ca.infoway.messagebuilder.generator.lang.Association;
import ca.infoway.messagebuilder.generator.lang.BaseRelationship;
import ca.infoway.messagebuilder.generator.lang.BaseRelationshipNameResolver;
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

public class Hl7JavaMessageTypeWriter extends Hl7MessageTypeWriter implements Hl7TypeWriter, SourceFileWriter {

	private ImportDeclarationGenerator importDeclarationGenerator;
    private final NameTranslator nameTranslator;
	private final BaseRelationshipNameResolver nameResolver;

	public Hl7JavaMessageTypeWriter(RenderedType type, NameTranslator nameTranslator, NamingPolicy namingPolicy) throws GeneratorException {
		super(type);
		this.nameTranslator = nameTranslator;
		this.nameResolver = new PropertyNameResolver(type.getLanguageSpecificName().getUnqualifiedClassName(), type.getRelationships(), namingPolicy);
		Set<Object> importTypes = new HashSet<Object>(ImportTypeUtil.getImports(this.type, JAVA));
        this.importDeclarationGenerator = new ImportDeclarationGenerator(this.type.getLanguageSpecificName(), importTypes, this.nameTranslator);
	}

	public void write(Writer writer) throws IOException {
		writer.write("/* This class was auto-generated by the message builder generator tools. */");
        writer.write(LINE_SEPARATOR);
		
        writePackage(this.type.getLanguageSpecificName().getPackageName(), writer);
        writeDependencies(writer, 0);
		
        writer.write(LINE_SEPARATOR);
        writer.write(LINE_SEPARATOR);
        this.type.getTypeDocumentation().write(JAVA, writer, 0);
        writeClassDefinition(writer, 0);
        writeSerialUid(writer, 1);
        writeAllRelationships(writer, 1);
        writeClassDefinitionClosure(0, writer);
    }

	private void writeSerialUid(Writer writer, int indent) throws IOException {
		if (!this.type.isAbstract()) {
			indent(indent, writer);
			writer.write("private static final long serialVersionUID = ");
			writer.write(DateFormatUtils.format(new Date(), "yyyyMMdd"));
			writer.write("L;");
	        writer.write(LINE_SEPARATOR);
		}
	}

	private void writeDependencies(Writer writer, int indentLevel) throws IOException {
		this.importDeclarationGenerator.generate(writer, indentLevel);
	}

    void writeClassDefinition(Writer writer, int indentLevel) throws IOException {
        writeHl7PartTypeMapping(writer, indentLevel);
        if (this.type.isRootType()) {
            writer.write("@Hl7RootType");
            writer.write(LINE_SEPARATOR);
        }
        if (this.type.isAbstract()) {
        	writer.write("public interface ");
        } else {
        	writer.write("public class ");
        }
        
        
        writer.write(this.type.getLanguageSpecificName().getUnqualifiedClassName());
        if (this.type.isTemplateType()) {
        	writeTemplateParameters(writer);
        }

        if (isInteractionAndHasParent(this.type)) {
   			writeInteractionDeclaration(writer);
        } else {
        	if (!this.type.isAbstract()) {
        		writer.write(" extends MessagePartBean");
        	}
        
	        if (!this.type.getInterfaceTypes().isEmpty()) {
	       		if (this.type.isAbstract()) {
	       			writer.write(" extends ");
	       		} else {
	       			writer.write(" implements ");
	       		}
	       		boolean first = true;
	       		for (RenderedType interfaceType : this.type.getInterfaceTypes()) {
	       			if (!first) {
	       				writer.write(", ");
	       			}
	       			writer.write(this.importDeclarationGenerator.getRepresentationOfClassName(interfaceType.getLanguageSpecificName().getFullyQualifiedName()));
	       			first = false;
				}
	       	}
        }
       	
        writer.write(" {");
        writer.write(LINE_SEPARATOR);
        writer.write(LINE_SEPARATOR);
    }

	private void writeInteractionDeclaration(Writer writer) throws IOException {
		writer.write(" extends ");
		InteractionType interaction = (InteractionType) this.type;
		Type parentTypeName = interaction.getParentType();
		writer.write(parentTypeName.getLanguageSpecificName().getUnqualifiedClassName());
		
		writeTemplateArguments(writer, interaction.getArguments());
		
		if (interaction.isCda()) {
			writer.write(" implements ClinicalDocumentBean");
		} else {
			writer.write(" implements InteractionBean");
		}
	}

	private void writeTemplateArguments(Writer writer, List<ArgumentType> arguments) throws IOException {
		if (!arguments.isEmpty()) {
			arguments = ArgumentType.sort(arguments);
			
			writer.write("<");
			boolean first = true;
			for (ArgumentType argument : arguments) {
				if (!first) {
					writer.write(",");
				}
				writer.write(this.importDeclarationGenerator.getRepresentationOfTypeName(argument.getType()));
				writeTemplateArguments(writer, argument.getArgumentTypes());
				first = false;
			}
			writer.write(">");
		}
	}

	private boolean isInteractionAndHasParent(RenderedType type) {
		return type instanceof InteractionType && ((InteractionType) type).getParentType() != null; 
	}

	private void writeHl7PartTypeMapping(Writer writer, int indentLevel)
			throws IOException {
		indent(indentLevel, writer);
        writer.write("@Hl7PartTypeMapping({");
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
        writer.write("})");
        writer.write(LINE_SEPARATOR);
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

    protected void writePackage(String packageName, Writer writer) throws IOException {
        writer.write("package ");
        writer.write(packageName);
        writer.write(";");
        writer.write(LINE_SEPARATOR);
    }
    
	@Override
	protected boolean writeConstructor(Writer writer, int indentLevel, List<BaseRelationship> relationships) throws IOException {
		if (this.type.isCdaDocumentRoot()) {
			indent(indentLevel, writer);
			writer.write("protected ");
			writer.write(this.type.getLanguageSpecificName().getUnqualifiedClassName());
			writer.write("() {}");
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	protected PropertyGenerator createPropertyGenerator(BaseRelationship relationship) {
		return relationship.getPropertyGenerator(JAVA, this.importDeclarationGenerator, this.nameResolver);
	}

	@Override
	protected PropertyGenerator createChoicePropertyGenerator(BaseRelationship rootChoice, Choice choice) {
		return PropertyGeneratorBuilders.newDerivedChoiceBuilder(JAVA, (Association) rootChoice, choice).build(this.importDeclarationGenerator, this.nameResolver);
	}

	@Override
	protected void writeDocumentation(Documentation documentation, ca.infoway.messagebuilder.xml.Relationship relationship, int indentLevel, Writer writer) throws IOException {
		new TypeDocumentation(documentation, relationship).write(JAVA, writer, indentLevel);
	}
    
	@Override
	protected void createGettersAndSettersForInterface(Writer writer, int indentLevel, BaseRelationship relationship) throws IOException {
		Relationship relForDocs = getRelationshipForDocumentation(relationship);
		writeDocumentation(relationship.getDocumentation(), relForDocs, indentLevel, writer);
		createPropertyGenerator(relationship).createGettersForInterface(indentLevel, writer);
		if (relationship.isWriteable()) {
			writeDocumentation(relationship.getDocumentation(), relForDocs, indentLevel, writer);
			createPropertyGenerator(relationship).createSettersForInterface(indentLevel, writer);
		}
	}

	@Override
	protected void createGettersAndSetters(Writer writer, int indentLevel, BaseRelationship relationship) throws IOException {
		Relationship relForDocs = getRelationshipForDocumentation(relationship);
		writeDocumentation(relationship.getDocumentation(), relForDocs, indentLevel, writer);
		createPropertyGenerator(relationship).createGetters(indentLevel, writer);
		if (relationship.isWriteable()) {
			writeDocumentation(relationship.getDocumentation(), relForDocs, indentLevel, writer);
			createPropertyGenerator(relationship).createSetters(indentLevel, writer);
		}
	}
	
}