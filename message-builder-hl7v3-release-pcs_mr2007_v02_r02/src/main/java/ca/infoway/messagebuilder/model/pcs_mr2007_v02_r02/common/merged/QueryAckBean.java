/**
 * Copyright 2011 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged;

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

    private static final long serialVersionUID = 20111117L;
    private II queryId = new IIImpl();
    private CS queryResponseCode = new CSImpl();
    private INT resultTotalQuantity = new INTImpl();
    private INT resultCurrentQuantity = new INTImpl();
    private INT resultRemainingQuantity = new INTImpl();


    /**
     * <p>QueryIdentifier</p>
     * 
     * <p>H:Query Identifier</p>
     * 
     * <p><p>Identifies the query being acknowledged</p></p>
     * 
     * <p><p>Allows linking of a response back to the request that 
     * triggered it and is therefore mandatory. Particularly useful 
     * when responses are deferred or queued.</p></p>
     */
    @Hl7XmlMapping({"queryId"})
    public Identifier getQueryId() {
        return this.queryId.getValue();
    }
    public void setQueryId(Identifier queryId) {
        this.queryId.setValue(queryId);
    }


    /**
     * <p>QueryStatus</p>
     * 
     * <p>I:Query Status</p>
     * 
     * <p><p>Indicates whether the query was successful or not.</p></p>
     * 
     * <p><p>Used to control receiver logic and is therefore 
     * mandatory.</p></p>
     */
    @Hl7XmlMapping({"queryResponseCode"})
    public QueryResponse getQueryResponseCode() {
        return (QueryResponse) this.queryResponseCode.getValue();
    }
    public void setQueryResponseCode(QueryResponse queryResponseCode) {
        this.queryResponseCode.setValue(queryResponseCode);
    }


    /**
     * <p>TotalMatchingRows</p>
     * 
     * <p>J:Total Matching Rows</p>
     * 
     * <p><p>Identifies the total number of rows identified that 
     * matched the query.</p></p>
     * 
     * <p><p>Indicates the overall size of the result-set and is 
     * therefore mandatory. Particularly useful when only part of 
     * the result set is actually returned.</p></p>
     */
    @Hl7XmlMapping({"resultTotalQuantity"})
    public Integer getResultTotalQuantity() {
        return this.resultTotalQuantity.getValue();
    }
    public void setResultTotalQuantity(Integer resultTotalQuantity) {
        this.resultTotalQuantity.setValue(resultTotalQuantity);
    }


    /**
     * <p>ReturnedRows</p>
     * 
     * <p>K:Returned Rows</p>
     * 
     * <p><p>Identifies the number of rows returned as part of this 
     * particular query response.</p></p>
     * 
     * <p><p>Provides a quick overview of the results of the query 
     * and is therefore mandatory</p></p>
     * 
     * <p>K:Returned Rows</p>
     * 
     * <p><p>Identifies the number of rows returned as part of this 
     * particular query response.</p></p>
     * 
     * <p><p>Provides a quick overview of the results of the query 
     * and is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"resultCurrentQuantity"})
    public Integer getResultCurrentQuantity() {
        return this.resultCurrentQuantity.getValue();
    }
    public void setResultCurrentQuantity(Integer resultCurrentQuantity) {
        this.resultCurrentQuantity.setValue(resultCurrentQuantity);
    }


    /**
     * <p>RemainingRows</p>
     * 
     * <p>L:Remaining Rows</p>
     * 
     * <p><p>Indicates the number of rows that still exist after 
     * the last row returned in this response.</p></p>
     * 
     * <p><p>Identifies how much data remains to be queried and is 
     * therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"resultRemainingQuantity"})
    public Integer getResultRemainingQuantity() {
        return this.resultRemainingQuantity.getValue();
    }
    public void setResultRemainingQuantity(Integer resultRemainingQuantity) {
        this.resultRemainingQuantity.setValue(resultRemainingQuantity);
    }

}
