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

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.ActUncertainty;
import ca.infoway.messagebuilder.domainvalue.IntoleranceValue;
import ca.infoway.messagebuilder.domainvalue.ObservationIntoleranceType;
import ca.infoway.messagebuilder.domainvalue.SeverityObservation;
import ca.infoway.messagebuilder.domainvalue.x_NormalRestrictedTabooConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt120600ca.NotesBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;



@Hl7PartTypeMapping({"REPC_MT000001CA.IntoleranceCondition","REPC_MT000013CA.IntoleranceCondition"})
@Hl7RootType
public class AllergyIntoleranceBean extends MessagePartBean {

    private CD<ObservationIntoleranceType> allergyIntoleranceType = new CDImpl<ObservationIntoleranceType>();
    private BL allergyIntoleranceRefuted = new BLImpl();
    private CS<ActStatus> allergyIntoleranceStatus = new CSImpl<ActStatus>();
    private TS allergyIntoleranceDate = new TSImpl();
    private SET<CV<x_NormalRestrictedTabooConfidentialityKind>, x_NormalRestrictedTabooConfidentialityKind> allergyIntoleranceMaskingIndicators = new SETImpl<CV<x_NormalRestrictedTabooConfidentialityKind>, x_NormalRestrictedTabooConfidentialityKind>(CVImpl.class);
    private CV<ActUncertainty> confirmedIndicator = new CVImpl<ActUncertainty>();
    private CV<IntoleranceValue> agent = new CVImpl<IntoleranceValue>();
    private Informant_1Bean informant;
    private List<RecordsBean> supportRecords = new ArrayList<RecordsBean>();
    private NotesBean subjectOf1Annotation;
    private CV<SeverityObservation> severityLevel = new CVImpl<SeverityObservation>();
    private II allergyIntoleranceRecordId = new IIImpl();
    private CV<SeverityObservation> subjectOfSeverityObservationValue = new CVImpl<SeverityObservation>();

    @Hl7XmlMapping({"code"})
    public ObservationIntoleranceType getAllergyIntoleranceType() {
        return this.allergyIntoleranceType.getValue();
    }
    public void setAllergyIntoleranceType(ObservationIntoleranceType allergyIntoleranceType) {
        this.allergyIntoleranceType.setValue(allergyIntoleranceType);
    }

    @Hl7XmlMapping({"negationInd"})
    public java.lang.Boolean getAllergyIntoleranceRefuted() {
        return this.allergyIntoleranceRefuted.getValue();
    }
    public void setAllergyIntoleranceRefuted(java.lang.Boolean allergyIntoleranceRefuted) {
        this.allergyIntoleranceRefuted.setValue(allergyIntoleranceRefuted);
    }

    @Hl7XmlMapping({"statusCode"})
    public ActStatus getAllergyIntoleranceStatus() {
        return this.allergyIntoleranceStatus.getValue();
    }
    public void setAllergyIntoleranceStatus(ActStatus allergyIntoleranceStatus) {
        this.allergyIntoleranceStatus.setValue(allergyIntoleranceStatus);
    }

    @Hl7XmlMapping({"effectiveTime"})
    public Date getAllergyIntoleranceDate() {
        return this.allergyIntoleranceDate.getValue();
    }
    public void setAllergyIntoleranceDate(Date allergyIntoleranceDate) {
        this.allergyIntoleranceDate.setValue(allergyIntoleranceDate);
    }

    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_NormalRestrictedTabooConfidentialityKind> getAllergyIntoleranceMaskingIndicators() {
        return this.allergyIntoleranceMaskingIndicators.rawSet();
    }

    @Hl7XmlMapping({"uncertaintyCode"})
    public ActUncertainty getConfirmedIndicator() {
        return this.confirmedIndicator.getValue();
    }
    public void setConfirmedIndicator(ActUncertainty confirmedIndicator) {
        this.confirmedIndicator.setValue(confirmedIndicator);
    }

    @Hl7XmlMapping({"value"})
    public IntoleranceValue getAgent() {
        return this.agent.getValue();
    }
    public void setAgent(IntoleranceValue agent) {
        this.agent.setValue(agent);
    }

    @Hl7XmlMapping({"informant"})
    public Informant_1Bean getInformant() {
        return this.informant;
    }
    public void setInformant(Informant_1Bean informant) {
        this.informant = informant;
    }

    @Hl7XmlMapping({"support/records"})
    public List<RecordsBean> getSupportRecords() {
        return this.supportRecords;
    }

    @Hl7XmlMapping({"subjectOf1/annotation"})
    public NotesBean getSubjectOf1Annotation() {
        return this.subjectOf1Annotation;
    }
    public void setSubjectOf1Annotation(NotesBean subjectOf1Annotation) {
        this.subjectOf1Annotation = subjectOf1Annotation;
    }

    @Hl7XmlMapping({"subjectOf2/severityObservation/value"})
    public SeverityObservation getSeverityLevel() {
        return this.severityLevel.getValue();
    }
    public void setSeverityLevel(SeverityObservation severityLevel) {
        this.severityLevel.setValue(severityLevel);
    }

    @Hl7XmlMapping({"id"})
    public Identifier getAllergyIntoleranceRecordId() {
        return this.allergyIntoleranceRecordId.getValue();
    }
    public void setAllergyIntoleranceRecordId(Identifier allergyIntoleranceRecordId) {
        this.allergyIntoleranceRecordId.setValue(allergyIntoleranceRecordId);
    }

    @Hl7XmlMapping({"subjectOf/severityObservation/value"})
    public SeverityObservation getSubjectOfSeverityObservationValue() {
        return this.subjectOfSeverityObservationValue.getValue();
    }
    public void setSubjectOfSeverityObservationValue(SeverityObservation subjectOfSeverityObservationValue) {
        this.subjectOfSeverityObservationValue.setValue(subjectOfSeverityObservationValue);
    }

}
