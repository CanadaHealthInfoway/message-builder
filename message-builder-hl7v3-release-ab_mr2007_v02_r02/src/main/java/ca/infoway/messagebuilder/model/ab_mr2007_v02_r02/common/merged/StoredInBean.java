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
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.domainvalue.ParticipationType;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>StoredIn</p>
 * 
 * <p>QUQI_MT120006CA.RecordTarget: (no business name)</p>
 * 
 * <p><p>Associated patient record for which this message 
 * applies. Record target can be one of either identified 
 * patient (id, name, gender, date of birth), indeterminate 
 * patient (name, gender, date of birth) or a patient token 
 * (suggesting client identity).</p></p>
 * 
 * <p><p>Inferring patient identity opens up the potential for 
 * privacy breach through the mis-keying of identifiers. Also, 
 * inclusion of patient identity simplifies logging, processing 
 * and application of data access constraints such as masking 
 * and consent. Finally, patient id is required to support both 
 * EHR Index (record and update) and Patient Profile Summary 
 * query (list).</p><p>Patient identity is key to successful 
 * operation of the EHR.</p><p>A bare identifier exposes the 
 * patient to potential privacy violation.</p></p>
 * 
 * <p><p>Inferring patient identity opens up the potential for 
 * privacy breach through the mis-keying of identifiers. Also, 
 * inclusion of patient identity simplifies logging, processing 
 * and application of data access constraints such as masking 
 * and consent. Finally, patient id is required to support both 
 * EHR Index (record and update) and Patient Profile Summary 
 * query (list).</p><p>Patient identity is key to successful 
 * operation of the EHR.</p><p>A bare identifier exposes the 
 * patient to potential privacy violation.</p></p>
 * 
 * <p><p>Inferring patient identity opens up the potential for 
 * privacy breach through the mis-keying of identifiers. Also, 
 * inclusion of patient identity simplifies logging, processing 
 * and application of data access constraints such as masking 
 * and consent. Finally, patient id is required to support both 
 * EHR Index (record and update) and Patient Profile Summary 
 * query (list).</p><p>Patient identity is key to successful 
 * operation of the EHR.</p><p>A bare identifier exposes the 
 * patient to potential privacy violation.</p></p>
 * 
 * <p>MCAI_MT700230CA.RecordTarget: (no business name)</p>
 * 
 * <p><p>Associated patient record for which this message 
 * applies. Record target can be one of either identified 
 * patient (id, name, gender, date of birth), indeterminate 
 * patient (name, gender, date of birth) or a patient token 
 * (suggesting client identity).</p></p>
 * 
 * <p><p>Inferring patient identity opens up the potential for 
 * privacy breach through the mis-keying of identifiers. Also, 
 * inclusion of patient identity simplifies logging, processing 
 * and application of data access constraints such as masking 
 * and consent. Finally, patient id is required to support both 
 * EHR Index (record and update) and Patient Profile Summary 
 * query (list).</p><p>Patient identity is key to successful 
 * operation of the EHR.</p><p>A bare identifier exposes the 
 * patient to potential privacy violation.</p></p>
 * 
 * <p><p>Inferring patient identity opens up the potential for 
 * privacy breach through the mis-keying of identifiers. Also, 
 * inclusion of patient identity simplifies logging, processing 
 * and application of data access constraints such as masking 
 * and consent. Finally, patient id is required to support both 
 * EHR Index (record and update) and Patient Profile Summary 
 * query (list).</p><p>Patient identity is key to successful 
 * operation of the EHR.</p><p>A bare identifier exposes the 
 * patient to potential privacy violation.</p></p>
 * 
 * <p><p>Inferring patient identity opens up the potential for 
 * privacy breach through the mis-keying of identifiers. Also, 
 * inclusion of patient identity simplifies logging, processing 
 * and application of data access constraints such as masking 
 * and consent. Finally, patient id is required to support both 
 * EHR Index (record and update) and Patient Profile Summary 
 * query (list).</p><p>Patient identity is key to successful 
 * operation of the EHR.</p><p>A bare identifier exposes the 
 * patient to potential privacy violation.</p></p>
 * 
 * <p>MCAI_MT700216CA.RecordTarget: (no business name)</p>
 * 
 * <p><p>Associated patient record for which this message 
 * applies. Record target can be one of either identified 
 * patient (id, name, gender, date of birth), indeterminate 
 * patient (name, gender, date of birth) or a patient token 
 * (suggesting client identity).</p></p>
 * 
 * <p><p>Inferring patient identity opens up the potential for 
 * privacy breach through the mis-keying of identifiers. Also, 
 * inclusion of patient identity simplifies logging, processing 
 * and application of data access constraints such as masking 
 * and consent. Finally, patient id is required to support both 
 * EHR Index (record and update) and Patient Profile Summary 
 * query (list).</p><p>Patient identity is key to successful 
 * operation of the EHR.</p><p>A bare identifier exposes the 
 * patient to potential privacy violation.</p></p>
 * 
 * <p><p>Inferring patient identity opens up the potential for 
 * privacy breach through the mis-keying of identifiers. Also, 
 * inclusion of patient identity simplifies logging, processing 
 * and application of data access constraints such as masking 
 * and consent. Finally, patient id is required to support both 
 * EHR Index (record and update) and Patient Profile Summary 
 * query (list).</p><p>Patient identity is key to successful 
 * operation of the EHR.</p><p>A bare identifier exposes the 
 * patient to potential privacy violation.</p></p>
 * 
 * <p><p>Inferring patient identity opens up the potential for 
 * privacy breach through the mis-keying of identifiers. Also, 
 * inclusion of patient identity simplifies logging, processing 
 * and application of data access constraints such as masking 
 * and consent. Finally, patient id is required to support both 
 * EHR Index (record and update) and Patient Profile Summary 
 * query (list).</p><p>Patient identity is key to successful 
 * operation of the EHR.</p><p>A bare identifier exposes the 
 * patient to potential privacy violation.</p></p>
 * 
 * <p>MCAI_MT700220CA.RecordTarget: (no business name)</p>
 * 
 * <p><p>Associated patient record for which this message 
 * applies. Record target can be one of either identified 
 * patient (id, name, gender, date of birth), indeterminate 
 * patient (name, gender, date of birth) or a patient token 
 * (suggesting client identity).</p></p>
 * 
 * <p><p>Inferring patient identity opens up the potential for 
 * privacy breach through the mis-keying of identifiers. Also, 
 * inclusion of patient identity simplifies logging, processing 
 * and application of data access constraints such as masking 
 * and consent. Finally, patient id is required to support both 
 * EHR Index (record and update) and Patient Profile Summary 
 * query (list).</p><p>Patient identity is key to successful 
 * operation of the EHR.</p><p>A bare identifier exposes the 
 * patient to potential privacy violation.</p></p>
 * 
 * <p><p>Inferring patient identity opens up the potential for 
 * privacy breach through the mis-keying of identifiers. Also, 
 * inclusion of patient identity simplifies logging, processing 
 * and application of data access constraints such as masking 
 * and consent. Finally, patient id is required to support both 
 * EHR Index (record and update) and Patient Profile Summary 
 * query (list).</p><p>Patient identity is key to successful 
 * operation of the EHR.</p><p>A bare identifier exposes the 
 * patient to potential privacy violation.</p></p>
 * 
 * <p><p>Inferring patient identity opens up the potential for 
 * privacy breach through the mis-keying of identifiers. Also, 
 * inclusion of patient identity simplifies logging, processing 
 * and application of data access constraints such as masking 
 * and consent. Finally, patient id is required to support both 
 * EHR Index (record and update) and Patient Profile Summary 
 * query (list).</p><p>Patient identity is key to successful 
 * operation of the EHR.</p><p>A bare identifier exposes the 
 * patient to potential privacy violation.</p></p>
 * 
 * <p>MCAI_MT700211CA.RecordTarget: (no business name)</p>
 * 
 * <p><p>Associated patient record for which this message 
 * applies. Record target can be one of either identified 
 * patient (id, name, gender, date of birth), indeterminate 
 * patient (name, gender, date of birth) or a patient token 
 * (suggesting client identity).</p></p>
 * 
 * <p><p>Inferring patient identity opens up the potential for 
 * privacy breach through the mis-keying of identifiers. Also, 
 * inclusion of patient identity simplifies logging, processing 
 * and application of data access constraints such as masking 
 * and consent. Finally, patient id is required to support both 
 * EHR Index (record and update) and Patient Profile Summary 
 * query (list).</p><p>Patient identity is key to successful 
 * operation of the EHR.</p><p>A bare identifier exposes the 
 * patient to potential privacy violation.</p></p>
 * 
 * <p><p>Inferring patient identity opens up the potential for 
 * privacy breach through the mis-keying of identifiers. Also, 
 * inclusion of patient identity simplifies logging, processing 
 * and application of data access constraints such as masking 
 * and consent. Finally, patient id is required to support both 
 * EHR Index (record and update) and Patient Profile Summary 
 * query (list).</p><p>Patient identity is key to successful 
 * operation of the EHR.</p><p>A bare identifier exposes the 
 * patient to potential privacy violation.</p></p>
 * 
 * <p><p>Inferring patient identity opens up the potential for 
 * privacy breach through the mis-keying of identifiers. Also, 
 * inclusion of patient identity simplifies logging,
 * ... [rest of documentation truncated due to excessive length]
 */
@Hl7PartTypeMapping({"MCAI_MT700210CA.RecordTarget","MCAI_MT700211CA.RecordTarget","MCAI_MT700216CA.RecordTarget","MCAI_MT700217CA.RecordTarget","MCAI_MT700220CA.RecordTarget","MCAI_MT700221CA.RecordTarget","MCAI_MT700226CA.RecordTarget","MCAI_MT700227CA.RecordTarget","MCAI_MT700230CA.RecordTarget","MCAI_MT700231CA.RecordTarget","MCAI_MT700236CA.RecordTarget","MCAI_MT700237CA.RecordTarget","QUQI_MT020000CA.RecordTarget","QUQI_MT120006CA.RecordTarget"})
public class StoredInBean extends MessagePartBean {

    private static final long serialVersionUID = 20120116L;
    private CS typeCode = new CSImpl();
    private Patient_2 patient1;


    @Hl7XmlMapping({"typeCode"})
    public ParticipationType getTypeCode() {
        return (ParticipationType) this.typeCode.getValue();
    }
    public void setTypeCode(ParticipationType typeCode) {
        this.typeCode.setValue(typeCode);
    }


    @Hl7XmlMapping({"patient1"})
    public Patient_2 getPatient1() {
        return this.patient1;
    }
    public void setPatient1(Patient_2 patient1) {
        this.patient1 = patient1;
    }

}
