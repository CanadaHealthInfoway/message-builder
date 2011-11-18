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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged;

import ca.infoway.messagebuilder.Code;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"FICR_MT490001CA.ParameterList","FICR_MT490002CA.ParameterList"})
@Hl7RootType
public class ParameterList_1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
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
     * <p>CoveredPartyBirthdate</p>
     * 
     * <p>Covered Party Birthdate</p>
     */
    @Hl7XmlMapping({"coveredPartyDOB/value"})
    public Date getCoveredPartyDOBValue() {
        return this.coveredPartyDOBValue.getValue();
    }
    public void setCoveredPartyDOBValue(Date coveredPartyDOBValue) {
        this.coveredPartyDOBValue.setValue(coveredPartyDOBValue);
    }


    /**
     * <p>Covered Party Gender</p>
     * 
     * <p>Gender of covered party</p>
     */
    @Hl7XmlMapping({"coveredPartyGender/value"})
    public AdministrativeGender getCoveredPartyGenderValue() {
        return (AdministrativeGender) this.coveredPartyGenderValue.getValue();
    }
    public void setCoveredPartyGenderValue(AdministrativeGender coveredPartyGenderValue) {
        this.coveredPartyGenderValue.setValue(coveredPartyGenderValue);
    }


    /**
     * <p>Covered Party Name</p>
     * 
     * <p>Covered Party (Patient) Name</p>
     */
    @Hl7XmlMapping({"coveredPartyName/value"})
    public PersonName getCoveredPartyNameValue() {
        return this.coveredPartyNameValue.getValue();
    }
    public void setCoveredPartyNameValue(PersonName coveredPartyNameValue) {
        this.coveredPartyNameValue.setValue(coveredPartyNameValue);
    }


    /**
     * <p>PolicyIdentifier</p>
     * 
     * <p>Policy Identifier</p>
     */
    @Hl7XmlMapping({"policyIdentifier/value"})
    public Identifier getPolicyIdentifierValue() {
        return this.policyIdentifierValue.getValue();
    }
    public void setPolicyIdentifierValue(Identifier policyIdentifierValue) {
        this.policyIdentifierValue.setValue(policyIdentifierValue);
    }


    /**
     * <p>SpecialAuthorizationRequestID</p>
     * 
     * <p>Special Authorization Request ID</p>
     */
    @Hl7XmlMapping({"specialAuthorizationRequestID/value"})
    public Identifier getSpecialAuthorizationRequestIDValue() {
        return this.specialAuthorizationRequestIDValue.getValue();
    }
    public void setSpecialAuthorizationRequestIDValue(Identifier specialAuthorizationRequestIDValue) {
        this.specialAuthorizationRequestIDValue.setValue(specialAuthorizationRequestIDValue);
    }


    /**
     * <p>ApprovedDeviceCode</p>
     * 
     * <p>Approved Device Code</p>
     */
    @Hl7XmlMapping({"approvedDeviceCode/value"})
    public ClinicalDeviceEntity getApprovedDeviceCodeValue() {
        return (ClinicalDeviceEntity) this.approvedDeviceCodeValue.getValue();
    }
    public void setApprovedDeviceCodeValue(ClinicalDeviceEntity approvedDeviceCodeValue) {
        this.approvedDeviceCodeValue.setValue(approvedDeviceCodeValue);
    }


    /**
     * <p>ApprovedDrugCode</p>
     * 
     * <p>Approved Drug Code</p>
     */
    @Hl7XmlMapping({"approvedDrugCode/value"})
    public ClinicalDrug getApprovedDrugCodeValue() {
        return (ClinicalDrug) this.approvedDrugCodeValue.getValue();
    }
    public void setApprovedDrugCodeValue(ClinicalDrug approvedDrugCodeValue) {
        this.approvedDrugCodeValue.setValue(approvedDrugCodeValue);
    }


    /**
     * <p>AuthorID</p>
     * 
     * <p>Author ID</p>
     */
    @Hl7XmlMapping({"authorID/id"})
    public Identifier getAuthorIDId() {
        return this.authorIDId.getValue();
    }
    public void setAuthorIDId(Identifier authorIDId) {
        this.authorIDId.setValue(authorIDId);
    }


    /**
     * <p>AuthorName</p>
     * 
     * <p>Author Name</p>
     */
    @Hl7XmlMapping({"authorName/value"})
    public PersonName getAuthorNameValue() {
        return this.authorNameValue.getValue();
    }
    public void setAuthorNameValue(PersonName authorNameValue) {
        this.authorNameValue.setValue(authorNameValue);
    }


    /**
     * <p>SpecialAuthorizationExpiryDateRange</p>
     * 
     * <p>Special Authorization Expiry Date Range</p>
     */
    @Hl7XmlMapping({"expiryDateRange/value"})
    public Interval<Date> getExpiryDateRangeValue() {
        return this.expiryDateRangeValue.getValue();
    }
    public void setExpiryDateRangeValue(Interval<Date> expiryDateRangeValue) {
        this.expiryDateRangeValue.setValue(expiryDateRangeValue);
    }


    /**
     * <p>RequestedDeviceCode</p>
     * 
     * <p>Requested Device Code</p>
     */
    @Hl7XmlMapping({"requestedDeviceCode/value"})
    public ClinicalDeviceEntity getRequestedDeviceCodeValue() {
        return (ClinicalDeviceEntity) this.requestedDeviceCodeValue.getValue();
    }
    public void setRequestedDeviceCodeValue(ClinicalDeviceEntity requestedDeviceCodeValue) {
        this.requestedDeviceCodeValue.setValue(requestedDeviceCodeValue);
    }


    /**
     * <p>RequestedDrugCode</p>
     * 
     * <p>Requested Drug Code</p>
     */
    @Hl7XmlMapping({"requestedDrugCode/value"})
    public ClinicalDrug getRequestedDrugCodeValue() {
        return (ClinicalDrug) this.requestedDrugCodeValue.getValue();
    }
    public void setRequestedDrugCodeValue(ClinicalDrug requestedDrugCodeValue) {
        this.requestedDrugCodeValue.setValue(requestedDrugCodeValue);
    }


    /**
     * <p>SpecialAuthorizationRequestType</p>
     * 
     * <p>Special Authorization Request Type</p>
     */
    @Hl7XmlMapping({"specialAuthorizationRequestType/value"})
    public Code getSpecialAuthorizationRequestTypeValue() {
        return (Code) this.specialAuthorizationRequestTypeValue.getValue();
    }
    public void setSpecialAuthorizationRequestTypeValue(Code specialAuthorizationRequestTypeValue) {
        this.specialAuthorizationRequestTypeValue.setValue(specialAuthorizationRequestTypeValue);
    }


    /**
     * <p>SpecialAuthorizationStatus</p>
     * 
     * <p>Special Authorization Status</p>
     */
    @Hl7XmlMapping({"specialAuthorizationStatus/value"})
    public List<ActStatus> getSpecialAuthorizationStatusValue() {
        return new RawListWrapper<CV, ActStatus>(specialAuthorizationStatusValue, CVImpl.class);
    }

}
