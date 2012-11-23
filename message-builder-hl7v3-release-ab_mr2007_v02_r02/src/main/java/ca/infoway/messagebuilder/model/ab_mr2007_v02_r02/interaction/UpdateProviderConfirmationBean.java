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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.mcci_mt002300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.mfmi_mt700726ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pr.prpm_mt309000ca.RoleChoice;



/**
 * <p>PRPM_IN303011CA: Update Provider Confirmation</p>
 * 
 * <p>Message: MCCI_MT002300CA.Message</p>
 * 
 * <p>Payload: MFMI_MT700726CA.ControlActEvent</p>
 * 
 * <p>--> Sub-Payload: PRPM_MT309000CA.RoleChoice</p>
 * 
 * <p>----> Sub-Payload Choice: PRPM_MT309000CA.AssignedEntity</p>
 * 
 * <p>----> Sub-Payload Choice: PRPM_MT309000CA.QualifiedEntity</p>
 * 
 * <p>----> Sub-Payload Choice: 
 * PRPM_MT309000CA.HealthCareProvider</p>
 */
@Hl7PartTypeMapping({"PRPM_IN303011CA"})
public class UpdateProviderConfirmationBean extends HL7MessageBean<TriggerEventBean<RoleChoice>> implements InteractionBean {

    private static final long serialVersionUID = 20121122L;

}
