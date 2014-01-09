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

package ca.infoway.messagebuilder.marshalling;

import ca.infoway.messagebuilder.Hl7BaseVersion;
import ca.infoway.messagebuilder.Typed;
import ca.infoway.messagebuilder.VersionNumber;

public class MockVersionNumber implements VersionNumber {

	public static final VersionNumber MOCK_NEWFOUNDLAND = new MockVersionNumber("MOCK_NEWFOUNDLAND", Hl7BaseVersion.MR2007);
	public static final VersionNumber MOCK_MR2009 = new MockVersionNumber("MOCK_MR2009", Hl7BaseVersion.MR2009);
	private final String literal;
	private final Hl7BaseVersion baseVersion;
	
	private MockVersionNumber(String literal, Hl7BaseVersion baseVersion) {
		this.literal = literal;
		this.baseVersion = baseVersion;
	}
	
	public String getVersionLiteral() {
		return this.literal;
	}

	public Hl7BaseVersion getBaseVersion() {
		return this.baseVersion;
	}

	public Hl7BaseVersion getBaseVersion(Typed datatype) {
		return getBaseVersion();
	}
}
