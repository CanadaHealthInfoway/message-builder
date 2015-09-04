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
import ca.infoway.messagebuilder.model.nb_drug.common.mcai_mt700210nb.TriggerEventBean;
import ca.infoway.messagebuilder.model.nb_drug.common.mcci_mt000100nb.HL7MessageBean;
import ca.infoway.messagebuilder.model.nb_drug.pharmacy.porx_mt040020nb.OtherMedicationBean;



/**
 * <p>Business Name: PORX_IN040070NB: Update other medication 
 * request</p>
 * 
 * <p>Requests that status, comments or other information about 
 * an existing medication record be modified.</p>
 * 
 * <p>The most common use of this message would be to update 
 * the &ldquo;effectiveTime&rdquo; of the medication record by 
 * specifying a &ldquo;high&rdquo; element (end date) for the 
 * use of the medication by the patient. The 
 * &ldquo;effectiveTime&rdquo; element may be found in the 
 * message path: &ldquo;/subject /otherMedication&rdquo;.</p> 
 * <p>The next most frequent use of this message may be to 
 * correct or update the &ldquo;route of administration&rdquo; 
 * of the medication. This may be done specifying the 
 * &ldquo;routeCode&rdquo; element in the message path 
 * &ldquo;/subject /otherMedication&rdquo; using the 
 * RouteOfAdministration vocabulary.</p>
 * 
 * <p>Message: MCCI_MT000100NB.Message</p>
 * 
 * <p>Control Act: MCAI_MT700210NB.ControlActEvent</p>
 * 
 * <p>--> Payload: PORX_MT040020NB.OtherMedication</p>
 */
@Hl7PartTypeMapping({"PORX_IN040070NB"})
public class UpdateOtherMedicationRequestBean extends HL7MessageBean<TriggerEventBean<OtherMedicationBean>> implements InteractionBean {

    private static final long serialVersionUID = 20150901L;

}