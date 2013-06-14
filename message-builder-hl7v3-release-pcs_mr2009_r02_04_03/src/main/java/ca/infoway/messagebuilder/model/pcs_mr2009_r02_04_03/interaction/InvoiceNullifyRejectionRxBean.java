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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.TriggerEvent_2Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.ActRequestBean;



/**
 * <p>Business Name: FICR_IN630202CA: Invoice Nullify 
 * Rejection, Rx</p>
 * 
 * <p>The sender sends an ACK to acknowledge of the request and 
 * indicate that the nullification was rejected and the 
 * adjudication results not reversed.</p>
 * 
 * <p>Message: MCCI_MT002300CA.Message</p>
 * 
 * <p>Control Act: MCAI_MT700227CA.ControlActEvent</p>
 * 
 * <p>--> Payload: COMT_MT001103CA.ActEvent</p>
 */
@Hl7PartTypeMapping({"FICR_IN630202CA"})
public class InvoiceNullifyRejectionRxBean extends HL7Message_1Bean<TriggerEvent_2Bean<ActRequestBean>> implements InteractionBean {

    private static final long serialVersionUID = 20130613L;

}
