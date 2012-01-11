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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.URG;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.URGImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.UncertainRange;
import ca.infoway.messagebuilder.domainvalue.ObservationDosageDefinitionPreconditionType;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PORX_MT980010CA.ObservationEventCriterion","PORX_MT980020CA.ObservationEventCriterion","PORX_MT980030CA.ObservationEventCriterion"})
public class DosagePreconditionsBean extends MessagePartBean {

    private static final long serialVersionUID = 20111121L;
    private CV code = new CVImpl();
    private URG<PQ, PhysicalQuantity> value = new URGImpl<PQ, PhysicalQuantity>();


    /**
     * <p>DosagePreconditionType</p>
     * 
     * <p>A:Dosage Precondition Type</p>
     */
    @Hl7XmlMapping({"code"})
    public ObservationDosageDefinitionPreconditionType getCode() {
        return (ObservationDosageDefinitionPreconditionType) this.code.getValue();
    }
    public void setCode(ObservationDosageDefinitionPreconditionType code) {
        this.code.setValue(code);
    }


    /**
     * <p>DosagePreconditionValue</p>
     * 
     * <p>B:Dosage Precondition Value</p>
     */
    @Hl7XmlMapping({"value"})
    public UncertainRange<PhysicalQuantity> getValue() {
        return this.value.getValue();
    }
    public void setValue(UncertainRange<PhysicalQuantity> value) {
        this.value.setValue(value);
    }

}
