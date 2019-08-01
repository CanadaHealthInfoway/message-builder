/**
 * Copyright 2013 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged;

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

    private static final long serialVersionUID = 20190731L;
    private II queryId = new IIImpl();
    private CS queryResponseCode = new CSImpl();
    private INT resultTotalQuantity = new INTImpl();
    private INT resultCurrentQuantity = new INTImpl();
    private INT resultRemainingQuantity = new INTImpl();


    /**
     * <p>Business Name: QueryResponseIdentifier</p>
     * 
     * <p>Un-merged Business Name: QueryResponseIdentifier</p>
     * 
     * <p>Relationship: MFMI_MT700746CA.QueryAck.queryId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows linking of a response back to the request that 
     * triggered it and is therefore mandatory. Particularly useful 
     * when responses are deferred or queued.</p>
     * 
     * <p>Identifies the query being acknowledged</p>
     * 
     * <p>Un-merged Business Name: QueryResponseIdentifier</p>
     * 
     * <p>Relationship: QUQI_MT120006CA.QueryAck.queryId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows linking of a response back to the request that 
     * triggered it and is therefore mandatory. Particularly useful 
     * when responses are deferred or queued.</p>
     * 
     * <p>Identifies the query being acknowledged</p>
     * 
     * <p>Un-merged Business Name: QueryResponseIdentifier</p>
     * 
     * <p>Relationship: QUQI_MT120008CA.QueryAck.queryId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows linking of a response back to the request that 
     * triggered it and is therefore mandatory. Particularly useful 
     * when responses are deferred or queued.</p>
     * 
     * <p>Identifies the query being acknowledged</p>
     */
    @Hl7XmlMapping({"queryId"})
    public Identifier getQueryId() {
        return this.queryId.getValue();
    }

    /**
     * <p>Business Name: QueryResponseIdentifier</p>
     * 
     * <p>Un-merged Business Name: QueryResponseIdentifier</p>
     * 
     * <p>Relationship: MFMI_MT700746CA.QueryAck.queryId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows linking of a response back to the request that 
     * triggered it and is therefore mandatory. Particularly useful 
     * when responses are deferred or queued.</p>
     * 
     * <p>Identifies the query being acknowledged</p>
     * 
     * <p>Un-merged Business Name: QueryResponseIdentifier</p>
     * 
     * <p>Relationship: QUQI_MT120006CA.QueryAck.queryId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows linking of a response back to the request that 
     * triggered it and is therefore mandatory. Particularly useful 
     * when responses are deferred or queued.</p>
     * 
     * <p>Identifies the query being acknowledged</p>
     * 
     * <p>Un-merged Business Name: QueryResponseIdentifier</p>
     * 
     * <p>Relationship: QUQI_MT120008CA.QueryAck.queryId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows linking of a response back to the request that 
     * triggered it and is therefore mandatory. Particularly useful 
     * when responses are deferred or queued.</p>
     * 
     * <p>Identifies the query being acknowledged</p>
     */
    public void setQueryId(Identifier queryId) {
        this.queryId.setValue(queryId);
    }


    /**
     * <p>Business Name: QueryStatus</p>
     * 
     * <p>Un-merged Business Name: QueryStatus</p>
     * 
     * <p>Relationship: MFMI_MT700746CA.QueryAck.queryResponseCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to control receiver logic and is therefore 
     * mandatory.</p>
     * 
     * <p>Indicates whether the query was successful or not.</p>
     * 
     * <p>Un-merged Business Name: QueryStatus</p>
     * 
     * <p>Relationship: QUQI_MT120006CA.QueryAck.queryResponseCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to control receiver logic and is therefore 
     * mandatory.</p>
     * 
     * <p>Indicates whether the query was successful or not.</p>
     * 
     * <p>Un-merged Business Name: QueryStatus</p>
     * 
     * <p>Relationship: QUQI_MT120008CA.QueryAck.queryResponseCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to control receiver logic and is therefore 
     * mandatory.</p>
     * 
     * <p>Indicates whether the query was successful or not.</p>
     */
    @Hl7XmlMapping({"queryResponseCode"})
    public QueryResponse getQueryResponseCode() {
        return (QueryResponse) this.queryResponseCode.getValue();
    }

    /**
     * <p>Business Name: QueryStatus</p>
     * 
     * <p>Un-merged Business Name: QueryStatus</p>
     * 
     * <p>Relationship: MFMI_MT700746CA.QueryAck.queryResponseCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to control receiver logic and is therefore 
     * mandatory.</p>
     * 
     * <p>Indicates whether the query was successful or not.</p>
     * 
     * <p>Un-merged Business Name: QueryStatus</p>
     * 
     * <p>Relationship: QUQI_MT120006CA.QueryAck.queryResponseCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to control receiver logic and is therefore 
     * mandatory.</p>
     * 
     * <p>Indicates whether the query was successful or not.</p>
     * 
     * <p>Un-merged Business Name: QueryStatus</p>
     * 
     * <p>Relationship: QUQI_MT120008CA.QueryAck.queryResponseCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to control receiver logic and is therefore 
     * mandatory.</p>
     * 
     * <p>Indicates whether the query was successful or not.</p>
     */
    public void setQueryResponseCode(QueryResponse queryResponseCode) {
        this.queryResponseCode.setValue(queryResponseCode);
    }


    /**
     * <p>Business Name: TotalMatchingRows</p>
     * 
     * <p>Un-merged Business Name: TotalMatchingRows</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700746CA.QueryAck.resultTotalQuantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the overall size of the result-set and is 
     * therefore mandatory. Particularly useful when only part of 
     * the result set is actually returned.</p>
     * 
     * <p>Identifies the total number of rows identified that 
     * matched the query.</p>
     * 
     * <p>Un-merged Business Name: TotalMatchingRows</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120006CA.QueryAck.resultTotalQuantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the overall size of the result-set and is 
     * therefore mandatory. Particularly useful when only part of 
     * the result set is actually returned.</p>
     * 
     * <p>Identifies the total number of rows identified that 
     * matched the query.</p>
     * 
     * <p>Un-merged Business Name: TotalMatchingRows</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120008CA.QueryAck.resultTotalQuantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the overall size of the result-set and is 
     * therefore mandatory. Particularly useful when only part of 
     * the result set is actually returned.</p>
     * 
     * <p>Identifies the total number of rows identified that 
     * matched the query.</p>
     */
    @Hl7XmlMapping({"resultTotalQuantity"})
    public Integer getResultTotalQuantity() {
        return this.resultTotalQuantity.getValue();
    }

    /**
     * <p>Business Name: TotalMatchingRows</p>
     * 
     * <p>Un-merged Business Name: TotalMatchingRows</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700746CA.QueryAck.resultTotalQuantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the overall size of the result-set and is 
     * therefore mandatory. Particularly useful when only part of 
     * the result set is actually returned.</p>
     * 
     * <p>Identifies the total number of rows identified that 
     * matched the query.</p>
     * 
     * <p>Un-merged Business Name: TotalMatchingRows</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120006CA.QueryAck.resultTotalQuantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the overall size of the result-set and is 
     * therefore mandatory. Particularly useful when only part of 
     * the result set is actually returned.</p>
     * 
     * <p>Identifies the total number of rows identified that 
     * matched the query.</p>
     * 
     * <p>Un-merged Business Name: TotalMatchingRows</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120008CA.QueryAck.resultTotalQuantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the overall size of the result-set and is 
     * therefore mandatory. Particularly useful when only part of 
     * the result set is actually returned.</p>
     * 
     * <p>Identifies the total number of rows identified that 
     * matched the query.</p>
     */
    public void setResultTotalQuantity(Integer resultTotalQuantity) {
        this.resultTotalQuantity.setValue(resultTotalQuantity);
    }


    /**
     * <p>Business Name: ReturnedRows</p>
     * 
     * <p>Un-merged Business Name: ReturnedRows</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700746CA.QueryAck.resultCurrentQuantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a quick overview of the results of the query and 
     * is therefore mandatory</p>
     * 
     * <p>Identifies the number of rows returned as part of this 
     * particular query response.</p>
     * 
     * <p>Un-merged Business Name: ReturnedRows</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120006CA.QueryAck.resultCurrentQuantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a quick overview of the results of the query and 
     * is therefore mandatory.</p>
     * 
     * <p>Identifies the number of rows returned as part of this 
     * particular query response.</p>
     * 
     * <p>Un-merged Business Name: ReturnedRows</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120008CA.QueryAck.resultCurrentQuantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a quick overview of the results of the query and 
     * is therefore mandatory.</p>
     * 
     * <p>Identifies the number of rows returned as part of this 
     * particular query response.</p>
     */
    @Hl7XmlMapping({"resultCurrentQuantity"})
    public Integer getResultCurrentQuantity() {
        return this.resultCurrentQuantity.getValue();
    }

    /**
     * <p>Business Name: ReturnedRows</p>
     * 
     * <p>Un-merged Business Name: ReturnedRows</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700746CA.QueryAck.resultCurrentQuantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a quick overview of the results of the query and 
     * is therefore mandatory</p>
     * 
     * <p>Identifies the number of rows returned as part of this 
     * particular query response.</p>
     * 
     * <p>Un-merged Business Name: ReturnedRows</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120006CA.QueryAck.resultCurrentQuantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a quick overview of the results of the query and 
     * is therefore mandatory.</p>
     * 
     * <p>Identifies the number of rows returned as part of this 
     * particular query response.</p>
     * 
     * <p>Un-merged Business Name: ReturnedRows</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120008CA.QueryAck.resultCurrentQuantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a quick overview of the results of the query and 
     * is therefore mandatory.</p>
     * 
     * <p>Identifies the number of rows returned as part of this 
     * particular query response.</p>
     */
    public void setResultCurrentQuantity(Integer resultCurrentQuantity) {
        this.resultCurrentQuantity.setValue(resultCurrentQuantity);
    }


    /**
     * <p>Business Name: RemainingRows</p>
     * 
     * <p>Un-merged Business Name: RemainingRows</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700746CA.QueryAck.resultRemainingQuantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies how much data remains to be queried and is 
     * therefore mandatory.</p>
     * 
     * <p>Indicates the number of rows that still exist after the 
     * last row returned in this response.</p>
     * 
     * <p>Un-merged Business Name: RemainingRows</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120006CA.QueryAck.resultRemainingQuantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies how much data remains to be queried and is 
     * therefore mandatory.</p>
     * 
     * <p>Indicates the number of rows that still exist after the 
     * last row returned in this response.</p>
     * 
     * <p>Un-merged Business Name: RemainingRows</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120008CA.QueryAck.resultRemainingQuantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies how much data remains to be queried and is 
     * therefore mandatory.</p>
     * 
     * <p>Indicates the number of rows that still exist after the 
     * last row returned in this response.</p>
     */
    @Hl7XmlMapping({"resultRemainingQuantity"})
    public Integer getResultRemainingQuantity() {
        return this.resultRemainingQuantity.getValue();
    }

    /**
     * <p>Business Name: RemainingRows</p>
     * 
     * <p>Un-merged Business Name: RemainingRows</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700746CA.QueryAck.resultRemainingQuantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies how much data remains to be queried and is 
     * therefore mandatory.</p>
     * 
     * <p>Indicates the number of rows that still exist after the 
     * last row returned in this response.</p>
     * 
     * <p>Un-merged Business Name: RemainingRows</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120006CA.QueryAck.resultRemainingQuantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies how much data remains to be queried and is 
     * therefore mandatory.</p>
     * 
     * <p>Indicates the number of rows that still exist after the 
     * last row returned in this response.</p>
     * 
     * <p>Un-merged Business Name: RemainingRows</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120008CA.QueryAck.resultRemainingQuantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies how much data remains to be queried and is 
     * therefore mandatory.</p>
     * 
     * <p>Indicates the number of rows that still exist after the 
     * last row returned in this response.</p>
     */
    public void setResultRemainingQuantity(Integer resultRemainingQuantity) {
        this.resultRemainingQuantity.setValue(resultRemainingQuantity);
    }

}
