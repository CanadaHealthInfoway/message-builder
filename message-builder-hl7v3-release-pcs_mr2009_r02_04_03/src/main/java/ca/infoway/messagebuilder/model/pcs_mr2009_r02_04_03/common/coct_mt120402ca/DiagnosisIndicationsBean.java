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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt120402ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Diagnosis Indications</p>
 * 
 * <p><p>Describes diagnosis-related indications</p></p>
 * 
 * <p><p>Allows separation of conditions from symptoms from 
 * other forms of indication.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT120402CA.ObservationProblem"})
public class DiagnosisIndicationsBean extends MessagePartBean implements Indications {

    private static final long serialVersionUID = 20120106L;
    private CV code = new CVImpl();
    private CD value = new CDImpl();


    /**
     * <p>Problem Type</p>
     * 
     * <p><p>Identifies the type of problem described.</p></p>
     * 
     * <p><p>Identifies this measurement as a type of diagnosis and 
     * is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getCode() {
        return (Code) this.code.getValue();
    }
    public void setCode(Code code) {
        this.code.setValue(code);
    }


    /**
     * <p>A:Problem Code</p>
     * 
     * <p><p>A coded form of the problem that is the reason for the 
     * current action.</p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"value"})
    public Code getValue() {
        return (Code) this.value.getValue();
    }
    public void setValue(Code value) {
        this.value.setValue(value);
    }

}
