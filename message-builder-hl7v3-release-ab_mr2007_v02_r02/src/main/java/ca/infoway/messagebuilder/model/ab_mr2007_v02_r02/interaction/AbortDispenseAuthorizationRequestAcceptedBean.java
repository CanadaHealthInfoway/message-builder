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
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.mcci_mt002300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.merged.ReferencedRecordBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.merged.TriggerEvent_1Bean;



/**
 * <p>Business Name: PORX_IN010570CA: Abort dispense 
 * authorization request accepted</p>
 * 
 * <p>Message: MCCI_MT002300CA.Message</p>
 * 
 * <p>Payload: MCAI_MT700226CA.ControlActEvent</p>
 * 
 * <p>--> Sub-Payload: COMT_MT001101CA.ActRequest</p>
 */
@Hl7PartTypeMapping({"PORX_IN010570CA"})
public class AbortDispenseAuthorizationRequestAcceptedBean extends HL7MessageBean<TriggerEvent_1Bean<ReferencedRecordBean>> implements InteractionBean {

    private static final long serialVersionUID = 20130103L;

}
