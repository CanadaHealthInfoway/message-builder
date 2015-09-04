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
package ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.mcci_mt002100ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.quqi_mt020000ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.iehr.repc_mt000019ca.ConditionHistoryQueryParametersBean;



/**
 * <p>Business Name: REPC_IN000017CA: Patient 
 * allergy/intolerance with hist. query</p>
 * 
 * <p>Requests retrieval of the history of a particular allergy 
 * or intolerance record identified by patient id and allergy 
 * or intolerance record id, including changes to severity, 
 * status, annotations, etc.</p>
 * 
 * <p>Message: MCCI_MT002100CA.Message</p>
 * 
 * <p>Control Act: QUQI_MT020000CA.ControlActEvent</p>
 * 
 * <p>--> Payload: REPC_MT000019CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"REPC_IN000017CA"})
public class PatientAllergyIntoleranceWithHistQueryBean extends HL7MessageBean<TriggerEventBean<ConditionHistoryQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20150901L;

}