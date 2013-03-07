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
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.TriggerEvent_6Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.immunization.poiz_mt061140ca.ImmunizationCandidateQueryParametersBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.immunization.poiz_mt061150ca.ImmunizationsBean;



/**
 * <p>Business Name: POIZ_IN021020CA: Immunization Candidate 
 * Query Response</p>
 * 
 * <p>Returns a list of candidate imunization events.</p>
 * 
 * <p>Message: MCCI_MT002300CA.Message</p>
 * 
 * <p>Payload: QUQI_MT120008CA.ControlActEvent</p>
 * 
 * <p>--> Sub-Payload: POIZ_MT061150CA.Immunization</p>
 * 
 * <p>--> Sub-Payload: POIZ_MT061140CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"POIZ_IN021020CA"})
public class ImmunizationCandidateQueryResponseBean extends HL7Message_1Bean<TriggerEvent_6Bean<ImmunizationsBean,ImmunizationCandidateQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20130307L;

}
