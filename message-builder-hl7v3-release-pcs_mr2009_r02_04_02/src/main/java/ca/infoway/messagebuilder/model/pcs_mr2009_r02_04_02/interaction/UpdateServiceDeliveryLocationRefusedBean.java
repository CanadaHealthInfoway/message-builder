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
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.common.merged.TriggerEvent_4Bean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.merged.ActRequestBean;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;



/**
 * <p>Business Name: PRPA_IN202019CA: Update service delivery 
 * location refused</p>
 * 
 * <p>Indicates that the requested modification to the service 
 * delivery location has been refused.</p>
 * 
 * <p>Message: MCCI_MT002300CA.Message</p>
 * 
 * <p>Control Act: MFMI_MT700726CA.ControlActEvent</p>
 * 
 * <p>--> Payload: COMT_MT001201CA.Role</p>
 */
@Hl7PartTypeMapping({"PRPA_IN202019CA"})
public class UpdateServiceDeliveryLocationRefusedBean extends HL7Message_1Bean<TriggerEvent_4Bean<ActRequestBean>> implements InteractionBean {

    private static final long serialVersionUID = 20130614L;

}
