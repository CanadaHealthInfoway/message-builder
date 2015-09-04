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
import ca.infoway.messagebuilder.model.nb_drug.common.mcai_mt700220nb.TriggerEventBean;
import ca.infoway.messagebuilder.model.nb_drug.common.mcci_mt000300nb.HL7MessageBean;
import ca.infoway.messagebuilder.model.nb_drug.pharmacy.porx_mt990010nb.ReferencedRecordBean;



/**
 * <p>Business Name: PORX_IN040030NB: Record other medication 
 * request accepted</p>
 * 
 * <p>Indicates that the requested medication has been 
 * successfully recorded.</p>
 * 
 * <p>The key element returned in this message is the newly 
 * created DIS identifier for this medication record against 
 * the patient&rsquo;s DIS profile. This identifier is in the 
 * &ldquo;id&rdquo; element in the message path: 
 * &ldquo;/subject /actEvent&rdquo; and this identifier should 
 * be saved against the record for the medication in the local 
 * system such that it may be used for subsequent update 
 * messages or other transactions requiring this 
 * identifier.</p> <p>The response may include warnings and/or 
 * issues in the message path: &ldquo;/subjectOf 
 * /detectedIssueEvent /subject&rdquo;. Issues may include 
 * issue identified by a DUR or other business rules that 
 * evaluate the prescription against the patient's profile, 
 * including the patient&rsquo;s active medications and/or 
 * dispenses, and/or coded observations (pregnancy, geriatric, 
 * allergy / intolerance, etc), and/or Patient Measurable 
 * Observations (height, weight, etc). Generally, most issues 
 * will have associated management specified with them.</p>
 * 
 * <p>Message: MCCI_MT000300NB.Message</p>
 * 
 * <p>Control Act: MCAI_MT700220NB.ControlActEvent</p>
 * 
 * <p>--> Payload: PORX_MT990010NB.ActEvent</p>
 */
@Hl7PartTypeMapping({"PORX_IN040030NB"})
public class RecordOtherMedicationRequestAcceptedBean extends HL7MessageBean<TriggerEventBean<ReferencedRecordBean>> implements InteractionBean {

    private static final long serialVersionUID = 20150901L;

}