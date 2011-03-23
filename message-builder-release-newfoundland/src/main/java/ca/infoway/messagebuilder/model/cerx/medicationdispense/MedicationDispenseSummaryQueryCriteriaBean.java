package ca.infoway.messagebuilder.model.cerx.medicationdispense;

import java.util.Date;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.IssueFilterCode;
import ca.infoway.messagebuilder.model.MostRecentByDrugIndicatorable;
import ca.infoway.messagebuilder.model.cerx.MostRecentDispenseForEachRxIndicatorable;
import ca.infoway.messagebuilder.model.cerx.PatientQueryCriteria;

@Hl7PartTypeMapping({ "PORX_MT060110CA.ParameterList" })
public class MedicationDispenseSummaryQueryCriteriaBean extends PatientQueryCriteria implements MostRecentByDrugIndicatorable, MostRecentDispenseForEachRxIndicatorable {

    private static final long serialVersionUID = 8768937290028575285L;

    private IVL<TS, Interval<Date>> administrationEffectivePeriod = new IVLImpl<TS, Interval<Date>>();

    private CD issueFilterCode = new CDImpl();

    private BL mostRecentByDrugIndicator = new BLImpl(false);

    private BL mostRecentDispenseForEachRxIndicator = new BLImpl(false);

    private TS patientBirthDate = new TSImpl();

    private CD patientGender = new CDImpl();

    private II patientId = new IIImpl();

    private PN patientName = new PNImpl();

    /**
     * Indicates the administration period for which the request/query applies.
     * 
	 * Filter the result set to include only those medication records (prescription order, prescription 
	 * dispense and other active medication) for which the patient was deemed to be taking the drug 
	 * within the specified period.
	 * 
	 * Allows the requester to specify the administration period of interest for the retrieval. 
	 * Useful for constraining run-away queries.
     */
    @Hl7XmlMapping("administrationEffectivePeriod/value")
    public Interval<Date> getAdministrationEffectivePeriod() {
        return this.administrationEffectivePeriod.getValue();
    }

    public void setAdministrationEffectivePeriod(Interval<Date> administrationEffectivePeriod) {
        this.administrationEffectivePeriod.setValue(administrationEffectivePeriod);
    }

    /**
	 * Indicates whether records to be returned (e.g. prescription order, prescription dispense and/or other medication) should 
	 * be filtered to those with at least one persistent un-managed issue (against the record), with at least one persistent issues 
	 * or should return all records, independent of the presence of persistent issues.
	 * 
	 * By filtering returned records to include only those which have unmanaged issues or any issues at all, allows a provider 
	 * to focus on those aspects of care where extra attention is needed. Because the attribute must be known, it is mandatory.
	 **/
    @Hl7XmlMapping("issueFilterCode/value")
    public IssueFilterCode getIssueFilterCode() {
        return (IssueFilterCode) this.issueFilterCode.getValue();
    }

    public void setIssueFilterCode(IssueFilterCode issueFilterCode) {
        this.issueFilterCode.setValue(issueFilterCode);
    }

    /**
	 * Indicates whether or not the medication records are to be retrieved based on the most recent by Drug Code. 
	 * If true, only the most recent prescription, dispense or other active medication for a particular drug generic 
	 * classification will be returned. The default is 'FALSE' indicating that retrieval of prescription, dispense 
	 * and other active medication records should not be limited to one per drug.
	 *
	 * Helps decrease the volume of records returned, while still maintaining information on all drugs that the patient is on.
	 *
	 * Because this is a boolean attribute whose value must be known to evaluate the query, the attribute is mandatory.
	 */
    @Hl7XmlMapping("mostRecentByDrugIndicator/value")
    public boolean isMostRecentByDrugIndicator() {
        return this.mostRecentByDrugIndicator.getValue();
    }

    public void setMostRecentByDrugIndicator(boolean mostRecentByDrugIndicator) {
        this.mostRecentByDrugIndicator.setValue(mostRecentByDrugIndicator);
    }

    /**
	 * Indicates whether or not prescription dispenses returned on a query should be limited to only the most recent dispense 
	 * for a prescription order.
	 * 
	 * Allows for the returning of at most one prescription dispense record per a prescription.
	 * 
	 * The default is 'TRUE' indicating that retrieval should be for only the most recent dispense for a prescription is to be 
	 * included in a query result.
	 * 
	 * Helps to trim down volume of query response by eliminating multiple prescription dispenses for the same prescription 
	 * order.
	 * 
	 * Because this is a boolean attribute whose value must be known to evaluate the query, the attribute is mandatory.
	 */
    @Hl7XmlMapping("mostRecentDispenseForEachRxIndicator/value")
    public boolean isMostRecentDispenseForEachRxIndicator() {
        return this.mostRecentDispenseForEachRxIndicator.getValue();
    }

    public void setMostRecentDispenseForEachRxIndicator(boolean mostRecentDispenseForEachRxIndicator) {
        this.mostRecentDispenseForEachRxIndicator.setValue(mostRecentDispenseForEachRxIndicator);
    }

    @Override
    @Hl7XmlMapping("patientBirthDate/value")
    public Date getPatientBirthDate() {
        return this.patientBirthDate.getValue();
    }

    public void setPatientBirthDate(Date patientBirthDate) {
        this.patientBirthDate.setValue(patientBirthDate);
    }

    @Override
    @Hl7XmlMapping("patientGender/value")
    public AdministrativeGender getPatientGender() {
        return (AdministrativeGender) this.patientGender.getValue();
    }

    public void setPatientGender(AdministrativeGender patientGender) {
        this.patientGender.setValue(patientGender);
    }

    @Override
    @Hl7XmlMapping("patientID/value")
    public Identifier getPatientId() {
        return this.patientId.getValue();
    }

    public void setPatientId(Identifier patientId) {
        this.patientId.setValue(patientId);
    }

    @Override
    @Hl7XmlMapping("patientName/value")
    public PersonName getPatientName() {
        return this.patientName.getValue();
    }

    public void setPatientName(PersonName patientName) {
        this.patientName.setValue(patientName);
    }
}
