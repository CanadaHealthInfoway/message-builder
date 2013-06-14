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
package Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.interaction;

import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.common.merged.HL7Message_1Bean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.common.merged.TriggerEvent_1Bean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.pharmacy.merged.DispenseInstructionsBean;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;



/**
 * <p>Business Name: PORX_IN010100CA: Revise assigned dispense 
 * responsibility req.</p>
 * 
 * <p>Requests that the responsibility for fulfilling the 
 * dispense portion of a prescription be changed to the 
 * specified facility. Changing to a null flavor of 
 * &quot;&quot;Not Applicable&quot;&quot; means that no 
 * facility has responsibility. Changing to a null flavor of 
 * &quot;&quot;Unknown&quot;&quot; means that the 
 * responsibility has been transferred to a facility outside 
 * the list of registered facilities.</p>
 * 
 * <p>Message: MCCI_MT002100CA.Message</p>
 * 
 * <p>Control Act: MCAI_MT700211CA.ControlActEvent</p>
 * 
 * <p>--> Payload: PORX_MT010140CA.SupplyRequest</p>
 */
@Hl7PartTypeMapping({"PORX_IN010100CA"})
public class ReviseAssignedDispenseResponsibilityReqBean extends HL7Message_1Bean<TriggerEvent_1Bean<DispenseInstructionsBean>> implements InteractionBean {

    private static final long serialVersionUID = 20130614L;

}
