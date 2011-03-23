/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.coct_mt490000ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;



@Hl7PartTypeMapping({"COCT_MT490000CA.ProductReferrer"})
public class ProductReferrerBean extends MessagePartBean {

    private SET<II, Identifier> providerIdentifierS = new SETImpl<II, Identifier>(IIImpl.class);
    private CV<Code> providerType = new CVImpl<Code>();
    private PN nameOfProvider = new PNImpl();
    private TEL contactNo = new TELImpl();
    private CV<AdministrativeGender> providerGender = new CVImpl<AdministrativeGender>();
    private TS providerDateOfBirth = new TSImpl();
    private AD providerAddress = new ADImpl();

    @Hl7XmlMapping({"healthCareProvider/id"})
    public Set<Identifier> getProviderIdentifierS() {
        return this.providerIdentifierS.rawSet();
    }

    @Hl7XmlMapping({"healthCareProvider/code"})
    public Code getProviderType() {
        return this.providerType.getValue();
    }
    public void setProviderType(Code providerType) {
        this.providerType.setValue(providerType);
    }

    @Hl7XmlMapping({"healthCareProvider/healthCareProviderPerson/name"})
    public PersonName getNameOfProvider() {
        return this.nameOfProvider.getValue();
    }
    public void setNameOfProvider(PersonName nameOfProvider) {
        this.nameOfProvider.setValue(nameOfProvider);
    }

    @Hl7XmlMapping({"healthCareProvider/healthCareProviderPerson/telecom"})
    public TelecommunicationAddress getContactNo() {
        return this.contactNo.getValue();
    }
    public void setContactNo(TelecommunicationAddress contactNo) {
        this.contactNo.setValue(contactNo);
    }

    @Hl7XmlMapping({"healthCareProvider/healthCareProviderPerson/administrativeGenderCode"})
    public AdministrativeGender getProviderGender() {
        return this.providerGender.getValue();
    }
    public void setProviderGender(AdministrativeGender providerGender) {
        this.providerGender.setValue(providerGender);
    }

    @Hl7XmlMapping({"healthCareProvider/healthCareProviderPerson/birthTime"})
    public Date getProviderDateOfBirth() {
        return this.providerDateOfBirth.getValue();
    }
    public void setProviderDateOfBirth(Date providerDateOfBirth) {
        this.providerDateOfBirth.setValue(providerDateOfBirth);
    }

    @Hl7XmlMapping({"healthCareProvider/healthCareProviderPerson/addr"})
    public PostalAddress getProviderAddress() {
        return this.providerAddress.getValue();
    }
    public void setProviderAddress(PostalAddress providerAddress) {
        this.providerAddress.setValue(providerAddress);
    }

}
