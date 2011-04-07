/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.cr.prpa_mt101103ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"PRPA_MT101103CA.ParameterList"})
@Hl7RootType
public class ParameterListBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private CV clientGender = new CVImpl();
    private List<II> clientHealthcareIdentificationNumberAndOrNonHealthcareIdentification = new ArrayList<II>();
    private DeceasedIndicatorBean deceasedIndicator;
    private DeceasedTimeBean deceasedTime;
    private FathersNameBean fathersName;
    private LanguageCodeBean languageCode;
    private MothersMaidenNameBean mothersMaidenName;
    private MultipleBirthIndicatorBean multipleBirthIndicator;
    private MultipleBirthOrderNumberBean multipleBirthOrderNumber;
    private List<AD> clientAddress = new ArrayList<AD>();
    private TS clientDateOfBirth = new TSImpl();
    private List<PN> clientName = new ArrayList<PN>();
    private List<TEL> clientTelecom = new ArrayList<TEL>();
    private PersonalRelationshipCodeBean personalRelationshipCode;


    /**
     * <p>Client Gender</p>
     */
    @Hl7XmlMapping({"administrativeGender/value"})
    public AdministrativeGender getClientGender() {
        return (AdministrativeGender) this.clientGender.getValue();
    }
    public void setClientGender(AdministrativeGender clientGender) {
        this.clientGender.setValue(clientGender);
    }


    /**
     * <p>Identification</p>
     */
    @Hl7XmlMapping({"clientId/value"})
    public List<Identifier> getClientHealthcareIdentificationNumberAndOrNonHealthcareIdentification() {
        return new RawListWrapper<II, Identifier>(clientHealthcareIdentificationNumberAndOrNonHealthcareIdentification, IIImpl.class);
    }


    @Hl7XmlMapping({"deceasedIndicator"})
    public DeceasedIndicatorBean getDeceasedIndicator() {
        return this.deceasedIndicator;
    }
    public void setDeceasedIndicator(DeceasedIndicatorBean deceasedIndicator) {
        this.deceasedIndicator = deceasedIndicator;
    }


    @Hl7XmlMapping({"deceasedTime"})
    public DeceasedTimeBean getDeceasedTime() {
        return this.deceasedTime;
    }
    public void setDeceasedTime(DeceasedTimeBean deceasedTime) {
        this.deceasedTime = deceasedTime;
    }


    @Hl7XmlMapping({"fathersName"})
    public FathersNameBean getFathersName() {
        return this.fathersName;
    }
    public void setFathersName(FathersNameBean fathersName) {
        this.fathersName = fathersName;
    }


    @Hl7XmlMapping({"languageCode"})
    public LanguageCodeBean getLanguageCode() {
        return this.languageCode;
    }
    public void setLanguageCode(LanguageCodeBean languageCode) {
        this.languageCode = languageCode;
    }


    @Hl7XmlMapping({"mothersMaidenName"})
    public MothersMaidenNameBean getMothersMaidenName() {
        return this.mothersMaidenName;
    }
    public void setMothersMaidenName(MothersMaidenNameBean mothersMaidenName) {
        this.mothersMaidenName = mothersMaidenName;
    }


    @Hl7XmlMapping({"multipleBirthIndicator"})
    public MultipleBirthIndicatorBean getMultipleBirthIndicator() {
        return this.multipleBirthIndicator;
    }
    public void setMultipleBirthIndicator(MultipleBirthIndicatorBean multipleBirthIndicator) {
        this.multipleBirthIndicator = multipleBirthIndicator;
    }


    @Hl7XmlMapping({"multipleBirthOrderNumber"})
    public MultipleBirthOrderNumberBean getMultipleBirthOrderNumber() {
        return this.multipleBirthOrderNumber;
    }
    public void setMultipleBirthOrderNumber(MultipleBirthOrderNumberBean multipleBirthOrderNumber) {
        this.multipleBirthOrderNumber = multipleBirthOrderNumber;
    }


    /**
     * <p>Client Address</p>
     */
    @Hl7XmlMapping({"personAddress/value"})
    public List<PostalAddress> getClientAddress() {
        return new RawListWrapper<AD, PostalAddress>(clientAddress, ADImpl.class);
    }


    /**
     * <p>Client Date of Birth</p>
     */
    @Hl7XmlMapping({"personBirthtime/value"})
    public Date getClientDateOfBirth() {
        return this.clientDateOfBirth.getValue();
    }
    public void setClientDateOfBirth(Date clientDateOfBirth) {
        this.clientDateOfBirth.setValue(clientDateOfBirth);
    }


    /**
     * <p>Client Name</p>
     */
    @Hl7XmlMapping({"personName/value"})
    public List<PersonName> getClientName() {
        return new RawListWrapper<PN, PersonName>(clientName, PNImpl.class);
    }


    /**
     * <p>Client Telecom</p>
     */
    @Hl7XmlMapping({"personTelecom/value"})
    public List<TelecommunicationAddress> getClientTelecom() {
        return new RawListWrapper<TEL, TelecommunicationAddress>(clientTelecom, TELImpl.class);
    }


    @Hl7XmlMapping({"personalRelationshipCode"})
    public PersonalRelationshipCodeBean getPersonalRelationshipCode() {
        return this.personalRelationshipCode;
    }
    public void setPersonalRelationshipCode(PersonalRelationshipCodeBean personalRelationshipCode) {
        this.personalRelationshipCode = personalRelationshipCode;
    }

}
