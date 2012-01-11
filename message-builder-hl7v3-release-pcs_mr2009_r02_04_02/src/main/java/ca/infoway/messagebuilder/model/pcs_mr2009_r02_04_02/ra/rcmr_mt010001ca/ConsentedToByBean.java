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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.ra.rcmr_mt010001ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.x_PhysicalVerbalParticipationMode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.Consenter;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.RelatedPersonBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.ra.merged.PatientBean;



/**
 * <p>b:consented to by</p>
 * 
 * <p><p>Indicates that the consent was provided by the patient 
 * or representative.</p></p>
 * 
 * <p><p>Consent can be provided by the patient or 
 * representative or be overridden by a provider. It is 
 * important to know which occurred for audit purposes.</p></p>
 */
@Hl7PartTypeMapping({"RCMR_MT010001CA.Author"})
public class ConsentedToByBean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
    private CV modeCode = new CVImpl();
    private Consenter consenter;


    /**
     * <p>Patient Consent Mechanism</p>
     * 
     * <p><p>Indicates whether the patient's consent is written or 
     * verbal.</p></p>
     * 
     * <p><p>Verbal consents may trigger a higher level of 
     * auditing.</p></p>
     */
    @Hl7XmlMapping({"modeCode"})
    public x_PhysicalVerbalParticipationMode getModeCode() {
        return (x_PhysicalVerbalParticipationMode) this.modeCode.getValue();
    }
    public void setModeCode(x_PhysicalVerbalParticipationMode modeCode) {
        this.modeCode.setValue(modeCode);
    }


    @Hl7XmlMapping({"consenter"})
    public Consenter getConsenter() {
        return this.consenter;
    }
    public void setConsenter(Consenter consenter) {
        this.consenter = consenter;
    }

    public PatientBean getConsenterAsPatient() {
        return this.consenter instanceof PatientBean ? (PatientBean) this.consenter : null;
    }
    public boolean hasConsenterAsPatient() {
        return (this.consenter instanceof PatientBean);
    }

    public RelatedPersonBean getConsenterAsPersonalRelationship() {
        return this.consenter instanceof RelatedPersonBean ? (RelatedPersonBean) this.consenter : null;
    }
    public boolean hasConsenterAsPersonalRelationship() {
        return (this.consenter instanceof RelatedPersonBean);
    }

}
