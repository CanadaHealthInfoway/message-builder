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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged.TriggerEvent_3Bean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.cr.merged.IdentifiedPersonBean;



/**
 * <p>Business Name: PRPA_IN101204CA: Revise Person Request</p>
 * 
 * <p>This interaction occurs after information about a person 
 * is revised in a person registry. An informer sends to a 
 * tracker updated person information.</p>
 * 
 * <p>Message: MCCI_MT002100CA.Message</p>
 * 
 * <p>Control Act: MFMI_MT700711CA.ControlActEvent</p>
 * 
 * <p>--> Payload: PRPA_MT101002CA.IdentifiedEntity</p>
 */
@Hl7PartTypeMapping({"PRPA_IN101204CA"})
public class RevisePersonRequestBean extends HL7Message_1Bean<TriggerEvent_3Bean<IdentifiedPersonBean>> implements InteractionBean {

    private static final long serialVersionUID = 20130613L;

}
