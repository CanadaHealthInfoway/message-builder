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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.pr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.domainvalue.ParticipationMode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.domainvalue.ActInformRequestType;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.Choice;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.ServiceDeliveryLocationBean;



@Hl7PartTypeMapping({"PRPM_MT301010CA.SequelTo","PRPM_MT303010CA.SequelTo"})
public class SequelToBean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private INT sequenceNumber = new INTImpl();
    private CV informRequestCode = new CVImpl();
    private CV informRequestSubjectModeCode = new CVImpl();
    private ServiceDeliveryLocationBean informRequestSubjectServiceDeliveryLocation;
    private Choice informRequestIndirectTargetChoice;


    /**
     * <p>Business Name: OrderOfInformRequests</p>
     * 
     * <p>Un-merged Business Name: OrderOfInformRequests</p>
     * 
     * <p>Relationship: PRPM_MT301010CA.SequelTo.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required</p>
     * 
     * <p>Allows each Inform Request to be sequentially listed.</p>
     * 
     * <p>Un-merged Business Name: OrderOfInformRequests</p>
     * 
     * <p>Relationship: PRPM_MT303010CA.SequelTo.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows each Inform Request to be sequentially listed.</p>
     */
    @Hl7XmlMapping({"sequenceNumber"})
    public Integer getSequenceNumber() {
        return this.sequenceNumber.getValue();
    }

    /**
     * <p>Business Name: OrderOfInformRequests</p>
     * 
     * <p>Un-merged Business Name: OrderOfInformRequests</p>
     * 
     * <p>Relationship: PRPM_MT301010CA.SequelTo.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required</p>
     * 
     * <p>Allows each Inform Request to be sequentially listed.</p>
     * 
     * <p>Un-merged Business Name: OrderOfInformRequests</p>
     * 
     * <p>Relationship: PRPM_MT303010CA.SequelTo.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows each Inform Request to be sequentially listed.</p>
     */
    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber.setValue(sequenceNumber);
    }


    /**
     * <p>Business Name: InformRequestCode</p>
     * 
     * <p>Un-merged Business Name: InformRequestCode</p>
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
     * 
     * <p>Un-merged Business Name: InformRequestCode</p>
     * 
     * <p>Relationship: PRPM_MT303010CA.InformRequest.code</p>
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
    @Hl7XmlMapping({"informRequest/code"})
    public ActInformRequestType getInformRequestCode() {
        return (ActInformRequestType) this.informRequestCode.getValue();
    }

    /**
     * <p>Business Name: InformRequestCode</p>
     * 
     * <p>Un-merged Business Name: InformRequestCode</p>
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
     * 
     * <p>Un-merged Business Name: InformRequestCode</p>
     * 
     * <p>Relationship: PRPM_MT303010CA.InformRequest.code</p>
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
    public void setInformRequestCode(ActInformRequestType informRequestCode) {
        this.informRequestCode.setValue(informRequestCode);
    }


    /**
     * <p>Business Name: ServiceDeliveryLocationParticipationMode</p>
     * 
     * <p>Un-merged Business Name: 
     * ServiceDeliveryLocationParticipationMode</p>
     * 
     * <p>Relationship: PRPM_MT301010CA.Subject.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated</p>
     * 
     * <p>A code specifying the modality by which the Entity 
     * playing the Role is participating in the Act.</p>
     * 
     * <p>Un-merged Business Name: 
     * ServiceDeliveryLocationParticipationMode</p>
     * 
     * <p>Relationship: PRPM_MT303010CA.Subject.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>A code specifying the modality by which the Entity 
     * playing the Role is participating in the Act.</p>
     */
    @Hl7XmlMapping({"informRequest/subject/modeCode"})
    public ParticipationMode getInformRequestSubjectModeCode() {
        return (ParticipationMode) this.informRequestSubjectModeCode.getValue();
    }

    /**
     * <p>Business Name: ServiceDeliveryLocationParticipationMode</p>
     * 
     * <p>Un-merged Business Name: 
     * ServiceDeliveryLocationParticipationMode</p>
     * 
     * <p>Relationship: PRPM_MT301010CA.Subject.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated</p>
     * 
     * <p>A code specifying the modality by which the Entity 
     * playing the Role is participating in the Act.</p>
     * 
     * <p>Un-merged Business Name: 
     * ServiceDeliveryLocationParticipationMode</p>
     * 
     * <p>Relationship: PRPM_MT303010CA.Subject.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>A code specifying the modality by which the Entity 
     * playing the Role is participating in the Act.</p>
     */
    public void setInformRequestSubjectModeCode(ParticipationMode informRequestSubjectModeCode) {
        this.informRequestSubjectModeCode.setValue(informRequestSubjectModeCode);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PRPM_MT301010CA.Subject.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PRPM_MT303010CA.Subject.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"informRequest/subject/serviceDeliveryLocation"})
    public ServiceDeliveryLocationBean getInformRequestSubjectServiceDeliveryLocation() {
        return this.informRequestSubjectServiceDeliveryLocation;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PRPM_MT301010CA.Subject.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PRPM_MT303010CA.Subject.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setInformRequestSubjectServiceDeliveryLocation(ServiceDeliveryLocationBean informRequestSubjectServiceDeliveryLocation) {
        this.informRequestSubjectServiceDeliveryLocation = informRequestSubjectServiceDeliveryLocation;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PRPM_MT301010CA.IndirectTarget.choice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PRPM_MT303010CA.IndirectTarget.choice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"informRequest/indirectTarget/choice"})
    public Choice getInformRequestIndirectTargetChoice() {
        return this.informRequestIndirectTargetChoice;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PRPM_MT301010CA.IndirectTarget.choice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PRPM_MT303010CA.IndirectTarget.choice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setInformRequestIndirectTargetChoice(Choice informRequestIndirectTargetChoice) {
        this.informRequestIndirectTargetChoice = informRequestIndirectTargetChoice;
    }

}
