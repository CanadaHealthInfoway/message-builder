/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.claims.merged;

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

    private static final long serialVersionUID = 20110407L;
    private TS coveredPartyBirthdate = new TSImpl();
    private CV coveredPartyGenderValue = new CVImpl();
    private PN coveredPartyNameValue = new PNImpl();
    private II policyIdentifier = new IIImpl();
    private II specialAuthorizationRequestID = new IIImpl();
    private CV approvedDeviceCode = new CVImpl();
    private CV approvedDrugCode = new CVImpl();
    private II authorID = new IIImpl();
    private PN authorName = new PNImpl();
    private IVL<TS, Interval<Date>> specialAuthorizationExpiryDateRange = new IVLImpl<TS, Interval<Date>>();
    private CV requestedDeviceCode = new CVImpl();
    private CV requestedDrugCode = new CVImpl();
    private CV specialAuthorizationRequestType = new CVImpl();
    private List<CV> specialAuthorizationStatus = new ArrayList<CV>();


    /**
     * <p>CoveredPartyBirthdate</p>
     * 
     * <p>Covered Party Birthdate</p>
     */
    @Hl7XmlMapping({"coveredPartyDOB/value"})
    public Date getCoveredPartyBirthdate() {
        return this.coveredPartyBirthdate.getValue();
    }
    public void setCoveredPartyBirthdate(Date coveredPartyBirthdate) {
        this.coveredPartyBirthdate.setValue(coveredPartyBirthdate);
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
    public Identifier getPolicyIdentifier() {
        return this.policyIdentifier.getValue();
    }
    public void setPolicyIdentifier(Identifier policyIdentifier) {
        this.policyIdentifier.setValue(policyIdentifier);
    }


    /**
     * <p>SpecialAuthorizationRequestID</p>
     * 
     * <p>Special Authorization Request ID</p>
     */
    @Hl7XmlMapping({"specialAuthorizationRequestID/value"})
    public Identifier getSpecialAuthorizationRequestID() {
        return this.specialAuthorizationRequestID.getValue();
    }
    public void setSpecialAuthorizationRequestID(Identifier specialAuthorizationRequestID) {
        this.specialAuthorizationRequestID.setValue(specialAuthorizationRequestID);
    }


    /**
     * <p>ApprovedDeviceCode</p>
     * 
     * <p>Approved Device Code</p>
     */
    @Hl7XmlMapping({"approvedDeviceCode/value"})
    public ClinicalDeviceEntity getApprovedDeviceCode() {
        return (ClinicalDeviceEntity) this.approvedDeviceCode.getValue();
    }
    public void setApprovedDeviceCode(ClinicalDeviceEntity approvedDeviceCode) {
        this.approvedDeviceCode.setValue(approvedDeviceCode);
    }


    /**
     * <p>ApprovedDrugCode</p>
     * 
     * <p>Approved Drug Code</p>
     */
    @Hl7XmlMapping({"approvedDrugCode/value"})
    public ClinicalDrug getApprovedDrugCode() {
        return (ClinicalDrug) this.approvedDrugCode.getValue();
    }
    public void setApprovedDrugCode(ClinicalDrug approvedDrugCode) {
        this.approvedDrugCode.setValue(approvedDrugCode);
    }


    /**
     * <p>AuthorID</p>
     * 
     * <p>Author ID</p>
     */
    @Hl7XmlMapping({"authorID/id"})
    public Identifier getAuthorID() {
        return this.authorID.getValue();
    }
    public void setAuthorID(Identifier authorID) {
        this.authorID.setValue(authorID);
    }


    /**
     * <p>AuthorName</p>
     * 
     * <p>Author Name</p>
     */
    @Hl7XmlMapping({"authorName/value"})
    public PersonName getAuthorName() {
        return this.authorName.getValue();
    }
    public void setAuthorName(PersonName authorName) {
        this.authorName.setValue(authorName);
    }


    /**
     * <p>SpecialAuthorizationExpiryDateRange</p>
     * 
     * <p>Special Authorization Expiry Date Range</p>
     */
    @Hl7XmlMapping({"expiryDateRange/value"})
    public Interval<Date> getSpecialAuthorizationExpiryDateRange() {
        return this.specialAuthorizationExpiryDateRange.getValue();
    }
    public void setSpecialAuthorizationExpiryDateRange(Interval<Date> specialAuthorizationExpiryDateRange) {
        this.specialAuthorizationExpiryDateRange.setValue(specialAuthorizationExpiryDateRange);
    }


    /**
     * <p>RequestedDeviceCode</p>
     * 
     * <p>Requested Device Code</p>
     */
    @Hl7XmlMapping({"requestedDeviceCode/value"})
    public ClinicalDeviceEntity getRequestedDeviceCode() {
        return (ClinicalDeviceEntity) this.requestedDeviceCode.getValue();
    }
    public void setRequestedDeviceCode(ClinicalDeviceEntity requestedDeviceCode) {
        this.requestedDeviceCode.setValue(requestedDeviceCode);
    }


    /**
     * <p>RequestedDrugCode</p>
     * 
     * <p>Requested Drug Code</p>
     */
    @Hl7XmlMapping({"requestedDrugCode/value"})
    public ClinicalDrug getRequestedDrugCode() {
        return (ClinicalDrug) this.requestedDrugCode.getValue();
    }
    public void setRequestedDrugCode(ClinicalDrug requestedDrugCode) {
        this.requestedDrugCode.setValue(requestedDrugCode);
    }


    /**
     * <p>SpecialAuthorizationRequestType</p>
     * 
     * <p>Special Authorization Request Type</p>
     */
    @Hl7XmlMapping({"specialAuthorizationRequestType/value"})
    public Code getSpecialAuthorizationRequestType() {
        return (Code) this.specialAuthorizationRequestType.getValue();
    }
    public void setSpecialAuthorizationRequestType(Code specialAuthorizationRequestType) {
        this.specialAuthorizationRequestType.setValue(specialAuthorizationRequestType);
    }


    /**
     * <p>SpecialAuthorizationStatus</p>
     * 
     * <p>Special Authorization Status</p>
     */
    @Hl7XmlMapping({"specialAuthorizationStatus/value"})
    public List<ActStatus> getSpecialAuthorizationStatus() {
        return new RawListWrapper<CV, ActStatus>(specialAuthorizationStatus, CVImpl.class);
    }

}
