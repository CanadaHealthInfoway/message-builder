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
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.mcai_mt700236ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.mcci_mt002300ca.HL7MessageBean;



/**
 * <p>Business Name: PORX_IN020330CA: Record device disp. 
 * processing request refused</p>
 * 
 * <p>Indicates that the request to record the device dispense 
 * processing has been refused.</p>
 * 
 * <p>Message: MCCI_MT002300CA.Message</p>
 * 
 * <p>Control Act: MCAI_MT700236CA.ControlActEvent</p>
 */
@Hl7PartTypeMapping({"PORX_IN020330CA"})
public class RecordDeviceDispProcessingRequestRefusedBean extends HL7MessageBean<TriggerEventBean> implements InteractionBean {

    private static final long serialVersionUID = 20190801L;

}
