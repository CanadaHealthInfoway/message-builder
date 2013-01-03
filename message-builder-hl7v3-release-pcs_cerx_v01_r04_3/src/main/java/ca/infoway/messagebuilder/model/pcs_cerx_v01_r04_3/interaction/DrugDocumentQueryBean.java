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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.quqi_mt020000ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.DrugQueryParametersBean;



/**
 * <p>Business Name: POME_IN010010CA: Drug document query</p>
 * 
 * <p>Requests retrieval of a specific monograph or set of 
 * monographs for a particular medication (specified by 
 * identifier) or indication. The type of monograph (provider, 
 * patient, long, short, etc.) may be specified.</p>
 * 
 * <p>Message: MCCI_MT000100CA.Message</p>
 * 
 * <p>Payload: QUQI_MT020000CA.ControlActEvent</p>
 * 
 * <p>--> Sub-Payload: POME_MT010050CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"POME_IN010010CA"})
public class DrugDocumentQueryBean extends HL7Message_1Bean<TriggerEventBean<DrugQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20130103L;

}
