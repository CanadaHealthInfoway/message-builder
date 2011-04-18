package ca.infoway.messagebuilder.model.newfoundland.cr;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7BusinessName;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.model.newfoundland.PersonQueryCriteria;

@Hl7PartTypeMapping("PRPA_MT101103CA.ParameterList")
public class FindCandidatesCriteria extends PersonQueryCriteria {

    private static final long serialVersionUID = -8159830797683245013L;

    @Hl7BusinessName("clientName")
    private List<PN> personNames = new ArrayList<PN>();

    @Hl7BusinessName("clientGender")
    private final CD gender = new CDImpl();
    
    @Hl7BusinessName("clientAddress")
    private List<AD> addresses = new ArrayList<AD>();

    @Hl7BusinessName("clientTelecom")
    private List<TEL> telecoms = new ArrayList<TEL>();

    @Hl7BusinessName("clientDateOfBirth")
    private final TS birthDate = new TSImpl();

    @Override
	@Hl7XmlMapping("personBirthtime/value")
    public Date getBirthDate() {
        return this.birthDate.getValue();
    }

    @Override
	public void setBirthDate(Date birthDate) {
        this.birthDate.setValue(birthDate);
    }
    
    /**
	 *  <p>(Client Healthcare Identification Number And Or NonHealthcare Identification.</p>
	 *  
	 *  <p>Healthcare identiers may be assigned jurisdictionally or by care facility 
	 *  and/or non-healthcare identifiers for the Client (e.g. Passport, SIN, DND, 
	 *  DIAND, Drivers License)</p>
	 *  
	 *  <p>Mandatory attribute supports the identification of the client.</p>
	 */
    @Override
    @Hl7XmlMapping("clientId/value")
    public List<Identifier> getIdentifiers() {
        return super.getIdentifiers();
    }

    /**
	 * <p>Client Name</p>
	 * 
	 * <p>Name(s) for the Client.</p>
	 * 
	 * <p>Mandatory attribute supports the identification of the client.</p>
	 */
    @Hl7XmlMapping("personName/value")
    public List<PersonName> getPersonNames() {
    	return new RawListWrapper<PN, PersonName>(this.personNames, PNImpl.class);
    }

    @Override
    public void setName(PersonName name) {
    	getPersonNames().clear();
    	getPersonNames().add(name);
    }

    @Override
    public PersonName getName() {
    	List<PersonName> names = getPersonNames();
        return names.isEmpty() ? null : names.get(0);
    }

    /**
	 * <p>Client Address.</p>
	 * 
	 * <p>Address(es) of the Client.</p>
	 * 
	 * <p>Mandatory attribute supports the identification of the client.</p>
	 */
    @Hl7XmlMapping("personAddress/value")
    public List<PostalAddress> getAddresses() {
    	return new RawListWrapper<AD, PostalAddress>(this.addresses, ADImpl.class);
    }

    /**
	 * <p>Client Telecom.</p>
	 * 
	 * <p>Provides information about telecom.</p>
	 * 
	 * <p>Mandatory attribute supports the identification of the client.</p>
	 */
    @Override
    @Hl7XmlMapping("personTelecom/value")
    public List<TelecommunicationAddress> getTelecoms() {
    	return new RawListWrapper<TEL, TelecommunicationAddress>(this.telecoms, TELImpl.class);
    }
    
    @Override
	@Hl7XmlMapping("administrativeGender/value")
    public AdministrativeGender getGender() {
        return (AdministrativeGender) this.gender.getValue();
    }

    @Override
	public void setGender(AdministrativeGender gender) {
        this.gender.setValue(gender);
    }
}