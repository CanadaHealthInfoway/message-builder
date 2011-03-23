/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.coct_mt910108ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.x_SimplePersonalRelationship;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt911108ca.ActingPersonBean;
import java.util.Set;



/**
 * <p>Related Person</p>
 * 
 * <p>Describes a person (other than a health-care provider or 
 * employee) who is providing information and making decision 
 * on behalf of the patient, in relation to the delivery of 
 * healthcare for the patient. E.g. Patient's mother. Also used 
 * with a relationship of "self" when the patient themselves is 
 * providing the care.</p>
 * 
 * <p>Represents information retrieved from the client 
 * registry.</p>
 * 
 * <p>Important for tracking source of information for decision 
 * making and other actions taken on behalf of a patient.</p>
 */
@Hl7PartTypeMapping({"COCT_MT910108CA.PersonalRelationship"})
@Hl7RootType
public class RelatedPersonBean extends MessagePartBean implements ActingPersonBean {

    private static final long serialVersionUID = 20100614L;
    private II relatedPersonIdentifier = new IIImpl();
    private CV responsiblePersonType = new CVImpl();
    private PN relatedPersonName = new PNImpl();
    private SET<TEL, TelecommunicationAddress> relatedPersonPhonesAndEmails = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private AD relatedPersonAddress = new ADImpl();

    @Hl7XmlMapping({"id"})
    public Identifier getRelatedPersonIdentifier() {
        return this.relatedPersonIdentifier.getValue();
    }
    public void setRelatedPersonIdentifier(Identifier relatedPersonIdentifier) {
        this.relatedPersonIdentifier.setValue(relatedPersonIdentifier);
    }

    @Hl7XmlMapping({"code"})
    public x_SimplePersonalRelationship getResponsiblePersonType() {
        return (x_SimplePersonalRelationship) this.responsiblePersonType.getValue();
    }
    public void setResponsiblePersonType(x_SimplePersonalRelationship responsiblePersonType) {
        this.responsiblePersonType.setValue(responsiblePersonType);
    }

    @Hl7XmlMapping({"relationshipHolder/name"})
    public PersonName getRelatedPersonName() {
        return this.relatedPersonName.getValue();
    }
    public void setRelatedPersonName(PersonName relatedPersonName) {
        this.relatedPersonName.setValue(relatedPersonName);
    }

    @Hl7XmlMapping({"relationshipHolder/telecom"})
    public Set<TelecommunicationAddress> getRelatedPersonPhonesAndEmails() {
        return this.relatedPersonPhonesAndEmails.rawSet();
    }

    @Hl7XmlMapping({"relationshipHolder/addr"})
    public PostalAddress getRelatedPersonAddress() {
        return this.relatedPersonAddress.getValue();
    }
    public void setRelatedPersonAddress(PostalAddress relatedPersonAddress) {
        this.relatedPersonAddress.setValue(relatedPersonAddress);
    }

}
