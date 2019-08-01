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
package ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.common.mcci_mt002100ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.common.mfmi_mt700717ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.cr.prpa_mt101002ab.IdentifiedPersonBean;



/**
 * <p>Business Name: PRPA_IN101004AB: AB Resolve Duplicate 
 * Person Registrations</p>
 * 
 * <p>Message: MCCI_MT002100CA.Message</p>
 * 
 * <p>Control Act: MFMI_MT700717CA.ControlActEvent</p>
 * 
 * <p>--&gt; Payload: PRPA_MT101002AB.IdentifiedEntity</p>
 */
@Hl7PartTypeMapping({"PRPA_IN101004AB"})
public class ABResolveDuplicatePersonRegistrationsBean extends HL7MessageBean<TriggerEventBean<IdentifiedPersonBean>> implements InteractionBean {

    private static final long serialVersionUID = 20190731L;

}
