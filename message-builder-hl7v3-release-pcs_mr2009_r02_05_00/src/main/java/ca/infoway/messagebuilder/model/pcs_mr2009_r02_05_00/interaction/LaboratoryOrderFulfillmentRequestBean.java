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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.common.mcai_mt700210ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.common.mcci_mt002100ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.lab.polb_mt001000ca.RequestChoice;



/**
 * <p>Business Name: POLB_IN111100CA: Laboratory Order 
 * Fulfillment Request</p>
 * 
 * <p>This interaction is a Order Fulfillment Request with 
 * Receiver Responsibilities (application-level responses are 
 * required). It is requested that filler perform the order, 
 * provide a completed result; and provide a promise msg with 
 * that commitment.</p>
 * 
 * <p>Message: MCCI_MT002100CA.Message</p>
 * 
 * <p>Control Act: MCAI_MT700210CA.ControlActEvent</p>
 * 
 * <p>--&gt; Payload: POLB_MT001000CA.RequestChoice</p>
 * 
 * <p>----&gt; Payload Choice: POLB_MT001000CA.PlacerGroup</p>
 * 
 * <p>----&gt; Payload Choice: POLB_MT001000CA.BatteryRequest</p>
 * 
 * <p>----&gt; Payload Choice: 
 * POLB_MT001000CA.ObservationRequest</p>
 */
@Hl7PartTypeMapping({"POLB_IN111100CA"})
public class LaboratoryOrderFulfillmentRequestBean extends HL7MessageBean<TriggerEventBean<RequestChoice>> implements InteractionBean {

    private static final long serialVersionUID = 20190731L;

}
