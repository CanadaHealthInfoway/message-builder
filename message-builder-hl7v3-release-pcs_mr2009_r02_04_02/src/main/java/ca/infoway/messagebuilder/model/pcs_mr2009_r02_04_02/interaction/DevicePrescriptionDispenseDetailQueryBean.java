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
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.mcci_mt002100ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.quqi_mt020000ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.porx_mt060360ca.GenericQueryParametersBean;



/**
 * <p>Business Name: PORX_IN060050CA: Device prescription 
 * dispense detail query</p>
 * 
 * <p>Requests retrieval of detailed information about a single 
 * identified device dispense event.</p>
 * 
 * <p>Message: MCCI_MT002100CA.Message</p>
 * 
 * <p>Control Act: QUQI_MT020000CA.ControlActEvent</p>
 * 
 * <p>--> Payload: PORX_MT060360CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"PORX_IN060050CA"})
public class DevicePrescriptionDispenseDetailQueryBean extends HL7MessageBean<TriggerEventBean<GenericQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20150902L;

}
