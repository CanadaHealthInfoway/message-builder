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
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.mcai_mt700220ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.mcci_mt000300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.porx_mt990010ca.ReferencedRecordBean;



/**
 * <p>Business Name: RCMR_IN010001CA: Record consent or 
 * override request accepted</p>
 * 
 * <p>Indicates that the requested consent, revocation of 
 * consent or consent override has been successfully recorded 
 * for a particular patient.</p>
 * 
 * <p>Message: MCCI_MT000300CA.Message</p>
 * 
 * <p>Control Act: MCAI_MT700220CA.ControlActEvent</p>
 * 
 * <p>--> Payload: PORX_MT990010CA.ActEvent</p>
 */
@Hl7PartTypeMapping({"RCMR_IN010001CA"})
public class RecordConsentOrOverrideRequestAcceptedBean extends HL7MessageBean<TriggerEventBean<ReferencedRecordBean>> implements InteractionBean {

    private static final long serialVersionUID = 20150326L;

}
