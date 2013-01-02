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
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.mfmi_mt700751ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.cr.prpa_mt101101ca.ParameterListBean;



/**
 * <p>Business Name: PRPA_IN101105CA: Find Associated Person 
 * Identifiers Query</p>
 * 
 * <p>This interaction sends a query to a Person Registry 
 * requesting all other identifiers associated with a specific 
 * person identifier.</p>
 * 
 * <p>Message: MCCI_MT002100CA.Message</p>
 * 
 * <p>Payload: MFMI_MT700751CA.ControlActEvent</p>
 * 
 * <p>--> Sub-Payload: PRPA_MT101101CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"PRPA_IN101105CA"})
public class FindAssociatedPersonIdentifiersQueryBean extends HL7Message_1Bean<TriggerEventBean<ParameterListBean>> implements InteractionBean {

    private static final long serialVersionUID = 20121204L;

}
