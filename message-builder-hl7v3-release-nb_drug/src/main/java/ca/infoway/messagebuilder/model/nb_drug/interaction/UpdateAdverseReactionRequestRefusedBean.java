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
import ca.infoway.messagebuilder.model.nb_drug.common.mcai_mt700220ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.nb_drug.common.mcci_mt000300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.nb_drug.pharmacy.porx_mt990010ca.ReferencedRecordBean;



/**
 * <p>Business Name: REPC_IN000010CA: Update adverse reaction 
 * request refused</p>
 * 
 * <p>Indicates that the requested modification to the 
 * previously-recorded adverse reaction has been refused.</p>
 * 
 * <p>A receipt of this message means the update adverse 
 * reaction request message was rejected by the DIS. The 
 * &ldquo;text&rdquo; element in the message path 
 * &ldquo;/subjectOf /detectedIssueEvent&rdquo; will return the 
 * detailed error message describing why the record was 
 * rejected.</p> <p>The most common reason the request message 
 * may have been refused by the DIS include:<br /> a. The 
 * identifier for the adverse reaction record was not valid.<br 
 * /> b. The patient record identifier supplied in the update 
 * request was not valid.<br /> c. Record identifiers for 
 * location, provider, or prescriptions were not valid.<br /> 
 * d. One or more code values supplied in the message were not 
 * valid.</p>
 * 
 * <p>Message: MCCI_MT000300CA.Message</p>
 * 
 * <p>Control Act: MCAI_MT700220CA.ControlActEvent</p>
 * 
 * <p>--> Payload: PORX_MT990010CA.ActEvent</p>
 */
@Hl7PartTypeMapping({"REPC_IN000010CA"})
public class UpdateAdverseReactionRequestRefusedBean extends HL7MessageBean<TriggerEventBean<ReferencedRecordBean>> implements InteractionBean {

    private static final long serialVersionUID = 20151013L;

}
