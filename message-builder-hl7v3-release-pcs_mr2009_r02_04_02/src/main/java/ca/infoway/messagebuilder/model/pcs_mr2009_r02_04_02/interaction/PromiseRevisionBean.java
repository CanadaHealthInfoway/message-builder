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
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.mcai_mt700210ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.mcci_mt002100ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.polb_mt002000ca.PromiseChoice;



/**
 * <p>Business Name: POLB_IN122102CA: Promise Revision</p>
 * 
 * <p>This interaction is a Promise Revision Response. This 
 * interaction is used when a filler communicates a response to 
 * revise an order fulfillment request. This is the fillers 
 * promise to fulfill the order. There is an expectation that 
 * once the filler issues the promise revision response, the 
 * filler will fulfill the order with a subsequent result 
 * complete interaction.</p>
 * 
 * <p>Message: MCCI_MT002100CA.Message</p>
 * 
 * <p>Control Act: MCAI_MT700210CA.ControlActEvent</p>
 * 
 * <p>--> Payload: POLB_MT002000CA.PromiseChoice</p>
 * 
 * <p>----> Payload Choice: POLB_MT002000CA.PromiseGroup</p>
 * 
 * <p>----> Payload Choice: POLB_MT002000CA.BatteryPromise</p>
 * 
 * <p>----> Payload Choice: POLB_MT002000CA.ObservationPromise</p>
 */
@Hl7PartTypeMapping({"POLB_IN122102CA"})
public class PromiseRevisionBean extends HL7MessageBean<TriggerEventBean<PromiseChoice>> implements InteractionBean {

    private static final long serialVersionUID = 20150326L;

}
