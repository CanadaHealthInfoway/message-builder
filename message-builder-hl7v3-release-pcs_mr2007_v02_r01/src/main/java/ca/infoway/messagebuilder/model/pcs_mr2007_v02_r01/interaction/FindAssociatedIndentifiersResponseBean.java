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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.mfmi_mt700746ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.cr.merged.IdentifiedPersonBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.cr.prpa_mt101101ca.ParameterListBean;



/**
 * <p>PRPA_IN101106CA: Find Associated Indentifiers Response</p>
 * 
 * <p>Message: MCCI_MT002300CA.Message</p>
 * 
 * <p>Payload: MFMI_MT700746CA.ControlActEvent</p>
 * 
 * <p>--> Sub-Payload: PRPA_MT101106CA.IdentifiedEntity</p>
 * 
 * <p>--> Sub-Payload: PRPA_MT101101CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"PRPA_IN101106CA"})
public class FindAssociatedIndentifiersResponseBean extends HL7Message_1Bean<TriggerEventBean<IdentifiedPersonBean,ParameterListBean>> implements InteractionBean {

    private static final long serialVersionUID = 20121122L;

}
