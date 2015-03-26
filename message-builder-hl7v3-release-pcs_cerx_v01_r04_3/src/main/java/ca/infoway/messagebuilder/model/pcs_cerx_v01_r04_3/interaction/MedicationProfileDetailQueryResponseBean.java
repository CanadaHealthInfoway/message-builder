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
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.mcci_mt000300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.quqi_mt120000ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.porx_mt060160ca.MedicationRecord;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.porx_mt060170ca.GenericQueryParametersBean;



/**
 * <p>Business Name: PORX_IN060380CA: Medication profile detail 
 * query response</p>
 * 
 * <p>Returns detailed information about a patient's 
 * prescriptions, dispenses and other medications for a 
 * specific patient optionally filtered by date.</p>
 * 
 * <p>Message: MCCI_MT000300CA.Message</p>
 * 
 * <p>Control Act: QUQI_MT120000CA.ControlActEvent</p>
 * 
 * <p>--> Payload: PORX_MT060160CA.MedicationRecord</p>
 * 
 * <p>----> Payload Choice: 
 * PORX_MT060160CA.CombinedMedicationRequest</p>
 * 
 * <p>----> Payload Choice: PORX_MT060160CA.OtherMedication</p>
 * 
 * <p>--> Payload: PORX_MT060170CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"PORX_IN060380CA"})
public class MedicationProfileDetailQueryResponseBean extends HL7MessageBean<TriggerEventBean<MedicationRecord,GenericQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20150326L;

}
