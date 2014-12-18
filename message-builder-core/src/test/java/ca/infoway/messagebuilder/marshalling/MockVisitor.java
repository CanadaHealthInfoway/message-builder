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

import java.util.TimeZone;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.xml.ConstrainedDatatype;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.Relationship;

class MockVisitor implements Visitor {

	private boolean rootStarted;
	private boolean rootEnded;
	private boolean attributeVisited;

	public boolean isRootStarted() {
		return rootStarted;
	}

	public void setRootStarted(boolean rootStarted) {
		this.rootStarted = rootStarted;
	}

	public void visitAssociationEnd(PartBridge tealBean,
			Relationship relationship) {
		
	}

	public void visitAssociationStart(PartBridge tealBean,
			Relationship relationship) {
	}

	public void visitAttribute(AttributeBridge tealBean,
			Relationship relationship, ConstrainedDatatype constraints, VersionNumber version, TimeZone dateTimeZone, TimeZone dateTimeTimeZone) {
		this.attributeVisited = true;
	}

	public void visitRootEnd(PartBridge tealBean, Interaction interaction) {
		this.rootEnded = true;
	}

	public void visitRootStart(PartBridge tealBean, Interaction interaction) {
		this.rootStarted = true;
	}

	public boolean isRootEnded() {
		return this.rootEnded;
	}

	public boolean isAttributeVisited() {
		return this.attributeVisited;
	}

	public void logError(Hl7Error error) {
		// do nothing
	}

	public String getCurrentPropertyPath() {
		return "";
	}

}
