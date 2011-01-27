/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.QueryResponse;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"MFMI_MT700746CA.QueryAck","QUQI_MT120006CA.QueryAck","QUQI_MT120008CA.QueryAck"})
public class QueryAckBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private INT remainingRows = new INTImpl();
    private INT totalMatchingRows = new INTImpl();
    private CS queryStatus = new CSImpl();
    private INT returnedRows = new INTImpl();
    private II queryIdentifier = new IIImpl();


    /**
     * <p>RemainingRows</p>
     * 
     * <p>L:Remaining Rows</p>
     */
    @Hl7XmlMapping({"resultRemainingQuantity"})
    public Integer getRemainingRows() {
        return this.remainingRows.getValue();
    }
    public void setRemainingRows(Integer remainingRows) {
        this.remainingRows.setValue(remainingRows);
    }


    /**
     * <p>TotalMatchingRows</p>
     * 
     * <p>J:Total Matching Rows</p>
     */
    @Hl7XmlMapping({"resultTotalQuantity"})
    public Integer getTotalMatchingRows() {
        return this.totalMatchingRows.getValue();
    }
    public void setTotalMatchingRows(Integer totalMatchingRows) {
        this.totalMatchingRows.setValue(totalMatchingRows);
    }


    /**
     * <p>QueryStatus</p>
     * 
     * <p>I:Query Status</p>
     */
    @Hl7XmlMapping({"queryResponseCode"})
    public QueryResponse getQueryStatus() {
        return (QueryResponse) this.queryStatus.getValue();
    }
    public void setQueryStatus(QueryResponse queryStatus) {
        this.queryStatus.setValue(queryStatus);
    }


    /**
     * <p>ReturnedRows</p>
     * 
     * <p>K:Returned Rows</p>
     */
    @Hl7XmlMapping({"resultCurrentQuantity"})
    public Integer getReturnedRows() {
        return this.returnedRows.getValue();
    }
    public void setReturnedRows(Integer returnedRows) {
        this.returnedRows.setValue(returnedRows);
    }


    /**
     * <p>QueryIdentifier</p>
     * 
     * <p>H:Query Identifier</p>
     */
    @Hl7XmlMapping({"queryId"})
    public Identifier getQueryIdentifier() {
        return this.queryIdentifier.getValue();
    }
    public void setQueryIdentifier(Identifier queryIdentifier) {
        this.queryIdentifier.setValue(queryIdentifier);
    }

}
