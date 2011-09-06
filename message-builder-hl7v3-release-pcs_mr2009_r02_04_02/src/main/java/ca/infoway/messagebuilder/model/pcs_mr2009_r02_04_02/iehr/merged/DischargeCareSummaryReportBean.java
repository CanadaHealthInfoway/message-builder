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

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActCareEventType;
import ca.infoway.messagebuilder.domainvalue.EncounterDischargeDisposition;
import ca.infoway.messagebuilder.domainvalue.x_ActStatusActiveComplete;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.BecauseOfBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.OccurredAtBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>DischargeCareSummaryReport</p>
 * 
 * <p>REPC_MT220001CA.PatientCareProvisionEvent: B: 
 * Discharge/Care Summary Report</p>
 * 
 * <p><p>Discrete information about the encounter, episode or 
 * other event for which the discharge or care report is being 
 * written.</p></p>
 * 
 * <p><p>Provides contextual overview information for searching 
 * and filtering</p></p>
 * 
 * <p>REPC_MT220002CA.PatientCareProvisionEvent: B: 
 * Discharge/Care Summary Report</p>
 * 
 * <p><p>Discrete information about the encounter, episode or 
 * other event for which the discharge or care report is being 
 * written.</p></p>
 * 
 * <p><p>Provides contextual overview information for searching 
 * and filtering</p></p>
 * 
 * <p>REPC_MT220003CA.PatientCareProvisionEvent: B: 
 * Discharge/Care Summary Report</p>
 * 
 * <p><p>Discrete information about the encounter, episode or 
 * other event for which the discharge or care report is being 
 * written.</p></p>
 * 
 * <p><p>Provides contextual overview information for searching 
 * and filtering</p></p>
 */
@Hl7PartTypeMapping({"REPC_MT220001CA.PatientCareProvisionEvent","REPC_MT220002CA.PatientCareProvisionEvent","REPC_MT220003CA.PatientCareProvisionEvent"})
public class DischargeCareSummaryReportBean extends MessagePartBean implements DocumentContent_2 {

    private static final long serialVersionUID = 20110906L;
    private List<BecauseOfBean> reason = new ArrayList<BecauseOfBean>();
    private II reportedOnCareCompositionLink = new IIImpl();
    private CD dischargeCareSummaryReportType = new CDImpl();
    private CS preliminaryFinalIndicator = new CSImpl();
    private IVL<TS, Interval<Date>> dischargeCareSummaryReportPeriod = new IVLImpl<TS, Interval<Date>>();
    private CV dischargeDisposition = new CVImpl();
    private OccurredAtBean location;
    private List<DischargeDiagnosesBean> outcomeConditionEvent = new ArrayList<DischargeDiagnosesBean>();
    private Request_1Bean inFulfillmentOfActRequest;


    @Hl7XmlMapping({"reason"})
    public List<BecauseOfBean> getReason() {
        return this.reason;
    }


    /**
     * <p>ReportedOnCareCompositionLink</p>
     * 
     * <p>M:Reported on Care Composition Link</p>
     * 
     * <p><p>Provides the identifier of the discrete encounter, 
     * episode or care event being reported on.</p></p>
     * 
     * <p><p>Allows for drill-down and for direct association 
     * between the report and the discrete record.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getReportedOnCareCompositionLink() {
        return this.reportedOnCareCompositionLink.getValue();
    }
    public void setReportedOnCareCompositionLink(Identifier reportedOnCareCompositionLink) {
        this.reportedOnCareCompositionLink.setValue(reportedOnCareCompositionLink);
    }


    /**
     * <p>DischargeCareSummaryReportType</p>
     * 
     * <p>C: Discharge/Care Summary Report Type</p>
     * 
     * <p><p>Identifies the type or category Summary Report 
     * represented by this record.</p><p>The discharge / care 
     * report summarizes the events and activities that happened 
     * during care including who is responsible for the care 
     * provided. The report is sent at the termination of care. In 
     * this case, the performer is the sending 
     * provider.</p><p>Examples: Inpatient stay, cardiology, 
     * etc.</p></p>
     * 
     * <p><p>Identifies the type or category Summary Report 
     * represented by this record.</p><p>The discharge / care 
     * report summarizes the events and activities that happened 
     * during care including who is responsible for the care 
     * provided. The report is sent at the termination of care. In 
     * this case, the performer is the sending 
     * provider.</p><p>Examples: Inpatient stay, cardiology, 
     * etc.</p></p>
     * 
     * <p><p>Identifies the type or category Summary Report 
     * represented by this record.</p><p>The discharge / care 
     * report summarizes the events and activities that happened 
     * during care including who is responsible for the care 
     * provided. The report is sent at the termination of care. In 
     * this case, the performer is the sending 
     * provider.</p><p>Examples: Inpatient stay, cardiology, 
     * etc.</p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"code"})
    public ActCareEventType getDischargeCareSummaryReportType() {
        return (ActCareEventType) this.dischargeCareSummaryReportType.getValue();
    }
    public void setDischargeCareSummaryReportType(ActCareEventType dischargeCareSummaryReportType) {
        this.dischargeCareSummaryReportType.setValue(dischargeCareSummaryReportType);
    }


    /**
     * <p>PreliminaryFinalIndicator</p>
     * 
     * <p>D: Preliminary/Final Indicator</p>
     * 
     * <p></p><p>If the status is 'active' it means that the 
     * assessment is ongoing and the report is preliminary. If the 
     * status is 'completed' it means that the assessment is 
     * finished and the report is considered complete.</p></p>
     * 
     * <p></p><p>If the status is 'active' it means that the 
     * assessment is ongoing and the report is preliminary. If the 
     * status is 'completed' it means that the assessment is 
     * finished and the report is considered complete.</p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public x_ActStatusActiveComplete getPreliminaryFinalIndicator() {
        return (x_ActStatusActiveComplete) this.preliminaryFinalIndicator.getValue();
    }
    public void setPreliminaryFinalIndicator(x_ActStatusActiveComplete preliminaryFinalIndicator) {
        this.preliminaryFinalIndicator.setValue(preliminaryFinalIndicator);
    }


    /**
     * <p>DischargeCareSummaryReportPeriod</p>
     * 
     * <p>F: Discharge/Care Summary Report Period</p>
     * 
     * <p><p>Indicates the period of care to which the discharge or 
     * care report applies. For an encounter discharge assessment, 
     * this would be the admit and discharge date.</p></p>
     * 
     * <p><p>Identifies the time-period of relevance to the record 
     * which is useful in filtering and organizing 
     * &quot;time-view&quot; presentations of data. Because the 
     * period covered by a discharge or care summary should always 
     * be known, this attribute is mandatory.</p></p>
     * 
     * <p>F: Discharge/Care Summary Report Period</p>
     * 
     * <p><p>Indicates the period of care to which the discharge or 
     * care report applies. For an encounter discharge assessment, 
     * this would be the admission and discharge date.</p></p>
     * 
     * <p><p>Identifies the time-period of relevance to the record 
     * which is useful in filtering and organizing 
     * &quot;time-view&quot; presentations of data. Because the 
     * period covered by a discharge or care summary should always 
     * be known, this attribute is mandatory.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getDischargeCareSummaryReportPeriod() {
        return this.dischargeCareSummaryReportPeriod.getValue();
    }
    public void setDischargeCareSummaryReportPeriod(Interval<Date> dischargeCareSummaryReportPeriod) {
        this.dischargeCareSummaryReportPeriod.setValue(dischargeCareSummaryReportPeriod);
    }


    /**
     * <p>DischargeDisposition</p>
     * 
     * <p>N:Discharge Disposition</p>
     * 
     * <p><p>Indicates the manner in which the patient left the 
     * encounter or other care event. E.g. 'Deceased', 'Discharged 
     * to home', 'Discharged to isolation'</p></p>
     * 
     * <p><p>May be important in planning subsequent care for the 
     * patient. Something must be said about discharge condition 
     * but in some circumstances the value may not be known. Thus 
     * the attribute is treated as 'populated'.</p></p>
     */
    @Hl7XmlMapping({"dischargeDispositionCode"})
    public EncounterDischargeDisposition getDischargeDisposition() {
        return (EncounterDischargeDisposition) this.dischargeDisposition.getValue();
    }
    public void setDischargeDisposition(EncounterDischargeDisposition dischargeDisposition) {
        this.dischargeDisposition.setValue(dischargeDisposition);
    }


    @Hl7XmlMapping({"location"})
    public OccurredAtBean getLocation() {
        return this.location;
    }
    public void setLocation(OccurredAtBean location) {
        this.location = location;
    }


    @Hl7XmlMapping({"outcome/conditionEvent"})
    public List<DischargeDiagnosesBean> getOutcomeConditionEvent() {
        return this.outcomeConditionEvent;
    }


    @Hl7XmlMapping({"inFulfillmentOf/actRequest"})
    public Request_1Bean getInFulfillmentOfActRequest() {
        return this.inFulfillmentOfActRequest;
    }
    public void setInFulfillmentOfActRequest(Request_1Bean inFulfillmentOfActRequest) {
        this.inFulfillmentOfActRequest = inFulfillmentOfActRequest;
    }

}
