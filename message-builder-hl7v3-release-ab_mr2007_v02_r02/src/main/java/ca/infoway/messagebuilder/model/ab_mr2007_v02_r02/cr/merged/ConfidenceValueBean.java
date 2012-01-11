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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.cr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.REAL;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.REALImpl;
import ca.infoway.messagebuilder.domainvalue.ActClass;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActMood;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.math.BigDecimal;



/**
 * <p>ConfidenceValue</p>
 * 
 * <p>PRPA_MT101102CA.ObservationEvent: Confidence Value</p>
 * 
 * <p><p>Each returned IdentifiedPerson can have an associated 
 * ObservationEvent reporting the confidence value (degree of 
 * certainty) and the name of the matching algorithm that 
 * resulted in that record's inclusion in the result set.</p></p>
 * 
 * <p><p>Supports the business requirement to provide a 
 * confidence value associated with the identifiedEntity 
 * returned in the response distinguishes these different 
 * representations.</p></p>
 * 
 * <p>PRPA_MT101104CA.ObservationEvent: Confidence Value</p>
 * 
 * <p><p>Each returned IdentifiedPerson can have an associated 
 * ObservationEvent reporting the confidence value (degree of 
 * certainty) and the name of the matching algorithm that 
 * resulted in that record's inclusion in the result set.</p></p>
 * 
 * <p><p>Supports the business requirement to provide a 
 * confidence value associated with the identifiedEntity 
 * returned in the responsedistinguishes these different 
 * representations.</p></p>
 */
@Hl7PartTypeMapping({"PRPA_MT101102CA.ObservationEvent","PRPA_MT101104CA.ObservationEvent"})
public class ConfidenceValueBean extends MessagePartBean {

    private static final long serialVersionUID = 20111208L;
    private CS classCode = new CSImpl();
    private CS moodCode = new CSImpl();
    private CV code = new CVImpl();
    private REAL value = new REALImpl();


    @Hl7XmlMapping({"classCode"})
    public ActClass getClassCode() {
        return (ActClass) this.classCode.getValue();
    }
    public void setClassCode(ActClass classCode) {
        this.classCode.setValue(classCode);
    }


    @Hl7XmlMapping({"moodCode"})
    public ActMood getMoodCode() {
        return (ActMood) this.moodCode.getValue();
    }
    public void setMoodCode(ActMood moodCode) {
        this.moodCode.setValue(moodCode);
    }


    /**
     * <p>ProbabilityMatchCode</p>
     * 
     * <p>*Probability Match Code</p>
     * 
     * <p><p>Supports the business requirement to identify type of 
     * confidence matching used i.e. the code would be the name for 
     * the algorithm for the confidence value</p></p>
     * 
     * <p><p>Mandatory attribute supports confident identification 
     * of intended client</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
    }
    public void setCode(ActCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>ConfidenceValue</p>
     * 
     * <p>Confidence Value</p>
     * 
     * <p><p>A real number value indicating the confidence of the 
     * query with regard to finding the intended target client i.e. 
     * the value would be the computed confidence value.</p></p>
     * 
     * <p><p>Required attribute to provide information about 
     * success of query</p></p>
     */
    @Hl7XmlMapping({"value"})
    public BigDecimal getValue() {
        return this.value.getValue();
    }
    public void setValue(BigDecimal value) {
        this.value.setValue(value);
    }

}
