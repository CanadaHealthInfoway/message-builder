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
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.mcci_mt002300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.mfmi_mt700726ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pr.prpm_mt309000ca.RoleChoice;



/**
 * <p>Business Name: PRPM_IN301011CA: Add Provider Confirmation</p>
 * 
 * <p>This interaction is used to confirm the receipt of the 
 * Add Provider Request interaction. This interaction either 
 * confirms processing of the request and contains the 
 * appropriate identifiers assigned by the provider registry 
 * system; or will indicate that the request could not be 
 * fulfilled (with supporting reasons).</p>
 * 
 * <p>Message: MCCI_MT002300CA.Message</p>
 * 
 * <p>Control Act: MFMI_MT700726CA.ControlActEvent</p>
 * 
 * <p>--> Payload: PRPM_MT309000CA.RoleChoice</p>
 * 
 * <p>----> Payload Choice: PRPM_MT309000CA.AssignedEntity</p>
 * 
 * <p>----> Payload Choice: PRPM_MT309000CA.QualifiedEntity</p>
 * 
 * <p>----> Payload Choice: PRPM_MT309000CA.HealthCareProvider</p>
 */
@Hl7PartTypeMapping({"PRPM_IN301011CA"})
public class AddProviderConfirmationBean extends HL7MessageBean<TriggerEventBean<RoleChoice>> implements InteractionBean {

    private static final long serialVersionUID = 20150902L;

}
