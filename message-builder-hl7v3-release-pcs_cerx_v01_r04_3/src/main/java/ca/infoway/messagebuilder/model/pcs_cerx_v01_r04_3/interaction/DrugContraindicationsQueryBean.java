/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.quqi_mt020000ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.porx_mt050010ca.GenericQueryParametersBean;



/**
 * <p>Business Name: PORX_IN050010CA: Drug contraindications 
 * query</p>
 * 
 * <p>Requests retrieval of the contraindications associated 
 * with issuing a particular combination of drugs based only on 
 * a list of concomitant medications.</p>
 * 
 * <p>Message: MCCI_MT000100CA.Message</p>
 * 
 * <p>Payload: QUQI_MT020000CA.ControlActEvent</p>
 * 
 * <p>--> Sub-Payload: PORX_MT050010CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"PORX_IN050010CA"})
public class DrugContraindicationsQueryBean extends HL7Message_1Bean<TriggerEventBean<GenericQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20121204L;

}
