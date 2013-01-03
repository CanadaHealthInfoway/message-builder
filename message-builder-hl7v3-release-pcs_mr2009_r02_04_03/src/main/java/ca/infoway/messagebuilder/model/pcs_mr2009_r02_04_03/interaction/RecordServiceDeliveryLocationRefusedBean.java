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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.mfmi_mt700726ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.ActRequestBean;



/**
 * <p>Business Name: PRPA_IN202016CA: Record service delivery 
 * location refused</p>
 * 
 * <p>Indicates that the request to record a new service 
 * delivery location has been refused.</p>
 * 
 * <p>Message: MCCI_MT002300CA.Message</p>
 * 
 * <p>Payload: MFMI_MT700726CA.ControlActEvent</p>
 * 
 * <p>--> Sub-Payload: COMT_MT001201CA.Role</p>
 */
@Hl7PartTypeMapping({"PRPA_IN202016CA"})
public class RecordServiceDeliveryLocationRefusedBean extends HL7Message_1Bean<TriggerEventBean<ActRequestBean>> implements InteractionBean {

    private static final long serialVersionUID = 20130103L;

}
