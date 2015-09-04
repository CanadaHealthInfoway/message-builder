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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.mcci_mt002300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.quqi_mt120006ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.iehr.repc_mt000004ca.AllergyIntoleranceQueryParametersBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.iehr.repc_mt000005ca.AllergyIntoleranceBean;



/**
 * <p>Business Name: REPC_IN000016CA: Patient 
 * allergy/intolerance query response</p>
 * 
 * <p>Returns the details of one or more allergy and 
 * intolerance records.</p>
 * 
 * <p>Message: MCCI_MT002300CA.Message</p>
 * 
 * <p>Control Act: QUQI_MT120006CA.ControlActEvent</p>
 * 
 * <p>--> Payload: REPC_MT000005CA.IntoleranceCondition</p>
 * 
 * <p>--> Payload: REPC_MT000004CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"REPC_IN000016CA"})
public class PatientAllergyIntoleranceQueryResponseBean extends HL7MessageBean<TriggerEventBean<AllergyIntoleranceBean,AllergyIntoleranceQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20150903L;

}
