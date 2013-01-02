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
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged.TriggerEvent_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.si.comt_mt400001ca.MaskableRecordBean;



/**
 * <p>Business Name: COMT_IN400001CA: Change item masking 
 * request</p>
 * 
 * <p>Requests that an identified item, group of items 
 * (identified by act type, medication, indication) or all 
 * items for a particular patient should have their 
 * confidentiality code changed to the specified value.</p>
 * 
 * <p>Message: MCCI_MT002100CA.Message</p>
 * 
 * <p>Payload: MCAI_MT700210CA.ControlActEvent</p>
 * 
 * <p>--> Sub-Payload: COMT_MT400001CA.MaskableActType</p>
 */
@Hl7PartTypeMapping({"COMT_IN400001CA"})
public class ChangeItemMaskingRequestBean extends HL7Message_1Bean<TriggerEvent_1Bean<MaskableRecordBean>> implements InteractionBean {

    private static final long serialVersionUID = 20121204L;

}
