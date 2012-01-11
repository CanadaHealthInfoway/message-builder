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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.DiagnosisValue;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Diagnosis</p>
 * 
 * <p>COCT_MT290000CA.Diagnosis: Diagnosis</p>
 * 
 * <p><p>Diagnosis</p></p>
 * 
 * <p><p>More than 1 diagnosis may be specified to justify the 
 * performing of a particular service.</p><p>A specific 
 * diagnosis code must always be specified, and may be 
 * supplemented by descriptive text.</p><p>For some services 
 * (e.g. provider's review of a file), the diagnosis may not be 
 * known.</p></p>
 * 
 * <p><p>More than 1 diagnosis may be specified to justify the 
 * performing of a particular service.</p><p>A specific 
 * diagnosis code must always be specified, and may be 
 * supplemented by descriptive text.</p><p>For some services 
 * (e.g. provider's review of a file), the diagnosis may not be 
 * known.</p></p>
 * 
 * <p><p>More than 1 diagnosis may be specified to justify the 
 * performing of a particular service.</p><p>A specific 
 * diagnosis code must always be specified, and may be 
 * supplemented by descriptive text.</p><p>For some services 
 * (e.g. provider's review of a file), the diagnosis may not be 
 * known.</p></p>
 * 
 * <p>COCT_MT490000CA.Diagnosis: Diagnosis</p>
 * 
 * <p><p>Patient Diagnosis</p></p>
 * 
 * <p>COMT_MT400001CA.Diagnosis: Diagnosis</p>
 * 
 * <p><p>Conveys information about a diagnosis to be masked</p></p>
 * 
 * <p><p>Allows masking of items related to a particular 
 * medical condition.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT290000CA.Diagnosis","COCT_MT490000CA.Diagnosis","COMT_MT400001CA.Diagnosis"})
public class DiagnosisBean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
    private CV code = new CVImpl();
    private ST text = new STImpl();
    private CV value = new CVImpl();


    /**
     * <p>A:Diagnosis Type</p>
     * 
     * <p><p>If code is SNOMED, value must not be specified. 
     * Otherwise value is mandatory and code must be DX</p></p>
     * 
     * <p><p>Used to indicate that this observation is a diagnosis, 
     * and for SNOMED, provides details of what the diagnosis 
     * is.</p></p>
     * 
     * <p><p>Needed to convey the diagnosis information to be 
     * masked, and attribute is therefore mandatory.</p></p>
     * 
     * <p>Diagnosis type</p>
     * 
     * <p><p>admit, intermediate, discharge diagnosis</p></p>
     * 
     * <p>Diagnosis Code</p>
     * 
     * <p><p>ObservationDiagnosis Type</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
    }
    public void setCode(ActCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>DiagnosisDescription</p>
     * 
     * <p>Diagnosis Description</p>
     * 
     * <p><p>Can be used to supplement a diagnostic code</p></p>
     * 
     * <p><p>Can be used to supplement a diagnostic code</p></p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>Diagnosis Value</p>
     * 
     * <p><p>coded Value denoting diagnosis</p></p>
     * 
     * <p>B:Diagnosis</p>
     * 
     * <p><p>The diagnosis whose associated records should be 
     * masked.</p></p>
     * 
     * <p><p>Allows masking of all records (prescriptions, 
     * dispenses, encounters, lab tests, etc.) associated with the 
     * specified diagnosis. This element is optional because it is 
     * not used for SNOMED.</p></p>
     * 
     * <p>Diagnosis Value</p>
     * 
     * <p><p>Diagnosis Code eg. ICD-10-CA code.</p></p>
     */
    @Hl7XmlMapping({"value"})
    public DiagnosisValue getValue() {
        return (DiagnosisValue) this.value.getValue();
    }
    public void setValue(DiagnosisValue value) {
        this.value.setValue(value);
    }

}
