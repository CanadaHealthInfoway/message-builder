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
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.common.mcci_mt000300on.HL7MessageBean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.common.quqi_mt120000on.TriggerEventBean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.si.comt_mt300002on.GenericQueryParametersBean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.si.comt_mt300003on.CommentBean;



/**
 * <p>Business Name: COMT_IN300202ON: Patient note query 
 * response</p>
 * 
 * <p>Returns the notes that have been recorded against a 
 * particular patient, potentially filtered by note type and/or 
 * date.</p>
 * 
 * <p>Message: MCCI_MT000300ON.Message</p>
 * 
 * <p>Control Act: QUQI_MT120000ON.ControlActEvent</p>
 * 
 * <p>--> Payload: COMT_MT300003ON.Annotation</p>
 * 
 * <p>--> Payload: COMT_MT300002ON.ParameterList</p>
 */
@Hl7PartTypeMapping({"COMT_IN300202ON"})
public class PatientNoteQueryResponseBean extends HL7MessageBean<TriggerEventBean<CommentBean,GenericQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20150326L;

}
