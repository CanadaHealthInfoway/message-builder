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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.comt_mt001101ca.ReferencedRecordBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.mcai_mt700226ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.mcci_mt002300ca.HL7MessageBean;



/**
 * <p>Business Name: PORX_IN010120CA: Revise assigned dispense 
 * responsibility req. ref.</p>
 * 
 * <p>Indicates that the request to change the facility 
 * responsible for fulfilling the dispense portion of a 
 * prescription has been refused.</p>
 * 
 * <p>Message: MCCI_MT002300CA.Message</p>
 * 
 * <p>Control Act: MCAI_MT700226CA.ControlActEvent</p>
 * 
 * <p>--> Payload: COMT_MT001101CA.ActRequest</p>
 */
@Hl7PartTypeMapping({"PORX_IN010120CA"})
public class ReviseAssignedDispenseResponsibilityReqRefBean extends HL7MessageBean<TriggerEventBean<ReferencedRecordBean>> implements InteractionBean {

    private static final long serialVersionUID = 20150903L;

}
