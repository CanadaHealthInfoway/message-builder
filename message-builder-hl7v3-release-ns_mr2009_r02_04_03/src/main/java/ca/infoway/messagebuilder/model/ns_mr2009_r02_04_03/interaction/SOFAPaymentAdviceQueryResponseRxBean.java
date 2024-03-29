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
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.claims.qucr_mt800201ca.ParameterListBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.claims.qucr_mt810201ca.AdjudicatedResultsGroupBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.mcci_mt002300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.quqi_mt120008ca.TriggerEventBean;



/**
 * <p>Business Name: QUCR_IN810102CA: SOFA Payment Advice Query 
 * Response, Rx</p>
 * 
 * <p>The sender sends a SOFA (Statement of Financial Activity) 
 * Payment Advice Query Response message for Pharmacy services 
 * and/or products.</p>
 * 
 * <p>Message: MCCI_MT002300CA.Message</p>
 * 
 * <p>Control Act: QUQI_MT120008CA.ControlActEvent</p>
 * 
 * <p>--&gt; Payload: QUCR_MT810201CA.AdjudResultsGroup</p>
 * 
 * <p>--&gt; Payload: QUCR_MT800201CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"QUCR_IN810102CA"})
public class SOFAPaymentAdviceQueryResponseRxBean extends HL7MessageBean<TriggerEventBean<AdjudicatedResultsGroupBean,ParameterListBean>> implements InteractionBean {

    private static final long serialVersionUID = 20190801L;

}
