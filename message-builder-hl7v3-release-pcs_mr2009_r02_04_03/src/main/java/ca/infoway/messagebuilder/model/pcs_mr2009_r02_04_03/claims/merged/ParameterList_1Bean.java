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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.ClinicalDeviceEntity;
import ca.infoway.messagebuilder.domainvalue.ClinicalDrug;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.domainvalue.ActSpecialAuthorizationCode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"FICR_MT490001CA.ParameterList","FICR_MT490002CA.ParameterList"})
@Hl7RootType
public class ParameterList_1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20130103L;
    private TS coveredPartyDOBValue = new TSImpl();
    private CV coveredPartyGenderValue = new CVImpl();
    private PN coveredPartyNameValue = new PNImpl();
    private II policyIdentifierValue = new IIImpl();
    private II specialAuthorizationRequestIDValue = new IIImpl();
    private CV approvedDeviceCodeValue = new CVImpl();
    private CV approvedDrugCodeValue = new CVImpl();
    private II authorIDId = new IIImpl();
    private PN authorNameValue = new PNImpl();
    private IVL<TS, Interval<Date>> expiryDateRangeValue = new IVLImpl<TS, Interval<Date>>();
    private CV requestedDeviceCodeValue = new CVImpl();
    private CV requestedDrugCodeValue = new CVImpl();
    private CV specialAuthorizationRequestTypeValue = new CVImpl();
    private List<CV> specialAuthorizationStatusValue = new ArrayList<CV>();


    /**
     * <p>Business Name: CoveredPartyBirthdate</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyBirthdate</p>
     * 
     * <p>Relationship: FICR_MT490002CA.CoveredPartyDOB.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyBirthdate</p>
     * 
     * <p>Relationship: FICR_MT490001CA.CoveredPartyDOB.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"coveredPartyDOB/value"})
    public Date getCoveredPartyDOBValue() {
        return this.coveredPartyDOBValue.getValue();
    }

    /**
     * <p>Business Name: CoveredPartyBirthdate</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyBirthdate</p>
     * 
     * <p>Relationship: FICR_MT490002CA.CoveredPartyDOB.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyBirthdate</p>
     * 
     * <p>Relationship: FICR_MT490001CA.CoveredPartyDOB.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCoveredPartyDOBValue(Date coveredPartyDOBValue) {
        this.coveredPartyDOBValue.setValue(coveredPartyDOBValue);
    }


    /**
     * <p>Un-merged Business Name: GenderOfCoveredParty</p>
     * 
     * <p>Relationship: FICR_MT490002CA.CoveredPartyGender.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyGender</p>
     * 
     * <p>Relationship: FICR_MT490001CA.CoveredPartyGender.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"coveredPartyGender/value"})
    public AdministrativeGender getCoveredPartyGenderValue() {
        return (AdministrativeGender) this.coveredPartyGenderValue.getValue();
    }

    /**
     * <p>Un-merged Business Name: GenderOfCoveredParty</p>
     * 
     * <p>Relationship: FICR_MT490002CA.CoveredPartyGender.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyGender</p>
     * 
     * <p>Relationship: FICR_MT490001CA.CoveredPartyGender.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCoveredPartyGenderValue(AdministrativeGender coveredPartyGenderValue) {
        this.coveredPartyGenderValue.setValue(coveredPartyGenderValue);
    }


    /**
     * <p>Un-merged Business Name: CoveredPartyName</p>
     * 
     * <p>Relationship: FICR_MT490002CA.CoveredPartyName.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyPatientName</p>
     * 
     * <p>Relationship: FICR_MT490001CA.CoveredPartyName.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"coveredPartyName/value"})
    public PersonName getCoveredPartyNameValue() {
        return this.coveredPartyNameValue.getValue();
    }

    /**
     * <p>Un-merged Business Name: CoveredPartyName</p>
     * 
     * <p>Relationship: FICR_MT490002CA.CoveredPartyName.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: CoveredPartyPatientName</p>
     * 
     * <p>Relationship: FICR_MT490001CA.CoveredPartyName.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCoveredPartyNameValue(PersonName coveredPartyNameValue) {
        this.coveredPartyNameValue.setValue(coveredPartyNameValue);
    }


    /**
     * <p>Business Name: PolicyIdentifier</p>
     * 
     * <p>Un-merged Business Name: PolicyIdentifier</p>
     * 
     * <p>Relationship: FICR_MT490002CA.PolicyIdentifier.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: PolicyIdentifier</p>
     * 
     * <p>Relationship: FICR_MT490001CA.PolicyIdentifier.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"policyIdentifier/value"})
    public Identifier getPolicyIdentifierValue() {
        return this.policyIdentifierValue.getValue();
    }

    /**
     * <p>Business Name: PolicyIdentifier</p>
     * 
     * <p>Un-merged Business Name: PolicyIdentifier</p>
     * 
     * <p>Relationship: FICR_MT490002CA.PolicyIdentifier.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: PolicyIdentifier</p>
     * 
     * <p>Relationship: FICR_MT490001CA.PolicyIdentifier.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setPolicyIdentifierValue(Identifier policyIdentifierValue) {
        this.policyIdentifierValue.setValue(policyIdentifierValue);
    }


    /**
     * <p>Business Name: SpecialAuthorizationRequestID</p>
     * 
     * <p>Un-merged Business Name: SpecialAuthorizationRequestID</p>
     * 
     * <p>Relationship: 
     * FICR_MT490002CA.SpecialAuthorizationRequestID.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"specialAuthorizationRequestID/value"})
    public Identifier getSpecialAuthorizationRequestIDValue() {
        return this.specialAuthorizationRequestIDValue.getValue();
    }

    /**
     * <p>Business Name: SpecialAuthorizationRequestID</p>
     * 
     * <p>Un-merged Business Name: SpecialAuthorizationRequestID</p>
     * 
     * <p>Relationship: 
     * FICR_MT490002CA.SpecialAuthorizationRequestID.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSpecialAuthorizationRequestIDValue(Identifier specialAuthorizationRequestIDValue) {
        this.specialAuthorizationRequestIDValue.setValue(specialAuthorizationRequestIDValue);
    }


    /**
     * <p>Business Name: ApprovedDeviceCode</p>
     * 
     * <p>Un-merged Business Name: ApprovedDeviceCode</p>
     * 
     * <p>Relationship: FICR_MT490001CA.ApprovedDeviceCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"approvedDeviceCode/value"})
    public ClinicalDeviceEntity getApprovedDeviceCodeValue() {
        return (ClinicalDeviceEntity) this.approvedDeviceCodeValue.getValue();
    }

    /**
     * <p>Business Name: ApprovedDeviceCode</p>
     * 
     * <p>Un-merged Business Name: ApprovedDeviceCode</p>
     * 
     * <p>Relationship: FICR_MT490001CA.ApprovedDeviceCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setApprovedDeviceCodeValue(ClinicalDeviceEntity approvedDeviceCodeValue) {
        this.approvedDeviceCodeValue.setValue(approvedDeviceCodeValue);
    }


    /**
     * <p>Business Name: ApprovedDrugCode</p>
     * 
     * <p>Un-merged Business Name: ApprovedDrugCode</p>
     * 
     * <p>Relationship: FICR_MT490001CA.ApprovedDrugCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"approvedDrugCode/value"})
    public ClinicalDrug getApprovedDrugCodeValue() {
        return (ClinicalDrug) this.approvedDrugCodeValue.getValue();
    }

    /**
     * <p>Business Name: ApprovedDrugCode</p>
     * 
     * <p>Un-merged Business Name: ApprovedDrugCode</p>
     * 
     * <p>Relationship: FICR_MT490001CA.ApprovedDrugCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setApprovedDrugCodeValue(ClinicalDrug approvedDrugCodeValue) {
        this.approvedDrugCodeValue.setValue(approvedDrugCodeValue);
    }


    /**
     * <p>Business Name: AuthorID</p>
     * 
     * <p>Un-merged Business Name: AuthorID</p>
     * 
     * <p>Relationship: FICR_MT490001CA.AuthorID.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"authorID/id"})
    public Identifier getAuthorIDId() {
        return this.authorIDId.getValue();
    }

    /**
     * <p>Business Name: AuthorID</p>
     * 
     * <p>Un-merged Business Name: AuthorID</p>
     * 
     * <p>Relationship: FICR_MT490001CA.AuthorID.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthorIDId(Identifier authorIDId) {
        this.authorIDId.setValue(authorIDId);
    }


    /**
     * <p>Business Name: AuthorName</p>
     * 
     * <p>Un-merged Business Name: AuthorName</p>
     * 
     * <p>Relationship: FICR_MT490001CA.AuthorName.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"authorName/value"})
    public PersonName getAuthorNameValue() {
        return this.authorNameValue.getValue();
    }

    /**
     * <p>Business Name: AuthorName</p>
     * 
     * <p>Un-merged Business Name: AuthorName</p>
     * 
     * <p>Relationship: FICR_MT490001CA.AuthorName.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthorNameValue(PersonName authorNameValue) {
        this.authorNameValue.setValue(authorNameValue);
    }


    /**
     * <p>Business Name: SpecialAuthorizationExpiryDateRange</p>
     * 
     * <p>Un-merged Business Name: 
     * SpecialAuthorizationExpiryDateRange</p>
     * 
     * <p>Relationship: FICR_MT490001CA.ExpiryDateRange.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"expiryDateRange/value"})
    public Interval<Date> getExpiryDateRangeValue() {
        return this.expiryDateRangeValue.getValue();
    }

    /**
     * <p>Business Name: SpecialAuthorizationExpiryDateRange</p>
     * 
     * <p>Un-merged Business Name: 
     * SpecialAuthorizationExpiryDateRange</p>
     * 
     * <p>Relationship: FICR_MT490001CA.ExpiryDateRange.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setExpiryDateRangeValue(Interval<Date> expiryDateRangeValue) {
        this.expiryDateRangeValue.setValue(expiryDateRangeValue);
    }


    /**
     * <p>Business Name: RequestedDeviceCode</p>
     * 
     * <p>Un-merged Business Name: RequestedDeviceCode</p>
     * 
     * <p>Relationship: FICR_MT490001CA.RequestedDeviceCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"requestedDeviceCode/value"})
    public ClinicalDeviceEntity getRequestedDeviceCodeValue() {
        return (ClinicalDeviceEntity) this.requestedDeviceCodeValue.getValue();
    }

    /**
     * <p>Business Name: RequestedDeviceCode</p>
     * 
     * <p>Un-merged Business Name: RequestedDeviceCode</p>
     * 
     * <p>Relationship: FICR_MT490001CA.RequestedDeviceCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setRequestedDeviceCodeValue(ClinicalDeviceEntity requestedDeviceCodeValue) {
        this.requestedDeviceCodeValue.setValue(requestedDeviceCodeValue);
    }


    /**
     * <p>Business Name: RequestedDrugCode</p>
     * 
     * <p>Un-merged Business Name: RequestedDrugCode</p>
     * 
     * <p>Relationship: FICR_MT490001CA.RequestedDrugCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"requestedDrugCode/value"})
    public ClinicalDrug getRequestedDrugCodeValue() {
        return (ClinicalDrug) this.requestedDrugCodeValue.getValue();
    }

    /**
     * <p>Business Name: RequestedDrugCode</p>
     * 
     * <p>Un-merged Business Name: RequestedDrugCode</p>
     * 
     * <p>Relationship: FICR_MT490001CA.RequestedDrugCode.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setRequestedDrugCodeValue(ClinicalDrug requestedDrugCodeValue) {
        this.requestedDrugCodeValue.setValue(requestedDrugCodeValue);
    }


    /**
     * <p>Business Name: SpecialAuthorizationRequestType</p>
     * 
     * <p>Un-merged Business Name: SpecialAuthorizationRequestType</p>
     * 
     * <p>Relationship: 
     * FICR_MT490001CA.SpecialAuthorizationRequestType.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"specialAuthorizationRequestType/value"})
    public ActSpecialAuthorizationCode getSpecialAuthorizationRequestTypeValue() {
        return (ActSpecialAuthorizationCode) this.specialAuthorizationRequestTypeValue.getValue();
    }

    /**
     * <p>Business Name: SpecialAuthorizationRequestType</p>
     * 
     * <p>Un-merged Business Name: SpecialAuthorizationRequestType</p>
     * 
     * <p>Relationship: 
     * FICR_MT490001CA.SpecialAuthorizationRequestType.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSpecialAuthorizationRequestTypeValue(ActSpecialAuthorizationCode specialAuthorizationRequestTypeValue) {
        this.specialAuthorizationRequestTypeValue.setValue(specialAuthorizationRequestTypeValue);
    }


    /**
     * <p>Business Name: SpecialAuthorizationStatus</p>
     * 
     * <p>Un-merged Business Name: SpecialAuthorizationStatus</p>
     * 
     * <p>Relationship: 
     * FICR_MT490001CA.SpecialAuthorizationStatus.value</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"specialAuthorizationStatus/value"})
    public List<ActStatus> getSpecialAuthorizationStatusValue() {
        return new RawListWrapper<CV, ActStatus>(specialAuthorizationStatusValue, CVImpl.class);
    }

}
