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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.common.mcci_mt002100ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.common.mfmi_mt700711ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.lr.prpa_mt202301ca.LocationBean;



/**
 * <p>Business Name: PRPA_IN202311CA: Record service delivery 
 * location request</p>
 * 
 * <p>Seeks to add a new service delivery location to the 
 * registry.</p>
 * 
 * <p>Message: MCCI_MT002100CA.Message</p>
 * 
 * <p>Control Act: MFMI_MT700711CA.ControlActEvent</p>
 * 
 * <p>--&gt; Payload: PRPA_MT202301CA.ServiceDeliveryLocation</p>
 */
@Hl7PartTypeMapping({"PRPA_IN202311CA"})
public class RecordServiceDeliveryLocationRequestBean extends HL7MessageBean<TriggerEventBean<LocationBean>> implements InteractionBean {

    private static final long serialVersionUID = 20190731L;

}
