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
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.generator.lang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.TypeName;

public class InteractionType extends Type {

	private static final long serialVersionUID = 6689684820345539035L;

	public static class ArgumentType {
		private final TypeName typeName;
		private final Argument argument;
		private final List<ArgumentType> argumentTypes = Collections.synchronizedList(new ArrayList<ArgumentType>());

		public ArgumentType(Argument argument, TypeName typeName) {
			this.argument = argument;
			this.typeName = typeName;
		}
		public TypeName getType() {
			return this.typeName;
		}
		
		public Argument getArgument() {
			return this.argument;
		}
		public List<ArgumentType> getArgumentTypes() {
			return this.argumentTypes;
		}
		/**
		 * <p>We've taken some care to ensure that template variables use names like 
		 * "PL" for "ParameterList" and "RR" for "RegisteredRole", so that we can 
		 * later try to more easily associate one with the other.  We're always going to 
		 * show those template parameters in alphabetical order.
		 */
		public static List<ArgumentType> sort(List<ArgumentType> arguments) {
			TemplateVariableGenerator generator = new TemplateVariableGenerator();
			Map<String,ArgumentType> result = new TreeMap<String, ArgumentType>();
			for (ArgumentType argumentType : arguments) {
				TemplateVariable variable = generator.getNext(argumentType.getArgument().getTemplateParameterName());
				result.put(variable.getType(), argumentType);
			}
			return new ArrayList<ArgumentType>(result.values());
		}
		
		
	}
	
	private final List<ArgumentType> arguments = Collections.synchronizedList(new ArrayList<ArgumentType>());
	private Type parentType;

	public Type getParentType() {
		return this.parentType;
	}

	public InteractionType(TypeName typeName) {
		super(typeName);
	}

	public List<ArgumentType> getArguments() {
		return this.arguments;
	}

	public void setParentType(Type typeName) {
		this.parentType = typeName;
	}

	public boolean hasParent() {
		return this.parentType != null;
	}
}
