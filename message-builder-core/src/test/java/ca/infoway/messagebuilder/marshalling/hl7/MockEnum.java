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

import ca.infoway.messagebuilder.lang.EnumPattern;

public class MockEnum extends EnumPattern implements MockCharacters {
	
	private static final long serialVersionUID = 2054176307399510076L;
	
	public static final MockEnum FRED = new MockEnum("FRED");
	public static final MockEnum BARNEY = new MockEnum("BARNEY"); 
	public static final MockEnum WILMA = new MockEnum("WILMA"); 
	public static final MockEnum BETTY = new MockEnum("BETTY"); 
	public static final MockEnum BAM_BAM = new MockEnum("BAM_BAM");

	private MockEnum(String name) {
		super(name);
	}
	
	public String getCodeSystem() {
		return "1.2.3.4.5";
	}

	public String getCodeValue() {
		return toString();
	}

}
