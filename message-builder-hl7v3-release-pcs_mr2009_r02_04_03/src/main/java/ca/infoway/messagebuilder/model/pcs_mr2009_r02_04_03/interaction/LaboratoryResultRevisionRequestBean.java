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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.mcai_mt700210ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.polb_mt004999ca.ResultInstancePayloadChoice;



/**
 * <p>Business Name: POLB_IN224202CA: Laboratory Result 
 * Revision Request</p>
 * 
 * <p>This interaction is a Result Corrected with Receiver 
 * Responsibilitie. This interaction is used when the filler 
 * must correct (i.e., change) results that were previously 
 * reported as completed. The expected responses to this 
 * interaction are confirm or reject.</p>
 * 
 * <p>Message: MCCI_MT002100CA.Message</p>
 * 
 * <p>Control Act: MCAI_MT700210CA.ControlActEvent</p>
 * 
 * <p>--> Payload: POLB_MT004999CA.ResultInstancePayloadChoice</p>
 * 
 * <p>----> Payload Choice: POLB_MT004000CA.ResultChoice</p>
 * 
 * <p>----> Payload Choice: POLB_MT004100CA.ObservationReport</p>
 * 
 * <p>----> Payload Choice: POLB_MT004200CA.ObservationChoice</p>
 */
@Hl7PartTypeMapping({"POLB_IN224202CA"})
public class LaboratoryResultRevisionRequestBean extends HL7Message_1Bean<TriggerEventBean<ResultInstancePayloadChoice>> implements InteractionBean {

    private static final long serialVersionUID = 20130613L;

}
