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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.merged.TriggerEvent_4Bean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.pharmacy.porx_mt060070ca.QueryParametersBean;



/**
 * <p>PORX_IN060130CA: Device prescription summary query</p>
 * 
 * <p>Message: MCCI_MT002100CA.Message</p>
 * 
 * <p>Payload: QUQI_MT020000CA.ControlActEvent</p>
 * 
 * <p>--> Sub-Payload: PORX_MT060070CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"PORX_IN060130CA"})
public class DevicePrescriptionSummaryQueryBean extends HL7Message_1Bean<TriggerEvent_4Bean<QueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20121122L;

}
