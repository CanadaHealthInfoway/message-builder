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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.TriggerEvent_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.repc_mt610001ca.ProfessionalServiceBean;



/**
 * <p>Business Name: REPC_IN000044CA: Record patient 
 * professional service request</p>
 * 
 * <p>Seeks to add a record of a professional service which has 
 * been delivered to a patient.</p>
 * 
 * <p>Message: MCCI_MT002100CA.Message</p>
 * 
 * <p>Control Act: MCAI_MT700210CA.ControlActEvent</p>
 * 
 * <p>--> Payload: REPC_MT610001CA.ProcedureEvent</p>
 */
@Hl7PartTypeMapping({"REPC_IN000044CA"})
public class RecordPatientProfessionalServiceRequestBean extends HL7Message_1Bean<TriggerEvent_1Bean<ProfessionalServiceBean>> implements InteractionBean {

    private static final long serialVersionUID = 20130614L;

}
