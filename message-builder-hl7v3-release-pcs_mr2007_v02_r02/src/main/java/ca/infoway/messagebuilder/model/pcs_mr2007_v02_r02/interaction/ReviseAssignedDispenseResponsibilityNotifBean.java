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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged.TriggerEvent_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.merged.DispenseInstructions_1Bean;



/**
 * <p>Business Name: PORX_IN010090CA: Revise assigned dispense 
 * responsibility notif.</p>
 * 
 * <p>Indicates that the responsibility for fulfilling the 
 * dispense portion of a prescription has changed.</p>
 * 
 * <p>Message: MCCI_MT002100CA.Message</p>
 * 
 * <p>Control Act: MCAI_MT700211CA.ControlActEvent</p>
 * 
 * <p>--> Payload: PORX_MT010140CA.SupplyRequest</p>
 */
@Hl7PartTypeMapping({"PORX_IN010090CA"})
public class ReviseAssignedDispenseResponsibilityNotifBean extends HL7Message_1Bean<TriggerEvent_1Bean<DispenseInstructions_1Bean>> implements InteractionBean {

    private static final long serialVersionUID = 20130613L;

}
