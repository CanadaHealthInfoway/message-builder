/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.coct_mt080100ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"COCT_MT080100CA.TransportationEvent"})
public class SpecimenProcessStepsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private CS transportationStatus = new CSImpl();
    private IVL<TS, Interval<Date>> transportationDateTime = new IVLImpl<TS, Interval<Date>>();
    private CV transportationType = new CVImpl();


    /**
     * <p>R:Transportation Status</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getTransportationStatus() {
        return (ActStatus) this.transportationStatus.getValue();
    }
    public void setTransportationStatus(ActStatus transportationStatus) {
        this.transportationStatus.setValue(transportationStatus);
    }


    /**
     * <p>Q:Transportation Date/Time</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getTransportationDateTime() {
        return this.transportationDateTime.getValue();
    }
    public void setTransportationDateTime(Interval<Date> transportationDateTime) {
        this.transportationDateTime.setValue(transportationDateTime);
    }


    /**
     * <p>P:Transportation Type</p>
     */
    @Hl7XmlMapping({"code"})
    public Code getTransportationType() {
        return (Code) this.transportationType.getValue();
    }
    public void setTransportationType(Code transportationType) {
        this.transportationType.setValue(transportationType);
    }

}
