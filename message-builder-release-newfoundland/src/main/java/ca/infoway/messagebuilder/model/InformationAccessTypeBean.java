package ca.infoway.messagebuilder.model;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.domainvalue.ActInformationAccessTypeCode;

@Hl7PartTypeMapping({ "COCT_MT470000CA.Subject3", "RCMR_MT010001CA.Subject2" })
public class InformationAccessTypeBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = -1127816597472476758L;

    private CD code = new CDImpl();

    @Hl7XmlMapping({ "actDefinition/code", "recordType/code" })
    public ActInformationAccessTypeCode getCode() {
        return (ActInformationAccessTypeCode) this.code.getValue();
    }

    public void setCode(ActInformationAccessTypeCode code) {
        this.code.setValue(code);
    }
}
