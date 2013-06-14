/**
 * Copyright 2013 Canada Health, Inc.
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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.merged.ParameterListBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged.TriggerEvent_4Bean;



/**
 * <p>Business Name: QUCR_IN820102CA: SOFA Detail Query 
 * Request, Rx</p>
 * 
 * <p>The sender sends a SOFA (Statement of Financial Activity) 
 * Detail Query message for Pharmacy services and/or products. 
 * The request is for detailed account activity information, 
 * including references to previously adjudicated Invoices.</p>
 * 
 * <p>Message: MCCI_MT002100CA.Message</p>
 * 
 * <p>Control Act: QUQI_MT020002CA.ControlActEvent</p>
 * 
 * <p>--> Payload: QUCR_MT820201CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"QUCR_IN820102CA"})
public class SOFADetailQueryRequestRxBean extends HL7Message_1Bean<TriggerEvent_4Bean<ParameterListBean>> implements InteractionBean {

    private static final long serialVersionUID = 20130613L;

}
