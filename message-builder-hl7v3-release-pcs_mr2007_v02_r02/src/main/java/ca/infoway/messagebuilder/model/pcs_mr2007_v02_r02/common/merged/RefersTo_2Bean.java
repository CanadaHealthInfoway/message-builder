/**
 * Copyright 2011 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>RefersTo</p>
 * 
 * <p>MFMI_MT700711CA.Subject2: f:refers to</p>
 * 
 * <p><p>On '''creation''' interactions (where the state 
 * transition is null-&gt;active), this must be true otherwise 
 * it must be false.</p></p>
 * 
 * <p><p>Indicates the item(s) being acted upon by this trigger 
 * event.</p><p>Will be mandatory in wrappers with payload 
 * messages, otherwise not present.</p></p>
 * 
 * <p><p>Indicates the item(s) being acted upon by this trigger 
 * event.</p><p>Will be mandatory in wrappers with payload 
 * messages, otherwise not present.</p></p>
 * 
 * <p><p>Provides information about the thing being created, 
 * modified or removed.</p></p>
 * 
 * <p><p>If there are multiple subject items, the changes to 
 * all of them must be either accepted or rejected as a single 
 * action. I.e. One trigger event = 1 unit of work.</p></p>
 * 
 * <p>MFMI_MT700716CA.Subject2: f:refers to</p>
 * 
 * <p><p>Indicates the item(s) being acted upon by this trigger 
 * event.</p><p>Will be mandatory in wrappers with payload 
 * messages, otherwise not present.</p></p>
 * 
 * <p><p>Indicates the item(s) being acted upon by this trigger 
 * event.</p><p>Will be mandatory in wrappers with payload 
 * messages, otherwise not present.</p></p>
 * 
 * <p><p>Provides information about the thing being created, 
 * modified or removed.</p></p>
 * 
 * <p><p>If there are multiple subject items, the changes to 
 * all of them must be either accepted or rejected as a single 
 * action. I.e. One trigger event = 1 unit of work.</p></p>
 */
@Hl7PartTypeMapping({"MFMI_MT700711CA.Subject2","MFMI_MT700716CA.Subject2"})
public class RefersTo_2Bean<RR> extends MessagePartBean {

    private static final long serialVersionUID = 20110729L;
    private BL cascadeResponsibilityIndicator = new BLImpl();
    private RegisteredItemBean<RR> registrationRequestSubject;
    private EHRRepositoryBean registrationRequestCustodianAssignedDevice;
    private List<ReplacesBean> registrationRequestReplacementOf = new ArrayList<ReplacesBean>();


    /**
     * <p>CascadeResponsibilityIndicator</p>
     * 
     * <p>Cascade Responsibility Indicator</p>
     * 
     * <p><p>Indicates whether or not objects of the trigger event 
     * are to be cascaded to the payload.</p><p>If true, 
     * associations in the parent act are conducted across the 
     * ActRelationship to the message payload (act). Conduction for 
     * each association is specifically indicated by each 
     * associations' contextControlCode value.</p><p>In other 
     * words, if the &quot;subject&quot; act relationship has 
     * contextConductionInd=true; THEN the subjectOf association is 
     * carried (to the regsitrationRequest act) according to the 
     * subjectOf.contextControlCode (AP = propogate to the reg 
     * request and add to any subject(s) (issues) already present 
     * in the payload).</p></p>
     * 
     * <p><p>Indicates whether or not objects of the trigger event 
     * are to be cascaded to the payload.</p><p>If true, 
     * associations in the parent act are conducted across the 
     * ActRelationship to the message payload (act). Conduction for 
     * each association is specifically indicated by each 
     * associations' contextControlCode value.</p><p>In other 
     * words, if the &quot;subject&quot; act relationship has 
     * contextConductionInd=true; THEN the subjectOf association is 
     * carried (to the regsitrationRequest act) according to the 
     * subjectOf.contextControlCode (AP = propogate to the reg 
     * request and add to any subject(s) (issues) already present 
     * in the payload).</p></p>
     * 
     * <p><p>Indicates whether or not objects of the trigger event 
     * are to be cascaded to the payload.</p><p>If true, 
     * associations in the parent act are conducted across the 
     * ActRelationship to the message payload (act). Conduction for 
     * each association is specifically indicated by each 
     * associations' contextControlCode value.</p><p>In other 
     * words, if the &quot;subject&quot; act relationship has 
     * contextConductionInd=true; THEN the subjectOf association is 
     * carried (to the regsitrationRequest act) according to the 
     * subjectOf.contextControlCode (AP = propogate to the reg 
     * request and add to any subject(s) (issues) already present 
     * in the payload).</p></p>
     * 
     * <p><p>Cascading of trigger event objects allows different 
     * messages to employ consistent and common 
     * objects.</p><p>Attribute is mandatory to ensure that 
     * cascading will be specified one way or another.</p></p>
     * 
     * <p><p>Cascading of trigger event objects allows different 
     * messages to employ consistent and common 
     * objects.</p><p>Attribute is mandatory to ensure that 
     * cascading will be specified one way or another.</p></p>
     * 
     * <p>Cascade Responsibility Indicator</p>
     * 
     * <p><p>On '''creation''' interactions (where the state 
     * transition is null-&gt;active), this must be true otherwise 
     * it must be false.</p></p>
     * 
     * <p><p>Indicates whether or not objects of the trigger event 
     * are to be cascaded to the payload.</p><p>If true, 
     * associations in the parent act are conducted across the 
     * ActRelationship to the message payload (act). Conduction for 
     * each association is specifically indicated by each 
     * associations' contextControlCode value.</p><p>In other 
     * words, if the &quot;subject&quot; act relationship has 
     * contextConductionInd=true; THEN the subjectOf association is 
     * carried (to the regsitrationRequest act) according to the 
     * subjectOf.contextControlCode (AP = propogate to the reg 
     * request and add to any subject(s) (issues) already present 
     * in the payload).</p></p>
     * 
     * <p><p>Indicates whether or not objects of the trigger event 
     * are to be cascaded to the payload.</p><p>If true, 
     * associations in the parent act are conducted across the 
     * ActRelationship to the message payload (act). Conduction for 
     * each association is specifically indicated by each 
     * associations' contextControlCode value.</p><p>In other 
     * words, if the &quot;subject&quot; act relationship has 
     * contextConductionInd=true; THEN the subjectOf association is 
     * carried (to the regsitrationRequest act) according to the 
     * subjectOf.contextControlCode (AP = propogate to the reg 
     * request and add to any subject(s) (issues) already present 
     * in the payload).</p></p>
     * 
     * <p><p>Indicates whether or not objects of the trigger event 
     * are to be cascaded to the payload.</p><p>If true, 
     * associations in the parent act are conducted across the 
     * ActRelationship to the message payload (act). Conduction for 
     * each association is specifically indicated by each 
     * associations' contextControlCode value.</p><p>In other 
     * words, if the &quot;subject&quot; act relationship has 
     * contextConductionInd=true; THEN the subjectOf association is 
     * carried (to the regsitrationRequest act) according to the 
     * subjectOf.contextControlCode (AP = propogate to the reg 
     * request and add to any subject(s) (issues) already present 
     * in the payload).</p></p>
     * 
     * <p><p>Cascading of trigger event objects allows different 
     * messages to employ consistent and common 
     * objects.</p><p>Attribute is mandatory to ensure that 
     * cascading will be specified one way or another.</p></p>
     * 
     * <p><p>Cascading of trigger event objects allows different 
     * messages to employ consistent and common 
     * objects.</p><p>Attribute is mandatory to ensure that 
     * cascading will be specified one way or another.</p></p>
     */
    @Hl7XmlMapping({"contextConductionInd"})
    public Boolean getCascadeResponsibilityIndicator() {
        return this.cascadeResponsibilityIndicator.getValue();
    }
    public void setCascadeResponsibilityIndicator(Boolean cascadeResponsibilityIndicator) {
        this.cascadeResponsibilityIndicator.setValue(cascadeResponsibilityIndicator);
    }


    @Hl7XmlMapping({"registrationRequest/subject"})
    public RegisteredItemBean<RR> getRegistrationRequestSubject() {
        return this.registrationRequestSubject;
    }
    public void setRegistrationRequestSubject(RegisteredItemBean<RR> registrationRequestSubject) {
        this.registrationRequestSubject = registrationRequestSubject;
    }


    @Hl7XmlMapping({"registrationRequest/custodian/assignedDevice"})
    public EHRRepositoryBean getRegistrationRequestCustodianAssignedDevice() {
        return this.registrationRequestCustodianAssignedDevice;
    }
    public void setRegistrationRequestCustodianAssignedDevice(EHRRepositoryBean registrationRequestCustodianAssignedDevice) {
        this.registrationRequestCustodianAssignedDevice = registrationRequestCustodianAssignedDevice;
    }


    @Hl7XmlMapping({"registrationRequest/replacementOf"})
    public List<ReplacesBean> getRegistrationRequestReplacementOf() {
        return this.registrationRequestReplacementOf;
    }

}
