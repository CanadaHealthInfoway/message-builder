package ca.infoway.messagebuilder.model.newfoundland.cr;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.newfoundland.QueryCriteria;

@Hl7PartTypeMapping({ "PRPA_MT101101CA.ParameterList" })
public class DemographicsQueryCriteria extends QueryCriteria {

    private static final long serialVersionUID = 8278423502300636113L;

    private II clientIDBus = new IIImpl();

    private II clientIDPub = new IIImpl();

    @Hl7XmlMapping("clientIDBus/value")
    public Identifier getClientIDBus() {
        return this.clientIDBus.getValue();
    }

    public void setClientIDBus(Identifier clientIDBus) {
        this.clientIDBus.setValue(clientIDBus);
    }

    @Hl7XmlMapping("clientIDPub/value")
    public Identifier getClientIDPub() {
        return this.clientIDPub.getValue();
    }

    public void setClientIDPub(Identifier clientIDPub) {
        this.clientIDPub.setValue(clientIDPub);
    }
}
