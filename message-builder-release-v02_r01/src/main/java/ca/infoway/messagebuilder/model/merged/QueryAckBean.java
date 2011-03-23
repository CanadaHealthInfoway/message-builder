/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"QUQI_MT120006CA.QueryAck","QUQI_MT120008CA.QueryAck"})
public class QueryAckBean extends MessagePartBean {

    private static final long serialVersionUID = 20100615L;
    private II queryIdentifier = new IIImpl();
    private CS queryStatus = new CSImpl();
    private INT totalMatchingRows = new INTImpl();
    private INT returnedRows = new INTImpl();
    private INT remainingRows = new INTImpl();

    @Hl7XmlMapping({"queryId"})
    public Identifier getQueryIdentifier() {
        return this.queryIdentifier.getValue();
    }
    public void setQueryIdentifier(Identifier queryIdentifier) {
        this.queryIdentifier.setValue(queryIdentifier);
    }

    @Hl7XmlMapping({"queryResponseCode"})
    public Code getQueryStatus() {
        return (Code) this.queryStatus.getValue();
    }
    public void setQueryStatus(Code queryStatus) {
        this.queryStatus.setValue(queryStatus);
    }

    @Hl7XmlMapping({"resultTotalQuantity"})
    public Integer getTotalMatchingRows() {
        return this.totalMatchingRows.getValue();
    }
    public void setTotalMatchingRows(Integer totalMatchingRows) {
        this.totalMatchingRows.setValue(totalMatchingRows);
    }

    @Hl7XmlMapping({"resultCurrentQuantity"})
    public Integer getReturnedRows() {
        return this.returnedRows.getValue();
    }
    public void setReturnedRows(Integer returnedRows) {
        this.returnedRows.setValue(returnedRows);
    }

    @Hl7XmlMapping({"resultRemainingQuantity"})
    public Integer getRemainingRows() {
        return this.remainingRows.getValue();
    }
    public void setRemainingRows(Integer remainingRows) {
        this.remainingRows.setValue(remainingRows);
    }

}
