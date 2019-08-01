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
package ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.coct_mt090310ca.EHRRepositoryBean;



/**
 * <p>Business Name: RefersTo</p>
 * 
 * <p>MFMI_MT700711CA.Subject2: f:refers to</p>
 * 
 * <p>On 'creation' interactions (where the state transition is 
 * null-&gt;active), this must be true otherwise it must be 
 * false.</p>
 * 
 * <p>Provides information about the thing being created, 
 * modified or removed.</p>
 * 
 * <p>If there are multiple subject items, the changes to all 
 * of them must be either accepted or rejected as a single 
 * action. I.e. One trigger event = 1 unit of work.</p>
 * 
 * <p>Indicates the item(s) being acted upon by this trigger 
 * event.</p><p>Will be mandatory in wrappers with payload 
 * messages, otherwise not present.</p>
 * 
 * <p>MFMI_MT700716CA.Subject2: f:refers to</p>
 * 
 * <p>On 'creation' interactions (where the state transition is 
 * null-&gt;active), this must be true otherwise it must be 
 * false.</p>
 * 
 * <p>Provides information about the thing being created, 
 * modified or removed.</p>
 * 
 * <p>If there are multiple subject items, the changes to all 
 * of them must be either accepted or rejected as a single 
 * action. I.e. One trigger event = 1 unit of work.</p>
 * 
 * <p>Indicates the item(s) being acted upon by this trigger 
 * event.</p><p>Will be mandatory in wrappers with payload 
 * messages, otherwise not present.</p>
 */
@Hl7PartTypeMapping({"MFMI_MT700711CA.Subject2","MFMI_MT700716CA.Subject2"})
public class RefersTo_2Bean<RR> extends MessagePartBean {

    private static final long serialVersionUID = 20190801L;
    private BL contextConductionInd = new BLImpl();
    private RegisteredItemBean<RR> registrationRequestSubject;
    private EHRRepositoryBean registrationRequestCustodianAssignedDevice;
    private PriorRegistrationEventBean registrationRequestReplacementOfPriorRegistration;


    /**
     * <p>Business Name: CascadeResponsibilityIndicator</p>
     * 
     * <p>Un-merged Business Name: CascadeResponsibilityIndicator</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700711CA.Subject2.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Cascading of trigger event objects allows different 
     * messages to employ consistent and common 
     * objects.</p><p>Attribute is mandatory to ensure that 
     * cascading will be specified one way or another.</p>
     * 
     * <p>Indicates whether or not objects of the trigger event are 
     * to be cascaded to the payload.</p><p>If true, associations 
     * in the parent act are conducted across the ActRelationship 
     * to the message payload (act). Conduction for each 
     * association is specifically indicated by each associations' 
     * contextControlCode value.</p><p>In other words, if the 
     * &quot;subject&quot; act relationship has 
     * contextConductionInd=true; THEN the subjectOf association is 
     * carried (to the regsitrationRequest act) according to the 
     * subjectOf.contextControlCode (AP = propogate to the reg 
     * request and add to any subject(s) (issues) already present 
     * in the payload).</p>
     * 
     * <p>Un-merged Business Name: CascadeResponsibilityIndicator</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700716CA.Subject2.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Cascading of trigger event objects allows different 
     * messages to employ consistent and common 
     * objects.</p><p>Attribute is mandatory to ensure that 
     * cascading will be specified one way or another.</p>
     * 
     * <p>Indicates whether or not objects of the trigger event are 
     * to be cascaded to the payload.</p><p>If true, associations 
     * in the parent act are conducted across the ActRelationship 
     * to the message payload (act). Conduction for each 
     * association is specifically indicated by each associations' 
     * contextControlCode value.</p><p>In other words, if the 
     * &quot;subject&quot; act relationship has 
     * contextConductionInd=true; THEN the subjectOf association is 
     * carried (to the regsitrationRequest act) according to the 
     * subjectOf.contextControlCode (AP = propogate to the reg 
     * request and add to any subject(s) (issues) already present 
     * in the payload).</p>
     */
    @Hl7XmlMapping({"contextConductionInd"})
    public Boolean getContextConductionInd() {
        return this.contextConductionInd.getValue();
    }

    /**
     * <p>Business Name: CascadeResponsibilityIndicator</p>
     * 
     * <p>Un-merged Business Name: CascadeResponsibilityIndicator</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700711CA.Subject2.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Cascading of trigger event objects allows different 
     * messages to employ consistent and common 
     * objects.</p><p>Attribute is mandatory to ensure that 
     * cascading will be specified one way or another.</p>
     * 
     * <p>Indicates whether or not objects of the trigger event are 
     * to be cascaded to the payload.</p><p>If true, associations 
     * in the parent act are conducted across the ActRelationship 
     * to the message payload (act). Conduction for each 
     * association is specifically indicated by each associations' 
     * contextControlCode value.</p><p>In other words, if the 
     * &quot;subject&quot; act relationship has 
     * contextConductionInd=true; THEN the subjectOf association is 
     * carried (to the regsitrationRequest act) according to the 
     * subjectOf.contextControlCode (AP = propogate to the reg 
     * request and add to any subject(s) (issues) already present 
     * in the payload).</p>
     * 
     * <p>Un-merged Business Name: CascadeResponsibilityIndicator</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700716CA.Subject2.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Cascading of trigger event objects allows different 
     * messages to employ consistent and common 
     * objects.</p><p>Attribute is mandatory to ensure that 
     * cascading will be specified one way or another.</p>
     * 
     * <p>Indicates whether or not objects of the trigger event are 
     * to be cascaded to the payload.</p><p>If true, associations 
     * in the parent act are conducted across the ActRelationship 
     * to the message payload (act). Conduction for each 
     * association is specifically indicated by each associations' 
     * contextControlCode value.</p><p>In other words, if the 
     * &quot;subject&quot; act relationship has 
     * contextConductionInd=true; THEN the subjectOf association is 
     * carried (to the regsitrationRequest act) according to the 
     * subjectOf.contextControlCode (AP = propogate to the reg 
     * request and add to any subject(s) (issues) already present 
     * in the payload).</p>
     */
    public void setContextConductionInd(Boolean contextConductionInd) {
        this.contextConductionInd.setValue(contextConductionInd);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MFMI_MT700711CA.RegistrationRequest.subject</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MFMI_MT700716CA.RegistrationRequest.subject</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"registrationRequest/subject"})
    public RegisteredItemBean<RR> getRegistrationRequestSubject() {
        return this.registrationRequestSubject;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MFMI_MT700711CA.RegistrationRequest.subject</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MFMI_MT700716CA.RegistrationRequest.subject</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setRegistrationRequestSubject(RegisteredItemBean<RR> registrationRequestSubject) {
        this.registrationRequestSubject = registrationRequestSubject;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MFMI_MT700711CA.Custodian.assignedDevice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MFMI_MT700716CA.Custodian.assignedDevice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"registrationRequest/custodian/assignedDevice"})
    public EHRRepositoryBean getRegistrationRequestCustodianAssignedDevice() {
        return this.registrationRequestCustodianAssignedDevice;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MFMI_MT700711CA.Custodian.assignedDevice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MFMI_MT700716CA.Custodian.assignedDevice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setRegistrationRequestCustodianAssignedDevice(EHRRepositoryBean registrationRequestCustodianAssignedDevice) {
        this.registrationRequestCustodianAssignedDevice = registrationRequestCustodianAssignedDevice;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700711CA.ReplacementOf.priorRegistration</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700716CA.ReplacementOf.priorRegistration</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"registrationRequest/replacementOf/priorRegistration"})
    public PriorRegistrationEventBean getRegistrationRequestReplacementOfPriorRegistration() {
        return this.registrationRequestReplacementOfPriorRegistration;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700711CA.ReplacementOf.priorRegistration</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700716CA.ReplacementOf.priorRegistration</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setRegistrationRequestReplacementOfPriorRegistration(PriorRegistrationEventBean registrationRequestReplacementOfPriorRegistration) {
        this.registrationRequestReplacementOfPriorRegistration = registrationRequestReplacementOfPriorRegistration;
    }

}
