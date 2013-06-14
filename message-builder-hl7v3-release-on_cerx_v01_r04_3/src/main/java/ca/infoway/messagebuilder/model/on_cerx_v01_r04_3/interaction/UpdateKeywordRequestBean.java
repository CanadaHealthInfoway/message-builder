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
package ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.common.merged.TriggerEvent_1Bean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.si.rcmr_mt010002on.KeywordBean;



/**
 * <p>Business Name: RCMR_IN010006ON: Update keyword request</p>
 * 
 * <p>Requests that the keyword used to control patient access 
 * to a all or a portion of the patient's record be revised to 
 * the specified value.</p>
 * 
 * <p>Message: MCCI_MT000100ON.Message</p>
 * 
 * <p>Control Act: MCAI_MT700210ON.ControlActEvent</p>
 * 
 * <p>--> Payload: RCMR_MT010002ON.KeywordEvent</p>
 */
@Hl7PartTypeMapping({"RCMR_IN010006ON"})
public class UpdateKeywordRequestBean extends HL7Message_1Bean<TriggerEvent_1Bean<KeywordBean>> implements InteractionBean {

    private static final long serialVersionUID = 20130614L;

}