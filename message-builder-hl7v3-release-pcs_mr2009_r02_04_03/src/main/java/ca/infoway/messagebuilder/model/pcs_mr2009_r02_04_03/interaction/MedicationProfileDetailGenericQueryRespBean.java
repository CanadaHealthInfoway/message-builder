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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.TriggerEvent_6Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.pharmacy.merged.DrugQueryParametersBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.pharmacy.merged.MedicationRecord;



/**
 * <p>Business Name: PORX_IN060360CA: Medication profile detail 
 * generic query resp.</p>
 * 
 * <p>Returns detailed information about a patient's 
 * prescriptions, dispenses and other medications for a 
 * specific patient filtered by a variety of criteria, 
 * including id, drug, indication, date, etc.</p>
 * 
 * <p>Message: MCCI_MT002300CA.Message</p>
 * 
 * <p>Control Act: QUQI_MT120006CA.ControlActEvent</p>
 * 
 * <p>--> Payload: PORX_MT060160CA.MedicationRecord</p>
 * 
 * <p>----> Payload Choice: 
 * PORX_MT060160CA.CombinedMedicationRequest</p>
 * 
 * <p>----> Payload Choice: PORX_MT060160CA.OtherMedication</p>
 * 
 * <p>--> Payload: PORX_MT060180CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"PORX_IN060360CA"})
public class MedicationProfileDetailGenericQueryRespBean extends HL7Message_1Bean<TriggerEvent_6Bean<MedicationRecord,DrugQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20130614L;

}
