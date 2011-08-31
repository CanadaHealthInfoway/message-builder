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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.DiagnosisValue;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>DischargeDiagnoses</p>
 * 
 * <p>REPC_MT220002CA.ConditionEvent: Discharge Diagnoses</p>
 * 
 * <p><p>Describes one of the conditions associated with the 
 * patient as part of the encounter.</p></p>
 * 
 * <p><p>Commonly used for reporting, but also useful for 
 * searching and for obtaining a general understanding of the 
 * encounter.</p></p>
 * 
 * <p>REPC_MT220001CA.ConditionEvent: Discharge Diagnoses</p>
 * 
 * <p><p>Describes one of the conditions associated with the 
 * patient as part of the encounter.</p></p>
 * 
 * <p><p>Commonly used for reporting, but also useful for 
 * searching and for obtaining a general understanding of the 
 * encounter.</p></p>
 * 
 * <p>REPC_MT220003CA.ConditionEvent: Discharge Diagnoses</p>
 * 
 * <p><p>Describes one of the conditions associated with the 
 * patient as part of the encounter.</p></p>
 * 
 * <p><p>Commonly used for reporting, but also useful for 
 * searching and for obtaining a general understanding of the 
 * encounter.</p></p>
 */
@Hl7PartTypeMapping({"REPC_MT220001CA.ConditionEvent","REPC_MT220002CA.ConditionEvent","REPC_MT220003CA.ConditionEvent"})
public class DischargeDiagnosesBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private CD dischargeDiagnosisType = new CDImpl();
    private CV diagnosisCode = new CVImpl();


    /**
     * <p>DischargeDiagnosisType</p>
     * 
     * <p>A: Discharge Diagnosis Type</p>
     * 
     * <p><p>Code is fixed to DX if not using SNOMED</p></p>
     * 
     * <p><p>Identifications of the type of diagnosis at the time 
     * of discharge.</p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p><p>For SNOMED, the complete diagnosis appears here. For 
     * non-SNOMED this should be a fixed value of 
     * &quot;DX&quot;.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getDischargeDiagnosisType() {
        return (Code) this.dischargeDiagnosisType.getValue();
    }
    public void setDischargeDiagnosisType(Code dischargeDiagnosisType) {
        this.dischargeDiagnosisType.setValue(dischargeDiagnosisType);
    }


    /**
     * <p>DiagnosisCode</p>
     * 
     * <p>B:Diagnosis Code</p>
     * 
     * <p><p>Identifies the actual discharge diagnosis.</p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"value"})
    public DiagnosisValue getDiagnosisCode() {
        return (DiagnosisValue) this.diagnosisCode.getValue();
    }
    public void setDiagnosisCode(DiagnosisValue diagnosisCode) {
        this.diagnosisCode.setValue(diagnosisCode);
    }

}
