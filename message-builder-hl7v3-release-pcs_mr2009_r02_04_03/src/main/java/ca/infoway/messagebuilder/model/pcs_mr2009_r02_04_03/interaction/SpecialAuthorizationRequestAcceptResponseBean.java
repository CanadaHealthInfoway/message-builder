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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.ficr_mt400004ca.SpecialAuthorizationRequestBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.mcai_mt700227ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.mcci_mt002300ca.HL7MessageBean;



/**
 * <p>Business Name: FICR_IN400002CA: Special Authorization 
 * Request Accept Response</p>
 * 
 * <p>Indicates that processing of the Create SA Request for a 
 * specific product (e.g. drug), device or service was either: 
 * - Approved (SA status of &quot;&quot;active&quot;&quot;); or 
 * - Pended (SA status of &quot;&quot;suspended&quot;&quot;); 
 * or - Pended and Request Additional Information (SA status of 
 * &quot;&quot;suspended&quot;&quot;) with request for 
 * additional information from the Payor conveyed in the 
 * response message payload</p>
 * 
 * <p>Message: MCCI_MT002300CA.Message</p>
 * 
 * <p>Control Act: MCAI_MT700227CA.ControlActEvent</p>
 * 
 * <p>--&gt; Payload: 
 * FICR_MT400004CA.SpecialAuthorizationRequest</p>
 */
@Hl7PartTypeMapping({"FICR_IN400002CA"})
public class SpecialAuthorizationRequestAcceptResponseBean extends HL7MessageBean<TriggerEventBean<SpecialAuthorizationRequestBean>> implements InteractionBean {

    private static final long serialVersionUID = 20190731L;

}
