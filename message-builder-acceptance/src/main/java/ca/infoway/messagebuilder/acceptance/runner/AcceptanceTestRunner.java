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

package ca.infoway.messagebuilder.acceptance.runner;

import ca.infoway.messagebuilder.Hl7BaseVersion;
import ca.infoway.messagebuilder.Typed;
import ca.infoway.messagebuilder.VersionNumber;

public interface AcceptanceTestRunner {
	
	public static final VersionNumber NEWFOUNDLAND_LEGACY_VERSION_HACK = new VersionNumber() {
		public String getVersionLiteral() {return "NEWFOUNDLAND";}
		public Hl7BaseVersion getBaseVersion() {return Hl7BaseVersion.MR2007;} // Newfoundland (as IWD currently implements it) is a mix of CeRx and V02R02
		public Hl7BaseVersion getBaseVersion(Typed datatype) {return getBaseVersion();};
	};

	public void run(AcceptanceTestResultCallback resultCallback);

}
