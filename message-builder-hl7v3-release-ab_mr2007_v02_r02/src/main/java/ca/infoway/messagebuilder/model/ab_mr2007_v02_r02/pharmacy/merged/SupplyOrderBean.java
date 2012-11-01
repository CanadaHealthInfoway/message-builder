/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.ConsentOverriddenByBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.HealthcareWorkerBean;



/**
 * <p>PORX_MT060020CA.SupplyRequest: Prescription Reference</p>
 * 
 * <p><p>A reference to the prescription order being 
 * dispensed</p></p>
 * 
 * <p><p>Links a dispense with its parent prescription.</p></p>
 * 
 * <p>PORX_MT020050CA.SupplyRequest: Supply Order</p>
 * 
 * <p><p>Identification of the supply information. This 
 * prescription will have a supply order portion but no 
 * administration part.</p></p>
 * 
 * <p><p>Ensures that dispenses to offices (non-patient 
 * identifiable dispenses) follow the normal dispensing 
 * rules.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT020050CA.SupplyRequest","PORX_MT060020CA.SupplyRequest"})
public class SupplyOrderBean extends MessagePartBean {

    private static final long serialVersionUID = 20120122L;
    private II id = new IIImpl();
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private ConsentOverriddenByBean author;


    /**
     * <p>PrescriptionIdentifier</p>
     * 
     * <p>A:Prescription Identifier</p>
     * 
     * <p><p>This is an identifier assigned to a specific device 
     * order. The number remains constant across the lifetime of 
     * the order, regardless of the number of providers or 
     * pharmacies involved in fulfilling the order.</p></p>
     * 
     * <p><p>Allows prescriptions to be uniquely referenced and 
     * associated with the dispense.</p><p>The ID is mandatory 
     * because the DIS would always assign a Prescription 
     * Number.</p></p>
     * 
     * <p><p>Allows prescriptions to be uniquely referenced and 
     * associated with the dispense.</p><p>The ID is mandatory 
     * because the DIS would always assign a Prescription 
     * Number.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }
    public void setResponsiblePartyAssignedEntity(HealthcareWorkerBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
    }


    @Hl7XmlMapping({"author"})
    public ConsentOverriddenByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(ConsentOverriddenByBean author) {
        this.author = author;
    }

}