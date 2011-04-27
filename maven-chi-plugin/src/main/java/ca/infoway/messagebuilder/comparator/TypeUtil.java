/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.comparator;

import japa.parser.ast.type.ClassOrInterfaceType;
import japa.parser.ast.type.PrimitiveType;
import japa.parser.ast.type.ReferenceType;
import japa.parser.ast.type.Type;
import japa.parser.ast.type.VoidType;

public class TypeUtil {

	public static String getTypeName(Type type) {
		if (type instanceof ClassOrInterfaceType) {
			return ((ClassOrInterfaceType)type).getName();
		} else if (type instanceof PrimitiveType) {
			return ((PrimitiveType)type).getType().name();
		} else if (type instanceof ReferenceType) {
			return ((ClassOrInterfaceType)((ReferenceType)type).getType()).getName();
		} else if (type instanceof VoidType) {
			return "void";
		} else {
			return null;
		}
	}

}
