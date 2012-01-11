/**
 * Copyright 2012 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprescription;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.ActTherapyDurationWorkingListCode;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.PrescriptionDispenseFilterCode;
import ca.infoway.messagebuilder.domainvalue.SymptomValue;
import ca.infoway.messagebuilder.model.newfoundland.cerx.PatientQueryCriteria;

public class MedPrescriptionWithHistoryAndDispensesQueryCriteriaBean extends PatientQueryCriteria {

    private static final long serialVersionUID = 1822382334871547099L;

    private IVL<TS, Interval<Date>> amendedInTimeRange = new IVLImpl<TS, Interval<Date>>();

    private BL includeEventHistoryIndicator = new BLImpl(false);

    private BL includeIssuesIndicator = new BLImpl(false);

    private BL includeNotesIndicator = new BLImpl(false);

    private BL includePendingChangesIndicator = new BLImpl(false);

    private TS patientBirthDate = new TSImpl();

    private CD patientGender = new CDImpl();

    private II patientId = new IIImpl();

    private PN patientName = new PNImpl();

    private II prescriptionOrderNumber = new IIImpl();

    private final List<CV> rxDispenseIndicator = Collections.synchronizedList(new ArrayList<CV>());

    private CD symptomCode = new CDImpl();

    private CD treatmentType = new CDImpl();

    /**
	 * Indicates that the returned records should be filtered to only include those which have been 
	 * amended in some way (had status changed, been annotated, prescription was dispensed, etc.) 
	 * within the indicated time-period. This will commonly be used to retrieve everything that has been amended since xxx.
	 * 
	 * Allows the requester to specify the event period of interest for the retrieval of medication records.
	 * 
	 * Useful for constraining run-away queries.
	 */
    @Hl7XmlMapping("amendedInTimeRange/value")
    public Interval<Date> getAmendedInTimeRange() {
        return this.amendedInTimeRange.getValue();
    }

    public void setAmendedInTimeRange(Interval<Date> amendedInTimeRange) {
        this.amendedInTimeRange.setValue(amendedInTimeRange);
    }

    @Hl7XmlMapping("includeEventHistoryIndicator/value")
    public boolean isIncludeEventHistoryIndicator() {
        return this.includeEventHistoryIndicator.getValue();
    }

    public void setIncludeEventHistoryIndicator(boolean includeEventHistoryIndicator) {
        this.includeEventHistoryIndicator.setValue(includeEventHistoryIndicator);
    }

    @Hl7XmlMapping("includeIssuesIndicator/value")
    public boolean isIncludeIssuesIndicator() {
        return this.includeIssuesIndicator.getValue();
    }

    public void setIncludeIssuesIndicator(boolean includeIssuesIndicator) {
        this.includeIssuesIndicator.setValue(includeIssuesIndicator);
    }

    @Hl7XmlMapping("includeNotesIndicator/value")
    public boolean isIncludeNotesIndicator() {
        return this.includeNotesIndicator.getValue();
    }

    public void setIncludeNotesIndicator(boolean includeNotesIndicator) {
        this.includeNotesIndicator.setValue(includeNotesIndicator);
    }

    @Hl7XmlMapping("includePendingChangesIndicator/value")
    public boolean isIncludePendingChangesIndicator() {
        return this.includePendingChangesIndicator.getValue();
    }

    public void setIncludePendingChangesIndicator(boolean includePendingChangesIndicator) {
        this.includePendingChangesIndicator.setValue(includePendingChangesIndicator);
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

    /**
	 * Identifier of the prescription for which detailed information is required.
	 * 
	 * The result set will be filtered to only the specific prescription.
	 * 
	 * Identifies the prescription that is to be retrieved.
	 */
    @Hl7XmlMapping("prescriptionOrderNumber/value")
    public Identifier getPrescriptionOrderNumber() {
        return this.prescriptionOrderNumber.getValue();
    }

    public void setPrescriptionOrderNumber(Identifier prescriptionOrderNumber) {
        this.prescriptionOrderNumber.setValue(prescriptionOrderNumber);
    }

    /**
	 * A coded value indicating the dispensing (fill) status of the prescription to be included in the result set. 
	 * Rx Dispense Indicators include: ND (Never Dispensed), DRR (Dispensed with Refills Remaining), etc.
	 *
	 * The repetition of 3 allows for retrieval based on all three Rx Dispense Indicators.
	 * 
	 * Allows for finer sub-set of prescriptions to be retrieved based on the fill status of the prescription.
	 */
    @Hl7XmlMapping("rxDispenseIndicator/value")
    public List<PrescriptionDispenseFilterCode> getRxDispenseIndicator() {
    	return new RawListWrapper<CV, PrescriptionDispenseFilterCode>(this.rxDispenseIndicator, CVImpl.class);
    }

    @Hl7XmlMapping("symptomCode/value")
    public SymptomValue getSymptomCode() {
        return (SymptomValue) this.symptomCode.getValue();
    }

    public void setSymptomCode(SymptomValue symptomCode) {
        this.symptomCode.setValue(symptomCode);
    }

    @Hl7XmlMapping("treatmentType/value")
    public ActTherapyDurationWorkingListCode getTreatmentType() {
        return (ActTherapyDurationWorkingListCode) this.treatmentType.getValue();
    }

    public void setTreatmentType(ActTherapyDurationWorkingListCode treatmentType) {
        this.treatmentType.setValue(treatmentType);
    }
}
