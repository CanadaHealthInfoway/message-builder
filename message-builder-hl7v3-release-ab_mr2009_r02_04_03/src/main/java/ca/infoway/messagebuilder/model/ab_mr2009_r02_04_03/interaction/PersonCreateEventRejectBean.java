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
package ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.common.mcci_mt002300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.common.mfmi_mt700726ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.cr.prpa_mt101106ca.IdentifiedPersonBean;



/**
 * <p>Business Name: PRPA_IN101203CA: Person Create Event 
 * Reject</p>
 * 
 * <p>person registry rejects a request to add a record and 
 * responds back to the requesting application. The reason for 
 * the rejection is returned as a Detected Issue in the Master 
 * File / Reg Notif. Control Act, Role Subject wrapper.</p>
 * 
 * <p>Message: MCCI_MT002300CA.Message</p>
 * 
 * <p>Control Act: MFMI_MT700726CA.ControlActEvent</p>
 * 
 * <p>--> Payload: PRPA_MT101106CA.IdentifiedEntity</p>
 */
@Hl7PartTypeMapping({"PRPA_IN101203CA"})
public class PersonCreateEventRejectBean extends HL7MessageBean<TriggerEventBean<IdentifiedPersonBean>> implements InteractionBean {

    private static final long serialVersionUID = 20150807L;

}
