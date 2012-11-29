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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged.ParameterList_2Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.qucr_mt830201ca.TypeOfSummaryBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.TriggerEvent_6Bean;



/**
 * <p>QUCR_IN830102CA: SOFA Detail Query Results, Rx</p>
 * 
 * <p>Message: MCCI_MT002300CA.Message</p>
 * 
 * <p>Payload: QUQI_MT120008CA.ControlActEvent</p>
 * 
 * <p>--> Sub-Payload: QUCR_MT830201CA.AdjudResultsGroup</p>
 * 
 * <p>--> Sub-Payload: QUCR_MT820201CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"QUCR_IN830102CA"})
public class SOFADetailQueryResultsRxBean extends HL7Message_1Bean<TriggerEvent_6Bean<TypeOfSummaryBean,ParameterList_2Bean>> implements InteractionBean {

    private static final long serialVersionUID = 20121122L;

}
