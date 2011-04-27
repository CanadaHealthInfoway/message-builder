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

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

class NameAndType implements Comparable<NameAndType> {
	private final String name;
	private final String type;

	NameAndType(String name, String type) {
		this.name = name;
		this.type = type;
	}
	
	String getName() {
		return this.name;
	}

	String getType() {
		return this.type;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (obj == this) {
			return true;
		} else if (!obj.getClass().equals(this.getClass())) {
			return false;
		} else {
			NameAndType that = (NameAndType) obj;
			return new EqualsBuilder()
				.append(this.name, that.name)
				.append(this.type, that.type)
				.isEquals();
		}
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
			.append(this.name)
			.append(this.type)
			.toHashCode();
	}

	public int compareTo(NameAndType that) {
		return new CompareToBuilder()
					.append(this.name, that.name)
					.append(this.type, that.type)
					.toComparison();
	}
}