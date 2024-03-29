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
package ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.pharmacy.porx_mt980050on;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.DiagnosisValue;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Diagnosis Indications</p>
 * 
 * <p>Code must be fixed to DX if not using SNOMED</p>
 * 
 * <p>Value is mandatory if not using SNOMED</p>
 * 
 * <p>Allows separation of conditions from symptoms from other 
 * forms of indication.</p>
 * 
 * <p>Describes diagnosis-related indications</p>
 */
@Hl7PartTypeMapping({"PORX_MT980050ON.ObservationDiagnosis"})
public class DiagnosisIndicationsBean extends MessagePartBean implements Indications {

    private static final long serialVersionUID = 20190731L;
    private CD code = new CDImpl();
    private ST text = new STImpl();
    private CV value = new CVImpl();


    /**
     * <p>Business Name: Diagnosis Type</p>
     * 
     * <p>Relationship: PORX_MT980050ON.ObservationDiagnosis.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies this measurement as a type of diagnosis and is 
     * therefore mandatory. It is set to CD because SNOMED codes 
     * may require post-coordination</p>
     * 
     * <p>For SNOMED, the complete diagnosis appears here. For 
     * non-SNOMED this should be a fixed value of 
     * &quot;DX&quot;.</p>
     * 
     * <p>Identifies the type of diagnosis</p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
    }

    /**
     * <p>Business Name: Diagnosis Type</p>
     * 
     * <p>Relationship: PORX_MT980050ON.ObservationDiagnosis.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies this measurement as a type of diagnosis and is 
     * therefore mandatory. It is set to CD because SNOMED codes 
     * may require post-coordination</p>
     * 
     * <p>For SNOMED, the complete diagnosis appears here. For 
     * non-SNOMED this should be a fixed value of 
     * &quot;DX&quot;.</p>
     * 
     * <p>Identifies the type of diagnosis</p>
     */
    public void setCode(ActCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Free Form Diagnosis Indication</p>
     * 
     * <p>Relationship: PORX_MT980050ON.ObservationDiagnosis.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides greater flexibility in specifying 
     * indication.</p>
     * 
     * <p>A free form description augmenting the specified 
     * diagnosis code.</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: Free Form Diagnosis Indication</p>
     * 
     * <p>Relationship: PORX_MT980050ON.ObservationDiagnosis.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides greater flexibility in specifying 
     * indication.</p>
     * 
     * <p>A free form description augmenting the specified 
     * diagnosis code.</p>
     */
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>Business Name: A:Diagnosis Code</p>
     * 
     * <p>Relationship: PORX_MT980050ON.ObservationDiagnosis.value</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Allows cross-checking the use of a therapy against its 
     * indication. Also allows analysis of best practices, etc. 
     * This attribute is optional because it is not used by 
     * SNOMED.</p>
     * 
     * <p>A coded form of the diagnosis that is the reason for the 
     * current action.</p>
     */
    @Hl7XmlMapping({"value"})
    public DiagnosisValue getValue() {
        return (DiagnosisValue) this.value.getValue();
    }

    /**
     * <p>Business Name: A:Diagnosis Code</p>
     * 
     * <p>Relationship: PORX_MT980050ON.ObservationDiagnosis.value</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Allows cross-checking the use of a therapy against its 
     * indication. Also allows analysis of best practices, etc. 
     * This attribute is optional because it is not used by 
     * SNOMED.</p>
     * 
     * <p>A coded form of the diagnosis that is the reason for the 
     * current action.</p>
     */
    public void setValue(DiagnosisValue value) {
        this.value.setValue(value);
    }

}
