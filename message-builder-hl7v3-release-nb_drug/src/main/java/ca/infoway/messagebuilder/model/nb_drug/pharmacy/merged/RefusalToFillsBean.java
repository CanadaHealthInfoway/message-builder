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
package ca.infoway.messagebuilder.model.nb_drug.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.domainvalue.ActSupplyFulfillmentRefusalReason;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.nb_drug.merged.RecordedAtBean;
import ca.infoway.messagebuilder.model.nb_drug.merged.RefusedByBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>PORX_MT030040NB.RefusalToFill: Refusal to Fills</p>
 * 
 * <p>One of 'Refusal To Fill Reason' or 'Issue' must be 
 * specified, but not both.</p>
 * 
 * <p>Exposes in the model that this issue is associated with a 
 * refusal to dispense.</p><p>An indication of 'refusal to 
 * fill' must be indicated, thus attribute is mandatory.</p>
 * 
 * <p>Indicates that the identified issue resulted in a 
 * dispenser refusing to fill the subject prescription.</p>
 * 
 * <p>PORX_MT060340NB.RefusalToFill: Refusal to Fills</p>
 * 
 * <p>One of 'Refusal to Fill Reason' or an 'Issue' must be 
 * specified but not both</p>
 * 
 * <p>Exposes in the model that this issue is associated with a 
 * refusal to dispense.</p><p>An indication of 'refusal to 
 * fill' must be indicated, thus attribute is mandatory.</p>
 * 
 * <p>Indicates that the identified issue resulted in a 
 * dispenser refusing to fill the subject prescription.</p>
 * 
 * <p>PORX_MT060190NB.RefusalToFill: Refusal To Fills</p>
 * 
 * <p>One of 'Refusal To Fill Reason' or Issue must be 
 * specified but not both</p>
 * 
 * <p>Exposes in the model that this issue is associated with a 
 * refusal to dispense.</p><p>An indication of 'refusal to 
 * fill' must be indicated, thus attribute is mandatory.</p>
 * 
 * <p>Indicates that the identified issue resulted in a 
 * dispenser refusing to fill the subject prescription.</p>
 * 
 * <p>PORX_MT060160NB.RefusalToFill: Fill Refusals</p>
 * 
 * <p>One of 'Refusal to Fill Reason' or an Issue must be 
 * specified but no both</p>
 * 
 * <p>Exposes in the model that this issue is associated with a 
 * refusal to dispense.</p><p>An indication of 'refusal to 
 * fill' must be indicated, thus attribute is mandatory.</p>
 * 
 * <p>Indicates that the identified issue resulted in a 
 * dispenser refusing to fill the subject prescription.</p>
 * 
 * <p>PORX_MT060060NB.RefusalToFill: Refusal To Fills</p>
 * 
 * <p>One of 'Refusal To Fill Reason' or Issue must be 
 * specified but not both</p>
 * 
 * <p>Exposes in the model that this issue is associated with a 
 * refusal to dispense.</p><p>An indication of 'refusal to 
 * fill' must be indicated, thus attribute is mandatory.</p>
 * 
 * <p>Indicates that the identified issue resulted in a 
 * dispenser refusing to fill the subject prescription.</p>
 * 
 * <p>PORX_MT060040NB.RefusalToFill: Refusals To Fills</p>
 * 
 * <p>One of 'Refusal To Fill Reason' or Issue must be 
 * specified but not both</p>
 * 
 * <p>Exposes in the model that this issue is associated with a 
 * refusal to dispense.</p><p>An indication of 'refusal to 
 * fill' must be indicated, thus attribute is mandatory.</p>
 * 
 * <p>Indicates that the identified issue resulted in a 
 * dispenser refusing to fill the subject prescription. .</p>
 */
@Hl7PartTypeMapping({"PORX_MT030040NB.RefusalToFill","PORX_MT060040NB.RefusalToFill","PORX_MT060060NB.RefusalToFill","PORX_MT060160NB.RefusalToFill","PORX_MT060190NB.RefusalToFill","PORX_MT060340NB.RefusalToFill"})
public class RefusalToFillsBean extends MessagePartBean {

    private static final long serialVersionUID = 20150901L;
    private TS effectiveTime = new TSImpl();
    private CV reasonCode = new CVImpl();
    private RefusedByBean author;
    private RecordedAtBean location;
    private List<IssuesBean> reasonDetectedIssueEvent = new ArrayList<IssuesBean>();


    /**
     * <p>Business Name: RefusalToFillDate</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillDate</p>
     * 
     * <p>Relationship: PORX_MT030040NB.RefusalToFill.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillDate</p>
     * 
     * <p>Relationship: PORX_MT060340NB.RefusalToFill.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillDate</p>
     * 
     * <p>Relationship: PORX_MT060190NB.RefusalToFill.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillDate</p>
     * 
     * <p>Relationship: PORX_MT060160NB.RefusalToFill.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillDate</p>
     * 
     * <p>Relationship: PORX_MT060040NB.RefusalToFill.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillDate</p>
     * 
     * <p>Relationship: PORX_MT060060NB.RefusalToFill.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: RefusalToFillDate</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillDate</p>
     * 
     * <p>Relationship: PORX_MT030040NB.RefusalToFill.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillDate</p>
     * 
     * <p>Relationship: PORX_MT060340NB.RefusalToFill.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillDate</p>
     * 
     * <p>Relationship: PORX_MT060190NB.RefusalToFill.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillDate</p>
     * 
     * <p>Relationship: PORX_MT060160NB.RefusalToFill.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillDate</p>
     * 
     * <p>Relationship: PORX_MT060040NB.RefusalToFill.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillDate</p>
     * 
     * <p>Relationship: PORX_MT060060NB.RefusalToFill.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: RefusalToFillReason</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillReason</p>
     * 
     * <p>Relationship: PORX_MT030040NB.RefusalToFill.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates a non-clinical-issue based reason for refusing 
     * to fill. Allows CWE for non-coded reasons.</p>
     * 
     * <p>Indicates a non-clinical-issue based reason for refusing 
     * to fill.</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillReason</p>
     * 
     * <p>Relationship: PORX_MT060340NB.RefusalToFill.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Supports capture of reasons such as 'moral objection' 
     * which are not tied to specific issues. Set to CWE to allow 
     * non-coded reasons.</p>
     * 
     * <p>Indicates a non-clinical-issue based reason for refusing 
     * to fill.</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillReason</p>
     * 
     * <p>Relationship: PORX_MT060190NB.RefusalToFill.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Supports capture of reasons such as 'moral objection' 
     * which are not tied to specific issues. Set to CWE to allow 
     * non-coded reasons.</p>
     * 
     * <p>Indicates a non-clinical-issue based reason for refusing 
     * to fill.</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillReason</p>
     * 
     * <p>Relationship: PORX_MT060160NB.RefusalToFill.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Supports capture of reasons such as 'moral objection' 
     * which are not tied to specific issues. Set as CWE to allow 
     * for non-coded reasons.</p>
     * 
     * <p>Indicates a non-clinical-issue based reason for refusing 
     * to fill.</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillReason</p>
     * 
     * <p>Relationship: PORX_MT060040NB.RefusalToFill.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Supports capture of reasons such as 'moral objection' 
     * which are not tied to specific issues. The element is CWE to 
     * allow for non-coded reasons.</p>
     * 
     * <p>Indicates a non-clinical-issue based reason for refusing 
     * to fill.</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillReason</p>
     * 
     * <p>Relationship: PORX_MT060060NB.RefusalToFill.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Supports capture of reasons such as 'moral objection' 
     * which are not tied to specific issues. Set as CWE to allow 
     * non-coded reasons.</p>
     * 
     * <p>Indicates a non-clinical-issue based reason for refusing 
     * to fill.</p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public ActSupplyFulfillmentRefusalReason getReasonCode() {
        return (ActSupplyFulfillmentRefusalReason) this.reasonCode.getValue();
    }

    /**
     * <p>Business Name: RefusalToFillReason</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillReason</p>
     * 
     * <p>Relationship: PORX_MT030040NB.RefusalToFill.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates a non-clinical-issue based reason for refusing 
     * to fill. Allows CWE for non-coded reasons.</p>
     * 
     * <p>Indicates a non-clinical-issue based reason for refusing 
     * to fill.</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillReason</p>
     * 
     * <p>Relationship: PORX_MT060340NB.RefusalToFill.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Supports capture of reasons such as 'moral objection' 
     * which are not tied to specific issues. Set to CWE to allow 
     * non-coded reasons.</p>
     * 
     * <p>Indicates a non-clinical-issue based reason for refusing 
     * to fill.</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillReason</p>
     * 
     * <p>Relationship: PORX_MT060190NB.RefusalToFill.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Supports capture of reasons such as 'moral objection' 
     * which are not tied to specific issues. Set to CWE to allow 
     * non-coded reasons.</p>
     * 
     * <p>Indicates a non-clinical-issue based reason for refusing 
     * to fill.</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillReason</p>
     * 
     * <p>Relationship: PORX_MT060160NB.RefusalToFill.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Supports capture of reasons such as 'moral objection' 
     * which are not tied to specific issues. Set as CWE to allow 
     * for non-coded reasons.</p>
     * 
     * <p>Indicates a non-clinical-issue based reason for refusing 
     * to fill.</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillReason</p>
     * 
     * <p>Relationship: PORX_MT060040NB.RefusalToFill.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Supports capture of reasons such as 'moral objection' 
     * which are not tied to specific issues. The element is CWE to 
     * allow for non-coded reasons.</p>
     * 
     * <p>Indicates a non-clinical-issue based reason for refusing 
     * to fill.</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillReason</p>
     * 
     * <p>Relationship: PORX_MT060060NB.RefusalToFill.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Supports capture of reasons such as 'moral objection' 
     * which are not tied to specific issues. Set as CWE to allow 
     * non-coded reasons.</p>
     * 
     * <p>Indicates a non-clinical-issue based reason for refusing 
     * to fill.</p>
     */
    public void setReasonCode(ActSupplyFulfillmentRefusalReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT030040NB.RefusalToFill.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340NB.RefusalToFill.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060190NB.RefusalToFill.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160NB.RefusalToFill.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060040NB.RefusalToFill.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060060NB.RefusalToFill.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author"})
    public RefusedByBean getAuthor() {
        return this.author;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT030040NB.RefusalToFill.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340NB.RefusalToFill.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060190NB.RefusalToFill.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160NB.RefusalToFill.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060040NB.RefusalToFill.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060060NB.RefusalToFill.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthor(RefusedByBean author) {
        this.author = author;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT030040NB.RefusalToFill.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340NB.RefusalToFill.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160NB.RefusalToFill.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060040NB.RefusalToFill.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"location"})
    public RecordedAtBean getLocation() {
        return this.location;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT030040NB.RefusalToFill.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340NB.RefusalToFill.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160NB.RefusalToFill.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060040NB.RefusalToFill.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setLocation(RecordedAtBean location) {
        this.location = location;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT030040NB.Reason2.detectedIssueEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340NB.Reason.detectedIssueEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060190NB.Reason2.detectedIssueEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160NB.Reason.detectedIssueEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060040NB.Reason.detectedIssueEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060060NB.Reason2.detectedIssueEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"reason/detectedIssueEvent"})
    public List<IssuesBean> getReasonDetectedIssueEvent() {
        return this.reasonDetectedIssueEvent;
    }

}