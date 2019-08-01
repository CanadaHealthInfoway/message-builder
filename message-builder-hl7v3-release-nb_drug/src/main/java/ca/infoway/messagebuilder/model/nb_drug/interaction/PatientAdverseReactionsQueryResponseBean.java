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
package ca.infoway.messagebuilder.model.nb_drug.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.nb_drug.common.mcci_mt000300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.nb_drug.common.quqi_mt120000ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.nb_drug.iehr.repc_mt000006ca.ReportedReactionBean;
import ca.infoway.messagebuilder.model.nb_drug.iehr.repc_mt000016ca.AdverseReactionsQueryParametersBean;



/**
 * <p>Business Name: REPC_IN000002CA: Patient adverse reactions 
 * query response</p>
 * 
 * <p>Returns information about the current status of one or 
 * more adverse reactions for a patient.</p>
 * 
 * <p>If an error occurred in processing the query request, the 
 * response message will not contain any &ldquo;subject 
 * /reactionObservationEvent&rdquo; elements and one or more 
 * errors will be returned in &ldquo;detectedIssueEvent&rdquo; 
 * elements in the message path: &ldquo; /subjectOf&rdquo;. 
 * Potential reasons for an error may include an invalid 
 * patient identifier specified in the query response message, 
 * a malformed query request message, or invalid attribute 
 * values.</p>
 * 
 * <p>On successful processing of the query message, any number 
 * of &ldquo;reactionObservationEvent&rdquo; elements will be 
 * returned in the message path: &ldquo;/subject&rdquo;. The 
 * details of the adverse reaction will be in each 
 * &ldquo;reactionObservationEvent&rdquo; element including the 
 * &ldquo;author&rdquo; of the adverse reaction, the 
 * author&rsquo;s &ldquo;location&rdquo; at time of entry, the 
 * &ldquo;causalityAssessment&rdquo; and 
 * &ldquo;severityObservation&rdquo; elements that relate to 
 * the cause of the adverse reaction its severity, and any 
 * related notes.</p>
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
