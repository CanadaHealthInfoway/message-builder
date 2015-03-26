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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.coct_mt260020ca;

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
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged.CausalActs;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged.IssueDescriptionBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged.IssueManagements_2Bean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.AllergyIntoleranceSeverityLevelBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Business Name: Issues</p>
 * 
 * <p>Provides a list of issues that have been detected.</p>
 * 
 * <p>This is the list of clinical and business-rule issues 
 * that have been detected and recorded involving the current 
 * action.</p>
 */
@Hl7PartTypeMapping({"COCT_MT260020CA.DetectedIssueEvent"})
@Hl7RootType
public class IssuesBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private CV code = new CVImpl();
    private ST text = new STImpl();
    private CV priorityCode = new CVImpl();
    private List<CausalActs> subjectCausalActs = new ArrayList<CausalActs>();
    private IssueDescriptionBean instantiationDetectedIssueDefinition;
    private List<IssueManagements_2Bean> mitigatedByDetectedIssueManagement = new ArrayList<IssueManagements_2Bean>();
    private BL triggerForActRequest = new BLImpl(false);
    private BL subjectOf1StorageIntent = new BLImpl(false);
    private AllergyIntoleranceSeverityLevelBean subjectOf2SeverityObservation;


    /**
     * <p>Business Name: A:Issue Type</p>
     * 
     * <p>Relationship: COCT_MT260020CA.DetectedIssueEvent.code</p>
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
     * <p>Identifies what kind of issue was detected.</p><p>This is 
     * mandatory so as to ensure that one issue type can be 
     * distinguished from another.</p>
     * 
     * <p>A coded value that is used to distinguish between 
     * different kinds of issues. Types of issue include: 
     * unrecognized identifiers, permission issues, drug-drug 
     * contraindications, drug-allergy alerts, duplicate therapies, 
     * etc.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActDetectedIssueCode getCode() {
        return (ActDetectedIssueCode) this.code.getValue();
    }

    /**
     * <p>Business Name: A:Issue Type</p>
     * 
     * <p>Relationship: COCT_MT260020CA.DetectedIssueEvent.code</p>
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
     * <p>Identifies what kind of issue was detected.</p><p>This is 
     * mandatory so as to ensure that one issue type can be 
     * distinguished from another.</p>
     * 
     * <p>A coded value that is used to distinguish between 
     * different kinds of issues. Types of issue include: 
     * unrecognized identifiers, permission issues, drug-drug 
     * contraindications, drug-allergy alerts, duplicate therapies, 
     * etc.</p>
     */
    public void setCode(ActDetectedIssueCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: D:Issue Details</p>
     * 
     * <p>Relationship: COCT_MT260020CA.DetectedIssueEvent.text</p>
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
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: D:Issue Details</p>
     * 
     * <p>Relationship: COCT_MT260020CA.DetectedIssueEvent.text</p>
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
     */
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>Business Name: C:Issue Priority</p>
     * 
     * <p>Relationship: 
     * COCT_MT260020CA.DetectedIssueEvent.priorityCode</p>
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
     * <p>Business Name: C:Issue Priority</p>
     * 
     * <p>Relationship: 
     * COCT_MT260020CA.DetectedIssueEvent.priorityCode</p>
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
     * <p>Relationship: COCT_MT260020CA.Subject2.causalActs</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subject/causalActs"})
    public List<CausalActs> getSubjectCausalActs() {
        return this.subjectCausalActs;
    }


    /**
     * <p>Relationship: 
     * COCT_MT260020CA.Definition.detectedIssueDefinition</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"instantiation/detectedIssueDefinition"})
    public IssueDescriptionBean getInstantiationDetectedIssueDefinition() {
        return this.instantiationDetectedIssueDefinition;
    }

    /**
     * <p>Relationship: 
     * COCT_MT260020CA.Definition.detectedIssueDefinition</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setInstantiationDetectedIssueDefinition(IssueDescriptionBean instantiationDetectedIssueDefinition) {
        this.instantiationDetectedIssueDefinition = instantiationDetectedIssueDefinition;
    }


    /**
     * <p>Relationship: 
     * COCT_MT260020CA.Mitigates.detectedIssueManagement</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"mitigatedBy/detectedIssueManagement"})
    public List<IssueManagements_2Bean> getMitigatedByDetectedIssueManagement() {
        return this.mitigatedByDetectedIssueManagement;
    }


    /**
     * <p>Relationship: COCT_MT260020CA.Trigger2.actRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"triggerFor/actRequest"})
    public Boolean getTriggerForActRequest() {
        return this.triggerForActRequest.getValue();
    }

    /**
     * <p>Relationship: COCT_MT260020CA.Trigger2.actRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setTriggerForActRequest(Boolean triggerForActRequest) {
        this.triggerForActRequest.setValue(triggerForActRequest);
    }


    /**
     * <p>Relationship: COCT_MT260020CA.Subject3.storageIntent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf1/storageIntent"})
    public Boolean getSubjectOf1StorageIntent() {
        return this.subjectOf1StorageIntent.getValue();
    }

    /**
     * <p>Relationship: COCT_MT260020CA.Subject3.storageIntent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf1StorageIntent(Boolean subjectOf1StorageIntent) {
        this.subjectOf1StorageIntent.setValue(subjectOf1StorageIntent);
    }


    /**
     * <p>Relationship: COCT_MT260020CA.Subject.severityObservation</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/severityObservation"})
    public AllergyIntoleranceSeverityLevelBean getSubjectOf2SeverityObservation() {
        return this.subjectOf2SeverityObservation;
    }

    /**
     * <p>Relationship: COCT_MT260020CA.Subject.severityObservation</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSubjectOf2SeverityObservation(AllergyIntoleranceSeverityLevelBean subjectOf2SeverityObservation) {
        this.subjectOf2SeverityObservation = subjectOf2SeverityObservation;
    }

}
