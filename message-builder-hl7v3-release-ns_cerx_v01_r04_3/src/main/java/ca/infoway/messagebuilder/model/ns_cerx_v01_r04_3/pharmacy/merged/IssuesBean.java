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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ns_cerx_v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ActDetectedIssueCode;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Issues</p>
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
 * <p>PORX_MT060060CA.DetectedIssueEvent: Issues</p>
 * 
 * <p>Allows a dispenser to assert an issue against a 
 * prescription to be displayed to subsequent dispensers as 
 * well as others reviewing the patient's profile.</p>
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
 * <p>PORX_MT060190CA.DetectedIssueEvent: Issues</p>
 * 
 * <p>Allows a dispenser to assert an issue against a 
 * prescription to be displayed to subsequent dispensers as 
 * well as others reviewing the patient's medication 
 * profile.</p>
 * 
 * <p>Describes an issue associated with a prescription that 
 * resulted in a dispenser refusing to fill it.</p>
 */
@Hl7PartTypeMapping({"PORX_MT030040CA.DetectedIssueEvent","PORX_MT060040CA.DetectedIssueEvent","PORX_MT060060CA.DetectedIssueEvent","PORX_MT060160CA.DetectedIssueEvent","PORX_MT060190CA.DetectedIssueEvent","PORX_MT060340CA.DetectedIssueEvent"})
public class IssuesBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private CV code = new CVImpl();
    private ST text = new STImpl();


    /**
     * <p>Business Name: IssueType</p>
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
     */
    public void setCode(ActDetectedIssueCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: IssueComment</p>
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
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: IssueComment</p>
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
     */
    public void setText(String text) {
        this.text.setValue(text);
    }

}
