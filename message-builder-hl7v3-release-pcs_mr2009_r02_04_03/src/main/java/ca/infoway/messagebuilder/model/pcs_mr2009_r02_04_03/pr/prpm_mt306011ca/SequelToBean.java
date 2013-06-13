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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.pr.prpm_mt306011ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CE;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CEImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.domainvalue.ParticipationMode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.domainvalue.ActInformRequestType;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.Choice;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.pr.merged.ServiceDeliveryLocationBean;



@Hl7PartTypeMapping({"PRPM_MT306011CA.SequelTo"})
public class SequelToBean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private INT sequenceNumber = new INTImpl();
    private CD informRequestCode = new CDImpl();
    private CE informRequestSubjectModeCode = new CEImpl();
    private ServiceDeliveryLocationBean informRequestSubjectServiceDeliveryLocation;
    private Choice informRequestIndirectTargetChoice;


    /**
     * <p>Business Name: Order of Inform Requests</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.SequelTo.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Allows each Inform Request to be sequentially listed.</p>
     */
    @Hl7XmlMapping({"sequenceNumber"})
    public Integer getSequenceNumber() {
        return this.sequenceNumber.getValue();
    }

    /**
     * <p>Business Name: Order of Inform Requests</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.SequelTo.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Allows each Inform Request to be sequentially listed.</p>
     */
    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber.setValue(sequenceNumber);
    }


    /**
     * <p>Business Name: Inform Request Code</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.InformRequest.code</p>
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
     * <p>Business Name: Inform Request Code</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.InformRequest.code</p>
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
     * <p>Business Name: Service Delivery Location Participation 
     * Mode</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.Subject.modeCode</p>
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
     * <p>Business Name: Service Delivery Location Participation 
     * Mode</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.Subject.modeCode</p>
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
     * <p>Relationship: 
     * PRPM_MT306011CA.Subject.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"informRequest/subject/serviceDeliveryLocation"})
    public ServiceDeliveryLocationBean getInformRequestSubjectServiceDeliveryLocation() {
        return this.informRequestSubjectServiceDeliveryLocation;
    }

    /**
     * <p>Relationship: 
     * PRPM_MT306011CA.Subject.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setInformRequestSubjectServiceDeliveryLocation(ServiceDeliveryLocationBean informRequestSubjectServiceDeliveryLocation) {
        this.informRequestSubjectServiceDeliveryLocation = informRequestSubjectServiceDeliveryLocation;
    }


    /**
     * <p>Relationship: PRPM_MT306011CA.IndirectTarget.choice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"informRequest/indirectTarget/choice"})
    public Choice getInformRequestIndirectTargetChoice() {
        return this.informRequestIndirectTargetChoice;
    }

    /**
     * <p>Relationship: PRPM_MT306011CA.IndirectTarget.choice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setInformRequestIndirectTargetChoice(Choice informRequestIndirectTargetChoice) {
        this.informRequestIndirectTargetChoice = informRequestIndirectTargetChoice;
    }

    public ServiceDeliveryLocationBean getInformRequestIndirectTargetChoiceAsServiceDeliveryLocation() {
        return this.informRequestIndirectTargetChoice instanceof ServiceDeliveryLocationBean ? (ServiceDeliveryLocationBean) this.informRequestIndirectTargetChoice : null;
    }
    public boolean hasInformRequestIndirectTargetChoiceAsServiceDeliveryLocation() {
        return (this.informRequestIndirectTargetChoice instanceof ServiceDeliveryLocationBean);
    }

    public HealthcareProviderBean getInformRequestIndirectTargetChoiceAsHealthCareProvider() {
        return this.informRequestIndirectTargetChoice instanceof HealthcareProviderBean ? (HealthcareProviderBean) this.informRequestIndirectTargetChoice : null;
    }
    public boolean hasInformRequestIndirectTargetChoiceAsHealthCareProvider() {
        return (this.informRequestIndirectTargetChoice instanceof HealthcareProviderBean);
    }

}
