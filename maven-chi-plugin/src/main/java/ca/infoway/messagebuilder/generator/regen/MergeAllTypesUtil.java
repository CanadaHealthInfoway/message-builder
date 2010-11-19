package ca.infoway.messagebuilder.generator.regen;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import ca.infoway.messagebuilder.generator.java.IntermediateToJavaGenerator;
import ca.infoway.messagebuilder.generator.java.Type;
import ca.infoway.messagebuilder.generator.java.TypeAnalysisResult;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.MessageSetMarshaller;
import ca.infoway.messagebuilder.xml.TypeName;

public class MergeAllTypesUtil {

	private final MessageSetMarshaller marshaller;
	private final IntermediateToJavaGenerator generator;

	public MergeAllTypesUtil(MessageSetMarshaller marshaller, IntermediateToJavaGenerator generator) {
		this.marshaller = marshaller;
		this.generator = generator;
	}
	
	public void generate(List<File> files) throws Exception {

		List<TypeAnalysisResult> convertedMessageSets = new ArrayList<TypeAnalysisResult>();
		for (File messageSet : files) {
			MessageSet convertedMessageSet = this.marshaller.unmarshall(messageSet);
			TypeAnalysisResult typeAnalysisResult = this.generator.resultify(convertedMessageSet);
			convertedMessageSets.add(typeAnalysisResult);
		}

		TypeAnalysisResult mergedTypes = convertedMessageSets.get(0);
		for (int i = 1, length = convertedMessageSets.size(); i < length; i++) {
			mergedTypes = this.merge(mergedTypes, convertedMessageSets.get(i));
		}

		// should likely simplify the merged results at this stage - might end up removing
//		this.generator.simplify(mergedTypes);
		
		this.generator.completeProcessing(mergedTypes);
		
	}

	public TypeAnalysisResult merge(TypeAnalysisResult oldTypesResult, TypeAnalysisResult newTypesResult) {
		
		TypeAnalysisResult mergedResult = new TypeAnalysisResult();
		
		Map<TypeName, Type> oldTypes = new LinkedHashMap<TypeName, Type>(oldTypesResult.getTypes());
		Map<TypeName, Type> newTypes = new LinkedHashMap<TypeName, Type>(newTypesResult.getTypes());

		for (TypeName typeName : oldTypes.keySet()) {
			Type oldType = oldTypes.get(typeName);
			Type newType = newTypes.remove(typeName);
			
			Type mergedType = oldType;
			if (newType != null) {
				mergedType = new MergeTypeUtil().mergeTypes(oldType, newType);
			}
			mergedResult.addType(mergedType); // handles packages
		}
		
		for (Type type : newTypes.values()) {
			mergedResult.addType(type);
		}
		
		// FIXME - TM/AG - need to consider how to merge "removed" types (???)
		//                - re-generation is effectively broken for backwards compatibility until this is resolved
		// - need to consider case where a type has been removed in both
		// - need to consider case where a type is removed in one and not removed in the other
		// - since removed types are used to generate a class name, how can we ensure that a name is chosen that
		//   satisfies all previous APIs in the re-gen?
		
//		mergedResult.getRemovedTypes().putAll(newTypesResult.getRemovedTypes());
//		mergedResult.getRemovedTypes().putAll(oldTypesResult.getRemovedTypes());
		
		// need to be concerned with merging packages ??? 
		// addType() creates packages, but what if a pair of merged types has different packages?? (can this even happen?)

		return mergedResult;
	}
	
}
