/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.coct_mt050303ca;

import java.util.Set;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Animal Patient</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">An animal 
 * that is receiving or may receive healthcare services.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Used when 
 * animal services are attached to a human patient record. E.g. 
 * narcotics prescribed for a pet may be attached to the 
 * owner's record for monitoring of abuse.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT050303CA.Patient"})
@Hl7RootType
public class AnimalPatientBean extends MessagePartBean implements ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged.Patient_2 {

    private static final long serialVersionUID = 20110714L;
    private ST animalName = new STImpl();
    private AD ownerAddress = new ADImpl();
    private SET<TEL, TelecommunicationAddress> ownerPhonesAndEmails = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private PN ownerName = new PNImpl();


    /**
     * <p>B:Animal name</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Name by 
     * which the animal patient is known.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">ZPA.1 
     * (partType=Given)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPA.2 
     * (partType=Family)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPA.3 
     * (partType=Given - all repetitions except first)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">C37 
     * (partType=Given)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">C38 
     * (partType=Family)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PTT.030-01 
     * (partType=Family)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PTT.030-02 
     * (partType=Given - 1st occurrence)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PTT.030-03 
     * (partType=Given - subsequen occurrences)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PTT.030-04 
     * (partType=Suffix)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PTT.030-05 
     * (partType=Prefix)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">patient 
     * Initials</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PID.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Patient.310-CA 
     * (partType=Given)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Patient.311-CB 
     * (partType=Family)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Recipient Name 
     * First (partType=Given)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Recipient Name 
     * Last (partType=Family)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PID.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PID.9 (any name 
     * other than first repetition is an alias)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.3</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZKW.2</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Person.givenName</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Person.lastName</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Person.middleName</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Person.namePrefix</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Person.nameSuffix</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">ZPA.1 
     * (partType=Given)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPA.2 
     * (partType=Family)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPA.3 
     * (partType=Given - all repetitions except first)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">C37 
     * (partType=Given)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">C38 
     * (partType=Family)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PTT.030-01 
     * (partType=Family)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PTT.030-02 
     * (partType=Given - 1st occurrence)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PTT.030-03 
     * (partType=Given - subsequen occurrences)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PTT.030-04 
     * (partType=Suffix)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PTT.030-05 
     * (partType=Prefix)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">patient 
     * Initials</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PID.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Patient.310-CA 
     * (partType=Given)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Patient.311-CB 
     * (partType=Family)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Recipient Name 
     * First (partType=Given)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Recipient Name 
     * Last (partType=Family)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PID.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PID.9 (any name 
     * other than first repetition is an alias)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.3</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZKW.2</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Person.givenName</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Person.lastName</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Person.middleName</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Person.namePrefix</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Person.nameSuffix</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">ZPA.1 
     * (partType=Given)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPA.2 
     * (partType=Family)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPA.3 
     * (partType=Given - all repetitions except first)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">C37 
     * (partType=Given)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">C38 
     * (partType=Family)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PTT.030-01 
     * (partType=Family)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PTT.030-02 
     * (partType=Given - 1st occurrence)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PTT.030-03 
     * (partType=Given - subsequen occurrences)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PTT.030-04 
     * (partType=Suffix)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PTT.030-05 
     * (partType=Prefix)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">patient 
     * Initials</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PID.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Patient.310-CA 
     * (partType=Given)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Patient.311-CB 
     * (partType=Family)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Recipient Name 
     * First (partType=Given)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Recipient Name 
     * Last (partType=Family)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PID.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PID.9 (any name 
     * other than first repetition is an alias)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.3</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZKW.2</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Person.givenName</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Person.lastName</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Person.middleName</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Person.namePrefix</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Person.nameSuffix</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">ZPA.1 
     * (partType=Given)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPA.2 
     * (partType=Family)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPA.3 
     * (partType=Given - all repetitions except first)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">C37 
     * (partType=Given)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">C38 
     * (partType=Family)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PTT.030-01 
     * (partType=Family)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PTT.030-02 
     * (partType=Given - 1st occurrence)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PTT.030-03 
     * (partType=Given - subsequen occurrences)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PTT.030-04 
     * (partType=Suffix)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PTT.030-05 
     * (partType=Prefix)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">patient 
     * Initials</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PID.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Patient.310-CA 
     * (partType=Given)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Patient.311-CB 
     * (partType=Family)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Recipient Name 
     * First (partType=Given)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Recipient Name 
     * Last (partType=Family)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PID.5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PID.9 (any name 
     * other than first repetition is an alias)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDU.3</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZKW.2</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Person.givenName</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Person.lastName</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Person.middleName</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Person.namePrefix</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Person.nameSuffix</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">ZPA.1 
     * (partType=Given)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPA.2 
     * (partType=Family)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPA.3 
     * (partType=Given - all repetitions except first)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">C37 
     * (partType=Given)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">C38 
     * (partType=Family)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PTT.030-01 
     * (partType=Family)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PTT.030-02 
     * (partType=Given - 1st occurrence)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PTT.030-03 
     * (partType=Given - subsequen occurrences)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PTT.030-04 
     * (partType=Suffix)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PTT.030-05 
     * (partType=Prefix)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">patient 
     * Initial
     * ... [rest of documentation truncated due to excessive length]
     */
    @Hl7XmlMapping({"patientAnimal/name"})
    public String getAnimalName() {
        return this.animalName.getValue();
    }
    public void setAnimalName(String animalName) {
        this.animalName.setValue(animalName);
    }


    /**
     * <p>Owner address</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The mail 
     * and/or physical address associated with the owner or contact 
     * person for the animal.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Used to 
     * contact the owner or contact person</p></p>
     */
    @Hl7XmlMapping({"patientAnimal/contactParty/addr"})
    public PostalAddress getOwnerAddress() {
        return this.ownerAddress.getValue();
    }
    public void setOwnerAddress(PostalAddress ownerAddress) {
        this.ownerAddress.setValue(ownerAddress);
    }


    /**
     * <p>Owner Phones and Emails</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The phone 
     * number(s) and email address(s) by which the owner may be 
     * contacted.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Used to 
     * contact the owner or contact person</p></p>
     */
    @Hl7XmlMapping({"patientAnimal/contactParty/telecom"})
    public Set<TelecommunicationAddress> getOwnerPhonesAndEmails() {
        return this.ownerPhonesAndEmails.rawSet();
    }


    /**
     * <p>Owner Name</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The name by 
     * which the owner person is known</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Used when 
     * contacting or addressing the owner person. Because this will 
     * be the principle means of identifying the owner person, it 
     * is mandatory.</p></p>
     */
    @Hl7XmlMapping({"patientAnimal/contactParty/contactPerson/name"})
    public PersonName getOwnerName() {
        return this.ownerName.getValue();
    }
    public void setOwnerName(PersonName ownerName) {
        this.ownerName.setValue(ownerName);
    }

}
