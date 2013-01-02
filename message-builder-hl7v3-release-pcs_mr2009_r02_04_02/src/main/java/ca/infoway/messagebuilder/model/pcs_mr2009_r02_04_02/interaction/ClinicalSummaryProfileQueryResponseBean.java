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
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.comt_mt111111ca.Summary;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged.QueryDefinitionBean;



/**
 * <p>Business Name: COMT_IN200000CA: Clinical summary/profile 
 * query response</p>
 * 
 * <p>Return the 'summary' versions of all demographics, 
 * medications, allergies, medical conditions, lab tests, 
 * observations, procedures, encounters, referrals and other 
 * clinical data.</p>
 * 
 * <p>Message: MCCI_MT002300CA.Message</p>
 * 
 * <p>Payload: QUQI_MT120006CA.ControlActEvent</p>
 * 
 * <p>--> Sub-Payload: COMT_MT111111CA.Summary</p>
 * 
 * <p>----> Sub-Payload Choice: COMT_MT111111CA.RenderedContent</p>
 * 
 * <p>----> Sub-Payload Choice: COMT_MT111111CA.SHR</p>
 * 
 * <p>----> Sub-Payload Choice: COMT_MT111111CA.Pharmacy</p>
 * 
 * <p>----> Sub-Payload Choice: COMT_MT111111CA.Lab</p>
 * 
 * <p>--> Sub-Payload: REPC_MT000008CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"COMT_IN200000CA"})
public class ClinicalSummaryProfileQueryResponseBean extends HL7Message_1Bean<TriggerEvent_6Bean<Summary,QueryDefinitionBean>> implements InteractionBean {

    private static final long serialVersionUID = 20121204L;

}
