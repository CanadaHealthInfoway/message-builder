package ca.infoway.messagebuilder.model.location;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;

public abstract class BaseLocationBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = 7989032264151534130L;

    private II indirectAuthority = new IIImpl();

    @Hl7XmlMapping("indirectAuthority/territorialAuthority")
    public Identifier getIndirectAuthority() {
        return this.indirectAuthority.getValue();
    }

    public void setIndirectAuthority(Identifier indirectAuthority) {
        this.indirectAuthority.setValue(indirectAuthority);
    }
}
