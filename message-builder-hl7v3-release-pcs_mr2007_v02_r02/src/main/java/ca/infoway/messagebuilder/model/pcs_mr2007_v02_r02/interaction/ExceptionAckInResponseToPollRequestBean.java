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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged.HL7Message_2Bean;



/**
 * <p>Business Name: MCCI_IN100005CA: Exception Ack in Response 
 * to Poll Request</p>
 * 
 * <p>Communication level acknowledgement indicating exception 
 * as to why message payload not returned by poll request that 
 * has been received. Note: This interaction is invoked, where 
 * appropriate, as a receiver responsibility.</p>
 * 
 * <p>Message: MCCI_MT002200CA.Message</p>
 */
@Hl7PartTypeMapping({"MCCI_IN100005CA"})
public class ExceptionAckInResponseToPollRequestBean extends HL7Message_2Bean implements InteractionBean {

    private static final long serialVersionUID = 20121204L;

}
