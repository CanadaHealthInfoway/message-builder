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
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.ficr_mt490001ca.ParameterListBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.ficr_mt490101ca.SpecialAuthorizationRequestBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.mcci_mt002300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.quqi_mt120008ca.TriggerEventBean;



/**
 * <p>Business Name: FICR_IN404102CA: Special Authorization 
 * Summary Query Response</p>
 * 
 * <p>Returns summary level Special Authorization Requests 
 * based on submitted query parameters.</p>
 * 
 * <p>Message: MCCI_MT002300CA.Message</p>
 * 
 * <p>Control Act: QUQI_MT120008CA.ControlActEvent</p>
 * 
 * <p>--> Payload: FICR_MT490101CA.SpecialAuthorizationRequest</p>
 * 
 * <p>--> Payload: FICR_MT490001CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"FICR_IN404102CA"})
public class SpecialAuthorizationSummaryQueryResponseBean extends HL7MessageBean<TriggerEventBean<SpecialAuthorizationRequestBean,ParameterListBean>> implements InteractionBean {

    private static final long serialVersionUID = 20150902L;

}
