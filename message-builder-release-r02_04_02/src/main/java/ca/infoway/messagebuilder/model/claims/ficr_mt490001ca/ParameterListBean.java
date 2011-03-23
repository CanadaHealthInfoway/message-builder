/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.claims.ficr_mt490001ca;

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



@Hl7PartTypeMapping({"FICR_MT490001CA.ParameterList"})
@Hl7RootType
public class ParameterListBean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private CV approvedDeviceCode = new CVImpl();
    private CV approvedDrugCode = new CVImpl();
    private II authorID = new IIImpl();
    private PN authorName = new PNImpl();
    private TS coveredPartyBirthdate = new TSImpl();
    private CV genderOfCoveredParty = new CVImpl();
    private PN coveredPartyName = new PNImpl();
    private IVL<TS, Interval<Date>> specialAuthorizationExpiryDateRange = new IVLImpl<TS, Interval<Date>>();
    private II policyIdentifier = new IIImpl();
    private CV requestedDeviceCode = new CVImpl();
    private CV requestedDrugCode = new CVImpl();
    private CV specialAuthorizationRequestType = new CVImpl();
    private List<CV> specialAuthorizationStatus = new ArrayList<CV>();

    @Hl7XmlMapping({"approvedDeviceCode/value"})
    public ClinicalDeviceEntity getApprovedDeviceCode() {
        return (ClinicalDeviceEntity) this.approvedDeviceCode.getValue();
    }
    public void setApprovedDeviceCode(ClinicalDeviceEntity approvedDeviceCode) {
        this.approvedDeviceCode.setValue(approvedDeviceCode);
    }

    @Hl7XmlMapping({"approvedDrugCode/value"})
    public ClinicalDrug getApprovedDrugCode() {
        return (ClinicalDrug) this.approvedDrugCode.getValue();
    }
    public void setApprovedDrugCode(ClinicalDrug approvedDrugCode) {
        this.approvedDrugCode.setValue(approvedDrugCode);
    }

    @Hl7XmlMapping({"authorID/id"})
    public Identifier getAuthorID() {
        return this.authorID.getValue();
    }
    public void setAuthorID(Identifier authorID) {
        this.authorID.setValue(authorID);
    }

    @Hl7XmlMapping({"authorName/value"})
    public PersonName getAuthorName() {
        return this.authorName.getValue();
    }
    public void setAuthorName(PersonName authorName) {
        this.authorName.setValue(authorName);
    }

    @Hl7XmlMapping({"coveredPartyDOB/value"})
    public Date getCoveredPartyBirthdate() {
        return this.coveredPartyBirthdate.getValue();
    }
    public void setCoveredPartyBirthdate(Date coveredPartyBirthdate) {
        this.coveredPartyBirthdate.setValue(coveredPartyBirthdate);
    }

    @Hl7XmlMapping({"coveredPartyGender/value"})
    public AdministrativeGender getGenderOfCoveredParty() {
        return (AdministrativeGender) this.genderOfCoveredParty.getValue();
    }
    public void setGenderOfCoveredParty(AdministrativeGender genderOfCoveredParty) {
        this.genderOfCoveredParty.setValue(genderOfCoveredParty);
    }

    @Hl7XmlMapping({"coveredPartyName/value"})
    public PersonName getCoveredPartyName() {
        return this.coveredPartyName.getValue();
    }
    public void setCoveredPartyName(PersonName coveredPartyName) {
        this.coveredPartyName.setValue(coveredPartyName);
    }

    @Hl7XmlMapping({"expiryDateRange/value"})
    public Interval<Date> getSpecialAuthorizationExpiryDateRange() {
        return this.specialAuthorizationExpiryDateRange.getValue();
    }
    public void setSpecialAuthorizationExpiryDateRange(Interval<Date> specialAuthorizationExpiryDateRange) {
        this.specialAuthorizationExpiryDateRange.setValue(specialAuthorizationExpiryDateRange);
    }

    @Hl7XmlMapping({"policyIdentifier/value"})
    public Identifier getPolicyIdentifier() {
        return this.policyIdentifier.getValue();
    }
    public void setPolicyIdentifier(Identifier policyIdentifier) {
        this.policyIdentifier.setValue(policyIdentifier);
    }

    @Hl7XmlMapping({"requestedDeviceCode/value"})
    public ClinicalDeviceEntity getRequestedDeviceCode() {
        return (ClinicalDeviceEntity) this.requestedDeviceCode.getValue();
    }
    public void setRequestedDeviceCode(ClinicalDeviceEntity requestedDeviceCode) {
        this.requestedDeviceCode.setValue(requestedDeviceCode);
    }

    @Hl7XmlMapping({"requestedDrugCode/value"})
    public ClinicalDrug getRequestedDrugCode() {
        return (ClinicalDrug) this.requestedDrugCode.getValue();
    }
    public void setRequestedDrugCode(ClinicalDrug requestedDrugCode) {
        this.requestedDrugCode.setValue(requestedDrugCode);
    }

    @Hl7XmlMapping({"specialAuthorizationRequestType/value"})
    public Code getSpecialAuthorizationRequestType() {
        return (Code) this.specialAuthorizationRequestType.getValue();
    }
    public void setSpecialAuthorizationRequestType(Code specialAuthorizationRequestType) {
        this.specialAuthorizationRequestType.setValue(specialAuthorizationRequestType);
    }

    @Hl7XmlMapping({"specialAuthorizationStatus/value"})
    public List<ActStatus> getSpecialAuthorizationStatus() {
        return new RawListWrapper<CV, ActStatus>(specialAuthorizationStatus, CVImpl.class);
    }

}
