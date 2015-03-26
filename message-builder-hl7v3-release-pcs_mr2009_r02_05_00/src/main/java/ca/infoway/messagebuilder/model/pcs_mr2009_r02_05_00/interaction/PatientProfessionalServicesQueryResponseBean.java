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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.common.mcci_mt002300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.common.quqi_mt120006ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.iehr.repc_mt610002ca.ProfessionalServiceBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.iehr.repc_mt610004ca.QueryDefinitionBean;



/**
 * <p>Business Name: REPC_IN000042CA: Patient professional 
 * services query response</p>
 * 
 * <p>Returns detailed information about some or all 
 * professional services delivered to a patient.</p>
 * 
 * <p>Message: MCCI_MT002300CA.Message</p>
 * 
 * <p>Control Act: QUQI_MT120006CA.ControlActEvent</p>
 * 
 * <p>--> Payload: REPC_MT610002CA.ProcedureEvent</p>
 * 
 * <p>--> Payload: REPC_MT610004CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"REPC_IN000042CA"})
public class PatientProfessionalServicesQueryResponseBean extends HL7MessageBean<TriggerEventBean<ProfessionalServiceBean,QueryDefinitionBean>> implements InteractionBean {

    private static final long serialVersionUID = 20150326L;

}
