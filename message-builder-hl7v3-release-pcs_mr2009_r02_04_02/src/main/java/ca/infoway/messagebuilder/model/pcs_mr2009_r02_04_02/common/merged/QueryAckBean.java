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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged;

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

    private static final long serialVersionUID = 20110407L;
    private II queryResponseIdentifier = new IIImpl();
    private CS queryStatus = new CSImpl();
    private INT totalMatchingRows = new INTImpl();
    private INT returnedRows = new INTImpl();
    private INT remainingRows = new INTImpl();


    /**
     * <p>QueryResponseIdentifier</p>
     * 
     * <p>H:Query Response Identifier</p>
     * 
     * <p><p>Identifies the query being acknowledged</p></p>
     * 
     * <p><p>Allows linking of a response back to the request that 
     * triggered it and is therefore mandatory. Particularly useful 
     * when responses are deferred or queued.</p></p>
     */
    @Hl7XmlMapping({"queryId"})
    public Identifier getQueryResponseIdentifier() {
        return this.queryResponseIdentifier.getValue();
    }
    public void setQueryResponseIdentifier(Identifier queryResponseIdentifier) {
        this.queryResponseIdentifier.setValue(queryResponseIdentifier);
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
    public QueryResponse getQueryStatus() {
        return (QueryResponse) this.queryStatus.getValue();
    }
    public void setQueryStatus(QueryResponse queryStatus) {
        this.queryStatus.setValue(queryStatus);
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
    public Integer getTotalMatchingRows() {
        return this.totalMatchingRows.getValue();
    }
    public void setTotalMatchingRows(Integer totalMatchingRows) {
        this.totalMatchingRows.setValue(totalMatchingRows);
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
    public Integer getReturnedRows() {
        return this.returnedRows.getValue();
    }
    public void setReturnedRows(Integer returnedRows) {
        this.returnedRows.setValue(returnedRows);
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
    public Integer getRemainingRows() {
        return this.remainingRows.getValue();
    }
    public void setRemainingRows(Integer remainingRows) {
        this.remainingRows.setValue(remainingRows);
    }

}
