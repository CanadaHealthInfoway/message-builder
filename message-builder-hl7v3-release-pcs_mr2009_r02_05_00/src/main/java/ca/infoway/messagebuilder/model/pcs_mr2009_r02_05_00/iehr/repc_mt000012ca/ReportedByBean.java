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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.iehr.repc_mt000012ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.pr.coct_mt050202ca.PatientBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.pr.coct_mt090108ca.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.pr.coct_mt910107ca.RelatedPersonBean;
import java.util.Date;



/**
 * <p>Business Name: d:reported by</p>
 * 
 * <p>The original source of the information can be important 
 * in evaluating its accuracy and importance.</p>
 * 
 * <p>Indicates where the information that led to the recording 
 * of this information came from. The possible 3 sources of the 
 * information are: the patient, the patient's representative 
 * or a health-care provider.</p>
 */
@Hl7PartTypeMapping({"REPC_MT000012CA.Informant"})
public class ReportedByBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private TS time = new TSImpl();
    private Choice choice;


    /**
     * <p>Business Name: Reported date</p>
     * 
     * <p>Relationship: REPC_MT000012CA.Informant.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for establishment of timelines between reaction 
     * onset date, reported date and recorded date, and is 
     * therefore mandatory.</p>
     * 
     * <p>The date on which the adverse reaction was reported.</p>
     */
    @Hl7XmlMapping({"time"})
    public Date getTime() {
        return this.time.getValue();
    }

    /**
     * <p>Business Name: Reported date</p>
     * 
     * <p>Relationship: REPC_MT000012CA.Informant.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for establishment of timelines between reaction 
     * onset date, reported date and recorded date, and is 
     * therefore mandatory.</p>
     * 
     * <p>The date on which the adverse reaction was reported.</p>
     */
    public void setTime(Date time) {
        this.time.setValue(time);
    }


    /**
     * <p>Relationship: REPC_MT000012CA.Informant.choice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"choice"})
    public Choice getChoice() {
        return this.choice;
    }

    /**
     * <p>Relationship: REPC_MT000012CA.Informant.choice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setChoice(Choice choice) {
        this.choice = choice;
    }

    public PatientBean getChoiceAsPatient() {
        return this.choice instanceof PatientBean ? (PatientBean) this.choice : null;
    }
    public boolean hasChoiceAsPatient() {
        return (this.choice instanceof PatientBean);
    }

    public RelatedPersonBean getChoiceAsPersonalRelationship() {
        return this.choice instanceof RelatedPersonBean ? (RelatedPersonBean) this.choice : null;
    }
    public boolean hasChoiceAsPersonalRelationship() {
        return (this.choice instanceof RelatedPersonBean);
    }

    public HealthcareWorkerBean getChoiceAsAssignedEntity() {
        return this.choice instanceof HealthcareWorkerBean ? (HealthcareWorkerBean) this.choice : null;
    }
    public boolean hasChoiceAsAssignedEntity() {
        return (this.choice instanceof HealthcareWorkerBean);
    }

}
