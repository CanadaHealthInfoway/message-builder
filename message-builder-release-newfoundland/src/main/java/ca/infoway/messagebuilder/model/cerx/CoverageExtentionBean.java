package ca.infoway.messagebuilder.model.cerx;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.x_ActMoodOrderEvent;
import ca.infoway.messagebuilder.model.MessagePartBean;

/**
 * 
 * @author administrator
 *
 * Business name: Coverage Extensions
 * An authorization issued by a payor to cover a device not previously covered by a patient's drug plan.
 * Allows conveying special coverage information between providers.
 * 
 */
@Hl7PartTypeMapping({ "PORX_MT060040CA.Coverage" })
public class CoverageExtentionBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = 7153526012375350674L;

    private CD moodCode = new CDImpl();

    private II id = new IIImpl();

    private UnderwriterBean underwriter;

    @Hl7XmlMapping({ "moodCode" })
    public x_ActMoodOrderEvent getMoodCode() {
        return (x_ActMoodOrderEvent) this.moodCode.getValue();
    }

    public void setMoodCode(x_ActMoodOrderEvent moodCode) {
        this.moodCode.setValue(moodCode);
    }

    @Hl7XmlMapping({ "id" })
    public Identifier getId() {
        return this.id.getValue();
    }

    public void setId(Identifier id) {
        this.id.setValue(id);
    }

    @Hl7XmlMapping({ "author/underwriter" })
    public UnderwriterBean getUnderwriter() {
        return underwriter;
    }

    public void setUnderwriter(UnderwriterBean underwriter) {
        this.underwriter = underwriter;
    }
}
