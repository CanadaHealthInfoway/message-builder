package ca.infoway.messagebuilder.model.newfoundland.cr;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.newfoundland.QueryCriteria;

@Hl7PartTypeMapping({ "PRPA_MT101101CA.ParameterList" })
public class FindAssociatedIdentifiersCriteria extends QueryCriteria {

    private static final long serialVersionUID = 3762023883896990729L;

    private final II clientBusinessId = new IIImpl();

    private final II clientPublicId = new IIImpl();

    @Hl7XmlMapping("clientIDBus/value")
    public Identifier getClientBusinessId() {
        return this.clientBusinessId.getValue();
    }

    public void setClientBusinessId(Identifier clientBusinessId) {
        this.clientBusinessId.setValue(clientBusinessId);
    }

    @Hl7XmlMapping("clientIDPub/value")
    public Identifier getClientPublicId() {
        return this.clientPublicId.getValue();
    }

    public void setClientPublicId(Identifier clientPublicId) {
        this.clientPublicId.setValue(clientPublicId);
    }

    public Identifier getIdentifier() {
        if (this.clientBusinessId.getValue()!= null) {
            return this.clientBusinessId.getValue();
        } else if (this.clientPublicId.getValue() != null) {
            return this.clientPublicId.getValue();
        } else {
            return null;
        }
    }
}
