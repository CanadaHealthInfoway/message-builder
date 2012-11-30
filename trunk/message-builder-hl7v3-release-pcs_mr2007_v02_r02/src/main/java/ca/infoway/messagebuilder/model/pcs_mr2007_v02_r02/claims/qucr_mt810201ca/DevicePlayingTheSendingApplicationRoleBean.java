/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.qucr_mt810201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Device playing the Sending Application Role</p>
 * 
 * <p>Device playing the Sending Application Role</p>
 */
@Hl7PartTypeMapping({"QUCR_MT810201CA.AdjudResultsSendingAppRole"})
public class DevicePlayingTheSendingApplicationRoleBean extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
    private II playingAdjudResultsSendingAppDeviceId = new IIImpl();


    /**
     * <p>Sending application identifier</p>
     */
    @Hl7XmlMapping({"playingAdjudResultsSendingAppDevice/id"})
    public Identifier getPlayingAdjudResultsSendingAppDeviceId() {
        return this.playingAdjudResultsSendingAppDeviceId.getValue();
    }

    /**
     * <p>Sending application identifier</p>
     */
    public void setPlayingAdjudResultsSendingAppDeviceId(Identifier playingAdjudResultsSendingAppDeviceId) {
        this.playingAdjudResultsSendingAppDeviceId.setValue(playingAdjudResultsSendingAppDeviceId);
    }

}
