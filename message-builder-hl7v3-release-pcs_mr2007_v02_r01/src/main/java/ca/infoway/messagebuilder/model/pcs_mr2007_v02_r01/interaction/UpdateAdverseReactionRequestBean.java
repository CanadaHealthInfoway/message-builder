/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.merged.TriggerEvent_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.iehr.repc_mt000012ca.ReportedReactionBean;



/**
 * <p>Business Name: REPC_IN000008CA: Update adverse reaction 
 * request</p>
 * 
 * <p>Requests that information such as severity, outcome and 
 * suspected cause of a previously-recorded adverse reaction be 
 * updated.</p>
 * 
 * <p>Message: MCCI_MT002100CA.Message</p>
 * 
 * <p>Payload: MCAI_MT700210CA.ControlActEvent</p>
 * 
 * <p>--> Sub-Payload: REPC_MT000012CA.ReactionObservationEvent</p>
 */
@Hl7PartTypeMapping({"REPC_IN000008CA"})
public class UpdateAdverseReactionRequestBean extends HL7Message_1Bean<TriggerEvent_1Bean<ReportedReactionBean>> implements InteractionBean {

    private static final long serialVersionUID = 20121204L;

}
