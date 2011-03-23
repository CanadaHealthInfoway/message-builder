package ca.infoway.messagebuilder.model;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.domainvalue.ActStatus;

@Hl7PartTypeMapping({ "MFMI_MT700746CA.Subject2" })
public class RegistrationEventRecordBean<R> extends RecordBean<R> {

    private static final long serialVersionUID = -8457080275476931218L;

    private final CD statusCode = new CDImpl();

    private CustodianBean custodian = new CustodianBean();

    public RegistrationEventRecordBean() {
    }

    public RegistrationEventRecordBean(R record, ActStatus actStatus) {
        setStatusCode(actStatus);
        setRecord(record);
    }

    @Override
    @Hl7XmlMapping("registrationEvent/subject/registeredRole")
    public R getRecord() {
        return super.getRecord();
    }

    @Hl7XmlMapping("registrationEvent/statusCode")
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }

    @Hl7XmlMapping("registrationEvent/custodian")
    public CustodianBean getCustodian() {
        return this.custodian;
    }

    public void setCustodian(CustodianBean custodian) {
        this.custodian = custodian;
    }
}
