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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.pharmacy.pome_mt010040ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ActMonitoringProtocolCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.merged.HealthcareWorkerBean;



@Hl7PartTypeMapping({"POME_MT010040CA.MonitoringProgram"})
public class MonitoringProgramsBean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
    private CV code = new CVImpl();
    private ST title = new STImpl();
    private HealthcareWorkerBean custodianAssignedEntity;


    /**
     * <p>Program Type</p>
     */
    @Hl7XmlMapping({"code"})
    public ActMonitoringProtocolCode getCode() {
        return (ActMonitoringProtocolCode) this.code.getValue();
    }
    public void setCode(ActMonitoringProtocolCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Program Name</p>
     */
    @Hl7XmlMapping({"title"})
    public String getTitle() {
        return this.title.getValue();
    }
    public void setTitle(String title) {
        this.title.setValue(title);
    }


    @Hl7XmlMapping({"custodian/assignedEntity"})
    public HealthcareWorkerBean getCustodianAssignedEntity() {
        return this.custodianAssignedEntity;
    }
    public void setCustodianAssignedEntity(HealthcareWorkerBean custodianAssignedEntity) {
        this.custodianAssignedEntity = custodianAssignedEntity;
    }

}
