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
import ca.infoway.messagebuilder.model.nb_drug.pharmacy.porx_mt060090ca.DispenseBean;
import ca.infoway.messagebuilder.model.nb_drug.pharmacy.porx_mt060360ca.GenericQueryParametersBean;



/**
 * <p>Business Name: PORX_IN060220CA: Medication dispense 
 * detail query response</p>
 * 
 * <p>Returns detailed information about a single identified 
 * medication dispense event.</p>
 * 
 * <p>The detailed information for the medication dispense will 
 * be returned in this response message in the message path: 
 * &ldquo;/subject /medicationDispense /&rdquo;.</p> <p>Each 
 * medication dispense returned in the query response may have 
 * any number of issues returned per medication dispense. The 
 * element at message path: &ldquo;/subject /medicationDispense 
 * /subjectOf2 /detectedIssueEvent /&rdquo; identifies whether 
 * an issue is returned for a specific dispense. If the 
 * &ldquo;mitigatedBy&rdquo; element in this message path is 
 * not specified, the issue is presently an unmanaged 
 * issue.</p>
 * 
 * <p>Message: MCCI_MT000300CA.Message</p>
 * 
 * <p>Control Act: QUQI_MT120000CA.ControlActEvent</p>
 * 
 * <p>--&gt; Payload: PORX_MT060090CA.MedicationDispense</p>
 * 
 * <p>--&gt; Payload: PORX_MT060360CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"PORX_IN060220CA"})
public class MedicationDispenseDetailQueryResponseBean extends HL7MessageBean<TriggerEventBean<DispenseBean,GenericQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20190731L;

}
