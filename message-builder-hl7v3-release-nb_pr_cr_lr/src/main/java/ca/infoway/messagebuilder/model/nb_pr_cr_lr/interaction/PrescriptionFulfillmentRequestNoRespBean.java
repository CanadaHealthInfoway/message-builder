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
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.mcai_mt700210ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.mcci_mt002100ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.pharmacy.porx_mt010120ca.PrescriptionBean;



/**
 * <p>Business Name: PORX_IN010650CA: Prescription fulfillment 
 * request (no resp.)</p>
 * 
 * <p>Requests that the specified facility dispense the 
 * medication prescription transmitted by this interaction and 
 * does not expect a response interaction</p>
 * 
 * <p>Message: MCCI_MT002100CA.Message</p>
 * 
 * <p>Control Act: MCAI_MT700210CA.ControlActEvent</p>
 * 
 * <p>--&gt; Payload: PORX_MT010120CA.CombinedMedicationRequest</p>
 */
@Hl7PartTypeMapping({"PORX_IN010650CA"})
public class PrescriptionFulfillmentRequestNoRespBean extends HL7MessageBean<TriggerEventBean<PrescriptionBean>> implements InteractionBean {

    private static final long serialVersionUID = 20190801L;

}
