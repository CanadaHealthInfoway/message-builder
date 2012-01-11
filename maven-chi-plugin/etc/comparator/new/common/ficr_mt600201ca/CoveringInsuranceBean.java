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
package ca.infoway.messagebuilder.model.common.ficr_mt600201ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.util.CollapsedToDataTypeListHelper;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



/**
 * <p>Covering Insurance 
 * 
 * <p>Only 1 policy can be specified for authorizations & 
 * coverage extentionsFor groups, specify all policies (e.g. 
 * WCB claim numbers) with the same coverage.sequenceNumber. 
 * 
 * <p>Refers to multiple policies for an Invoice Grouping. The 
 * Invoice Grouping could refer to a single patient or multiple 
 * patients. For Pharmacy invoices, only supply policies for 
 * the Adjudicator that is the recipient of the Invoice. Other 
 * policies that may be applied against an Invoice Grouping, 
 * that will not be adjudicatd by the Adjudicator, will not be 
 * included with the Invoice. In other words, you would not 
 * disclose policies for which the Adjudicator is not going to 
 * adjudicate against. 
 * 
 * <p>If the Provider is aware of multiple policies that the 
 * Adjudicator adjudicates against, then they may, at their 
 * discretion, indicate both policies in the same Invoice. The 
 * Adjudicator must respond to all policies in the Invoice for 
 * which they adjudicate. This would allow the Adjudicator to 
 * resolve COB priority if multiple policies are noted on the 
 * Invoice. 
 * 
 * <p>Expectation is that Adjudicator must support multiple 
 * policies, but Provider could send 1 Invoice with multiple 
 * policies or send multiple Invoices with 1 policy each. 
 * 
 * <p>This relationship is mandatory for the Root Invoice 
 * Element Group and is not permitted for all other Invoice 
 * Element Groups. 
 */
@Hl7PartTypeMapping({"FICR_MT600201CA.InvoiceElementCoverage"})
public class CoveringInsuranceBean extends MessagePartBean {

    private II policyIdentifierS = new IIImpl();
    private CD<ActCode> policyType = new CDImpl<ActCode>();
    private II carrierID = new IIImpl();
    private II coveredPartyIdentifier = new IIImpl();
    private CV<Code> relationshipToPolicyHolder = new CVImpl<Code>();
    private CoveredPartyAsPatientChoiceBean policyOrAccountBeneficiaryCoveredPartyAsPatientCoveredPartyAsPatientChoice;
    private List<ST> patientKeyword = new ArrayList<ST>();
    private CV<Code> examplesAreSpouseChild = new CVImpl<Code>();

    @Hl7XmlMapping({"policyOrAccount/id"})
    public Identifier getPolicyIdentifierS() {
        return this.policyIdentifierS.getValue();
    }
    public void setPolicyIdentifierS(Identifier policyIdentifierS) {
        this.policyIdentifierS.setValue(policyIdentifierS);
    }

    @Hl7XmlMapping({"policyOrAccount/code"})
    public ActCode getPolicyType() {
        return this.policyType.getValue();
    }
    public void setPolicyType(ActCode policyType) {
        this.policyType.setValue(policyType);
    }

    @Hl7XmlMapping({"policyOrAccount/author/carrierRole/id"})
    public Identifier getCarrierID() {
        return this.carrierID.getValue();
    }
    public void setCarrierID(Identifier carrierID) {
        this.carrierID.setValue(carrierID);
    }

    @Hl7XmlMapping({"policyOrAccount/beneficiary/coveredPartyAsPatient/id"})
    public Identifier getCoveredPartyIdentifier() {
        return this.coveredPartyIdentifier.getValue();
    }
    public void setCoveredPartyIdentifier(Identifier coveredPartyIdentifier) {
        this.coveredPartyIdentifier.setValue(coveredPartyIdentifier);
    }

    @Hl7XmlMapping({"policyOrAccount/beneficiary/coveredPartyAsPatient/code"})
    public Code getRelationshipToPolicyHolder() {
        return this.relationshipToPolicyHolder.getValue();
    }
    public void setRelationshipToPolicyHolder(Code relationshipToPolicyHolder) {
        this.relationshipToPolicyHolder.setValue(relationshipToPolicyHolder);
    }

    @Hl7XmlMapping({"policyOrAccount/beneficiary/coveredPartyAsPatient/coveredPartyAsPatientChoice"})
    public CoveredPartyAsPatientChoiceBean getPolicyOrAccountBeneficiaryCoveredPartyAsPatientCoveredPartyAsPatientChoice() {
        return this.policyOrAccountBeneficiaryCoveredPartyAsPatientCoveredPartyAsPatientChoice;
    }
    public void setPolicyOrAccountBeneficiaryCoveredPartyAsPatientCoveredPartyAsPatientChoice(CoveredPartyAsPatientChoiceBean policyOrAccountBeneficiaryCoveredPartyAsPatientCoveredPartyAsPatientChoice) {
        this.policyOrAccountBeneficiaryCoveredPartyAsPatientCoveredPartyAsPatientChoice = policyOrAccountBeneficiaryCoveredPartyAsPatientCoveredPartyAsPatientChoice;
    }

    @Hl7XmlMapping({"policyOrAccount/beneficiary/coveredPartyAsPatient/subjectOf/signatureText"})
    public List<java.lang.String> getPatientKeyword() {
        return new CollapsedToDataTypeListHelper(STImpl.class, this.patientKeyword).rawList();
    }

    @Hl7XmlMapping({"policyOrAccount/beneficiary/coveredPartyAsPatient/indirectAuthority/personalRelationship/code"})
    public Code getExamplesAreSpouseChild() {
        return this.examplesAreSpouseChild.getValue();
    }
    public void setExamplesAreSpouseChild(Code examplesAreSpouseChild) {
        this.examplesAreSpouseChild.setValue(examplesAreSpouseChild);
    }

}
