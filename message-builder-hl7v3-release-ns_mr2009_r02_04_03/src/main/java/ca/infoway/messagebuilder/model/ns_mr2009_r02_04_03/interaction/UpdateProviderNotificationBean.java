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
package ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.mcci_mt002100ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.mfmi_mt700717ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.pr.prpm_mt303010ca.RoleChoice;



/**
 * <p>Business Name: PRPM_IN303030CA: Update Provider 
 * Notification</p>
 * 
 * <p>This interaction is used to send a notification that a 
 * provider record has been updated in a provider registry 
 * system. No response is expected from the recipient 
 * system.</p>
 * 
 * <p>Message: MCCI_MT002100CA.Message</p>
 * 
 * <p>Control Act: MFMI_MT700717CA.ControlActEvent</p>
 * 
 * <p>--> Payload: PRPM_MT303010CA.RoleChoice</p>
 * 
 * <p>----> Payload Choice: PRPM_MT303010CA.AssignedEntity</p>
 * 
 * <p>----> Payload Choice: PRPM_MT303010CA.QualifiedEntity</p>
 * 
 * <p>----> Payload Choice: PRPM_MT303010CA.HealthCareProvider</p>
 */
@Hl7PartTypeMapping({"PRPM_IN303030CA"})
public class UpdateProviderNotificationBean extends HL7MessageBean<TriggerEventBean<RoleChoice>> implements InteractionBean {

    private static final long serialVersionUID = 20150901L;

}
