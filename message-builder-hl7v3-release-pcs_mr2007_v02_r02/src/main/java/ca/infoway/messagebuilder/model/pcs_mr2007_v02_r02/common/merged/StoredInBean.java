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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.domainvalue.ParticipationType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.coct_mt050202ca.PatientBean;



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
 * inclusion of patient identity simplifies logging, processing 
 * and application of data access constraints such as masking 
 * and consent. Finally, patient id is required to support both 
 * EHR Index (record and update) and Patient Profile Summary 
 * query (list).</p><p>Patient identity is key to successful 
 * operation of the EHR.</p><p>A bare identifier exposes the 
 * patient to potential privacy violation.</p></p>
 * 
 * <p>QUQI_MT020000CA.RecordTarget: stored in</p>
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
 * <p><p>Choice of Patient CMET is as 
 * follows:</p><p>COCT_MT050201CA 'identified' when supporting 
 * Patient Session Tokens.</p><p>COCT_MT050207CA 
 * 'informational' when passing through non Client- Registry 
 * patient for PHS or similar processing.</p><p>COCT_MT050202CA 
 * 'identified-confirmable' otherwise.</p></p>
 * 
 * <p><p>Choice of Patient CMET is as 
 * follows:</p><p>COCT_MT050201CA 'identified' when supporting 
 * Patient Session Tokens.</p><p>COCT_MT050207CA 
 * 'informational' when passing through non Client- Registry 
 * patient for PHS or similar processing.</p><p>COCT_MT050202CA 
 * 'identified-confirmable' otherwise.</p></p>
 * 
 * <p><p>Choice of Patient CMET is as 
 * follows:</p><p>COCT_MT050201CA 'identified' when supporting 
 * Patient Session Tokens.</p><p>COCT_MT050207CA 
 * 'informational' when passing through non Client- Registry 
 * patient for PHS or similar processing.</p><p>COCT_MT050202CA 
 * 'identified-confirmable' otherwise.</p></p>
 * 
 * <p><p>Choice of Patient CMET is as 
 * follows:</p><p>COCT_MT050201CA 'identified' when supporting 
 * Patient Session Tokens.</p><p>COCT_MT050207CA 
 * 'informational' when passing through non Client- Registry 
 * patient for PHS or similar processing.</p><p>COCT_MT050202CA 
 * 'identified-confirmable' otherwise.</p></p>
 * 
 * <p>MCAI_MT700217CA.RecordTarget: (no business name)</p>
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
 * <p>MCAI_MT700226CA.RecordTarget: (no business name)</p>
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
 * <p>MCAI_MT700227CA.RecordTarget: (no business name)</p>
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
 * <p>MCAI_MT700210CA.RecordTarget: (no business name)</p>
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
 * <p>MCAI_MT700237CA.RecordTarget: (no business name)</p>
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
 * <p>MCAI_MT700221CA.RecordTarget: (no business name)</p>
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
 * <p>MCAI_MT700231CA.RecordTarget: (no business name)</p>
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
 * <p>MCAI_MT700236CA.RecordTarget: (no business name)</p>
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
 */
@Hl7PartTypeMapping({"MCAI_MT700210CA.RecordTarget","MCAI_MT700211CA.RecordTarget","MCAI_MT700216CA.RecordTarget","MCAI_MT700217CA.RecordTarget","MCAI_MT700220CA.RecordTarget","MCAI_MT700221CA.RecordTarget","MCAI_MT700226CA.RecordTarget","MCAI_MT700227CA.RecordTarget","MCAI_MT700230CA.RecordTarget","MCAI_MT700231CA.RecordTarget","MCAI_MT700236CA.RecordTarget","MCAI_MT700237CA.RecordTarget","QUQI_MT020000CA.RecordTarget","QUQI_MT120006CA.RecordTarget"})
public class StoredInBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
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

    public PatientBean getPatient1AsPatient1() {
        return this.patient1 instanceof PatientBean ? (PatientBean) this.patient1 : null;
    }
    public boolean hasPatient1AsPatient1() {
        return (this.patient1 instanceof PatientBean);
    }

    public Patient_1Bean getPatient1AsPatient2() {
        return this.patient1 instanceof Patient_1Bean ? (Patient_1Bean) this.patient1 : null;
    }
    public boolean hasPatient1AsPatient2() {
        return (this.patient1 instanceof Patient_1Bean);
    }

    public ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.coct_mt050201ca.PatientBean getPatient1AsPatient3() {
        return this.patient1 instanceof ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.coct_mt050201ca.PatientBean ? (ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.coct_mt050201ca.PatientBean) this.patient1 : null;
    }
    public boolean hasPatient1AsPatient3() {
        return (this.patient1 instanceof ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.coct_mt050201ca.PatientBean);
    }

}
