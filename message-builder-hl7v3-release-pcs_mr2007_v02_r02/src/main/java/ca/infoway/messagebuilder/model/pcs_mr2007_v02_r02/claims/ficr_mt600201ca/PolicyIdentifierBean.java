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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.ficr_mt600201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.merged.CoveredPartyInformationBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.CarrierRoleBean;



/**
 * <p>Business Name: Policy Identifier</p>
 * 
 * <p>id: = Coverage Identifier, extension = 
 * Policy.Plan.Group.Contract. Division.Section.Version (or 
 * similar). Carrier noted in author participation, and may not 
 * be same namespace as OID of id</p>
 */
@Hl7PartTypeMapping({"FICR_MT600201CA.PolicyOrAccount"})
public class PolicyIdentifierBean extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private II id = new IIImpl();
    private CoveredPartyInformationBean beneficiaryCoveredPartyAsPatient;
    private CarrierRoleBean authorCarrierRole;


    /**
     * <p>Business Name: Policy ID</p>
     * 
     * <p>Relationship: FICR_MT600201CA.PolicyOrAccount.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>In some cases, the policy identifier may include a 
     * concatenation of group, section, certificate, etc. to be 
     * unique. Methods for specifying the Extension component of 
     * the data type will be expressed in the NeCST Message 
     * Specifications.</p><p>For Worker's Compensation and Auto 
     * Invoices, the policy identifier (WCB or Auto Claim Number) 
     * may not be known when the Invoice is submitted. In these 
     * situations, the Adjudicator may require name, address and 
     * date of accident (for example) in the Invoice to help 
     * determine the WCB or Auto Claim Number (policy identifier). 
     * Most of these adjudicators will keep this Invoice Grouping 
     * pended until the WCB or Auto Claim Number (policy 
     * identifier) is found and may be refused after a specified 
     * time period (e.g. 10 days).</p><p>For Invoice: In good faith 
     * Invoices, the Policy Identifier, Covered Party Identifier 
     * and Policy Holder Identifier is not present, and therefore 
     * this attribute cannot be made mandatory.</p>
     * 
     * <p>For Invoice, Pre-Determination and Coverage Extension 
     * requests: If this information is not supplied, the 
     * Adjudicator may attempt to determine the information from 
     * other patient information supplied in the message (e.g. 
     * name, date of birth, gender) and would return this 
     * information with the response. If this cannot be obtained in 
     * a real time environment, the message may be rejected, 
     * depending on the Application Role (if Application Role = 
     * Final).</p><p>For Invoice, Pre-Determination and Coverage 
     * Extension results: This information is 
     * mandatory.</p><p>RxS1: This information is mandatory. Scheme 
     * to be confirmed.</p>
     * 
     * <p>Set of identifiers that uniquely identify the policy. 
     * I.e. WCB Number, Auto Number, Certificate Number, combined 
     * identifier (Group+Section+Coverage Number)</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: Policy ID</p>
     * 
     * <p>Relationship: FICR_MT600201CA.PolicyOrAccount.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>In some cases, the policy identifier may include a 
     * concatenation of group, section, certificate, etc. to be 
     * unique. Methods for specifying the Extension component of 
     * the data type will be expressed in the NeCST Message 
     * Specifications.</p><p>For Worker's Compensation and Auto 
     * Invoices, the policy identifier (WCB or Auto Claim Number) 
     * may not be known when the Invoice is submitted. In these 
     * situations, the Adjudicator may require name, address and 
     * date of accident (for example) in the Invoice to help 
     * determine the WCB or Auto Claim Number (policy identifier). 
     * Most of these adjudicators will keep this Invoice Grouping 
     * pended until the WCB or Auto Claim Number (policy 
     * identifier) is found and may be refused after a specified 
     * time period (e.g. 10 days).</p><p>For Invoice: In good faith 
     * Invoices, the Policy Identifier, Covered Party Identifier 
     * and Policy Holder Identifier is not present, and therefore 
     * this attribute cannot be made mandatory.</p>
     * 
     * <p>For Invoice, Pre-Determination and Coverage Extension 
     * requests: If this information is not supplied, the 
     * Adjudicator may attempt to determine the information from 
     * other patient information supplied in the message (e.g. 
     * name, date of birth, gender) and would return this 
     * information with the response. If this cannot be obtained in 
     * a real time environment, the message may be rejected, 
     * depending on the Application Role (if Application Role = 
     * Final).</p><p>For Invoice, Pre-Determination and Coverage 
     * Extension results: This information is 
     * mandatory.</p><p>RxS1: This information is mandatory. Scheme 
     * to be confirmed.</p>
     * 
     * <p>Set of identifiers that uniquely identify the policy. 
     * I.e. WCB Number, Auto Number, Certificate Number, combined 
     * identifier (Group+Section+Coverage Number)</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Relationship: 
     * FICR_MT600201CA.PolicyBeneficiary.coveredPartyAsPatient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"beneficiary/coveredPartyAsPatient"})
    public CoveredPartyInformationBean getBeneficiaryCoveredPartyAsPatient() {
        return this.beneficiaryCoveredPartyAsPatient;
    }

    /**
     * <p>Relationship: 
     * FICR_MT600201CA.PolicyBeneficiary.coveredPartyAsPatient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setBeneficiaryCoveredPartyAsPatient(CoveredPartyInformationBean beneficiaryCoveredPartyAsPatient) {
        this.beneficiaryCoveredPartyAsPatient = beneficiaryCoveredPartyAsPatient;
    }


    /**
     * <p>Relationship: 
     * FICR_MT600201CA.PolicyUnderwriter.carrierRole</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"author/carrierRole"})
    public CarrierRoleBean getAuthorCarrierRole() {
        return this.authorCarrierRole;
    }

    /**
     * <p>Relationship: 
     * FICR_MT600201CA.PolicyUnderwriter.carrierRole</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setAuthorCarrierRole(CarrierRoleBean authorCarrierRole) {
        this.authorCarrierRole = authorCarrierRole;
    }

}
