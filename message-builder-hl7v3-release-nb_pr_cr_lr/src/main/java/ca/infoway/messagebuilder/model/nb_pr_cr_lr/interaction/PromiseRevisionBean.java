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
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.mcai_mt700210nb.TriggerEventBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.mcci_mt002100nb.HL7MessageBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.lab.polb_mt002000nb.PromiseChoice;



/**
 * <p>Business Name: POLB_IN122102NB: Promise Revision</p>
 * 
 * <p>This interaction is a Promise Revision Response. This 
 * interaction is used when a filler communicates a response to 
 * revise an order fulfillment request. This is the fillers 
 * promise to fulfill the order. There is an expectation that 
 * once the filler issues the promise revision response, the 
 * filler will fulfill the order with a subsequent result 
 * complete interaction.</p>
 * 
 * <p>Message: MCCI_MT002100NB.Message</p>
 * 
 * <p>Control Act: MCAI_MT700210NB.ControlActEvent</p>
 * 
 * <p>--> Payload: POLB_MT002000NB.PromiseChoice</p>
 * 
 * <p>----> Payload Choice: POLB_MT002000NB.PromiseGroup</p>
 * 
 * <p>----> Payload Choice: POLB_MT002000NB.BatteryPromise</p>
 * 
 * <p>----> Payload Choice: POLB_MT002000NB.ObservationPromise</p>
 */
@Hl7PartTypeMapping({"POLB_IN122102NB"})
public class PromiseRevisionBean extends HL7MessageBean<TriggerEventBean<PromiseChoice>> implements InteractionBean {

    private static final long serialVersionUID = 20150902L;

}