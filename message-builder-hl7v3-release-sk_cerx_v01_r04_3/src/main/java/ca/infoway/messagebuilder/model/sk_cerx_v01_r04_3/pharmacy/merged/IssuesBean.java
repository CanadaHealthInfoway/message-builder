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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ActDetectedIssueCode;
import ca.infoway.messagebuilder.domainvalue.ActIssuePriority;
import ca.infoway.messagebuilder.domainvalue.SeverityObservation;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Issues</p>
 * 
 * <p>PORX_MT030040CA.DetectedIssueEvent: Issues</p>
 * 
 * <p><p>Describes an issue associated with a prescription that 
 * resulted in a dispenser refusing to fill it.</p></p>
 * 
 * <p><p>Allows a dispenser to assert an issue against a 
 * prescription to be displayed to subsequent dispensers as 
 * well as others reviewing the patient's medication 
 * profile.</p></p>
 * 
 * <p>PORX_MT060160CA.DetectedIssueEvent: Issues</p>
 * 
 * <p><p>Describes an issue associated with a prescription that 
 * resulted in a dispenser refusing to fill it.</p></p>
 * 
 * <p><p>Allows a dispenser to assert an issue against a 
 * prescription to be displayed to subsequent dispensers as 
 * well as others reviewing the patient's medication 
 * profile.</p></p>
 * 
 * <p>PORX_MT060340CA.DetectedIssueEvent: Issues</p>
 * 
 * <p><p>Describes an issue associated with a prescription that 
 * resulted in a dispenser refusing to fill it.</p></p>
 * 
 * <p><p>Allows a dispenser to assert an issue against a 
 * prescription to be displayed to subsequent dispensers as 
 * well as others reviewing the patient's medication 
 * profile.</p></p>
 * 
 * <p>PORX_MT060190CA.DetectedIssueEvent: Issues</p>
 * 
 * <p><p>Describes an issue associated with a prescription that 
 * resulted in a dispenser refusing to fill it.</p></p>
 * 
 * <p><p>Allows a dispenser to assert an issue against a 
 * prescription to be displayed to subsequent dispensers as 
 * well as others reviewing the patient's medication 
 * profile.</p></p>
 * 
 * <p>PORX_MT980030CA.DetectedIssueEvent: Issues</p>
 * 
 * <p><p>This is the list of clinical and business issues that 
 * have been detected and recorded involving the current 
 * action.</p></p>
 * 
 * <p><p>Provides a list of issues that have been detected 
 * and/or managed.</p></p>
 * 
 * <p>PORX_MT980020CA.DetectedIssueEvent: Issues</p>
 * 
 * <p><p>This is the list of clinical and business-rule issues 
 * that have been detected and recorded involving the current 
 * action.</p></p>
 * 
 * <p><p>Provides a list of issues that have been detected.</p></p>
 * 
 * <p>PORX_MT060040CA.DetectedIssueEvent: Issues</p>
 * 
 * <p><p>Describes an issue associated with a prescription that 
 * resulted in a dispenser refusing to fill it.</p></p>
 * 
 * <p><p>Allows a dispenser to assert an issue against a 
 * prescription to be displayed to subsequent dispensers as 
 * well as others reviewing the patient's medication 
 * profile.</p></p>
 * 
 * <p>PORX_MT980010CA.DetectedIssueEvent: Issues</p>
 * 
 * <p><p>This is the list of clinical and business issues that 
 * have been detected and recorded involving the current 
 * action.</p></p>
 * 
 * <p><p>Provides a list of issues that have been detected 
 * and/or managed.</p></p>
 * 
 * <p>PORX_MT060060CA.DetectedIssueEvent: Issues</p>
 * 
 * <p><p>Describes an issue associated with a prescription that 
 * resulted in a dispenser refusing to fill it.</p></p>
 * 
 * <p><p>Allows a dispenser to assert an issue against a 
 * prescription to be displayed to subsequent dispensers as 
 * well as others reviewing the patient's profile.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT030040CA.DetectedIssueEvent","PORX_MT060040CA.DetectedIssueEvent","PORX_MT060060CA.DetectedIssueEvent","PORX_MT060160CA.DetectedIssueEvent","PORX_MT060190CA.DetectedIssueEvent","PORX_MT060340CA.DetectedIssueEvent","PORX_MT980010CA.DetectedIssueEvent","PORX_MT980020CA.DetectedIssueEvent","PORX_MT980030CA.DetectedIssueEvent"})
@Hl7RootType
public class IssuesBean extends MessagePartBean {

    private static final long serialVersionUID = 20120320L;
    private CV code = new CVImpl();
    private ST text = new STImpl();
    private CV priorityCode = new CVImpl();
    private List<CausalActs> subjectCausalActs = new ArrayList<CausalActs>();
    private IssueDescriptionBean instantiationDetectedIssueDefinition;
    private List<IssueManagementsBean> mitigatedByDetectedIssueManagement = new ArrayList<IssueManagementsBean>();
    private CV subjectOfSeverityObservationValue = new CVImpl();
    private BL triggerForActRequest = new BLImpl(false);
    private BL subjectOf1StorageIntent = new BLImpl(false);


    /**
     * <p>IssueType</p>
     * 
     * <p>Issue Type</p>
     * 
     * <p><p>A coded value that is used to distinguish between 
     * different kinds of issues. Types of issue include: 
     * unrecognized identifiers, permission issues, drug-drug 
     * contraindications, drug-allergy alerts, duplicate therapies, 
     * suspect fraud etc.</p></p>
     * 
     * <p><p>Identifies what kind of issue was detected or is being 
     * managed.</p><p>This is mandatory so as to ensure that one 
     * issue type can be distinguished from another.</p></p>
     * 
     * <p><p>Identifies what kind of issue was detected or is being 
     * managed.</p><p>This is mandatory so as to ensure that one 
     * issue type can be distinguished from another.</p></p>
     * 
     * <p>Issue Type</p>
     * 
     * <p><p>A coded value that is used to distinguish between 
     * different kinds of issues. Types of issue include: 
     * unrecognized identifiers, permission issues, drug-drug 
     * contraindications, drug-allergy alerts, duplicate therapies, 
     * suspect fraud etc.</p></p>
     * 
     * <p><p>Identifies what kind of issue was detected or is being 
     * managed and is therefore mandatory.</p></p>
     * 
     * <p>A:Issue Type</p>
     * 
     * <p><p>A coded value that is used to distinguish between 
     * different kinds of issues. Types of issue include: 
     * unrecognized identifiers, permission issues, drug-drug 
     * contraindications, drug-allergy alerts, duplicate therapies, 
     * suspect fraud etc.</p></p>
     * 
     * <p><p>Contraindication.crossSensitive (if code is related 
     * reaction dected issue then crossSensitive is 
     * 'True')</p><p>Distinguishes between DAI, DDI, DosageCheck, 
     * DPD, and Duplicate Therapy 
     * Contraindications</p><p>Contraindication.DosageContraType</p><p>OverrideReason.reasonDomain</p><p>ZP3.3</p><p>E06(for 
     * contraindications errors are handled at transmission or 
     * controlAct wrapper level)</p><p>05.03D</p><p>DUR Response 
     * Codes</p><p>Interaction 
     * Type</p><p>ZPS.7.1</p><p>ZDU.9.1(PLYPHRM)</p><p>ZDU.10.1 
     * (PLYDOC)</p><p>ZDU.6.2</p><p>ZDU.6.4</p><p>ZDU.7.3</p><p>DRU.100-01</p><p>DUR/PPS.439-E4</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>Contraindication.crossSensitive (if code is related 
     * reaction dected issue then crossSensitive is 
     * 'True')</p><p>Distinguishes between DAI, DDI, DosageCheck, 
     * DPD, and Duplicate Therapy 
     * Contraindications</p><p>Contraindication.DosageContraType</p><p>OverrideReason.reasonDomain</p><p>ZP3.3</p><p>E06(for 
     * contraindications errors are handled at transmission or 
     * controlAct wrapper level)</p><p>05.03D</p><p>DUR Response 
     * Codes</p><p>Interaction 
     * Type</p><p>ZPS.7.1</p><p>ZDU.9.1(PLYPHRM)</p><p>ZDU.10.1 
     * (PLYDOC)</p><p>ZDU.6.2</p><p>ZDU.6.4</p><p>ZDU.7.3</p><p>DRU.100-01</p><p>DUR/PPS.439-E4</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>Contraindication.crossSensitive (if code is related 
     * reaction dected issue then crossSensitive is 
     * 'True')</p><p>Distinguishes between DAI, DDI, DosageCheck, 
     * DPD, and Duplicate Therapy 
     * Contraindications</p><p>Contraindication.DosageContraType</p><p>OverrideReason.reasonDomain</p><p>ZP3.3</p><p>E06(for 
     * contraindications errors are handled at transmission or 
     * controlAct wrapper level)</p><p>05.03D</p><p>DUR Response 
     * Codes</p><p>Interaction 
     * Type</p><p>ZPS.7.1</p><p>ZDU.9.1(PLYPHRM)</p><p>ZDU.10.1 
     * (PLYDOC)</p><p>ZDU.6.2</p><p>ZDU.6.4</p><p>ZDU.7.3</p><p>DRU.100-01</p><p>DUR/PPS.439-E4</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>Contraindication.crossSensitive (if code is related 
     * reaction dected issue then crossSensitive is 
     * 'True')</p><p>Distinguishes between DAI, DDI, DosageCheck, 
     * DPD, and Duplicate Therapy 
     * Contraindications</p><p>Contraindication.DosageContraType</p><p>OverrideReason.reasonDomain</p><p>ZP3.3</p><p>E06(for 
     * contraindications errors are handled at transmission or 
     * controlAct wrapper level)</p><p>05.03D</p><p>DUR Response 
     * Codes</p><p>Interaction 
     * Type</p><p>ZPS.7.1</p><p>ZDU.9.1(PLYPHRM)</p><p>ZDU.10.1 
     * (PLYDOC)</p><p>ZDU.6.2</p><p>ZDU.6.4</p><p>ZDU.7.3</p><p>DRU.100-01</p><p>DUR/PPS.439-E4</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>Contraindication.crossSensitive (if code is related 
     * reaction dected issue then crossSensitive is 
     * 'True')</p><p>Distinguishes between DAI, DDI, DosageCheck, 
     * DPD, and Duplicate Therapy 
     * Contraindications</p><p>Contraindication.DosageContraType</p><p>OverrideReason.reasonDomain</p><p>ZP3.3</p><p>E06(for 
     * contraindications errors are handled at transmission or 
     * controlAct wrapper level)</p><p>05.03D</p><p>DUR Response 
     * Codes</p><p>Interaction 
     * Type</p><p>ZPS.7.1</p><p>ZDU.9.1(PLYPHRM)</p><p>ZDU.10.1 
     * (PLYDOC)</p><p>ZDU.6.2</p><p>ZDU.6.4</p><p>ZDU.7.3</p><p>DRU.100-01</p><p>DUR/PPS.439-E4</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>Contraindication.crossSensitive (if code is related 
     * reaction dected issue then crossSensitive is 
     * 'True')</p><p>Distinguishes between DAI, DDI, DosageCheck, 
     * DPD, and Duplicate Therapy 
     * Contraindications</p><p>Contraindication.DosageContraType</p><p>OverrideReason.reasonDomain</p><p>ZP3.3</p><p>E06(for 
     * contraindications errors are handled at transmission or 
     * controlAct wrapper level)</p><p>05.03D</p><p>DUR Response 
     * Codes</p><p>Interaction 
     * Type</p><p>ZPS.7.1</p><p>ZDU.9.1(PLYPHRM)</p><p>ZDU.10.1 
     * (PLYDOC)</p><p>ZDU.6.2</p><p>ZDU.6.4</p><p>ZDU.7.3</p><p>DRU.100-01</p><p>DUR/PPS.439-E4</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>Contraindication.crossSensitive (if code is related 
     * reaction dected issue then crossSensitive is 
     * 'True')</p><p>Distinguishes between DAI, DDI, DosageCheck, 
     * DPD, and Duplicate Therapy 
     * Contraindications</p><p>Contraindication.DosageContraType</p><p>OverrideReason.reasonDomain</p><p>ZP3.3</p><p>E06(for 
     * contraindications errors are handled at transmission or 
     * controlAct wrapper level)</p><p>05.03D</p><p>DUR Response 
     * Codes</p><p>Interaction 
     * Type</p><p>ZPS.7.1</p><p>ZDU.9.1(PLYPHRM)</p><p>ZDU.10.1 
     * (PLYDOC)</p><p>ZDU.6.2</p><p>ZDU.6.4</p><p>ZDU.7.3</p><p>DRU.100-01</p><p>DUR/PPS.439-E4</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>Contraindication.crossSensitive (if code is related 
     * reaction dected issue then crossSensitive is 
     * 'True')</p><p>Distinguishes between DAI, DDI, DosageCheck, 
     * DPD, and Duplicate Therapy 
     * Contraindications</p><p>Contraindication.DosageContraType</p><p>OverrideReason.reasonDomain</p><p>ZP3.3</p><p>E06(for 
     * contraindications errors are handled at transmission or 
     * controlAct wrapper level)</p><p>05.03D</p><p>DUR Response 
     * Codes</p><p>Interaction 
     * Type</p><p>ZPS.7.1</p><p>ZDU.9.1(PLYPHRM)</p><p>ZDU.10.1 
     * (PLYDOC)</p><p>ZDU.6.2</p><p>ZDU.6.4</p><p>ZDU.7.3</p><p>DRU.100-01</p><p>DUR/PPS.439-E4</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>Contraindication.crossSensitive (if code is related 
     * reaction dected issue then crossSensitive is 
     * 'True')</p><p>Distinguishes between DAI, DDI, DosageCheck, 
     * DPD, and Duplicate Therapy 
     * Contraindications</p><p>Contraindication.DosageContraType</p><p>OverrideReason.reasonDomain</p><p>ZP3.3</p><p>E06(for 
     * contraindications errors are handled at transmission or 
     * controlAct wrapper level)</p><p>05.03D</p><p>DUR Response 
     * Codes</p><p>Interaction 
     * Type</p><p>ZPS.7.1</p><p>ZDU.9.1(PLYPHRM)</p><p>ZDU.10.1 
     * (PLYDOC)</p><p>ZDU.6.2</p><p>ZDU.6.4</p><p>ZDU.7.3</p><p>DRU.100-01</p><p>DUR/PPS.439-E4</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>Contraindication.crossSensitive (if code is related 
     * reaction dected issue then crossSensitive is 
     * 'True')</p><p>Distinguishes between DAI, DDI, DosageCheck, 
     * DPD, and Duplicate Therapy 
     * Contraindications</p><p>Contraindication.DosageContraType</p><p>OverrideReason.reasonDomain</p><p>ZP3.3</p><p>E06(for 
     * contraindications errors are handled at transmission or 
     * controlAct wrapper level)</p><p>05.03D</p><p>DUR Response 
     * Codes</p><p>Interaction 
     * Type</p><p>ZPS.7.1</p><p>ZDU.9.1(PLYPHRM)</p><p>ZDU.10.1 
     * (PLYDOC)</p><p>ZDU.6.2</p><p>ZDU.6.4</p><p>ZDU.7.3</p><p>DRU.100-01</p><p>DUR/PPS.439-E4</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>Contraindication.crossSensitive (if code is related 
     * reaction dected issue then crossSensitive is 
     * 'True')</p><p>Distinguishes between DAI, DDI, DosageCheck, 
     * DPD, and Duplicate Therapy 
     * Contraindications</p><p>Contraindication.DosageContraType</p><p>OverrideReason.reasonDomain</p><p>ZP3.3</p><p>E06(for 
     * contraindications errors are handled at transmission or 
     * controlAct wrapper level)</p><p>05.03D</p><p>DUR Response 
     * Codes</p><p>Interaction 
     * Type</p><p>ZPS.7.1</p><p>ZDU.9.1(PLYPHRM)</p><p>ZDU.10.1 
     * (PLYDOC)</p><p>ZDU.6.2</p><p>ZDU.6.4</p><p>ZDU.7.3</p><p>DRU.100-01</p><p>DUR/PPS.439-E4</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>Contraindication.crossSensitive (if code is related 
     * reaction dected issue then crossSensitive is 
     * 'True')</p><p>Distinguishes between DAI, DDI, DosageCheck, 
     * DPD, and Duplicate Therapy 
     * Contraindications</p><p>Contraindication.DosageContraType</p><p>OverrideReason.reasonDomain</p><p>ZP3.3</p><p>E06(for 
     * contraindication
     * ... [rest of documentation truncated due to excessive length]
     */
    @Hl7XmlMapping({"code"})
    public ActDetectedIssueCode getCode() {
        return (ActDetectedIssueCode) this.code.getValue();
    }
    public void setCode(ActDetectedIssueCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>B:Issue Comment</p>
     * 
     * <p><p>A free form textual description regarding the issue of 
     * fraudulence. This may be specified in place of, or in 
     * addition to the coded issue.</p></p>
     * 
     * <p><p>Enables extra or more detailed description of the 
     * alert</p></p>
     * 
     * <p>Issue Comment</p>
     * 
     * <p><p>A free form textual description regarding the issue of 
     * fraudulence. This may be specified in place of, or in 
     * addition to the coded issue.</p></p>
     * 
     * <p><p>Enables extra or more detailed description of the 
     * alert</p></p>
     * 
     * <p>D:Issue Details</p>
     * 
     * <p><p>A free form textual description of a detected issue. 
     * This textual information is provided to either augment the 
     * coded information or in place of the coded information.</p></p>
     * 
     * <p><p>Contraindication.DDIDescription</p><p>E20(for 
     * contraindication errors are handled at transmission or 
     * controlact wrapper level)</p><p>ZPE.4</p><p>ZDU.11.1</p></p>
     * 
     * <p><p>Contraindication.DDIDescription</p><p>E20(for 
     * contraindication errors are handled at transmission or 
     * controlact wrapper level)</p><p>ZPE.4</p><p>ZDU.11.1</p></p>
     * 
     * <p><p>Contraindication.DDIDescription</p><p>E20(for 
     * contraindication errors are handled at transmission or 
     * controlact wrapper level)</p><p>ZPE.4</p><p>ZDU.11.1</p></p>
     * 
     * <p><p>Contraindication.DDIDescription</p><p>E20(for 
     * contraindication errors are handled at transmission or 
     * controlact wrapper level)</p><p>ZPE.4</p><p>ZDU.11.1</p></p>
     * 
     * <p><p>Lets providers see textual explanation of the 
     * issue.</p></p>
     * 
     * <p>Issue Comment</p>
     * 
     * <p><p>A free form textual description regarding the issue. 
     * This may be specified in place of, or in addition to the 
     * coded issue.</p></p>
     * 
     * <p><p>Enables extra or more detailed description of the 
     * alert</p></p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>IssuePriority</p>
     * 
     * <p>C:Issue Priority</p>
     * 
     * <p><p>A coded value denoting the importance of a detectable 
     * issue. Valid codes are: I - for Information, E - for Error, 
     * and W - for Warning.</p></p>
     * 
     * <p><p>Allows the provider to make informed decision on the 
     * importance and criticality of an issue. May also be used by 
     * the DIS to determine the order of returning issues. 
     * Attribute is mandatory because every issue needs to be 
     * prioritized.</p></p>
     */
    @Hl7XmlMapping({"priorityCode"})
    public ActIssuePriority getPriorityCode() {
        return (ActIssuePriority) this.priorityCode.getValue();
    }
    public void setPriorityCode(ActIssuePriority priorityCode) {
        this.priorityCode.setValue(priorityCode);
    }


    @Hl7XmlMapping({"subject/causalActs"})
    public List<CausalActs> getSubjectCausalActs() {
        return this.subjectCausalActs;
    }


    @Hl7XmlMapping({"instantiation/detectedIssueDefinition"})
    public IssueDescriptionBean getInstantiationDetectedIssueDefinition() {
        return this.instantiationDetectedIssueDefinition;
    }
    public void setInstantiationDetectedIssueDefinition(IssueDescriptionBean instantiationDetectedIssueDefinition) {
        this.instantiationDetectedIssueDefinition = instantiationDetectedIssueDefinition;
    }


    @Hl7XmlMapping({"mitigatedBy/detectedIssueManagement"})
    public List<IssueManagementsBean> getMitigatedByDetectedIssueManagement() {
        return this.mitigatedByDetectedIssueManagement;
    }


    /**
     * <p>SeverityCode</p>
     * 
     * <p>B:Severity Code</p>
     * 
     * <p><p>A coded value denoting the gravity of the detected 
     * issue.</p></p>
     * 
     * <p><p>Contraindication.severity</p><p>ZPE.3</p><p>MB.05.03A</p><p>Severity</p><p>ZDU.6.3</p><p>ZDU.8.4</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>Contraindication.severity</p><p>ZPE.3</p><p>MB.05.03A</p><p>Severity</p><p>ZDU.6.3</p><p>ZDU.8.4</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>Contraindication.severity</p><p>ZPE.3</p><p>MB.05.03A</p><p>Severity</p><p>ZDU.6.3</p><p>ZDU.8.4</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>Contraindication.severity</p><p>ZPE.3</p><p>MB.05.03A</p><p>Severity</p><p>ZDU.6.3</p><p>ZDU.8.4</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>Contraindication.severity</p><p>ZPE.3</p><p>MB.05.03A</p><p>Severity</p><p>ZDU.6.3</p><p>ZDU.8.4</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>Contraindication.severity</p><p>ZPE.3</p><p>MB.05.03A</p><p>Severity</p><p>ZDU.6.3</p><p>ZDU.8.4</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>Contraindication.severity</p><p>ZPE.3</p><p>MB.05.03A</p><p>Severity</p><p>ZDU.6.3</p><p>ZDU.8.4</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>May be used to determine which contraindications must 
     * be managed and how.</p><p>This attribute is marked as 
     * &quot;populated&quot; to allow for use of null flavors.</p></p>
     * 
     * <p><p>May be used to determine which contraindications must 
     * be managed and how.</p><p>This attribute is marked as 
     * &quot;populated&quot; to allow for use of null flavors.</p></p>
     * 
     * <p>B:Severity Code</p>
     * 
     * <p><p>A coded value denoting the gravity of the detected 
     * issue.</p></p>
     * 
     * <p><p>Contraindication.severity</p><p>ZPE.3</p><p>MB.05.03A</p><p>Severity</p><p>ZDU.6.3</p><p>ZDU.8.4</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>Contraindication.severity</p><p>ZPE.3</p><p>MB.05.03A</p><p>Severity</p><p>ZDU.6.3</p><p>ZDU.8.4</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>Contraindication.severity</p><p>ZPE.3</p><p>MB.05.03A</p><p>Severity</p><p>ZDU.6.3</p><p>ZDU.8.4</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>Contraindication.severity</p><p>ZPE.3</p><p>MB.05.03A</p><p>Severity</p><p>ZDU.6.3</p><p>ZDU.8.4</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>Contraindication.severity</p><p>ZPE.3</p><p>MB.05.03A</p><p>Severity</p><p>ZDU.6.3</p><p>ZDU.8.4</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>Contraindication.severity</p><p>ZPE.3</p><p>MB.05.03A</p><p>Severity</p><p>ZDU.6.3</p><p>ZDU.8.4</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>Contraindication.severity</p><p>ZPE.3</p><p>MB.05.03A</p><p>Severity</p><p>ZDU.6.3</p><p>ZDU.8.4</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>May be used to determine which issues must be managed 
     * and how.</p><p>This attribute is marked as 
     * &quot;populated&quot; to allow the use of null flavors.</p></p>
     * 
     * <p><p>May be used to determine which issues must be managed 
     * and how.</p><p>This attribute is marked as 
     * &quot;populated&quot; to allow the use of null flavors.</p></p>
     * 
     * <p>B:Severity Code</p>
     * 
     * <p><p>A coded value denoting the gravity of the detected 
     * issue.</p></p>
     * 
     * <p><p>Contraindication.severity</p><p>ZPE.3</p><p>MB.05.03A</p><p>Severity</p><p>ZDU.6.3</p><p>ZDU.8.4</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>Contraindication.severity</p><p>ZPE.3</p><p>MB.05.03A</p><p>Severity</p><p>ZDU.6.3</p><p>ZDU.8.4</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>Contraindication.severity</p><p>ZPE.3</p><p>MB.05.03A</p><p>Severity</p><p>ZDU.6.3</p><p>ZDU.8.4</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>Contraindication.severity</p><p>ZPE.3</p><p>MB.05.03A</p><p>Severity</p><p>ZDU.6.3</p><p>ZDU.8.4</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>Contraindication.severity</p><p>ZPE.3</p><p>MB.05.03A</p><p>Severity</p><p>ZDU.6.3</p><p>ZDU.8.4</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>Contraindication.severity</p><p>ZPE.3</p><p>MB.05.03A</p><p>Severity</p><p>ZDU.6.3</p><p>ZDU.8.4</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>Contraindication.severity</p><p>ZPE.3</p><p>MB.05.03A</p><p>Severity</p><p>ZDU.6.3</p><p>ZDU.8.4</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>May be used to determine which contraindications must 
     * be managed and how.</p><p>This attribute is marked as 
     * &quot;populated&quot; to allow the use of null flavors.</p></p>
     * 
     * <p><p>May be used to determine which contraindications must 
     * be managed and how.</p><p>This attribute is marked as 
     * &quot;populated&quot; to allow the use of null flavors.</p></p>
     */
    @Hl7XmlMapping({"subjectOf/severityObservation/value","subjectOf2/severityObservation/value"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subjectOf", type="PORX_MT980010CA.Subject"),
        @Hl7MapByPartType(name="subjectOf", type="PORX_MT980030CA.Subject"),
        @Hl7MapByPartType(name="subjectOf/severityObservation", type="PORX_MT980010CA.SeverityObservation"),
        @Hl7MapByPartType(name="subjectOf/severityObservation", type="PORX_MT980030CA.SeverityObservation"),
        @Hl7MapByPartType(name="subjectOf2", type="PORX_MT980020CA.Subject"),
        @Hl7MapByPartType(name="subjectOf2/severityObservation", type="PORX_MT980020CA.SeverityObservation")})
    public SeverityObservation getSubjectOfSeverityObservationValue() {
        return (SeverityObservation) this.subjectOfSeverityObservationValue.getValue();
    }
    public void setSubjectOfSeverityObservationValue(SeverityObservation subjectOfSeverityObservationValue) {
        this.subjectOfSeverityObservationValue.setValue(subjectOfSeverityObservationValue);
    }


    @Hl7XmlMapping({"triggerFor/actRequest"})
    public Boolean getTriggerForActRequest() {
        return this.triggerForActRequest.getValue();
    }
    public void setTriggerForActRequest(Boolean triggerForActRequest) {
        this.triggerForActRequest.setValue(triggerForActRequest);
    }


    @Hl7XmlMapping({"subjectOf1/storageIntent"})
    public Boolean getSubjectOf1StorageIntent() {
        return this.subjectOf1StorageIntent.getValue();
    }
    public void setSubjectOf1StorageIntent(Boolean subjectOf1StorageIntent) {
        this.subjectOf1StorageIntent.setValue(subjectOf1StorageIntent);
    }

}
