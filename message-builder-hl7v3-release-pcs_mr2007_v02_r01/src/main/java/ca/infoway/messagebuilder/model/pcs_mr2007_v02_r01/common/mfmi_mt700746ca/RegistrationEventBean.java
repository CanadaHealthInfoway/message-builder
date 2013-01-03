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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.mfmi_mt700746ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.merged.EHRRepositoryBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.merged.RegisteredItemBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.merged.ReplacesBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Business Name: Registration Event</p>
 * 
 * <p>The RegistrationProcess act is the focal act of the 
 * message and therefore is mandatory</p>
 * 
 * <p>This class contains information relevant to the 
 * registration of the payload item(s) into the Master File or 
 * Registry. This message is a response to a request to 
 * register (therefore, the mood is an event).</p>
 */
@Hl7PartTypeMapping({"MFMI_MT700746CA.RegistrationEvent"})
public class RegistrationEventBean<RR> extends MessagePartBean {

    private static final long serialVersionUID = 20130103L;
    private RegisteredItemBean<RR> subject;
    private EHRRepositoryBean custodianAssignedDevice;
    private List<ReplacesBean> replacementOf = new ArrayList<ReplacesBean>();


    /**
     * <p>Relationship: MFMI_MT700746CA.RegistrationEvent.subject</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"subject"})
    public RegisteredItemBean<RR> getSubject() {
        return this.subject;
    }

    /**
     * <p>Relationship: MFMI_MT700746CA.RegistrationEvent.subject</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSubject(RegisteredItemBean<RR> subject) {
        this.subject = subject;
    }


    /**
     * <p>Relationship: MFMI_MT700746CA.Custodian.assignedDevice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"custodian/assignedDevice"})
    public EHRRepositoryBean getCustodianAssignedDevice() {
        return this.custodianAssignedDevice;
    }

    /**
     * <p>Relationship: MFMI_MT700746CA.Custodian.assignedDevice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCustodianAssignedDevice(EHRRepositoryBean custodianAssignedDevice) {
        this.custodianAssignedDevice = custodianAssignedDevice;
    }


    /**
     * <p>Relationship: 
     * MFMI_MT700746CA.RegistrationEvent.replacementOf</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-10)</p>
     */
    @Hl7XmlMapping({"replacementOf"})
    public List<ReplacesBean> getReplacementOf() {
        return this.replacementOf;
    }

}
