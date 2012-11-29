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

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.mfmi_mt700746ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.merged.EHRRepositoryBean;
import ca.infoway.messagebuilder.model.merged.ReplacesBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



/**
 * <p>f:refers to 
 * 
 * <p>Indicates the item(s) being acted upon by this trigger 
 * event. 
 * 
 * <p>Will be mandatory in wrappers with payload messages, 
 * otherwise not present. 
 * 
 * <p>If there are multiple subject items, the changes to all 
 * of them must be either accepted or rejected as a single 
 * action. I.e. One trigger event = 1 unit of work. 
 * 
 * <p>Provides information about the thing being created, 
 * modified or removed. 
 */
@Hl7PartTypeMapping({"MFMI_MT700746CA.Subject2"})
public class RefersToBean<RR> extends MessagePartBean {

    private List<ReplacesBean> registrationEventReplacementOf = new ArrayList<ReplacesBean>();
    private RR registrationEventSubjectRegisteredRole;
    private EHRRepositoryBean registrationEventCustodianAssignedDevice = new EHRRepositoryBean();

    @Hl7XmlMapping({"registrationEvent/replacementOf"})
    public List<ReplacesBean> getRegistrationEventReplacementOf() {
        return this.registrationEventReplacementOf;
    }

    @Hl7XmlMapping({"registrationEvent/subject/registeredRole"})
    public RR getRegistrationEventSubjectRegisteredRole() {
        return this.registrationEventSubjectRegisteredRole;
    }
    public void setRegistrationEventSubjectRegisteredRole(RR registrationEventSubjectRegisteredRole) {
        this.registrationEventSubjectRegisteredRole = registrationEventSubjectRegisteredRole;
    }

    @Hl7XmlMapping({"registrationEvent/custodian/assignedDevice"})
    public EHRRepositoryBean getRegistrationEventCustodianAssignedDevice() {
        return this.registrationEventCustodianAssignedDevice;
    }
    public void setRegistrationEventCustodianAssignedDevice(EHRRepositoryBean registrationEventCustodianAssignedDevice) {
        this.registrationEventCustodianAssignedDevice = registrationEventCustodianAssignedDevice;
    }

}
