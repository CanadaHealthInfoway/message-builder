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

package ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
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
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.IssueFilterCode;
import ca.infoway.messagebuilder.domainvalue.PrescriptionDispenseFilterCode;
import ca.infoway.messagebuilder.model.newfoundland.cerx.PatientQueryCriteria;

@Hl7PartTypeMapping({ "PORX_MT060070CA.ParameterList" })
public class DevicePrescriptionSummaryQueryCriteriaBean extends PatientQueryCriteria {

    private static final long serialVersionUID = -7498117037585753494L;

    private final TS patientBirthDate = new TSImpl();

    private final CD patientGender = new CDImpl();

    private final II patientId = new IIImpl();

    private final PN patientName = new PNImpl();

    private final IVL<TS, Interval<Date>> amendedInTimeRange = new IVLImpl<TS, Interval<Date>>();

    private final CD issueFilterCode = new CDImpl();

    private final BL mostRecentByDeviceIndicator = new BLImpl(false);

    private final List<CV> rxDispenseIndicator = Collections.synchronizedList(new ArrayList<CV>());

    private final IVL<TS, Interval<Date>> usageEffectivePeriod = new IVLImpl<TS, Interval<Date>>();
    
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

    @Hl7XmlMapping("amendedInTimeRange/value")
    public Interval<Date> getAmendedInTimeRange() {
        return this.amendedInTimeRange.getValue();
    }

    public void setAmendedInTimeRange(Interval<Date> amendedInTimeRange) {
        this.amendedInTimeRange.setValue(amendedInTimeRange);
    }

    @Hl7XmlMapping("issueFilterCode/value")
    public IssueFilterCode getIssueFilterCode() {
        return (IssueFilterCode) this.issueFilterCode.getValue();
    }

    public void setIssueFilterCode(IssueFilterCode issueFilterCode) {
        this.issueFilterCode.setValue(issueFilterCode);
    }

    @Hl7XmlMapping("mostRecentByDeviceIndicator/value")
    public boolean isMostRecentByDeviceIndicator() {
        return this.mostRecentByDeviceIndicator.getValue();
    }

    public void setMostRecentByDeviceIndicator(boolean mostRecentByDeviceIndicator) {
        this.mostRecentByDeviceIndicator.setValue(mostRecentByDeviceIndicator);
    }

    @Hl7XmlMapping("rxDispenseIndicator/value")
    public List<PrescriptionDispenseFilterCode> getRxDispenseIndicator() {
    	return new RawListWrapper<CV, PrescriptionDispenseFilterCode>(this.rxDispenseIndicator, CVImpl.class);
    }

    @Hl7XmlMapping("usageEffectivePeriod/value")
    public void setUsageEffectivePeriod(Interval<Date> usageEffectivePeriod) {
        this.usageEffectivePeriod.setValue(usageEffectivePeriod);
    }

    public Interval<Date> getUsageEffectivePeriod() {
        return this.usageEffectivePeriod.getValue();
    }
}
