/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprofile;

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
import ca.infoway.messagebuilder.model.newfoundland.MostRecentByDrugIndicatorable;
import ca.infoway.messagebuilder.model.newfoundland.cerx.PatientQueryCriteria;

@Hl7PartTypeMapping({ "PORX_MT060200CA.ParameterList" })
public class MedicationProfileSummaryQueryCriteriaBean extends PatientQueryCriteria implements MostRecentByDrugIndicatorable {

    private static final long serialVersionUID = -1676432554228260274L;

    private IVL<TS, Interval<Date>> administrationEffectivePeriod = new IVLImpl<TS, Interval<Date>>();

    private IVL<TS, Interval<Date>> amendedInTimeRange = new IVLImpl<TS, Interval<Date>>();

    private CD issueFilterCode = new CDImpl();

    private BL mostRecentByDrugIndicator = new BLImpl(false);

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
