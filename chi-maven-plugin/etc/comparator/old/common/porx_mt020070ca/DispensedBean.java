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
package ca.infoway.messagebuilder.model.common.porx_mt020070ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.merged.IsPartOfBean;
import ca.infoway.messagebuilder.model.merged.RefusedByBean;



/**
 * <p>dispensed 
 * 
 * <p>Indicates the prescription that is being dispensed 
 * against. 
 * 
 * <p>Links the dispense act to the prescription order it was 
 * performed against. 
 */
@Hl7PartTypeMapping({"PORX_MT020070CA.InFulfillmentOf1"})
public class DispensedBean extends MessagePartBean {

    private II prescriptionOrderNumber = new IIImpl();
    private HealthcareWorkerBean substanceAdministrationRequestResponsiblePartyAssignedEntity;
    private RefusedByBean substanceAdministrationRequestAuthor;
    private IsPartOfBean substanceAdministrationRequestComponent;

    @Hl7XmlMapping({"substanceAdministrationRequest/id"})
    public Identifier getPrescriptionOrderNumber() {
        return this.prescriptionOrderNumber.getValue();
    }
    public void setPrescriptionOrderNumber(Identifier prescriptionOrderNumber) {
        this.prescriptionOrderNumber.setValue(prescriptionOrderNumber);
    }

    @Hl7XmlMapping({"substanceAdministrationRequest/responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getSubstanceAdministrationRequestResponsiblePartyAssignedEntity() {
        return this.substanceAdministrationRequestResponsiblePartyAssignedEntity;
    }
    public void setSubstanceAdministrationRequestResponsiblePartyAssignedEntity(HealthcareWorkerBean substanceAdministrationRequestResponsiblePartyAssignedEntity) {
        this.substanceAdministrationRequestResponsiblePartyAssignedEntity = substanceAdministrationRequestResponsiblePartyAssignedEntity;
    }

    @Hl7XmlMapping({"substanceAdministrationRequest/author"})
    public RefusedByBean getSubstanceAdministrationRequestAuthor() {
        return this.substanceAdministrationRequestAuthor;
    }
    public void setSubstanceAdministrationRequestAuthor(RefusedByBean substanceAdministrationRequestAuthor) {
        this.substanceAdministrationRequestAuthor = substanceAdministrationRequestAuthor;
    }

    @Hl7XmlMapping({"substanceAdministrationRequest/component"})
    public IsPartOfBean getSubstanceAdministrationRequestComponent() {
        return this.substanceAdministrationRequestComponent;
    }
    public void setSubstanceAdministrationRequestComponent(IsPartOfBean substanceAdministrationRequestComponent) {
        this.substanceAdministrationRequestComponent = substanceAdministrationRequestComponent;
    }

}
