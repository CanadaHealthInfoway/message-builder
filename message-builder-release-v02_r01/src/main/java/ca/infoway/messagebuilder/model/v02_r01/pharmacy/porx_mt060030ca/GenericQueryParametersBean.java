/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.pharmacy.porx_mt060030ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.IssueFilterCode;
import ca.infoway.messagebuilder.domainvalue.PrescriptionDispenseFilterCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"PORX_MT060030CA.ParameterList"})
@Hl7RootType
public class GenericQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private CV issueFilterCode = new CVImpl();
    private BL mostRecentByDeviceIndicator = new BLImpl();
    private BL mostRecentDispenseForEachRxIndicator = new BLImpl();
    private List<CV> rxDispenserIndicators = new ArrayList<CV>();
    private IVL<TS, Interval<Date>> usageEffectivePeriod = new IVLImpl<TS, Interval<Date>>();


    /**
     * <p>Issue Filter Code</p>
     */
    @Hl7XmlMapping({"issueFilterCode/value"})
    public IssueFilterCode getIssueFilterCode() {
        return (IssueFilterCode) this.issueFilterCode.getValue();
    }
    public void setIssueFilterCode(IssueFilterCode issueFilterCode) {
        this.issueFilterCode.setValue(issueFilterCode);
    }


    /**
     * <p>Most Recent By Device Indicator</p>
     */
    @Hl7XmlMapping({"mostRecentByDeviceIndicator/value"})
    public Boolean getMostRecentByDeviceIndicator() {
        return this.mostRecentByDeviceIndicator.getValue();
    }
    public void setMostRecentByDeviceIndicator(Boolean mostRecentByDeviceIndicator) {
        this.mostRecentByDeviceIndicator.setValue(mostRecentByDeviceIndicator);
    }


    /**
     * <p>Most Recent Dispense for each Rx Indicator</p>
     */
    @Hl7XmlMapping({"mostRecentDispenseForEachRxIndicator/value"})
    public Boolean getMostRecentDispenseForEachRxIndicator() {
        return this.mostRecentDispenseForEachRxIndicator.getValue();
    }
    public void setMostRecentDispenseForEachRxIndicator(Boolean mostRecentDispenseForEachRxIndicator) {
        this.mostRecentDispenseForEachRxIndicator.setValue(mostRecentDispenseForEachRxIndicator);
    }


    /**
     * <p>Rx Dispenser Indicators</p>
     */
    @Hl7XmlMapping({"rxDispenseIndicator/value"})
    public List<PrescriptionDispenseFilterCode> getRxDispenserIndicators() {
        return new RawListWrapper<CV, PrescriptionDispenseFilterCode>(rxDispenserIndicators, CVImpl.class);
    }


    /**
     * <p>D:Usage Effective Period</p>
     */
    @Hl7XmlMapping({"usageEffectivePeriod/value"})
    public Interval<Date> getUsageEffectivePeriod() {
        return this.usageEffectivePeriod.getValue();
    }
    public void setUsageEffectivePeriod(Interval<Date> usageEffectivePeriod) {
        this.usageEffectivePeriod.setValue(usageEffectivePeriod);
    }

}
