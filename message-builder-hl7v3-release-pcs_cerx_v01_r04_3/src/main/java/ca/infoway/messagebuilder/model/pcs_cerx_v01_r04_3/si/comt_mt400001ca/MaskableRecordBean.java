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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.si.comt_mt400001ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActInformationCategoryCode;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.merged.PatientBean;



@Hl7PartTypeMapping({"COMT_MT400001CA.MaskableActType"})
@Hl7RootType
public class MaskableRecordBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private II recordIdentifier = new IIImpl();
    private CV recordType = new CVImpl();
    private CV maskedIndicator = new CVImpl();
    private RoleBean directTargetRole;
    private PatientBean recordTargetPatient;
    private DiagnosisBean reasonDiagnosis;


    /**
     * <p>C:Record Identifier</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getRecordIdentifier() {
        return this.recordIdentifier.getValue();
    }
    public void setRecordIdentifier(Identifier recordIdentifier) {
        this.recordIdentifier.setValue(recordIdentifier);
    }


    /**
     * <p>B:Record Type</p>
     */
    @Hl7XmlMapping({"code"})
    public ActInformationCategoryCode getRecordType() {
        return (ActInformationCategoryCode) this.recordType.getValue();
    }
    public void setRecordType(ActInformationCategoryCode recordType) {
        this.recordType.setValue(recordType);
    }


    /**
     * <p>A:Masked Indicator</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getMaskedIndicator() {
        return (x_VeryBasicConfidentialityKind) this.maskedIndicator.getValue();
    }
    public void setMaskedIndicator(x_VeryBasicConfidentialityKind maskedIndicator) {
        this.maskedIndicator.setValue(maskedIndicator);
    }


    @Hl7XmlMapping({"directTarget/role"})
    public RoleBean getDirectTargetRole() {
        return this.directTargetRole;
    }
    public void setDirectTargetRole(RoleBean directTargetRole) {
        this.directTargetRole = directTargetRole;
    }


    @Hl7XmlMapping({"recordTarget/patient"})
    public PatientBean getRecordTargetPatient() {
        return this.recordTargetPatient;
    }
    public void setRecordTargetPatient(PatientBean recordTargetPatient) {
        this.recordTargetPatient = recordTargetPatient;
    }


    @Hl7XmlMapping({"reason/diagnosis"})
    public DiagnosisBean getReasonDiagnosis() {
        return this.reasonDiagnosis;
    }
    public void setReasonDiagnosis(DiagnosisBean reasonDiagnosis) {
        this.reasonDiagnosis = reasonDiagnosis;
    }

}
