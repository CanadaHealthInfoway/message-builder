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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.quqi_mt120000ca;

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
 * <p><p>Describes the results of a particular query.</p></p>
 * 
 * <p><p>Links a query response to the query that invoked it, 
 * and provides information about the overall result-set (which 
 * may not have been completely returned as part of the 
 * response.)</p></p>
 */
@Hl7PartTypeMapping({"QUQI_MT120000CA.QueryAck"})
public class QueryResponseInformationBean extends MessagePartBean {

    private static final long serialVersionUID = 20120301L;
    private II queryId = new IIImpl();
    private CS queryResponseCode = new CSImpl();
    private INT resultTotalQuantity = new INTImpl();
    private INT resultCurrentQuantity = new INTImpl();
    private INT resultRemainingQuantity = new INTImpl();


    /**
     * <p>M:Query Identifier</p>
     * 
     * <p><p>The identifier of the query this response is related 
     * to.</p></p>
     * 
     * <p><p>A single query may involve multiple messages. 
     * (Multiple continuations.). This attribute links all messages 
     * related to the same query and is therefore mandatory.</p></p>
     * 
     * <p><p>Query Identifier.)&nbsp;</p></p>
     */
    @Hl7XmlMapping({"queryId"})
    public Identifier getQueryId() {
        return this.queryId.getValue();
    }
    public void setQueryId(Identifier queryId) {
        this.queryId.setValue(queryId);
    }


    /**
     * <p>N:Query Result Status</p>
     * 
     * <p><p>Indicates the overall result status of the query.</p></p>
     * 
     * <p><p>Indicates whether the query was successful and is 
     * therefore mandatory</p></p>
     */
    @Hl7XmlMapping({"queryResponseCode"})
    public QueryResponse getQueryResponseCode() {
        return (QueryResponse) this.queryResponseCode.getValue();
    }
    public void setQueryResponseCode(QueryResponse queryResponseCode) {
        this.queryResponseCode.setValue(queryResponseCode);
    }


    /**
     * <p>O:Query Result-set Size</p>
     * 
     * <p><p>The total number of matching rows found by the query. 
     * (This may differ from the number of rows actually 
     * returned.)</p></p>
     * 
     * <p><p>Indicates whether additional content exists that may 
     * need to be retrieved by query continuations and is therefore 
     * mandatory</p></p>
     */
    @Hl7XmlMapping({"resultTotalQuantity"})
    public Integer getResultTotalQuantity() {
        return this.resultTotalQuantity.getValue();
    }
    public void setResultTotalQuantity(Integer resultTotalQuantity) {
        this.resultTotalQuantity.setValue(resultTotalQuantity);
    }


    /**
     * <p>P:Query Items Returned</p>
     * 
     * <p><p>This is how many items are returned in this query.</p></p>
     * 
     * <p><p>Provides a quick overview of the number of items 
     * without having to go through and count the data and is 
     * therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"resultCurrentQuantity"})
    public Integer getResultCurrentQuantity() {
        return this.resultCurrentQuantity.getValue();
    }
    public void setResultCurrentQuantity(Integer resultCurrentQuantity) {
        this.resultCurrentQuantity.setValue(resultCurrentQuantity);
    }


    /**
     * <p>Q:Query Items Remaining</p>
     * 
     * <p><p>The number of item repetitions yet to be returned in 
     * the current response.</p></p>
     * 
     * <p><p>Provides a means of evaluating the magnitude of the 
     * result and is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"resultRemainingQuantity"})
    public Integer getResultRemainingQuantity() {
        return this.resultRemainingQuantity.getValue();
    }
    public void setResultRemainingQuantity(Integer resultRemainingQuantity) {
        this.resultRemainingQuantity.setValue(resultRemainingQuantity);
    }

}
