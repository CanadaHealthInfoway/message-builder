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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.common.mcai_mt700220on.TriggerEventBean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.common.mcci_mt000300on.HL7MessageBean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.pharmacy.porx_mt060350on.Prescription;



/**
 * <p>Business Name: PORX_IN010110ON: Revise assigned dispense 
 * responsibility req. acc.</p>
 * 
 * <p>Indicates that the responsibility for fulfilling the 
 * dispense portion of a prescription has been changed to the 
 * requested facility.</p>
 * 
 * <p>Message: MCCI_MT000300ON.Message</p>
 * 
 * <p>Control Act: MCAI_MT700220ON.ControlActEvent</p>
 * 
 * <p>--> Payload: PORX_MT060350ON.Prescription</p>
 * 
 * <p>----> Payload Choice: 
 * PORX_MT060340ON.CombinedMedicationRequest</p>
 * 
 * <p>----> Payload Choice: PORX_MT060040ON.DeviceRequest</p>
 */
@Hl7PartTypeMapping({"PORX_IN010110ON"})
public class ReviseAssignedDispenseResponsibilityReqAccBean extends HL7MessageBean<TriggerEventBean<Prescription>> implements InteractionBean {

    private static final long serialVersionUID = 20150326L;

}
