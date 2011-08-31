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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.iehr.merged;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
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
import ca.infoway.messagebuilder.domainvalue.x_NormalRestrictedTabooConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.coct_mt120600ca.NotesBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.merged.AllergyIntoleranceSeverityLevelBean;



@Hl7PartTypeMapping({"REPC_MT000001CA.IntoleranceCondition","REPC_MT000013CA.IntoleranceCondition"})
@Hl7RootType
public class AllergyIntoleranceBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private CD allergyIntoleranceType = new CDImpl();
    private BL allergyIntoleranceRefuted = new BLImpl();
    private CS allergyIntoleranceStatus = new CSImpl();
    private TS allergyIntoleranceDate = new TSImpl();
    private SET<CV, Code> allergyIntoleranceMaskingIndicators = new SETImpl<CV, Code>(CVImpl.class);
    private CV confirmedIndicator = new CVImpl();
    private CV agent = new CVImpl();
    private ReportedByBean informant;
    private List<Records> supportRecords = new ArrayList<Records>();
    private NotesBean subjectOf1Annotation;
    private AllergyIntoleranceSeverityLevelBean subjectOfSeverityObservation;
    private II allergyIntoleranceRecordId = new IIImpl();


    /**
     * <p>AllergyIntoleranceType</p>
     * 
     * <p>A:Allergy/Intolerance Type</p>
     */
    @Hl7XmlMapping({"code"})
    public ObservationIntoleranceType getAllergyIntoleranceType() {
        return (ObservationIntoleranceType) this.allergyIntoleranceType.getValue();
    }
    public void setAllergyIntoleranceType(ObservationIntoleranceType allergyIntoleranceType) {
        this.allergyIntoleranceType.setValue(allergyIntoleranceType);
    }


    /**
     * <p>AllergyIntoleranceRefuted</p>
     * 
     * <p>G:Allergy/Intolerance Refuted</p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getAllergyIntoleranceRefuted() {
        return this.allergyIntoleranceRefuted.getValue();
    }
    public void setAllergyIntoleranceRefuted(Boolean allergyIntoleranceRefuted) {
        this.allergyIntoleranceRefuted.setValue(allergyIntoleranceRefuted);
    }


    /**
     * <p>AllergyIntoleranceStatus</p>
     * 
     * <p>E:Allergy/Intolerance Status</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getAllergyIntoleranceStatus() {
        return (ActStatus) this.allergyIntoleranceStatus.getValue();
    }
    public void setAllergyIntoleranceStatus(ActStatus allergyIntoleranceStatus) {
        this.allergyIntoleranceStatus.setValue(allergyIntoleranceStatus);
    }


    /**
     * <p>AllergyIntoleranceDate</p>
     * 
     * <p>I:Allergy/Intolerance Date</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getAllergyIntoleranceDate() {
        return this.allergyIntoleranceDate.getValue();
    }
    public void setAllergyIntoleranceDate(Date allergyIntoleranceDate) {
        this.allergyIntoleranceDate.setValue(allergyIntoleranceDate);
    }


    /**
     * <p>AllergyIntoleranceMaskingIndicators</p>
     * 
     * <p>H:Allergy/Intolerance Masking Indicators</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_NormalRestrictedTabooConfidentialityKind> getAllergyIntoleranceMaskingIndicators() {
        return this.allergyIntoleranceMaskingIndicators.rawSet(x_NormalRestrictedTabooConfidentialityKind.class);
    }


    /**
     * <p>ConfirmedIndicator</p>
     * 
     * <p>F:Confirmed Indicator</p>
     */
    @Hl7XmlMapping({"uncertaintyCode"})
    public ActUncertainty getConfirmedIndicator() {
        return (ActUncertainty) this.confirmedIndicator.getValue();
    }
    public void setConfirmedIndicator(ActUncertainty confirmedIndicator) {
        this.confirmedIndicator.setValue(confirmedIndicator);
    }


    /**
     * <p>Agent</p>
     * 
     * <p>B:Agent</p>
     */
    @Hl7XmlMapping({"value"})
    public IntoleranceValue getAgent() {
        return (IntoleranceValue) this.agent.getValue();
    }
    public void setAgent(IntoleranceValue agent) {
        this.agent.setValue(agent);
    }


    @Hl7XmlMapping({"informant"})
    public ReportedByBean getInformant() {
        return this.informant;
    }
    public void setInformant(ReportedByBean informant) {
        this.informant = informant;
    }


    @Hl7XmlMapping({"support/records"})
    public List<Records> getSupportRecords() {
        return this.supportRecords;
    }


    @Hl7XmlMapping({"subjectOf1/annotation"})
    public NotesBean getSubjectOf1Annotation() {
        return this.subjectOf1Annotation;
    }
    public void setSubjectOf1Annotation(NotesBean subjectOf1Annotation) {
        this.subjectOf1Annotation = subjectOf1Annotation;
    }


    @Hl7XmlMapping({"subjectOf/severityObservation","subjectOf2/severityObservation"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subjectOf", type="REPC_MT000013CA.Subject1"),
        @Hl7MapByPartType(name="subjectOf/severityObservation", type="REPC_MT000013CA.SeverityObservation"),
        @Hl7MapByPartType(name="subjectOf2", type="REPC_MT000001CA.Subject1"),
        @Hl7MapByPartType(name="subjectOf2/severityObservation", type="REPC_MT000001CA.SeverityObservation")})
    public AllergyIntoleranceSeverityLevelBean getSubjectOfSeverityObservation() {
        return this.subjectOfSeverityObservation;
    }
    public void setSubjectOfSeverityObservation(AllergyIntoleranceSeverityLevelBean subjectOfSeverityObservation) {
        this.subjectOfSeverityObservation = subjectOfSeverityObservation;
    }


    /**
     * <p>AllergyIntoleranceRecordId</p>
     * 
     * <p>D:Allergy/Intolerance Record Id</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getAllergyIntoleranceRecordId() {
        return this.allergyIntoleranceRecordId.getValue();
    }
    public void setAllergyIntoleranceRecordId(Identifier allergyIntoleranceRecordId) {
        this.allergyIntoleranceRecordId.setValue(allergyIntoleranceRecordId);
    }

}
