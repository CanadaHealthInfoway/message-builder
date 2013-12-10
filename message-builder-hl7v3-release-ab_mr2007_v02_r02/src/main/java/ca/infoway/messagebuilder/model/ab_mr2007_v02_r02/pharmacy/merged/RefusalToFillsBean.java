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
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.domainvalue.ActSupplyFulfillmentRefusalReason;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.CreatedAtBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.IssuesBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.RefusedByBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>PORX_MT060060CA.RefusalToFill: Refusal To Fills</p>
 * 
 * <p>One of 'Refusal To Fill Reason' or Issue must be 
 * specified but not both</p>
 * 
 * <p>Indicates that the identified issue resulted in a 
 * dispenser refusing to fill the subject prescription.</p>
 * 
 * <p>Exposes in the model that this issue is associated with a 
 * refusal to dispense.</p><p>An indication of 'refusal to 
 * fill' must be indicated, thus attribute is mandatory.</p>
 * 
 * <p>Exposes in the model that this issue is associated with a 
 * refusal to dispense.</p><p>An indication of 'refusal to 
 * fill' must be indicated, thus attribute is mandatory.</p>
 * 
 * <p>PORX_MT030040CA.RefusalToFill: Refusal to Fills</p>
 * 
 * <p>One of 'Refusal To Fill Reason' or 'Issue' must be 
 * specified, but not both.</p>
 * 
 * <p>Indicates that the identified issue resulted in a 
 * dispenser refusing to fill the subject prescription.</p>
 * 
 * <p>Exposes in the model that this issue is associated with a 
 * refusal to dispense.</p><p>An indication of 'refusal to 
 * fill' must be indicated, thus attribute is mandatory.</p>
 * 
 * <p>Exposes in the model that this issue is associated with a 
 * refusal to dispense.</p><p>An indication of 'refusal to 
 * fill' must be indicated, thus attribute is mandatory.</p>
 * 
 * <p>PORX_MT060190CA.RefusalToFill: Refusal To Fills</p>
 * 
 * <p>One of 'Refusal To Fill Reason' or Issue must be 
 * specified but not both</p>
 * 
 * <p>Indicates that the identified issue resulted in a 
 * dispenser refusing to fill the subject prescription.</p>
 * 
 * <p>Exposes in the model that this issue is associated with a 
 * refusal to dispense.</p><p>An indication of 'refusal to 
 * fill' must be indicated, thus attribute is mandatory.</p>
 * 
 * <p>Exposes in the model that this issue is associated with a 
 * refusal to dispense.</p><p>An indication of 'refusal to 
 * fill' must be indicated, thus attribute is mandatory.</p>
 * 
 * <p>PORX_MT060040CA.RefusalToFill: Refusals To Fills</p>
 * 
 * <p>One of 'Refusal To Fill Reason' or Issue must be 
 * specified but not both</p>
 * 
 * <p>Indicates that the identified issue resulted in a 
 * dispenser refusing to fill the subject prescription. .</p>
 * 
 * <p>Exposes in the model that this issue is associated with a 
 * refusal to dispense.</p><p>An indication of 'refusal to 
 * fill' must be indicated, thus attribute is mandatory.</p>
 * 
 * <p>Exposes in the model that this issue is associated with a 
 * refusal to dispense.</p><p>An indication of 'refusal to 
 * fill' must be indicated, thus attribute is mandatory.</p>
 */
@Hl7PartTypeMapping({"PORX_MT030040CA.RefusalToFill","PORX_MT060040CA.RefusalToFill","PORX_MT060060CA.RefusalToFill","PORX_MT060190CA.RefusalToFill"})
public class RefusalToFillsBean extends MessagePartBean {

    private static final long serialVersionUID = 20131210L;
    private TS effectiveTime = new TSImpl();
    private CV reasonCode = new CVImpl();
    private RefusedByBean author;
    private List<IssuesBean> reasonDetectedIssueEvent = new ArrayList<IssuesBean>();
    private CreatedAtBean location;


    /**
     * <p>Business Name: RefusalToFillDate</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillDate</p>
     * 
     * <p>Relationship: PORX_MT060060CA.RefusalToFill.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>The date that the dispenser refused to fill the 
     * prescription</p>
     * 
     * <p>May be important to down stream providers to know when 
     * the refusal occurred.</p><p>Is marked as populated as it may 
     * not always be known for historical data pre- loaded into the 
     * EHR</p>
     * 
     * <p>May be important to down stream providers to know when 
     * the refusal occurred.</p><p>Is marked as populated as it may 
     * not always be known for historical data pre- loaded into the 
     * EHR</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillDate</p>
     * 
     * <p>Relationship: PORX_MT030040CA.RefusalToFill.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>The date that the dispenser refused to fill the 
     * prescitpion</p>
     * 
     * <p>May be important to down stream providers to know when 
     * the refusal occured.</p><p>Is marked as populated as it may 
     * not always be known for historical data pre- loaded into the 
     * EHR</p>
     * 
     * <p>May be important to down stream providers to know when 
     * the refusal occured.</p><p>Is marked as populated as it may 
     * not always be known for historical data pre- loaded into the 
     * EHR</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillDate</p>
     * 
     * <p>Relationship: PORX_MT060040CA.RefusalToFill.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>The date that the dispenser refused to fill the 
     * prescription</p>
     * 
     * <p>May be important to down stream providers to know when 
     * the refusal occurred.</p><p>Is marked as populated as it may 
     * not always be known for historical data pre- loaded into the 
     * EHR</p>
     * 
     * <p>May be important to down stream providers to know when 
     * the refusal occurred.</p><p>Is marked as populated as it may 
     * not always be known for historical data pre- loaded into the 
     * EHR</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillDate</p>
     * 
     * <p>Relationship: PORX_MT060190CA.RefusalToFill.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>The date that the dispenser refused to fill the 
     * prescription</p>
     * 
     * <p>May be important to down stream providers to know when 
     * the refusal occurred.</p><p>Is marked as populated as it may 
     * not always be known for historical data pre- loaded into the 
     * EHR</p>
     * 
     * <p>May be important to down stream providers to know when 
     * the refusal occurred.</p><p>Is marked as populated as it may 
     * not always be known for historical data pre- loaded into the 
     * EHR</p>
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
     * <p>Relationship: PORX_MT060060CA.RefusalToFill.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>The date that the dispenser refused to fill the 
     * prescription</p>
     * 
     * <p>May be important to down stream providers to know when 
     * the refusal occurred.</p><p>Is marked as populated as it may 
     * not always be known for historical data pre- loaded into the 
     * EHR</p>
     * 
     * <p>May be important to down stream providers to know when 
     * the refusal occurred.</p><p>Is marked as populated as it may 
     * not always be known for historical data pre- loaded into the 
     * EHR</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillDate</p>
     * 
     * <p>Relationship: PORX_MT030040CA.RefusalToFill.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>The date that the dispenser refused to fill the 
     * prescitpion</p>
     * 
     * <p>May be important to down stream providers to know when 
     * the refusal occured.</p><p>Is marked as populated as it may 
     * not always be known for historical data pre- loaded into the 
     * EHR</p>
     * 
     * <p>May be important to down stream providers to know when 
     * the refusal occured.</p><p>Is marked as populated as it may 
     * not always be known for historical data pre- loaded into the 
     * EHR</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillDate</p>
     * 
     * <p>Relationship: PORX_MT060040CA.RefusalToFill.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>The date that the dispenser refused to fill the 
     * prescription</p>
     * 
     * <p>May be important to down stream providers to know when 
     * the refusal occurred.</p><p>Is marked as populated as it may 
     * not always be known for historical data pre- loaded into the 
     * EHR</p>
     * 
     * <p>May be important to down stream providers to know when 
     * the refusal occurred.</p><p>Is marked as populated as it may 
     * not always be known for historical data pre- loaded into the 
     * EHR</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillDate</p>
     * 
     * <p>Relationship: PORX_MT060190CA.RefusalToFill.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>The date that the dispenser refused to fill the 
     * prescription</p>
     * 
     * <p>May be important to down stream providers to know when 
     * the refusal occurred.</p><p>Is marked as populated as it may 
     * not always be known for historical data pre- loaded into the 
     * EHR</p>
     * 
     * <p>May be important to down stream providers to know when 
     * the refusal occurred.</p><p>Is marked as populated as it may 
     * not always be known for historical data pre- loaded into the 
     * EHR</p>
     */
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: RefusalToFillReason</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillReason</p>
     * 
     * <p>Relationship: PORX_MT060060CA.RefusalToFill.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates a non-clinical-issue based reason for refusing 
     * to fill.</p>
     * 
     * <p>Supports capture of reasons such as 'moral objection' 
     * which are not tied to specific issues. Set as CWE to allow 
     * non-coded reasons.</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillReason</p>
     * 
     * <p>Relationship: PORX_MT030040CA.RefusalToFill.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates a non-clinical-issue based reason for refusing 
     * to fill.</p>
     * 
     * <p>Indicates a non-clinical-issue based reason for refusing 
     * to fill. Allows CWE for non-coded reasons.</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillReason</p>
     * 
     * <p>Relationship: PORX_MT060040CA.RefusalToFill.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates a non-clinical-issue based reason for refusing 
     * to fill.</p>
     * 
     * <p>Supports capture of reasons such as 'moral objection' 
     * which are not tied to specific issues. The element is CWE to 
     * allow for non-coded reasons.</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillReason</p>
     * 
     * <p>Relationship: PORX_MT060190CA.RefusalToFill.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates a non-clinical-issue based reason for refusing 
     * to fill.</p>
     * 
     * <p>Supports capture of reasons such as 'moral objection' 
     * which are not tied to specific issues. Set to CWE to allow 
     * non-coded reasons.</p>
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
     * <p>Relationship: PORX_MT060060CA.RefusalToFill.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates a non-clinical-issue based reason for refusing 
     * to fill.</p>
     * 
     * <p>Supports capture of reasons such as 'moral objection' 
     * which are not tied to specific issues. Set as CWE to allow 
     * non-coded reasons.</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillReason</p>
     * 
     * <p>Relationship: PORX_MT030040CA.RefusalToFill.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates a non-clinical-issue based reason for refusing 
     * to fill.</p>
     * 
     * <p>Indicates a non-clinical-issue based reason for refusing 
     * to fill. Allows CWE for non-coded reasons.</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillReason</p>
     * 
     * <p>Relationship: PORX_MT060040CA.RefusalToFill.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates a non-clinical-issue based reason for refusing 
     * to fill.</p>
     * 
     * <p>Supports capture of reasons such as 'moral objection' 
     * which are not tied to specific issues. The element is CWE to 
     * allow for non-coded reasons.</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillReason</p>
     * 
     * <p>Relationship: PORX_MT060190CA.RefusalToFill.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates a non-clinical-issue based reason for refusing 
     * to fill.</p>
     * 
     * <p>Supports capture of reasons such as 'moral objection' 
     * which are not tied to specific issues. Set to CWE to allow 
     * non-coded reasons.</p>
     */
    public void setReasonCode(ActSupplyFulfillmentRefusalReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060060CA.RefusalToFill.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT030040CA.RefusalToFill.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060040CA.RefusalToFill.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060190CA.RefusalToFill.author</p>
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
     * <p>Relationship: PORX_MT060060CA.RefusalToFill.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT030040CA.RefusalToFill.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060040CA.RefusalToFill.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060190CA.RefusalToFill.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthor(RefusedByBean author) {
        this.author = author;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060060CA.Reason2.detectedIssueEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT030040CA.Reason2.detectedIssueEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060040CA.Reason.detectedIssueEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060190CA.Reason2.detectedIssueEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"reason/detectedIssueEvent"})
    public List<IssuesBean> getReasonDetectedIssueEvent() {
        return this.reasonDetectedIssueEvent;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT030040CA.RefusalToFill.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060040CA.RefusalToFill.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"location"})
    public CreatedAtBean getLocation() {
        return this.location;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT030040CA.RefusalToFill.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060040CA.RefusalToFill.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setLocation(CreatedAtBean location) {
        this.location = location;
    }

}
