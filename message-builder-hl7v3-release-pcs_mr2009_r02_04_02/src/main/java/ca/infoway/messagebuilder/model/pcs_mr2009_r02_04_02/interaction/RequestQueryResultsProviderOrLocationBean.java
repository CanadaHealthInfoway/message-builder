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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.TriggerEvent_5Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.ParameterListBean;



/**
 * <p>Business Name: POLB_IN354005CA: Request Query Results 
 * Provider or Location</p>
 * 
 * <p>This interaction is used to query lab results from a lab 
 * system, by location or provider.</p>
 * 
 * <p>Message: MCCI_MT002100CA.Message</p>
 * 
 * <p>Payload: QUQI_MT020002CA.ControlActEvent</p>
 * 
 * <p>--> Sub-Payload: POLB_MT320000CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"POLB_IN354005CA"})
public class RequestQueryResultsProviderOrLocationBean extends HL7Message_1Bean<TriggerEvent_5Bean<ParameterListBean>> implements InteractionBean {

    private static final long serialVersionUID = 20130307L;

}
