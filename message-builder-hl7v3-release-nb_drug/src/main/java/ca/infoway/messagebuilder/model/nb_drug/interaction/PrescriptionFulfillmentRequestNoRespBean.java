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
package ca.infoway.messagebuilder.model.nb_drug.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.nb_drug.common.mcai_mt700210nb.TriggerEventBean;
import ca.infoway.messagebuilder.model.nb_drug.common.mcci_mt000100nb.HL7MessageBean;
import ca.infoway.messagebuilder.model.nb_drug.pharmacy.porx_mt010120nb.PrescriptionBean;



/**
 * <p>Business Name: PORX_IN010650NB: Prescription fulfillment 
 * request (no resp.)</p>
 * 
 * <p>Requests that the specified facility dispense the 
 * medication prescription transmitted by this interaction and 
 * does not expect a response interaction</p>
 * 
 * <p>Message: MCCI_MT000100NB.Message</p>
 * 
 * <p>Control Act: MCAI_MT700210NB.ControlActEvent</p>
 * 
 * <p>--> Payload: PORX_MT010120NB.CombinedMedicationRequest</p>
 */
@Hl7PartTypeMapping({"PORX_IN010650NB"})
public class PrescriptionFulfillmentRequestNoRespBean extends HL7MessageBean<TriggerEventBean<PrescriptionBean>> implements InteractionBean {

    private static final long serialVersionUID = 20150901L;

}