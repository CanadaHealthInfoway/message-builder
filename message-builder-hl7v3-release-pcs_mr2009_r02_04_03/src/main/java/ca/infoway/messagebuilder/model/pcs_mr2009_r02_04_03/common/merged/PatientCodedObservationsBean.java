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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.IssueTriggerObservationValue;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.domainvalue.CommonCodedClinicalObservationType;
import java.util.Set;



/**
 * <p>Business Name: PatientCodedObservations</p>
 * 
 * <p>COCT_MT260010CA.ObservationCodedEvent: Patient Coded 
 * Observations</p>
 * 
 * <p>Useful for determining appropriate management and for 
 * drilling down for more information.</p>
 * 
 * <p>This is the recorded observation (e.g. allergy, medical 
 * condition, lab result, pregnancy status, etc.) of the 
 * patient that contributed to the issue being raised.</p>
 * 
 * <p>COCT_MT260030CA.ObservationCodedEvent: Patient Coded 
 * Observations</p>
 * 
 * <p>Useful for determining appropriate management and for 
 * drilling down for more information.</p>
 * 
 * <p>This is the recorded observation (e.g. allergy, medical 
 * condition, lab result, pregnancy status, etc.) of the 
 * patient that contributed to the issue being raised.</p>
 */
@Hl7PartTypeMapping({"COCT_MT260010CA.ObservationCodedEvent","COCT_MT260020CA.ObservationCodedEvent","COCT_MT260030CA.ObservationCodedEvent"})
public class PatientCodedObservationsBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt260030ca.CausalActs, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt260020ca.CausalActs, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt260010ca.CausalActs {

    private static final long serialVersionUID = 20190731L;
    private II id = new IIImpl();
    private CD code = new CDImpl();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private CV value = new CVImpl();


    /**
     * <p>Business Name: ObservationIdentifier</p>
     * 
     * <p>Un-merged Business Name: ObservationIdentifier</p>
     * 
     * <p>Relationship: COCT_MT260020CA.ObservationCodedEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: ObservationIdentifier</p>
     * 
     * <p>Relationship: COCT_MT260010CA.ObservationCodedEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows lookup of the specific coded observation (e.g. 
     * allergy, medical condition, pregnancy status, etc.) for 
     * additional details when evaluating appropriateness of issue 
     * management.</p>
     * 
     * <p>Unique identifier for the record of the coded observation 
     * (e.g. allergy, medical condition, pregnancy status, etc.) 
     * that contributed to the issue.</p>
     * 
     * <p>Un-merged Business Name: ObservationIdentifier</p>
     * 
     * <p>Relationship: COCT_MT260030CA.ObservationCodedEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows lookup of the specific coded observation (e.g. 
     * allergy, medical condition, pregnancy status, etc.) for 
     * additional details when evaluating appropriateness of issue 
     * management.</p>
     * 
     * <p>Unique identifier for the record of the coded observation 
     * (e.g. allergy, medical condition, pregnancy status, etc.) 
     * that contributed to the issue.</p>
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
     * <p>Relationship: COCT_MT260020CA.ObservationCodedEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: ObservationIdentifier</p>
     * 
     * <p>Relationship: COCT_MT260010CA.ObservationCodedEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows lookup of the specific coded observation (e.g. 
     * allergy, medical condition, pregnancy status, etc.) for 
     * additional details when evaluating appropriateness of issue 
     * management.</p>
     * 
     * <p>Unique identifier for the record of the coded observation 
     * (e.g. allergy, medical condition, pregnancy status, etc.) 
     * that contributed to the issue.</p>
     * 
     * <p>Un-merged Business Name: ObservationIdentifier</p>
     * 
     * <p>Relationship: COCT_MT260030CA.ObservationCodedEvent.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows lookup of the specific coded observation (e.g. 
     * allergy, medical condition, pregnancy status, etc.) for 
     * additional details when evaluating appropriateness of issue 
     * management.</p>
     * 
     * <p>Unique identifier for the record of the coded observation 
     * (e.g. allergy, medical condition, pregnancy status, etc.) 
     * that contributed to the issue.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: ObservationType</p>
     * 
     * <p>Un-merged Business Name: ObservationType</p>
     * 
     * <p>Relationship: COCT_MT260020CA.ObservationCodedEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: ObservationType</p>
     * 
     * <p>Relationship: COCT_MT260010CA.ObservationCodedEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Differentiates DAI from DPD Contraindications</p>
     * 
     * <p>DRU.100-04 (mnemonic)</p>
     * 
     * <p>DRU.100-05 (code system)</p>
     * 
     * <p>Indicates the type of recorded observation being 
     * referenced. The attribute is mandatory because it is 
     * essential to interpreting the rest of the information on the 
     * class.</p>
     * 
     * <p>Distinguishes the kinds of coded observation that could 
     * be the trigger for clinical issue detection. Coded 
     * Observation types include: Allergy, Intolerance, Medical 
     * Condition, Indication, Pregnancy status, Lactation status 
     * and other observable information about a person that may be 
     * deemed as a possible trigger for clinical issue 
     * detection.</p>
     * 
     * <p>Un-merged Business Name: ObservationType</p>
     * 
     * <p>Relationship: COCT_MT260030CA.ObservationCodedEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Differentiates DAI from DPD Contraindications</p>
     * 
     * <p>DRU.100-04 (mnemonic)</p>
     * 
     * <p>DRU.100-05 (code system)</p>
     * 
     * <p>Indicates the type of recorded observation being 
     * referenced. The attribute is mandatory because it is 
     * essential to interpreting the rest of the information on the 
     * class.</p>
     * 
     * <p>Distinguishes the kinds of coded observation that could 
     * be the trigger for clinical issue detection. Coded 
     * Observation types include: Allergy, Intolerance, Medical 
     * Condition, Indication, Pregnancy status, Lactation status 
     * and other observable information about a person that may be 
     * deemed as a possible trigger for clinical issue 
     * detection.</p>
     */
    @Hl7XmlMapping({"code"})
    public CommonCodedClinicalObservationType getCode() {
        return (CommonCodedClinicalObservationType) this.code.getValue();
    }

    /**
     * <p>Business Name: ObservationType</p>
     * 
     * <p>Un-merged Business Name: ObservationType</p>
     * 
     * <p>Relationship: COCT_MT260020CA.ObservationCodedEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: ObservationType</p>
     * 
     * <p>Relationship: COCT_MT260010CA.ObservationCodedEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Differentiates DAI from DPD Contraindications</p>
     * 
     * <p>DRU.100-04 (mnemonic)</p>
     * 
     * <p>DRU.100-05 (code system)</p>
     * 
     * <p>Indicates the type of recorded observation being 
     * referenced. The attribute is mandatory because it is 
     * essential to interpreting the rest of the information on the 
     * class.</p>
     * 
     * <p>Distinguishes the kinds of coded observation that could 
     * be the trigger for clinical issue detection. Coded 
     * Observation types include: Allergy, Intolerance, Medical 
     * Condition, Indication, Pregnancy status, Lactation status 
     * and other observable information about a person that may be 
     * deemed as a possible trigger for clinical issue 
     * detection.</p>
     * 
     * <p>Un-merged Business Name: ObservationType</p>
     * 
     * <p>Relationship: COCT_MT260030CA.ObservationCodedEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Differentiates DAI from DPD Contraindications</p>
     * 
     * <p>DRU.100-04 (mnemonic)</p>
     * 
     * <p>DRU.100-05 (code system)</p>
     * 
     * <p>Indicates the type of recorded observation being 
     * referenced. The attribute is mandatory because it is 
     * essential to interpreting the rest of the information on the 
     * class.</p>
     * 
     * <p>Distinguishes the kinds of coded observation that could 
     * be the trigger for clinical issue detection. Coded 
     * Observation types include: Allergy, Intolerance, Medical 
     * Condition, Indication, Pregnancy status, Lactation status 
     * and other observable information about a person that may be 
     * deemed as a possible trigger for clinical issue 
     * detection.</p>
     */
    public void setCode(CommonCodedClinicalObservationType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Un-merged Business Name: ObservationMaskedIndicator</p>
     * 
     * <p>Relationship: 
     * COCT_MT260020CA.ObservationCodedEvent.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-2)</p>
     * 
     * <p>Un-merged Business Name: ObservationMaskingIndicator</p>
     * 
     * <p>Relationship: 
     * COCT_MT260010CA.ObservationCodedEvent.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-2)</p>
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
     * condition, and thus defines the required sensitivity for the 
     * detected issue.</p>
     * 
     * <p>Un-merged Business Name: ObservationMaskingIndicator</p>
     * 
     * <p>Relationship: 
     * COCT_MT260030CA.ObservationCodedEvent.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-2)</p>
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
     * condition, and thus defines the required sensitivity for the 
     * detected issue.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_BasicConfidentialityKind.class);
    }


    /**
     * <p>Business Name: ObservationValue</p>
     * 
     * <p>Un-merged Business Name: ObservationValue</p>
     * 
     * <p>Relationship: COCT_MT260020CA.ObservationCodedEvent.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: ObservationValue</p>
     * 
     * <p>Relationship: COCT_MT260010CA.ObservationCodedEvent.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Containdication.allergenGroupName (PrintName) 
     * PIN:Contraindications.drugAllergy (Inferred from Code System 
     * - if it is a DIN it is probably a drug)</p>
     * 
     * <p>Contraindication.indicationDescription</p>
     * 
     * <p>ZDU.7.1 (Code System)</p>
     * 
     * <p>ZDU.7.2 (mnemonic)</p>
     * 
     * <p>ZDU.8.2 (Code System)</p>
     * 
     * <p>ZDU.8.3 (mnemonic)</p>
     * 
     * <p>ZDU.8.1 (Print Name)</p>
     * 
     * <p>Disease Code</p>
     * 
     * <p>Provides unambiguous reference to the related coded 
     * observation.</p>
     * 
     * <p>Denotes a specific coded observation made about a person 
     * that might have trigger the clinical issue detection.</p>
     * 
     * <p>Un-merged Business Name: ObservationValue</p>
     * 
     * <p>Relationship: COCT_MT260030CA.ObservationCodedEvent.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Containdication.allergenGroupName (PrintName) 
     * PIN:Contraindications.drugAllergy (Inferred from Code System 
     * - if it is a DIN it is probably a drug)</p>
     * 
     * <p>Contraindication.indicationDescription</p>
     * 
     * <p>ZDU.7.1 (Code System)</p>
     * 
     * <p>ZDU.7.2 (mnemonic)</p>
     * 
     * <p>ZDU.8.2 (Code System)</p>
     * 
     * <p>ZDU.8.3 (mnemonic)</p>
     * 
     * <p>ZDU.8.1 (Print Name)</p>
     * 
     * <p>Disease Code</p>
     * 
     * <p>Provides unambiguous reference to the related coded 
     * observation.</p>
     * 
     * <p>Denotes a specific coded observation made about a person 
     * that might have trigger the clinical issue detection.</p>
     */
    @Hl7XmlMapping({"value"})
    public IssueTriggerObservationValue getValue() {
        return (IssueTriggerObservationValue) this.value.getValue();
    }

    /**
     * <p>Business Name: ObservationValue</p>
     * 
     * <p>Un-merged Business Name: ObservationValue</p>
     * 
     * <p>Relationship: COCT_MT260020CA.ObservationCodedEvent.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: ObservationValue</p>
     * 
     * <p>Relationship: COCT_MT260010CA.ObservationCodedEvent.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Containdication.allergenGroupName (PrintName) 
     * PIN:Contraindications.drugAllergy (Inferred from Code System 
     * - if it is a DIN it is probably a drug)</p>
     * 
     * <p>Contraindication.indicationDescription</p>
     * 
     * <p>ZDU.7.1 (Code System)</p>
     * 
     * <p>ZDU.7.2 (mnemonic)</p>
     * 
     * <p>ZDU.8.2 (Code System)</p>
     * 
     * <p>ZDU.8.3 (mnemonic)</p>
     * 
     * <p>ZDU.8.1 (Print Name)</p>
     * 
     * <p>Disease Code</p>
     * 
     * <p>Provides unambiguous reference to the related coded 
     * observation.</p>
     * 
     * <p>Denotes a specific coded observation made about a person 
     * that might have trigger the clinical issue detection.</p>
     * 
     * <p>Un-merged Business Name: ObservationValue</p>
     * 
     * <p>Relationship: COCT_MT260030CA.ObservationCodedEvent.value</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Containdication.allergenGroupName (PrintName) 
     * PIN:Contraindications.drugAllergy (Inferred from Code System 
     * - if it is a DIN it is probably a drug)</p>
     * 
     * <p>Contraindication.indicationDescription</p>
     * 
     * <p>ZDU.7.1 (Code System)</p>
     * 
     * <p>ZDU.7.2 (mnemonic)</p>
     * 
     * <p>ZDU.8.2 (Code System)</p>
     * 
     * <p>ZDU.8.3 (mnemonic)</p>
     * 
     * <p>ZDU.8.1 (Print Name)</p>
     * 
     * <p>Disease Code</p>
     * 
     * <p>Provides unambiguous reference to the related coded 
     * observation.</p>
     * 
     * <p>Denotes a specific coded observation made about a person 
     * that might have trigger the clinical issue detection.</p>
     */
    public void setValue(IssueTriggerObservationValue value) {
        this.value.setValue(value);
    }

}
