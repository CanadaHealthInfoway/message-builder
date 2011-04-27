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

package ca.infoway.messagebuilder.generator;

import ca.infoway.messagebuilder.generator.util.Namespace;

public class XsdDataType {
	
	private final String name;
	private final String prefix;
	private final String namespace;

	XsdDataType(String name, Namespace namespace) {
		this(name, namespace.getPrefix(), namespace.getNamespace());
	}
	XsdDataType(String name, String prefix, String namespace) {
		this.name = name;
		this.prefix = prefix;
		this.namespace = namespace;
	}

	public String getName() {
		return this.name;
	}

	public String getPrefix() {
		return this.prefix;
	}

	public String getNamespace() {
		return this.namespace;
	}
	public String getQualifiedName() {
		return this.prefix + ":" + this.name;
	}
}
