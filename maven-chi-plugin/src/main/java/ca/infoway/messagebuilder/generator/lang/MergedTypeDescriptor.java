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

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;

import ca.infoway.messagebuilder.xml.TypeName;

/**
 * <p>This class provides information about how we'd merge various types in 
 * case 3 simplification.</p>
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 */
public class MergedTypeDescriptor {

	private TypeName newName;
	private final Set<TypeName> mergedTypes = Collections.synchronizedSet(new HashSet<TypeName>());
	
	public MergedTypeDescriptor() {
		this.newName = TemporaryTypeName.create("merged");
	}
	
	public Set<TypeName> getMergedTypes() {
		return this.mergedTypes;
	}

	public TypeName getNewName() {
		return this.newName;
	}
	
	@Override
	public int hashCode() {
		return this.newName.hashCode();
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
			MergedTypeDescriptor that = (MergedTypeDescriptor) obj;
			return new EqualsBuilder().append(this.newName, that.newName).isEquals();
		}
	}
}
