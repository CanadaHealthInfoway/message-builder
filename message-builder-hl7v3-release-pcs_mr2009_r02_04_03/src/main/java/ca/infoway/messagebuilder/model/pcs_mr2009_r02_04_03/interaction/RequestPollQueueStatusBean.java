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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.mcci_mt102001ca.HL7MessageBean;



/**
 * <p>Business Name: MCCI_IN102002CA: Request Poll Queue Status</p>
 * 
 * <p>Requests an indication of the number and priority of 
 * outstanding interactions (if any) on the application's poll 
 * queue.</p>
 * 
 * <p>Message: MCCI_MT102001CA.Message</p>
 */
@Hl7PartTypeMapping({"MCCI_IN102002CA"})
public class RequestPollQueueStatusBean extends HL7MessageBean implements InteractionBean {

    private static final long serialVersionUID = 20190731L;

}
