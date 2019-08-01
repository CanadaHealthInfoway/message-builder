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
package ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.claims.ficr_mt610201ca.PaymentIntentBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.mcai_mt700227ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.mcci_mt002300ca.HL7MessageBean;



/**
 * <p>Business Name: FICR_IN610102CA: Invoice Results, Rx</p>
 * 
 * <p>The sender sends an Invoice Adjudication Results message 
 * containing the completed results of an Invoice Adjudication 
 * Request for Pharmacy services and/or products.</p>
 * 
 * <p>Message: MCCI_MT002300CA.Message</p>
 * 
 * <p>Control Act: MCAI_MT700227CA.ControlActEvent</p>
 * 
 * <p>--&gt; Payload: FICR_MT610201CA.PaymentIntent</p>
 */
@Hl7PartTypeMapping({"FICR_IN610102CA"})
public class InvoiceResultsRxBean extends HL7MessageBean<TriggerEventBean<PaymentIntentBean>> implements InteractionBean {

    private static final long serialVersionUID = 20190801L;

}
