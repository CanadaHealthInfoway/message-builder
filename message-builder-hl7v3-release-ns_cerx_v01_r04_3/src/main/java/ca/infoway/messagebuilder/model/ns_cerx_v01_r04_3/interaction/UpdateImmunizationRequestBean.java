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
package ca.infoway.messagebuilder.model.ns_cerx_v01_r04_3.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.ns_cerx_v01_r04_3.common.mcai_mt700210ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.ns_cerx_v01_r04_3.common.mcci_mt000100ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.ns_cerx_v01_r04_3.immunization.poiz_mt030060ca.ImmunizationsBean;



/**
 * <p>Business Name: POIZ_IN010070CA: Update immunization 
 * request</p>
 * 
 * <p>Request that information about a previously recorded 
 * immunization be changed.</p>
 * 
 * <p>Message: MCCI_MT000100CA.Message</p>
 * 
 * <p>Control Act: MCAI_MT700210CA.ControlActEvent</p>
 * 
 * <p>--&gt; Payload: POIZ_MT030060CA.Immunization</p>
 */
@Hl7PartTypeMapping({"POIZ_IN010070CA"})
public class UpdateImmunizationRequestBean extends HL7MessageBean<TriggerEventBean<ImmunizationsBean>> implements InteractionBean {

    private static final long serialVersionUID = 20190731L;

}
