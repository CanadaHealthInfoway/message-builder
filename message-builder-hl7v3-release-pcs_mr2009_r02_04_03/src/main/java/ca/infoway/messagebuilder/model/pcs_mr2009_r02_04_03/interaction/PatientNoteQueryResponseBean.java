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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.mcci_mt002300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.quqi_mt120006ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.iehr.comt_mt300002ca.GenericQueryParametersBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.iehr.comt_mt300003ca.CommentBean;



/**
 * <p>Business Name: COMT_IN300202CA: Patient note query 
 * response</p>
 * 
 * <p>Returns the notes that have been recorded against a 
 * particular patient, potentially filtered by note type and/or 
 * date.</p>
 * 
 * <p>Message: MCCI_MT002300CA.Message</p>
 * 
 * <p>Control Act: QUQI_MT120006CA.ControlActEvent</p>
 * 
 * <p>--> Payload: COMT_MT300003CA.Annotation</p>
 * 
 * <p>--> Payload: COMT_MT300002CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"COMT_IN300202CA"})
public class PatientNoteQueryResponseBean extends HL7MessageBean<TriggerEventBean<CommentBean,GenericQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20150326L;

}
