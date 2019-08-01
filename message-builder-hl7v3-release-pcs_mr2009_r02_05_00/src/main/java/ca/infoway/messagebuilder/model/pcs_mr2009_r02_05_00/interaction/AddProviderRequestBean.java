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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.common.mcci_mt002100ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.common.mfmi_mt700711ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.pr.prpm_mt301010ca.RoleChoice;



/**
 * <p>Business Name: PRPM_IN301010CA: Add Provider Request</p>
 * 
 * <p>This interaction is used to request that a new provider 
 * record be added to a provider registry system.</p>
 * 
 * <p>Message: MCCI_MT002100CA.Message</p>
 * 
 * <p>Control Act: MFMI_MT700711CA.ControlActEvent</p>
 * 
 * <p>--&gt; Payload: PRPM_MT301010CA.RoleChoice</p>
 * 
 * <p>----&gt; Payload Choice: PRPM_MT301010CA.AssignedEntity</p>
 * 
 * <p>----&gt; Payload Choice: PRPM_MT301010CA.QualifiedEntity</p>
 * 
 * <p>----&gt; Payload Choice: 
 * PRPM_MT301010CA.HealthCareProvider</p>
 */
@Hl7PartTypeMapping({"PRPM_IN301010CA"})
public class AddProviderRequestBean extends HL7MessageBean<TriggerEventBean<RoleChoice>> implements InteractionBean {

    private static final long serialVersionUID = 20190731L;

}
