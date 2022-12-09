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

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.ficr_mt600201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Animal Patient 
 * 
 * <p>Animal Patient 
 * 
 * <p>Used when invoice is for animal patient. 
 */
@Hl7PartTypeMapping({"FICR_MT600201CA.CoveredPartyAsPatientAnimal"})
public class AnimalPatientBean extends MessagePartBean implements CoveredPartyAsPatientChoiceBean {

    private ST nameOfTheAnimal = new STImpl();

    @Hl7XmlMapping({"name"})
    public java.lang.String getNameOfTheAnimal() {
        return this.nameOfTheAnimal.getValue();
    }
    public void setNameOfTheAnimal(java.lang.String nameOfTheAnimal) {
        this.nameOfTheAnimal.setValue(nameOfTheAnimal);
    }

}