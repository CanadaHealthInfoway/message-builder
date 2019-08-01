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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.pr.prpm_mt301010ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.ParticipationMode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.domainvalue.ActInformRequestType;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.merged.ServiceDeliveryLocationBean;



/**
 * <p>Business Name: Inform Request</p>
 * 
 * <p>The use case for including this class is for requesting 
 * routing of health information where the code equals the 
 * information type. Examples include ECG results, DI - 
 * Diagnostic Image interpretation reports, Lab Test Results 
 * Transcripts</p>
 * 
 * <p>Class communicates request for routing of information to 
 * a provider or service delivery location.</p>
 */
@Hl7PartTypeMapping({"PRPM_MT301010CA.InformRequest"})
public class InformRequestBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private CV code = new CVImpl();
    private CV subjectModeCode = new CVImpl();
    private ServiceDeliveryLocationBean subjectServiceDeliveryLocation;
    private Choice indirectTargetChoice;


    /**
     * <p>Business Name: Inform Request Code</p>
     * 
     * <p>Relationship: PRPM_MT301010CA.InformRequest.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated - Allows providers to request that specific 
     * document(s) be routed from an SDL to them.</p>
     * 
     * <p>A coded value denoting a specific document type that a 
     * provider expresses to have routed to them from the Service 
     * Delivery Location to which they are associated.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActInformRequestType getCode() {
        return (ActInformRequestType) this.code.getValue();
    }

    /**
     * <p>Business Name: Inform Request Code</p>
     * 
     * <p>Relationship: PRPM_MT301010CA.InformRequest.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated - Allows providers to request that specific 
     * document(s) be routed from an SDL to them.</p>
     * 
     * <p>A coded value denoting a specific document type that a 
     * provider expresses to have routed to them from the Service 
     * Delivery Location to which they are associated.</p>
     */
    public void setCode(ActInformRequestType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Service Delivery Location Participation 
     * Mode</p>
     * 
     * <p>Relationship: PRPM_MT301010CA.Subject.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated</p>
     * 
     * <p>A code specifying the modality by which the Entity 
     * playing the Role is participating in the Act.</p>
     */
    @Hl7XmlMapping({"subject/modeCode"})
    public ParticipationMode getSubjectModeCode() {
        return (ParticipationMode) this.subjectModeCode.getValue();
    }

    /**
     * <p>Business Name: Service Delivery Location Participation 
     * Mode</p>
     * 
     * <p>Relationship: PRPM_MT301010CA.Subject.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated</p>
     * 
     * <p>A code specifying the modality by which the Entity 
     * playing the Role is participating in the Act.</p>
     */
    public void setSubjectModeCode(ParticipationMode subjectModeCode) {
        this.subjectModeCode.setValue(subjectModeCode);
    }


    /**
     * <p>Relationship: 
     * PRPM_MT301010CA.Subject.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subject/serviceDeliveryLocation"})
    public ServiceDeliveryLocationBean getSubjectServiceDeliveryLocation() {
        return this.subjectServiceDeliveryLocation;
    }

    /**
     * <p>Relationship: 
     * PRPM_MT301010CA.Subject.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectServiceDeliveryLocation(ServiceDeliveryLocationBean subjectServiceDeliveryLocation) {
        this.subjectServiceDeliveryLocation = subjectServiceDeliveryLocation;
    }


    /**
     * <p>Relationship: PRPM_MT301010CA.IndirectTarget.choice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"indirectTarget/choice"})
    public Choice getIndirectTargetChoice() {
        return this.indirectTargetChoice;
    }

    /**
     * <p>Relationship: PRPM_MT301010CA.IndirectTarget.choice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setIndirectTargetChoice(Choice indirectTargetChoice) {
        this.indirectTargetChoice = indirectTargetChoice;
    }

    public ServiceDeliveryLocationBean getIndirectTargetChoiceAsServiceDeliveryLocation() {
        return this.indirectTargetChoice instanceof ServiceDeliveryLocationBean ? (ServiceDeliveryLocationBean) this.indirectTargetChoice : null;
    }
    public boolean hasIndirectTargetChoiceAsServiceDeliveryLocation() {
        return (this.indirectTargetChoice instanceof ServiceDeliveryLocationBean);
    }

    public HealthcareProviderBean getIndirectTargetChoiceAsHealthCareProvider() {
        return this.indirectTargetChoice instanceof HealthcareProviderBean ? (HealthcareProviderBean) this.indirectTargetChoice : null;
    }
    public boolean hasIndirectTargetChoiceAsHealthCareProvider() {
        return (this.indirectTargetChoice instanceof HealthcareProviderBean);
    }

}
