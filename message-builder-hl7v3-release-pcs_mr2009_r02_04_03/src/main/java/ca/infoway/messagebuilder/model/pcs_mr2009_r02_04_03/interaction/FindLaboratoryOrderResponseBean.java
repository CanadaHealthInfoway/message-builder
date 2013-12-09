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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.TriggerEvent_6Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.polb_mt001999ca.RequestChoice;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.polb_mt330000ca.ParameterListBean;



/**
 * <p>Business Name: POLB_IN361000CA: Find Laboratory Order 
 * Response</p>
 * 
 * <p>This interaction is used in response to a lab order 
 * query.</p>
 * 
 * <p>Message: MCCI_MT002300CA.Message</p>
 * 
 * <p>Control Act: QUQI_MT120006CA.ControlActEvent</p>
 * 
 * <p>--> Payload: POLB_MT001999CA.RequestChoice</p>
 * 
 * <p>----> Payload Choice: POLB_MT001999CA.PlacerGroup</p>
 * 
 * <p>----> Payload Choice: POLB_MT001999CA.BatteryRequest</p>
 * 
 * <p>----> Payload Choice: POLB_MT001999CA.ObservationRequest</p>
 * 
 * <p>--> Payload: POLB_MT330000CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"POLB_IN361000CA"})
public class FindLaboratoryOrderResponseBean extends HL7Message_1Bean<TriggerEvent_6Bean<RequestChoice,ParameterListBean>> implements InteractionBean {

    private static final long serialVersionUID = 20131209L;

}
