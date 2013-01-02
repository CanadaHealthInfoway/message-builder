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
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.TriggerEvent_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.merged.PrescriptionDispenseBean;



/**
 * <p>Business Name: PORX_IN020060CA: Record device dispense 
 * processing request</p>
 * 
 * <p>Requests that the device dispense processing (drug 
 * preparation, packaging and contraindication checking) for a 
 * particular quantity of devices against a prescription has 
 * been performed and the medication is awaiting pickup ne 
 * recorded.</p>
 * 
 * <p>Message: MCCI_MT002100CA.Message</p>
 * 
 * <p>Payload: MCAI_MT700210CA.ControlActEvent</p>
 * 
 * <p>--> Sub-Payload: PORX_MT020060CA.DeviceDispense</p>
 */
@Hl7PartTypeMapping({"PORX_IN020060CA"})
public class RecordDeviceDispenseProcessingRequestBean extends HL7Message_1Bean<TriggerEvent_1Bean<PrescriptionDispenseBean>> implements InteractionBean {

    private static final long serialVersionUID = 20121204L;

}
