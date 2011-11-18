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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.coct_mt911108ca.ActingPerson;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.pharmacy.merged.ChangedBy;
import java.util.Date;



@Hl7PartTypeMapping({"COCT_MT130001CA.Author3","COCT_MT260010CA.Author1","COCT_MT260012CA.Author1","COCT_MT260020CA.Author1","COCT_MT260022CA.Author1","COCT_MT260030CA.Author1","PORX_MT060010CA.Author6","PORX_MT060040CA.Author1","PORX_MT060090CA.Author6","PORX_MT060160CA.Author1","PORX_MT060210CA.Author7","PORX_MT060340CA.Author1","REPC_MT000009CA.Author3"})
public class ChangedByBean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
    private TS time = new TSImpl();
    private ChangedBy changedBy;
    private HealthcareWorkerBean assignedEntity;
    private ActingPerson actingPerson;


    /**
     * <p>Change Datetime</p>
     * 
     * <p>Change Time</p>
     * 
     * <p>Change Timestamp</p>
     * 
     * <p>B:Management Date</p>
     */
    @Hl7XmlMapping({"time"})
    public Date getTime() {
        return this.time.getValue();
    }
    public void setTime(Date time) {
        this.time.setValue(time);
    }


    @Hl7XmlMapping({"changedBy"})
    public ChangedBy getChangedBy() {
        return this.changedBy;
    }
    public void setChangedBy(ChangedBy changedBy) {
        this.changedBy = changedBy;
    }


    @Hl7XmlMapping({"assignedEntity"})
    public HealthcareWorkerBean getAssignedEntity() {
        return this.assignedEntity;
    }
    public void setAssignedEntity(HealthcareWorkerBean assignedEntity) {
        this.assignedEntity = assignedEntity;
    }


    @Hl7XmlMapping({"actingPerson"})
    public ActingPerson getActingPerson() {
        return this.actingPerson;
    }
    public void setActingPerson(ActingPerson actingPerson) {
        this.actingPerson = actingPerson;
    }

}
