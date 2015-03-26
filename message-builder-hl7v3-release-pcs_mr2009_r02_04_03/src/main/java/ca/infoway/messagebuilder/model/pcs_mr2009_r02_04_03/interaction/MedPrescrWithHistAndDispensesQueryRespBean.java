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
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.mcci_mt002300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.quqi_mt120006ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.pharmacy.porx_mt060280ca.DrugPrescriptionDetailQueryParametersBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.pharmacy.porx_mt060340ca.PrescriptionBean;



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
public class MedPrescrWithHistAndDispensesQueryRespBean extends HL7MessageBean<TriggerEventBean<PrescriptionBean,DrugPrescriptionDetailQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20150326L;

}
