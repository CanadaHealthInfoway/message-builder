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
package ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.mcci_mt002100ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.mfmi_mt700711ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.lr.prlo_mt202015ca.LocationBean;



/**
 * <p>Business Name: PRLO_IN202017CA: Update service delivery 
 * location request</p>
 * 
 * <p>Requests that information about a service delivery 
 * location be updated.</p>
 * 
 * <p>Message: MCCI_MT002100CA.Message</p>
 * 
 * <p>Control Act: MFMI_MT700711CA.ControlActEvent</p>
 * 
 * <p>--&gt; Payload: PRLO_MT202015CA.ServiceDeliveryLocation</p>
 */
@Hl7PartTypeMapping({"PRLO_IN202017CA"})
public class UpdateServiceDeliveryLocationRequestBean extends HL7MessageBean<TriggerEventBean<LocationBean>> implements InteractionBean {

    private static final long serialVersionUID = 20190801L;

}
