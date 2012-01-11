/**
 * Copyright 2012 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.marshalling.hl7;

import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;

public class Hl7DataTypeName {
	
	private final String name;

	private Hl7DataTypeName(String name) {
		this.name = name;
	}
	
	public static Hl7DataTypeName create(String name) {
		return new Hl7DataTypeName(name);
	}
	
	public Hl7DataTypeName getUnqualifiedVersion() {
		if (isQualified()) {
			return create(unqualify());
		} else {
			return this;
		}
	}

	private String unqualify() {
		StringBuilder builder = new StringBuilder();
		for (StringTokenizer tokenizer = new StringTokenizer(this.name, "<,>", true); tokenizer.hasMoreTokens(); ) {
			String token = tokenizer.nextToken();
			if ("<,>".indexOf(token) >= 0) {
				builder.append(token);
			} else if (isQualified(token)) {
				builder.append(StringUtils.substringBefore(token, "."));
			} else {
				builder.append(token);
			}
		}
		return builder.toString();
	}

	private boolean isQualified(String token) {
		return token.contains(".");
	}

	public String toString() {
		return this.name;
	}

	public boolean isQualified() {
		return this.name.contains(".");
	}

	public static String unqualify(String name) {
		return create(name).getUnqualifiedVersion().toString();
	}

	public static String getTypeWithoutParameters(String name) {
		return StringUtils.isNotBlank(name) && name.contains("<") ? StringUtils.substringBefore(name, "<") : name;
	}
	
	public static String getParameterizedType(String type) {
		return StringUtils.substringBeforeLast(StringUtils.substringAfter(type, "<"), ">");
	}
}
