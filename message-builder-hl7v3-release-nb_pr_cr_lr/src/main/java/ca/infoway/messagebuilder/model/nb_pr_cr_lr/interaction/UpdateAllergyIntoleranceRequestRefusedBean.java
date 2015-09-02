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
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.comt_mt001103nb.ReferencedRecordBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.mcai_mt700226nb.TriggerEventBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.mcci_mt002300nb.HL7MessageBean;



/**
 * <p>Business Name: REPC_IN000022NB: Update 
 * allergy/intolerance request refused</p>
 * 
 * <p>Indicates that the requested modification to the defined 
 * allergy or intolerance record has been denied.</p>
 * 
 * <p>Message: MCCI_MT002300NB.Message</p>
 * 
 * <p>Control Act: MCAI_MT700226NB.ControlActEvent</p>
 * 
 * <p>--> Payload: COMT_MT001103NB.ActEvent</p>
 */
@Hl7PartTypeMapping({"REPC_IN000022NB"})
public class UpdateAllergyIntoleranceRequestRefusedBean extends HL7MessageBean<TriggerEventBean<ReferencedRecordBean>> implements InteractionBean {

    private static final long serialVersionUID = 20150902L;

}
