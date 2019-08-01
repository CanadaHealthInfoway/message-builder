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
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.mcci_mt002300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.quqi_mt120008ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.pharmacy.pome_mt010030ca.DrugQueryParametersBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.pharmacy.pome_mt010040ca.MedicationBean;



/**
 * <p>Business Name: POME_IN010060CA: Drug product detail query 
 * response</p>
 * 
 * <p>Returns detailed information about a single drug 
 * product.</p>
 * 
 * <p>Message: MCCI_MT002300CA.Message</p>
 * 
 * <p>Control Act: QUQI_MT120008CA.ControlActEvent</p>
 * 
 * <p>--&gt; Payload: POME_MT010040CA.AdministerableMaterial</p>
 * 
 * <p>--&gt; Payload: POME_MT010030CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"POME_IN010060CA"})
public class DrugProductDetailQueryResponseBean extends HL7MessageBean<TriggerEventBean<MedicationBean,DrugQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20190801L;

}
