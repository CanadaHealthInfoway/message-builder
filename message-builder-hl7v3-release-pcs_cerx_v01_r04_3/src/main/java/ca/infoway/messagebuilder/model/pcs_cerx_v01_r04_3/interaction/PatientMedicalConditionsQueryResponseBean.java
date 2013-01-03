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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.quqi_mt120000ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.iehr.repc_mt000007ca.MedicalConditionBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged.GenericQueryParametersBean;



/**
 * <p>Business Name: REPC_IN000024CA: Patient medical 
 * conditions query response</p>
 * 
 * <p>Returns the details of one or more medical condition 
 * records.</p>
 * 
 * <p>Message: MCCI_MT000300CA.Message</p>
 * 
 * <p>Payload: QUQI_MT120000CA.ControlActEvent</p>
 * 
 * <p>--> Sub-Payload: REPC_MT000007CA.MedicalCondition</p>
 * 
 * <p>--> Sub-Payload: REPC_MT000015CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"REPC_IN000024CA"})
public class PatientMedicalConditionsQueryResponseBean extends HL7Message_1Bean<TriggerEventBean<MedicalConditionBean,GenericQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20130103L;

}
