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
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.ficr_mt490003ca.SpecialAuthorizationAdditionalInformationRequestBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.mcai_mt700211ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.mcci_mt002100ca.HL7MessageBean;



/**
 * <p>Business Name: FICR_IN404001CA: Special Authorization 
 * Additional Information Reque</p>
 * 
 * <p>Indicates that the Payor requires additional information 
 * in order to adjudicate the Special Authorization 
 * Request.</p>
 * 
 * <p>Message: MCCI_MT002100CA.Message</p>
 * 
 * <p>Control Act: MCAI_MT700211CA.ControlActEvent</p>
 * 
 * <p>--> Payload: 
 * FICR_MT490003CA.SpecialAuthorizationAdditionalInformationRequest</p>
 */
@Hl7PartTypeMapping({"FICR_IN404001CA"})
public class SpecialAuthorizationAdditionalInformationRequeBean extends HL7MessageBean<TriggerEventBean<SpecialAuthorizationAdditionalInformationRequestBean>> implements InteractionBean {

    private static final long serialVersionUID = 20150326L;

}
