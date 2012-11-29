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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.domainvalue.ActSupplyFulfillmentRefusalReason;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.CreatedAtBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.IssuesBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.RefusedByBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>PORX_MT060340CA.RefusalToFill: Refusal to Fills</p>
 * 
 * <p>One of 'Refusal to Fill Reason' or an 'Issue' must be 
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
 * 
 * <p>PORX_MT060160CA.RefusalToFill: Fill Refusals</p>
 * 
 * <p>One of 'Refusal to Fill Reason' or an Issue must be 
 * specified but no both</p>
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
 */
@Hl7PartTypeMapping({"PORX_MT030040CA.RefusalToFill","PORX_MT060040CA.RefusalToFill","PORX_MT060060CA.RefusalToFill","PORX_MT060160CA.RefusalToFill","PORX_MT060190CA.RefusalToFill","PORX_MT060340CA.RefusalToFill"})
public class RefusalToFillsBean extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
    private TS effectiveTime = new TSImpl();
    private CV reasonCode = new CVImpl();
    private RefusedByBean author;
    private CreatedAtBean location;
    private List<IssuesBean> reasonDetectedIssueEvent = new ArrayList<IssuesBean>();


    /**
     * <p>RefusalToFillDate</p>
     * 
     * <p>Refusal To Fill Date</p>
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
     * <p>Refusal To Fill Date</p>
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
     * <p>RefusalToFillDate</p>
     * 
     * <p>Refusal To Fill Date</p>
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
     * <p>Refusal To Fill Date</p>
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
     * <p>RefusalToFillReason</p>
     * 
     * <p>Refusal To Fill Reason</p>
     * 
     * <p>Indicates a non-clinical-issue based reason for refusing 
     * to fill.</p>
     * 
     * <p>Supports capture of reasons such as 'moral objection' 
     * which are not tied to specific issues. Set as CWE to allow 
     * non-coded reasons.</p>
     * 
     * <p>Refusal to Fill Reason</p>
     * 
     * <p>Indicates a non-clinical-issue based reason for refusing 
     * to fill.</p>
     * 
     * <p>Supports capture of reasons such as 'moral objection' 
     * which are not tied to specific issues. Set to CWE to allow 
     * non-coded reasons.</p>
     * 
     * <p>Refusal To Fill Reason</p>
     * 
     * <p>Indicates a non-clinical-issue based reason for refusing 
     * to fill.</p>
     * 
     * <p>Supports capture of reasons such as 'moral objection' 
     * which are not tied to specific issues. The element is CWE to 
     * allow for non-coded reasons.</p>
     * 
     * <p>Refusal to Fill Reason</p>
     * 
     * <p>Indicates a non-clinical-issue based reason for refusing 
     * to fill.</p>
     * 
     * <p>Indicates a non-clinical-issue based reason for refusing 
     * to fill. Allows CWE for non-coded reasons.</p>
     * 
     * <p>Refusal To Fill Reason</p>
     * 
     * <p>Indicates a non-clinical-issue based reason for refusing 
     * to fill.</p>
     * 
     * <p>Supports capture of reasons such as 'moral objection' 
     * which are not tied to specific issues. Set to CWE to allow 
     * non-coded reasons.</p>
     * 
     * <p>Refusal To Fill Reason</p>
     * 
     * <p>Indicates a non-clinical-issue based reason for refusing 
     * to fill.</p>
     * 
     * <p>Supports capture of reasons such as 'moral objection' 
     * which are not tied to specific issues. Set as CWE to allow 
     * for non-coded reasons.</p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public ActSupplyFulfillmentRefusalReason getReasonCode() {
        return (ActSupplyFulfillmentRefusalReason) this.reasonCode.getValue();
    }

    /**
     * <p>RefusalToFillReason</p>
     * 
     * <p>Refusal To Fill Reason</p>
     * 
     * <p>Indicates a non-clinical-issue based reason for refusing 
     * to fill.</p>
     * 
     * <p>Supports capture of reasons such as 'moral objection' 
     * which are not tied to specific issues. Set as CWE to allow 
     * non-coded reasons.</p>
     * 
     * <p>Refusal to Fill Reason</p>
     * 
     * <p>Indicates a non-clinical-issue based reason for refusing 
     * to fill.</p>
     * 
     * <p>Supports capture of reasons such as 'moral objection' 
     * which are not tied to specific issues. Set to CWE to allow 
     * non-coded reasons.</p>
     * 
     * <p>Refusal To Fill Reason</p>
     * 
     * <p>Indicates a non-clinical-issue based reason for refusing 
     * to fill.</p>
     * 
     * <p>Supports capture of reasons such as 'moral objection' 
     * which are not tied to specific issues. The element is CWE to 
     * allow for non-coded reasons.</p>
     * 
     * <p>Refusal to Fill Reason</p>
     * 
     * <p>Indicates a non-clinical-issue based reason for refusing 
     * to fill.</p>
     * 
     * <p>Indicates a non-clinical-issue based reason for refusing 
     * to fill. Allows CWE for non-coded reasons.</p>
     * 
     * <p>Refusal To Fill Reason</p>
     * 
     * <p>Indicates a non-clinical-issue based reason for refusing 
     * to fill.</p>
     * 
     * <p>Supports capture of reasons such as 'moral objection' 
     * which are not tied to specific issues. Set to CWE to allow 
     * non-coded reasons.</p>
     * 
     * <p>Refusal To Fill Reason</p>
     * 
     * <p>Indicates a non-clinical-issue based reason for refusing 
     * to fill.</p>
     * 
     * <p>Supports capture of reasons such as 'moral objection' 
     * which are not tied to specific issues. Set as CWE to allow 
     * for non-coded reasons.</p>
     */
    public void setReasonCode(ActSupplyFulfillmentRefusalReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }


    @Hl7XmlMapping({"author"})
    public RefusedByBean getAuthor() {
        return this.author;
    }

    public void setAuthor(RefusedByBean author) {
        this.author = author;
    }


    @Hl7XmlMapping({"location"})
    public CreatedAtBean getLocation() {
        return this.location;
    }

    public void setLocation(CreatedAtBean location) {
        this.location = location;
    }


    @Hl7XmlMapping({"reason/detectedIssueEvent"})
    public List<IssuesBean> getReasonDetectedIssueEvent() {
        return this.reasonDetectedIssueEvent;
    }

}
