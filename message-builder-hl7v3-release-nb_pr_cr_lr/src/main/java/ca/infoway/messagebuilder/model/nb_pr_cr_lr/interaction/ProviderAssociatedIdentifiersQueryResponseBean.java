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
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.mcci_mt002300nb.HL7MessageBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.mfmi_mt700746nb.TriggerEventBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.pr.prpm_mt306050nb.ParameterListBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.pr.prpm_mt306051nb.RoleChoice;



/**
 * <p>Business Name: PRPM_IN306051NB: Provider Associated 
 * Identifiers Query Response</p>
 * 
 * <p>This interaction is used to respond to a Provider 
 * Associated Identifiers Query interaction and will contain 
 * the requested records from the provider registry system.</p>
 * 
 * <p>Message: MCCI_MT002300NB.Message</p>
 * 
 * <p>Control Act: MFMI_MT700746NB.ControlActEvent</p>
 * 
 * <p>--> Payload: PRPM_MT306051NB.RoleChoice</p>
 * 
 * <p>----> Payload Choice: PRPM_MT306051NB.AssignedEntity</p>
 * 
 * <p>----> Payload Choice: PRPM_MT306051NB.QualifiedEntity</p>
 * 
 * <p>----> Payload Choice: PRPM_MT306051NB.HealthCareProvider</p>
 * 
 * <p>--> Payload: PRPM_MT306050NB.ParameterList</p>
 */
@Hl7PartTypeMapping({"PRPM_IN306051NB"})
public class ProviderAssociatedIdentifiersQueryResponseBean extends HL7MessageBean<TriggerEventBean<ParameterListBean,RoleChoice>> implements InteractionBean {

    private static final long serialVersionUID = 20150902L;

}
