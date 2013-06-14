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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.immunization.poiz_mt070020ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.Patient_2Bean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"POIZ_MT070020CA.ImmunizationProfile"})
@Hl7RootType
public class ImmunizationProfileBean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private Patient_2Bean subject1Patient;
    private List<ImmunizationForecastBean> subject2ImmunizationForecast = new ArrayList<ImmunizationForecastBean>();
    private AttachmentBean pertinentInformationAttachment;


    /**
     * <p>Relationship: POIZ_MT070020CA.Subject.patient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subject1/patient"})
    public Patient_2Bean getSubject1Patient() {
        return this.subject1Patient;
    }

    /**
     * <p>Relationship: POIZ_MT070020CA.Subject.patient</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubject1Patient(Patient_2Bean subject1Patient) {
        this.subject1Patient = subject1Patient;
    }


    /**
     * <p>Relationship: 
     * POIZ_MT070020CA.Subject3.immunizationForecast</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subject2/immunizationForecast"})
    public List<ImmunizationForecastBean> getSubject2ImmunizationForecast() {
        return this.subject2ImmunizationForecast;
    }


    /**
     * <p>Relationship: 
     * POIZ_MT070020CA.PertinentInformation.attachment</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"pertinentInformation/attachment"})
    public AttachmentBean getPertinentInformationAttachment() {
        return this.pertinentInformationAttachment;
    }

    /**
     * <p>Relationship: 
     * POIZ_MT070020CA.PertinentInformation.attachment</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPertinentInformationAttachment(AttachmentBean pertinentInformationAttachment) {
        this.pertinentInformationAttachment = pertinentInformationAttachment;
    }

}
