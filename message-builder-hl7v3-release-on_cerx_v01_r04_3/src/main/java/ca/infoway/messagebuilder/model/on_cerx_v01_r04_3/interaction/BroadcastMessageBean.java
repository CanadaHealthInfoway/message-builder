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
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.common.mcai_mt700211on.TriggerEventBean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.common.mcci_mt000100on.HL7MessageBean;



/**
 * <p>Business Name: COMT_IN500001ON: Broadcast Message</p>
 * 
 * <p>Sends a broadcast message to all or a subset of users of 
 * a given system; (Used for alerts regarding system outages or 
 * other urgent messages).</p>
 * 
 * <p>Message: MCCI_MT000100ON.Message</p>
 * 
 * <p>Control Act: MCAI_MT700211ON.ControlActEvent</p>
 * 
 * <p>--&gt; Payload: COMT_MT500001ON.InformEvent</p>
 */
@Hl7PartTypeMapping({"COMT_IN500001ON"})
public class BroadcastMessageBean extends HL7MessageBean<TriggerEventBean<ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.si.comt_mt500001on.BroadcastMessageBean>> implements InteractionBean {

    private static final long serialVersionUID = 20190731L;

}
