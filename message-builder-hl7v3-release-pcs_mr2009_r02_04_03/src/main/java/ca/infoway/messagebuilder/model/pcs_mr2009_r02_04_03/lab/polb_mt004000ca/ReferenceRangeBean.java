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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.polb_mt004000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.ANYImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.ObservationInterpretation;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Reference Range</p>
 * 
 * <p><p>Reference ranges are generally presented as a pair of 
 * values (Lo - Hi) of the same datatype as the observation to 
 * which they apply (carried as an IVL). In some cases there 
 * may only be a Lo or a Hi rather than a pair of values.</p></p>
 */
@Hl7PartTypeMapping({"POLB_MT004000CA.InterpretationRange"})
public class ReferenceRangeBean extends MessagePartBean {

    private static final long serialVersionUID = 20120106L;
    private ANY<Object> value = new ANYImpl<Object>();
    private CV interpretationCode = new CVImpl();
    private List<ReferenceRangeCriteriaBean> preconditionObservationEventCriterion = new ArrayList<ReferenceRangeCriteriaBean>();


    /**
     * <p>Reference Range Value</p>
     * 
     * <p><p>Reference ranges are generally presented as a pair of 
     * values (Lo - Hi) of the same datatype as the observation to 
     * which they apply (carried as an IVL). In some cases there 
     * may only be a single value (not a range or interval). If a 
     * coded value applies, the value must be selected from the 
     * LaboratoryResultCodeValue Concept Domain.</p></p>
     */
    @Hl7XmlMapping({"value"})
    public Object getValue() {
        return this.value.getValue();
    }
    public void setValue(Object value) {
        this.value.setValue(value);
    }


    /**
     * <p>Reference Range Interpretation Type</p>
     * 
     * <p><p>Describes the type of range e.g. normal, high, 
     * etc.</p></p>
     */
    @Hl7XmlMapping({"interpretationCode"})
    public ObservationInterpretation getInterpretationCode() {
        return (ObservationInterpretation) this.interpretationCode.getValue();
    }
    public void setInterpretationCode(ObservationInterpretation interpretationCode) {
        this.interpretationCode.setValue(interpretationCode);
    }


    @Hl7XmlMapping({"precondition/observationEventCriterion"})
    public List<ReferenceRangeCriteriaBean> getPreconditionObservationEventCriterion() {
        return this.preconditionObservationEventCriterion;
    }

}