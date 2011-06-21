/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.quqi_mt120000ca;

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



/**
 * <p>Query response information</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Describes 
 * the results of a particular query.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Links a 
 * query response to the query that invoked it, and provides 
 * information about the overall result-set (which may not have 
 * been completely returned as part of the response.)</p></p>
 */
@Hl7PartTypeMapping({"QUQI_MT120000CA.QueryAck"})
public class QueryResponseInformationBean extends MessagePartBean {

    private static final long serialVersionUID = 20110621L;
    private II queryIdentifier = new IIImpl();
    private CS queryResultStatus = new CSImpl();
    private INT queryResultSetSize = new INTImpl();
    private INT queryItemsReturned = new INTImpl();
    private INT queryItemsRemaining = new INTImpl();


    /**
     * <p>M:Query Identifier</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The 
     * identifier of the query this response is related to.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A single 
     * query may involve multiple messages. (Multiple 
     * continuations.). This attribute links all messages related 
     * to the same query and is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"queryId"})
    public Identifier getQueryIdentifier() {
        return this.queryIdentifier.getValue();
    }
    public void setQueryIdentifier(Identifier queryIdentifier) {
        this.queryIdentifier.setValue(queryIdentifier);
    }


    /**
     * <p>N:Query Result Status</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the overall result status of the query.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * whether the query was successful and is therefore 
     * mandatory</p></p>
     */
    @Hl7XmlMapping({"queryResponseCode"})
    public QueryResponse getQueryResultStatus() {
        return (QueryResponse) this.queryResultStatus.getValue();
    }
    public void setQueryResultStatus(QueryResponse queryResultStatus) {
        this.queryResultStatus.setValue(queryResultStatus);
    }


    /**
     * <p>O:Query Result-set Size</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The total 
     * number of matching rows found by the query. (This may differ 
     * from the number of rows actually returned.)</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * whether additional content exists that may need to be 
     * retrieved by query continuations and is therefore 
     * mandatory</p></p>
     */
    @Hl7XmlMapping({"resultTotalQuantity"})
    public Integer getQueryResultSetSize() {
        return this.queryResultSetSize.getValue();
    }
    public void setQueryResultSetSize(Integer queryResultSetSize) {
        this.queryResultSetSize.setValue(queryResultSetSize);
    }


    /**
     * <p>P:Query Items Returned</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The number 
     * of item repetitions returned in the current response.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Provides a 
     * quick overview of the number of items without having to go 
     * through and count the data and is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"resultCurrentQuantity"})
    public Integer getQueryItemsReturned() {
        return this.queryItemsReturned.getValue();
    }
    public void setQueryItemsReturned(Integer queryItemsReturned) {
        this.queryItemsReturned.setValue(queryItemsReturned);
    }


    /**
     * <p>Q:Query Items Remaining</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The number 
     * of item repetitions yet to be returned in the current 
     * response.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Provides a 
     * means of evaluating the magnitude of the result and is 
     * therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"resultRemainingQuantity"})
    public Integer getQueryItemsRemaining() {
        return this.queryItemsRemaining.getValue();
    }
    public void setQueryItemsRemaining(Integer queryItemsRemaining) {
        this.queryItemsRemaining.setValue(queryItemsRemaining);
    }

}
