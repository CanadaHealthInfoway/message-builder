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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: NotEligibleForTrial</p>
 * 
 * <p>PORX_MT060160CA.Component2: G:Not eligible for Trial?</p>
 * 
 * <p>Serves as reminder for dispenser to consider option of 
 * part-filling. In some jurisdictions, the prescription must 
 * be so designated by the prescriber for the dispenser to do 
 * trial dispensing.</p><p>The element is mandatory because 
 * eligibility must be either true or false.</p>
 * 
 * <p>Indicates that a prescription is part of a Trial 
 * Program.</p>
 * 
 * <p>PORX_MT060340CA.Component2: G:not eligible for Trial?</p>
 * 
 * <p>Serves as reminder for dispenser to consider option of 
 * part-filling. In some jurisdictions, the prescription must 
 * be so designated by the prescriber for the dispenser to do 
 * trial dispensing.</p>
 * 
 * <p>Indicates that a prescription is part of a Trial 
 * Program.</p>
 */
@Hl7PartTypeMapping({"PORX_MT060160CA.Component2","PORX_MT060340CA.Component2"})
public class NotEligibleForTrialBean extends MessagePartBean {

    private static final long serialVersionUID = 20190730L;
    private BL negationInd = new BLImpl();


    /**
     * <p>Business Name: NotEligibleForTrial</p>
     * 
     * <p>Un-merged Business Name: NotEligibleForTrial</p>
     * 
     * <p>Relationship: PORX_MT060160CA.Component2.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>May affect dispensers' discretion to dispense anything 
     * other than prescribed fill quantity.</p><p>Expressed as 
     * 'Non-Eligibility' rather than 'Eligibility' due to 
     * restrictions in HL7 modeling.</p><p>The attribute is 
     * mandatory as it must be known whether it is true or 
     * false.</p>
     * 
     * <p>An indication that a prescription is or is not eligible 
     * for trial dispensing from a clinical (not financial) 
     * perspective. False = Eligible, True = Not Eligible.</p>
     * 
     * <p>Un-merged Business Name: NotEligibleForTrial</p>
     * 
     * <p>Relationship: PORX_MT060340CA.Component2.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>May affect dispensers' discretion to dispense anything 
     * other than prescribed fill quantity.</p><p>Expressed as 
     * 'Non-Eligibility' rather than 'Eligibility' due to 
     * restrictions in HL7 modeling.</p><p>The attribute is 
     * mandatory because it must be known whether trials are 
     * allowed or not.</p>
     * 
     * <p>An indication that a prescription is or is not eligible 
     * for trial dispensing from a clinical (not financial) 
     * perspective. False = Eligible, True = Not Eligible.</p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }

    /**
     * <p>Business Name: NotEligibleForTrial</p>
     * 
     * <p>Un-merged Business Name: NotEligibleForTrial</p>
     * 
     * <p>Relationship: PORX_MT060160CA.Component2.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>May affect dispensers' discretion to dispense anything 
     * other than prescribed fill quantity.</p><p>Expressed as 
     * 'Non-Eligibility' rather than 'Eligibility' due to 
     * restrictions in HL7 modeling.</p><p>The attribute is 
     * mandatory as it must be known whether it is true or 
     * false.</p>
     * 
     * <p>An indication that a prescription is or is not eligible 
     * for trial dispensing from a clinical (not financial) 
     * perspective. False = Eligible, True = Not Eligible.</p>
     * 
     * <p>Un-merged Business Name: NotEligibleForTrial</p>
     * 
     * <p>Relationship: PORX_MT060340CA.Component2.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>May affect dispensers' discretion to dispense anything 
     * other than prescribed fill quantity.</p><p>Expressed as 
     * 'Non-Eligibility' rather than 'Eligibility' due to 
     * restrictions in HL7 modeling.</p><p>The attribute is 
     * mandatory because it must be known whether trials are 
     * allowed or not.</p>
     * 
     * <p>An indication that a prescription is or is not eligible 
     * for trial dispensing from a clinical (not financial) 
     * perspective. False = Eligible, True = Not Eligible.</p>
     */
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }

}
