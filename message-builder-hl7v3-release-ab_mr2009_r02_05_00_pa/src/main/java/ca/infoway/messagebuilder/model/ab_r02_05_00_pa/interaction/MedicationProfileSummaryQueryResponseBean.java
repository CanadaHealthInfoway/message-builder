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
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.common.merged.TriggerEvent_6Bean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.pharmacy.merged.MedicationRecord;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.pharmacy.porx_mt060200ca.ParameterListBean;



/**
 * <p>Business Name: PORX_IN060400CA: Medication profile 
 * summary query response</p>
 * 
 * <p>Returns basic information about a patient's 
 * prescriptions, dispenses and other medications for a 
 * specific patient optionally filtered by date.</p>
 * 
 * <p>Message: MCCI_MT002300CA.Message</p>
 * 
 * <p>Control Act: QUQI_MT120006CA.ControlActEvent</p>
 * 
 * <p>--> Payload: PORX_MT060190CA.MedicationRecord</p>
 * 
 * <p>----> Payload Choice: 
 * PORX_MT060190CA.CombinedMedicationRequest</p>
 * 
 * <p>----> Payload Choice: PORX_MT060190CA.OtherMedication</p>
 * 
 * <p>--> Payload: PORX_MT060200CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"PORX_IN060400CA"})
public class MedicationProfileSummaryQueryResponseBean extends HL7Message_1Bean<TriggerEvent_6Bean<MedicationRecord,ParameterListBean>> implements InteractionBean {

    private static final long serialVersionUID = 20140501L;

}
