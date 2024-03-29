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
package ca.infoway.messagebuilder.model.nb_drug.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.nb_drug.common.mcai_mt700220ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.nb_drug.common.mcci_mt000300ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.nb_drug.pharmacy.porx_mt020030ca.PrescriptionDispenseResponseBean;



/**
 * <p>Business Name: PORX_IN020340CA: Record device disp. 
 * processing request accepted</p>
 * 
 * <p>Indicates that the requested device dispense processing 
 * information has been successfully recorded in the patient's 
 * record.</p>
 * 
 * <p>Receiving this message means the dispense was accepted by 
 * the DIS. The message will return a &ldquo;subject&rdquo; 
 * element that contains both the dispense record identifier 
 * and the prescription record identifier in the message paths 
 * &ldquo;/subject /supplyEvent /id&rdquo; and &ldquo;/subject 
 * /supplyEvent /inFulfillmentOf /actRequest /id&rdquo; 
 * respectively.</p>
 * 
 * <p>Message: MCCI_MT000300CA.Message</p>
 * 
 * <p>Control Act: MCAI_MT700220CA.ControlActEvent</p>
 * 
 * <p>--&gt; Payload: PORX_MT020030CA.SupplyEvent</p>
 */
@Hl7PartTypeMapping({"PORX_IN020340CA"})
public class RecordDeviceDispProcessingRequestAcceptedBean extends HL7MessageBean<TriggerEventBean<PrescriptionDispenseResponseBean>> implements InteractionBean {

    private static final long serialVersionUID = 20190731L;

}
