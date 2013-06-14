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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.mfmi_mt700746ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pr.prpm_mt306050ca.ParameterListBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pr.prpm_mt306051ca.RoleChoice;



/**
 * <p>Business Name: PRPM_IN306051CA: Provider Associated 
 * Identifiers Query Response</p>
 * 
 * <p>This interaction is used to respond to a Provider 
 * Associated Identifiers Query interaction and will contain 
 * the requested records from the provider registry system.</p>
 * 
 * <p>Message: MCCI_MT002300CA.Message</p>
 * 
 * <p>Control Act: MFMI_MT700746CA.ControlActEvent</p>
 * 
 * <p>--> Payload: PRPM_MT306051CA.RoleChoice</p>
 * 
 * <p>----> Payload Choice: PRPM_MT306051CA.AssignedEntity</p>
 * 
 * <p>----> Payload Choice: PRPM_MT306051CA.QualifiedEntity</p>
 * 
 * <p>----> Payload Choice: PRPM_MT306051CA.HealthCareProvider</p>
 * 
 * <p>--> Payload: PRPM_MT306050CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"PRPM_IN306051CA"})
public class ProviderAssociatedIdentifiersQueryResponseBean extends HL7Message_1Bean<TriggerEventBean<ParameterListBean,RoleChoice>> implements InteractionBean {

    private static final long serialVersionUID = 20130613L;

}
