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
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.common.mcci_mt000100on.HL7MessageBean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.common.quqi_mt020000on.TriggerEventBean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.iehr.repc_mt120002on.CommonObservationQueryParametersBean;



/**
 * <p>Business Name: REPC_IN000054ON: Patient basic 
 * observations query</p>
 * 
 * <p>Requests retrieval of the basic observations (height, 
 * weight, blood-pressure, etc.) which have been recorded for a 
 * particular patient, optionally filtered by the type of 
 * observation and/or by the date-range for which the 
 * observation was recorded.</p>
 * 
 * <p>Message: MCCI_MT000100ON.Message</p>
 * 
 * <p>Control Act: QUQI_MT020000ON.ControlActEvent</p>
 * 
 * <p>--> Payload: REPC_MT120002ON.ParameterList</p>
 */
@Hl7PartTypeMapping({"REPC_IN000054ON"})
public class PatientBasicObservationsQueryBean extends HL7MessageBean<TriggerEventBean<CommonObservationQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20150326L;

}
