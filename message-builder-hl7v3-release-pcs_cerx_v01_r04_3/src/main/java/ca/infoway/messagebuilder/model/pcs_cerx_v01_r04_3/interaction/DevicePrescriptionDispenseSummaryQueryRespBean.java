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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.quqi_mt120000ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.PrescriptionDispenseBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.porx_mt060030ca.GenericQueryParametersBean;



/**
 * <p>Business Name: PORX_IN060080CA: Device prescription 
 * dispense summary query resp.</p>
 * 
 * <p>Returns basic information about all device dispenses 
 * provided to a particular patient.</p>
 * 
 * <p>Message: MCCI_MT000300CA.Message</p>
 * 
 * <p>Payload: QUQI_MT120000CA.ControlActEvent</p>
 * 
 * <p>--> Sub-Payload: PORX_MT060020CA.DeviceDispense</p>
 * 
 * <p>--> Sub-Payload: PORX_MT060030CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"PORX_IN060080CA"})
public class DevicePrescriptionDispenseSummaryQueryRespBean extends HL7Message_1Bean<TriggerEventBean<PrescriptionDispenseBean,GenericQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20121204L;

}
