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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.quqi_mt120000ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged.GenericQueryParametersBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.Prescription_1;



/**
 * <p>Business Name: PORX_IN060480CA: Unfilled prescr. by 
 * prescriber query response</p>
 * 
 * <p>Returns basic information about all prescriptions 
 * provided to a single patient, prescribed by the specified 
 * prescriber which have not yet been dispensed, optionally 
 * filtered by date and status.</p>
 * 
 * <p>Message: MCCI_MT000300CA.Message</p>
 * 
 * <p>Control Act: QUQI_MT120000CA.ControlActEvent</p>
 * 
 * <p>--> Payload: PORX_MT060300CA.Prescription</p>
 * 
 * <p>----> Payload Choice: 
 * PORX_MT030040CA.CombinedMedicationRequest</p>
 * 
 * <p>----> Payload Choice: PORX_MT060060CA.DevicePrescription</p>
 * 
 * <p>--> Payload: PORX_MT060270CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"PORX_IN060480CA"})
public class UnfilledPrescrByPrescriberQueryResponseBean extends HL7Message_1Bean<TriggerEventBean<Prescription_1,GenericQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20130613L;

}
