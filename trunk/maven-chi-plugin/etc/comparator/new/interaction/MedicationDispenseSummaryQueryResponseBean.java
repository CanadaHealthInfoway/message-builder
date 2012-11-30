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
package ca.infoway.messagebuilder.model.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.common.mcci_mt002300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.common.porx_mt060110ca.ParameterListBean;
import ca.infoway.messagebuilder.model.common.quqi_mt120006ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.merged.DispenseBean;



/**
 * <p>Returns basic information about all medication dispenses 
 * provided to a particular patient. 
 */
@Hl7PartTypeMapping({"PORX_IN060240CA"})
public class MedicationDispenseSummaryQueryResponseBean extends HL7MessageBean<TriggerEventBean<DispenseBean,ParameterListBean>> implements InteractionBean {


}
