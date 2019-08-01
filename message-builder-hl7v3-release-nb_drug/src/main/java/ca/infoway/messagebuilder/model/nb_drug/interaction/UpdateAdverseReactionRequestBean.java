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
import ca.infoway.messagebuilder.model.nb_drug.common.mcai_mt700210ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.nb_drug.common.mcci_mt000100ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.nb_drug.iehr.repc_mt000012ca.ReportedReactionBean;



/**
 * <p>Business Name: REPC_IN000008CA: Update adverse reaction 
 * request</p>
 * 
 * <p>Requests that information such as severity, outcome and 
 * suspected cause of a previously-recorded adverse reaction be 
 * updated.</p>
 * 
 * <p>When issuing an update to an adverse reaction record, all 
 * elements with the &ldquo;/subject&rdquo; message path that 
 * are to remain against the adverse reaction record must be 
 * specified in the update message. If an element that 
 * presently exists against the adverse reaction record is 
 * dropped from the update message, the DIS will assume in 
 * receiving the update that this element is to be removed from 
 * the adverse reaction message.</p> <p>Generally, updates to 
 * an existing adverse reaction may be updates to the effective 
 * time of the record, the severity of the reaction, and/or to 
 * the causality of the reaction.</p>
 * 
 * <p>Message: MCCI_MT000100CA.Message</p>
 * 
 * <p>Control Act: MCAI_MT700210CA.ControlActEvent</p>
 * 
 * <p>--&gt; Payload: REPC_MT000012CA.ReactionObservationEvent</p>
 */
@Hl7PartTypeMapping({"REPC_IN000008CA"})
public class UpdateAdverseReactionRequestBean extends HL7MessageBean<TriggerEventBean<ReportedReactionBean>> implements InteractionBean {

    private static final long serialVersionUID = 20190731L;

}
