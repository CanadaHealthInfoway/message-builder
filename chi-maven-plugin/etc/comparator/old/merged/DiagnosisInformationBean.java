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
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.DiagnosisValue;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COCT_MT290000CA.DiagnosisInformation","COCT_MT490000CA.DiagnosisInformation"})
public class DiagnosisInformationBean extends MessagePartBean {

    private INT sequenceNumber = new INTImpl();
    private CV<ActCode> diagnosisCode = new CVImpl<ActCode>();
    private ST diagnosisText = new STImpl();
    private CV<DiagnosisValue> diagnosisValue = new CVImpl<DiagnosisValue>();

    @Hl7XmlMapping({"sequenceNumber"})
    public java.lang.Integer getSequenceNumber() {
        return this.sequenceNumber.getValue();
    }
    public void setSequenceNumber(java.lang.Integer sequenceNumber) {
        this.sequenceNumber.setValue(sequenceNumber);
    }

    @Hl7XmlMapping({"diagnosis/code"})
    public ActCode getDiagnosisCode() {
        return this.diagnosisCode.getValue();
    }
    public void setDiagnosisCode(ActCode diagnosisCode) {
        this.diagnosisCode.setValue(diagnosisCode);
    }

    @Hl7XmlMapping({"diagnosis/text"})
    public java.lang.String getDiagnosisText() {
        return this.diagnosisText.getValue();
    }
    public void setDiagnosisText(java.lang.String diagnosisText) {
        this.diagnosisText.setValue(diagnosisText);
    }

    @Hl7XmlMapping({"diagnosis/value"})
    public DiagnosisValue getDiagnosisValue() {
        return this.diagnosisValue.getValue();
    }
    public void setDiagnosisValue(DiagnosisValue diagnosisValue) {
        this.diagnosisValue.setValue(diagnosisValue);
    }

}
