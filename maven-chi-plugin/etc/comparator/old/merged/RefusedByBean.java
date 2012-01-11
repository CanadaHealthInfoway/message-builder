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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt911108ca.ActingPersonBean;
import java.util.Date;



@Hl7PartTypeMapping({"COCT_MT130001CA.Author3","COCT_MT260010CA.Author1","COCT_MT260012CA.Author1","COCT_MT260020CA.Author1","COCT_MT260022CA.Author1","COCT_MT260030CA.Author1","PORR_MT050016CA.Author","PORX_MT020060CA.Author","PORX_MT020070CA.Author","PORX_MT030040CA.Author","PORX_MT060010CA.Author5","PORX_MT060010CA.Author6","PORX_MT060040CA.Author","PORX_MT060040CA.Author1","PORX_MT060060CA.Author","PORX_MT060090CA.Author5","PORX_MT060090CA.Author6","PORX_MT060160CA.Author","PORX_MT060160CA.Author1","PORX_MT060160CA.Author5","PORX_MT060190CA.Author","PORX_MT060190CA.Author3","PORX_MT060210CA.Author","PORX_MT060210CA.Author7","PORX_MT060340CA.Author","PORX_MT060340CA.Author1","REPC_MT000009CA.Author3"})
public class RefusedByBean extends MessagePartBean {

    private HealthcareWorkerBean assignedEntity = new HealthcareWorkerBean();
    private TS changeTimestamp = new TSImpl();
    private ChangedByBean changedBy;
    private ActingPersonBean actingPerson;

    @Hl7XmlMapping({"assignedEntity"})
    public HealthcareWorkerBean getAssignedEntity() {
        return this.assignedEntity;
    }
    public void setAssignedEntity(HealthcareWorkerBean assignedEntity) {
        this.assignedEntity = assignedEntity;
    }

    @Hl7XmlMapping({"time"})
    public Date getChangeTimestamp() {
        return this.changeTimestamp.getValue();
    }
    public void setChangeTimestamp(Date changeTimestamp) {
        this.changeTimestamp.setValue(changeTimestamp);
    }

    @Hl7XmlMapping({"changedBy"})
    public ChangedByBean getChangedBy() {
        return this.changedBy;
    }
    public void setChangedBy(ChangedByBean changedBy) {
        this.changedBy = changedBy;
    }

    @Hl7XmlMapping({"actingPerson"})
    public ActingPersonBean getActingPerson() {
        return this.actingPerson;
    }
    public void setActingPerson(ActingPersonBean actingPerson) {
        this.actingPerson = actingPerson;
    }

}
