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

import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.error.Hl7ErrorLevel;
import ca.infoway.messagebuilder.error.Hl7Errors;

/**
 * <p>An object that represents the result of transforming an object from HL7 XML format
 * to an object representation.  The result tends to contain two key items:
 * 
 * <ol>
 * <li>An object representation of the HL7 message that contains all of the populated 
 * data.
 * <li>A set of errors that were encountered during parsing of the message.
 * </ol>
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class XmlToModelResult implements Hl7Errors {
	
	private Object messageObject;
	private final List<Hl7Error> hl7Errors = new ArrayList<Hl7Error>();
	
	/**
	 * <p>The object representation of the HL7 message.
	 * 
	 * @return - the populated classes that contain the message data.
	 */
	public Object getMessageObject() {
		return messageObject;
	}
	public void setMessageObject(Object messageObject) {
		this.messageObject = messageObject;
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