package ca.infoway.messagebuilder.generator.regen;

import java.io.File;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.ObjectUtils;

import ca.infoway.messagebuilder.generator.LogLevel;
import ca.infoway.messagebuilder.generator.OutputUI;
import ca.infoway.messagebuilder.generator.java.InteractionType;
import ca.infoway.messagebuilder.generator.java.IntermediateToJavaGenerator;
import ca.infoway.messagebuilder.generator.java.Type;
import ca.infoway.messagebuilder.generator.java.TypeAnalysisResult;
import ca.infoway.messagebuilder.generator.lang.TypeDocumentation;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.MessageSetMarshaller;
import ca.infoway.messagebuilder.xml.TypeName;

public class MergeTypeUtil {

	public MergeTypeUtil() {
	}
	
	public Type mergeTypes(Type oldType, Type newType) {
		
		// assume same TypeName; throw exception if different (might change)
		TypeName typeName = validateTypeNamesMatch(oldType, newType);
		
		boolean isRootType = mergeRootType(oldType, newType);
		Type resultType = createType(typeName, isRootType, oldType, newType);

		// the following properties should not be different - error condition otherwise
		mergeCategory(resultType, oldType, newType);
		mergeIsAbstract(resultType, oldType, newType);
		
		// the following properties default to the more recent value (by convention, the first argument)
		mergeJavadoc(resultType, oldType, newType);
		mergeBusinessName(resultType, oldType.getBusinessName(), newType.getBusinessName());
		
		// the following properties are merged with the union of their types
		mergeInterfaceTypes(resultType, oldType.getInterfaceTypes(), newType.getInterfaceTypes());
		mergeChildTypes(resultType, oldType.getChildTypes(), newType.getChildTypes());
		mergeMergedTypes(resultType, oldType.getMergedTypes(), newType.getMergedTypes());
		
		mergeInteractions(resultType, oldType, newType);
		
		mergeRelationships(resultType, oldType, newType);
		
		return resultType;
	}

	private void mergeMergedTypes(Type resultType, Set<TypeName> oldMergedTypes, Set<TypeName> newMergedTypes) {
		// the result of merging merged types is the union of all types
		resultType.getMergedTypes().addAll(newMergedTypes);
		resultType.getMergedTypes().addAll(oldMergedTypes);
	}

	private void mergeInteractions(Type resultType, Type oldType, Type newType) {
		if (resultType instanceof InteractionType) {
			InteractionType resultInteractionType = (InteractionType) resultType;
			InteractionType newInteractionType = (InteractionType) newType;
			
			// from a Java generation perspective, the interaction info might not be interesting
			// but xsd generation does seem to make use of interaction
			
			// should interactions just take the newer InteractionType properties and not merge?
			// we will take newer interaction properties for now

			// just adding all the arguments might not be safe; should consider adding a clone of each argument
			resultInteractionType.setParentType(newInteractionType.getParentType());
			resultInteractionType.getArguments().addAll(newInteractionType.getArguments());
		}
	}
	
	private Type createType(TypeName typeName, boolean isRootType, Type oldType, Type newType) {
		if (oldType instanceof InteractionType != newType instanceof InteractionType) {
			error("Can not merge interaction with non-interaction", oldType, newType);
		}
		return (oldType instanceof InteractionType ? new InteractionType(typeName) : new Type(typeName, isRootType));
	}

	private TypeName validateTypeNamesMatch(Type oldType, Type newType) {
		TypeName newName = newType.getName();
		TypeName oldName = oldType.getName();
		if (differentTypeName(oldName, newName)) {
			error("Can not merge types with different TypeNames", oldType, newType);
		}
		return newName;
	}

	private boolean differentTypeName(TypeName oldName, TypeName newName) {
		return newName == null || oldName == null || !newName.equals(oldName);
	}

	private boolean mergeRootType(Type oldType, Type newType) {
		if (newType.isRootType() != oldType.isRootType()) {
			error("Merging types must both be root or non-root", oldType, newType);
		}
		return newType.isRootType();
	}

	private void mergeCategory(Type resultType, Type oldType, Type newType) {
		if (!ObjectUtils.equals(newType.getCategory(), oldType.getCategory())) {
			error("Merging types must have same category", oldType, newType);
		}
		resultType.setCategory(newType.getCategory());
	}

	private void mergeBusinessName(Type resultType, String oldBusinessName, String newBusinessName) {
		// most recent businessName should win - this is, by CONVENTION, assumed to be the first argument
		resultType.setBusinessName(newBusinessName);
	}

	private void mergeIsAbstract(Type resultType, Type oldType, Type newType) {
		if (newType.isAbstract() != oldType.isAbstract()) {
			error("Merging types must be abstract or non-abstract", oldType, newType);
		}
		resultType.setAbstract(newType.isAbstract());
	}

	private void mergeChildTypes(Type resultType, Set<TypeName> oldChildTypes, Set<TypeName> newChildTypes) {
		// the result of merging interface types is the union of all types
		resultType.getChildTypes().addAll(newChildTypes);
		resultType.getChildTypes().addAll(oldChildTypes);
	}

	private void mergeInterfaceTypes(Type resultType, Set<TypeName> oldInterfaceTypes, Set<TypeName> newInterfaceTypes) {
		// the result of merging interface types is the union of all types
		resultType.getInterfaceTypes().addAll(newInterfaceTypes);
		resultType.getInterfaceTypes().addAll(oldInterfaceTypes);
	}

	private void mergeRelationships(Type resultType, Type oldType, Type newType) {
		new TypeRelationshipsMerger(oldType, newType).mergeInto(resultType);
	}

	private void mergeJavadoc(Type resultType, Type oldMatchingType, Type newMatchingType) {
		// most recent javadoc should win - this is, by CONVENTION, assumed to be the first argument
		TypeDocumentation mostRecentJdoc = newMatchingType.getTypeDocumentation();
		resultType.setTypeDocumentation(mostRecentJdoc);
	}

	private void error(String message, Type oldType, Type newType) {
		throw new MergeTypeException(message +" [" + newType.getName() + ", " + oldType.getName() + "]");
//		System.out.println(">>>>>>>>>>>>" + message +" [" + newType.getName() + ", " + oldType.getName() + "]");
	}
	
	public static void main(String[] args) throws Exception {
		File oldMessageSet = new File("/home/administrator/workspace/message-builder/message-builder-release-v01_r04_3/src/main/resources/messageSet_v01r04_3_hotfix3.xml");
		MessageSet oldMessages = new MessageSetMarshaller().unmarshall(oldMessageSet);

		File newMessageSet = new File("/home/administrator/workspace/message-builder/message-builder-release-r02_04_02/src/main/resources/messageSet_r02_04_02.xml");
		MessageSet newMessages = new MessageSetMarshaller().unmarshall(newMessageSet);
		
		File javaSourceFolder = null;
		
		IntermediateToJavaGenerator generator = new IntermediateToJavaGenerator(
				new OutputUI() {
					public void log(LogLevel level, String message) {
					}
				}, javaSourceFolder, "", null);
		
		TypeAnalysisResult oldTypeAnalysisResult = generator.resultify(oldMessages);
		TypeAnalysisResult newTypeAnalysisResult = generator.resultify(newMessages);
		
		Map<TypeName, Type> oldTypes = oldTypeAnalysisResult.getTypes();
		Map<TypeName, Type> newTypes = newTypeAnalysisResult.getTypes();
		
		for (TypeName typeName : oldTypes.keySet()) {
			Type oldType = oldTypes.get(typeName);
			Type newType = newTypes.get(typeName);
			if (newType!=null) {
				new MergeTypeUtil().mergeTypes(oldType, newType);
			}
		}
		
	}
}
