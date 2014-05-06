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
package ca.infoway.messagebuilder.model.ab_r02_05_00_pa.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.common.merged.TriggerEvent_2Bean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.pharmacy.porx_mt010110ca.PrescriptionBean;



/**
 * <p>Business Name: PORX_IN010940CA: Device prescr. fulfill 
 * request (no resp.)</p>
 * 
 * <p>Requests that the specified facility dispense the device 
 * prescription transmitted by this interaction and does not 
 * expect a response interaction</p>
 * 
 * <p>Message: MCCI_MT002300CA.Message</p>
 * 
 * <p>Control Act: MCAI_MT700220CA.ControlActEvent</p>
 * 
 * <p>--> Payload: PORX_MT010110CA.DeviceRequest</p>
 */
@Hl7PartTypeMapping({"PORX_IN010940CA"})
public class DevicePrescrFulfillRequestNoRespBean extends HL7Message_1Bean<TriggerEvent_2Bean<PrescriptionBean>> implements InteractionBean {

    private static final long serialVersionUID = 20140501L;

}