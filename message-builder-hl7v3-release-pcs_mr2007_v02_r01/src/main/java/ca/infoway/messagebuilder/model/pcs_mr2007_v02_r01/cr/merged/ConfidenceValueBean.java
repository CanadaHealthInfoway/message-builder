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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.cr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.REAL;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.REALImpl;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.math.BigDecimal;



@Hl7PartTypeMapping({"PRPA_MT101102CA.ObservationEvent","PRPA_MT101104CA.ObservationEvent","PRPA_MT101106CA.ObservationEvent"})
public class ConfidenceValueBean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
    private CD code = new CDImpl();
    private REAL value = new REALImpl();


    /**
     * <p>ProbabilityMatchCode</p>
     * 
     * <p>Probability Match Code</p>
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
     */
    @Hl7XmlMapping({"value"})
    public BigDecimal getValue() {
        return this.value.getValue();
    }
    public void setValue(BigDecimal value) {
        this.value.setValue(value);
    }

}
