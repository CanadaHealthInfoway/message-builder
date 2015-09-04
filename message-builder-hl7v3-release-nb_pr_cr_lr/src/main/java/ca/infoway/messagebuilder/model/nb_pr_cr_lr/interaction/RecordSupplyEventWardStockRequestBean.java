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
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.mcai_mt700212nb.TriggerEventBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.mcci_mt002100nb.HL7MessageBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.pharmacy.porx_mt020050nb.OfficeSupplyBean;



/**
 * <p>Business Name: PORX_IN020210NB: Record supply event (ward 
 * stock) request</p>
 * 
 * <p>Requests that a bulk supply of a medication to a facility 
 * be recorded.</p>
 * 
 * <p>Message: MCCI_MT002100NB.Message</p>
 * 
 * <p>Control Act: MCAI_MT700212NB.ControlActEvent</p>
 * 
 * <p>--> Payload: PORX_MT020050NB.SupplyEvent</p>
 */
@Hl7PartTypeMapping({"PORX_IN020210NB"})
public class RecordSupplyEventWardStockRequestBean extends HL7MessageBean<TriggerEventBean<OfficeSupplyBean>> implements InteractionBean {

    private static final long serialVersionUID = 20150902L;

}