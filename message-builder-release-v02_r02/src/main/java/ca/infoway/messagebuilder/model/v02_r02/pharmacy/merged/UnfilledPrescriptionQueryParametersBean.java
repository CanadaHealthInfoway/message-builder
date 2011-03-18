/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r02.pharmacy.merged;

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



/**
 * <p>UnfilledPrescriptionQueryParameters</p>
 * 
 * <p>PORX_MT060270CA.ParameterList: (no business name)</p>
 * 
 * <p><p>Defines the set of parameters that may be used to 
 * filter the query response.</p></p>
 * 
 * <p><p>Root class for query definition</p></p>
 * 
 * <p>PORX_MT060240CA.ParameterList: Unfilled Prescription 
 * Query Parameters</p>
 * 
 * <p><p>Defines the set of parameters that may be used to 
 * filter the query response.</p></p>
 * 
 * <p><p>Root class for query definition</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT060240CA.ParameterList","PORX_MT060270CA.ParameterList"})
@Hl7RootType
public class UnfilledPrescriptionQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private II prescriberProviderID = new IIImpl();
    private IVL<TS, Interval<Date>> administrationEffectivePeriod = new IVLImpl<TS, Interval<Date>>();
    private List<CV> prescriptionStatuses = new ArrayList<CV>();
    private CV rxDispenseIndicator = new CVImpl();


    /**
     * <p>PrescriberProviderID</p>
     * 
     * <p>D:Prescriber Provider ID</p>
     * 
     * <p><p>Identifier of the prescriber who created and/or 
     * supervised the prescriptions being retrieved.</p><p>The 
     * result set will be filtered to only include records which 
     * were either directly created by this provider, or were 
     * created 'under the supervision' of this provider.</p></p>
     * 
     * <p><p>Identifier of the prescriber who created and/or 
     * supervised the prescriptions being retrieved.</p><p>The 
     * result set will be filtered to only include records which 
     * were either directly created by this provider, or were 
     * created 'under the supervision' of this provider.</p></p>
     * 
     * <p><p>Allows for the retrieval of prescriptions based on a 
     * specific prescriber.</p></p>
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
     * <p>E:Administration Effective Period</p>
     * 
     * <p><p>Indicates the administration period for which the 
     * request/query applies.</p><p>Filter the result set to 
     * include only those medication records (prescription order, 
     * prescription dispense and other active medication) for which 
     * the patient was deemed to be taking the drug within the 
     * specified period.</p></p>
     * 
     * <p><p>Indicates the administration period for which the 
     * request/query applies.</p><p>Filter the result set to 
     * include only those medication records (prescription order, 
     * prescription dispense and other active medication) for which 
     * the patient was deemed to be taking the drug within the 
     * specified period.</p></p>
     * 
     * <p><p>Allows the requester to specify the administration 
     * period of interest for the retrieval. Useful for 
     * constraining run-away queries.</p></p>
     * 
     * <p>D:Administration Effective Period</p>
     * 
     * <p><p>Indicates the administration period for which the 
     * request/query applies.</p><p>Filter the result set to 
     * include only those medication records (prescription order, 
     * prescription dispense and other active medication) for which 
     * the patient was deemed to be taking the drug within the 
     * specified period.</p></p>
     * 
     * <p><p>Indicates the administration period for which the 
     * request/query applies.</p><p>Filter the result set to 
     * include only those medication records (prescription order, 
     * prescription dispense and other active medication) for which 
     * the patient was deemed to be taking the drug within the 
     * specified period.</p></p>
     * 
     * <p><p>Allows the requester to specify the administration 
     * period of interest for the retrieval. Useful for 
     * constraining run-away queries.</p></p>
     */
    @Hl7XmlMapping({"administrationEffectivePeriod/value"})
    public Interval<Date> getAdministrationEffectivePeriod() {
        return this.administrationEffectivePeriod.getValue();
    }
    public void setAdministrationEffectivePeriod(Interval<Date> administrationEffectivePeriod) {
        this.administrationEffectivePeriod.setValue(administrationEffectivePeriod);
    }


    /**
     * <p>PrescriptionStatuses</p>
     * 
     * <p>E:Prescription Statuses</p>
     * 
     * <p><p>Indicates that prescriptions of a specific statuses 
     * are to be included in the result set. Allowable prescription 
     * status codes are: 'ABORTED, ACTIVE', 'COMPLETED', and 
     * 'SUSPENDED'.</p></p>
     * 
     * <p><p>Allows for the retrieval of patient prescriptions and 
     * dispenses based on the lifecycle state of the 
     * prescription.</p></p>
     */
    @Hl7XmlMapping({"prescriptionStatus/value"})
    public List<ActStatus> getPrescriptionStatuses() {
        return new RawListWrapper<CV, ActStatus>(prescriptionStatuses, CVImpl.class);
    }


    /**
     * <p>RxDispenseIndicator</p>
     * 
     * <p>Rx Dispense Indicator</p>
     * 
     * <p><p>A coded value indicating the dispensing (fill) status 
     * of the prescription to be included in the result set. The 
     * only allowable Rx Dispense Indicators is ND (Never 
     * Dispensed).</p></p>
     * 
     * <p><p>Allows for finer sub-set of prescriptions to be 
     * retrieved based on the fill status of the prescription.</p></p>
     */
    @Hl7XmlMapping({"rxDispenseIndicator/value"})
    public PrescriptionDispenseFilterCode getRxDispenseIndicator() {
        return (PrescriptionDispenseFilterCode) this.rxDispenseIndicator.getValue();
    }
    public void setRxDispenseIndicator(PrescriptionDispenseFilterCode rxDispenseIndicator) {
        this.rxDispenseIndicator.setValue(rxDispenseIndicator);
    }

}
