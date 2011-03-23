package ca.infoway.messagebuilder.model.pr;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.HealthcareProviderRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({"PRPM_MT306011CA.HealthCareProvider"})
public class HealthcareProvider extends MessagePartBean implements RoleChoice, Serializable {

	private static final long serialVersionUID = 1701242657724075950L;
	
	private final SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
	private final LIST<PN, PersonName> name = new LISTImpl<PN, PersonName>(PNImpl.class);
	private final CD code = new CDImpl();

	@Hl7XmlMapping("name")
	public List<PersonName> getName() {
		return this.name.rawList();
	}

	@Hl7XmlMapping("id")
	public Set<Identifier> getId() {
		return this.id.rawSet();
	}

	@Hl7XmlMapping("code")
	public HealthcareProviderRoleType getCode() {
		return (HealthcareProviderRoleType) this.code.getValue();
	}

	public void setCode(HealthcareProviderRoleType code) {
		this.code.setValue(code);
	}
}
