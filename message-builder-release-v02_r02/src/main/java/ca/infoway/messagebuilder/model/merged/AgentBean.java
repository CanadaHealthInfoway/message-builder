/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PORX_MT020070CA.Agent","PORX_MT060160CA.Agent","PORX_MT060340CA.Agent"})
public class AgentBean extends MessagePartBean {

    private static final long serialVersionUID = 20100614L;
    private II substitutingPersonIdentifier = new IIImpl();

    @Hl7XmlMapping({"id"})
    public Identifier getSubstitutingPersonIdentifier() {
        return this.substitutingPersonIdentifier.getValue();
    }
    public void setSubstitutingPersonIdentifier(Identifier substitutingPersonIdentifier) {
        this.substitutingPersonIdentifier.setValue(substitutingPersonIdentifier);
    }

}
