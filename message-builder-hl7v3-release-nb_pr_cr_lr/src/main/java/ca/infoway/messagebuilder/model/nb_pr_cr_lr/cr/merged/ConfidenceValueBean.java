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
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.cr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.REAL;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.REALImpl;
import ca.infoway.messagebuilder.domainvalue.ObservationQueryMatchType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.math.BigDecimal;



/**
 * <p>Business Name: ConfidenceValue</p>
 * 
 * <p>PRPA_MT101102CA.ObservationEvent: Confidence Value</p>
 * 
 * <p>Supports the business requirement to provide a confidence 
 * value associated with the identifiedEntity returned in the 
 * response distinguishes these different representations.</p>
 * 
 * <p>Each returned IdentifiedPerson can have an associated 
 * ObservationEvent reporting the confidence value (degree of 
 * certainty) and the name of the matching algorithm that 
 * resulted in that record's inclusion in the result set.</p>
 * 
 * <p>PRPA_MT101104CA.ObservationEvent: Confidence Value</p>
 * 
 * <p>Supports the business requirement to provide a confidence 
 * value associated with the identifiedEntity returned in the 
 * responsedistinguishes these different representations.</p>
 * 
 * <p>Each returned IdentifiedPerson can have an associated 
 * ObservationEvent reporting the confidence value (degree of 
 * certainty) and the name of the matching algorithm that 
 * resulted in that record's inclusion in the result set.</p>
 */
@Hl7PartTypeMapping({"PRPA_MT101102CA.ObservationEvent","PRPA_MT101104CA.ObservationEvent"})
public class ConfidenceValueBean extends MessagePartBean {

    private static final long serialVersionUID = 20151013L;
    private CV code = new CVImpl();
    private REAL value = new REALImpl();


    /**
     * <p>Business Name: ProbabilityMatchCode</p>
     * 
     * <p>Un-merged Business Name: ProbabilityMatchCode</p>
     * 
     * <p>Relationship: PRPA_MT101102CA.ObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports confident identification of 
     * intended client</p>
     * 
     * <p>Supports the business requirement to identify type of 
     * confidence matching used i.e. the code would be the name for 
     * the algorithm for the confidence value</p>
     * 
     * <p>Un-merged Business Name: ProbabilityMatchCode</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.ObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports confident identification of 
     * intended client</p>
     * 
     * <p>Supports the business requirement to identify type of 
     * confidence matching used i.e. the code would be the name for 
     * the algorithm for the confidence value</p>
     */
    @Hl7XmlMapping({"code"})
    public ObservationQueryMatchType getCode() {
        return (ObservationQueryMatchType) this.code.getValue();
    }

    /**
     * <p>Business Name: ProbabilityMatchCode</p>
     * 
     * <p>Un-merged Business Name: ProbabilityMatchCode</p>
     * 
     * <p>Relationship: PRPA_MT101102CA.ObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports confident identification of 
     * intended client</p>
     * 
     * <p>Supports the business requirement to identify type of 
     * confidence matching used i.e. the code would be the name for 
     * the algorithm for the confidence value</p>
     * 
     * <p>Un-merged Business Name: ProbabilityMatchCode</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.ObservationEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports confident identification of 
     * intended client</p>
     * 
     * <p>Supports the business requirement to identify type of 
     * confidence matching used i.e. the code would be the name for 
     * the algorithm for the confidence value</p>
     */
    public void setCode(ObservationQueryMatchType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: ConfidenceValue</p>
     * 
     * <p>Un-merged Business Name: ConfidenceValue</p>
     * 
     * <p>Relationship: PRPA_MT101102CA.ObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute to provide information about success 
     * of query</p>
     * 
     * <p>A real number value indicating the confidence of the 
     * query with regard to finding the intended target client i.e. 
     * the value would be the computed confidence value.</p>
     * 
     * <p>Un-merged Business Name: ConfidenceValue</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.ObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute to provide information about success 
     * of query</p>
     * 
     * <p>A real number value indicating the confidence of the 
     * query with regard to finding the intended target client i.e. 
     * the value would be the computed confidence value.</p>
     */
    @Hl7XmlMapping({"value"})
    public BigDecimal getValue() {
        return this.value.getValue();
    }

    /**
     * <p>Business Name: ConfidenceValue</p>
     * 
     * <p>Un-merged Business Name: ConfidenceValue</p>
     * 
     * <p>Relationship: PRPA_MT101102CA.ObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute to provide information about success 
     * of query</p>
     * 
     * <p>A real number value indicating the confidence of the 
     * query with regard to finding the intended target client i.e. 
     * the value would be the computed confidence value.</p>
     * 
     * <p>Un-merged Business Name: ConfidenceValue</p>
     * 
     * <p>Relationship: PRPA_MT101104CA.ObservationEvent.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute to provide information about success 
     * of query</p>
     * 
     * <p>A real number value indicating the confidence of the 
     * query with regard to finding the intended target client i.e. 
     * the value would be the computed confidence value.</p>
     */
    public void setValue(BigDecimal value) {
        this.value.setValue(value);
    }

}
