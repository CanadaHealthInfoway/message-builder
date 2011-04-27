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

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.porx_mt060010ca;

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
 * <p>a:dispensed 
 * 
 * <p>Indicates the prescription that was dispensed. 
 * 
 * <p>Links the dispense act to the prescription order it was 
 * performed against. 
 */
@Hl7PartTypeMapping({"PORX_MT060010CA.InFulfillmentOf"})
public class DispensedBean extends MessagePartBean {

    private II prescriptionOrderNumber = new IIImpl();
    private HealthcareWorkerBean supplyRequestResponsiblePartyAssignedEntity;
    private RefusedByBean supplyRequestAuthor;
    private IsPartOfBean supplyRequestComponent;

    @Hl7XmlMapping({"supplyRequest/id"})
    public Identifier getPrescriptionOrderNumber() {
        return this.prescriptionOrderNumber.getValue();
    }
    public void setPrescriptionOrderNumber(Identifier prescriptionOrderNumber) {
        this.prescriptionOrderNumber.setValue(prescriptionOrderNumber);
    }

    @Hl7XmlMapping({"supplyRequest/responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getSupplyRequestResponsiblePartyAssignedEntity() {
        return this.supplyRequestResponsiblePartyAssignedEntity;
    }
    public void setSupplyRequestResponsiblePartyAssignedEntity(HealthcareWorkerBean supplyRequestResponsiblePartyAssignedEntity) {
        this.supplyRequestResponsiblePartyAssignedEntity = supplyRequestResponsiblePartyAssignedEntity;
    }

    @Hl7XmlMapping({"supplyRequest/author"})
    public RefusedByBean getSupplyRequestAuthor() {
        return this.supplyRequestAuthor;
    }
    public void setSupplyRequestAuthor(RefusedByBean supplyRequestAuthor) {
        this.supplyRequestAuthor = supplyRequestAuthor;
    }

    @Hl7XmlMapping({"supplyRequest/component"})
    public IsPartOfBean getSupplyRequestComponent() {
        return this.supplyRequestComponent;
    }
    public void setSupplyRequestComponent(IsPartOfBean supplyRequestComponent) {
        this.supplyRequestComponent = supplyRequestComponent;
    }

}
