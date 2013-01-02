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

package ca.infoway.messagebuilder.model.newfoundland;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;

public abstract class RegistrationBean<T> extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = 4357656443876780252L;

    private BL contextConductionInd = new BLImpl(false);

    protected AssignedDeviceBean assignedDevice;

    protected T record;

    @Hl7XmlMapping("contextConductionInd")
    public boolean isContextConductionInd() {
        return this.contextConductionInd.getValue();
    }

    public void setContextConductionInd(boolean contextConductionInd) {
        this.contextConductionInd.setValue(contextConductionInd);
    }

    public abstract T getRecord();

    public void setRecord(T record) {
        this.record = record;
    }

    public abstract AssignedDeviceBean getAssignedDevice();

    public void setAssignedDevice(AssignedDeviceBean custodian) {
        this.assignedDevice = custodian;
    }
}
