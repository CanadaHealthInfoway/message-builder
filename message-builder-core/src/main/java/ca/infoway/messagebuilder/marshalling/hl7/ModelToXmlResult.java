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

package ca.infoway.messagebuilder.marshalling.hl7;

import java.util.ArrayList;
import java.util.List;

public class ModelToXmlResult implements Hl7Errors {
	
	private String xmlMessage;

	private final List<Hl7Error> hl7Errors = new ArrayList<Hl7Error>();
	
	public String getXmlMessage() {
		return this.xmlMessage;
	}
	public String getXmlMessageWithoutFormatting() {
		return this.xmlMessage == null ? null : this.xmlMessage.replaceAll(">\\s+<", "><");
	}
	public void setXmlMessage(String xmlMessage) {
		this.xmlMessage = xmlMessage;
	}

	public boolean isValid() {
		for (Hl7Error hl7Error : this.hl7Errors) {
			if (hl7Error.getHl7ErrorLevel() == Hl7ErrorLevel.ERROR || hl7Error.getHl7ErrorLevel() == Hl7ErrorLevel.WARNING) {
				return false;
			}
		}
		return true;
	}

	public void addHl7Error(Hl7Error hl7Error) {
		this.hl7Errors.add(hl7Error);
	}
	
	public List<Hl7Error> getHl7Errors() {
		return this.hl7Errors;
	}
	
	public void clearErrors() {
		this.hl7Errors.clear();
	}
	
}