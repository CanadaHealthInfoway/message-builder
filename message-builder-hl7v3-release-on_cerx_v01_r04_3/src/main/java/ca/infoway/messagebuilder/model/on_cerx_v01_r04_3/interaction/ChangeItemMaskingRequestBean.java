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
package ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.common.mcai_mt700210on.TriggerEventBean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.common.mcci_mt000100on.HL7MessageBean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.si.comt_mt400001on.MaskableRecordBean;



/**
 * <p>Business Name: COMT_IN400001ON: Change item masking 
 * request</p>
 * 
 * <p>Requests that an identified item, group of items 
 * (identified by act type, medication, indication) or all 
 * items for a particular patient should have their 
 * confidentiality code changed to the specified value.</p>
 * 
 * <p>Message: MCCI_MT000100ON.Message</p>
 * 
 * <p>Control Act: MCAI_MT700210ON.ControlActEvent</p>
 * 
 * <p>--&gt; Payload: COMT_MT400001ON.MaskableActType</p>
 */
@Hl7PartTypeMapping({"COMT_IN400001ON"})
public class ChangeItemMaskingRequestBean extends HL7MessageBean<TriggerEventBean<MaskableRecordBean>> implements InteractionBean {

    private static final long serialVersionUID = 20190731L;

}
