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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.ficr_mt490103ca.SpecialAuthorizationAdditionalInformationResponseBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.mcai_mt700227ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.mcci_mt002300ca.HL7MessageBean;



/**
 * <p>Business Name: FICR_IN404101CA: Special Authorization 
 * Additional Information Resp</p>
 * 
 * <p>Allows a provider to respond to a request for additional 
 * information for Special Authorization.</p>
 * 
 * <p>Message: MCCI_MT002300CA.Message</p>
 * 
 * <p>Control Act: MCAI_MT700227CA.ControlActEvent</p>
 * 
 * <p>--&gt; Payload: 
 * FICR_MT490103CA.SpecialAuthorizationAdditionalInformationResponse</p>
 */
@Hl7PartTypeMapping({"FICR_IN404101CA"})
public class SpecialAuthorizationAdditionalInformationRespBean extends HL7MessageBean<TriggerEventBean<SpecialAuthorizationAdditionalInformationResponseBean>> implements InteractionBean {

    private static final long serialVersionUID = 20190730L;

}
