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
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * <p>A "fingerprint" that can be used to compare two relationships to see if they're
 * essentially the same.
 * 
 * <p>Originally, we used to track relationships by "name", but it's possible to have 
 * renamed relationships.  We use the "fingerprint" in lieu of the name.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class Fingerprint {
	
	static class Part {
		private final RelationshipType type;
		private final String name;
		
		Part(RelationshipType type, String name) {
			this.type = type;
			this.name = name;
		}
		public String getName() {
			return this.name;
		}
		public RelationshipType getType() {
			return this.type;
		}
		@Override
		public int hashCode() {
			return new HashCodeBuilder()
					.append(this.type)
					.append(this.name)
					.toHashCode();
		}
		public boolean equals(Object obj) {
			if (obj == null) {
				return false;
			} else if (obj == this) {
				return true;
			} else if (obj.getClass() != getClass()) {
				return false;
			} else {
				Part that = (Part) obj;
				return new EqualsBuilder()
						.append(this.type, that.type)
						.append(this.name, that.name)
						.isEquals();
			}
		}
	}
	
	private List<Part> parts = new ArrayList<Part>();
	
	public Fingerprint(RelationshipType type, String name) {
		this.parts.add(new Part(type, name));
	}
	private Fingerprint(List<Part> parts) {
		this.parts.addAll(parts);
	}
	public Fingerprint concat(Fingerprint fingerprint) {
		List<Part> temp = new ArrayList<Part>();
		temp.addAll(this.parts);
		temp.addAll(fingerprint.parts);
		return new Fingerprint(temp);
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		boolean first = true;
		for (Part part : this.parts) {
			if (!first) {
				builder.append("/");
			}
			builder.append(part.getName());
			first = false;
		}
		return builder.toString();
	}
	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder();
		for (Part part : this.parts) {
			builder.append(part);
		}
		return builder.toHashCode();
	}
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (obj == this) {
			return true;
		} else if (obj.getClass() != getClass()) {
			return false;
		} else {
			Fingerprint that = (Fingerprint) obj;
			EqualsBuilder builder = new EqualsBuilder();
			builder.append(this.parts.size(), that.parts.size());
			for (int i = 0, length = Math.max(this.parts.size(), that.parts.size()); i < length; i++) {
				builder.append(this.partAt(i), that.partAt(i));
			}
			return builder.isEquals();
		}
	}
	private Part partAt(int index) {
		return this.parts.size() > index ? this.parts.get(index) : null;
	}
}
