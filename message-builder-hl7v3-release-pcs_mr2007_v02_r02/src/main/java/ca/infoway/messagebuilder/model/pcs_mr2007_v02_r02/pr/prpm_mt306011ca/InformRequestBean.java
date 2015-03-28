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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pr.prpm_mt306011ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CE;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CEImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.domainvalue.ActClass;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActMood;
import ca.infoway.messagebuilder.domainvalue.ParticipationMode;
import ca.infoway.messagebuilder.domainvalue.ParticipationType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pr.merged.ServiceDeliveryLocationBean;



/**
 * <p>Business Name: Inform Request</p>
 * 
 * <p>Acts are the pivot of the RIM; all domain information and 
 * processes are represented primarily in Acts. Any profession 
 * or business, including healthcare, is primarily constituted 
 * of intentional and occasionally non-intentional actions, 
 * performed and recorded by responsible actors. An 
 * Act-instance is a record of such an action.</p>
 * 
 * <p>A record of something that is being done, has been done, 
 * can be done, or is intended or requested to be done.</p>
 */
@Hl7PartTypeMapping({"PRPM_MT306011CA.InformRequest"})
public class InformRequestBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private CS classCode = new CSImpl();
    private CS moodCode = new CSImpl();
    private CD code = new CDImpl();
    private CE subjectModeCode = new CEImpl();
    private ServiceDeliveryLocationBean subjectServiceDeliveryLocation;
    private CS indirectTargetTypeCode = new CSImpl();
    private Choice indirectTargetChoice;


    /**
     * <p>Relationship: PRPM_MT306011CA.InformRequest.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"classCode"})
    public ActClass getClassCode() {
        return (ActClass) this.classCode.getValue();
    }

    /**
     * <p>Relationship: PRPM_MT306011CA.InformRequest.classCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setClassCode(ActClass classCode) {
        this.classCode.setValue(classCode);
    }


    /**
     * <p>Relationship: PRPM_MT306011CA.InformRequest.moodCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"moodCode"})
    public ActMood getMoodCode() {
        return (ActMood) this.moodCode.getValue();
    }

    /**
     * <p>Relationship: PRPM_MT306011CA.InformRequest.moodCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setMoodCode(ActMood moodCode) {
        this.moodCode.setValue(moodCode);
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
    @Hl7XmlMapping({"code"})
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
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
    public void setCode(ActCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Relationship: PRPM_MT306011CA.Subject.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subject/modeCode"})
    public ParticipationMode getSubjectModeCode() {
        return (ParticipationMode) this.subjectModeCode.getValue();
    }

    /**
     * <p>Relationship: PRPM_MT306011CA.Subject.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectModeCode(ParticipationMode subjectModeCode) {
        this.subjectModeCode.setValue(subjectModeCode);
    }


    /**
     * <p>Relationship: 
     * PRPM_MT306011CA.Subject.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subject/serviceDeliveryLocation"})
    public ServiceDeliveryLocationBean getSubjectServiceDeliveryLocation() {
        return this.subjectServiceDeliveryLocation;
    }

    /**
     * <p>Relationship: 
     * PRPM_MT306011CA.Subject.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubjectServiceDeliveryLocation(ServiceDeliveryLocationBean subjectServiceDeliveryLocation) {
        this.subjectServiceDeliveryLocation = subjectServiceDeliveryLocation;
    }


    /**
     * <p>Relationship: PRPM_MT306011CA.IndirectTarget.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"indirectTarget/typeCode"})
    public ParticipationType getIndirectTargetTypeCode() {
        return (ParticipationType) this.indirectTargetTypeCode.getValue();
    }

    /**
     * <p>Relationship: PRPM_MT306011CA.IndirectTarget.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setIndirectTargetTypeCode(ParticipationType indirectTargetTypeCode) {
        this.indirectTargetTypeCode.setValue(indirectTargetTypeCode);
    }


    /**
     * <p>Relationship: PRPM_MT306011CA.IndirectTarget.choice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"indirectTarget/choice"})
    public Choice getIndirectTargetChoice() {
        return this.indirectTargetChoice;
    }

    /**
     * <p>Relationship: PRPM_MT306011CA.IndirectTarget.choice</p>
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
