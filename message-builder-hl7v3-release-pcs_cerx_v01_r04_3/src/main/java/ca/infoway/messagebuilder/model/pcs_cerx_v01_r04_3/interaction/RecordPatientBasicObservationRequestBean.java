/**
 * Copyright 2013 Canada Health, Inc.
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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.merged.TriggerEvent_1Bean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.iehr.merged.PatientMeasurementsBean;



/**
 * <p>Business Name: REPC_IN000051CA: Record patient basic 
 * observation request</p>
 * 
 * <p>Requests that a basic observation (height, weight, 
 * blood-pressure, etc.) be recorded in a patient's record.</p>
 * 
 * <p>Message: MCCI_MT000100CA.Message</p>
 * 
 * <p>Control Act: MCAI_MT700210CA.ControlActEvent</p>
 * 
 * <p>--> Payload: REPC_MT000018CA.CommonObservationEvent</p>
 */
@Hl7PartTypeMapping({"REPC_IN000051CA"})
public class RecordPatientBasicObservationRequestBean extends HL7Message_1Bean<TriggerEvent_1Bean<PatientMeasurementsBean>> implements InteractionBean {

    private static final long serialVersionUID = 20130613L;

}
