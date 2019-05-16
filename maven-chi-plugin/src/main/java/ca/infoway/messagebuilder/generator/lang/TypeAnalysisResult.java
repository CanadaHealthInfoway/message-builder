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
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Predicate;

import ca.infoway.messagebuilder.xml.TypeName;

public class TypeAnalysisResult implements TypeProvider, TypeNameHelper {

    protected final Map<TypeName,Type> types = Collections.synchronizedMap(new LinkedHashMap<TypeName,Type>());
    protected final Map<TypeName,ComplexTypePackage> packages = Collections.synchronizedMap(new LinkedHashMap<TypeName,ComplexTypePackage>());
    
	public void addType(Type type) {
		TypeName rootName = type.getTypeName().getRootName();
		if (!this.packages.containsKey(rootName)) {
			this.packages.put(rootName, new ComplexTypePackage(rootName));
		}
		this.packages.get(rootName).addInnerClass(type.getTypeName().getName(), type);
		this.types.put(type.getTypeName(), type);
	}
	
	public Map<TypeName, Type> getTypes() {
		return this.types;
	}

	public Collection<ComplexTypePackage> getAllPackages() {
		return new ArrayList<ComplexTypePackage>(this.packages.values());
	}

	public void removeType(Type type) {
		TypeName rootName = type.getTypeName().getRootName();
		if (this.packages.containsKey(rootName)) {
			this.packages.get(rootName).removeInnerClass(type.getTypeName());
		}
		this.types.remove(type.getTypeName());
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Type> getAllMessageTypes() {
		return filter(new Predicate<Type>() {
			public boolean apply(Type input) {
				return !(input instanceof InteractionType);
			}
		});
	}
	
	@SuppressWarnings("unchecked")
	public Collection<InteractionType> getAllInteractions() {
		return filter(new Predicate<Type>() {
			public boolean apply(Type input) {
				return input instanceof InteractionType;
			}
		});
	}

	@SuppressWarnings("unchecked")
	private Collection filter(Predicate<Type> predicate) {
		List<Type> result = new ArrayList<Type>();
		for (Type type : this.types.values()) {
			if (predicate.apply(type)) {
				result.add(type);
			}
		}
		return result;
	}

	/**
	 * <p>Returns information about type name, whether or not it has been removed.
	 */
	public Type getNamedType(TypeName name) {
		if (this.types.containsKey(name)) {
			return this.types.get(name);
		} else {
			return null;
		}
	}

	/**
	 * <p>Indicates whether or not a type is abstract.
	 */
	public boolean isAbstract(TypeName name) {
		Type type = (Type) getNamedType(name);
		return type == null ? false : type.isAbstract();
	}

	public Type getTypeByName(TypeName name) {
		return this.types.get(name);
	}

}
