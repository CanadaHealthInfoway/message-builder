/**
 * Copyright 2011 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.ActSubstanceAdminSubstitutionCode;
import ca.infoway.messagebuilder.domainvalue.SubstanceAdminSubstitutionNotAllowedReason;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>AllowedSubstitution</p>
 * 
 * <p>PORX_MT060340CA.SubstitutionPermission: Allowed 
 * Substitution</p>
 * 
 * <p><p>A prescriber's instruction that a specific prescribed 
 * product be dispensed as is, or not.</p></p>
 * 
 * <p><p>May have financial and therapeutic conformance 
 * ramifications for a patient.</p></p>
 * 
 * <p>PORX_MT010120CA.SubstitutionPermission: Allowed 
 * Substitution</p>
 * 
 * <p><p>A prescriber's instruction that a specific prescribed 
 * product be dispensed as is, or not.</p></p>
 * 
 * <p><p>May have financial and therapeutic conformance 
 * ramifications for a patient.</p></p>
 * 
 * <p>PORX_MT060160CA.SubstitutionPermission: Allowed 
 * Substitution</p>
 * 
 * <p><p>A prescriber's instruction that a specific prescribed 
 * product be dispensed as is, or not.</p></p>
 * 
 * <p><p>May have financial and therapeutic conformance 
 * ramifications for a patient.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT010120CA.SubstitutionPermission","PORX_MT060160CA.SubstitutionPermission","PORX_MT060340CA.SubstitutionPermission"})
public class AllowedSubstitutionBean extends MessagePartBean {

    private static final long serialVersionUID = 20120106L;
    private CV code = new CVImpl();
    private BL negationInd = new BLImpl();
    private CV reasonCode = new CVImpl();


    /**
     * <p>Substituion Allowed</p>
     * 
     * <p><p>Provides the ability for a prescriber to indicate the 
     * type of allowed subsitution</p></p>
     * 
     * <p><p>Provides direction to the dispensing provider/ 
     * facility</p></p>
     * 
     * <p>Substitution allowed</p>
     * 
     * <p><p>Provides the ability for a prescriber to indicate the 
     * type of allowed substitution</p></p>
     * 
     * <p><p>Provides direction to the dispensing provider/ 
     * facility</p></p>
     * 
     * <p>Substitution Allowed</p>
     * 
     * <p><p>Provides the ability for a prescriber to indicate the 
     * type of allowed substitution</p></p>
     * 
     * <p><p>Provides direction to the dispensing provider/ 
     * facility</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ActSubstanceAdminSubstitutionCode getCode() {
        return (ActSubstanceAdminSubstitutionCode) this.code.getValue();
    }
    public void setCode(ActSubstanceAdminSubstitutionCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>A:Substitution Not Allowed?</p>
     * 
     * <p><p>If true, indicates that the prescriber has prohibited 
     * substitution. Default is that substitution is allowed.</p></p>
     * 
     * <p><p>Indicates whether substitutions are allowed. The 
     * attribute is mandatory because whether substitution is 
     * allowed must be declared.</p></p>
     * 
     * <p>A:Substitution Not Allowed Indicator</p>
     * 
     * <p><p>If true, indicates that the drug must be dispensed 
     * exactly as prescribed</p></p>
     * 
     * <p><p>Many jurisdictions allow substitution by default and 
     * require prescribers to explicitly declare when they do not 
     * want substitution.</p><p>The attribute is mandatory because 
     * it must be known whether the indicator is true or false.</p></p>
     * 
     * <p><p>Many jurisdictions allow substitution by default and 
     * require prescribers to explicitly declare when they do not 
     * want substitution.</p><p>The attribute is mandatory because 
     * it must be known whether the indicator is true or false.</p></p>
     * 
     * <p>A:Substitution Not Allowed Indicator</p>
     * 
     * <p><p>If true, indicates that the drug must be dispensed 
     * exactly as prescribed</p></p>
     * 
     * <p><p>Many jurisdictions allow substitution by default and 
     * require prescribers to explicitly declare when they do not 
     * want substitution. The element is mandatory because it must 
     * be explicitly true or false.</p></p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }


    /**
     * <p>B:Substitution Not Allowed Reason</p>
     * 
     * <p><p>The reason why the prescriber has indicated that 
     * substitution is not allowed by the dispensing pharmacy.</p></p>
     * 
     * <p><p>Some jurisdictions demand that a prescriber gives a 
     * reason for prohibiting substitution. The field is marked as 
     * 'Populated' because the reason for substitution is important 
     * to understanding the decision. However when a prescription 
     * is being recorded in the pharmacy, the information may not 
     * be available.</p></p>
     * 
     * <p>Not Allowed Reason</p>
     * 
     * <p><p>The reason why the prescriber has indicated that 
     * substitution is not allowed by the dispensing pharmacy.</p></p>
     * 
     * <p><p>Some jurisdictions demand that a prescriber gives a 
     * reason for prohibiting substitution.</p><p>The field is 
     * marked as 'Populated' because the reason for substitution is 
     * important to understanding the decision. However when a 
     * prescription is being recorded in the pharmacy, the 
     * information may not be available.</p></p>
     * 
     * <p><p>Some jurisdictions demand that a prescriber gives a 
     * reason for prohibiting substitution.</p><p>The field is 
     * marked as 'Populated' because the reason for substitution is 
     * important to understanding the decision. However when a 
     * prescription is being recorded in the pharmacy, the 
     * information may not be available.</p></p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public SubstanceAdminSubstitutionNotAllowedReason getReasonCode() {
        return (SubstanceAdminSubstitutionNotAllowedReason) this.reasonCode.getValue();
    }
    public void setReasonCode(SubstanceAdminSubstitutionNotAllowedReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }

}
