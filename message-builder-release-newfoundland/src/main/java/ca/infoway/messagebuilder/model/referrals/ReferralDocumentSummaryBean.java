package ca.infoway.messagebuilder.model.referrals;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;

@Hl7PartTypeMapping({ "REPC_MT210002CA.Document" })
public class ReferralDocumentSummaryBean extends ReferralDocumentBean implements Serializable {

    private static final long serialVersionUID = 1411839540124934470L;

    private II id = new IIImpl();

    @Hl7XmlMapping("id")
    public Identifier getId() {
        return this.id.getValue();
    }

    public void setId(Identifier id) {
        this.id.setValue(id);
    }
}
