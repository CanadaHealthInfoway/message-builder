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
import ca.infoway.messagebuilder.model.nb_drug.pharmacy.porx_mt990020ca.ReferencedRecordBean;



/**
 * <p>Business Name: PORX_IN010460CA: Suspend prescription 
 * request refused</p>
 * 
 * <p>Indicates that the request to suspend specified 
 * prescription has been refused.</p>
 * 
 * <p>The error message that describes why the request message 
 * was refused will be in the &ldquo;text&rdquo; element in the 
 * message path: &ldquo;/subjectOf /detectedIssueEvent 
 * /text&rdquo;.</p> <p>Possible reasons for rejecting the 
 * message may include:<br /> a. The identifier of the author, 
 * location, prescription, or patient were not valid provincial 
 * record identifiers.<br /> b. The status of the prescription 
 * record was not set to &ldquo;Active&rdquo;.<br /> c. One or 
 * more code values supplied in the message were invalid.</p>
 * 
 * <p>Message: MCCI_MT000300CA.Message</p>
 * 
 * <p>Control Act: MCAI_MT700220CA.ControlActEvent</p>
 * 
 * <p>--> Payload: PORX_MT990020CA.ActRequest</p>
 */
@Hl7PartTypeMapping({"PORX_IN010460CA"})
public class SuspendPrescriptionRequestRefusedBean extends HL7MessageBean<TriggerEventBean<ReferencedRecordBean>> implements InteractionBean {

    private static final long serialVersionUID = 20151013L;

}
