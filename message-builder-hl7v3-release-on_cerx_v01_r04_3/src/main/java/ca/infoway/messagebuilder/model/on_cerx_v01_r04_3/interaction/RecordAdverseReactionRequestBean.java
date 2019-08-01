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
package ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.common.mcai_mt700210on.TriggerEventBean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.common.mcci_mt000100on.HL7MessageBean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.iehr.repc_mt000002on.ReportedReactionBean;



/**
 * <p>Business Name: REPC_IN000004ON: Record adverse reaction 
 * request</p>
 * 
 * <p>Requests that information about an adverse reaction be 
 * recorded against a patient's record.</p>
 * 
 * <p>Message: MCCI_MT000100ON.Message</p>
 * 
 * <p>Control Act: MCAI_MT700210ON.ControlActEvent</p>
 * 
 * <p>--&gt; Payload: REPC_MT000002ON.ReactionObservationEvent</p>
 */
@Hl7PartTypeMapping({"REPC_IN000004ON"})
public class RecordAdverseReactionRequestBean extends HL7MessageBean<TriggerEventBean<ReportedReactionBean>> implements InteractionBean {

    private static final long serialVersionUID = 20190731L;

}
