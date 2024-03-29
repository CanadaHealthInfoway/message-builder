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
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pr.prpm_mt303010ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ParticipationMode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.DispenseShipToLocationBean;



/**
 * <p>Business Name: Inform Request</p>
 * 
 * <p>A record of something that is being done, has been done, 
 * can be done, or is intended or requested to be done.</p>
 * 
 * <p>Acts are the pivot of the RIM; all domain information and 
 * processes are represented primarily in Acts. Any profession 
 * or business, including healthcare, is primarily constituted 
 * of intentional and occasionally non-intentional actions, 
 * performed and recorded by responsible actors. An 
 * Act-instance is a record of such an action.</p>
 */
@Hl7PartTypeMapping({"PRPM_MT303010CA.InformRequest"})
public class InformRequestBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private CV code = new CVImpl();
    private CV subjectModeCode = new CVImpl();
    private DispenseShipToLocationBean subjectServiceDeliveryLocation;
    private Choice indirectTargetChoice;


    /**
     * <p>Business Name: Inform Request Code</p>
     * 
     * <p>Relationship: PRPM_MT303010CA.InformRequest.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>A code specifying the particular kind of Act that the 
     * Act-instance represents within its class. Ex. Document 
     * Type</p>
     * 
     * <p>Populated attribute supports the business requirement to 
     * provide coded information about the Act being described</p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
    }

    /**
     * <p>Business Name: Inform Request Code</p>
     * 
     * <p>Relationship: PRPM_MT303010CA.InformRequest.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>A code specifying the particular kind of Act that the 
     * Act-instance represents within its class. Ex. Document 
     * Type</p>
     * 
     * <p>Populated attribute supports the business requirement to 
     * provide coded information about the Act being described</p>
     */
    public void setCode(ActCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Relationship: PRPM_MT303010CA.Subject.modeCode</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subject/modeCode"})
    public ParticipationMode getSubjectModeCode() {
        return (ParticipationMode) this.subjectModeCode.getValue();
    }

    /**
     * <p>Relationship: PRPM_MT303010CA.Subject.modeCode</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubjectModeCode(ParticipationMode subjectModeCode) {
        this.subjectModeCode.setValue(subjectModeCode);
    }


    /**
     * <p>Relationship: 
     * PRPM_MT303010CA.Subject.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subject/serviceDeliveryLocation"})
    public DispenseShipToLocationBean getSubjectServiceDeliveryLocation() {
        return this.subjectServiceDeliveryLocation;
    }

    /**
     * <p>Relationship: 
     * PRPM_MT303010CA.Subject.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubjectServiceDeliveryLocation(DispenseShipToLocationBean subjectServiceDeliveryLocation) {
        this.subjectServiceDeliveryLocation = subjectServiceDeliveryLocation;
    }


    /**
     * <p>Relationship: PRPM_MT303010CA.IndirectTarget.choice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"indirectTarget/choice"})
    public Choice getIndirectTargetChoice() {
        return this.indirectTargetChoice;
    }

    /**
     * <p>Relationship: PRPM_MT303010CA.IndirectTarget.choice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setIndirectTargetChoice(Choice indirectTargetChoice) {
        this.indirectTargetChoice = indirectTargetChoice;
    }

    public RoleChoice getIndirectTargetChoiceAsServiceDeliveryLocation() {
        return this.indirectTargetChoice instanceof RoleChoice ? (RoleChoice) this.indirectTargetChoice : null;
    }
    public boolean hasIndirectTargetChoiceAsServiceDeliveryLocation() {
        return (this.indirectTargetChoice instanceof RoleChoice);
    }

    public HealthcareProviderBean getIndirectTargetChoiceAsHealthCareProvider() {
        return this.indirectTargetChoice instanceof HealthcareProviderBean ? (HealthcareProviderBean) this.indirectTargetChoice : null;
    }
    public boolean hasIndirectTargetChoiceAsHealthCareProvider() {
        return (this.indirectTargetChoice instanceof HealthcareProviderBean);
    }

}
