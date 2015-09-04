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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.common.mcai_mt700236ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.common.mcci_mt002300ca.HL7MessageBean;



/**
 * <p>Business Name: COMT_IN301002CA: Add note to record 
 * request accepted</p>
 * 
 * <p>Indicates that the specified annotation has been 
 * successfully recorded against the requested record.</p>
 * 
 * <p>Message: MCCI_MT002300CA.Message</p>
 * 
 * <p>Control Act: MCAI_MT700236CA.ControlActEvent</p>
 */
@Hl7PartTypeMapping({"COMT_IN301002CA"})
public class AddNoteToRecordRequestAcceptedBean extends HL7MessageBean<TriggerEventBean> implements InteractionBean {

    private static final long serialVersionUID = 20150904L;

}
