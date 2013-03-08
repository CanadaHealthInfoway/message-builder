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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.pharmacy.merged;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.domainvalue.ActSupplyFulfillmentRefusalReason;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.IssuesBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.OccurredAtBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.RefusedByBean;



/**
 * <p>PORX_MT060340CA.RefusalToFill: Refusal to Fills</p>
 * 
 * <p>One of Refusal to Fill Reason or an Issue must be 
 * specified but not both</p>
 * 
 * <p>Exposes in the model that this issue is associated with a 
 * refusal to dispense.</p><p>An indication of 'refusal to 
 * fill' must be indicated, thus attribute is mandatory.</p>
 * 
 * <p>Indicates that the identified issue resulted in a 
 * dispenser refusing to fill the subject prescription.</p>
 * 
 * <p>PORX_MT060060CA.RefusalToFill: Refusal To Fills</p>
 * 
 * <p>One of Refusal To Fill Reason or Issue must be specified 
 * but not both</p>
 * 
 * <p>Exposes in the model that this issue is associated with a 
 * refusal to dispense.</p><p>An indication of 'refusal to 
 * fill' must be indicated, thus attribute is mandatory.</p>
 * 
 * <p>Indicates that the identified issue resulted in a 
 * dispenser refusing to fill the subject prescription.</p>
 * 
 * <p>PORX_MT030040CA.RefusalToFill: Refusal to Fills</p>
 * 
 * <p>One of Refusal To Fill Reason or Issue must be specified, 
 * but not both.</p>
 * 
 * <p>Exposes in the model that this issue is associated with a 
 * refusal to dispense.</p><p>An indication of 'refusal to 
 * fill' must be indicated, thus attribute is mandatory.</p>
 * 
 * <p>Indicates that the identified issue resulted in a 
 * dispenser refusing to fill the subject prescription.</p>
 * 
 * <p>PORX_MT060190CA.RefusalToFill: Refusal To Fills</p>
 * 
 * <p>One of Refusal To Fill Reason or Issue must be specified 
 * but not both</p>
 * 
 * <p>Exposes in the model that this issue is associated with a 
 * refusal to dispense.</p><p>An indication of 'refusal to 
 * fill' must be indicated, thus attribute is mandatory.</p>
 * 
 * <p>Indicates that the identified issue resulted in a 
 * dispenser refusing to fill the subject prescription.</p>
 * 
 * <p>PORX_MT060040CA.RefusalToFill: Refusals To Fills</p>
 * 
 * <p>One of Refusal To Fill Reason or Issue must be specified 
 * but not both</p>
 * 
 * <p>Exposes in the model that this issue is associated with a 
 * refusal to dispense.</p><p>An indication of 'refusal to 
 * fill' must be indicated, thus attribute is mandatory.</p>
 * 
 * <p>Indicates that the identified issue resulted in a 
 * dispenser refusing to fill the subject prescription. .</p>
 * 
 * <p>PORX_MT060160CA.RefusalToFill: Fill Refusals</p>
 * 
 * <p>One of Refusal to Fill Reason or an Issue must be 
 * specified but no both</p>
 * 
 * <p>Exposes in the model that this issue is associated with a 
 * refusal to dispense.</p><p>An indication of 'refusal to 
 * fill' must be indicated, thus attribute is mandatory.</p>
 * 
 * <p>Indicates that the identified issue resulted in a 
 * dispenser refusing to fill the subject prescription.</p>
 */
@Hl7PartTypeMapping({"PORX_MT030040CA.RefusalToFill","PORX_MT060040CA.RefusalToFill","PORX_MT060060CA.RefusalToFill","PORX_MT060160CA.RefusalToFill","PORX_MT060190CA.RefusalToFill","PORX_MT060340CA.RefusalToFill"})
public class RefusalToFillsBean extends MessagePartBean {

    private static final long serialVersionUID = 20130307L;
    private TS effectiveTime = new TSImpl();
    private CV reasonCode = new CVImpl();
    private RefusedByBean author;
    private OccurredAtBean location;
    private List<IssuesBean> reasonDetectedIssueEvent = new ArrayList<IssuesBean>();


    /**
     * <p>Business Name: RefusalToFillDate</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillDate</p>
     * 
     * <p>Relationship: PORX_MT060060CA.RefusalToFill.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>May be important to down stream providers to know when 
     * the refusal occurred.</p><p>Is marked as populated as it may 
     * not always be known for historical data pre- loaded into the 
     * EHR</p>
     * 
     * <p>The date that the dispenser refused to fill the 
     * prescription</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillDate</p>
     * 
     * <p>Relationship: PORX_MT060340CA.RefusalToFill.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>May be important to down stream providers to know when 
     * the refusal occurred.</p><p>Is marked as populated as it may 
     * not always be known for historical data pre- loaded into the 
     * EHR</p>
     * 
     * <p>The date that the dispenser refused to fill the 
     * prescription</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillDate</p>
     * 
     * <p>Relationship: PORX_MT030040CA.RefusalToFill.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>May be important to down stream providers to know when 
     * the refusal occured.</p><p>Is marked as populated as it may 
     * not always be known for historical data pre- loaded into the 
     * EHR</p>
     * 
     * <p>The date that the dispenser refused to fill the 
     * prescitpion</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillDate</p>
     * 
     * <p>Relationship: PORX_MT060040CA.RefusalToFill.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>May be important to down stream providers to know when 
     * the refusal occurred.</p><p>Is marked as populated as it may 
     * not always be known for historical data pre- loaded into the 
     * EHR</p>
     * 
     * <p>The date that the dispenser refused to fill the 
     * prescription</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillDate</p>
     * 
     * <p>Relationship: PORX_MT060190CA.RefusalToFill.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>May be important to down stream providers to know when 
     * the refusal occurred.</p><p>Is marked as populated as it may 
     * not always be known for historical data pre- loaded into the 
     * EHR</p>
     * 
     * <p>The date that the dispenser refused to fill the 
     * prescription</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillDate</p>
     * 
     * <p>Relationship: PORX_MT060160CA.RefusalToFill.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>May be important to down stream providers to know when 
     * the refusal occurred.</p><p>Is marked as populated as it may 
     * not always be known for historical data pre- loaded into the 
     * EHR</p>
     * 
     * <p>The date that the dispenser refused to fill the 
     * prescription</p>
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
     * <p>May be important to down stream providers to know when 
     * the refusal occurred.</p><p>Is marked as populated as it may 
     * not always be known for historical data pre- loaded into the 
     * EHR</p>
     * 
     * <p>The date that the dispenser refused to fill the 
     * prescription</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillDate</p>
     * 
     * <p>Relationship: PORX_MT060340CA.RefusalToFill.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>May be important to down stream providers to know when 
     * the refusal occurred.</p><p>Is marked as populated as it may 
     * not always be known for historical data pre- loaded into the 
     * EHR</p>
     * 
     * <p>The date that the dispenser refused to fill the 
     * prescription</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillDate</p>
     * 
     * <p>Relationship: PORX_MT030040CA.RefusalToFill.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>May be important to down stream providers to know when 
     * the refusal occured.</p><p>Is marked as populated as it may 
     * not always be known for historical data pre- loaded into the 
     * EHR</p>
     * 
     * <p>The date that the dispenser refused to fill the 
     * prescitpion</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillDate</p>
     * 
     * <p>Relationship: PORX_MT060040CA.RefusalToFill.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>May be important to down stream providers to know when 
     * the refusal occurred.</p><p>Is marked as populated as it may 
     * not always be known for historical data pre- loaded into the 
     * EHR</p>
     * 
     * <p>The date that the dispenser refused to fill the 
     * prescription</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillDate</p>
     * 
     * <p>Relationship: PORX_MT060190CA.RefusalToFill.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>May be important to down stream providers to know when 
     * the refusal occurred.</p><p>Is marked as populated as it may 
     * not always be known for historical data pre- loaded into the 
     * EHR</p>
     * 
     * <p>The date that the dispenser refused to fill the 
     * prescription</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillDate</p>
     * 
     * <p>Relationship: PORX_MT060160CA.RefusalToFill.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>May be important to down stream providers to know when 
     * the refusal occurred.</p><p>Is marked as populated as it may 
     * not always be known for historical data pre- loaded into the 
     * EHR</p>
     * 
     * <p>The date that the dispenser refused to fill the 
     * prescription</p>
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
     * <p>Supports capture of reasons such as 'moral objection' 
     * which are not tied to specific issues. Set as CWE to allow 
     * non-coded reasons.</p>
     * 
     * <p>Indicates a non-clinical-issue based reason for refusing 
     * to fill.</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillReason</p>
     * 
     * <p>Relationship: PORX_MT060340CA.RefusalToFill.reasonCode</p>
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
     * <p>Relationship: PORX_MT030040CA.RefusalToFill.reasonCode</p>
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
     * <p>Relationship: PORX_MT060040CA.RefusalToFill.reasonCode</p>
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
     * <p>Relationship: PORX_MT060190CA.RefusalToFill.reasonCode</p>
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
     * <p>Relationship: PORX_MT060160CA.RefusalToFill.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Supports capture of reasons such as 'moral objection' 
     * which are not tied to specific issues. Set as CWE to allow 
     * for non-coded reasons.</p>
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
     * <p>Relationship: PORX_MT060060CA.RefusalToFill.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Supports capture of reasons such as 'moral objection' 
     * which are not tied to specific issues. Set as CWE to allow 
     * non-coded reasons.</p>
     * 
     * <p>Indicates a non-clinical-issue based reason for refusing 
     * to fill.</p>
     * 
     * <p>Un-merged Business Name: RefusalToFillReason</p>
     * 
     * <p>Relationship: PORX_MT060340CA.RefusalToFill.reasonCode</p>
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
     * <p>Relationship: PORX_MT030040CA.RefusalToFill.reasonCode</p>
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
     * <p>Relationship: PORX_MT060040CA.RefusalToFill.reasonCode</p>
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
     * <p>Relationship: PORX_MT060190CA.RefusalToFill.reasonCode</p>
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
     * <p>Relationship: PORX_MT060160CA.RefusalToFill.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Supports capture of reasons such as 'moral objection' 
     * which are not tied to specific issues. Set as CWE to allow 
     * for non-coded reasons.</p>
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
     * <p>Relationship: PORX_MT060060CA.RefusalToFill.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340CA.RefusalToFill.author</p>
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
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160CA.RefusalToFill.author</p>
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
     * <p>Relationship: PORX_MT060340CA.RefusalToFill.author</p>
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
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160CA.RefusalToFill.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthor(RefusedByBean author) {
        this.author = author;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060060CA.RefusalToFill.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340CA.RefusalToFill.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
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
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060190CA.RefusalToFill.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160CA.RefusalToFill.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"location"})
    public OccurredAtBean getLocation() {
        return this.location;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060060CA.RefusalToFill.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340CA.RefusalToFill.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
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
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060190CA.RefusalToFill.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160CA.RefusalToFill.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setLocation(OccurredAtBean location) {
        this.location = location;
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
     * <p>Relationship: PORX_MT060340CA.Reason.detectedIssueEvent</p>
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
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160CA.Reason.detectedIssueEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"reason/detectedIssueEvent"})
    public List<IssuesBean> getReasonDetectedIssueEvent() {
        return this.reasonDetectedIssueEvent;
    }

}
