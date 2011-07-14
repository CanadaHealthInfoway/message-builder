/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.porx_mt060240ca;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.PrescriptionDispenseFilterCode;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Unfilled Prescription Query Parameters</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Defines the 
 * set of parameters that may be used to filter the query 
 * response.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Root class 
 * for query definition</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT060240CA.ParameterList"})
@Hl7RootType
public class UnfilledPrescriptionQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20110714L;
    private IVL<TS, Interval<Date>> administrationEffectivePeriod = new IVLImpl<TS, Interval<Date>>();
    private TS patientBirthDate = new TSImpl();
    private CV patientGender = new CVImpl();
    private II patientID = new IIImpl();
    private PN patientName = new PNImpl();
    private List<CV> prescriptionStatuses = new ArrayList<CV>();
    private CV rxDispenseIndicator = new CVImpl();


    /**
     * <p>D:Administration Effective Period</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the administration period for which the request/query 
     * applies.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Filter the result 
     * set to include only those medication records (prescription 
     * order, prescription dispense and other active medication) 
     * for which the patient was deemed to be taking the drug 
     * within the specified period.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the administration period for which the request/query 
     * applies.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Filter the result 
     * set to include only those medication records (prescription 
     * order, prescription dispense and other active medication) 
     * for which the patient was deemed to be taking the drug 
     * within the specified period.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows the 
     * requester to specify the administration period of interest 
     * for the retrieval. Useful for constraining run-away 
     * queries.</p></p>
     */
    @Hl7XmlMapping({"administrationEffectivePeriod/value"})
    public Interval<Date> getAdministrationEffectivePeriod() {
        return this.administrationEffectivePeriod.getValue();
    }
    public void setAdministrationEffectivePeriod(Interval<Date> administrationEffectivePeriod) {
        this.administrationEffectivePeriod.setValue(administrationEffectivePeriod);
    }


    /**
     * <p>Patient Birth Date</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the date on which the patient was born.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Used to 
     * confirm the identity of the patient for the query and is 
     * therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"patientBirthDate/value"})
    public Date getPatientBirthDate() {
        return this.patientBirthDate.getValue();
    }
    public void setPatientBirthDate(Date patientBirthDate) {
        this.patientBirthDate.setValue(patientBirthDate);
    }


    /**
     * <p>Patient Gender</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the gender (sex) of the patient.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Used to 
     * confirm the identity of the patient for the query and is 
     * therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"patientGender/value"})
    public AdministrativeGender getPatientGender() {
        return (AdministrativeGender) this.patientGender.getValue();
    }
    public void setPatientGender(AdministrativeGender patientGender) {
        this.patientGender.setValue(patientGender);
    }


    /**
     * <p>B:Patient ID</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Identifier 
     * of the patient who is the subject of the patient medication 
     * query. Filter the result set to include only those records 
     * pertaining to the patient with this Id.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
     * filtering of result set by patient Id. This is a mandatory 
     * field because a patient must be specified for the query to 
     * be valid</p></p>
     */
    @Hl7XmlMapping({"patientID/value"})
    public Identifier getPatientID() {
        return this.patientID.getValue();
    }
    public void setPatientID(Identifier patientID) {
        this.patientID.setValue(patientID);
    }


    /**
     * <p>C:Patient Name</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The name of 
     * the patient who is the subject of the patient medication 
     * query.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Filter the result 
     * set to include only those records pertaining to the patient 
     * with this name.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The name of 
     * the patient who is the subject of the patient medication 
     * query.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Filter the result 
     * set to include only those records pertaining to the patient 
     * with this name.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
     * filtering of result set by patient name. This is a mandatory 
     * field because a patient name must match the patient Id for 
     * the query to be valid.</p></p>
     */
    @Hl7XmlMapping({"patientName/value"})
    public PersonName getPatientName() {
        return this.patientName.getValue();
    }
    public void setPatientName(PersonName patientName) {
        this.patientName.setValue(patientName);
    }


    /**
     * <p>E:Prescription Statuses</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * that prescriptions of a specific statuses are to be included 
     * in the result set. Allowable prescription status codes are: 
     * 'ABORTED, ACTIVE', 'COMPLETED', and 'SUSPENDED'.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows for 
     * the retrieval of patient prescriptions and dispenses based 
     * on the lifecycle state of the prescription.</p></p>
     */
    @Hl7XmlMapping({"prescriptionStatus/value"})
    public List<ActStatus> getPrescriptionStatuses() {
        return new RawListWrapper<CV, ActStatus>(prescriptionStatuses, CVImpl.class);
    }


    /**
     * <p>Rx Dispense Indicator</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A coded 
     * value indicating the dispensing (fill) status of the 
     * prescription to be included in the result set. The only 
     * allowable Rx Dispense Indicators is ND (Never 
     * Dispensed).</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows for 
     * finer sub-set of prescriptions to be retrieved based on the 
     * fill status of the prescription.</p></p>
     */
    @Hl7XmlMapping({"rxDispenseIndicator/value"})
    public PrescriptionDispenseFilterCode getRxDispenseIndicator() {
        return (PrescriptionDispenseFilterCode) this.rxDispenseIndicator.getValue();
    }
    public void setRxDispenseIndicator(PrescriptionDispenseFilterCode rxDispenseIndicator) {
        this.rxDispenseIndicator.setValue(rxDispenseIndicator);
    }

}
