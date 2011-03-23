package ca.infoway.messagebuilder.model.cerx.medicationprofile;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.x_ActMoodOrderEvent;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "PORX_MT010120CA.Coverage", "PORX_MT060160CA.Coverage" })
public class CoverageBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = -4427268897648324856L;

    private CD moodCode = new CDImpl();

    private II identifier = new IIImpl();

    private II payorIdentifier = new IIImpl();

    private ST payorName = new STImpl();

    @Hl7XmlMapping("moodCode")
    public x_ActMoodOrderEvent getMoodCode() {
        return (x_ActMoodOrderEvent) this.moodCode.getValue();
    }

    public void setMoodCode(x_ActMoodOrderEvent moodCode) {
        this.moodCode.setValue(moodCode);
    }

    @Hl7XmlMapping("id")
    public Identifier getIdentifier() {
        return this.identifier.getValue();
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier.setValue(identifier);
    }

    @Hl7XmlMapping({ "author/carrierRole/id", "author/underwriter/id" })
    public Identifier getPayorIdentifier() {
        return this.payorIdentifier.getValue();
    }

    public void setPayorIdentifier(Identifier payorIdentifier) {
        this.payorIdentifier.setValue(payorIdentifier);
    }

    @Hl7XmlMapping({ "author/carrierRole/underwritingCarrierOrganization/name", "author/underwriter/underwritingOrganization/name" })
    public String getPayorName() {
        return this.payorName.getValue();
    }

    public void setPayorName(String payorName) {
        this.payorName.setValue(payorName);
    }
}
