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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.coct_mt120402ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.DiagnosisValue;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Diagnosis Indications</p>
 * 
 * <p><p>Describes diagnosis-related indications</p></p>
 * 
 * <p><p>Allows separation of conditions from symptoms from 
 * other forms of indication.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT120402CA.ObservationCondition"})
public class DiagnosisIndicationsBean extends MessagePartBean implements Indications {

    private static final long serialVersionUID = 20111117L;
    private CV code = new CVImpl();
    private CD value = new CDImpl();


    /**
     * <p>Diagnosis Type</p>
     * 
     * <p><p>Identifies the type of condition described (diagnosis 
     * or indication)</p></p>
     * 
     * <p><p>Identifies this measurement as a type of diagnosis and 
     * is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
    }
    public void setCode(ActCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>A:Diagnosis Code</p>
     * 
     * <p><p>A coded form of the diagnosis that is the reason for 
     * the current action.</p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"value"})
    public DiagnosisValue getValue() {
        return (DiagnosisValue) this.value.getValue();
    }
    public void setValue(DiagnosisValue value) {
        this.value.setValue(value);
    }

}
