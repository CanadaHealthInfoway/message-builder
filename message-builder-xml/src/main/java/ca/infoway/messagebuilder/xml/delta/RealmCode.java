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

package ca.infoway.messagebuilder.xml.delta;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.xml.TypeName;

public class RealmCode {

	private final String code;

	private RealmCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}

	public String substituteRealmCode(String typeName) {
		return StringUtils.isBlank(typeName) ? typeName : substituteRealmCode(new TypeName(typeName)).getName();
	}
	public TypeName substituteRealmCode(TypeName typeName) {
		if (StringUtils.isNotBlank(this.code)) {
			StringBuilder builder = new StringBuilder(typeName.getName());
			if (typeName.getRootName().getName().length() >=15) {
				builder.replace(13, 15, this.code);
			}
			
			return new TypeName(builder.toString());
		} else {
			return typeName;
		}
	}

	public static RealmCode from(String realm) {
		return new RealmCode(realm);
	}

	public static RealmCode createTrivialRealmCode() {
		return new RealmCode(null);
	}

	public boolean matches(String typeName) {
		if (typeName != null && typeName.length() >=15) {
			return StringUtils.equals(typeName.substring(13, 15), this.code);
		} else {
			return false;
		}
	}
}
