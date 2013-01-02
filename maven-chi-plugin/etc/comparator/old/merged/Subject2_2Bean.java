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
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



@Hl7PartTypeMapping({"MFMI_MT700711CA.Subject2","MFMI_MT700716CA.Subject2"})
public class Subject2_2Bean<RR> extends MessagePartBean {

    private BL cascadeResponsibilityIndicator = new BLImpl();
    private List<ReplacesBean> registrationRequestReplacementOf = new ArrayList<ReplacesBean>();
    private RR registrationRequestSubjectRegisteredRole;
    private EHRRepositoryBean registrationRequestCustodianAssignedDevice = new EHRRepositoryBean();

    @Hl7XmlMapping({"contextConductionInd"})
    public java.lang.Boolean getCascadeResponsibilityIndicator() {
        return this.cascadeResponsibilityIndicator.getValue();
    }
    public void setCascadeResponsibilityIndicator(java.lang.Boolean cascadeResponsibilityIndicator) {
        this.cascadeResponsibilityIndicator.setValue(cascadeResponsibilityIndicator);
    }

    @Hl7XmlMapping({"registrationRequest/replacementOf"})
    public List<ReplacesBean> getRegistrationRequestReplacementOf() {
        return this.registrationRequestReplacementOf;
    }

    @Hl7XmlMapping({"registrationRequest/subject/registeredRole"})
    public RR getRegistrationRequestSubjectRegisteredRole() {
        return this.registrationRequestSubjectRegisteredRole;
    }
    public void setRegistrationRequestSubjectRegisteredRole(RR registrationRequestSubjectRegisteredRole) {
        this.registrationRequestSubjectRegisteredRole = registrationRequestSubjectRegisteredRole;
    }

    @Hl7XmlMapping({"registrationRequest/custodian/assignedDevice"})
    public EHRRepositoryBean getRegistrationRequestCustodianAssignedDevice() {
        return this.registrationRequestCustodianAssignedDevice;
    }
    public void setRegistrationRequestCustodianAssignedDevice(EHRRepositoryBean registrationRequestCustodianAssignedDevice) {
        this.registrationRequestCustodianAssignedDevice = registrationRequestCustodianAssignedDevice;
    }

}
