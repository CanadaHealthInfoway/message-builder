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
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ObservationIssueTriggerMeasuredObservationType;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PORX_MT980010CA.ObservationMeasurableEvent","PORX_MT980020CA.ObservationMeasurableEvent","PORX_MT980030CA.ObservationMeasurableEvent"})
public class PatientMeasurableObservationsBean extends MessagePartBean implements CausalActs {

    private static final long serialVersionUID = 20111121L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private CV confidentialityCode = new CVImpl();
    private PQ value = new PQImpl();


    /**
     * <p>ObservationIdentifier</p>
     * 
     * <p>A:Observation Identifier</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>ObservationType</p>
     * 
     * <p>B:Observation Type</p>
     */
    @Hl7XmlMapping({"code"})
    public ObservationIssueTriggerMeasuredObservationType getCode() {
        return (ObservationIssueTriggerMeasuredObservationType) this.code.getValue();
    }
    public void setCode(ObservationIssueTriggerMeasuredObservationType code) {
        this.code.setValue(code);
    }


    /**
     * <p>D:Observation Masking Indicator</p>
     * 
     * <p>D:Observation Masked Indicator</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }
    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }


    /**
     * <p>ObservationValue</p>
     * 
     * <p>C:Observation Value</p>
     */
    @Hl7XmlMapping({"value"})
    public PhysicalQuantity getValue() {
        return this.value.getValue();
    }
    public void setValue(PhysicalQuantity value) {
        this.value.setValue(value);
    }

}
