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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_4.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_4.common.mcci_mt000300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_4.common.quqi_mt120000ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_4.iehr.repc_mt000006ca.ReportedReactionBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_4.iehr.repc_mt000016ca.AdverseReactionsQueryParametersBean;



/**
 * <p>Business Name: REPC_IN000002CA: Patient adverse reactions 
 * query response</p>
 * 
 * <p>Returns information about the current status of one or 
 * more adverse reactions for a patient.</p>
 * 
 * <p>Message: MCCI_MT000300CA.Message</p>
 * 
 * <p>Control Act: QUQI_MT120000CA.ControlActEvent</p>
 * 
 * <p>--&gt; Payload: REPC_MT000006CA.ReactionObservationEvent</p>
 * 
 * <p>--&gt; Payload: REPC_MT000016CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"REPC_IN000002CA"})
public class PatientAdverseReactionsQueryResponseBean extends HL7MessageBean<TriggerEventBean<ReportedReactionBean,AdverseReactionsQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20190731L;

}
