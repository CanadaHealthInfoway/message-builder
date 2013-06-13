/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.ficr_mt510201ca.FinancialTransactionIntentBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.TriggerEvent_2Bean;



/**
 * <p>Business Name: FICR_IN510102CA: Pre-Determination 
 * Results, Rx</p>
 * 
 * <p>The sender sends a Pre-Determination Results message 
 * containing the completed results of a Pre-Determination 
 * Request for Pharmacy services and/or products. 
 * Pre-Determination Results indicate adjudication results for 
 * specified services and/or products, but does not generate a 
 * payment.</p>
 * 
 * <p>Message: MCCI_MT002300CA.Message</p>
 * 
 * <p>Control Act: MCAI_MT700227CA.ControlActEvent</p>
 * 
 * <p>--> Payload: FICR_MT510201CA.FinancialTransactionIntent</p>
 */
@Hl7PartTypeMapping({"FICR_IN510102CA"})
public class PreDeterminationResultsRxBean extends HL7Message_1Bean<TriggerEvent_2Bean<FinancialTransactionIntentBean>> implements InteractionBean {

    private static final long serialVersionUID = 20130613L;

}
