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

package ca.infoway.messagebuilder.generator.java;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import ca.infoway.messagebuilder.xml.TypeName;

class Case3MergeResult implements TypeNameSubstituter {
	
	class TypeNameTuple {
		private final TypeName name1;
		private final TypeName name2;
		public TypeNameTuple(TypeName name1, TypeName name2) {
			this.name1 = name1.getName().compareTo(name2.getName()) < 0 ? name1 : name2;
			this.name2 = name1.getName().compareTo(name2.getName()) < 0 ? name2 : name1;
		}
		public int hashCode() {
			return new HashCodeBuilder().append(this.name1).append(this.name2).toHashCode();
		}
		@Override
		public boolean equals(Object obj) {
			if (obj == null) {
				return false;
			} else if (obj == this) {
				return true;
			} else if (obj.getClass() != getClass()) {
				return false;
			} else {
				TypeNameTuple that = (TypeNameTuple) obj;
				return new EqualsBuilder().append(this.name1, that.name1)
						.append(this.name2, that.name2).isEquals();
			}
		}
	}

	private Set<TypeNameTuple> unmergeableTypes = new HashSet<TypeNameTuple>();
	private Map<TypeName,MergedTypeDescriptor> mergedTypes = Collections.synchronizedMap(new HashMap<TypeName,MergedTypeDescriptor>());
	private boolean initialized;

	/**
	 * 
	 * @param type - one of the two types that have been identified as matching.
	 * @param otherType - the other of two types that have been identified as matching.
	 * @return true if the match hasn't been previously discovered.
	 */
	boolean recordMatch(NamedType type, NamedType otherType) {
		TypeName typeName = type.getTypeName();
		TypeName otherTypeName = otherType.getTypeName();
		return recordMatch(typeName, otherTypeName);
	}
	
	boolean isUnmergeable(NamedType type, NamedType otherType) {
		return isUnmergeable(type.getTypeName(), otherType.getTypeName());
	}
	boolean isUnmergeable(TypeName name1, TypeName name2) {
		if (this.unmergeableTypes.contains(new TypeNameTuple(name1, name2))) {
			return true;
		} else if (!isMerged(name1) && !isMerged(name2)) {
			return false;
		} else {
			boolean result = false;
			Collection<TypeName> aliases1 = isMerged(name1) ? getAliases(name1) : Arrays.asList(name1);
			Collection<TypeName> aliases2 = isMerged(name2) ? getAliases(name2) : Arrays.asList(name2);
			
			for (TypeName typeName2 : aliases2) {
				for (TypeName typeName1 : aliases1) {
					result |= this.unmergeableTypes.contains(new TypeNameTuple(typeName1, typeName2));
				}
			}
			return result;
		}
	}

	private boolean isMerged(TypeName name) {
		return this.mergedTypes.containsKey(name);
	}

	private Collection<TypeName> getAliases(TypeName name1) {
		return this.mergedTypes.get(name1).getMergedTypes();
	}

	boolean isKnownMatch(NamedType type, NamedType otherType) {
		return isKnownMatch(type.getTypeName(), otherType.getTypeName());
	}
	boolean isKnownMatch(TypeName typeName, TypeName otherTypeName) {
		MergedTypeDescriptor descriptor = getDescriptorByName(typeName);
		if (descriptor == null) {
			return false;
		} else {
			return descriptor.getMergedTypes().contains(otherTypeName);
		}
	}

	boolean recordMatch(TypeName typeName, TypeName otherTypeName) {
		boolean result = false;
		MergedTypeDescriptor descriptor = this.mergedTypes.get(typeName);
		if (descriptor == null) {
			descriptor = this.mergedTypes.get(otherTypeName);
		} else {
			MergedTypeDescriptor temp = this.mergedTypes.get(otherTypeName);
			if (temp != null && temp != descriptor) {
				result = true;
				descriptor.getMergedTypes().addAll(temp.getMergedTypes());
				for (TypeName name : temp.getMergedTypes()) {
					this.mergedTypes.put(name, descriptor);
				}
			}
		}
		if (descriptor == null) {
			descriptor = new MergedTypeDescriptor();
			result = true;
		}
		
		this.mergedTypes.put(typeName, descriptor);
		this.mergedTypes.put(otherTypeName, descriptor);
		
		result |= descriptor.getMergedTypes().add(typeName);
		result |= descriptor.getMergedTypes().add(otherTypeName);
		return result;
	}

	public Set<MergedTypeDescriptor> getDescriptors() {
		Set<MergedTypeDescriptor> result = new HashSet<MergedTypeDescriptor>();
		for (MergedTypeDescriptor descriptor : this.mergedTypes.values()) {
			result.add(descriptor);
		}
		return result;
	}

	public MergedTypeDescriptor getDescriptorByName(TypeName name) {
		return this.mergedTypes.get(name);
	}

	public TypeName substitute(TypeName typeName) {
		MergedTypeDescriptor descriptor = getDescriptorByName(typeName);
		return descriptor == null ? typeName : descriptor.getNewName();
	}

	public Set<TypeName> substituteAll(Set<TypeName> childTypes) {
		Set<TypeName> result = new HashSet<TypeName>();
		for (TypeName typeName : childTypes) {
			result.add(substitute(typeName));
		}
		return result;
	}

	/**
	 * <p>There are certain types that we must be sure to not merge: in particular, 
	 * types that represent different choices.  This method initializes a structure of
	 * types that cannot be merged.
	 * 
	 * @param result
	 */
	public void initialize(SimplifiableTypeProvider result) {
		Map<TypeName,Set<TypeName>> choices = new HashMap<TypeName,Set<TypeName>>();
		if (!this.initialized) {
			for (SimplifiableType type : result.getAllTypes()) {
				for (String choice : type.getInterfaceTypes()) {
					TypeName choiceName = new TypeName(choice);
					if (!choices.containsKey(choiceName)) {
						choices.put(choiceName, new HashSet<TypeName>());
					}
					choices.get(choiceName).add(type.getTypeName());
				}
			}
			
			for (Set<TypeName> set : choices.values()) {
				Set<TypeName> temp = new HashSet<TypeName>();
				for (TypeName name1 : set) {
					for (TypeName name2 : temp) {
						this.unmergeableTypes.add(new TypeNameTuple(name1, name2));
					}
					temp.add(name1);
				}
			}
		}
		this.initialized = true;
	}
}
