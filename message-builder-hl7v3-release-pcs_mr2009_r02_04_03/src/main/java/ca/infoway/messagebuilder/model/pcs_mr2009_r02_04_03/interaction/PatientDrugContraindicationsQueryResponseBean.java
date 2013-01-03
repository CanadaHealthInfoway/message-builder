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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.IssuesBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.TriggerEvent_6Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.pharmacy.merged.DrugQueryParametersBean;



/**
 * <p>Business Name: PORX_IN050040CA: Patient drug 
 * contraindications query response</p>
 * 
 * <p>Indicates contraindications (if any) associated with 
 * placing a patient on a medication based on their existing 
 * medication and clinical profile. Excludes contraindications 
 * related to dose (which is not known), and may not 
 * appropriately reflect duplicate therapy contraindications 
 * due to lack of timing information.</p>
 * 
 * <p>Message: MCCI_MT002300CA.Message</p>
 * 
 * <p>Payload: QUQI_MT120006CA.ControlActEvent</p>
 * 
 * <p>--> Sub-Payload: COCT_MT260020CA.DetectedIssueEvent</p>
 * 
 * <p>--> Sub-Payload: PORX_MT050020CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"PORX_IN050040CA"})
public class PatientDrugContraindicationsQueryResponseBean extends HL7Message_1Bean<TriggerEvent_6Bean<IssuesBean,DrugQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20130103L;

}
