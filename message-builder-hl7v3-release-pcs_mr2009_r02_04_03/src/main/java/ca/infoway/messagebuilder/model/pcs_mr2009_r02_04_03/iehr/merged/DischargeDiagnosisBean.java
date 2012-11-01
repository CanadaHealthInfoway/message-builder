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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.iehr.merged;

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
 * <p>DischargeDiagnosis</p>
 * 
 * <p>REPC_MT500001CA.DiagnosisEvent: Discharge Diagnosis</p>
 * 
 * <p><p>Describes the health conditions which were identified 
 * or determined as part of the encounter.</p></p>
 * 
 * <p><p>These are key elements in defining the encounter.</p></p>
 * 
 * <p>REPC_MT500003CA.DiagnosisEvent: Discharge Diagnosis</p>
 * 
 * <p><p>Describes the health conditions which were identified 
 * or determined as part of the encounter.</p></p>
 * 
 * <p><p>These are key elements in defining the encounter.</p></p>
 * 
 * <p>REPC_MT500002CA.DiagnosisEvent: Discharge Diagnosis</p>
 * 
 * <p><p>Describes the health conditions which were identified 
 * or determined as part of the encounter.</p></p>
 * 
 * <p><p>These are key elements in defining the encounter.</p></p>
 * 
 * <p>REPC_MT500004CA.DiagnosisEvent: Discharge Diagnosis</p>
 * 
 * <p><p>Describes the health conditions which were identified 
 * or determined as part of the encounter.</p></p>
 * 
 * <p><p>These are key elements in defining the encounter.</p></p>
 */
@Hl7PartTypeMapping({"REPC_MT500001CA.DiagnosisEvent","REPC_MT500002CA.DiagnosisEvent","REPC_MT500003CA.DiagnosisEvent","REPC_MT500004CA.DiagnosisEvent"})
public class DischargeDiagnosisBean extends MessagePartBean {

    private static final long serialVersionUID = 20120106L;
    private CD code = new CDImpl();
    private CV value = new CVImpl();


    /**
     * <p>DiagnosisType</p>
     * 
     * <p>A:Diagnosis Type</p>
     * 
     * <p><p>Code is fixed to DX if not using SNOMED</p></p>
     * 
     * <p><p>Identifies the type of diagnosis</p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getCode() {
        return (Code) this.code.getValue();
    }
    public void setCode(Code code) {
        this.code.setValue(code);
    }


    /**
     * <p>DiagnosisCode</p>
     * 
     * <p>Diagnosis Code</p>
     * 
     * <p><p>A coded form of the condition that was identified as 
     * part of the care delivery described by this Care 
     * Composition.</p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"value"})
    public DiagnosisValue getValue() {
        return (DiagnosisValue) this.value.getValue();
    }
    public void setValue(DiagnosisValue value) {
        this.value.setValue(value);
    }

}