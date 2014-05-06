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
package ca.infoway.messagebuilder.model.ab_r02_05_00_pa.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.common.mcai_mt700210ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.pharmacy.porx_mt020070ca.PrescriptionDispenseBean;



/**
 * <p>Business Name: PORX_IN020190CA: Record dispense 
 * processing request</p>
 * 
 * <p>Requests the recording in the patient record that the 
 * medication dispense processing (drug preparation, packaging 
 * and contraindication checking) for a particular quantity of 
 * medication against a prescription has been performed and the 
 * medication is awaiting pickup.</p>
 * 
 * <p>Message: MCCI_MT002100CA.Message</p>
 * 
 * <p>Control Act: MCAI_MT700210CA.ControlActEvent</p>
 * 
 * <p>--> Payload: PORX_MT020070CA.MedicationDispense</p>
 */
@Hl7PartTypeMapping({"PORX_IN020190CA"})
public class RecordDispenseProcessingRequestBean extends HL7Message_1Bean<TriggerEventBean<PrescriptionDispenseBean>> implements InteractionBean {

    private static final long serialVersionUID = 20140501L;

}