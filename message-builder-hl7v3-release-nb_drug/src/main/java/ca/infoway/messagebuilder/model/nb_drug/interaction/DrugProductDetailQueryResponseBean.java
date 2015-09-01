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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.nb_drug.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.nb_drug.common.mcci_mt000300nb.HL7MessageBean;
import ca.infoway.messagebuilder.model.nb_drug.common.quqi_mt120000nb.TriggerEventBean;
import ca.infoway.messagebuilder.model.nb_drug.pharmacy.pome_mt010030nb.DrugQueryParametersBean;
import ca.infoway.messagebuilder.model.nb_drug.pharmacy.pome_mt010040nb.MedicationBean;



/**
 * <p>Business Name: POME_IN010060NB: Drug product detail query 
 * response</p>
 * 
 * <p>Returns detailed information about a single drug 
 * product.</p>
 * 
 * <p>This query response returns detailed information for each 
 * medication that matches the query criteria specified in the 
 * request message.</p>
 * 
 * <p>Message: MCCI_MT000300NB.Message</p>
 * 
 * <p>Control Act: QUQI_MT120000NB.ControlActEvent</p>
 * 
 * <p>--> Payload: POME_MT010040NB.Medication</p>
 * 
 * <p>--> Payload: POME_MT010030NB.ParameterList</p>
 */
@Hl7PartTypeMapping({"POME_IN010060NB"})
public class DrugProductDetailQueryResponseBean extends HL7MessageBean<TriggerEventBean<MedicationBean,DrugQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20150901L;

}
