/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.PrescriptionDispenseFilterCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"PORX_MT060240CA.ParameterList","PORX_MT060270CA.ParameterList"})
@Hl7RootType
public class UnfilledPrescriptionQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private II prescriberProviderID = new IIImpl();
    private IVL<TS, Interval<Date>> administrationEffectivePeriod = new IVLImpl<TS, Interval<Date>>();
    private CV rxDispenseIndicator = new CVImpl();
    private List<CV> prescriptionStatuses = new ArrayList<CV>();


    /**
     * <p>PrescriberProviderID</p>
     * 
     * <p>D:Prescriber Provider ID</p>
     */
    @Hl7XmlMapping({"prescriberProviderID/value"})
    public Identifier getPrescriberProviderID() {
        return this.prescriberProviderID.getValue();
    }
    public void setPrescriberProviderID(Identifier prescriberProviderID) {
        this.prescriberProviderID.setValue(prescriberProviderID);
    }


    /**
     * <p>AdministrationEffectivePeriod</p>
     * 
     * <p>D:Administration Effective Period</p>
     * 
     * <p>E:Administration Effective Period</p>
     */
    @Hl7XmlMapping({"administrationEffectivePeriod/value"})
    public Interval<Date> getAdministrationEffectivePeriod() {
        return this.administrationEffectivePeriod.getValue();
    }
    public void setAdministrationEffectivePeriod(Interval<Date> administrationEffectivePeriod) {
        this.administrationEffectivePeriod.setValue(administrationEffectivePeriod);
    }


    /**
     * <p>RxDispenseIndicator</p>
     * 
     * <p>Rx Dispense Indicator</p>
     */
    @Hl7XmlMapping({"rxDispenseIndicator/value"})
    public PrescriptionDispenseFilterCode getRxDispenseIndicator() {
        return (PrescriptionDispenseFilterCode) this.rxDispenseIndicator.getValue();
    }
    public void setRxDispenseIndicator(PrescriptionDispenseFilterCode rxDispenseIndicator) {
        this.rxDispenseIndicator.setValue(rxDispenseIndicator);
    }


    /**
     * <p>PrescriptionStatuses</p>
     * 
     * <p>E:Prescription Statuses</p>
     */
    @Hl7XmlMapping({"prescriptionStatus/value"})
    public List<ActStatus> getPrescriptionStatuses() {
        return new RawListWrapper<CV, ActStatus>(prescriptionStatuses, CVImpl.class);
    }

}
