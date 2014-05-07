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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_4.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_4.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_4.common.merged.TriggerEvent_1Bean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_4.pharmacy.porx_mt010120ca.PrescriptionBean;



/**
 * <p>Business Name: PORX_IN010420CA: Prescription clinical 
 * pre-determination check</p>
 * 
 * <p>Requests the specified medication prescription proposal 
 * be reviewed, and any detected issues be identified.</p>
 * 
 * <p>Message: MCCI_MT000100CA.Message</p>
 * 
 * <p>Control Act: MCAI_MT700210CA.ControlActEvent</p>
 * 
 * <p>--> Payload: PORX_MT010120CA.CombinedMedicationRequest</p>
 */
@Hl7PartTypeMapping({"PORX_IN010420CA"})
public class PrescriptionClinicalPreDeterminationCheckBean extends HL7Message_1Bean<TriggerEvent_1Bean<PrescriptionBean>> implements InteractionBean {

    private static final long serialVersionUID = 20140507L;

}
