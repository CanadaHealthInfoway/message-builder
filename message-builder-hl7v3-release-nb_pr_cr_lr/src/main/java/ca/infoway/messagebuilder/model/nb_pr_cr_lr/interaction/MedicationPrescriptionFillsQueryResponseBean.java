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
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.mcci_mt002300nb.HL7MessageBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.quqi_mt120006nb.TriggerEventBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.pharmacy.porx_mt060080nb.GenericQueryParametersBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.pharmacy.porx_mt060100nb.DispenseBean;



/**
 * <p>Business Name: PORX_IN060280NB: Medication prescription 
 * fills query response</p>
 * 
 * <p>Returns basic information about all medication dispenses 
 * performed against a particular prescription referenced by 
 * id.</p>
 * 
 * <p>Message: MCCI_MT002300NB.Message</p>
 * 
 * <p>Control Act: QUQI_MT120006NB.ControlActEvent</p>
 * 
 * <p>--> Payload: PORX_MT060100NB.MedicationDispense</p>
 * 
 * <p>--> Payload: PORX_MT060080NB.ParameterList</p>
 */
@Hl7PartTypeMapping({"PORX_IN060280NB"})
public class MedicationPrescriptionFillsQueryResponseBean extends HL7MessageBean<TriggerEventBean<DispenseBean,GenericQueryParametersBean>> implements InteractionBean {

    private static final long serialVersionUID = 20150902L;

}
