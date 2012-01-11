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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcci_mt002100ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.common.qucr_mt800201ca.ParameterListBean;
import ca.infoway.messagebuilder.model.common.quqi_mt020002ca.TriggerEventBean;



/**
 * <p>The sender sends a SOFA (Statement of Financial Activity) 
 * Payment Advice Query message for Pharmacy services and/or 
 * products. 
 */
@Hl7PartTypeMapping({"QUCR_IN800102CA"})
public class SOFAPaymentAdviceQueryRxBean extends HL7MessageBean<TriggerEventBean<ParameterListBean>> implements InteractionBean {


}
