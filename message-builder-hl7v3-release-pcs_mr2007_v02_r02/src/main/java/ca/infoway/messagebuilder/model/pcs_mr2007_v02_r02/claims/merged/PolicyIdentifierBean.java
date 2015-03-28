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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.CarrierRoleBean;



/**
 * <p>FICR_MT610201CA.PolicyOrAccount: Covering Policy or 
 * Account</p>
 * 
 * <p>Policy or Account of covered party name in invoice.</p>
 * 
 * <p>FICR_MT600201CA.PolicyOrAccount: Policy Identifier</p>
 * 
 * <p>id: = Coverage Identifier, extension = 
 * Policy.Plan.Group.Contract. Division.Section.Version (or 
 * similar). Carrier noted in author participation, and may not 
 * be same namespace as OID of id</p>
 * 
 * <p>Set of identifiers that uniquely identify the policy. 
 * I.e. WCB Number, Auto Number, Certificate Number, combined 
 * identifier (Group+Section+Coverage Number)</p>
 */
@Hl7PartTypeMapping({"FICR_MT600201CA.PolicyOrAccount","FICR_MT610201CA.PolicyOrAccount"})
public class PolicyIdentifierBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private II id = new IIImpl();
    private CD code = new CDImpl();
    private CoveredPartyInformationBean beneficiaryCoveredPartyAsPatient;
    private CarrierRoleBean authorCarrierRole;


    /**
     * <p>Un-merged Business Name: PolicyID</p>
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
     * 
     * <p>Un-merged Business Name: PolicyIdentifierS</p>
     * 
     * <p>Relationship: FICR_MT610201CA.PolicyOrAccount.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>identifier may include a concatenation of group, section, 
     * certificate, etc. to be unique. Methods for specifying the 
     * Extension component of the data type will be expressed in 
     * the NeCST Message Specifications.</p><p>For Worker's 
     * Compensation and Auto Invoices, the policy identifier (WCB 
     * or Auto Claim Number) may not be known when the Invoice is 
     * submitted. In these situations, the Adjudicator may require 
     * name, address and date of accident (for example) in the 
     * Invoice to help determine the WCB or Auto Claim Number 
     * (policy identifier). Most of these adjudicators will keep 
     * this Invoice Grouping pended until the WCB or Auto Claim 
     * Number (policy identifier) is found and may be refused after 
     * a specified time period (e.g. 10 days).</p><p>For Invoice: 
     * In good faith Invoices, the Policy Identifier, Covered Party 
     * Identifier and Policy Holder Identifier is not present, and 
     * therefore this attribute cannot be made mandatory.</p>
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
     * <p>Un-merged Business Name: PolicyID</p>
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
     * 
     * <p>Un-merged Business Name: PolicyIdentifierS</p>
     * 
     * <p>Relationship: FICR_MT610201CA.PolicyOrAccount.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>identifier may include a concatenation of group, section, 
     * certificate, etc. to be unique. Methods for specifying the 
     * Extension component of the data type will be expressed in 
     * the NeCST Message Specifications.</p><p>For Worker's 
     * Compensation and Auto Invoices, the policy identifier (WCB 
     * or Auto Claim Number) may not be known when the Invoice is 
     * submitted. In these situations, the Adjudicator may require 
     * name, address and date of accident (for example) in the 
     * Invoice to help determine the WCB or Auto Claim Number 
     * (policy identifier). Most of these adjudicators will keep 
     * this Invoice Grouping pended until the WCB or Auto Claim 
     * Number (policy identifier) is found and may be refused after 
     * a specified time period (e.g. 10 days).</p><p>For Invoice: 
     * In good faith Invoices, the Policy Identifier, Covered Party 
     * Identifier and Policy Holder Identifier is not present, and 
     * therefore this attribute cannot be made mandatory.</p>
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
     * <p>Business Name: PolicyType</p>
     * 
     * <p>Un-merged Business Name: PolicyType</p>
     * 
     * <p>Relationship: FICR_MT610201CA.PolicyOrAccount.code</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>For Invoice: This information is likely not known or not 
     * required by a Payor. Will be required for HSA policies that 
     * use the same policy identifier as another policy.</p><p>For 
     * Adjudication Results: This could be mandatory to indicate 
     * the type of policy. Must be specified if the EOB references 
     * a policy that was not specified on the Invoice.</p>
     * 
     * <p>For Pre-Determination Results, this could be used to 
     * coordinate Pre-Determinations.</p>
     * 
     * <p>Policy Type - A code that identifies the type of coverage 
     * the policy provides. I.e.. H.S.A.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
    }

    /**
     * <p>Business Name: PolicyType</p>
     * 
     * <p>Un-merged Business Name: PolicyType</p>
     * 
     * <p>Relationship: FICR_MT610201CA.PolicyOrAccount.code</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>For Invoice: This information is likely not known or not 
     * required by a Payor. Will be required for HSA policies that 
     * use the same policy identifier as another policy.</p><p>For 
     * Adjudication Results: This could be mandatory to indicate 
     * the type of policy. Must be specified if the EOB references 
     * a policy that was not specified on the Invoice.</p>
     * 
     * <p>For Pre-Determination Results, this could be used to 
     * coordinate Pre-Determinations.</p>
     * 
     * <p>Policy Type - A code that identifies the type of coverage 
     * the policy provides. I.e.. H.S.A.</p>
     */
    public void setCode(ActCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.PolicyBeneficiary.coveredPartyAsPatient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.PolicyBeneficiary.coveredPartyAsPatient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"beneficiary/coveredPartyAsPatient"})
    public CoveredPartyInformationBean getBeneficiaryCoveredPartyAsPatient() {
        return this.beneficiaryCoveredPartyAsPatient;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.PolicyBeneficiary.coveredPartyAsPatient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.PolicyBeneficiary.coveredPartyAsPatient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setBeneficiaryCoveredPartyAsPatient(CoveredPartyInformationBean beneficiaryCoveredPartyAsPatient) {
        this.beneficiaryCoveredPartyAsPatient = beneficiaryCoveredPartyAsPatient;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.PolicyUnderwriter.carrierRole</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.PolicyUnderwriter.carrierRole</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"author/carrierRole"})
    public CarrierRoleBean getAuthorCarrierRole() {
        return this.authorCarrierRole;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT600201CA.PolicyUnderwriter.carrierRole</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT610201CA.PolicyUnderwriter.carrierRole</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setAuthorCarrierRole(CarrierRoleBean authorCarrierRole) {
        this.authorCarrierRole = authorCarrierRole;
    }

}
