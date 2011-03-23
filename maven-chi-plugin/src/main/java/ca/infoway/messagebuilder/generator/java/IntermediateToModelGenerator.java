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

	public IntermediateToModelGenerator(OutputUI outputUI, File sourceFolder, String basePackageName) {
		this(outputUI, sourceFolder, basePackageName, null);
	}
	public IntermediateToModelGenerator(OutputUI outputUI, File sourceFolder, String basePackageName, File report) {
		this.outputUI = outputUI;
		this.sourceFolder = sourceFolder;
		this.basePackageName = basePackageName;
		this.report = report;
	}
	
	public void generate(MessageSet messageSet) throws IOException, GeneratorException {
		TypeAnalysisResult result = resultify(messageSet);
		completeProcessing(result, messageSet);
		
	}
	
	public TypeAnalysisResult resultify(MessageSet messageSet) throws GeneratorException {
		TypeAnalysisResult result = new TypeAnalysisResult();

		createTypes(messageSet, result);
		createRelationships(messageSet, result);
		createInteractions(messageSet, result);
		assignSuperTypes(messageSet, result);
		assignRelationshipsFromInterfaces(messageSet, result);
		
		simplify(result);
		return result;
	}


	public void simplify(TypeAnalysisResult result) throws GeneratorException {
		new Case2Simplifier(this.outputUI, result).execute();
		new Case1Simplifier(this.outputUI, result).execute();
		new Case0Simplifier(this.outputUI, result).execute();
	}

	private void assignRelationshipsFromInterfaces(MessageSet messageSet, TypeAnalysisResult result) {
		for (MessagePart messagePart : messageSet.getAllMessageParts()) {
			TypeName name = new TypeName(messagePart.getName());
			Type type = result.getTypes().get(name);

			if (!type.isAbstract() && !type.getInterfaceTypes().isEmpty()) {
				this.outputUI.log(LogLevel.DEBUG, "Checking interface relationships for non-abstract type: " + name);
				addInterfaceRelationshipsForType(type, type.getRelationships(), result);
			}
			
			sortRelationships(type);
		}
	}
	
	private void addInterfaceRelationshipsForType(Type type, List<BaseRelationship> allRelationships, TypeAnalysisResult result) {
		Set<TypeName> interfaceTypes = type.getInterfaceTypes();
		for (TypeName interfaceTypeName : interfaceTypes) {
			Type interfaceType = result.getTypes().get(interfaceTypeName);
			if (allRelationships.addAll(interfaceType.getRelationships())) {
				this.outputUI.log(LogLevel.DEBUG, "Added interface relationships for type: " + interfaceTypeName);
			}
			addInterfaceRelationshipsForType(interfaceType, allRelationships, result);
		}
	}
	
	private void assignSuperTypes(MessageSet messageSet, TypeAnalysisResult result) throws GeneratorException {
		for (MessagePart messagePart : messageSet.getAllMessageParts()) {
			TypeName name = new TypeName(messagePart.getName());
			Type type = result.getTypes().get(name);
			
			List<String> childs = messagePart.getSpecializationChilds();
			for (String childName : childs) {
				Type childType = result.getTypes().get(new TypeName(childName));
				
				if (childType == null) {
					throw new GeneratorException("Type " + name + " has a specialization child " + childName + " which does not appear to be defined.");
				} else if (type.isAbstract()) {
					childType.getInterfaceTypes().add(name);
					type.getChildTypes().add(childType.getName());
				} else {
					this.outputUI.log(LogLevel.WARN, "Type " + name + " has specialization childs, but is not abstract");
				}
			}
		}
	}

	private void createInteractions(MessageSet messageSet, TypeAnalysisResult result) {
		for (Interaction interaction : messageSet.getInteractions().values()) {
			InteractionType messageType = new InteractionType(new TypeName(interaction.getName()));
			TypeName parentTypeName = new TypeName(interaction.getSuperTypeName());
			messageType.setParentType(parentTypeName);
			messageType.setTypeDocumentation(new TypeDocumentation(interaction.getDocumentation()));
			messageType.setBusinessName(interaction.getBusinessName());
			messageType.getArguments().addAll(groupArgumentsAndTypes(interaction.getArguments(), result.getTypes()));
			result.getTypes().put(messageType.getName(), messageType);
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
	private void createRelationships(MessageSet messageSet, TypeAnalysisResult result) throws GeneratorException {
		for (MessagePart messagePart : messageSet.getAllMessageParts()) {
			TypeName name = new TypeName(messagePart.getName());
			Type type = result.getTypes().get(name);
			if (type != null) {
				createRelationships(messagePart, type, result);
			}
		}		
	}

	private void createRelationships(MessagePart messagePart, Type type, TypeAnalysisResult result) throws GeneratorException {
		TemplateVariableGenerator generator = new TemplateVariableGenerator();
		
		for (Relationship relationship : messagePart.getRelationships()) {
			if (relationship.isAttribute() && relationship.isFixed()) {
				// skip it
			} else {
				type.getRelationships().add(createRelationship(type.getName(), result, relationship, generator, type.getRelationships().size()));
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
			Relationship relationship, TemplateVariableGenerator generator, int sortKey) throws GeneratorException {
		
		if (relationship.isAttribute()) {
			DataType type = this.converter.convertToType(relationship);
			if (type == null) {
				throw new GeneratorException("Can't determine the type of " + relationship.getType() + " (property=" + name.toString() + "." + relationship.getName() + ")");
			} else {
				return new Attribute(relationship, type);
			}
		} else if (relationship.isTemplateRelationship()) {
			return Association.createTemplateAssociation(relationship, generator.getNext(relationship.getTemplateParameterName()), sortKey);
		} else {
			return Association.createStandardAssociation(relationship, 
					getTypeCorrespondingTo(result, relationship), sortKey);
		}
	}

	private Type getTypeCorrespondingTo(
			TypeAnalysisResult result,
			Relationship relationship) {
		return result.getTypes().get(new TypeName(relationship.getType()));
	}

	private void createTypes(MessageSet messageSet, TypeAnalysisResult result) {
		for (PackageLocation packageLocation : messageSet.getPackageLocations().values()) {
			
			for (MessagePart messagePart : packageLocation.getMessageParts().values()) {
				TypeName name = new TypeName(messagePart.getName());
				Type type = new Type(name, isRootType(messagePart, packageLocation));
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
	
	protected void completeProcessing(TypeAnalysisResult result, MessageSet messageSet) throws IOException, GeneratorException {
		completeProcessing(result);
		writeReport(result, messageSet);
	}

	private void writeReport(TypeAnalysisResult result, MessageSet messageSet) throws IOException {
		if (this.report != null) {
			new ReportWriter(result, messageSet, this.outputUI).write(this.report);
		}
	}

	protected abstract void writeClasses(TypeAnalysisResult result) throws IOException, GeneratorException;
}
