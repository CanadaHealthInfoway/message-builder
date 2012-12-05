/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.quqi_mt120000ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.DrugQueryParametersBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.MonographsBean;



/**
 * <p>Business Name: POME_IN010020CA: Drug document query 
 * response</p>
 * 
 * <p>Returns one or more drug, protocol or contraindication 
 * monographs as text, HTML, PDF or CDA documents.</p>
 * 
 * <p>Message: MCCI_MT000300CA.Message</p>
 * 
 * <p>Payload: QUQI_MT120000CA.ControlActEvent</p>
 * 
 * <p>--> Sub-Payload: PORR_MT050016CA.Document</p>
 * 
 * <p>--> Sub-Payload: POME_MT010050CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"POME_IN010020CA"})
public class DrugDocumentQueryResponseBean extends HL7Message_1Bean<TriggerEventBean<MonographsBean,DrugQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20121204L;

}
