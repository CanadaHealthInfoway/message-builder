package ca.infoway.messagebuilder.model.newfoundland;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.HealthcareProviderRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "COCT_MT090107CA.AssignedPerson", "MCAI_MT700210CA.ResponsibleParty", "COCT_MT090102CA.AssignedEntity", "COCT_MT090108CA.AssignedEntity" })
public class AssignedPersonBean extends MessagePartBean implements Serializable, InformantParty, IdentifiablePractitioner, Recipient, AssignedPerson {

    private static final long serialVersionUID = 5659630456107426952L;

    private final SET<II, Identifier> ids = new SETImpl<II, Identifier>(IIImpl.class);

    private final CD code = new CDImpl();

    private final II licenseNumber = new IIImpl();

    private final PN name = new PNImpl();

    @Hl7XmlMapping("id")
    public Set<Identifier> getIds() {
        return this.ids.rawSet();
    }

    public Identifier getId() {
        return this.getIds().isEmpty() ? null : new ArrayList<Identifier>(this.getIds()).get(0);
    }

    public void setId(Identifier id) {
        this.getIds().clear();
        this.getIds().add(id);
    }

    @Hl7XmlMapping("code")
    public HealthcareProviderRoleType getCode() {
        return (HealthcareProviderRoleType) this.code.getValue();
    }

    public void setCode(HealthcareProviderRoleType code) {
        this.code.setValue(code);
    }

    @Hl7XmlMapping({ "representedPerson/asLicensedEntity/id", "assignedPerson/asHealthCareProvider/id" })
    public Identifier getLicenseNumber() {
        return this.licenseNumber.getValue();
    }

    public void setLicenseNumber(Identifier licenseNumber) {
        this.licenseNumber.setValue(licenseNumber);
    }

    @Hl7XmlMapping({ "representedPerson/name", "assignedPerson/name" })
    public PersonName getName() {
        return this.name.getValue();
    }

    public void setName(PersonName name) {
        this.name.setValue(name);
    }
}
