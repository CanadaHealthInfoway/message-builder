/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.domainvalue.ActSupplyFulfillmentRefusalReason;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.v02_r01.merged.CreatedAtBean;
import ca.infoway.messagebuilder.model.v02_r01.merged.IssuesBean;
import ca.infoway.messagebuilder.model.v02_r01.merged.RefusedByBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"PORX_MT030040CA.RefusalToFill","PORX_MT060040CA.RefusalToFill","PORX_MT060060CA.RefusalToFill","PORX_MT060160CA.RefusalToFill","PORX_MT060190CA.RefusalToFill","PORX_MT060340CA.RefusalToFill"})
public class RefusalToFillsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private CV refusalToFillReason = new CVImpl();
    private RefusedByBean author;
    private TS refusalToFillDate = new TSImpl();
    private List<IssuesBean> reasonDetectedIssueEvent = new ArrayList<IssuesBean>();
    private CreatedAtBean location;


    /**
     * <p>RefusalToFillReason</p>
     * 
     * <p>Refusal To Fill Reason</p>
     * 
     * <p>Refusal to Fill Reason</p>
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


    /**
     * <p>RefusalToFillDate</p>
     * 
     * <p>Refusal To Fill Date</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getRefusalToFillDate() {
        return this.refusalToFillDate.getValue();
    }
    public void setRefusalToFillDate(Date refusalToFillDate) {
        this.refusalToFillDate.setValue(refusalToFillDate);
    }


    @Hl7XmlMapping({"reason/detectedIssueEvent"})
    public List<IssuesBean> getReasonDetectedIssueEvent() {
        return this.reasonDetectedIssueEvent;
    }


    @Hl7XmlMapping({"location"})
    public CreatedAtBean getLocation() {
        return this.location;
    }
    public void setLocation(CreatedAtBean location) {
        this.location = location;
    }

}
