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
package Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.interaction;

import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.common.merged.HL7Message_1Bean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.common.merged.TriggerEvent_1Bean;
import Ca.Infoway.Messagebuilder.Model.Pcs_mr2009_r02_04_02.merged.ActRequestBean;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;



/**
 * <p>Business Name: REPC_IN000065CA: Record patient coded 
 * observation request accepted</p>
 * 
 * <p>Indicates that the requested coded observation (for 
 * example: APGAR score, symptom, blood type, smoker, etc.) has 
 * been successfully recorded in a patient's record.</p>
 * 
 * <p>Message: MCCI_MT002300CA.Message</p>
 * 
 * <p>Control Act: MCAI_MT700226CA.ControlActEvent</p>
 * 
 * <p>--> Payload: COMT_MT001101CA.ActRequest</p>
 */
@Hl7PartTypeMapping({"REPC_IN000065CA"})
public class RecordPatientCodedObservationRequestAcceptedBean extends HL7Message_1Bean<TriggerEvent_1Bean<ActRequestBean>> implements InteractionBean {

    private static final long serialVersionUID = 20130614L;

}
