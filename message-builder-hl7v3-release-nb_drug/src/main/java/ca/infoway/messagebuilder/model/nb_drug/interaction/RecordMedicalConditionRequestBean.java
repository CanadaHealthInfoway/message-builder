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
package ca.infoway.messagebuilder.model.nb_drug.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.nb_drug.common.mcai_mt700210nb.TriggerEventBean;
import ca.infoway.messagebuilder.model.nb_drug.common.mcci_mt000100nb.HL7MessageBean;
import ca.infoway.messagebuilder.model.nb_drug.iehr.repc_mt000003nb.MedicalConditionBean;



/**
 * <p>Business Name: REPC_IN000028NB: Record medical condition 
 * request</p>
 * 
 * <p>Requests that a medical condition record be recorded 
 * against the specified patient.</p>
 * 
 * <p>Message: MCCI_MT000100NB.Message</p>
 * 
 * <p>Control Act: MCAI_MT700210NB.ControlActEvent</p>
 * 
 * <p>--> Payload: REPC_MT000003NB.MedicalCondition</p>
 */
@Hl7PartTypeMapping({"REPC_IN000028NB"})
public class RecordMedicalConditionRequestBean extends HL7MessageBean<TriggerEventBean<MedicalConditionBean>> implements InteractionBean {

    private static final long serialVersionUID = 20150901L;

}