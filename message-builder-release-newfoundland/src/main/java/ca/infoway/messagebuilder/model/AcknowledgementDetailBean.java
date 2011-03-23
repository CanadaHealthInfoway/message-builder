package ca.infoway.messagebuilder.model;

import java.io.Serializable;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.AcknowledgementDetailCode;
import ca.infoway.messagebuilder.domainvalue.AcknowledgementDetailType;

@Hl7PartTypeMapping({ "MCCI_MT002300CA.AcknowledgementDetail" })
public class AcknowledgementDetailBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = -6328334018535930961L;

    private final CD typeCode = new CDImpl();

    private final CD code = new CDImpl();

    private final ST text = new STImpl();

    private LIST<ST, String> location = new LISTImpl<ST, String>(STImpl.class);

    public AcknowledgementDetailBean() {
    }

    public AcknowledgementDetailBean(AcknowledgementDetailType typeCode, AcknowledgementDetailCode code, String text) {
        setTypeCode(typeCode);
        setCode(code);
        setText(text);
    }

    @Hl7XmlMapping("code")
    public AcknowledgementDetailCode getCode() {
        return (AcknowledgementDetailCode) this.code.getValue();
    }

    public void setCode(AcknowledgementDetailCode code) {
        this.code.setValue(code);
    }

    @Hl7XmlMapping("text")
    public String getText() {
        return this.text.getValue();
    }

    public void setText(String text) {
        this.text.setValue(text);
    }

    @Hl7XmlMapping("location")
    public List<String> getLocation() {
        return this.location.rawList();
    }

    @Hl7XmlMapping("typeCode")
    public AcknowledgementDetailType getTypeCode() {
        return (AcknowledgementDetailType) this.typeCode.getValue();
    }

    public void setTypeCode(AcknowledgementDetailType typeCode) {
        this.typeCode.setValue(typeCode);
    }
}
