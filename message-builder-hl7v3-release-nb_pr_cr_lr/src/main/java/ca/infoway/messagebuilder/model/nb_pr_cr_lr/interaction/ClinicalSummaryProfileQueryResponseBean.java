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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.mcci_mt002300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.quqi_mt120006ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.iehr.comt_mt111111ca.Summary;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.iehr.repc_mt000008ca.QueryDefinitionBean;



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
 * <p>Control Act: QUQI_MT120006CA.ControlActEvent</p>
 * 
 * <p>--> Payload: COMT_MT111111CA.Summary</p>
 * 
 * <p>----> Payload Choice: COMT_MT111111CA.RenderedContent</p>
 * 
 * <p>----> Payload Choice: COMT_MT111111CA.SHR</p>
 * 
 * <p>----> Payload Choice: COMT_MT111111CA.Pharmacy</p>
 * 
 * <p>----> Payload Choice: COMT_MT111111CA.Lab</p>
 * 
 * <p>--> Payload: REPC_MT000008CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"COMT_IN200000CA"})
public class ClinicalSummaryProfileQueryResponseBean extends HL7MessageBean<TriggerEventBean<Summary,QueryDefinitionBean>> implements InteractionBean {

    private static final long serialVersionUID = 20151013L;

}
