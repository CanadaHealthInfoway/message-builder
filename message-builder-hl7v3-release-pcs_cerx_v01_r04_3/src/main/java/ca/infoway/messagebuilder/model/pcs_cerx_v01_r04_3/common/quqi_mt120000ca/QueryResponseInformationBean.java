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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.quqi_mt120000ca;

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



@Hl7PartTypeMapping({"QUQI_MT120000CA.QueryAck"})
public class QueryResponseInformationBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private II queryIdentifier = new IIImpl();
    private CS queryResultStatus = new CSImpl();
    private INT queryResultSetSize = new INTImpl();
    private INT queryItemsReturned = new INTImpl();
    private INT queryItemsRemaining = new INTImpl();


    /**
     * <p>M:Query Identifier</p>
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
     */
    @Hl7XmlMapping({"resultRemainingQuantity"})
    public Integer getQueryItemsRemaining() {
        return this.queryItemsRemaining.getValue();
    }
    public void setQueryItemsRemaining(Integer queryItemsRemaining) {
        this.queryItemsRemaining.setValue(queryItemsRemaining);
    }

}
