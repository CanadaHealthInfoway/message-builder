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
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.merged.TriggerEvent_4Bean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.iehr.repc_mt000006ca.ReportedReactionBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.GenericQueryParametersBean;



/**
 * <p>Business Name: REPC_IN000002CA: Patient adverse reactions 
 * query response</p>
 * 
 * <p>Message: MCCI_MT002300CA.Message</p>
 * 
 * <p>Control Act: QUQI_MT120006CA.ControlActEvent</p>
 * 
 * <p>--> Payload: REPC_MT000006CA.ReactionObservationEvent</p>
 * 
 * <p>--> Payload: REPC_MT000016CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"REPC_IN000002CA"})
public class PatientAdverseReactionsQueryResponseBean extends HL7MessageBean<TriggerEvent_4Bean<ReportedReactionBean,GenericQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20131210L;

}
