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
package ca.infoway.messagebuilder.model.common.coct_mt470002ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.domainvalue.x_PhysicalVerbalParticipationMode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.merged.RelatedPersonBean;



/**
 * <p>b:consented to by 
 * 
 * <p>Indicates that the consent was provided by the patient or 
 * representative. 
 * 
 * <p>Consent can be provided by the patient or representative 
 * or the provider. 
 * 
 * <p>Authorization.Person 
 * 
 * <p>Authorization.signatory(PT) 
 */
@Hl7PartTypeMapping({"COCT_MT470002CA.Author"})
public class ConsentedToByBean extends MessagePartBean {

    private CV<x_PhysicalVerbalParticipationMode> patientConsentMechanism = new CVImpl<x_PhysicalVerbalParticipationMode>();
    private ED<String> keyword = new EDImpl<String>();
    private RelatedPersonBean personalRelationship;

    @Hl7XmlMapping({"modeCode"})
    public x_PhysicalVerbalParticipationMode getPatientConsentMechanism() {
        return this.patientConsentMechanism.getValue();
    }
    public void setPatientConsentMechanism(x_PhysicalVerbalParticipationMode patientConsentMechanism) {
        this.patientConsentMechanism.setValue(patientConsentMechanism);
    }

    @Hl7XmlMapping({"signatureText"})
    public java.lang.String getKeyword() {
        return this.keyword.getValue();
    }
    public void setKeyword(java.lang.String keyword) {
        this.keyword.setValue(keyword);
    }

    @Hl7XmlMapping({"personalRelationship"})
    public RelatedPersonBean getPersonalRelationship() {
        return this.personalRelationship;
    }
    public void setPersonalRelationship(RelatedPersonBean personalRelationship) {
        this.personalRelationship = personalRelationship;
    }

}