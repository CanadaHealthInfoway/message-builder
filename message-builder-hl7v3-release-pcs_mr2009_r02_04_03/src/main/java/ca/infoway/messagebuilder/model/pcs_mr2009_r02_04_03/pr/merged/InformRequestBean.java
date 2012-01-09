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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.pr.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.ParticipationMode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.Choice;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.ServiceDeliveryLocationBean;



/**
 * <p>InformRequest</p>
 * 
 * <p>PRPM_MT301010CA.InformRequest: Inform Request</p>
 * 
 * <p><p>Class communicates request for routing of information 
 * to a provider or service delivery location.</p></p>
 * 
 * <p><p>The use case for including this class is for 
 * requesting routing of health information where the code 
 * equals the information type. Examples include ECG results, 
 * DI - Diagnostic Image interpretation reports, Lab Test 
 * Results Transcripts</p></p>
 * 
 * <p>PRPM_MT303010CA.InformRequest: Inform Request</p>
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
@Hl7PartTypeMapping({"PRPM_MT301010CA.InformRequest","PRPM_MT303010CA.InformRequest"})
public class InformRequestBean extends MessagePartBean {

    private static final long serialVersionUID = 20120106L;
    private CV code = new CVImpl();
    private CV subjectModeCode = new CVImpl();
    private ServiceDeliveryLocationBean subjectServiceDeliveryLocation;
    private Choice indirectTargetChoice;


    /**
     * <p>InformRequestCode</p>
     * 
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
    public Code getCode() {
        return (Code) this.code.getValue();
    }
    public void setCode(Code code) {
        this.code.setValue(code);
    }


    /**
     * <p>ServiceDeliveryLocationParticipationMode</p>
     * 
     * <p>Service Delivery Location Participation Mode</p>
     * 
     * <p><p>A code specifying the modality by which the Entity 
     * playing the Role is participating in the Act.</p></p>
     * 
     * <p>Service Delivery Location Participation Mode</p>
     * 
     * <p><p>A code specifying the modality by which the Entity 
     * playing the Role is participating in the Act.</p></p>
     * 
     * <p><p>Populated</p></p>
     */
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


    @Hl7XmlMapping({"indirectTarget/choice"})
    public Choice getIndirectTargetChoice() {
        return this.indirectTargetChoice;
    }
    public void setIndirectTargetChoice(Choice indirectTargetChoice) {
        this.indirectTargetChoice = indirectTargetChoice;
    }

}