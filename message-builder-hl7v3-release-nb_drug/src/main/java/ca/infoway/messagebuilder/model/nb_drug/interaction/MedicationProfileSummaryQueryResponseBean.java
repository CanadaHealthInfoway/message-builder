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
package ca.infoway.messagebuilder.model.nb_drug.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.nb_drug.common.mcci_mt000300nb.HL7MessageBean;
import ca.infoway.messagebuilder.model.nb_drug.common.quqi_mt120000nb.TriggerEventBean;
import ca.infoway.messagebuilder.model.nb_drug.pharmacy.porx_mt060190nb.MedicationRecord;
import ca.infoway.messagebuilder.model.nb_drug.pharmacy.porx_mt060200nb.ParameterListBean;



/**
 * <p>Business Name: PORX_IN060400NB: Medication profile 
 * summary query response</p>
 * 
 * <p>Returns basic information about a patient's 
 * prescriptions, dispenses and other medications for a 
 * specific patient optionally filtered by date.</p>
 * 
 * <p>DIS prescription identifiers, important keys used by 
 * several other process functions and messages in this 
 * specification, are returned by the &ldquo;id&rdquo; element 
 * in the message path: &ldquo;/subject 
 * /combinedMedicationRequest&rdquo;. They must be cached 
 * locally by the POS system with the associated records, and 
 * used as the identifier for all interactions with the HIAL 
 * that require a prescription identifier.</p>
 * 
 * <p>Message: MCCI_MT000300NB.Message</p>
 * 
 * <p>Control Act: QUQI_MT120000NB.ControlActEvent</p>
 * 
 * <p>--> Payload: PORX_MT060190NB.MedicationRecord</p>
 * 
 * <p>----> Payload Choice: 
 * PORX_MT060190NB.CombinedMedicationRequest</p>
 * 
 * <p>----> Payload Choice: PORX_MT060190NB.OtherMedication</p>
 * 
 * <p>--> Payload: PORX_MT060200NB.ParameterList</p>
 */
@Hl7PartTypeMapping({"PORX_IN060400NB"})
public class MedicationProfileSummaryQueryResponseBean extends HL7MessageBean<TriggerEventBean<MedicationRecord,ParameterListBean>> implements InteractionBean {

    private static final long serialVersionUID = 20150901L;

}
