/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.x_SubstitutionConditionNoneOrUnconditional;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"COCT_MT260010CA.Location","COCT_MT260020CA.Location","COCT_MT260030CA.Location","COMT_MT300003CA.Location","POIZ_MT030050CA.Location","POIZ_MT030060CA.Location","POIZ_MT060150CA.Location","PORX_MT010110CA.Location2","PORX_MT010120CA.Location2","PORX_MT010140CA.Location","PORX_MT030040CA.Location","PORX_MT030040CA.Location2","PORX_MT060010CA.Location","PORX_MT060020CA.Location","PORX_MT060040CA.Location","PORX_MT060040CA.Location2","PORX_MT060040CA.Location3","PORX_MT060040CA.Location4","PORX_MT060060CA.Location","PORX_MT060060CA.Location2","PORX_MT060090CA.Location","PORX_MT060100CA.Location","PORX_MT060160CA.Location","PORX_MT060160CA.Location2","PORX_MT060160CA.Location3","PORX_MT060160CA.Location4","PORX_MT060160CA.Location5","PORX_MT060190CA.Location","PORX_MT060190CA.Location2","PORX_MT060190CA.Location3","PORX_MT060190CA.Location4","PORX_MT060210CA.Location2","PORX_MT060340CA.Location","PORX_MT060340CA.Location2","PORX_MT060340CA.Location3","PORX_MT060340CA.Location4","REPC_MT000005CA.Location","REPC_MT000006CA.Location","REPC_MT000009CA.Location","REPC_MT210001CA.Location3","REPC_MT210002CA.Location3","REPC_MT210003CA.Location3","REPC_MT220001CA.Location2","REPC_MT220002CA.Location2","REPC_MT220003CA.Location2","REPC_MT230001CA.Location","REPC_MT230002CA.Location","REPC_MT230003CA.Location","REPC_MT410001CA.Location","REPC_MT410003CA.Location","REPC_MT420001CA.Location","REPC_MT420003CA.Location","REPC_MT500001CA.Location","REPC_MT500002CA.Location","REPC_MT500003CA.Location","REPC_MT500004CA.Location","REPC_MT610001CA.Location","REPC_MT610002CA.Location"})
public class OccurredAtBean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private ServiceDeliveryLocation_2Bean serviceDeliveryLocation;
    private IVL<TS, Interval<Date>> toBePickedUpWhen = new IVLImpl<TS, Interval<Date>>();
    private CV dispenseFacilityNotAssignableIndicator = new CVImpl();

    @Hl7XmlMapping({"serviceDeliveryLocation"})
    public ServiceDeliveryLocation_2Bean getServiceDeliveryLocation() {
        return this.serviceDeliveryLocation;
    }
    public void setServiceDeliveryLocation(ServiceDeliveryLocation_2Bean serviceDeliveryLocation) {
        this.serviceDeliveryLocation = serviceDeliveryLocation;
    }

    @Hl7XmlMapping({"time"})
    public Interval<Date> getToBePickedUpWhen() {
        return this.toBePickedUpWhen.getValue();
    }
    public void setToBePickedUpWhen(Interval<Date> toBePickedUpWhen) {
        this.toBePickedUpWhen.setValue(toBePickedUpWhen);
    }

    @Hl7XmlMapping({"substitutionConditionCode"})
    public x_SubstitutionConditionNoneOrUnconditional getDispenseFacilityNotAssignableIndicator() {
        return (x_SubstitutionConditionNoneOrUnconditional) this.dispenseFacilityNotAssignableIndicator.getValue();
    }
    public void setDispenseFacilityNotAssignableIndicator(x_SubstitutionConditionNoneOrUnconditional dispenseFacilityNotAssignableIndicator) {
        this.dispenseFacilityNotAssignableIndicator.setValue(dispenseFacilityNotAssignableIndicator);
    }

}
