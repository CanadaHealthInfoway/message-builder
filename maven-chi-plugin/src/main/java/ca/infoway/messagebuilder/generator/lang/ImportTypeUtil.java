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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2014-03-17 14:28:03 -0400 (Mon, 17 Mar 2014) $
 * Revision:      $LastChangedRevision: 8461 $
 */

package ca.infoway.messagebuilder.generator.lang;

import static ca.infoway.messagebuilder.generator.util.ProgrammingLanguage.JAVA;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ca.infoway.messagebuilder.generator.lang.InteractionType.ArgumentType;
import ca.infoway.messagebuilder.generator.util.ProgrammingLanguage;

public class ImportTypeUtil {
	
	private static Set<Object> getImports(InteractionType type, ProgrammingLanguage language) {
		Set<Object> importTypes = new HashSet<Object>();
		if (language == ProgrammingLanguage.C_SHARP) {
			importTypes.add("Ca.Infoway.Messagebuilder.Annotation.Hl7PartTypeMapping");
			importTypes.add("Ca.Infoway.Messagebuilder.Model.IInteraction");
		} else {
			importTypes.add("ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping");
			importTypes.add("ca.infoway.messagebuilder.model.InteractionBean");
		}
		Type parentType = ((InteractionType) type).getParentType();
		if (parentType != null) {
			importTypes.add(parentType.getLanguageSpecificName().getFullyQualifiedName());
		}
		addArgumentTypes(importTypes, type.getArguments());
		return importTypes;
	}
	private static void addArgumentTypes(Set<Object> importTypes,
			List<ArgumentType> arguments) {
		for (ArgumentType argument : arguments) {
			importTypes.add(argument.getType());
			addArgumentTypes(importTypes, argument.getArgumentTypes());
		}
	}
	private static Set<Object> getImports(Type type, ProgrammingLanguage language) {
		
		Set<Object> importTypes = new HashSet<Object>();
		
		importTypes.add("ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping");
		if (!type.isAbstract()) {
			importTypes.add(language == JAVA 
					? "ca.infoway.messagebuilder.model.MessagePartBean" 
					: "Ca.Infoway.Messagebuilder.Model.MessagePartBean");
		}
		if (type.isRootType()) {
			importTypes.add("ca.infoway.messagebuilder.annotation.Hl7RootType");
		}
		
		// add imports for all relationships, even if type is abstract
		for (BaseRelationship relationship : type.getRelationships()) {
			if (!relationship.isFixed()) {
				boolean parentTypeIsMerged = type.getPartTypeMapping().length > 1;
				importTypes.addAll(relationship.getImportTypes(parentTypeIsMerged, type.isAbstract()));
			}
		}
		
		importTypes.addAll(type.getInterfaceTypes());
		return importTypes;
	}

	public static Set<Object> getImports(RenderedType type, ProgrammingLanguage language) {
		if (type instanceof InteractionType) {
			return getImports((InteractionType) type, language);
		} else if (type instanceof Type) {
			return getImports((Type) type, language);
		} else {
			throw new IllegalArgumentException("RenderedType is not supported");
		}
	}
}
