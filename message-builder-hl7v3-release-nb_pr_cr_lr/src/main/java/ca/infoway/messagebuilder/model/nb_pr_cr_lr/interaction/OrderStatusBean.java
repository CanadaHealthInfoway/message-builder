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
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.mcai_mt700210ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.mcci_mt002100ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.lab.polb_mt001000ca.RequestChoice;



/**
 * <p>Business Name: POLB_IN211000CA: Order Status</p>
 * 
 * <p>This interaction is a Order Status without Receiver 
 * Responsibilities (i.e., the sending system utilizes messages 
 * that do not require application-level responses). This 
 * interaction is used when a order status change is 
 * communicated.</p>
 * 
 * <p>Message: MCCI_MT002100CA.Message</p>
 * 
 * <p>Control Act: MCAI_MT700210CA.ControlActEvent</p>
 * 
 * <p>--> Payload: POLB_MT001000CA.RequestChoice</p>
 * 
 * <p>----> Payload Choice: POLB_MT001000CA.PlacerGroup</p>
 * 
 * <p>----> Payload Choice: POLB_MT001000CA.BatteryRequest</p>
 * 
 * <p>----> Payload Choice: POLB_MT001000CA.ObservationRequest</p>
 */
@Hl7PartTypeMapping({"POLB_IN211000CA"})
public class OrderStatusBean extends HL7MessageBean<TriggerEventBean<RequestChoice>> implements InteractionBean {

    private static final long serialVersionUID = 20151013L;

}
