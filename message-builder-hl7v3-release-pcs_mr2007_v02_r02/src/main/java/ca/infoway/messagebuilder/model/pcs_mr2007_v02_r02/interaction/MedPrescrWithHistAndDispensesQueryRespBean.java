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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged.TriggerEvent_5Bean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.GenericQueryParametersBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.porx_mt060340ca.PrescriptionBean;



/**
 * <p>Business Name: PORX_IN060180CA: Med. prescr. with hist. 
 * and dispenses query resp.</p>
 * 
 * <p>Returns detailed information about a single identified 
 * medication prescription, including history of changes and 
 * all fulfilling dispense events.</p>
 * 
 * <p>Message: MCCI_MT002300CA.Message</p>
 * 
 * <p>Control Act: QUQI_MT120006CA.ControlActEvent</p>
 * 
 * <p>--> Payload: PORX_MT060340CA.CombinedMedicationRequest</p>
 * 
 * <p>--> Payload: PORX_MT060280CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"PORX_IN060180CA"})
public class MedPrescrWithHistAndDispensesQueryRespBean extends HL7Message_1Bean<TriggerEvent_5Bean<PrescriptionBean,GenericQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20131209L;

}
