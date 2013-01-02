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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.generator.java;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

class Tuple<T> {
	private final T name1;
	private final T name2;
	public Tuple(T name1, T name2) {
		this.name1 = name1;
		this.name2 = name2;
	}
	public int hashCode() {
		return new HashCodeBuilder().append(this.name1).append(this.name2).toHashCode();
	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (obj == this) {
			return true;
		} else if (obj.getClass() != getClass()) {
			return false;
		} else {
			Tuple<T> that = (Tuple<T>) obj;
			return new EqualsBuilder().append(this.name1, that.name1)
					.append(this.name2, that.name2).isEquals();
		}
	}
	public T getName1() {
		return this.name1;
	}
	public T getName2() {
		return this.name2;
	}
}
