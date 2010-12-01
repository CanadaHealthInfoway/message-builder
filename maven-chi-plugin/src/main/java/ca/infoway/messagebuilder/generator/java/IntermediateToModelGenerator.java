package ca.infoway.messagebuilder.generator.java;

import static org.apache.commons.collections.CollectionUtils.isEmpty;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.CompareToBuilder;

import ca.infoway.messagebuilder.generator.DataType;
import ca.infoway.messagebuilder.generator.GeneratorException;
import ca.infoway.messagebuilder.generator.LogLevel;
import ca.infoway.messagebuilder.generator.OutputUI;
import ca.infoway.messagebuilder.generator.TypeConverter;
import ca.infoway.messagebuilder.generator.java.InteractionType.ArgumentType;
import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;
import ca.infoway.messagebuilder.generator.lang.TypeDocumentation;
import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;

public abstract class IntermediateToModelGenerator {
	
	private TypeConverter converter = new TypeConverter();
	protected final OutputUI outputUI;
	protected final File sourceFolder;
	protected final String basePackageName;
	private final File report;
	
	protected abstract ProgrammingLanguage getProgrammingLanguage();

	public IntermediateToModelGenerator(OutputUI outputUI, File sourceFolder, String basePackageName) {
		this(outputUI, sourceFolder, basePackageName, null);
	}
	public IntermediateToModelGenerator(OutputUI outputUI, File sourceFolder, String basePackageName, File report) {
		this.outputUI = outputUI;
		this.sourceFolder = sourceFolder;
		this.basePackageName = basePackageName;
		this.report = report;
	}
	
	public TypeAnalysisResult generate(MessageSet messageSet) throws IOException, GeneratorException {
		TypeAnalysisResult result = new TypeAnalysisResult();
		SimplifiableDefinitions definitions = new SimplifiableDefinitions();
		
		createTypes(messageSet, result, definitions);
		createRelationships(messageSet, result, definitions);
		createInteractions(messageSet, result, definitions);
		createChoiceStructures(messageSet, result, definitions);
		assignRelationshipsFromInterfaces(messageSet, result, definitions);
		
		simplify(result, definitions);
		
		result = createResultFromDefinitions(definitions);
		completeProcessing(result, messageSet, definitions);
		return result;
	}


	protected TypeAnalysisResult createResultFromDefinitions(
			SimplifiableDefinitions definitions) throws GeneratorException {
		return new DefinitionToResultConverter(definitions, this.basePackageName, getProgrammingLanguage()).convert();
	}
	public void simplify(TypeAnalysisResult result, SimplifiableDefinitions definitions) throws GeneratorException {
		new Case2Simplifier(this.outputUI, result, definitions).execute();
		new Case1Simplifier(this.outputUI, result, definitions).execute();
		new Case0Simplifier(this.outputUI, result, definitions).execute();
	}

	private void assignRelationshipsFromInterfaces(MessageSet messageSet, TypeAnalysisResult result, SimplifiableDefinitions definitions) {
		for (MessagePart messagePart : messageSet.getAllMessageParts()) {
			TypeName name = new TypeName(messagePart.getName());
			Type type = result.getTypes().get(name);
			SimplifiableType simplifiableType = definitions.getType(messagePart.getName());

			if (!simplifiableType.getMessagePart().isAbstract() && !simplifiableType.getInterfaceTypes().isEmpty()) {
				this.outputUI.log(LogLevel.DEBUG, "Checking interface relationships for non-abstract type: " + name);
				addInterfaceRelationshipsForType(type, type.getRelationships(), result);
				addInterfaceRelationshipsForType(simplifiableType, simplifiableType.getRelationships(), definitions);
			}
			
			sortRelationships(type);
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
	
	private void addInterfaceRelationshipsForType(Type type, List<BaseRelationship> allRelationships, TypeAnalysisResult result) {
		Set<RenderedType> interfaceTypes = type.getInterfaceTypes();
		for (RenderedType interfaceType : interfaceTypes) {
//			Type interfaceType = result.getTypes().get(interfaceTypeName.getTypeName());
			if (allRelationships.addAll(interfaceType.getRelationships())) {
				this.outputUI.log(LogLevel.DEBUG, "Added interface relationships for type: " + interfaceType);
			}
			addInterfaceRelationshipsForType((Type) interfaceType, allRelationships, result);
		}
	}
	
	private void createChoiceStructures(MessageSet messageSet, TypeAnalysisResult result, SimplifiableDefinitions definitions) throws GeneratorException {
		for (MessagePart messagePart : messageSet.getAllMessageParts()) {
			TypeName name = new TypeName(messagePart.getName());
			Type type = result.getTypes().get(name);
			
			List<String> childs = messagePart.getSpecializationChilds();
			for (String childName : childs) {
				Type childType = result.getTypes().get(new TypeName(childName));
				SimplifiableType simplifiableChildType = definitions.getType(childName);
				
				if (simplifiableChildType == null) {
					throw new GeneratorException("Type " + name + " has a specialization child " + childName + " which does not appear to be defined.");
				} else if (type.isAbstract()) {
					childType.getInterfaceTypes().add(type);
					type.getChildTypes().add(childType);
					simplifiableChildType.getInterfaceTypes().add(messagePart.getName());
				} else {
					this.outputUI.log(LogLevel.WARN, "Type " + name + " has specialization childs, but is not abstract");
				}
			}
		}
	}

	private void createInteractions(MessageSet messageSet, TypeAnalysisResult result, SimplifiableDefinitions definitions) {
		for (Interaction interaction : messageSet.getInteractions().values()) {
			definitions.addInteraction(new SimplifiableInteraction(interaction));
			InteractionType messageType = new InteractionType(new TypeName(interaction.getName()));
			TypeName parentTypeName = new TypeName(interaction.getSuperTypeName());
			messageType.setParentType(result.getTypeByName(parentTypeName));
			messageType.setTypeDocumentation(new TypeDocumentation(interaction.getDocumentation()));
			messageType.setBusinessName(interaction.getBusinessName());
			messageType.getArguments().addAll(groupArgumentsAndTypes(interaction.getArguments(), result.getTypes()));
			result.getTypes().put(messageType.getTypeName(), messageType);
		}
	}

	private List<ArgumentType> groupArgumentsAndTypes(List<Argument> arguments, Map<TypeName, Type> types) {
		List<ArgumentType> result = new ArrayList<ArgumentType>();
		for (Argument argument : arguments) {
			TypeName typeName = new TypeName(argument.getName());
			ArgumentType argumentType = new ArgumentType(argument, typeName);
			argumentType.getArgumentTypes().addAll(groupArgumentsAndTypes(argument.getArguments(), types));
			result.add(argumentType);
			
		}
		return result;
	}
	private void createRelationships(MessageSet messageSet, TypeAnalysisResult result, SimplifiableDefinitions definitions) throws GeneratorException {
		for (MessagePart messagePart : messageSet.getAllMessageParts()) {
			TypeName name = new TypeName(messagePart.getName());
			Type type = result.getTypes().get(name);
			SimplifiableType simplifiableType = definitions.getType(messagePart.getName());
			if (type != null) {
				createRelationships(messagePart, type, simplifiableType, result, definitions);
			}
		}		
	}

	private void createRelationships(MessagePart messagePart, Type type, SimplifiableType simplifiableType, TypeAnalysisResult result, SimplifiableDefinitions definitions) throws GeneratorException {
		TemplateVariableGenerator generator = new TemplateVariableGenerator();
		TemplateVariableGenerator generator2 = new TemplateVariableGenerator();
		
		for (Relationship relationship : messagePart.getRelationships()) {
			if (relationship.isAttribute() && relationship.isFixed()) {
				// skip it
			} else {
				type.getRelationships().add(createRelationship(type.getTypeName(), result, relationship, generator));
				simplifiableType.getRelationships().add(createRelationship(type.getTypeName(), definitions, relationship, generator2));
			}
		}
	}

	private void sortRelationships(Type type) {
		Collections.sort(type.getRelationships(), new Comparator<BaseRelationship>(){
			public int compare(BaseRelationship o1, BaseRelationship o2) {
				return new CompareToBuilder()
							.append(o1.getSortKey(), o2.getSortKey())
							.append(o1.getName(), o2.getName())
							.toComparison();
			}
		});
	}

	private BaseRelationship createRelationship(TypeName name, TypeAnalysisResult result,
			Relationship relationship, TemplateVariableGenerator generator) throws GeneratorException {
		
		if (relationship.isAttribute()) {
			DataType type = this.converter.convertToType(relationship);
			if (type == null) {
				throw new GeneratorException("Can't determine the type of " + relationship.getType() + " (property=" + name.toString() + "." + relationship.getName() + ")");
			} else {
				return new Attribute(relationship, type);
			}
		} else if (relationship.isTemplateRelationship()) {
			return Association.createTemplateAssociation(relationship, generator.getNext(relationship.getTemplateParameterName()));
		} else {
			return Association.createStandardAssociation(relationship, 
					getTypeCorrespondingTo(result, relationship));
		}
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

	private Type getTypeCorrespondingTo(
			TypeAnalysisResult result,
			Relationship relationship) {
		return result.getTypes().get(new TypeName(relationship.getType()));
	}

	private void createTypes(MessageSet messageSet, TypeAnalysisResult result, SimplifiableDefinitions definitions) {
		for (PackageLocation packageLocation : messageSet.getPackageLocations().values()) {
			
			for (MessagePart messagePart : packageLocation.getMessageParts().values()) {
				TypeName name = new TypeName(messagePart.getName());
				Type type = new Type(name, isRootType(messagePart, packageLocation));
				
				definitions.addType(new SimplifiableType(messagePart, isRootType(messagePart, packageLocation), packageLocation.getCategory()));
				
				type.setCategory(packageLocation.getCategory());
				if (messagePart.getDocumentation() != null) {
					type.setBusinessName(messagePart.getDocumentation().getBusinessName());
					if(!isEmpty(messagePart.getDocumentation().getParagraphs())) {
						type.setTypeDocumentation(new TypeDocumentation(messagePart.getDocumentation()));
					}
				}
				type.setAbstract(messagePart.isAbstract());
				result.addType(type);
			}
		}
	}

	private boolean isRootType(MessagePart messagePart, PackageLocation packageLocation) {
		String rootType = packageLocation.getRootType();
		return StringUtils.equals(rootType, messagePart.getName());
	}

	public void completeProcessing(TypeAnalysisResult result) throws IOException, GeneratorException {
		writeClasses(result);
	}
	
	protected void completeProcessing(TypeAnalysisResult result, MessageSet messageSet, SimplifiableDefinitions definitions) throws IOException, GeneratorException {
		completeProcessing(result);
		writeReport(result, messageSet, definitions);
	}

	private void writeReport(TypeAnalysisResult result, MessageSet messageSet, SimplifiableDefinitions definitions) throws IOException {
		if (this.report != null) {
			new ReportWriter(result, messageSet, this.outputUI, definitions).write(this.report);
		}
	}

	protected abstract void writeClasses(TypeAnalysisResult result) throws IOException, GeneratorException;
}
