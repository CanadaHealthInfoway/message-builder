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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.DiagnosisBean;



@Hl7PartTypeMapping({"COCT_MT290000CA.DiagnosisInformation","COCT_MT490000CA.DiagnosisInformation"})
public class DiagnosisInformationBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private INT diagnosisPriority = new INTImpl();
    private DiagnosisBean diagnosis;


    /**
     * <p>DiagnosisPriority</p>
     * 
     * <p>Diagnosis Priority</p>
     * 
     * <p><p>1 = Primary, 2 = Secondary, etc.</p></p>
     * 
     * <p><p>1=Primary, 2=Secondary, etc.</p></p>
     * 
     * <p>Diagnosis Priority</p>
     * 
     * <p><p>1=Primary, 2=Secondary, etc.</p></p>
     */
    @Hl7XmlMapping({"sequenceNumber"})
    public Integer getDiagnosisPriority() {
        return this.diagnosisPriority.getValue();
    }
    public void setDiagnosisPriority(Integer diagnosisPriority) {
        this.diagnosisPriority.setValue(diagnosisPriority);
    }


    @Hl7XmlMapping({"diagnosis"})
    public DiagnosisBean getDiagnosis() {
        return this.diagnosis;
    }
    public void setDiagnosis(DiagnosisBean diagnosis) {
        this.diagnosis = diagnosis;
    }

}