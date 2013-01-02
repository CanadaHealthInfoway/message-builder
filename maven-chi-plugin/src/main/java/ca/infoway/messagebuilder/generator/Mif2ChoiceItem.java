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
 * Author:        $LastChangedBy: gng $
 * Last modified: $LastChangedDate: 2012-08-20 12:43:41 -0400 (Mon, 20 Aug 2012) $
 * Revision:      $LastChangedRevision: 6028 $
 */

package ca.infoway.messagebuilder.generator;

import java.util.List;

import org.w3c.dom.Element;

import ca.infoway.messagebuilder.xml.TypeName;

class Mif2ChoiceItem implements MifChoiceItem {

	// <mif:choiceItem className="A_PatientProfileCareComp" traversalName="patientCareProvisionEvent1"/>
	private Element element;
	private final TypeName name;
	private final List<MifChoiceItem> subChoices;
	
	public Mif2ChoiceItem(TypeName name, Element element, List<MifChoiceItem> subChoices) {
		this.name = name;
		this.element = element;
		this.subChoices = subChoices;
	}

	public String getClassName() {
		return this.name.getName();
	}

	public String getTraversalName() {
		return this.element.getAttribute("traversalName");
	}

	public List<MifChoiceItem> getChoiceItems() {
		return this.subChoices;
	}
}
