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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.model.newfoundland;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;

@Hl7PartTypeMapping({ "MFMI_MT700711CA.Subject2", "MFMI_MT700716CA.Subject2" })
public class RegistrationRequestBean<T> extends RegistrationBean<T> {

    private static final long serialVersionUID = -6919002674167520092L;

    private final Set<ReplacementOfBean> priorRegistrations = Collections.synchronizedSet(new LinkedHashSet<ReplacementOfBean>());

    @Override
    @Hl7XmlMapping("registrationRequest/subject/registeredRole")
    public T getRecord() {
        return this.record;
    }

    @Override
    @Hl7XmlMapping("registrationRequest/custodian/assignedDevice")
    public AssignedDeviceBean getAssignedDevice() {
        return this.assignedDevice;
    }

    @Hl7XmlMapping("registrationRequest/replacementOf")
    public Set<ReplacementOfBean> getPriorRegistrations() {
        return priorRegistrations;
    }
}
