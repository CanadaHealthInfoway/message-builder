/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.domainvalue.ActSupplyFulfillmentRefusalReason;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.r02_04_02.merged.IssuesBean;
import ca.infoway.messagebuilder.model.r02_04_02.merged.OccurredAtBean;
import ca.infoway.messagebuilder.model.r02_04_02.merged.RefusedByBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>PORX_MT060340CA.RefusalToFill: Refusal to Fills</p>
 * 
 * <p><p>One of Refusal to Fill Reason or an Issue must be 
 * specified but not both</p></p>
 * 
 * <p><p>Indicates that the identified issue resulted in a 
 * dispenser refusing to fill the subject prescription.</p></p>
 * 
 * <p><p>Exposes in the model that this issue is associated 
 * with a refusal to dispense.</p><p>An indication of 'refusal 
 * to fill' must be indicated, thus attribute is mandatory.</p></p>
 * 
 * <p><p>Exposes in the model that this issue is associated 
 * with a refusal to dispense.</p><p>An indication of 'refusal 
 * to fill' must be indicated, thus attribute is mandatory.</p></p>
 * 
 * <p>PORX_MT060060CA.RefusalToFill: Refusal To Fills</p>
 * 
 * <p><p>One of Refusal To Fill Reason or Issue must be 
 * specified but not both</p></p>
 * 
 * <p><p>Indicates that the identified issue resulted in a 
 * dispenser refusing to fill the subject prescription.</p></p>
 * 
 * <p><p>Exposes in the model that this issue is associated 
 * with a refusal to dispense.</p><p>An indication of 'refusal 
 * to fill' must be indicated, thus attribute is mandatory.</p></p>
 * 
 * <p><p>Exposes in the model that this issue is associated 
 * with a refusal to dispense.</p><p>An indication of 'refusal 
 * to fill' must be indicated, thus attribute is mandatory.</p></p>
 * 
 * <p>PORX_MT030040CA.RefusalToFill: Refusal to Fills</p>
 * 
 * <p><p>One of Refusal To Fill Reason or Issue must be 
 * specified, but not both.</p></p>
 * 
 * <p><p>Indicates that the identified issue resulted in a 
 * dispenser refusing to fill the subject prescription.</p></p>
 * 
 * <p><p>Exposes in the model that this issue is associated 
 * with a refusal to dispense.</p><p>An indication of 'refusal 
 * to fill' must be indicated, thus attribute is mandatory.</p></p>
 * 
 * <p><p>Exposes in the model that this issue is associated 
 * with a refusal to dispense.</p><p>An indication of 'refusal 
 * to fill' must be indicated, thus attribute is mandatory.</p></p>
 * 
 * <p>PORX_MT060190CA.RefusalToFill: Refusal To Fills</p>
 * 
 * <p><p>One of Refusal To Fill Reason or Issue must be 
 * specified but not both</p></p>
 * 
 * <p><p>Indicates that the identified issue resulted in a 
 * dispenser refusing to fill the subject prescription.</p></p>
 * 
 * <p><p>Exposes in the model that this issue is associated 
 * with a refusal to dispense.</p><p>An indication of 'refusal 
 * to fill' must be indicated, thus attribute is mandatory.</p></p>
 * 
 * <p><p>Exposes in the model that this issue is associated 
 * with a refusal to dispense.</p><p>An indication of 'refusal 
 * to fill' must be indicated, thus attribute is mandatory.</p></p>
 * 
 * <p>PORX_MT060040CA.RefusalToFill: Refusals To Fills</p>
 * 
 * <p><p>One of Refusal To Fill Reason or Issue must be 
 * specified but not both</p></p>
 * 
 * <p><p>Indicates that the identified issue resulted in a 
 * dispenser refusing to fill the subject prescription. .</p></p>
 * 
 * <p><p>Exposes in the model that this issue is associated 
 * with a refusal to dispense.</p><p>An indication of 'refusal 
 * to fill' must be indicated, thus attribute is mandatory.</p></p>
 * 
 * <p><p>Exposes in the model that this issue is associated 
 * with a refusal to dispense.</p><p>An indication of 'refusal 
 * to fill' must be indicated, thus attribute is mandatory.</p></p>
 * 
 * <p>PORX_MT060160CA.RefusalToFill: Fill Refusals</p>
 * 
 * <p><p>One of Refusal to Fill Reason or an Issue must be 
 * specified but no both</p></p>
 * 
 * <p><p>Indicates that the identified issue resulted in a 
 * dispenser refusing to fill the subject prescription.</p></p>
 * 
 * <p><p>Exposes in the model that this issue is associated 
 * with a refusal to dispense.</p><p>An indication of 'refusal 
 * to fill' must be indicated, thus attribute is mandatory.</p></p>
 * 
 * <p><p>Exposes in the model that this issue is associated 
 * with a refusal to dispense.</p><p>An indication of 'refusal 
 * to fill' must be indicated, thus attribute is mandatory.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT030040CA.RefusalToFill","PORX_MT060040CA.RefusalToFill","PORX_MT060060CA.RefusalToFill","PORX_MT060160CA.RefusalToFill","PORX_MT060190CA.RefusalToFill","PORX_MT060340CA.RefusalToFill"})
public class RefusalToFillsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private TS refusalToFillDate = new TSImpl();
    private CV refusalToFillReason = new CVImpl();
    private RefusedByBean author;
    private OccurredAtBean location;
    private List<IssuesBean> reasonDetectedIssueEvent = new ArrayList<IssuesBean>();


    /**
     * <p>RefusalToFillDate</p>
     * 
     * <p>Refusal To Fill Date</p>
     * 
     * <p><p>The date that the dispenser refused to fill the 
     * prescription</p></p>
     * 
     * <p><p>May be important to down stream providers to know when 
     * the refusal occurred.</p><p>Is marked as populated as it may 
     * not always be known for historical data pre- loaded into the 
     * EHR</p></p>
     * 
     * <p><p>May be important to down stream providers to know when 
     * the refusal occurred.</p><p>Is marked as populated as it may 
     * not always be known for historical data pre- loaded into the 
     * EHR</p></p>
     * 
     * <p>Refusal To Fill Date</p>
     * 
     * <p><p>The date that the dispenser refused to fill the 
     * prescitpion</p></p>
     * 
     * <p><p>May be important to down stream providers to know when 
     * the refusal occured.</p><p>Is marked as populated as it may 
     * not always be known for historical data pre- loaded into the 
     * EHR</p></p>
     * 
     * <p><p>May be important to down stream providers to know when 
     * the refusal occured.</p><p>Is marked as populated as it may 
     * not always be known for historical data pre- loaded into the 
     * EHR</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getRefusalToFillDate() {
        return this.refusalToFillDate.getValue();
    }
    public void setRefusalToFillDate(Date refusalToFillDate) {
        this.refusalToFillDate.setValue(refusalToFillDate);
    }


    /**
     * <p>RefusalToFillReason</p>
     * 
     * <p>Refusal To Fill Reason</p>
     * 
     * <p><p>Indicates a non-clinical-issue based reason for 
     * refusing to fill.</p></p>
     * 
     * <p><p>Supports capture of reasons such as 'moral objection' 
     * which are not tied to specific issues. Set as CWE to allow 
     * non-coded reasons.</p></p>
     * 
     * <p>Refusal to Fill Reason</p>
     * 
     * <p><p>Indicates a non-clinical-issue based reason for 
     * refusing to fill.</p></p>
     * 
     * <p><p>Supports capture of reasons such as 'moral objection' 
     * which are not tied to specific issues. Set to CWE to allow 
     * non-coded reasons.</p></p>
     * 
     * <p>Refusal To Fill Reason</p>
     * 
     * <p><p>Indicates a non-clinical-issue based reason for 
     * refusing to fill.</p></p>
     * 
     * <p><p>Supports capture of reasons such as 'moral objection' 
     * which are not tied to specific issues. Set to CWE to allow 
     * non-coded reasons.</p></p>
     * 
     * <p>Refusal To Fill Reason</p>
     * 
     * <p><p>Indicates a non-clinical-issue based reason for 
     * refusing to fill.</p></p>
     * 
     * <p><p>Supports capture of reasons such as 'moral objection' 
     * which are not tied to specific issues. Set as CWE to allow 
     * for non-coded reasons.</p></p>
     * 
     * <p>Refusal to Fill Reason</p>
     * 
     * <p><p>Indicates a non-clinical-issue based reason for 
     * refusing to fill.</p></p>
     * 
     * <p><p>Indicates a non-clinical-issue based reason for 
     * refusing to fill. Allows CWE for non-coded reasons.</p></p>
     * 
     * <p>Refusal To Fill Reason</p>
     * 
     * <p><p>Indicates a non-clinical-issue based reason for 
     * refusing to fill.</p></p>
     * 
     * <p><p>Supports capture of reasons such as 'moral objection' 
     * which are not tied to specific issues. The element is CWE to 
     * allow for non-coded reasons.</p></p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public ActSupplyFulfillmentRefusalReason getRefusalToFillReason() {
        return (ActSupplyFulfillmentRefusalReason) this.refusalToFillReason.getValue();
    }
    public void setRefusalToFillReason(ActSupplyFulfillmentRefusalReason refusalToFillReason) {
        this.refusalToFillReason.setValue(refusalToFillReason);
    }


    @Hl7XmlMapping({"author"})
    public RefusedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(RefusedByBean author) {
        this.author = author;
    }


    @Hl7XmlMapping({"location"})
    public OccurredAtBean getLocation() {
        return this.location;
    }
    public void setLocation(OccurredAtBean location) {
        this.location = location;
    }


    @Hl7XmlMapping({"reason/detectedIssueEvent"})
    public List<IssuesBean> getReasonDetectedIssueEvent() {
        return this.reasonDetectedIssueEvent;
    }

}
