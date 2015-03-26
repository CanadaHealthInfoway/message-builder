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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.common.mcci_mt002100ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.common.quqi_mt020002ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.pharmacy.pome_mt010090ca.DrugQueryParametersBean;



/**
 * <p>Business Name: POME_IN010070CA: Drug search query</p>
 * 
 * <p>Requests retrieval of a lists of candidate drugs based on 
 * various search criteria such as name, route, code, 
 * manufacturer, appearance, etc.</p>
 * 
 * <p>Message: MCCI_MT002100CA.Message</p>
 * 
 * <p>Control Act: QUQI_MT020002CA.ControlActEvent</p>
 * 
 * <p>--> Payload: POME_MT010090CA.ParameterList</p>
 */
@Hl7PartTypeMapping({"POME_IN010070CA"})
public class DrugSearchQueryBean extends HL7MessageBean<TriggerEventBean<DrugQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20150326L;

}
