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
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.quqi_mt120006ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.porx_mt060060ca.PrescriptionBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.porx_mt060070ca.QueryParametersBean;



/**
 * <p>Business Name: PORX_IN060140CA: Device prescription 
 * summary query response</p>
 * 
 * <p>Returns basic information about all device prescriptions 
 * provided to a single patient, optionally filtered by date 
 * and status.</p>
 * 
 * <p>Message: MCCI_MT002300CA.Message</p>
 * 
 * <p>Control Act: QUQI_MT120006CA.ControlActEvent</p>
 * 
 * <p>--&gt; Payload: PORX_MT060060CA.DevicePrescription</p>
 * 
 * <p>--&gt; Payload: PORX_MT060070CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"PORX_IN060140CA"})
public class DevicePrescriptionSummaryQueryResponseBean extends HL7MessageBean<TriggerEventBean<PrescriptionBean,QueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20190730L;

}
