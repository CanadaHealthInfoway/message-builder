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

import static ca.infoway.messagebuilder.marshalling.hl7.DomainTypeHelper.sanitize;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.CompareToBuilder;

import ca.infoway.messagebuilder.Named;
import ca.infoway.messagebuilder.generator.DataType;
import ca.infoway.messagebuilder.generator.GeneratorException;
import ca.infoway.messagebuilder.generator.LogLevel;
import ca.infoway.messagebuilder.generator.NamingPolicy;
import ca.infoway.messagebuilder.generator.OutputUI;
import ca.infoway.messagebuilder.generator.TypeConverter;
import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;
import ca.infoway.messagebuilder.generator.multiplemessageset.ExciseReportGenerator;
import ca.infoway.messagebuilder.generator.multiplemessageset.ExcisedItem;
import ca.infoway.messagebuilder.generator.multiplemessageset.Exciser;
import ca.infoway.messagebuilder.generator.util.DomainRegistry;
import ca.infoway.messagebuilder.generator.util.PackageName;
import ca.infoway.messagebuilder.xml.ConceptDomain;
import ca.infoway.messagebuilder.xml.HasDifferences;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;
import ca.infoway.messagebuilder.xml.ValueSet;
import ca.infoway.messagebuilder.xml.Vocabulary;
import ca.intelliware.commons.dependency.DependencyManager;
import ca.intelliware.commons.dependency.Layer;
import ca.intelliware.commons.dependency.Node;

public abstract class IntermediateToModelGenerator {
	
	private TypeConverter converter = new TypeConverter();
	protected final OutputUI outputUI;
	protected final File sourceFolder;
	protected final String basePackageName;
	private final File reportDir;
	private NamingPolicy namingPolicy;
	
	protected NamingPolicy getNamingPolicy() {
		return namingPolicy;
	}

	protected abstract ProgrammingLanguage getProgrammingLanguage();

	public IntermediateToModelGenerator(OutputUI outputUI, File sourceFolder, String basePackageName) {
		this(outputUI, sourceFolder, basePackageName, null);
	}
	public IntermediateToModelGenerator(OutputUI outputUI, File sourceFolder, String basePackageName, File reportDir) {
		this.outputUI = outputUI;
		this.sourceFolder = sourceFolder;
		this.basePackageName = basePackageName;
		this.reportDir = reportDir;
	}
	
	public IntermediateToModelGenerator(OutputUI outputUI, IntermediateToModelConfiguration configuration) {
		this.outputUI = outputUI;
		this.sourceFolder = configuration.getSourceFolder();
		this.basePackageName = configuration.getBasePackageName();
		this.reportDir = configuration.getReportDirectory();
		this.namingPolicy = configuration.getNamingPolicy();
	}

	public TypeAnalysisResult generate(MessageSet messageSet) throws IOException, GeneratorException {
		SimplifiableDefinitions definitions = new SimplifiableDefinitions();
		
		registerDomainInterfaces(messageSet);
		createTypes(messageSet, definitions);
		createRelationships(messageSet, definitions);
		createInteractions(messageSet, definitions);
		createChoiceStructures(messageSet, definitions);
		assignRelationshipsFromInterfaces(messageSet, definitions);
		
		simplify(definitions);
		
		excise(messageSet, definitions);
		
		TypeAnalysisResult result = createResultFromDefinitions(definitions);
		completeProcessing(result, messageSet, definitions);
		return result;
	}


	private void registerDomainInterfaces(MessageSet messageSet) {
		if (messageSet.isVocabularyDataPresent()) {
			registerDomainInterfaces(messageSet.getVocabulary());
		} else {
			// BCH: Consider whether or not we should support this case
			for (MessagePart messagePart : messageSet.getAllMessageParts()) {
				for (Relationship relationship : messagePart.getRelationships()) {
					if (relationship.isAttribute() && relationship.isCodedType() 
							&& StringUtils.isNotBlank(relationship.getDomainType())) {
						registerDomainInterface(relationship.getDomainType(), Collections.<String>emptyList());
					}
				}
			}
		}
	}

	/**
	 * <p>Register all vocabulary types</p>
	 * 
	 * <p>We want to register all concepts and value sets that we've defined but
	 * order matters.  We need to parents types before the types that specialize them.
	 * To help us out, we'll build up a dependency tree.
	 * 
	 * @param vocabulary
	 */
	private void registerDomainInterfaces(Vocabulary vocabulary) {
		DependencyManager<String> manager = new DependencyManager<String>();
		for (ConceptDomain concepDomain : vocabulary.getConceptDomains()) {
			if (concepDomain.getParentConceptDomains().isEmpty()) {
				manager.add(sanitize(concepDomain.getName()));
			} else {
				for (String parent : concepDomain.getParentConceptDomains()) {
					manager.add(sanitize(concepDomain.getName()), parent);
				}
			}
		}
		
		for (ValueSet valueSet : vocabulary.getValueSets()) {
			manager.add(sanitize(valueSet.getName()));
		}
		
		for (Layer<Node<String>> layer : manager.getNodeLayers()) {
			for (Node<String> node : layer.getContents()) {
				registerDomainInterface(node.getItem(), node.getEfferentCouplings());
			}
		}		
	}

	private void registerDomainInterface(String domainType, Collection<String> parents) {
		DomainRegistry.getInstance().register(domainType, PackageName.createDomainValuesPackage(this.basePackageName), parents);
	}

	/**
	 * <p>After processing the simplifications, some of our differences may have been 
	 * conditional on whether or not types merge.  If the types merge, then the difference
	 * is okay.  If the types don't merge, then we want to remove the options, including 
	 * any dependencies.
	 * @param messageSet 
	 * @param definitions
	 */
	protected void excise(MessageSet messageSet, SimplifiableDefinitions definitions) {
		
		Exciser exciser = new Exciser(messageSet, new PostSimplificationEvaluator(definitions, this.outputUI));
		Set<ExcisedItem> items = exciser.execute();
		try {
			new ExciseReportGenerator(items, new File(this.reportDir, "generatorExciseReport_secondPass.xls")).create();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		
		for (ExcisedItem excisedItem : items) {
			HasDifferences o = excisedItem.getItemWithDifferences();
			if (o instanceof MessagePart) {
				String name = ((Named) o).getName();
				this.outputUI.log(LogLevel.INFO, "Removing message part " + name);
				definitions.removeType(name);
			} else if (o instanceof Interaction) {
				String name = ((Named) o).getName();
				this.outputUI.log(LogLevel.INFO, "Removing interaction " + name);
				definitions.removeInteraction(name);
			}
		}
	}

	protected DefinitionToResultConverter getDefinitionToResultConverter(SimplifiableDefinitions definitions) {
		return new DefinitionToResultConverter(definitions, this.basePackageName, getProgrammingLanguage(), this.outputUI, getNamingPolicy());
	}
	
	private TypeAnalysisResult createResultFromDefinitions(SimplifiableDefinitions definitions) throws GeneratorException {
		return getDefinitionToResultConverter(definitions).convert();
	}
	
	public void simplify(SimplifiableDefinitions definitions) throws GeneratorException {
		new Case2Simplifier(this.outputUI, definitions).execute();
		new Case1Simplifier(this.outputUI, definitions).execute();
		new Case0Simplifier(this.outputUI, definitions).execute();
	}

	private void assignRelationshipsFromInterfaces(MessageSet messageSet, SimplifiableDefinitions definitions) {
		for (MessagePart messagePart : messageSet.getAllMessageParts()) {
			TypeName name = new TypeName(messagePart.getName());
			SimplifiableType simplifiableType = definitions.getType(messagePart.getName());

			if (!simplifiableType.getMessagePart().isAbstract() && !simplifiableType.getInterfaceTypes().isEmpty()) {
				this.outputUI.log(LogLevel.DEBUG, "Checking interface relationships for non-abstract type: " + name);
				addInterfaceRelationshipsForType(simplifiableType, simplifiableType.getRelationships(), definitions);
			}
			
			sortRelationships(simplifiableType);
		}
	}
	
	private void addInterfaceRelationshipsForType(SimplifiableType simplifiableType, List<SimplifiableRelationship> allRelationships, SimplifiableDefinitions definitions) {
		Set<String> interfaceTypes = simplifiableType.getInterfaceTypes();
		for (String interfaceName : interfaceTypes) {
			SimplifiableType interfaceType = definitions.getType(interfaceName);
			if (allRelationships.addAll(interfaceType.getRelationships())) {
				this.outputUI.log(LogLevel.DEBUG, "Added interface relationships for type: " + interfaceName);
			}
			addInterfaceRelationshipsForType(interfaceType, allRelationships, definitions);
		}
	}
	
	private void createChoiceStructures(MessageSet messageSet, SimplifiableDefinitions definitions) throws GeneratorException {
		for (MessagePart messagePart : messageSet.getAllMessageParts()) {
			String name = messagePart.getName();
			List<String> childs = messagePart.getSpecializationChilds();
			for (String childName : childs) {
				SimplifiableType simplifiableChildType = definitions.getType(childName);
				
				if (simplifiableChildType == null) {
					throw new GeneratorException("Type " + name + " has a specialization child " + childName + " which does not appear to be defined.");
				} else if (messagePart.isAbstract()) {
					simplifiableChildType.getInterfaceTypes().add(name);
				} else {
					this.outputUI.log(LogLevel.WARN, "Type " + name + " has specialization childs, but is not abstract");
				}
			}
		}
	}

	private void createInteractions(MessageSet messageSet, SimplifiableDefinitions definitions) {
		for (Interaction interaction : messageSet.getInteractions().values()) {
			definitions.addInteraction(new SimplifiableInteraction(interaction));
		}
	}

	private void createRelationships(MessageSet messageSet, SimplifiableDefinitions definitions) throws GeneratorException {
		for (MessagePart messagePart : messageSet.getAllMessageParts()) {
			SimplifiableType simplifiableType = definitions.getType(messagePart.getName());
			if (simplifiableType != null) {
				createRelationships(messagePart, simplifiableType, definitions);
			}
		}		
	}

	private void createRelationships(MessagePart messagePart, SimplifiableType simplifiableType, SimplifiableDefinitions definitions) throws GeneratorException {
		for (Relationship relationship : messagePart.getRelationships()) {
			if (relationship.isAttribute() && relationship.isFixed()) {
				// skip it
			} else {
				TemplateVariableGenerator generator = new TemplateVariableGenerator();
				simplifiableType.getRelationships().add(
						createRelationship(simplifiableType.getTypeName(), definitions, relationship, generator));
			}
		}
	}

	private void sortRelationships(SimplifiableType simplifiableType) {
		Collections.sort(simplifiableType.getRelationships(), new Comparator<SimplifiableRelationship>(){
			public int compare(SimplifiableRelationship o1, SimplifiableRelationship o2) {
				return new CompareToBuilder()
							.append(o1.getRelationship().getSortOrder(), o2.getRelationship().getSortOrder())
							.append(o1.getName(), o2.getName())
							.toComparison();
			}
		});
	}

	private SimplifiableRelationship createRelationship(TypeName name, SimplifiableDefinitions definitions,
			Relationship relationship, TemplateVariableGenerator generator) throws GeneratorException {
		
		if (relationship.isAttribute()) {
			DataType type = this.converter.convertToType(relationship);
			if (type == null) {
				throw new GeneratorException("Can't determine the type of " + relationship.getType() + " (property=" + name.toString() + "." + relationship.getName() + ")");
			} else {
				return new SimplifiableRelationship(relationship, type);
			}
		} else if (relationship.isTemplateRelationship()) {
			return new SimplifiableRelationship(relationship, generator.getNext(relationship.getTemplateParameterName()));
		} else {
			return new SimplifiableRelationship(relationship, definitions.getType(relationship.getType()));
		}
	}

	private void createTypes(MessageSet messageSet, SimplifiableDefinitions definitions) {
		for (PackageLocation packageLocation : messageSet.getPackageLocations().values()) {
			for (MessagePart messagePart : packageLocation.getMessageParts().values()) {
				definitions.addType(new SimplifiableType(messagePart, isRootType(messagePart, packageLocation), packageLocation.getCategory()));
			}
		}
	}

	private boolean isRootType(MessagePart messagePart, PackageLocation packageLocation) {
		String rootType = packageLocation.getRootType();
		return StringUtils.equals(rootType, messagePart.getName());
	}

	public void completeProcessing(TypeAnalysisResult result) throws IOException, GeneratorException {
		writeClasses(result);
		writeDomainInterfaces();
	}
	
	protected void completeProcessing(TypeAnalysisResult result, MessageSet messageSet, SimplifiableDefinitions definitions) throws IOException, GeneratorException {
		completeProcessing(result);
		writeReport(result, messageSet, definitions);
	}

	private void writeReport(TypeAnalysisResult result, MessageSet messageSet, SimplifiableDefinitions definitions) throws IOException {
		if (this.reportDir != null) {
			new ReportWriter(result, messageSet, this.outputUI, definitions).write(new File(this.reportDir, "simplificationReport.html"));
		}
	}

	protected abstract void writeClasses(TypeAnalysisResult result) throws IOException, GeneratorException;
	protected abstract void writeDomainInterfaces() throws IOException, GeneratorException;
}
