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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.nb_drug.si.rcmr_mt010001nb;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.x_PhysicalVerbalParticipationMode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.nb_drug.common.coct_mt040205nb.ResponsiblePersonBean;
import ca.infoway.messagebuilder.model.nb_drug.si.merged.Consenter;
import ca.infoway.messagebuilder.model.nb_drug.si.merged.PatientBean;



/**
 * <p>Business Name: b:consented to by</p>
 * 
 * <p>Authorization.Person</p>
 * 
 * <p>Authorization.signatory(PT)</p>
 * 
 * <p>Consent can be provided by the patient or representative 
 * or be overridden by a provider. It is important to know 
 * which occurred for audit purposes.</p>
 * 
 * <p>Indicates that the consent was provided by the patient or 
 * representative.</p>
 */
@Hl7PartTypeMapping({"RCMR_MT010001NB.Author"})
public class ConsentedToByBean extends MessagePartBean {

    private static final long serialVersionUID = 20150901L;
    private CV modeCode = new CVImpl();
    private Consenter consenter;


    /**
     * <p>Business Name: Patient Consent Mechanism</p>
     * 
     * <p>Relationship: RCMR_MT010001NB.Author.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Verbal consents may trigger a higher level of 
     * auditing.</p>
     * 
     * <p>Indicates whether the patient's consent is written or 
     * verbal.</p>
     */
    @Hl7XmlMapping({"modeCode"})
    public x_PhysicalVerbalParticipationMode getModeCode() {
        return (x_PhysicalVerbalParticipationMode) this.modeCode.getValue();
    }

    /**
     * <p>Business Name: Patient Consent Mechanism</p>
     * 
     * <p>Relationship: RCMR_MT010001NB.Author.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Verbal consents may trigger a higher level of 
     * auditing.</p>
     * 
     * <p>Indicates whether the patient's consent is written or 
     * verbal.</p>
     */
    public void setModeCode(x_PhysicalVerbalParticipationMode modeCode) {
        this.modeCode.setValue(modeCode);
    }


    /**
     * <p>Relationship: RCMR_MT010001NB.Author.consenter</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"consenter"})
    public Consenter getConsenter() {
        return this.consenter;
    }

    /**
     * <p>Relationship: RCMR_MT010001NB.Author.consenter</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setConsenter(Consenter consenter) {
        this.consenter = consenter;
    }

    public PatientBean getConsenterAsPatient() {
        return this.consenter instanceof PatientBean ? (PatientBean) this.consenter : null;
    }
    public boolean hasConsenterAsPatient() {
        return (this.consenter instanceof PatientBean);
    }

    public ResponsiblePersonBean getConsenterAsResponsibleParty() {
        return this.consenter instanceof ResponsiblePersonBean ? (ResponsiblePersonBean) this.consenter : null;
    }
    public boolean hasConsenterAsResponsibleParty() {
        return (this.consenter instanceof ResponsiblePersonBean);
    }

}
