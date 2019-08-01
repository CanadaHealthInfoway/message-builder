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
package ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.mcci_mt002300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.quqi_mt120006ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.iehr.repc_mt000009ca.AllergyIntoleranceBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.iehr.repc_mt000019ca.ConditionHistoryQueryParametersBean;



/**
 * <p>Business Name: REPC_IN000018CA: Patient 
 * allergy/intolerance with hist. query resp.</p>
 * 
 * <p>Returns information about a single allergy or intolerance 
 * record, including all revisions to severity, status and 
 * annotations.</p>
 * 
 * <p>Message: MCCI_MT002300CA.Message</p>
 * 
 * <p>Control Act: QUQI_MT120006CA.ControlActEvent</p>
 * 
 * <p>--&gt; Payload: REPC_MT000009CA.IntoleranceCondition</p>
 * 
 * <p>--&gt; Payload: REPC_MT000019CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"REPC_IN000018CA"})
public class PatientAllergyIntoleranceWithHistQueryRespBean extends HL7MessageBean<TriggerEventBean<AllergyIntoleranceBean,ConditionHistoryQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20190801L;

}
