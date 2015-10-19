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
package ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.common.mcci_mt002300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.common.mfmi_mt700746ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.cr.prpa_mt101101ca.ParameterListBean;
import ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.cr.prpa_mt101102ab.IdentifiedEntityBean;



/**
 * <p>Business Name: PRPA_IN101102AB: AB Get Demographics Query 
 * Response</p>
 * 
 * <p>This interaction sends a response from an AB Person 
 * Registry with demographic information for a specific person 
 * identifier.</p>
 * 
 * <p>Message: MCCI_MT002300CA.Message</p>
 * 
 * <p>Control Act: MFMI_MT700746CA.ControlActEvent</p>
 * 
 * <p>--> Payload: PRPA_MT101102AB.IdentifiedEntity</p>
 * 
 * <p>--> Payload: PRPA_MT101101CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"PRPA_IN101102AB"})
public class ABGetDemographicsQueryResponseBean extends HL7MessageBean<TriggerEventBean<ParameterListBean,IdentifiedEntityBean>> implements InteractionBean {

    private static final long serialVersionUID = 20151019L;

}
