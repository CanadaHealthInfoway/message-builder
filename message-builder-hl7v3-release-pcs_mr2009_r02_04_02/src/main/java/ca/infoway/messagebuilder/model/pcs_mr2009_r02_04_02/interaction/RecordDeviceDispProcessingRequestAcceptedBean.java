/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.merged.PrescriptionDispenseResponseBean;



/**
 * <p>Business Name: PORX_IN020340CA: Record device disp. 
 * processing request accepted</p>
 * 
 * <p>Indicates that the requested device dispense processing 
 * information has been successfully recorded in the patient's 
 * record.</p>
 * 
 * <p>Message: MCCI_MT002300CA.Message</p>
 * 
 * <p>Payload: MCAI_MT700226CA.ControlActEvent</p>
 * 
 * <p>--> Sub-Payload: PORX_MT020030CA.SupplyEvent</p>
 */
@Hl7PartTypeMapping({"PORX_IN020340CA"})
public class RecordDeviceDispProcessingRequestAcceptedBean extends HL7Message_1Bean<TriggerEvent_1Bean<PrescriptionDispenseResponseBean>> implements InteractionBean {

    private static final long serialVersionUID = 20121204L;

}
