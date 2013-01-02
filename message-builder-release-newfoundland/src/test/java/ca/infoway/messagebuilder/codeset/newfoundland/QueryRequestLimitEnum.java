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

package ca.infoway.messagebuilder.codeset.newfoundland;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.lang.EnumPattern;

public class QueryRequestLimitEnum extends EnumPattern implements Code {

	static{ /*static init block for translation purposes. Please do not remove.*/ }
	
	private static final long serialVersionUID = 1908549015408291860L;
	
	public static final QueryRequestLimitEnum RD = new QueryRequestLimitEnum("RD");
	
	private QueryRequestLimitEnum(String name) {
		super(name);
	}
	
	public String getCodeSystem() {
		return CodeSystem.VOCABULARY_QUERY_REQUEST_LIMIT.getRoot();
	}

	public String getCodeValue() {
		return name();
	}
}