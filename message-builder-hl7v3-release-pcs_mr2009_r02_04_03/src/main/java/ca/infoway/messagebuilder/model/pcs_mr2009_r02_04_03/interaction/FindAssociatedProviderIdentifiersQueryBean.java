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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.mfmi_mt700751ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.pr.prpm_mt306050ca.ParameterListBean;



/**
 * <p>Business Name: PRPM_IN306050CA: Find Associated Provider 
 * Identifiers Query</p>
 * 
 * <p>This interaction is used to request associated 
 * identifiers for a provider. It is expected that the 
 * receiving application will respond with the Provider 
 * Associated Identifiers Query Response containing the 
 * requested information from the provider registry system.</p>
 * 
 * <p>Message: MCCI_MT002100CA.Message</p>
 * 
 * <p>Payload: MFMI_MT700751CA.ControlActEvent</p>
 * 
 * <p>--> Sub-Payload: PRPM_MT306050CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"PRPM_IN306050CA"})
public class FindAssociatedProviderIdentifiersQueryBean extends HL7Message_1Bean<TriggerEventBean<ParameterListBean>> implements InteractionBean {

    private static final long serialVersionUID = 20130307L;

}
