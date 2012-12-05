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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.domainvalue.ParticipationType;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>QUQI_MT120006CA.RecordTarget: (no business name)</p>
 * 
 * <p>Inferring patient identity opens up the potential for 
 * privacy breach through the mis-keying of identifiers. Also, 
 * inclusion of patient identity simplifies logging, processing 
 * and application of data access constraints such as masking 
 * and consent. Finally, patient id is required to support both 
 * EHR Index (record and update) and Patient Profile Summary 
 * query (list).</p><p>Patient identity is key to successful 
 * operation of the EHR.</p><p>A bare identifier exposes the 
 * patient to potential privacy violation.</p>
 * 
 * <p>Associated patient record for which this message applies. 
 * Record target can be one of either identified patient (id, 
 * name, gender, date of birth), indeterminate patient (name, 
 * gender, date of birth) or a patient token (suggesting client 
 * identity).</p>
 * 
 * <p>MCAI_MT700230CA.RecordTarget: (no business name)</p>
 * 
 * <p>Inferring patient identity opens up the potential for 
 * privacy breach through the mis-keying of identifiers. Also, 
 * inclusion of patient identity simplifies logging, processing 
 * and application of data access constraints such as masking 
 * and consent. Finally, patient id is required to support both 
 * EHR Index (record and update) and Patient Profile Summary 
 * query (list).</p><p>Patient identity is key to successful 
 * operation of the EHR.</p><p>A bare identifier exposes the 
 * patient to potential privacy violation.</p>
 * 
 * <p>Associated patient record for which this message applies. 
 * Record target can be one of either identified patient (id, 
 * name, gender, date of birth), indeterminate patient (name, 
 * gender, date of birth) or a patient token (suggesting client 
 * identity).</p>
 * 
 * <p>MCAI_MT700216CA.RecordTarget: (no business name)</p>
 * 
 * <p>Inferring patient identity opens up the potential for 
 * privacy breach through the mis-keying of identifiers. Also, 
 * inclusion of patient identity simplifies logging, processing 
 * and application of data access constraints such as masking 
 * and consent. Finally, patient id is required to support both 
 * EHR Index (record and update) and Patient Profile Summary 
 * query (list).</p><p>Patient identity is key to successful 
 * operation of the EHR.</p><p>A bare identifier exposes the 
 * patient to potential privacy violation.</p>
 * 
 * <p>Associated patient record for which this message applies. 
 * Record target can be one of either identified patient (id, 
 * name, gender, date of birth), indeterminate patient (name, 
 * gender, date of birth) or a patient token (suggesting client 
 * identity).</p>
 * 
 * <p>MCAI_MT700220CA.RecordTarget: (no business name)</p>
 * 
 * <p>Inferring patient identity opens up the potential for 
 * privacy breach through the mis-keying of identifiers. Also, 
 * inclusion of patient identity simplifies logging, processing 
 * and application of data access constraints such as masking 
 * and consent. Finally, patient id is required to support both 
 * EHR Index (record and update) and Patient Profile Summary 
 * query (list).</p><p>Patient identity is key to successful 
 * operation of the EHR.</p><p>A bare identifier exposes the 
 * patient to potential privacy violation.</p>
 * 
 * <p>Associated patient record for which this message applies. 
 * Record target can be one of either identified patient (id, 
 * name, gender, date of birth), indeterminate patient (name, 
 * gender, date of birth) or a patient token (suggesting client 
 * identity).</p>
 * 
 * <p>MCAI_MT700211CA.RecordTarget: (no business name)</p>
 * 
 * <p>Inferring patient identity opens up the potential for 
 * privacy breach through the mis-keying of identifiers. Also, 
 * inclusion of patient identity simplifies logging, processing 
 * and application of data access constraints such as masking 
 * and consent. Finally, patient id is required to support both 
 * EHR Index (record and update) and Patient Profile Summary 
 * query (list).</p><p>Patient identity is key to successful 
 * operation of the EHR.</p><p>A bare identifier exposes the 
 * patient to potential privacy violation.</p>
 * 
 * <p>Associated patient record for which this message applies. 
 * Record target can be one of either identified patient (id, 
 * name, gender, date of birth), indeterminate patient (name, 
 * gender, date of birth) or a patient token (suggesting client 
 * identity).</p>
 * 
 * <p>QUQI_MT020000CA.RecordTarget: (no business name)</p>
 * 
 * <p>Inferring patient identity opens up the potential for 
 * privacy breach through the mis-keying of identifiers. Also, 
 * inclusion of patient identity simplifies logging, processing 
 * and application of data access constraints such as masking 
 * and consent. Finally, patient id is required to support both 
 * EHR Index (record and update) and Patient Profile Summary 
 * query (list).</p><p>Patient identity is key to successful 
 * operation of the EHR.</p><p>A bare identifier exposes the 
 * patient to potential privacy violation.</p>
 * 
 * <p>Associated patient record for which this message applies. 
 * Record target can be one of either identified patient (id, 
 * name, gender, date of birth), indeterminate patient (name, 
 * gender, date of birth) or a patient token (suggesting client 
 * identity).</p>
 * 
 * <p>MCAI_MT700217CA.RecordTarget: (no business name)</p>
 * 
 * <p>Inferring patient identity opens up the potential for 
 * privacy breach through the mis-keying of identifiers. Also, 
 * inclusion of patient identity simplifies logging, processing 
 * and application of data access constraints such as masking 
 * and consent. Finally, patient id is required to support both 
 * EHR Index (record and update) and Patient Profile Summary 
 * query (list).</p><p>Patient identity is key to successful 
 * operation of the EHR.</p><p>A bare identifier exposes the 
 * patient to potential privacy violation.</p>
 * 
 * <p>Associated patient record for which this message applies. 
 * Record target can be one of either identified patient (id, 
 * name, gender, date of birth), indeterminate patient (name, 
 * gender, date of birth) or a patient token (suggesting client 
 * identity).</p>
 * 
 * <p>MCAI_MT700226CA.RecordTarget: (no business name)</p>
 * 
 * <p>Inferring patient identity opens up the potential for 
 * privacy breach through the mis-keying of identifiers. Also, 
 * inclusion of patient identity simplifies logging, processing 
 * and application of data access constraints such as masking 
 * and consent. Finally, patient id is required to support both 
 * EHR Index (record and update) and Patient Profile Summary 
 * query (list).</p><p>Patient identity is key to successful 
 * operation of the EHR.</p><p>A bare identifier exposes the 
 * patient to potential privacy violation.</p>
 * 
 * <p>Associated patient record for which this message applies. 
 * Record target can be one of either identified patient (id, 
 * name, gender, date of birth), indeterminate patient (name, 
 * gender, date of birth) or a patient token (suggesting client 
 * identity).</p>
 * 
 * <p>MCAI_MT700227CA.RecordTarget: (no business name)</p>
 * 
 * <p>Inferring patient identity opens up the potential for 
 * privacy breach through the mis-keying of identifiers. Also, 
 * inclusion of patient identity simplifies logging, processing 
 * and application of data access constraints such as masking 
 * and consent. Finally, patient id is required to support both 
 * EHR Index (record and update) and Patient Profile Summary 
 * query (list).</p><p>Patient identity is key to successful 
 * operation of the EHR.</p><p>A bare identifier exposes the 
 * patient to potential privacy violation.</p>
 * 
 * <p>Associated patient record for which this message applies. 
 * Record target can be one of either identified patient (id, 
 * name, gender, date of birth), indeterminate patient (name, 
 * gender, date of birth) or a patient token (suggesting client 
 * identity).</p>
 * 
 * <p>MCAI_MT700210CA.RecordTarget: (no business name)</p>
 * 
 * <p>Inferring patient identity opens up the potential for 
 * privacy breach through the mis-keying of identifiers. Also, 
 * inclusion of patient identity simplifies logging, processing 
 * and application of data access constraints such as masking 
 * and consent. Finally, patient id is required to support both 
 * EHR Index (record and update) and Patient Profile Summary 
 * query (list).</p><p>Patient identity is key to successful 
 * operation of the EHR.</p><p>A bare identifier exposes the 
 * patient to potential privacy violation.</p>
 * 
 * <p>Associated patient record for which this message applies. 
 * Record target can be one of either identified patient (id, 
 * name, gender, date of birth), indeterminate patient (name, 
 * gender, date of birth) or a patient token (suggesting client 
 * identity).</p>
 * 
 * <p>MCAI_MT700237CA.RecordTarget: (no business name)</p>
 * 
 * <p>Inferring patient identity opens up the potential for 
 * privacy breach through the mis-keying of identifiers. Also, 
 * inclusion of patient identity simplifies logging, processing 
 * and application of data access constraints such as masking 
 * and consent. Finally, patient id is required to support both 
 * EHR Index (record and update) and Patient Profile Summary 
 * query (list).</p><p>Patient identity is key to successful 
 * operation of the EHR.</p><p>A bare identifier exposes the 
 * patient to potential privacy violation.</p>
 * 
 * <p>Associated patient record for which this message applies. 
 * Record target can be one of either identified patient (id, 
 * name, gender, date of birth), indeterminate patient (name, 
 * gender, date of birth) or a 
 * ... [rest of documentation truncated due to excessive length]
 */
@Hl7PartTypeMapping({"MCAI_MT700210CA.RecordTarget","MCAI_MT700211CA.RecordTarget","MCAI_MT700216CA.RecordTarget","MCAI_MT700217CA.RecordTarget","MCAI_MT700220CA.RecordTarget","MCAI_MT700221CA.RecordTarget","MCAI_MT700226CA.RecordTarget","MCAI_MT700227CA.RecordTarget","MCAI_MT700230CA.RecordTarget","MCAI_MT700231CA.RecordTarget","MCAI_MT700236CA.RecordTarget","MCAI_MT700237CA.RecordTarget","QUQI_MT020000CA.RecordTarget","QUQI_MT120006CA.RecordTarget"})
public class RecordTargetBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private CS typeCode = new CSImpl();
    private Patient_2 patient1;


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: QUQI_MT120006CA.RecordTarget.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700230CA.RecordTarget.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700216CA.RecordTarget.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700220CA.RecordTarget.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700211CA.RecordTarget.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: QUQI_MT020000CA.RecordTarget.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700217CA.RecordTarget.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700226CA.RecordTarget.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700227CA.RecordTarget.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700210CA.RecordTarget.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700237CA.RecordTarget.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700221CA.RecordTarget.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700231CA.RecordTarget.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700236CA.RecordTarget.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"typeCode"})
    public ParticipationType getTypeCode() {
        return (ParticipationType) this.typeCode.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: QUQI_MT120006CA.RecordTarget.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700230CA.RecordTarget.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700216CA.RecordTarget.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700220CA.RecordTarget.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700211CA.RecordTarget.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: QUQI_MT020000CA.RecordTarget.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700217CA.RecordTarget.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700226CA.RecordTarget.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700227CA.RecordTarget.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700210CA.RecordTarget.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700237CA.RecordTarget.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700221CA.RecordTarget.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700231CA.RecordTarget.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700236CA.RecordTarget.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setTypeCode(ParticipationType typeCode) {
        this.typeCode.setValue(typeCode);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: QUQI_MT120006CA.RecordTarget.patient1</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700230CA.RecordTarget.patient1</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700216CA.RecordTarget.patient1</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700220CA.RecordTarget.patient1</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700211CA.RecordTarget.patient1</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: QUQI_MT020000CA.RecordTarget.patient1</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700217CA.RecordTarget.patient1</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700226CA.RecordTarget.patient1</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700227CA.RecordTarget.patient1</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700210CA.RecordTarget.patient1</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700237CA.RecordTarget.patient1</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700221CA.RecordTarget.patient1</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700231CA.RecordTarget.patient1</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700236CA.RecordTarget.patient1</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"patient1"})
    public Patient_2 getPatient1() {
        return this.patient1;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: QUQI_MT120006CA.RecordTarget.patient1</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700230CA.RecordTarget.patient1</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700216CA.RecordTarget.patient1</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700220CA.RecordTarget.patient1</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700211CA.RecordTarget.patient1</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: QUQI_MT020000CA.RecordTarget.patient1</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700217CA.RecordTarget.patient1</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700226CA.RecordTarget.patient1</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700227CA.RecordTarget.patient1</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700210CA.RecordTarget.patient1</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700237CA.RecordTarget.patient1</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700221CA.RecordTarget.patient1</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700231CA.RecordTarget.patient1</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700236CA.RecordTarget.patient1</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setPatient1(Patient_2 patient1) {
        this.patient1 = patient1;
    }

}
