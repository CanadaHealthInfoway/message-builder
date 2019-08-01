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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.common.mcci_mt000300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.common.quqi_mt120000ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.iehr.repc_mt100001ca.ProfessionalServiceBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.iehr.repc_mt120001ca.ProfessionalServiceQueryParametersBean;



/**
 * <p>Business Name: REPC_IN000042CA: Patient pharmacy prof. 
 * services query response</p>
 * 
 * <p>Message: MCCI_MT000300CA.Message</p>
 * 
 * <p>Control Act: QUQI_MT120000CA.ControlActEvent</p>
 * 
 * <p>--&gt; Payload: REPC_MT100001CA.ProcedureEvent</p>
 * 
 * <p>--&gt; Payload: REPC_MT120001CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"REPC_IN000042CA"})
public class PatientPharmacyProfServicesQueryResponseBean extends HL7MessageBean<TriggerEventBean<ProfessionalServiceBean,ProfessionalServiceQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20190731L;

}
