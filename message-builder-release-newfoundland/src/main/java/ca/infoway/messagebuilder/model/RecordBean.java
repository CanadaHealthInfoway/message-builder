package ca.infoway.messagebuilder.model;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.domainvalue.ActRelationshipType;

@Hl7PartTypeMapping({ "MCAI_MT700210CA.Subject2", "MCAI_MT700212CA.Subject2", "MCAI_MT700220CA.Subject2", "MCAI_MT700227NL.Subject2", "QUQI_MT120000CA.Subject2", "QUQI_MT120006CA.Subject2", "QUQI_MT120008CA.Subject2" })
public class RecordBean<R> extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = 4772090879756134214L;

    private CD typeCode = new CDImpl();

    private BL contextConductionInd = new BLImpl(false);

    private R record;

    public RecordBean() {
    }

    public RecordBean(R record) {
        this.record = record;
    }

    @Hl7XmlMapping("typeCode")
    public ActRelationshipType getTypeCode() {
        return (ActRelationshipType) this.typeCode.getValue();
    }

    public void setTypeCode(ActRelationshipType typeCode) {
        this.typeCode.setValue(typeCode);
    }

    @Hl7XmlMapping("contextConductionInd")
    public boolean isContextConductionInd() {
        return this.contextConductionInd.getValue();
    }

    public void setContextConductionInd(boolean contextConductionInd) {
        this.contextConductionInd.setValue(contextConductionInd);
    }

    @Hl7XmlMapping("act")
    public R getRecord() {
        return this.record;
    }

    public void setRecord(R record) {
        this.record = record;
    }
}
