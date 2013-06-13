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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: PatientMeasurableObservations</p>
 * 
 * <p>COCT_MT260010CA.ObservationMeasurableEvent: Patient 
 * Measurable Observations</p>
 * 
 * <p>Useful for determining appropriate management and for 
 * drilling down for more information.</p>
 * 
 * <p>This is the recorded observation (e.g. height, weight, 
 * lab result, etc.) of the patient that contributed to the 
 * issue being raised.</p>
 * 
 * <p>COCT_MT260030CA.ObservationMeasurableEvent: Patient 
 * Measurable Observations</p>
 * 
 * <p>Useful for determining appropriate management and for 
 * drilling down for more information.</p>
 * 
 * <p>This is the recorded observation (e.g. height, weight, 
 * lab result, etc.) of the patient that contributed to the 
 * issue being raised.</p>
 * 
 * <p>COCT_MT260020CA.ObservationMeasurableEvent: Patient 
 * Measurable Observations</p>
 * 
 * <p>Useful for determining appropriate management and for 
 * drilling down for more information.</p>
 * 
 * <p>This is the recorded observation (e.g. allergy, medical 
 * condition, lab result, weight, pregnancy status, etc.) of 
 * the patient that contributed to the issue being raised.</p>
 */
@Hl7PartTypeMapping({"COCT_MT260010CA.ObservationMeasurableEvent","COCT_MT260020CA.ObservationMeasurableEvent","COCT_MT260030CA.ObservationMeasurableEvent"})
public class PatientMeasurableObservationsBean extends MessagePartBean implements CausalActs {

    private static final long serialVersionUID = 20130613L;
    private II id = new IIImpl();
    private CD code = new CDImpl();
    private CV confidentialityCode = new CVImpl();
    private PQ value = new PQImpl();


    /**
     * <p>Business Name: ObservationIdentifier</p>
     * 
     * <p>Un-merged Business Name: ObservationIdentifier</p>
     * 
     * <p>Relationship: 
     * COCT_MT260010CA.ObservationMeasurableEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows lookup of the specific observation (e.g. height, 
     * weight, or lab record) for additional details when 
     * evaluating appropriateness of issue management.</p>
     * 
     * <p>Unique identifier for the record of the observation (e.g. 
     * height, weight or lab test/result) that contributed to the 
     * issue.</p>
     * 
     * <p>Un-merged Business Name: ObservationIdentifier</p>
     * 
     * <p>Relationship: 
     * COCT_MT260030CA.ObservationMeasurableEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows lookup of the specific observation (e.g. height, 
     * weight, or lab record) for additional details when 
     * evaluating appropriateness of issue management.</p>
     * 
     * <p>Unique identifier for the record of the observation (e.g. 
     * height, weight or lab test/result) that contributed to the 
     * issue.</p>
     * 
     * <p>Un-merged Business Name: ObservationIdentifier</p>
     * 
     * <p>Relationship: 
     * COCT_MT260020CA.ObservationMeasurableEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows lookup of the specific observation (e.g. height, 
     * weight, or lab record) for additional details when 
     * evaluating appropriateness of issue management.</p>
     * 
     * <p>Unique identifier for the record of the observation (e.g. 
     * height, weight or lab test/result) that contributed to the 
     * issue.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: ObservationIdentifier</p>
     * 
     * <p>Un-merged Business Name: ObservationIdentifier</p>
     * 
     * <p>Relationship: 
     * COCT_MT260010CA.ObservationMeasurableEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows lookup of the specific observation (e.g. height, 
     * weight, or lab record) for additional details when 
     * evaluating appropriateness of issue management.</p>
     * 
     * <p>Unique identifier for the record of the observation (e.g. 
     * height, weight or lab test/result) that contributed to the 
     * issue.</p>
     * 
     * <p>Un-merged Business Name: ObservationIdentifier</p>
     * 
     * <p>Relationship: 
     * COCT_MT260030CA.ObservationMeasurableEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows lookup of the specific observation (e.g. height, 
     * weight, or lab record) for additional details when 
     * evaluating appropriateness of issue management.</p>
     * 
     * <p>Unique identifier for the record of the observation (e.g. 
     * height, weight or lab test/result) that contributed to the 
     * issue.</p>
     * 
     * <p>Un-merged Business Name: ObservationIdentifier</p>
     * 
     * <p>Relationship: 
     * COCT_MT260020CA.ObservationMeasurableEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows lookup of the specific observation (e.g. height, 
     * weight, or lab record) for additional details when 
     * evaluating appropriateness of issue management.</p>
     * 
     * <p>Unique identifier for the record of the observation (e.g. 
     * height, weight or lab test/result) that contributed to the 
     * issue.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: ObservationType</p>
     * 
     * <p>Un-merged Business Name: ObservationType</p>
     * 
     * <p>Relationship: 
     * COCT_MT260010CA.ObservationMeasurableEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the type of observation record being 
     * referenced. The attribute is mandatory because it is 
     * essential to interpreting the rest of the information on the 
     * class.</p>
     * 
     * <p>Distinguishes between the kinds of measurable observation 
     * that could be the trigger for clinical issue detection. 
     * Measurable observation types include: Lab Result, Height, 
     * Weight, and other measurable information about a person that 
     * may be deemed as a possible trigger for clinical issue 
     * detection.</p>
     * 
     * <p>Un-merged Business Name: ObservationType</p>
     * 
     * <p>Relationship: 
     * COCT_MT260030CA.ObservationMeasurableEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the type of observation record being 
     * referenced. The attribute is mandatory because it is 
     * essential to interpreting the rest of the information on the 
     * class.</p>
     * 
     * <p>Distinguishes between the kinds of measurable observation 
     * that could be the trigger for clinical issue detection. 
     * Measurable observation types include: Lab Result, Height, 
     * Weight, and other measurable information about a person that 
     * may be deemed as a possible trigger for clinical issue 
     * detection.</p>
     * 
     * <p>Un-merged Business Name: ObservationType</p>
     * 
     * <p>Relationship: 
     * COCT_MT260020CA.ObservationMeasurableEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the type of observation record being 
     * referenced. The attribute is mandatory because it is 
     * essential to interpreting the rest of the information on the 
     * class.</p>
     * 
     * <p>Distinguishes between the kinds of measurable 
     * observations that can trigger clinical issues. Measurable 
     * observation types include: Lab Result, Height, Weight, and 
     * other measurable information about a person that may be 
     * deemed as a possible trigger for clinical issue 
     * detection.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
    }

    /**
     * <p>Business Name: ObservationType</p>
     * 
     * <p>Un-merged Business Name: ObservationType</p>
     * 
     * <p>Relationship: 
     * COCT_MT260010CA.ObservationMeasurableEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the type of observation record being 
     * referenced. The attribute is mandatory because it is 
     * essential to interpreting the rest of the information on the 
     * class.</p>
     * 
     * <p>Distinguishes between the kinds of measurable observation 
     * that could be the trigger for clinical issue detection. 
     * Measurable observation types include: Lab Result, Height, 
     * Weight, and other measurable information about a person that 
     * may be deemed as a possible trigger for clinical issue 
     * detection.</p>
     * 
     * <p>Un-merged Business Name: ObservationType</p>
     * 
     * <p>Relationship: 
     * COCT_MT260030CA.ObservationMeasurableEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the type of observation record being 
     * referenced. The attribute is mandatory because it is 
     * essential to interpreting the rest of the information on the 
     * class.</p>
     * 
     * <p>Distinguishes between the kinds of measurable observation 
     * that could be the trigger for clinical issue detection. 
     * Measurable observation types include: Lab Result, Height, 
     * Weight, and other measurable information about a person that 
     * may be deemed as a possible trigger for clinical issue 
     * detection.</p>
     * 
     * <p>Un-merged Business Name: ObservationType</p>
     * 
     * <p>Relationship: 
     * COCT_MT260020CA.ObservationMeasurableEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the type of observation record being 
     * referenced. The attribute is mandatory because it is 
     * essential to interpreting the rest of the information on the 
     * class.</p>
     * 
     * <p>Distinguishes between the kinds of measurable 
     * observations that can trigger clinical issues. Measurable 
     * observation types include: Lab Result, Height, Weight, and 
     * other measurable information about a person that may be 
     * deemed as a possible trigger for clinical issue 
     * detection.</p>
     */
    public void setCode(ActCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Un-merged Business Name: ObservationMaskingIndicator</p>
     * 
     * <p>Relationship: 
     * COCT_MT260010CA.ObservationMeasurableEvent.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Contraindication.intractingSourceMasked (Normal=false; 
     * Restricted or Very Restricted = True); (Information is 
     * withheld because the prescription is masked will be given a 
     * NULL flavour of 'Masked')</p>
     * 
     * <p>Conveys the patient's wishes relating to the sensitivity 
     * of the observation information.</p><p>The attribute is 
     * optional because not all systems will support masking.</p>
     * 
     * <p>An indication of sensitivity surrounding the related 
     * measurable observation, and thus defines the required 
     * sensitivity for the detected issue.</p>
     * 
     * <p>Un-merged Business Name: ObservationMaskingIndicator</p>
     * 
     * <p>Relationship: 
     * COCT_MT260030CA.ObservationMeasurableEvent.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Contraindication.intractingSourceMasked (Normal=false; 
     * Restricted or Very Restricted = True); (Information is 
     * withheld because the prescription is masked will be given a 
     * NULL flavour of 'Masked')</p>
     * 
     * <p>Conveys the patient'''s wishes relating to the 
     * sensitivity of the observation information.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p>
     * 
     * <p>An indication of sensitivity surrounding the related 
     * measurable observation, and thus defines the required 
     * sensitivity for the detected issue.</p>
     * 
     * <p>Un-merged Business Name: ObservationMaskedIndicator</p>
     * 
     * <p>Relationship: 
     * COCT_MT260020CA.ObservationMeasurableEvent.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Contraindication.intractingSourceMasked (Normal=false; 
     * Restricted or Very Restricted = True); (Information is 
     * withheld because the prescription is masked will be given a 
     * NULL flavour of 'Masked')</p>
     * 
     * <p>Conveys the patient's wishes relating to the sensitivity 
     * of the observation.</p><p>The attribute is optional because 
     * not all systems will support masking.</p>
     * 
     * <p>An indication of sensitivity surrounding the offending 
     * measurable observation, and thus defines the required 
     * sensitivity for the detected issue.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }

    /**
     * <p>Un-merged Business Name: ObservationMaskingIndicator</p>
     * 
     * <p>Relationship: 
     * COCT_MT260010CA.ObservationMeasurableEvent.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Contraindication.intractingSourceMasked (Normal=false; 
     * Restricted or Very Restricted = True); (Information is 
     * withheld because the prescription is masked will be given a 
     * NULL flavour of 'Masked')</p>
     * 
     * <p>Conveys the patient's wishes relating to the sensitivity 
     * of the observation information.</p><p>The attribute is 
     * optional because not all systems will support masking.</p>
     * 
     * <p>An indication of sensitivity surrounding the related 
     * measurable observation, and thus defines the required 
     * sensitivity for the detected issue.</p>
     * 
     * <p>Un-merged Business Name: ObservationMaskingIndicator</p>
     * 
     * <p>Relationship: 
     * COCT_MT260030CA.ObservationMeasurableEvent.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Contraindication.intractingSourceMasked (Normal=false; 
     * Restricted or Very Restricted = True); (Information is 
     * withheld because the prescription is masked will be given a 
     * NULL flavour of 'Masked')</p>
     * 
     * <p>Conveys the patient'''s wishes relating to the 
     * sensitivity of the observation information.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p>
     * 
     * <p>An indication of sensitivity surrounding the related 
     * measurable observation, and thus defines the required 
     * sensitivity for the detected issue.</p>
     * 
     * <p>Un-merged Business Name: ObservationMaskedIndicator</p>
     * 
     * <p>Relationship: 
     * COCT_MT260020CA.ObservationMeasurableEvent.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Contraindication.intractingSourceMasked (Normal=false; 
     * Restricted or Very Restricted = True); (Information is 
     * withheld because the prescription is masked will be given a 
     * NULL flavour of 'Masked')</p>
     * 
     * <p>Conveys the patient's wishes relating to the sensitivity 
     * of the observation.</p><p>The attribute is optional because 
     * not all systems will support masking.</p>
     * 
     * <p>An indication of sensitivity surrounding the offending 
     * measurable observation, and thus defines the required 
     * sensitivity for the detected issue.</p>
     */
    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }


    /**
     * <p>Business Name: ObservationValue</p>
     * 
     * <p>Un-merged Business Name: ObservationValue</p>
     * 
     * <p>Relationship: 
     * COCT_MT260010CA.ObservationMeasurableEvent.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides unambiguous reference to the related measurable 
     * observation.</p>
     * 
     * <p>Denotes a specific measurable observation made about a 
     * person that might have trigger the clinical issue 
     * detection.</p>
     * 
     * <p>Un-merged Business Name: ObservationValue</p>
     * 
     * <p>Relationship: 
     * COCT_MT260030CA.ObservationMeasurableEvent.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides unambiguous reference to the related measurable 
     * observation.</p>
     * 
     * <p>Denotes a specific measurable observation made about a 
     * person that might have trigger the clinical issue 
     * detection.</p>
     * 
     * <p>Un-merged Business Name: ObservationValue</p>
     * 
     * <p>Relationship: 
     * COCT_MT260020CA.ObservationMeasurableEvent.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides unambiguous reference to the implicated 
     * measurable observation.</p>
     * 
     * <p>Denotes a specific measurable observation made about a 
     * person that triggered the clinical issue detection.</p>
     */
    @Hl7XmlMapping({"value"})
    public PhysicalQuantity getValue() {
        return this.value.getValue();
    }

    /**
     * <p>Business Name: ObservationValue</p>
     * 
     * <p>Un-merged Business Name: ObservationValue</p>
     * 
     * <p>Relationship: 
     * COCT_MT260010CA.ObservationMeasurableEvent.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides unambiguous reference to the related measurable 
     * observation.</p>
     * 
     * <p>Denotes a specific measurable observation made about a 
     * person that might have trigger the clinical issue 
     * detection.</p>
     * 
     * <p>Un-merged Business Name: ObservationValue</p>
     * 
     * <p>Relationship: 
     * COCT_MT260030CA.ObservationMeasurableEvent.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides unambiguous reference to the related measurable 
     * observation.</p>
     * 
     * <p>Denotes a specific measurable observation made about a 
     * person that might have trigger the clinical issue 
     * detection.</p>
     * 
     * <p>Un-merged Business Name: ObservationValue</p>
     * 
     * <p>Relationship: 
     * COCT_MT260020CA.ObservationMeasurableEvent.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Provides unambiguous reference to the implicated 
     * measurable observation.</p>
     * 
     * <p>Denotes a specific measurable observation made about a 
     * person that triggered the clinical issue detection.</p>
     */
    public void setValue(PhysicalQuantity value) {
        this.value.setValue(value);
    }

}
