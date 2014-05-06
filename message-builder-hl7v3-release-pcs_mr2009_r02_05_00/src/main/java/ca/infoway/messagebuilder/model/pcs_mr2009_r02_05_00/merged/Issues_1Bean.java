/**
 * Copyright 2013 Canada Health Infoway, Inc.
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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ActDetectedIssueCode;
import ca.infoway.messagebuilder.domainvalue.ActIssuePriority;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.common.merged.CausalActs;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.common.merged.IssueDescriptionBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * <p>Business Name: Issues</p>
 * 
 * <p>PORX_MT030040CA.DetectedIssueEvent: Issues</p>
 * 
 * <p>Allows a dispenser to assert an issue against a 
 * prescription to be displayed to subsequent dispensers as 
 * well as others reviewing the patient's medication 
 * profile.</p>
 * 
 * <p>Describes an issue associated with a prescription that 
 * resulted in a dispenser refusing to fill it.</p>
 * 
 * <p>PORX_MT060160CA.DetectedIssueEvent: Issues</p>
 * 
 * <p>Allows a dispenser to assert an issue against a 
 * prescription to be displayed to subsequent dispensers as 
 * well as others reviewing the patient's medication 
 * profile.</p>
 * 
 * <p>Describes an issue associated with a prescription that 
 * resulted in a dispenser refusing to fill it.</p>
 * 
 * <p>PORX_MT060340CA.DetectedIssueEvent: Issues</p>
 * 
 * <p>Allows a dispenser to assert an issue against a 
 * prescription to be displayed to subsequent dispensers as 
 * well as others reviewing the patient's medication 
 * profile.</p>
 * 
 * <p>Describes an issue associated with a prescription that 
 * resulted in a dispenser refusing to fill it.</p>
 * 
 * <p>COCT_MT260012CA.DetectedIssueEvent: Issues</p>
 * 
 * <p>Provides a list of issues that have been detected and/or 
 * managed.</p>
 * 
 * <p>This is the list of clinical and business issues that 
 * have been detected and recorded involving the current 
 * action.</p>
 * 
 * <p>PORX_MT060190CA.DetectedIssueEvent: Issues</p>
 * 
 * <p>Allows a dispenser to assert an issue against a 
 * prescription to be displayed to subsequent dispensers as 
 * well as others reviewing the patient's medication 
 * profile.</p>
 * 
 * <p>Describes an issue associated with a prescription that 
 * resulted in a dispenser refusing to fill it.</p>
 * 
 * <p>PORX_MT060040CA.DetectedIssueEvent: Issues</p>
 * 
 * <p>Allows a dispenser to assert an issue against a 
 * prescription to be displayed to subsequent dispensers as 
 * well as others reviewing the patient's medication 
 * profile.</p>
 * 
 * <p>Describes an issue associated with a prescription that 
 * resulted in a dispenser refusing to fill it.</p>
 * 
 * <p>COCT_MT260010CA.DetectedIssueEvent: Issues</p>
 * 
 * <p>Provides a list of issues that have been detected and/or 
 * managed.</p>
 * 
 * <p>This is the list of clinical and business issues that 
 * have been detected and recorded involving the current 
 * action.</p>
 * 
 * <p>PORX_MT060060CA.DetectedIssueEvent: Issues</p>
 * 
 * <p>Allows a dispenser to assert an issue against a 
 * prescription to be displayed to subsequent dispensers as 
 * well as others reviewing the patient's profile.</p>
 * 
 * <p>Describes an issue associated with a prescription that 
 * resulted in a dispenser refusing to fill it.</p>
 */
@Hl7PartTypeMapping({"COCT_MT260010CA.DetectedIssueEvent","COCT_MT260012CA.DetectedIssueEvent","PORX_MT030040CA.DetectedIssueEvent","PORX_MT060040CA.DetectedIssueEvent","PORX_MT060060CA.DetectedIssueEvent","PORX_MT060160CA.DetectedIssueEvent","PORX_MT060190CA.DetectedIssueEvent","PORX_MT060340CA.DetectedIssueEvent"})
@Hl7RootType
public class Issues_1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20140506L;
    private CV code = new CVImpl();
    private ST text = new STImpl();
    private CV priorityCode = new CVImpl();
    private SET<ST, String> targetSiteCode = new SETImpl<ST, String>(STImpl.class);
    private List<IssueManagements_1Bean> mitigatedByDetectedIssueManagement = new ArrayList<IssueManagements_1Bean>();
    private List<CausalActs> subjectCausalActs = new ArrayList<CausalActs>();
    private IssueDescriptionBean instantiationDetectedIssueDefinition;
    private AllergyIntoleranceSeverityLevelBean subjectOfSeverityObservation;


    /**
     * <p>Business Name: IssueType</p>
     * 
     * <p>Un-merged Business Name: IssueType</p>
     * 
     * <p>Relationship: PORX_MT030040CA.DetectedIssueEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies what kind of issue was detected or is being 
     * managed.</p><p>This is mandatory so as to ensure that one 
     * issue type can be distinguished from another.</p>
     * 
     * <p>A coded value that is used to distinguish between 
     * different kinds of issues. Types of issue include: 
     * unrecognized identifiers, permission issues, drug-drug 
     * contraindications, drug-allergy alerts, duplicate therapies, 
     * suspect fraud etc.</p><p>.</p>
     * 
     * <p>Un-merged Business Name: IssueType</p>
     * 
     * <p>Relationship: PORX_MT060160CA.DetectedIssueEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies what kind of issue was detected or is being 
     * managed.</p><p>This is mandatory so as to ensure that one 
     * issue type can be distinguished from another.</p>
     * 
     * <p>A coded value that is used to distinguish between 
     * different kinds of issues. Types of issue include: 
     * unrecognized identifiers, permission issues, drug-drug 
     * contraindications, drug-allergy alerts, duplicate therapies, 
     * suspect fraud etc.</p>
     * 
     * <p>Un-merged Business Name: IssueType</p>
     * 
     * <p>Relationship: PORX_MT060340CA.DetectedIssueEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies what kind of issue was detected or is being 
     * managed.</p><p>This is mandatory so as to ensure that one 
     * issue type can be distinguished from another.</p>
     * 
     * <p>A coded value that is used to distinguish between 
     * different kinds of issues. Types of issue include: 
     * unrecognized identifiers, permission issues, drug-drug 
     * contraindications, drug-allergy alerts, duplicate therapies, 
     * suspect fraud etc.</p>
     * 
     * <p>Un-merged Business Name: IssueType</p>
     * 
     * <p>Relationship: COCT_MT260012CA.DetectedIssueEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Contraindication.crossSensitive (if code is related 
     * reaction dected issue then crossSensitive is 'True')</p>
     * 
     * <p>Distinguishes between DAI, DDI, DosageCheck, DPD, and 
     * Duplicate Therapy Contraindications</p>
     * 
     * <p>Contraindication.DosageContraType</p>
     * 
     * <p>OverrideReason.reasonDomain</p>
     * 
     * <p>ZP3.3</p>
     * 
     * <p>E06(for contraindications errors are handled at 
     * transmission or controlAct wrapper level)</p>
     * 
     * <p>05.03D</p>
     * 
     * <p>DUR Response Codes</p>
     * 
     * <p>Interaction Type</p>
     * 
     * <p>ZPS.7.1</p>
     * 
     * <p>ZDU.9.1(PLYPHRM)</p>
     * 
     * <p>ZDU.10.1 (PLYDOC)</p>
     * 
     * <p>ZDU.6.2</p>
     * 
     * <p>ZDU.6.4</p>
     * 
     * <p>ZDU.7.3</p>
     * 
     * <p>DRU.100-01</p>
     * 
     * <p>DUR/PPS.439-E4</p>
     * 
     * <p>A_DetectedMedicationIssue</p>
     * 
     * <p>Identifies what kind of issue was detected or is being 
     * managed.</p><p>This is mandatory so as to ensure that one 
     * issue type can be distinguished from another.</p>
     * 
     * <p>A coded value that is used to distinguish between 
     * different kinds of issues. Types of issue include: 
     * unrecognized identifiers, permission issues, drug-drug 
     * contraindications, drug-allergy alerts, duplicate therapies, 
     * etc.</p>
     * 
     * <p>Un-merged Business Name: IssueType</p>
     * 
     * <p>Relationship: PORX_MT060190CA.DetectedIssueEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies what kind of issue was detected or is being 
     * managed.</p><p>This is mandatory so as to ensure that one 
     * issue type can be distinguished from another.</p>
     * 
     * <p>A coded value that is used to distinguish between 
     * different kinds of issues. Types of issue include: 
     * unrecognized identifiers, permission issues, drug-drug 
     * contraindications, drug-allergy alerts, duplicate therapies, 
     * suspect fraud etc.</p>
     * 
     * <p>Un-merged Business Name: IssueType</p>
     * 
     * <p>Relationship: PORX_MT060040CA.DetectedIssueEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies what kind of issue was detected or is being 
     * managed.</p><p>This is mandatory so as to ensure that one 
     * issue type can be distinguished from another.</p>
     * 
     * <p>A coded value that is used to distinguish between 
     * different kinds of issues. Types of issue include: 
     * unrecognized identifiers, permission issues, drug-drug 
     * contraindications, drug-allergy alerts, duplicate therapies, 
     * suspect fraud etc.</p>
     * 
     * <p>Un-merged Business Name: IssueType</p>
     * 
     * <p>Relationship: COCT_MT260010CA.DetectedIssueEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Contraindication.crossSensitive (if code is related 
     * reaction dected issue then crossSensitive is 'True')</p>
     * 
     * <p>Distinguishes between DAI, DDI, DosageCheck, DPD, and 
     * Duplicate Therapy Contraindications</p>
     * 
     * <p>Contraindication.DosageContraType</p>
     * 
     * <p>OverrideReason.reasonDomain</p>
     * 
     * <p>ZP3.3</p>
     * 
     * <p>E06(for contraindications errors are handled at 
     * transmission or controlAct wrapper level)</p>
     * 
     * <p>05.03D</p>
     * 
     * <p>DUR Response Codes</p>
     * 
     * <p>Interaction Type</p>
     * 
     * <p>ZPS.7.1</p>
     * 
     * <p>ZDU.9.1(PLYPHRM)</p>
     * 
     * <p>ZDU.10.1 (PLYDOC)</p>
     * 
     * <p>ZDU.6.2</p>
     * 
     * <p>ZDU.6.4</p>
     * 
     * <p>ZDU.7.3</p>
     * 
     * <p>DRU.100-01</p>
     * 
     * <p>DUR/PPS.439-E4</p>
     * 
     * <p>A_DetectedMedicationIssue</p>
     * 
     * <p>Identifies what kind of issue was detected or is being 
     * managed.</p><p>This is mandatory so as to ensure that one 
     * issue type can be distinguished from another.</p>
     * 
     * <p>A coded value that is used to distinguish between 
     * different kinds of issues. Types of issue include: 
     * unrecognized identifiers, permission issues, drug-drug 
     * contraindications, drug-allergy alerts, duplicate therapies, 
     * etc.</p>
     * 
     * <p>Un-merged Business Name: IssueType</p>
     * 
     * <p>Relationship: PORX_MT060060CA.DetectedIssueEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies what kind of issue was detected or is being 
     * managed and is therefore mandatory.</p>
     * 
     * <p>A coded value that is used to distinguish between 
     * different kinds of issues. Types of issue include: 
     * unrecognized identifiers, permission issues, drug-drug 
     * contraindications, drug-allergy alerts, duplicate therapies, 
     * suspect fraud etc.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActDetectedIssueCode getCode() {
        return (ActDetectedIssueCode) this.code.getValue();
    }

    /**
     * <p>Business Name: IssueType</p>
     * 
     * <p>Un-merged Business Name: IssueType</p>
     * 
     * <p>Relationship: PORX_MT030040CA.DetectedIssueEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies what kind of issue was detected or is being 
     * managed.</p><p>This is mandatory so as to ensure that one 
     * issue type can be distinguished from another.</p>
     * 
     * <p>A coded value that is used to distinguish between 
     * different kinds of issues. Types of issue include: 
     * unrecognized identifiers, permission issues, drug-drug 
     * contraindications, drug-allergy alerts, duplicate therapies, 
     * suspect fraud etc.</p><p>.</p>
     * 
     * <p>Un-merged Business Name: IssueType</p>
     * 
     * <p>Relationship: PORX_MT060160CA.DetectedIssueEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies what kind of issue was detected or is being 
     * managed.</p><p>This is mandatory so as to ensure that one 
     * issue type can be distinguished from another.</p>
     * 
     * <p>A coded value that is used to distinguish between 
     * different kinds of issues. Types of issue include: 
     * unrecognized identifiers, permission issues, drug-drug 
     * contraindications, drug-allergy alerts, duplicate therapies, 
     * suspect fraud etc.</p>
     * 
     * <p>Un-merged Business Name: IssueType</p>
     * 
     * <p>Relationship: PORX_MT060340CA.DetectedIssueEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies what kind of issue was detected or is being 
     * managed.</p><p>This is mandatory so as to ensure that one 
     * issue type can be distinguished from another.</p>
     * 
     * <p>A coded value that is used to distinguish between 
     * different kinds of issues. Types of issue include: 
     * unrecognized identifiers, permission issues, drug-drug 
     * contraindications, drug-allergy alerts, duplicate therapies, 
     * suspect fraud etc.</p>
     * 
     * <p>Un-merged Business Name: IssueType</p>
     * 
     * <p>Relationship: COCT_MT260012CA.DetectedIssueEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Contraindication.crossSensitive (if code is related 
     * reaction dected issue then crossSensitive is 'True')</p>
     * 
     * <p>Distinguishes between DAI, DDI, DosageCheck, DPD, and 
     * Duplicate Therapy Contraindications</p>
     * 
     * <p>Contraindication.DosageContraType</p>
     * 
     * <p>OverrideReason.reasonDomain</p>
     * 
     * <p>ZP3.3</p>
     * 
     * <p>E06(for contraindications errors are handled at 
     * transmission or controlAct wrapper level)</p>
     * 
     * <p>05.03D</p>
     * 
     * <p>DUR Response Codes</p>
     * 
     * <p>Interaction Type</p>
     * 
     * <p>ZPS.7.1</p>
     * 
     * <p>ZDU.9.1(PLYPHRM)</p>
     * 
     * <p>ZDU.10.1 (PLYDOC)</p>
     * 
     * <p>ZDU.6.2</p>
     * 
     * <p>ZDU.6.4</p>
     * 
     * <p>ZDU.7.3</p>
     * 
     * <p>DRU.100-01</p>
     * 
     * <p>DUR/PPS.439-E4</p>
     * 
     * <p>A_DetectedMedicationIssue</p>
     * 
     * <p>Identifies what kind of issue was detected or is being 
     * managed.</p><p>This is mandatory so as to ensure that one 
     * issue type can be distinguished from another.</p>
     * 
     * <p>A coded value that is used to distinguish between 
     * different kinds of issues. Types of issue include: 
     * unrecognized identifiers, permission issues, drug-drug 
     * contraindications, drug-allergy alerts, duplicate therapies, 
     * etc.</p>
     * 
     * <p>Un-merged Business Name: IssueType</p>
     * 
     * <p>Relationship: PORX_MT060190CA.DetectedIssueEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies what kind of issue was detected or is being 
     * managed.</p><p>This is mandatory so as to ensure that one 
     * issue type can be distinguished from another.</p>
     * 
     * <p>A coded value that is used to distinguish between 
     * different kinds of issues. Types of issue include: 
     * unrecognized identifiers, permission issues, drug-drug 
     * contraindications, drug-allergy alerts, duplicate therapies, 
     * suspect fraud etc.</p>
     * 
     * <p>Un-merged Business Name: IssueType</p>
     * 
     * <p>Relationship: PORX_MT060040CA.DetectedIssueEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies what kind of issue was detected or is being 
     * managed.</p><p>This is mandatory so as to ensure that one 
     * issue type can be distinguished from another.</p>
     * 
     * <p>A coded value that is used to distinguish between 
     * different kinds of issues. Types of issue include: 
     * unrecognized identifiers, permission issues, drug-drug 
     * contraindications, drug-allergy alerts, duplicate therapies, 
     * suspect fraud etc.</p>
     * 
     * <p>Un-merged Business Name: IssueType</p>
     * 
     * <p>Relationship: COCT_MT260010CA.DetectedIssueEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Contraindication.crossSensitive (if code is related 
     * reaction dected issue then crossSensitive is 'True')</p>
     * 
     * <p>Distinguishes between DAI, DDI, DosageCheck, DPD, and 
     * Duplicate Therapy Contraindications</p>
     * 
     * <p>Contraindication.DosageContraType</p>
     * 
     * <p>OverrideReason.reasonDomain</p>
     * 
     * <p>ZP3.3</p>
     * 
     * <p>E06(for contraindications errors are handled at 
     * transmission or controlAct wrapper level)</p>
     * 
     * <p>05.03D</p>
     * 
     * <p>DUR Response Codes</p>
     * 
     * <p>Interaction Type</p>
     * 
     * <p>ZPS.7.1</p>
     * 
     * <p>ZDU.9.1(PLYPHRM)</p>
     * 
     * <p>ZDU.10.1 (PLYDOC)</p>
     * 
     * <p>ZDU.6.2</p>
     * 
     * <p>ZDU.6.4</p>
     * 
     * <p>ZDU.7.3</p>
     * 
     * <p>DRU.100-01</p>
     * 
     * <p>DUR/PPS.439-E4</p>
     * 
     * <p>A_DetectedMedicationIssue</p>
     * 
     * <p>Identifies what kind of issue was detected or is being 
     * managed.</p><p>This is mandatory so as to ensure that one 
     * issue type can be distinguished from another.</p>
     * 
     * <p>A coded value that is used to distinguish between 
     * different kinds of issues. Types of issue include: 
     * unrecognized identifiers, permission issues, drug-drug 
     * contraindications, drug-allergy alerts, duplicate therapies, 
     * etc.</p>
     * 
     * <p>Un-merged Business Name: IssueType</p>
     * 
     * <p>Relationship: PORX_MT060060CA.DetectedIssueEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies what kind of issue was detected or is being 
     * managed and is therefore mandatory.</p>
     * 
     * <p>A coded value that is used to distinguish between 
     * different kinds of issues. Types of issue include: 
     * unrecognized identifiers, permission issues, drug-drug 
     * contraindications, drug-allergy alerts, duplicate therapies, 
     * suspect fraud etc.</p>
     */
    public void setCode(ActDetectedIssueCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Un-merged Business Name: IssueComment</p>
     * 
     * <p>Relationship: PORX_MT030040CA.DetectedIssueEvent.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Enables extra or more detailed description of the 
     * alert</p>
     * 
     * <p>A free form textual description regarding the issue of 
     * fraudulence. This may be specified in place of, or in 
     * addition to the coded issue.</p>
     * 
     * <p>Un-merged Business Name: IssueComment</p>
     * 
     * <p>Relationship: PORX_MT060160CA.DetectedIssueEvent.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Enables extra or more detailed description of the 
     * alert</p>
     * 
     * <p>A free form textual description regarding the issue of 
     * fraudulence. This may be specified in place of, or in 
     * addition to the coded issue.</p>
     * 
     * <p>Un-merged Business Name: IssueComment</p>
     * 
     * <p>Relationship: PORX_MT060340CA.DetectedIssueEvent.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Enables extra or more detailed description of the 
     * alert</p>
     * 
     * <p>A free form textual description regarding the issue of 
     * fraudulence. This may be specified in place of, or in 
     * addition to the coded issue.</p>
     * 
     * <p>Un-merged Business Name: IssueDetails</p>
     * 
     * <p>Relationship: COCT_MT260012CA.DetectedIssueEvent.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Contraindication.DDIDescription</p>
     * 
     * <p>E20(for contraindication errors are handled at 
     * transmission or controlact wrapper level)</p>
     * 
     * <p>ZPE.4</p>
     * 
     * <p>ZDU.11.1</p>
     * 
     * <p>Lets providers see textual explanation of the issue.</p>
     * 
     * <p>A free form textual description of a detected issue. This 
     * textual information is provided to either augment the coded 
     * information or in place of the coded information.</p>
     * 
     * <p>Un-merged Business Name: IssueComment</p>
     * 
     * <p>Relationship: PORX_MT060190CA.DetectedIssueEvent.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Enables extra or more detailed description of the 
     * alert</p>
     * 
     * <p>A free form textual description regarding the issue of 
     * fraudulence. This may be specified in place of, or in 
     * addition to the coded issue.</p>
     * 
     * <p>Un-merged Business Name: IssueComment</p>
     * 
     * <p>Relationship: PORX_MT060040CA.DetectedIssueEvent.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Enables extra or more detailed description of the 
     * alert</p>
     * 
     * <p>A free form textual description regarding the issue of 
     * fraudulence. This may be specified in place of, or in 
     * addition to the coded issue.</p>
     * 
     * <p>Un-merged Business Name: IssueDetails</p>
     * 
     * <p>Relationship: COCT_MT260010CA.DetectedIssueEvent.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Contraindication.DDIDescription</p>
     * 
     * <p>E20(for contraindication errors are handled at 
     * transmission or controlact wrapper level)</p>
     * 
     * <p>ZPE.4</p>
     * 
     * <p>ZDU.11.1</p>
     * 
     * <p>Lets providers see textual explanation of the issue.</p>
     * 
     * <p>A free form textual description of a detected issue. This 
     * textual information is provided to either augment the coded 
     * information or in place of the coded information.</p>
     * 
     * <p>Un-merged Business Name: IssueComment</p>
     * 
     * <p>Relationship: PORX_MT060060CA.DetectedIssueEvent.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Enables extra or more detailed description of the 
     * alert</p>
     * 
     * <p>A free form textual description regarding the issue. This 
     * may be specified in place of, or in addition to the coded 
     * issue.</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }

    /**
     * <p>Un-merged Business Name: IssueComment</p>
     * 
     * <p>Relationship: PORX_MT030040CA.DetectedIssueEvent.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Enables extra or more detailed description of the 
     * alert</p>
     * 
     * <p>A free form textual description regarding the issue of 
     * fraudulence. This may be specified in place of, or in 
     * addition to the coded issue.</p>
     * 
     * <p>Un-merged Business Name: IssueComment</p>
     * 
     * <p>Relationship: PORX_MT060160CA.DetectedIssueEvent.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Enables extra or more detailed description of the 
     * alert</p>
     * 
     * <p>A free form textual description regarding the issue of 
     * fraudulence. This may be specified in place of, or in 
     * addition to the coded issue.</p>
     * 
     * <p>Un-merged Business Name: IssueComment</p>
     * 
     * <p>Relationship: PORX_MT060340CA.DetectedIssueEvent.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Enables extra or more detailed description of the 
     * alert</p>
     * 
     * <p>A free form textual description regarding the issue of 
     * fraudulence. This may be specified in place of, or in 
     * addition to the coded issue.</p>
     * 
     * <p>Un-merged Business Name: IssueDetails</p>
     * 
     * <p>Relationship: COCT_MT260012CA.DetectedIssueEvent.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Contraindication.DDIDescription</p>
     * 
     * <p>E20(for contraindication errors are handled at 
     * transmission or controlact wrapper level)</p>
     * 
     * <p>ZPE.4</p>
     * 
     * <p>ZDU.11.1</p>
     * 
     * <p>Lets providers see textual explanation of the issue.</p>
     * 
     * <p>A free form textual description of a detected issue. This 
     * textual information is provided to either augment the coded 
     * information or in place of the coded information.</p>
     * 
     * <p>Un-merged Business Name: IssueComment</p>
     * 
     * <p>Relationship: PORX_MT060190CA.DetectedIssueEvent.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Enables extra or more detailed description of the 
     * alert</p>
     * 
     * <p>A free form textual description regarding the issue of 
     * fraudulence. This may be specified in place of, or in 
     * addition to the coded issue.</p>
     * 
     * <p>Un-merged Business Name: IssueComment</p>
     * 
     * <p>Relationship: PORX_MT060040CA.DetectedIssueEvent.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Enables extra or more detailed description of the 
     * alert</p>
     * 
     * <p>A free form textual description regarding the issue of 
     * fraudulence. This may be specified in place of, or in 
     * addition to the coded issue.</p>
     * 
     * <p>Un-merged Business Name: IssueDetails</p>
     * 
     * <p>Relationship: COCT_MT260010CA.DetectedIssueEvent.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Contraindication.DDIDescription</p>
     * 
     * <p>E20(for contraindication errors are handled at 
     * transmission or controlact wrapper level)</p>
     * 
     * <p>ZPE.4</p>
     * 
     * <p>ZDU.11.1</p>
     * 
     * <p>Lets providers see textual explanation of the issue.</p>
     * 
     * <p>A free form textual description of a detected issue. This 
     * textual information is provided to either augment the coded 
     * information or in place of the coded information.</p>
     * 
     * <p>Un-merged Business Name: IssueComment</p>
     * 
     * <p>Relationship: PORX_MT060060CA.DetectedIssueEvent.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Enables extra or more detailed description of the 
     * alert</p>
     * 
     * <p>A free form textual description regarding the issue. This 
     * may be specified in place of, or in addition to the coded 
     * issue.</p>
     */
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>Business Name: IssuePriority</p>
     * 
     * <p>Un-merged Business Name: IssuePriority</p>
     * 
     * <p>Relationship: 
     * COCT_MT260012CA.DetectedIssueEvent.priorityCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the provider to make informed decision on the 
     * importance and criticality of an issue. May also be used by 
     * the DIS to determine the order of returning issues. 
     * Attribute is mandatory because every issue needs to be 
     * prioritized.</p>
     * 
     * <p>A coded value denoting the importance of a detectable 
     * issue. Valid codes are: I - for Information, E - for Error, 
     * and W - for Warning.</p>
     * 
     * <p>Un-merged Business Name: IssuePriority</p>
     * 
     * <p>Relationship: 
     * COCT_MT260010CA.DetectedIssueEvent.priorityCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the provider to make informed decision on the 
     * importance and criticality of an issue. May also be used by 
     * the DIS to determine the order of returning issues. 
     * Attribute is mandatory because every issue needs to be 
     * prioritized.</p>
     * 
     * <p>A coded value denoting the importance of a detectable 
     * issue. Valid codes are: I - for Information, E - for Error, 
     * and W - for Warning.</p>
     */
    @Hl7XmlMapping({"priorityCode"})
    public ActIssuePriority getPriorityCode() {
        return (ActIssuePriority) this.priorityCode.getValue();
    }

    /**
     * <p>Business Name: IssuePriority</p>
     * 
     * <p>Un-merged Business Name: IssuePriority</p>
     * 
     * <p>Relationship: 
     * COCT_MT260012CA.DetectedIssueEvent.priorityCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the provider to make informed decision on the 
     * importance and criticality of an issue. May also be used by 
     * the DIS to determine the order of returning issues. 
     * Attribute is mandatory because every issue needs to be 
     * prioritized.</p>
     * 
     * <p>A coded value denoting the importance of a detectable 
     * issue. Valid codes are: I - for Information, E - for Error, 
     * and W - for Warning.</p>
     * 
     * <p>Un-merged Business Name: IssuePriority</p>
     * 
     * <p>Relationship: 
     * COCT_MT260010CA.DetectedIssueEvent.priorityCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the provider to make informed decision on the 
     * importance and criticality of an issue. May also be used by 
     * the DIS to determine the order of returning issues. 
     * Attribute is mandatory because every issue needs to be 
     * prioritized.</p>
     * 
     * <p>A coded value denoting the importance of a detectable 
     * issue. Valid codes are: I - for Information, E - for Error, 
     * and W - for Warning.</p>
     */
    public void setPriorityCode(ActIssuePriority priorityCode) {
        this.priorityCode.setValue(priorityCode);
    }


    /**
     * <p>Business Name: MessageIssueLocation</p>
     * 
     * <p>Un-merged Business Name: MessageIssueLocation</p>
     * 
     * <p>Relationship: 
     * COCT_MT260012CA.DetectedIssueEvent.targetSiteCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     * 
     * <p>Used to identify XPath references that indicate which 
     * attributes from the message instance were involved in the 
     * issue.</p>
     * 
     * <p>Un-merged Business Name: MessageIssueLocation</p>
     * 
     * <p>Relationship: 
     * COCT_MT260010CA.DetectedIssueEvent.targetSiteCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     * 
     * <p>Used to identify XPath references that indicate which 
     * attributes from the message instance were involved in the 
     * issue.</p>
     */
    @Hl7XmlMapping({"targetSiteCode"})
    public Set<String> getTargetSiteCode() {
        return this.targetSiteCode.rawSet();
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT260012CA.Mitigates.detectedIssueManagement</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT260010CA.Mitigates.detectedIssueManagement</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"mitigatedBy/detectedIssueManagement"})
    public List<IssueManagements_1Bean> getMitigatedByDetectedIssueManagement() {
        return this.mitigatedByDetectedIssueManagement;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT260010CA.Subject2.causalActs</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subject/causalActs"})
    public List<CausalActs> getSubjectCausalActs() {
        return this.subjectCausalActs;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT260010CA.Definition.detectedIssueDefinition</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"instantiation/detectedIssueDefinition"})
    public IssueDescriptionBean getInstantiationDetectedIssueDefinition() {
        return this.instantiationDetectedIssueDefinition;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT260010CA.Definition.detectedIssueDefinition</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setInstantiationDetectedIssueDefinition(IssueDescriptionBean instantiationDetectedIssueDefinition) {
        this.instantiationDetectedIssueDefinition = instantiationDetectedIssueDefinition;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT260010CA.Subject.severityObservation</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"subjectOf/severityObservation"})
    public AllergyIntoleranceSeverityLevelBean getSubjectOfSeverityObservation() {
        return this.subjectOfSeverityObservation;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT260010CA.Subject.severityObservation</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSubjectOfSeverityObservation(AllergyIntoleranceSeverityLevelBean subjectOfSeverityObservation) {
        this.subjectOfSeverityObservation = subjectOfSeverityObservation;
    }

}