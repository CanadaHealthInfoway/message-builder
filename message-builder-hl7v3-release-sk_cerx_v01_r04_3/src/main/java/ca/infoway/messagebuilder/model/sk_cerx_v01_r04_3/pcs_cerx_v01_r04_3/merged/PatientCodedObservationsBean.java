/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.IssueTriggerObservationValue;
import ca.infoway.messagebuilder.domainvalue.ObservationIssueTriggerCodedObservationType;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>PatientCodedObservations</p>
 * 
 * <p>PORX_MT980030CA.ObservationCodedEvent: Patient Coded 
 * Observations</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">This is the 
 * recorded observation (e.g. allergy, medical condition, lab 
 * result, pregnancy status, etc.) of the patient that 
 * contributed to the issue being raised.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Useful for 
 * determining appropriate management and for drilling down for 
 * more information.</p></p>
 * 
 * <p>PORX_MT980010CA.ObservationCodedEvent: Patient Coded 
 * Observations</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">This is the 
 * recorded observation (e.g. allergy, medical condition, lab 
 * result, pregnancy status, etc.) of the patient that 
 * contributed to the issue being raised.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Useful for 
 * determining appropriate management and for drilling down for 
 * more information.</p></p>
 * 
 * <p>PORX_MT980020CA.ObservationCodedEvent: Patient Coded 
 * Observations</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">This is the 
 * recorded observation (e.g. allergy, medical condition, lab 
 * result, pregnancy status, etc.) of the patient that 
 * contributed to the issue being raised.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Useful for 
 * determining appropriate management and for drilling down for 
 * more information.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT980010CA.ObservationCodedEvent","PORX_MT980020CA.ObservationCodedEvent","PORX_MT980030CA.ObservationCodedEvent"})
public class PatientCodedObservationsBean extends MessagePartBean implements CausalActs {

    private static final long serialVersionUID = 20110714L;
    private II observationIdentifier = new IIImpl();
    private CD observationType = new CDImpl();
    private CV confidentialityCode = new CVImpl();
    private CV observationValue = new CVImpl();


    /**
     * <p>ObservationIdentifier</p>
     * 
     * <p>A:Observation Identifier</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Unique 
     * identifier for the record of the coded observation (e.g. 
     * allergy, medical condition, pregnancy status, etc.) that 
     * contributed to the issue.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
     * lookup of the specific coded observation (e.g. allergy, 
     * medical condition, pregnancy status, etc) for additional 
     * details when evaluating appropriateness of issue 
     * management.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The attribute is 
     * only marked as 'populated' because it may be masked.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
     * lookup of the specific coded observation (e.g. allergy, 
     * medical condition, pregnancy status, etc) for additional 
     * details when evaluating appropriateness of issue 
     * management.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The attribute is 
     * only marked as 'populated' because it may be masked.</p></p>
     * 
     * <p>A:Observation Identifier</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Unique 
     * identifier for the record of the coded observation (e.g. 
     * allergy, medical condition, pregnancy status, etc.) that 
     * contributed to the issue.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
     * lookup of the specific coded observation (e.g. allergy, 
     * medical condition, pregnancy status, etc.) for additional 
     * details when evaluating appropriateness of issue 
     * management.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The attribute is 
     * marked as populated because it may be masked.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
     * lookup of the specific coded observation (e.g. allergy, 
     * medical condition, pregnancy status, etc.) for additional 
     * details when evaluating appropriateness of issue 
     * management.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The attribute is 
     * marked as populated because it may be masked.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getObservationIdentifier() {
        return this.observationIdentifier.getValue();
    }
    public void setObservationIdentifier(Identifier observationIdentifier) {
        this.observationIdentifier.setValue(observationIdentifier);
    }


    /**
     * <p>ObservationType</p>
     * 
     * <p>B:Observation Type</p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Distinguishes the 
     * kinds of coded observation that could be the trigger for 
     * clinical issue detection. Coded Observation types include: 
     * Allergy, Intolerance, Medical Condition, Indication, 
     * Pregnancy status, Lactation status and other observable 
     * information about a person that may be deemed as a possible 
     * trigger for clinical issue detection.</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Differentiates DAI 
     * from DPD Contraindications</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.100-04 
     * (mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.100-05 (code 
     * system)</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Differentiates DAI 
     * from DPD Contraindications</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.100-04 
     * (mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.100-05 (code 
     * system)</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Differentiates DAI 
     * from DPD Contraindications</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.100-04 
     * (mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.100-05 (code 
     * system)</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the type of recorded observation being referenced. The 
     * attribute is mandatory because it is essential to 
     * interpreting the rest of the information on the class.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ObservationIssueTriggerCodedObservationType getObservationType() {
        return (ObservationIssueTriggerCodedObservationType) this.observationType.getValue();
    }
    public void setObservationType(ObservationIssueTriggerCodedObservationType observationType) {
        this.observationType.setValue(observationType);
    }


    /**
     * <p>D:Observation Masked Indicator</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">An 
     * indication of sensitivity surrounding the implicated 
     * condition, and thus defines the required sensitivity for the 
     * detected issue.</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Contraindication.intractingSourceMasked 
     * (Normal=false; Restricted or Very Restricted = True); 
     * (Information is withheld because the prescription is masked 
     * will be given a NULL flavour of 'Masked')</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Conveys the 
     * patient's wishes relating to the sensitivity of the 
     * observation.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The attribute is 
     * optional because not all systems will support masking.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Conveys the 
     * patient's wishes relating to the sensitivity of the 
     * observation.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The attribute is 
     * optional because not all systems will support masking.</p></p>
     * 
     * <p>D:Observation Masking Indicator</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">An 
     * indication of sensitivity surrounding the related condition, 
     * and thus defines the required sensitivity for the detected 
     * issue.</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Contraindication.intractingSourceMasked 
     * (Normal=false; Restricted or Very Restricted = True); 
     * (Information is withheld because the prescription is masked 
     * will be given a NULL flavour of 'Masked')</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Conveys the 
     * patient's wishes relating to the sensitivity of the 
     * observation information.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The attribute is 
     * optional because not all systems will support masking.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Conveys the 
     * patient's wishes relating to the sensitivity of the 
     * observation information.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The attribute is 
     * optional because not all systems will support masking.</p></p>
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
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Denotes a 
     * specific coded observation made about a person that might 
     * have trigger the clinical issue detection.</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Containdication.allergenGroupName 
     * (PrintName) PIN:Contraindications.drugAllergy (Inferred from 
     * Code System - if it is a DIN it is probably a drug)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Contraindication.indicationDescription</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.7.1 (Code 
     * System)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.7.2 
     * (mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.8.2 (Code 
     * System)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.8.3 
     * (mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.8.1 (Print 
     * Name)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Disease Code</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Containdication.allergenGroupName 
     * (PrintName) PIN:Contraindications.drugAllergy (Inferred from 
     * Code System - if it is a DIN it is probably a drug)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Contraindication.indicationDescription</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.7.1 (Code 
     * System)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.7.2 
     * (mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.8.2 (Code 
     * System)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.8.3 
     * (mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.8.1 (Print 
     * Name)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Disease Code</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Containdication.allergenGroupName 
     * (PrintName) PIN:Contraindications.drugAllergy (Inferred from 
     * Code System - if it is a DIN it is probably a drug)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Contraindication.indicationDescription</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.7.1 (Code 
     * System)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.7.2 
     * (mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.8.2 (Code 
     * System)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.8.3 
     * (mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.8.1 (Print 
     * Name)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Disease Code</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Containdication.allergenGroupName 
     * (PrintName) PIN:Contraindications.drugAllergy (Inferred from 
     * Code System - if it is a DIN it is probably a drug)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Contraindication.indicationDescription</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.7.1 (Code 
     * System)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.7.2 
     * (mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.8.2 (Code 
     * System)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.8.3 
     * (mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.8.1 (Print 
     * Name)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Disease Code</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Containdication.allergenGroupName 
     * (PrintName) PIN:Contraindications.drugAllergy (Inferred from 
     * Code System - if it is a DIN it is probably a drug)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Contraindication.indicationDescription</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.7.1 (Code 
     * System)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.7.2 
     * (mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.8.2 (Code 
     * System)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.8.3 
     * (mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.8.1 (Print 
     * Name)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Disease Code</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Containdication.allergenGroupName 
     * (PrintName) PIN:Contraindications.drugAllergy (Inferred from 
     * Code System - if it is a DIN it is probably a drug)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Contraindication.indicationDescription</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.7.1 (Code 
     * System)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.7.2 
     * (mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.8.2 (Code 
     * System)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.8.3 
     * (mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.8.1 (Print 
     * Name)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Disease Code</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Containdication.allergenGroupName 
     * (PrintName) PIN:Contraindications.drugAllergy (Inferred from 
     * Code System - if it is a DIN it is probably a drug)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Contraindication.indicationDescription</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.7.1 (Code 
     * System)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.7.2 
     * (mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.8.2 (Code 
     * System)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.8.3 
     * (mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.8.1 (Print 
     * Name)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Disease Code</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Containdication.allergenGroupName 
     * (PrintName) PIN:Contraindications.drugAllergy (Inferred from 
     * Code System - if it is a DIN it is probably a drug)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Contraindication.indicationDescription</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.7.1 (Code 
     * System)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.7.2 
     * (mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.8.2 (Code 
     * System)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.8.3 
     * (mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.8.1 (Print 
     * Name)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Disease Code</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Provides 
     * unambiguous reference to the related coded observation.</p></p>
     * 
     * <p>C:Observation Value</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Denotes a 
     * specific coded observation made about a person that might 
     * have trigger the clinical issue detection.</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Containdication.allergenGroupName 
     * (PrintName) PIN:Contraindications.drugAllergy (Inferred from 
     * Code System - if it is a DIN it is probably a drug)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Contraindication.indicationDescription</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.7.1 (Code 
     * System)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.7.2 
     * (mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.8.2 (Code 
     * System)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.8.3 
     * (mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.8.1 (Print 
     * Name)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Disease Code</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Containdication.allergenGroupName 
     * (PrintName) PIN:Contraindications.drugAllergy (Inferred from 
     * Code System - if it is a DIN it is probably a drug)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Contraindication.indicationDescription</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.7.1 (Code 
     * System)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.7.2 
     * (mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.8.2 (Code 
     * System)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.8.3 
     * (mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.8.1 (Print 
     * Name)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Disease Code</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Containdication.allergenGroupName 
     * (PrintName) PIN:Contraindications.drugAllergy (Inferred from 
     * Code System - if it is a DIN it is probably a drug)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Contraindication.indicationDescription</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.7.1 (Code 
     * System)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.7.2 
     * (mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.8.2 (Code 
     * System)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.8.3 
     * (mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.8.1 (Print 
     * Name)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Disease Code</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Containdication.allergenGroupName 
     * (PrintName) PIN:Contraindications.drugAllergy (Inferred from 
     * Code System - if it is a DIN it is p
     * ... [rest of documentation truncated due to excessive length]
     */
    @Hl7XmlMapping({"value"})
    public IssueTriggerObservationValue getObservationValue() {
        return (IssueTriggerObservationValue) this.observationValue.getValue();
    }
    public void setObservationValue(IssueTriggerObservationValue observationValue) {
        this.observationValue.setValue(observationValue);
    }

}
