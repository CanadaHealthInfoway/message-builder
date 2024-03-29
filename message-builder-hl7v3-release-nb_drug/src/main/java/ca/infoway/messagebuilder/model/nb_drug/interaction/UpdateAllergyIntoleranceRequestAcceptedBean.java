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
package ca.infoway.messagebuilder.model.nb_drug.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.nb_drug.common.mcai_mt700220ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.nb_drug.common.mcci_mt000300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.nb_drug.pharmacy.porx_mt990010ca.ReferencedRecordBean;



/**
 * <p>Business Name: REPC_IN000021CA: Update 
 * allergy/intolerance request accepted</p>
 * 
 * <p>Indicates that the status, severity and/or other 
 * information about the requested allergy or intolerance 
 * record has been updated.</p>
 * 
 * <p>A receipt of this message confirms the update request 
 * message has been processed successfully by the DIS. The 
 * response will include an &ldquo;actEvent&rdquo; element that 
 * will return the intolerance record and patient record 
 * against which the request message was processed, matching 
 * the identifiers that were supplied in the update request 
 * message.</p> <p>The response may include warnings and/or 
 * issues in the message path: &ldquo;/subjectOf 
 * /detectedIssueEvent /subject&rdquo;. This would be in cases 
 * where updates in the request message results in an 
 * identified issue as a result of a DUR or business rule 
 * execution against the current active prescriptions or 
 * dispenses on a patient&rsquo;s drug profile. As these are 
 * new issues resulting from the update of the intolerance 
 * record, generally they will require the user to determine 
 * appropriate management.</p>
 * 
 * <p>Message: MCCI_MT000300CA.Message</p>
 * 
 * <p>Control Act: MCAI_MT700220CA.ControlActEvent</p>
 * 
 * <p>--&gt; Payload: PORX_MT990010CA.ActEvent</p>
 */
@Hl7PartTypeMapping({"REPC_IN000021CA"})
public class UpdateAllergyIntoleranceRequestAcceptedBean extends HL7MessageBean<TriggerEventBean<ReferencedRecordBean>> implements InteractionBean {

    private static final long serialVersionUID = 20190731L;

}
