/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.cr.prpa_mt101003ca.PersonBean;



@Hl7PartTypeMapping({"COCT_MT050007CA.IdentifiedEntity","PRPA_MT101003CA.IdentifiedEntity"})
@Hl7RootType
public class OtherIdentifiersBean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private II otherIdentifier = new IIImpl();
    private CV otherIdentifierType = new CVImpl();
    private PersonBean identifiedPerson;

    @Hl7XmlMapping({"id"})
    public Identifier getOtherIdentifier() {
        return this.otherIdentifier.getValue();
    }
    public void setOtherIdentifier(Identifier otherIdentifier) {
        this.otherIdentifier.setValue(otherIdentifier);
    }

    @Hl7XmlMapping({"code"})
    public Code getOtherIdentifierType() {
        return (Code) this.otherIdentifierType.getValue();
    }
    public void setOtherIdentifierType(Code otherIdentifierType) {
        this.otherIdentifierType.setValue(otherIdentifierType);
    }

    @Hl7XmlMapping({"identifiedPerson"})
    public PersonBean getIdentifiedPerson() {
        return this.identifiedPerson;
    }
    public void setIdentifiedPerson(PersonBean identifiedPerson) {
        this.identifiedPerson = identifiedPerson;
    }

}
