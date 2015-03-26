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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_4.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_4.common.mcai_mt700210ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_4.common.mcci_mt000100ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_4.iehr.repc_mt000017ca.ProfessionalServiceBean;



/**
 * <p>Business Name: REPC_IN000044CA: Record pharmacy prof 
 * service request</p>
 * 
 * <p>Seeks to add a record of a professional service 
 * (training, counseling, medication reviews, etc.) which has 
 * been delivered to a patient.</p>
 * 
 * <p>Message: MCCI_MT000100CA.Message</p>
 * 
 * <p>Control Act: MCAI_MT700210CA.ControlActEvent</p>
 * 
 * <p>--> Payload: REPC_MT000017CA.ProcedureEvent</p>
 */
@Hl7PartTypeMapping({"REPC_IN000044CA"})
public class RecordPharmacyProfServiceRequestBean extends HL7MessageBean<TriggerEventBean<ProfessionalServiceBean>> implements InteractionBean {

    private static final long serialVersionUID = 20150326L;

}
