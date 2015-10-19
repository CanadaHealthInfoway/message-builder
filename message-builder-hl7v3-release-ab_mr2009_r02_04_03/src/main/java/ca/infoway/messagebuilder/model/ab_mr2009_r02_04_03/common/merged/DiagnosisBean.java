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
package ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.DiagnosisValue;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.domainvalue.ActDiagnosisCode;



/**
 * <p>Business Name: Diagnosis</p>
 * 
 * <p>COCT_MT290000CA.Diagnosis: Diagnosis</p>
 * 
 * <p>More than 1 diagnosis may be specified to justify the 
 * performing of a particular service.</p><p>A specific 
 * diagnosis code must always be specified, and may be 
 * supplemented by descriptive text.</p><p>For some services 
 * (e.g. provider's review of a file), the diagnosis may not be 
 * known.</p>
 * 
 * <p>Diagnosis</p>
 * 
 * <p>COCT_MT490000CA.Diagnosis: Diagnosis</p>
 * 
 * <p>Patient Diagnosis</p>
 */
@Hl7PartTypeMapping({"COCT_MT290000CA.Diagnosis","COCT_MT490000CA.Diagnosis"})
public class DiagnosisBean extends MessagePartBean {

    private static final long serialVersionUID = 20151019L;
    private CV code = new CVImpl();
    private ST text = new STImpl();
    private CV value = new CVImpl();


    /**
     * <p>Un-merged Business Name: DiagnosisType</p>
     * 
     * <p>Relationship: COCT_MT290000CA.Diagnosis.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>admit, intermediate, discharge diagnosis</p>
     * 
     * <p>Un-merged Business Name: DiagnosisCode</p>
     * 
     * <p>Relationship: COCT_MT490000CA.Diagnosis.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>ObservationDiagnosis Type</p>
     */
    @Hl7XmlMapping({"code"})
    public ActDiagnosisCode getCode() {
        return (ActDiagnosisCode) this.code.getValue();
    }

    /**
     * <p>Un-merged Business Name: DiagnosisType</p>
     * 
     * <p>Relationship: COCT_MT290000CA.Diagnosis.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>admit, intermediate, discharge diagnosis</p>
     * 
     * <p>Un-merged Business Name: DiagnosisCode</p>
     * 
     * <p>Relationship: COCT_MT490000CA.Diagnosis.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>ObservationDiagnosis Type</p>
     */
    public void setCode(ActDiagnosisCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: DiagnosisDescription</p>
     * 
     * <p>Un-merged Business Name: DiagnosisDescription</p>
     * 
     * <p>Relationship: COCT_MT290000CA.Diagnosis.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Can be used to supplement a diagnostic code</p>
     * 
     * <p>Can be used to supplement a diagnostic code</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: DiagnosisDescription</p>
     * 
     * <p>Un-merged Business Name: DiagnosisDescription</p>
     * 
     * <p>Relationship: COCT_MT290000CA.Diagnosis.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Can be used to supplement a diagnostic code</p>
     * 
     * <p>Can be used to supplement a diagnostic code</p>
     */
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>Business Name: DiagnosisValue</p>
     * 
     * <p>Un-merged Business Name: DiagnosisValue</p>
     * 
     * <p>Relationship: COCT_MT290000CA.Diagnosis.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Diagnosis Code eg. ICD-10-CA code.</p>
     * 
     * <p>Un-merged Business Name: DiagnosisValue</p>
     * 
     * <p>Relationship: COCT_MT490000CA.Diagnosis.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>coded Value denoting diagnosis</p>
     */
    @Hl7XmlMapping({"value"})
    public DiagnosisValue getValue() {
        return (DiagnosisValue) this.value.getValue();
    }

    /**
     * <p>Business Name: DiagnosisValue</p>
     * 
     * <p>Un-merged Business Name: DiagnosisValue</p>
     * 
     * <p>Relationship: COCT_MT290000CA.Diagnosis.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Diagnosis Code eg. ICD-10-CA code.</p>
     * 
     * <p>Un-merged Business Name: DiagnosisValue</p>
     * 
     * <p>Relationship: COCT_MT490000CA.Diagnosis.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>coded Value denoting diagnosis</p>
     */
    public void setValue(DiagnosisValue value) {
        this.value.setValue(value);
    }

}
