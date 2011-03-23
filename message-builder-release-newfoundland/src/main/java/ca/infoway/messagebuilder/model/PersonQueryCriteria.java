package ca.infoway.messagebuilder.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;

public abstract class PersonQueryCriteria extends QueryCriteria implements Serializable {

    private static final long serialVersionUID = 1314143115772807147L;


    private final LIST<II, Identifier> identifiers = new LISTImpl<II, Identifier>(IIImpl.class);

    private final PN name = new PNImpl();

    public List<Identifier> getIdentifiers() {
        return this.identifiers.rawList();
    }

    public abstract Date getBirthDate();
    public abstract void setBirthDate(Date birthDate);

    public abstract AdministrativeGender getGender();    
    public abstract void setGender(AdministrativeGender gender);

    public void setName(PersonName name) {
        this.name.setValue(name);
    }

    public PersonName getName() {
        return this.name.getValue();
    }

    public abstract List<TelecommunicationAddress> getTelecoms();
}
