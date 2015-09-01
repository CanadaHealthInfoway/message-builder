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
import ca.infoway.messagebuilder.model.nb_drug.common.mcci_mt000300nb.HL7MessageBean;
import ca.infoway.messagebuilder.model.nb_drug.common.quqi_mt120000nb.TriggerEventBean;
import ca.infoway.messagebuilder.model.nb_drug.iehr.repc_mt000008nb.ConditionHistoryQueryParametersBean;
import ca.infoway.messagebuilder.model.nb_drug.iehr.repc_mt000010nb.MedicalConditionBean;



/**
 * <p>Business Name: REPC_IN000026NB: Patient medical condition 
 * with hist. query resp.</p>
 * 
 * <p>Returns information about a single medical condition 
 * record, including all revisions to severity, status, start 
 * date, end date and annotations.</p>
 * 
 * <p>Message: MCCI_MT000300NB.Message</p>
 * 
 * <p>Control Act: QUQI_MT120000NB.ControlActEvent</p>
 * 
 * <p>--> Payload: REPC_MT000010NB.MedicalCondition</p>
 * 
 * <p>--> Payload: REPC_MT000008NB.ParameterList</p>
 */
@Hl7PartTypeMapping({"REPC_IN000026NB"})
public class PatientMedicalConditionWithHistQueryRespBean extends HL7MessageBean<TriggerEventBean<MedicalConditionBean,ConditionHistoryQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20150901L;

}
