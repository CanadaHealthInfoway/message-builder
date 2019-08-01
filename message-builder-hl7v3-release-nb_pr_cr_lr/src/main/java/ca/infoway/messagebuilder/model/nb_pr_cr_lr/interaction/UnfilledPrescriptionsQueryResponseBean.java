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
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.mcci_mt002300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.quqi_mt120006ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.pharmacy.porx_mt060240ca.UnfilledPrescriptionQueryParametersBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.pharmacy.porx_mt060300ca.Prescription;



/**
 * <p>Business Name: PORX_IN060500CA: Unfilled prescriptions 
 * query response</p>
 * 
 * <p>Returns basic information about all prescriptions 
 * provided to a single patient which have not yet been 
 * dispensed, optionally filtered by date and status.</p>
 * 
 * <p>Message: MCCI_MT002300CA.Message</p>
 * 
 * <p>Control Act: QUQI_MT120006CA.ControlActEvent</p>
 * 
 * <p>--&gt; Payload: PORX_MT060300CA.Prescription</p>
 * 
 * <p>----&gt; Payload Choice: 
 * PORX_MT030040CA.CombinedMedicationRequest</p>
 * 
 * <p>----&gt; Payload Choice: 
 * PORX_MT060060CA.DevicePrescription</p>
 * 
 * <p>--&gt; Payload: PORX_MT060240CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"PORX_IN060500CA"})
public class UnfilledPrescriptionsQueryResponseBean extends HL7MessageBean<TriggerEventBean<Prescription,UnfilledPrescriptionQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20190801L;

}
