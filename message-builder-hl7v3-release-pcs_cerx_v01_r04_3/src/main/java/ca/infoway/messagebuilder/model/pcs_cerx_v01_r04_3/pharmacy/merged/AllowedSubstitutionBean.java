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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.SubstanceAdminSubstitutionNotAllowedReason;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: AllowedSubstitution</p>
 * 
 * <p>PORX_MT060340CA.SubstitutionPermission: Allowed 
 * Substitution</p>
 * 
 * <p>A_BillablePharmacyDispense</p>
 * 
 * <p>May have financial and therapeutic conformance 
 * ramifications for a patient.</p>
 * 
 * <p>A prescriber's instruction that a specific prescribed 
 * product be dispensed as is, or not.</p>
 * 
 * <p>PORX_MT010120CA.SubstitutionPermission: Allowed 
 * Substitution</p>
 * 
 * <p>A_BillablePharmacyDispense</p>
 * 
 * <p>May have financial and therapeutic conformance 
 * ramifications for a patient.</p>
 * 
 * <p>A prescriber's instruction that a specific prescribed 
 * product be dispensed as is, or not.</p>
 * 
 * <p>PORX_MT060160CA.SubstitutionPermission: Allowed 
 * Substitution</p>
 * 
 * <p>A_BillablePharmacyDispense</p>
 * 
 * <p>May have financial and therapeutic conformance 
 * ramifications for a patient.</p>
 * 
 * <p>A prescriber's instruction that a specific prescribed 
 * product be dispensed as is, or not.</p>
 */
@Hl7PartTypeMapping({"PORX_MT010120CA.SubstitutionPermission","PORX_MT060160CA.SubstitutionPermission","PORX_MT060340CA.SubstitutionPermission"})
public class AllowedSubstitutionBean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private BL negationInd = new BLImpl();
    private CV reasonCode = new CVImpl();


    /**
     * <p>Un-merged Business Name: SubstitutionNotAllowedIndicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.SubstitutionPermission.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Many jurisdictions allow substitution by default and 
     * require prescribers to explicitly declare when they do not 
     * want substitution.</p><p>The attribute is mandatory because 
     * it must be known whether the indicator is true or false.</p>
     * 
     * <p>If true, indicates that the drug must be dispensed 
     * exactly as prescribed</p>
     * 
     * <p>Un-merged Business Name: SubstitutionNotAllowed</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.SubstitutionPermission.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Prescription.substitutionAllowed</p>
     * 
     * <p>Indicates whether substitutions are allowed. The 
     * attribute is mandatory because whether substitution is 
     * allowed must be declared.</p>
     * 
     * <p>If true, indicates that the prescriber has prohibited 
     * substitution. Default is that substitution is allowed.</p>
     * 
     * <p>Un-merged Business Name: SubstitutionNotAllowedIndicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.SubstitutionPermission.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Many jurisdictions allow substitution by default and 
     * require prescribers to explicitly declare when they do not 
     * want substitution. The element is mandatory because it must 
     * be explicitly true or false.</p>
     * 
     * <p>If true, indicates that the drug must be dispensed 
     * exactly as prescribed</p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }

    /**
     * <p>Un-merged Business Name: SubstitutionNotAllowedIndicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.SubstitutionPermission.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Many jurisdictions allow substitution by default and 
     * require prescribers to explicitly declare when they do not 
     * want substitution.</p><p>The attribute is mandatory because 
     * it must be known whether the indicator is true or false.</p>
     * 
     * <p>If true, indicates that the drug must be dispensed 
     * exactly as prescribed</p>
     * 
     * <p>Un-merged Business Name: SubstitutionNotAllowed</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.SubstitutionPermission.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Prescription.substitutionAllowed</p>
     * 
     * <p>Indicates whether substitutions are allowed. The 
     * attribute is mandatory because whether substitution is 
     * allowed must be declared.</p>
     * 
     * <p>If true, indicates that the prescriber has prohibited 
     * substitution. Default is that substitution is allowed.</p>
     * 
     * <p>Un-merged Business Name: SubstitutionNotAllowedIndicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.SubstitutionPermission.negationInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Many jurisdictions allow substitution by default and 
     * require prescribers to explicitly declare when they do not 
     * want substitution. The element is mandatory because it must 
     * be explicitly true or false.</p>
     * 
     * <p>If true, indicates that the drug must be dispensed 
     * exactly as prescribed</p>
     */
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }


    /**
     * <p>Un-merged Business Name: NotAllowedReason</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.SubstitutionPermission.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Some jurisdictions demand that a prescriber gives a 
     * reason for prohibiting substitution.</p><p>The field is 
     * marked as 'Populated' because the reason for substitution is 
     * important to understanding the decision. However when a 
     * prescription is being recorded in the pharmacy, the 
     * information may not be available.</p>
     * 
     * <p>The reason why the prescriber has indicated that 
     * substitution is not allowed by the dispensing pharmacy.</p>
     * 
     * <p>Un-merged Business Name: SubstitutionNotAllowedReason</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.SubstitutionPermission.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Some jurisdictions demand that a prescriber gives a 
     * reason for prohibiting substitution. The field is marked as 
     * 'Populated' because the reason for substitution is important 
     * to understanding the decision. However when a prescription 
     * is being recorded in the pharmacy, the information may not 
     * be available.</p>
     * 
     * <p>The reason why the prescriber has indicated that 
     * substitution is not allowed by the dispensing pharmacy.</p>
     * 
     * <p>Un-merged Business Name: NotAllowedReason</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.SubstitutionPermission.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Some jurisdictions demand that a prescriber gives a 
     * reason for prohibiting substitution.</p><p>The field is 
     * marked as 'Populated' because the reason for substitution is 
     * important to understanding the decision. However when a 
     * prescription is being recorded in the pharmacy, the 
     * information may not be available.</p>
     * 
     * <p>The reason why the prescriber has indicated that 
     * substitution is not allowed by the dispensing pharmacy.</p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public SubstanceAdminSubstitutionNotAllowedReason getReasonCode() {
        return (SubstanceAdminSubstitutionNotAllowedReason) this.reasonCode.getValue();
    }

    /**
     * <p>Un-merged Business Name: NotAllowedReason</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.SubstitutionPermission.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Some jurisdictions demand that a prescriber gives a 
     * reason for prohibiting substitution.</p><p>The field is 
     * marked as 'Populated' because the reason for substitution is 
     * important to understanding the decision. However when a 
     * prescription is being recorded in the pharmacy, the 
     * information may not be available.</p>
     * 
     * <p>The reason why the prescriber has indicated that 
     * substitution is not allowed by the dispensing pharmacy.</p>
     * 
     * <p>Un-merged Business Name: SubstitutionNotAllowedReason</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.SubstitutionPermission.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Some jurisdictions demand that a prescriber gives a 
     * reason for prohibiting substitution. The field is marked as 
     * 'Populated' because the reason for substitution is important 
     * to understanding the decision. However when a prescription 
     * is being recorded in the pharmacy, the information may not 
     * be available.</p>
     * 
     * <p>The reason why the prescriber has indicated that 
     * substitution is not allowed by the dispensing pharmacy.</p>
     * 
     * <p>Un-merged Business Name: NotAllowedReason</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.SubstitutionPermission.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Some jurisdictions demand that a prescriber gives a 
     * reason for prohibiting substitution.</p><p>The field is 
     * marked as 'Populated' because the reason for substitution is 
     * important to understanding the decision. However when a 
     * prescription is being recorded in the pharmacy, the 
     * information may not be available.</p>
     * 
     * <p>The reason why the prescriber has indicated that 
     * substitution is not allowed by the dispensing pharmacy.</p>
     */
    public void setReasonCode(SubstanceAdminSubstitutionNotAllowedReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }

}
