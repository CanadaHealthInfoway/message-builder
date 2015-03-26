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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt090310ca.EHRRepositoryBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>MFMI_MT700717CA.RegistrationEvent: Registration 
 * Notification</p>
 * 
 * <p>The RegistrationProcess act is the focal act of the 
 * message and therefore is mandatory</p>
 * 
 * <p>This class contains information relevant to the 
 * registration of the payload item(s) into the Master File or 
 * Registry. This message is a notification of the 
 * registration.</p>
 * 
 * <p>MFMI_MT700746CA.RegistrationEvent: Registration Event</p>
 * 
 * <p>The RegistrationProcess act is the focal act of the 
 * message and therefore is mandatory</p>
 * 
 * <p>This class contains information relevant to the 
 * registration of the payload item(s) into the Master File or 
 * Registry. This message is a response to a request to 
 * register (therefore, the mood is an event).</p>
 * 
 * <p>MFMI_MT700726CA.RegistrationEvent: Registration Event</p>
 * 
 * <p>The RegistrationProcess act is the focal act of the 
 * message and therefore is mandatory</p>
 * 
 * <p>This class contains information relevant to the 
 * registration of the payload item(s) into the Master File or 
 * Registry. This message is a response to a request to 
 * register (therefore, the mood is an event).</p>
 */
@Hl7PartTypeMapping({"MFMI_MT700717CA.RegistrationEvent","MFMI_MT700726CA.RegistrationEvent","MFMI_MT700746CA.RegistrationEvent"})
public class RegistrationEventBean<RR> extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private RegisteredItemBean<RR> subject;
    private EHRRepositoryBean custodianAssignedDevice;
    private List<PriorRegistrationEventBean> replacementOfPriorRegistration = new ArrayList<PriorRegistrationEventBean>();


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MFMI_MT700717CA.RegistrationEvent.subject</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MFMI_MT700746CA.RegistrationEvent.subject</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MFMI_MT700726CA.RegistrationEvent.subject</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"subject"})
    public RegisteredItemBean<RR> getSubject() {
        return this.subject;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MFMI_MT700717CA.RegistrationEvent.subject</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MFMI_MT700746CA.RegistrationEvent.subject</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MFMI_MT700726CA.RegistrationEvent.subject</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSubject(RegisteredItemBean<RR> subject) {
        this.subject = subject;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MFMI_MT700717CA.Custodian.assignedDevice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MFMI_MT700746CA.Custodian.assignedDevice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MFMI_MT700726CA.Custodian.assignedDevice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"custodian/assignedDevice"})
    public EHRRepositoryBean getCustodianAssignedDevice() {
        return this.custodianAssignedDevice;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MFMI_MT700717CA.Custodian.assignedDevice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MFMI_MT700746CA.Custodian.assignedDevice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MFMI_MT700726CA.Custodian.assignedDevice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCustodianAssignedDevice(EHRRepositoryBean custodianAssignedDevice) {
        this.custodianAssignedDevice = custodianAssignedDevice;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700717CA.ReplacementOf.priorRegistration</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700746CA.ReplacementOf.priorRegistration</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700726CA.ReplacementOf.priorRegistration</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"replacementOf/priorRegistration"})
    public List<PriorRegistrationEventBean> getReplacementOfPriorRegistration() {
        return this.replacementOfPriorRegistration;
    }

}
