/**
 * Copyright 2013 Canada Health, Inc.
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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.pharmacy.porx_mt010120ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Serves as reminder for dispenser that the prescription is 
 * not to be trial-filled. In some jurisdictions, the 
 * prescription must be so designated by the prescriber for the 
 * dispenser to do trial dispensing.</p>
 * 
 * <p>Enables the indication of whether the prescription is 
 * ineligible for trial dispensing.</p>
 */
@Hl7PartTypeMapping({"PORX_MT010120CA.Component2"})
public class Component2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private BL negationInd = new BLImpl();


    /**
     * <p>Business Name: G:Not Eligible for Trial?</p>
     * 
     * <p>Relationship: PORX_MT010120CA.Component2.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>May affect dispensers' discretion to dispense anything 
     * other than prescribed fill quantity.</p><p>Expressed as 
     * 'Non-Eligibility' rather than 'Eligibility' due to 
     * restrictions in HL7 modeling.</p><p>The element is mandatory 
     * because it must always be known whether the element is true 
     * or false.</p>
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
     * <p>Business Name: G:Not Eligible for Trial?</p>
     * 
     * <p>Relationship: PORX_MT010120CA.Component2.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>May affect dispensers' discretion to dispense anything 
     * other than prescribed fill quantity.</p><p>Expressed as 
     * 'Non-Eligibility' rather than 'Eligibility' due to 
     * restrictions in HL7 modeling.</p><p>The element is mandatory 
     * because it must always be known whether the element is true 
     * or false.</p>
     * 
     * <p>An indication that a prescription is or is not eligible 
     * for trial dispensing from a clinical (not financial) 
     * perspective. False = Eligible, True = Not Eligible.</p>
     */
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }

}
