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
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.merged.TriggerEvent_1Bean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.ReferencedRecordBean;



/**
 * <p>PORX_IN020370CA: Record dispense reversal request</p>
 * 
 * <p>Message: MCCI_MT000100CA.Message</p>
 * 
 * <p>Payload: MCAI_MT700210CA.ControlActEvent</p>
 * 
 * <p>--> Sub-Payload: PORX_MT990010CA.ActEvent</p>
 */
@Hl7PartTypeMapping({"PORX_IN020370CA"})
public class RecordDispenseReversalRequestBean extends HL7Message_1Bean<TriggerEvent_1Bean<ReferencedRecordBean>> implements InteractionBean {

    private static final long serialVersionUID = 20121122L;

}
