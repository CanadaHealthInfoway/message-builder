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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.immunization.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ParticipationMode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



/**
 * <p>POIZ_MT030060CA.Informant: (no business name)</p>
 * 
 * <p>The original source of the information can be important 
 * in evaluating its accuracy and importance. This information 
 * may not always be known. As a result, this association is 
 * required.</p>
 * 
 * <p>Indicates where the information that led to the recording 
 * of this information came from. The possible 3 sources of the 
 * information are: the patient, the patient's representative 
 * or a health-care provider.</p>
 */
@Hl7PartTypeMapping({"POIZ_MT030050CA.Informant","POIZ_MT030060CA.Informant"})
public class InformantBean extends MessagePartBean {

    private static final long serialVersionUID = 20150902L;
    private IVL<TS, Interval<Date>> time = new IVLImpl<TS, Interval<Date>>();
    private CV modeCode = new CVImpl();
    private InformationSourceChoice informationSourceChoice;


    /**
     * <p>Business Name: DateOfInformation</p>
     * 
     * <p>Un-merged Business Name: DateOfInformation</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.Informant.time</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Participation time is needed when the participant's 
     * involvement in the act spans only part of the Act's time. 
     * Participation time is also used to indicate the time at 
     * which certain very common sub-activities happen that are not 
     * worth mentioning in full acts. Not all implementations need 
     * this information. As a result, the attribute is 
     * optional.</p>
     * 
     * <p>Date in which the informant supplied information about an 
     * immunization event. This may differ from the time of the 
     * immunization event for historical entries.</p>
     * 
     * <p>Un-merged Business Name: DateOfInformation</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Informant.time</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"time"})
    public Interval<Date> getTime() {
        return this.time.getValue();
    }

    /**
     * <p>Business Name: DateOfInformation</p>
     * 
     * <p>Un-merged Business Name: DateOfInformation</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.Informant.time</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Participation time is needed when the participant's 
     * involvement in the act spans only part of the Act's time. 
     * Participation time is also used to indicate the time at 
     * which certain very common sub-activities happen that are not 
     * worth mentioning in full acts. Not all implementations need 
     * this information. As a result, the attribute is 
     * optional.</p>
     * 
     * <p>Date in which the informant supplied information about an 
     * immunization event. This may differ from the time of the 
     * immunization event for historical entries.</p>
     * 
     * <p>Un-merged Business Name: DateOfInformation</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Informant.time</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTime(Interval<Date> time) {
        this.time.setValue(time);
    }


    /**
     * <p>Business Name: InformationSourceForm</p>
     * 
     * <p>Un-merged Business Name: InformationSourceForm</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.Informant.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Useful for categorizing how information is gathered from 
     * information sources. This information may not always be 
     * available, so this attribute is noted as being required.</p>
     * 
     * <p>Describes how the information was presented by the 
     * information source.</p>
     * 
     * <p>Un-merged Business Name: InformationSourceForm</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Informant.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"modeCode"})
    public ParticipationMode getModeCode() {
        return (ParticipationMode) this.modeCode.getValue();
    }

    /**
     * <p>Business Name: InformationSourceForm</p>
     * 
     * <p>Un-merged Business Name: InformationSourceForm</p>
     * 
     * <p>Relationship: POIZ_MT030060CA.Informant.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Useful for categorizing how information is gathered from 
     * information sources. This information may not always be 
     * available, so this attribute is noted as being required.</p>
     * 
     * <p>Describes how the information was presented by the 
     * information source.</p>
     * 
     * <p>Un-merged Business Name: InformationSourceForm</p>
     * 
     * <p>Relationship: POIZ_MT030050CA.Informant.modeCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setModeCode(ParticipationMode modeCode) {
        this.modeCode.setValue(modeCode);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030060CA.Informant.informationSourceChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030050CA.Informant.informationSourceChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"informationSourceChoice"})
    public InformationSourceChoice getInformationSourceChoice() {
        return this.informationSourceChoice;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030060CA.Informant.informationSourceChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030050CA.Informant.informationSourceChoice</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setInformationSourceChoice(InformationSourceChoice informationSourceChoice) {
        this.informationSourceChoice = informationSourceChoice;
    }

}
