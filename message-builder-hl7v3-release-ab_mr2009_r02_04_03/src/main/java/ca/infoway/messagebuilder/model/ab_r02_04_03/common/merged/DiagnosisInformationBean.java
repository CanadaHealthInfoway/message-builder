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
package ca.infoway.messagebuilder.model.ab_r02_04_03.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COCT_MT290000CA.DiagnosisInformation","COCT_MT490000CA.DiagnosisInformation"})
public class DiagnosisInformationBean extends MessagePartBean {

    private static final long serialVersionUID = 20150810L;
    private INT sequenceNumber = new INTImpl();
    private DiagnosisBean diagnosis;


    /**
     * <p>Business Name: DiagnosisPriority</p>
     * 
     * <p>Un-merged Business Name: DiagnosisPriority</p>
     * 
     * <p>Relationship: 
     * COCT_MT290000CA.DiagnosisInformation.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>1=Primary, 2=Secondary, etc.</p>
     * 
     * <p>1 = Primary, 2 = Secondary, etc.</p>
     * 
     * <p>Un-merged Business Name: DiagnosisPriority</p>
     * 
     * <p>Relationship: 
     * COCT_MT490000CA.DiagnosisInformation.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>1=Primary, 2=Secondary, etc.</p>
     */
    @Hl7XmlMapping({"sequenceNumber"})
    public Integer getSequenceNumber() {
        return this.sequenceNumber.getValue();
    }

    /**
     * <p>Business Name: DiagnosisPriority</p>
     * 
     * <p>Un-merged Business Name: DiagnosisPriority</p>
     * 
     * <p>Relationship: 
     * COCT_MT290000CA.DiagnosisInformation.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>1=Primary, 2=Secondary, etc.</p>
     * 
     * <p>1 = Primary, 2 = Secondary, etc.</p>
     * 
     * <p>Un-merged Business Name: DiagnosisPriority</p>
     * 
     * <p>Relationship: 
     * COCT_MT490000CA.DiagnosisInformation.sequenceNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>1=Primary, 2=Secondary, etc.</p>
     */
    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber.setValue(sequenceNumber);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT290000CA.DiagnosisInformation.diagnosis</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT490000CA.DiagnosisInformation.diagnosis</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"diagnosis"})
    public DiagnosisBean getDiagnosis() {
        return this.diagnosis;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT290000CA.DiagnosisInformation.diagnosis</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT490000CA.DiagnosisInformation.diagnosis</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setDiagnosis(DiagnosisBean diagnosis) {
        this.diagnosis = diagnosis;
    }

}
