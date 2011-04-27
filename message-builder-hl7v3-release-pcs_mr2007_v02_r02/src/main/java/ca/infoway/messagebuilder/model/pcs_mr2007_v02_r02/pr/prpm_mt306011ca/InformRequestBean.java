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
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.Choice;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pr.merged.ServiceDeliveryLocationBean;



/**
 * <p>Inform Request</p>
 * 
 * <p><p>A record of something that is being done, has been 
 * done, can be done, or is intended or requested to be 
 * done.</p></p>
 * 
 * <p><p>Acts are the pivot of the RIM; all domain information 
 * and processes are represented primarily in Acts. Any 
 * profession or business, including healthcare, is primarily 
 * constituted of intentional and occasionally non-intentional 
 * actions, performed and recorded by responsible actors. An 
 * Act-instance is a record of such an action.</p></p>
 */
@Hl7PartTypeMapping({"PRPM_MT306011CA.InformRequest"})
public class InformRequestBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private CS classCode = new CSImpl();
    private CS moodCode = new CSImpl();
    private CD informRequestCode = new CDImpl();
    private CE subjectModeCode = new CEImpl();
    private ServiceDeliveryLocationBean subjectServiceDeliveryLocation;
    private CS indirectTargetTypeCode = new CSImpl();
    private Choice indirectTargetChoice;


    @Hl7XmlMapping({"classCode"})
    public ActClass getClassCode() {
        return (ActClass) this.classCode.getValue();
    }
    public void setClassCode(ActClass classCode) {
        this.classCode.setValue(classCode);
    }


    @Hl7XmlMapping({"moodCode"})
    public ActMood getMoodCode() {
        return (ActMood) this.moodCode.getValue();
    }
    public void setMoodCode(ActMood moodCode) {
        this.moodCode.setValue(moodCode);
    }


    /**
     * <p>Inform Request Code</p>
     * 
     * <p><p>A code specifying the particular kind of Act that the 
     * Act-instance represents within its class. Ex. Document 
     * Type</p></p>
     * 
     * <p><p>Populated attribute supports the business requirement 
     * to provide coded information about the Act being 
     * described</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getInformRequestCode() {
        return (ActCode) this.informRequestCode.getValue();
    }
    public void setInformRequestCode(ActCode informRequestCode) {
        this.informRequestCode.setValue(informRequestCode);
    }


    @Hl7XmlMapping({"subject/modeCode"})
    public ParticipationMode getSubjectModeCode() {
        return (ParticipationMode) this.subjectModeCode.getValue();
    }
    public void setSubjectModeCode(ParticipationMode subjectModeCode) {
        this.subjectModeCode.setValue(subjectModeCode);
    }


    @Hl7XmlMapping({"subject/serviceDeliveryLocation"})
    public ServiceDeliveryLocationBean getSubjectServiceDeliveryLocation() {
        return this.subjectServiceDeliveryLocation;
    }
    public void setSubjectServiceDeliveryLocation(ServiceDeliveryLocationBean subjectServiceDeliveryLocation) {
        this.subjectServiceDeliveryLocation = subjectServiceDeliveryLocation;
    }


    @Hl7XmlMapping({"indirectTarget/typeCode"})
    public ParticipationType getIndirectTargetTypeCode() {
        return (ParticipationType) this.indirectTargetTypeCode.getValue();
    }
    public void setIndirectTargetTypeCode(ParticipationType indirectTargetTypeCode) {
        this.indirectTargetTypeCode.setValue(indirectTargetTypeCode);
    }


    @Hl7XmlMapping({"indirectTarget/choice"})
    public Choice getIndirectTargetChoice() {
        return this.indirectTargetChoice;
    }
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
