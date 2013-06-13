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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pr.prpm_mt306011ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CE;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CEImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.domainvalue.ActClass;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActMood;
import ca.infoway.messagebuilder.domainvalue.ActRelationshipType;
import ca.infoway.messagebuilder.domainvalue.ParticipationMode;
import ca.infoway.messagebuilder.domainvalue.ParticipationType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.Choice;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pr.merged.ServiceDeliveryLocationBean;



@Hl7PartTypeMapping({"PRPM_MT306011CA.SequelTo"})
public class SequelToBean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private CS typeCode = new CSImpl();
    private INT sequenceNumber = new INTImpl();
    private CS informRequestClassCode = new CSImpl();
    private CS informRequestMoodCode = new CSImpl();
    private CD informRequestCode = new CDImpl();
    private CE informRequestSubjectModeCode = new CEImpl();
    private ServiceDeliveryLocationBean informRequestSubjectServiceDeliveryLocation;
    private CS informRequestIndirectTargetTypeCode = new CSImpl();
    private Choice informRequestIndirectTargetChoice;


    /**
     * <p>Relationship: PRPM_MT306011CA.SequelTo.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"typeCode"})
    public ActRelationshipType getTypeCode() {
        return (ActRelationshipType) this.typeCode.getValue();
    }

    /**
     * <p>Relationship: PRPM_MT306011CA.SequelTo.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setTypeCode(ActRelationshipType typeCode) {
        this.typeCode.setValue(typeCode);
    }


    /**
     * <p>Relationship: PRPM_MT306011CA.SequelTo.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"sequenceNumber"})
    public Integer getSequenceNumber() {
        return this.sequenceNumber.getValue();
    }

    /**
     * <p>Relationship: PRPM_MT306011CA.SequelTo.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber.setValue(sequenceNumber);
    }


    /**
     * <p>Relationship: PRPM_MT306011CA.InformRequest.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"informRequest/classCode"})
    public ActClass getInformRequestClassCode() {
        return (ActClass) this.informRequestClassCode.getValue();
    }

    /**
     * <p>Relationship: PRPM_MT306011CA.InformRequest.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setInformRequestClassCode(ActClass informRequestClassCode) {
        this.informRequestClassCode.setValue(informRequestClassCode);
    }


    /**
     * <p>Relationship: PRPM_MT306011CA.InformRequest.moodCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"informRequest/moodCode"})
    public ActMood getInformRequestMoodCode() {
        return (ActMood) this.informRequestMoodCode.getValue();
    }

    /**
     * <p>Relationship: PRPM_MT306011CA.InformRequest.moodCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setInformRequestMoodCode(ActMood informRequestMoodCode) {
        this.informRequestMoodCode.setValue(informRequestMoodCode);
    }


    /**
     * <p>Business Name: Inform Request Code</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.InformRequest.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the business requirement to 
     * provide coded information about the Act being described</p>
     * 
     * <p>A code specifying the particular kind of Act that the 
     * Act-instance represents within its class. Ex. Document 
     * Type</p>
     */
    @Hl7XmlMapping({"informRequest/code"})
    public ActCode getInformRequestCode() {
        return (ActCode) this.informRequestCode.getValue();
    }

    /**
     * <p>Business Name: Inform Request Code</p>
     * 
     * <p>Relationship: PRPM_MT306011CA.InformRequest.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Populated attribute supports the business requirement to 
     * provide coded information about the Act being described</p>
     * 
     * <p>A code specifying the particular kind of Act that the 
     * Act-instance represents within its class. Ex. Document 
     * Type</p>
     */
    public void setInformRequestCode(ActCode informRequestCode) {
        this.informRequestCode.setValue(informRequestCode);
    }


    /**
     * <p>Relationship: PRPM_MT306011CA.Subject.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"informRequest/subject/modeCode"})
    public ParticipationMode getInformRequestSubjectModeCode() {
        return (ParticipationMode) this.informRequestSubjectModeCode.getValue();
    }

    /**
     * <p>Relationship: PRPM_MT306011CA.Subject.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
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
     * <p>Relationship: PRPM_MT306011CA.IndirectTarget.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"informRequest/indirectTarget/typeCode"})
    public ParticipationType getInformRequestIndirectTargetTypeCode() {
        return (ParticipationType) this.informRequestIndirectTargetTypeCode.getValue();
    }

    /**
     * <p>Relationship: PRPM_MT306011CA.IndirectTarget.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setInformRequestIndirectTargetTypeCode(ParticipationType informRequestIndirectTargetTypeCode) {
        this.informRequestIndirectTargetTypeCode.setValue(informRequestIndirectTargetTypeCode);
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

    public RoleChoice getInformRequestIndirectTargetChoiceAsServiceDeliveryLocation() {
        return this.informRequestIndirectTargetChoice instanceof RoleChoice ? (RoleChoice) this.informRequestIndirectTargetChoice : null;
    }
    public boolean hasInformRequestIndirectTargetChoiceAsServiceDeliveryLocation() {
        return (this.informRequestIndirectTargetChoice instanceof RoleChoice);
    }

    public HealthcareProviderBean getInformRequestIndirectTargetChoiceAsHealthCareProvider() {
        return this.informRequestIndirectTargetChoice instanceof HealthcareProviderBean ? (HealthcareProviderBean) this.informRequestIndirectTargetChoice : null;
    }
    public boolean hasInformRequestIndirectTargetChoiceAsHealthCareProvider() {
        return (this.informRequestIndirectTargetChoice instanceof HealthcareProviderBean);
    }

}
