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

package ca.infoway.messagebuilder.generator.multiplemessageset;

import ca.infoway.messagebuilder.generator.LogLevel;
import ca.infoway.messagebuilder.generator.OutputUI;

class MergeContextImpl implements MergeContext {

	private OutputUI outputUI;
	private String currentInteraction;
	private String currentPackageLocation;
	private String primaryVersion;
	private String secondaryVersion;
	private String currentMessagePart;

	MergeContextImpl(OutputUI outputUI, String primaryVersion, String secondaryVersion) {
		this.outputUI = outputUI;
		this.primaryVersion = primaryVersion;
		this.secondaryVersion = secondaryVersion;
	}
	
	public String getCurrentInteraction() {
		return this.currentInteraction;
	}

	public String getCurrentPackageLocation() {
		return this.currentPackageLocation;
	}

	public String getPrimaryVersion() {
		return this.primaryVersion;
	}

	public String getSecondaryVersion() {
		return this.secondaryVersion;
	}

	public void logError(String error) {
		this.outputUI.log(LogLevel.ERROR, error);
	}

	public void logInfo(String info) {
		// leaving as debug for now to reduce noise
		this.outputUI.log(LogLevel.DEBUG, info);
		//this.outputUI.log(LogLevel.INFO, info);
	}

	public void setCurrentInteraction(String interaction) {
		this.currentInteraction = interaction;
	}

	public void setCurrentPackageLocation(String packageLocation) {
		this.currentPackageLocation = packageLocation;
	}

	public String getCurrentMessagePart() {
		return this.currentMessagePart;
	}

	public void setCurrentMessagePart(String messagePart) {
		this.currentMessagePart = messagePart;
	}

}
