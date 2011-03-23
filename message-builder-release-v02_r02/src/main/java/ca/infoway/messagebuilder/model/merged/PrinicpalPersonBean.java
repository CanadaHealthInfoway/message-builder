/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"PRPM_MT301010CA.PrincipalPerson","PRPM_MT303010CA.PrincipalPerson"})
public class PrinicpalPersonBean extends MessagePartBean {

    private static final long serialVersionUID = 20100614L;
    private II principalPersonAggregateIdentifier = new IIImpl();
    private LIST<PN, PersonName> principalPersonName = new LISTImpl<PN, PersonName>(PNImpl.class);
    private CV principalPersonGender = new CVImpl();
    private TS principalPersonDateOfBirth = new TSImpl();
    private BL principalPersonDeceasedIndicator = new BLImpl();
    private TS principalPersonDeceasedDate = new TSImpl();
    private AD birthplaceAddress = new ADImpl();
    private List<LanguageCommunicationBean> languageCommunication = new ArrayList<LanguageCommunicationBean>();

    @Hl7XmlMapping({"id"})
    public Identifier getPrincipalPersonAggregateIdentifier() {
        return this.principalPersonAggregateIdentifier.getValue();
    }
    public void setPrincipalPersonAggregateIdentifier(Identifier principalPersonAggregateIdentifier) {
        this.principalPersonAggregateIdentifier.setValue(principalPersonAggregateIdentifier);
    }

    @Hl7XmlMapping({"name"})
    public List<PersonName> getPrincipalPersonName() {
        return this.principalPersonName.rawList();
    }

    @Hl7XmlMapping({"administrativeGenderCode"})
    public AdministrativeGender getPrincipalPersonGender() {
        return (AdministrativeGender) this.principalPersonGender.getValue();
    }
    public void setPrincipalPersonGender(AdministrativeGender principalPersonGender) {
        this.principalPersonGender.setValue(principalPersonGender);
    }

    @Hl7XmlMapping({"birthTime"})
    public Date getPrincipalPersonDateOfBirth() {
        return this.principalPersonDateOfBirth.getValue();
    }
    public void setPrincipalPersonDateOfBirth(Date principalPersonDateOfBirth) {
        this.principalPersonDateOfBirth.setValue(principalPersonDateOfBirth);
    }

    @Hl7XmlMapping({"deceasedInd"})
    public Boolean getPrincipalPersonDeceasedIndicator() {
        return this.principalPersonDeceasedIndicator.getValue();
    }
    public void setPrincipalPersonDeceasedIndicator(Boolean principalPersonDeceasedIndicator) {
        this.principalPersonDeceasedIndicator.setValue(principalPersonDeceasedIndicator);
    }

    @Hl7XmlMapping({"deceasedTime"})
    public Date getPrincipalPersonDeceasedDate() {
        return this.principalPersonDeceasedDate.getValue();
    }
    public void setPrincipalPersonDeceasedDate(Date principalPersonDeceasedDate) {
        this.principalPersonDeceasedDate.setValue(principalPersonDeceasedDate);
    }

    @Hl7XmlMapping({"birthplace/addr"})
    public PostalAddress getBirthplaceAddress() {
        return this.birthplaceAddress.getValue();
    }
    public void setBirthplaceAddress(PostalAddress birthplaceAddress) {
        this.birthplaceAddress.setValue(birthplaceAddress);
    }

    @Hl7XmlMapping({"languageCommunication"})
    public List<LanguageCommunicationBean> getLanguageCommunication() {
        return this.languageCommunication;
    }

}
