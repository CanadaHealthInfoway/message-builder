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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.iehr.repc_mt000009ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ControlActReason;
import ca.infoway.messagebuilder.domainvalue.HL7TriggerEventCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.merged.ChangedByBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.merged.HealthcareWorkerBean;
import java.util.Date;



@Hl7PartTypeMapping({"REPC_MT000009CA.ControlActEvent"})
public class AllergyIntoleranceStatusChangesBean extends MessagePartBean {

    private static final long serialVersionUID = 20110729L;
    private CV allergyIntoleranceStatusChangeType = new CVImpl();
    private IVL<TS, Interval<Date>> allergyIntoleranceStatusChangeEffectiveDate = new IVLImpl<TS, Interval<Date>>();
    private CV allergyIntoleranceStatusChangeReason = new CVImpl();
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private ChangedByBean author;


    /**
     * <p>A:Allergy/Intolerance Status Change Type</p>
     */
    @Hl7XmlMapping({"code"})
    public HL7TriggerEventCode getAllergyIntoleranceStatusChangeType() {
        return (HL7TriggerEventCode) this.allergyIntoleranceStatusChangeType.getValue();
    }
    public void setAllergyIntoleranceStatusChangeType(HL7TriggerEventCode allergyIntoleranceStatusChangeType) {
        this.allergyIntoleranceStatusChangeType.setValue(allergyIntoleranceStatusChangeType);
    }


    /**
     * <p>B:Allergy/intolerance Status Change Effective Date</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getAllergyIntoleranceStatusChangeEffectiveDate() {
        return this.allergyIntoleranceStatusChangeEffectiveDate.getValue();
    }
    public void setAllergyIntoleranceStatusChangeEffectiveDate(Interval<Date> allergyIntoleranceStatusChangeEffectiveDate) {
        this.allergyIntoleranceStatusChangeEffectiveDate.setValue(allergyIntoleranceStatusChangeEffectiveDate);
    }


    /**
     * <p>C:Allergy/Intolerance Status Change Reason</p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public ControlActReason getAllergyIntoleranceStatusChangeReason() {
        return (ControlActReason) this.allergyIntoleranceStatusChangeReason.getValue();
    }
    public void setAllergyIntoleranceStatusChangeReason(ControlActReason allergyIntoleranceStatusChangeReason) {
        this.allergyIntoleranceStatusChangeReason.setValue(allergyIntoleranceStatusChangeReason);
    }


    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }
    public void setResponsiblePartyAssignedEntity(HealthcareWorkerBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
    }


    @Hl7XmlMapping({"author"})
    public ChangedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(ChangedByBean author) {
        this.author = author;
    }

}
