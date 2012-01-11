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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.mfmi_mt700746ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.domainvalue.ActRelationshipType;
import ca.infoway.messagebuilder.domainvalue.ContextControl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>f:refers to</p>
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
@Hl7PartTypeMapping({"MFMI_MT700746CA.Subject2"})
public class RefersToBean<RR> extends MessagePartBean {

    private static final long serialVersionUID = 20111208L;
    private CS typeCode = new CSImpl();
    private CS contextControlCode = new CSImpl();
    private BL contextConductionInd = new BLImpl();
    private RegistrationEventBean<RR> registrationEvent;


    @Hl7XmlMapping({"typeCode"})
    public ActRelationshipType getTypeCode() {
        return (ActRelationshipType) this.typeCode.getValue();
    }
    public void setTypeCode(ActRelationshipType typeCode) {
        this.typeCode.setValue(typeCode);
    }


    @Hl7XmlMapping({"contextControlCode"})
    public ContextControl getContextControlCode() {
        return (ContextControl) this.contextControlCode.getValue();
    }
    public void setContextControlCode(ContextControl contextControlCode) {
        this.contextControlCode.setValue(contextControlCode);
    }


    /**
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
     * carried (to the regsitrationEvent act) according to the 
     * subjectOf.contextControlCode (AP = propogate to the reg 
     * event and add to any subject(s) (issues) already 
     * present).</p></p>
     * 
     * <p><p>Indicates whether or not objects of the trigger event 
     * are to be cascaded to the payload.</p><p>If true, 
     * associations in the parent act are conducted across the 
     * ActRelationship to the message payload (act). Conduction for 
     * each association is specifically indicated by each 
     * associations' contextControlCode value.</p><p>In other 
     * words, if the &quot;subject&quot; act relationship has 
     * contextConductionInd=true; THEN the subjectOf association is 
     * carried (to the regsitrationEvent act) according to the 
     * subjectOf.contextControlCode (AP = propogate to the reg 
     * event and add to any subject(s) (issues) already 
     * present).</p></p>
     * 
     * <p><p>Indicates whether or not objects of the trigger event 
     * are to be cascaded to the payload.</p><p>If true, 
     * associations in the parent act are conducted across the 
     * ActRelationship to the message payload (act). Conduction for 
     * each association is specifically indicated by each 
     * associations' contextControlCode value.</p><p>In other 
     * words, if the &quot;subject&quot; act relationship has 
     * contextConductionInd=true; THEN the subjectOf association is 
     * carried (to the regsitrationEvent act) according to the 
     * subjectOf.contextControlCode (AP = propogate to the reg 
     * event and add to any subject(s) (issues) already 
     * present).</p></p>
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
    public Boolean getContextConductionInd() {
        return this.contextConductionInd.getValue();
    }
    public void setContextConductionInd(Boolean contextConductionInd) {
        this.contextConductionInd.setValue(contextConductionInd);
    }


    @Hl7XmlMapping({"registrationEvent"})
    public RegistrationEventBean<RR> getRegistrationEvent() {
        return this.registrationEvent;
    }
    public void setRegistrationEvent(RegistrationEventBean<RR> registrationEvent) {
        this.registrationEvent = registrationEvent;
    }

}
