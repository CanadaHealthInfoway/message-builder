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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.TriggerEvent_5Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.iehr.repc_mt410002ca.QueryDefinitionBean;



/**
 * <p>Business Name: REPC_IN000054CA: Patient measurement 
 * observations query</p>
 * 
 * <p>Requests retrieval of the measurement observations which 
 * have been recorded for a particular patient, optionally 
 * filtered by the type of observation and/or by the date-range 
 * for which the observation was recorded.</p>
 * 
 * <p>Message: MCCI_MT002100CA.Message</p>
 * 
 * <p>Payload: QUQI_MT020000CA.ControlActEvent</p>
 * 
 * <p>--> Sub-Payload: REPC_MT410002CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"REPC_IN000054CA"})
public class PatientMeasurementObservationsQueryBean extends HL7Message_1Bean<TriggerEvent_5Bean<QueryDefinitionBean>> implements InteractionBean {

    private static final long serialVersionUID = 20121204L;

}
