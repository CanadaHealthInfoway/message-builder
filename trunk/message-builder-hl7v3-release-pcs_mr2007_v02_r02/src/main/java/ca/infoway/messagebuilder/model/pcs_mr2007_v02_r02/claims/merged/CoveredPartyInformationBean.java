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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.ficr_mt600201ca.CoveredPartyAsPatientChoice;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.ficr_mt600201ca.PatientConsentBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.domainvalue.CoverageRoleType;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.RelatedPersonBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>CoveredPartyInformation</p>
 * 
 * <p>FICR_MT610201CA.CoveredPartyAsPatient: Covered Party 
 * Information</p>
 * 
 * <p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p>
 * 
 * <p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p>
 * 
 * <p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p>
 * 
 * <p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p>
 * 
 * <p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p>
 * 
 * <p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p>
 * 
 * <p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p>
 * 
 * <p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p>
 * 
 * <p>For Adjudication Results: Policy information can be 
 * returned in an EOB in adjudication results to inform a 
 * Provider of new policy information for a policy that was not 
 * submitted in the Invoice by the Provider (to be confirmed 
 * and specified in the NeCST Message Specifications).</p>
 * 
 * <p>For Adjudication Results: Policy information can be 
 * returned in an EOB in adjudication results to inform a 
 * Provider of new policy information for a policy that was not 
 * submitted in the Invoice by the Provider (to be confirmed 
 * and specified in the NeCST Message Specifications).</p>
 * 
 * <p>FICR_MT600201CA.CoveredPartyAsPatient: Covered Party 
 * Information</p>
 * 
 * <p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p>
 * 
 * <p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p>
 * 
 * <p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p>
 * 
 * <p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p>
 * 
 * <p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p>
 * 
 * <p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p>
 * 
 * <p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p>
 * 
 * <p>Covered Person Identifier</p><p>(Assigned by carrier - 
 * root of OID)</p><p>= Subscriber+Dependents</p><p>Can be a 
 * single covered party,</p><p>an organization, an 
 * animal</p><p>or a group of patients</p><p>and/or a group of 
 * animals.</p><p>Covered party may be a patient who for the 
 * purposes of the invoice is a covered party.</p>
 * 
 * <p>For Adjudication Results: Policy information can be 
 * returned in an EOB in adjudication results to inform a 
 * Provider of new policy information for a policy that was not 
 * submitted in the Invoice by the Provider (to be confirmed 
 * and specified in the NeCST Message Specifications).</p>
 */
@Hl7PartTypeMapping({"FICR_MT600201CA.CoveredPartyAsPatient","FICR_MT610201CA.CoveredPartyAsPatient"})
public class CoveredPartyInformationBean extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private RelatedPersonBean indirectAuthorityPersonalRelationship;
    private CoveredPartyAsPatientChoice coveredPartyAsPatientChoice;
    private List<PatientConsentBean> subjectOf = new ArrayList<PatientConsentBean>();


    /**
     * <p>CoveredPartyIdentifier</p>
     * 
     * <p>Covered Party Identifier</p>
     * 
     * <p>The insurance policy identifier of the party covered.</p>
     * 
     * <p>In the absence of a Covered Party identifier, additional 
     * information to identify the individual may be required (e.g. 
     * name, date of birth).</p><p>For Invoice: In good faith 
     * Invoices, the Policy Identifier, Covered Party Identifier 
     * and Policy Holder Identifier is not present, and therefore 
     * this attribute cannot be made mandatory.</p><p>For new borns 
     * &amp; children not registered to date such as adopted 
     * children (i.e. without a covered party identifier), the 
     * parents' policy is specified (in PolicyOrAccount.id). The 
     * new born/child is noted as the covered party.</p>
     * 
     * <p>In the absence of a Covered Party identifier, additional 
     * information to identify the individual may be required (e.g. 
     * name, date of birth).</p><p>For Invoice: In good faith 
     * Invoices, the Policy Identifier, Covered Party Identifier 
     * and Policy Holder Identifier is not present, and therefore 
     * this attribute cannot be made mandatory.</p><p>For new borns 
     * &amp; children not registered to date such as adopted 
     * children (i.e. without a covered party identifier), the 
     * parents' policy is specified (in PolicyOrAccount.id). The 
     * new born/child is noted as the covered party.</p>
     * 
     * <p>In the absence of a Covered Party identifier, additional 
     * information to identify the individual may be required (e.g. 
     * name, date of birth).</p><p>For Invoice: In good faith 
     * Invoices, the Policy Identifier, Covered Party Identifier 
     * and Policy Holder Identifier is not present, and therefore 
     * this attribute cannot be made mandatory.</p><p>For new borns 
     * &amp; children not registered to date such as adopted 
     * children (i.e. without a covered party identifier), the 
     * parents' policy is specified (in PolicyOrAccount.id). The 
     * new born/child is noted as the covered party.</p>
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
     * <p>Covered Party Identifier</p>
     * 
     * <p>The insurance policy identifier of the party covered</p>
     * 
     * <p>In the absence of a Covered Party identifier, additional 
     * information to identify the individual may be required (e.g. 
     * name, date of birth).</p><p>For Invoice: In good faith 
     * Invoices, the Policy Identifier, Covered Party Identifier 
     * and Policy Holder Identifier is not present, and therefore 
     * this attribute cannot be made mandatory.</p><p>For new borns 
     * &amp; children not registered to date such as adopted 
     * children (i.e. without a covered party identifier), the 
     * parents' policy is specified (in PolicyOrAccount.id). The 
     * new born/child is noted as the covered party.</p>
     * 
     * <p>In the absence of a Covered Party identifier, additional 
     * information to identify the individual may be required (e.g. 
     * name, date of birth).</p><p>For Invoice: In good faith 
     * Invoices, the Policy Identifier, Covered Party Identifier 
     * and Policy Holder Identifier is not present, and therefore 
     * this attribute cannot be made mandatory.</p><p>For new borns 
     * &amp; children not registered to date such as adopted 
     * children (i.e. without a covered party identifier), the 
     * parents' policy is specified (in PolicyOrAccount.id). The 
     * new born/child is noted as the covered party.</p>
     * 
     * <p>In the absence of a Covered Party identifier, additional 
     * information to identify the individual may be required (e.g. 
     * name, date of birth).</p><p>For Invoice: In good faith 
     * Invoices, the Policy Identifier, Covered Party Identifier 
     * and Policy Holder Identifier is not present, and therefore 
     * this attribute cannot be made mandatory.</p><p>For new borns 
     * &amp; children not registered to date such as adopted 
     * children (i.e. without a covered party identifier), the 
     * parents' policy is specified (in PolicyOrAccount.id). The 
     * new born/child is noted as the covered party.</p>
     * 
     * <p>Covered Party Identifier- The For Invoice, 
     * Pre-Determination and Coverage Extension requests: If this 
     * information is not supplied, the Adjudicator may attempt to 
     * determine the information from other patient information 
     * supplied in the message (e.g. name, date of birth, gender) 
     * and would return this information with the response. If this 
     * cannot be obtained in a real time environment, the message 
     * may be rejected, depending on the Application Role (if 
     * Application Role = Final).</p><p>For Invoice, 
     * Pre-Determination and Coverage Extension results: This 
     * information is mandatory.</p><p>RxS1: This information is 
     * mandatory. Scheme to be confirmed.</p>
     * 
     * <p>Covered Party Identifier- The For Invoice, 
     * Pre-Determination and Coverage Extension requests: If this 
     * information is not supplied, the Adjudicator may attempt to 
     * determine the information from other patient information 
     * supplied in the message (e.g. name, date of birth, gender) 
     * and would return this information with the response. If this 
     * cannot be obtained in a real time environment, the message 
     * may be rejected, depending on the Application Role (if 
     * Application Role = Final).</p><p>For Invoice, 
     * Pre-Determination and Coverage Extension results: This 
     * information is mandatory.</p><p>RxS1: This information is 
     * mandatory. Scheme to be confirmed.</p>
     * 
     * <p>Covered Party Identifier- The For Invoice, 
     * Pre-Determination and Coverage Extension requests: If this 
     * information is not supplied, the Adjudicator may attempt to 
     * determine the information from other patient information 
     * supplied in the message (e.g. name, date of birth, gender) 
     * and would return this information with the response. If this 
     * cannot be obtained in a real time environment, the message 
     * may be rejected, depending on the Application Role (if 
     * Application Role = Final).</p><p>For Invoice, 
     * Pre-Determination and Coverage Extension results: This 
     * information is mandatory.</p><p>RxS1: This information is 
     * mandatory. Scheme to be confirmed.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>CoveredPartyIdentifier</p>
     * 
     * <p>Covered Party Identifier</p>
     * 
     * <p>The insurance policy identifier of the party covered.</p>
     * 
     * <p>In the absence of a Covered Party identifier, additional 
     * information to identify the individual may be required (e.g. 
     * name, date of birth).</p><p>For Invoice: In good faith 
     * Invoices, the Policy Identifier, Covered Party Identifier 
     * and Policy Holder Identifier is not present, and therefore 
     * this attribute cannot be made mandatory.</p><p>For new borns 
     * &amp; children not registered to date such as adopted 
     * children (i.e. without a covered party identifier), the 
     * parents' policy is specified (in PolicyOrAccount.id). The 
     * new born/child is noted as the covered party.</p>
     * 
     * <p>In the absence of a Covered Party identifier, additional 
     * information to identify the individual may be required (e.g. 
     * name, date of birth).</p><p>For Invoice: In good faith 
     * Invoices, the Policy Identifier, Covered Party Identifier 
     * and Policy Holder Identifier is not present, and therefore 
     * this attribute cannot be made mandatory.</p><p>For new borns 
     * &amp; children not registered to date such as adopted 
     * children (i.e. without a covered party identifier), the 
     * parents' policy is specified (in PolicyOrAccount.id). The 
     * new born/child is noted as the covered party.</p>
     * 
     * <p>In the absence of a Covered Party identifier, additional 
     * information to identify the individual may be required (e.g. 
     * name, date of birth).</p><p>For Invoice: In good faith 
     * Invoices, the Policy Identifier, Covered Party Identifier 
     * and Policy Holder Identifier is not present, and therefore 
     * this attribute cannot be made mandatory.</p><p>For new borns 
     * &amp; children not registered to date such as adopted 
     * children (i.e. without a covered party identifier), the 
     * parents' policy is specified (in PolicyOrAccount.id). The 
     * new born/child is noted as the covered party.</p>
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
     * <p>Covered Party Identifier</p>
     * 
     * <p>The insurance policy identifier of the party covered</p>
     * 
     * <p>In the absence of a Covered Party identifier, additional 
     * information to identify the individual may be required (e.g. 
     * name, date of birth).</p><p>For Invoice: In good faith 
     * Invoices, the Policy Identifier, Covered Party Identifier 
     * and Policy Holder Identifier is not present, and therefore 
     * this attribute cannot be made mandatory.</p><p>For new borns 
     * &amp; children not registered to date such as adopted 
     * children (i.e. without a covered party identifier), the 
     * parents' policy is specified (in PolicyOrAccount.id). The 
     * new born/child is noted as the covered party.</p>
     * 
     * <p>In the absence of a Covered Party identifier, additional 
     * information to identify the individual may be required (e.g. 
     * name, date of birth).</p><p>For Invoice: In good faith 
     * Invoices, the Policy Identifier, Covered Party Identifier 
     * and Policy Holder Identifier is not present, and therefore 
     * this attribute cannot be made mandatory.</p><p>For new borns 
     * &amp; children not registered to date such as adopted 
     * children (i.e. without a covered party identifier), the 
     * parents' policy is specified (in PolicyOrAccount.id). The 
     * new born/child is noted as the covered party.</p>
     * 
     * <p>In the absence of a Covered Party identifier, additional 
     * information to identify the individual may be required (e.g. 
     * name, date of birth).</p><p>For Invoice: In good faith 
     * Invoices, the Policy Identifier, Covered Party Identifier 
     * and Policy Holder Identifier is not present, and therefore 
     * this attribute cannot be made mandatory.</p><p>For new borns 
     * &amp; children not registered to date such as adopted 
     * children (i.e. without a covered party identifier), the 
     * parents' policy is specified (in PolicyOrAccount.id). The 
     * new born/child is noted as the covered party.</p>
     * 
     * <p>Covered Party Identifier- The For Invoice, 
     * Pre-Determination and Coverage Extension requests: If this 
     * information is not supplied, the Adjudicator may attempt to 
     * determine the information from other patient information 
     * supplied in the message (e.g. name, date of birth, gender) 
     * and would return this information with the response. If this 
     * cannot be obtained in a real time environment, the message 
     * may be rejected, depending on the Application Role (if 
     * Application Role = Final).</p><p>For Invoice, 
     * Pre-Determination and Coverage Extension results: This 
     * information is mandatory.</p><p>RxS1: This information is 
     * mandatory. Scheme to be confirmed.</p>
     * 
     * <p>Covered Party Identifier- The For Invoice, 
     * Pre-Determination and Coverage Extension requests: If this 
     * information is not supplied, the Adjudicator may attempt to 
     * determine the information from other patient information 
     * supplied in the message (e.g. name, date of birth, gender) 
     * and would return this information with the response. If this 
     * cannot be obtained in a real time environment, the message 
     * may be rejected, depending on the Application Role (if 
     * Application Role = Final).</p><p>For Invoice, 
     * Pre-Determination and Coverage Extension results: This 
     * information is mandatory.</p><p>RxS1: This information is 
     * mandatory. Scheme to be confirmed.</p>
     * 
     * <p>Covered Party Identifier- The For Invoice, 
     * Pre-Determination and Coverage Extension requests: If this 
     * information is not supplied, the Adjudicator may attempt to 
     * determine the information from other patient information 
     * supplied in the message (e.g. name, date of birth, gender) 
     * and would return this information with the response. If this 
     * cannot be obtained in a real time environment, the message 
     * may be rejected, depending on the Application Role (if 
     * Application Role = Final).</p><p>For Invoice, 
     * Pre-Determination and Coverage Extension results: This 
     * information is mandatory.</p><p>RxS1: This information is 
     * mandatory. Scheme to be confirmed.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Relationship to Policy Holder</p>
     * 
     * <p>Relationship to Policy Holder - The covered party 
     * relationship to the Policy Holder.</p>
     * 
     * <p>For Invoice and Pre-Determination Request &amp; all 
     * Results: Mandatory, otherwise Required.</p>
     * 
     * <p>For Invoice and Pre-Determination Request &amp; all 
     * Results: Mandatory, otherwise Required.</p>
     * 
     * <p>Covered Party Relationship to Policy Holder</p>
     * 
     * <p>The covered party relationship to the Policy Holder.</p>
     * 
     * <p>Reason for being covered, including spouse, child, 
     * students, handicapped</p>
     * 
     * <p>For Invoice and Pre-Determination Request &amp; all 
     * Results: Mandatory, otherwise Required.</p>
     */
    @Hl7XmlMapping({"code"})
    public CoverageRoleType getCode() {
        return (CoverageRoleType) this.code.getValue();
    }

    /**
     * <p>Relationship to Policy Holder</p>
     * 
     * <p>Relationship to Policy Holder - The covered party 
     * relationship to the Policy Holder.</p>
     * 
     * <p>For Invoice and Pre-Determination Request &amp; all 
     * Results: Mandatory, otherwise Required.</p>
     * 
     * <p>For Invoice and Pre-Determination Request &amp; all 
     * Results: Mandatory, otherwise Required.</p>
     * 
     * <p>Covered Party Relationship to Policy Holder</p>
     * 
     * <p>The covered party relationship to the Policy Holder.</p>
     * 
     * <p>Reason for being covered, including spouse, child, 
     * students, handicapped</p>
     * 
     * <p>For Invoice and Pre-Determination Request &amp; all 
     * Results: Mandatory, otherwise Required.</p>
     */
    public void setCode(CoverageRoleType code) {
        this.code.setValue(code);
    }


    @Hl7XmlMapping({"indirectAuthority/personalRelationship"})
    public RelatedPersonBean getIndirectAuthorityPersonalRelationship() {
        return this.indirectAuthorityPersonalRelationship;
    }

    public void setIndirectAuthorityPersonalRelationship(RelatedPersonBean indirectAuthorityPersonalRelationship) {
        this.indirectAuthorityPersonalRelationship = indirectAuthorityPersonalRelationship;
    }


    @Hl7XmlMapping({"coveredPartyAsPatientChoice"})
    public CoveredPartyAsPatientChoice getCoveredPartyAsPatientChoice() {
        return this.coveredPartyAsPatientChoice;
    }

    public void setCoveredPartyAsPatientChoice(CoveredPartyAsPatientChoice coveredPartyAsPatientChoice) {
        this.coveredPartyAsPatientChoice = coveredPartyAsPatientChoice;
    }


    @Hl7XmlMapping({"subjectOf"})
    public List<PatientConsentBean> getSubjectOf() {
        return this.subjectOf;
    }

}
