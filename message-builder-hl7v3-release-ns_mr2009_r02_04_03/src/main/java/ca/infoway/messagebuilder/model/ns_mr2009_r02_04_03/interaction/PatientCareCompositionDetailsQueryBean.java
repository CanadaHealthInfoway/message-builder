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
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.mcci_mt002100ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.quqi_mt020000ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.iehr.repc_mt500006ca.QueryDefinitionBean;



/**
 * <p>Business Name: REPC_IN040100CA: Patient care composition 
 * details query</p>
 * 
 * <p>Requests retrieval of details of an encounter, episode 
 * and similar structures for a particular patient or group of 
 * patients, potentially filtered by date or other 
 * criteria.</p>
 * 
 * <p>Message: MCCI_MT002100CA.Message</p>
 * 
 * <p>Control Act: QUQI_MT020000CA.ControlActEvent</p>
 * 
 * <p>--&gt; Payload: REPC_MT500006CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"REPC_IN040100CA"})
public class PatientCareCompositionDetailsQueryBean extends HL7MessageBean<TriggerEventBean<QueryDefinitionBean>> implements InteractionBean {

    private static final long serialVersionUID = 20190801L;

}
