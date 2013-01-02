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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.merged.SpecialAuthorizationRequestBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.mcai_mt700211ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.HL7Message_1Bean;



/**
 * <p>Business Name: FICR_IN400011CA: Special Authorization 
 * Result Notification</p>
 * 
 * <p>Indicates that adjudication of a previously pended 
 * Special Authorization has been completed. The Special 
 * Authorization Request status will either be 
 * &quot;&quot;active&quot;&quot; if approved or 
 * &quot;&quot;aborted&quot;&quot; if not approved.</p>
 * 
 * <p>Message: MCCI_MT002100CA.Message</p>
 * 
 * <p>Payload: MCAI_MT700211CA.ControlActEvent</p>
 * 
 * <p>--> Sub-Payload: 
 * FICR_MT400003CA.SpecialAuthorizationRequest</p>
 */
@Hl7PartTypeMapping({"FICR_IN400011CA"})
public class SpecialAuthorizationResultNotificationBean extends HL7Message_1Bean<TriggerEventBean<SpecialAuthorizationRequestBean>> implements InteractionBean {

    private static final long serialVersionUID = 20121204L;

}
