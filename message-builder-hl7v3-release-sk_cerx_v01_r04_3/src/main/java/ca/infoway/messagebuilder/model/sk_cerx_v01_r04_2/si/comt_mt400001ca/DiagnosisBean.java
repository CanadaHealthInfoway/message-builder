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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.si.comt_mt400001ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.DiagnosisValue;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Diagnosis</p>
 * 
 * <p>If code is SNOMED, value must not be specified. Otherwise 
 * value is mandatory and code must be DX</p>
 * 
 * <p>Conveys information about a diagnosis to be masked</p>
 * 
 * <p>Allows masking of items related to a particular medical 
 * condition.</p>
 */
@Hl7PartTypeMapping({"COMT_MT400001CA.Diagnosis"})
public class DiagnosisBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private CV code = new CVImpl();
    private CV value = new CVImpl();


    /**
     * <p>Business Name: A:Diagnosis Type</p>
     * 
     * <p>Relationship: COMT_MT400001CA.Diagnosis.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to indicate that this observation is a diagnosis, 
     * and for SNOMED, provides details of what the diagnosis 
     * is.</p>
     * 
     * <p>Needed to convey the diagnosis information to be masked, 
     * and attribute is therefore mandatory.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
    }

    /**
     * <p>Business Name: A:Diagnosis Type</p>
     * 
     * <p>Relationship: COMT_MT400001CA.Diagnosis.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to indicate that this observation is a diagnosis, 
     * and for SNOMED, provides details of what the diagnosis 
     * is.</p>
     * 
     * <p>Needed to convey the diagnosis information to be masked, 
     * and attribute is therefore mandatory.</p>
     */
    public void setCode(ActCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: B:Diagnosis</p>
     * 
     * <p>Relationship: COMT_MT400001CA.Diagnosis.value</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>The diagnosis whose associated records should be 
     * masked.</p>
     * 
     * <p>Allows masking of all records (prescriptions, dispenses, 
     * encounters, lab tests, etc.) associated with the specified 
     * diagnosis. This element is optional because it is not used 
     * for SNOMED.</p>
     */
    @Hl7XmlMapping({"value"})
    public DiagnosisValue getValue() {
        return (DiagnosisValue) this.value.getValue();
    }

    /**
     * <p>Business Name: B:Diagnosis</p>
     * 
     * <p>Relationship: COMT_MT400001CA.Diagnosis.value</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>The diagnosis whose associated records should be 
     * masked.</p>
     * 
     * <p>Allows masking of all records (prescriptions, dispenses, 
     * encounters, lab tests, etc.) associated with the specified 
     * diagnosis. This element is optional because it is not used 
     * for SNOMED.</p>
     */
    public void setValue(DiagnosisValue value) {
        this.value.setValue(value);
    }

}
