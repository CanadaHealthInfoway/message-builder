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
package ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.interaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.common.mcai_mt700210on.TriggerEventBean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.common.mcci_mt000100on.HL7MessageBean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.pharmacy.porx_mt990010on.ReferencedRecordBean;



/**
 * <p>Business Name: PORX_IN020370ON: Record dispense reversal 
 * request</p>
 * 
 * <p>Requests that a previously submitted dispense be marked 
 * as reversed. The medication has been disposed of without 
 * having been picked up nor consumed by the patient.</p>
 * 
 * <p>Message: MCCI_MT000100ON.Message</p>
 * 
 * <p>Control Act: MCAI_MT700210ON.ControlActEvent</p>
 * 
 * <p>--&gt; Payload: PORX_MT990010ON.ActEvent</p>
 */
@Hl7PartTypeMapping({"PORX_IN020370ON"})
public class RecordDispenseReversalRequestBean extends HL7MessageBean<TriggerEventBean<ReferencedRecordBean>> implements InteractionBean {

    private static final long serialVersionUID = 20190731L;

}
