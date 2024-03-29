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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.mcai_mt700226ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.mcci_mt002300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.porx_mt060350ca.Prescription;



/**
 * <p>Business Name: PORX_IN010110CA: Revise assigned dispense 
 * responsibility req. acc.</p>
 * 
 * <p>Indicates that the responsibility for fulfilling the 
 * dispense portion of a prescription has been changed to the 
 * requested facility.</p>
 * 
 * <p>Message: MCCI_MT002300CA.Message</p>
 * 
 * <p>Control Act: MCAI_MT700226CA.ControlActEvent</p>
 * 
 * <p>--&gt; Payload: PORX_MT060350CA.Prescription</p>
 * 
 * <p>----&gt; Payload Choice: 
 * PORX_MT060340CA.CombinedMedicationRequest</p>
 * 
 * <p>----&gt; Payload Choice: PORX_MT060040CA.DeviceRequest</p>
 */
@Hl7PartTypeMapping({"PORX_IN010110CA"})
public class ReviseAssignedDispenseResponsibilityReqAccBean extends HL7MessageBean<TriggerEventBean<Prescription>> implements InteractionBean {

    private static final long serialVersionUID = 20190730L;

}
