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
package ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.mcci_mt002300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.quqi_mt120006ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.iehr.repc_mt230003ca.ClinicalObservationDocumentBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.iehr.repc_mt500006ca.QueryDefinitionBean;



/**
 * <p>Business Name: REPC_IN000095CA: Patient clinical 
 * observation doc detail query resp</p>
 * 
 * <p>Returns a list of Clinical Observation Document details 
 * for a particular patient, potentially filtered by time or 
 * other criteria.</p>
 * 
 * <p>Message: MCCI_MT002300CA.Message</p>
 * 
 * <p>Control Act: QUQI_MT120006CA.ControlActEvent</p>
 * 
 * <p>--&gt; Payload: REPC_MT230003CA.Document</p>
 * 
 * <p>--&gt; Payload: REPC_MT500006CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"REPC_IN000095CA"})
public class PatientClinicalObservationDocDetailQueryRespBean extends HL7MessageBean<TriggerEventBean<ClinicalObservationDocumentBean,QueryDefinitionBean>> implements InteractionBean {

    private static final long serialVersionUID = 20190801L;

}
