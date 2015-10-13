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
import ca.infoway.messagebuilder.model.nb_drug.common.mcai_mt700210ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.nb_drug.common.mcci_mt000100ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.nb_drug.pharmacy.porx_mt990010ca.ReferencedRecordBean;



/**
 * <p>Business Name: COMT_IN300101CA: Deprecate patient note 
 * request</p>
 * 
 * <p>Requests that the specified patient annotation be marked 
 * as no longer applicable.</p>
 * 
 * <p>The person requesting the note to be deprecated (i.e. 
 * specified in the &ldquo;author&rdquo; element) must match 
 * the recorded author of the specified patient note.</p> 
 * <p></p>
 * 
 * <p>An existing record identifier must be specified to 
 * identify the note record to deprecate. The record identifier 
 * must be specified in the &ldquo;id&rdquo; element in the 
 * message path &ldquo;/subject /actEvent&rdquo;.</p> <p>A 
 * valid patient identifier(PDID) must be specified that 
 * matches the patient to which the note record specified 
 * belongs. The patient identifier is specified in the 
 * &ldquo;id&rdquo; element in the message path &ldquo;/subject 
 * /actEvent /recordTarget /patient&rdquo;.</p>
 * 
 * <p>Message: MCCI_MT000100CA.Message</p>
 * 
 * <p>Control Act: MCAI_MT700210CA.ControlActEvent</p>
 * 
 * <p>--> Payload: PORX_MT990010CA.ActEvent</p>
 */
@Hl7PartTypeMapping({"COMT_IN300101CA"})
public class DeprecatePatientNoteRequestBean extends HL7MessageBean<TriggerEventBean<ReferencedRecordBean>> implements InteractionBean {

    private static final long serialVersionUID = 20151013L;

}
