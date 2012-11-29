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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.common.quqi_mt120000ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.merged.CommentBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.si.comt_mt300002ca.GenericQueryParametersBean;



/**
 * <p>COMT_IN300202CA: Patient note query response</p>
 * 
 * <p>Message: MCCI_MT000300CA.Message</p>
 * 
 * <p>Payload: QUQI_MT120000CA.ControlActEvent</p>
 * 
 * <p>--> Sub-Payload: COMT_MT300003CA.Annotation</p>
 * 
 * <p>--> Sub-Payload: COMT_MT300002CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"COMT_IN300202CA"})
public class PatientNoteQueryResponseBean extends HL7Message_1Bean<TriggerEventBean<CommentBean,GenericQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20121122L;

}
