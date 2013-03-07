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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt120402ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.domainvalue.ProblemType;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.domainvalue.ProblemValue;



/**
 * <p>Business Name: Diagnosis Indications</p>
 * 
 * <p>Allows separation of conditions from symptoms from other 
 * forms of indication.</p>
 * 
 * <p>Describes diagnosis-related indications</p>
 */
@Hl7PartTypeMapping({"COCT_MT120402CA.ObservationProblem"})
public class DiagnosisIndicationsBean extends MessagePartBean implements Indications {

    private static final long serialVersionUID = 20130307L;
    private CV code = new CVImpl();
    private CD value = new CDImpl();


    /**
     * <p>Business Name: Problem Type</p>
     * 
     * <p>Relationship: COCT_MT120402CA.ObservationProblem.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies this measurement as a type of diagnosis and is 
     * therefore mandatory.</p>
     * 
     * <p>Identifies the type of problem described.</p>
     */
    @Hl7XmlMapping({"code"})
    public ProblemType getCode() {
        return (ProblemType) this.code.getValue();
    }

    /**
     * <p>Business Name: Problem Type</p>
     * 
     * <p>Relationship: COCT_MT120402CA.ObservationProblem.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies this measurement as a type of diagnosis and is 
     * therefore mandatory.</p>
     * 
     * <p>Identifies the type of problem described.</p>
     */
    public void setCode(ProblemType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: A:Problem Code</p>
     * 
     * <p>Relationship: COCT_MT120402CA.ObservationProblem.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows cross-checking the use of a therapy against its 
     * indication. Also allows analysis of best practices, etc. 
     * This is the attribute that actually identifies the 
     * indication and is therefore mandatory.</p><p> <i>This 
     * element makes use of the CD datatype because some 
     * terminologies used for the domain require use of 
     * modifiers.</i> </p>
     * 
     * <p>A coded form of the problem that is the reason for the 
     * current action.</p>
     */
    @Hl7XmlMapping({"value"})
    public ProblemValue getValue() {
        return (ProblemValue) this.value.getValue();
    }

    /**
     * <p>Business Name: A:Problem Code</p>
     * 
     * <p>Relationship: COCT_MT120402CA.ObservationProblem.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows cross-checking the use of a therapy against its 
     * indication. Also allows analysis of best practices, etc. 
     * This is the attribute that actually identifies the 
     * indication and is therefore mandatory.</p><p> <i>This 
     * element makes use of the CD datatype because some 
     * terminologies used for the domain require use of 
     * modifiers.</i> </p>
     * 
     * <p>A coded form of the problem that is the reason for the 
     * current action.</p>
     */
    public void setValue(ProblemValue value) {
        this.value.setValue(value);
    }

}
