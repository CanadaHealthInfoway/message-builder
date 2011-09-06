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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pr.prpm_mt306011ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CE;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CEImpl;
import ca.infoway.messagebuilder.domainvalue.ParticipationMode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.Choice;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pr.merged.ServiceDeliveryLocationBean;



/**
 * <p>Inform Request</p>
 * 
 * <p><p>Class communicates request for routing of information 
 * to a provider or service delivery location provider.</p></p>
 * 
 * <p><p>The use case for including this class is for 
 * requesting routing of health information where the code 
 * equals the information type. Examples include ECG results, 
 * DI - Diagnostic Image interpretation reports, Lab Test 
 * Results Transcripts</p></p>
 */
@Hl7PartTypeMapping({"PRPM_MT306011CA.InformRequest"})
public class InformRequestBean extends MessagePartBean {

    private static final long serialVersionUID = 20110906L;
    private CD informRequestCode = new CDImpl();
    private CE serviceDeliveryLocationParticipationMode = new CEImpl();
    private ServiceDeliveryLocationBean subjectServiceDeliveryLocation;
    private Choice indirectTargetChoice;


    /**
     * <p>Inform Request Code</p>
     * 
     * <p><p>A coded value denoting a specific document type that a 
     * provider expresses to have routed to them from the Service 
     * Delivery Location to which they are associated.</p></p>
     * 
     * <p><p>Populated - Allows providers to request that specific 
     * document(s) be routed from an SDL to them.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getInformRequestCode() {
        return (Code) this.informRequestCode.getValue();
    }
    public void setInformRequestCode(Code informRequestCode) {
        this.informRequestCode.setValue(informRequestCode);
    }


    /**
     * <p>Service Delivery Location Participation Mode</p>
     * 
     * <p><p>A code specifying the modality by which the Entity 
     * playing the Role is participating in the Act.</p></p>
     */
    @Hl7XmlMapping({"subject/modeCode"})
    public ParticipationMode getServiceDeliveryLocationParticipationMode() {
        return (ParticipationMode) this.serviceDeliveryLocationParticipationMode.getValue();
    }
    public void setServiceDeliveryLocationParticipationMode(ParticipationMode serviceDeliveryLocationParticipationMode) {
        this.serviceDeliveryLocationParticipationMode.setValue(serviceDeliveryLocationParticipationMode);
    }


    @Hl7XmlMapping({"subject/serviceDeliveryLocation"})
    public ServiceDeliveryLocationBean getSubjectServiceDeliveryLocation() {
        return this.subjectServiceDeliveryLocation;
    }
    public void setSubjectServiceDeliveryLocation(ServiceDeliveryLocationBean subjectServiceDeliveryLocation) {
        this.subjectServiceDeliveryLocation = subjectServiceDeliveryLocation;
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
