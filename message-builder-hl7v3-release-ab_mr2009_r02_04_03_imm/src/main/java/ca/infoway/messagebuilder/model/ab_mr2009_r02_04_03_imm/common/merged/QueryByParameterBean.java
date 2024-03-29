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
package ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03_imm.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ResponseModality;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"QUQI_MT020000AB.QueryByParameter","QUQI_MT020002AB.QueryByParameter","QUQI_MT120006AB.QueryByParameter","QUQI_MT120008AB.QueryByParameter"})
public class QueryByParameterBean<PL> extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private II queryId = new IIImpl();
    private CS responseModalityCode = new CSImpl();
    private PL parameterList;


    /**
     * <p>Business Name: QueryIdentifier</p>
     * 
     * <p>Un-merged Business Name: QueryIdentifier</p>
     * 
     * <p>Relationship: QUQI_MT020000AB.QueryByParameter.queryId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Needed to allow continuation of queries and linking of 
     * query requests and responses and therefore mandatory.</p>
     * 
     * <p>Unique number for this particular query.</p>
     * 
     * <p>Un-merged Business Name: QueryIdentifier</p>
     * 
     * <p>Relationship: QUQI_MT120006AB.QueryByParameter.queryId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Needed to allow continuation of queries and linking of 
     * query requests and responses and therefore mandatory.</p>
     * 
     * <p>Unique number for this particular query.</p>
     * 
     * <p>Un-merged Business Name: QueryIdentifier</p>
     * 
     * <p>Relationship: QUQI_MT120008AB.QueryByParameter.queryId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Needed to allow continuation of queries and linking of 
     * query requests and responses and therefore mandatory.</p>
     * 
     * <p>Unique number for this particular query.</p>
     * 
     * <p>Un-merged Business Name: QueryIdentifier</p>
     * 
     * <p>Relationship: QUQI_MT020002AB.QueryByParameter.queryId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Needed to allow continuation of queries and linking of 
     * query requests and responses and therefore mandatory.</p>
     * 
     * <p>Unique number for this particular query.</p>
     */
    @Hl7XmlMapping({"queryId"})
    public Identifier getQueryId() {
        return this.queryId.getValue();
    }

    /**
     * <p>Business Name: QueryIdentifier</p>
     * 
     * <p>Un-merged Business Name: QueryIdentifier</p>
     * 
     * <p>Relationship: QUQI_MT020000AB.QueryByParameter.queryId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Needed to allow continuation of queries and linking of 
     * query requests and responses and therefore mandatory.</p>
     * 
     * <p>Unique number for this particular query.</p>
     * 
     * <p>Un-merged Business Name: QueryIdentifier</p>
     * 
     * <p>Relationship: QUQI_MT120006AB.QueryByParameter.queryId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Needed to allow continuation of queries and linking of 
     * query requests and responses and therefore mandatory.</p>
     * 
     * <p>Unique number for this particular query.</p>
     * 
     * <p>Un-merged Business Name: QueryIdentifier</p>
     * 
     * <p>Relationship: QUQI_MT120008AB.QueryByParameter.queryId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Needed to allow continuation of queries and linking of 
     * query requests and responses and therefore mandatory.</p>
     * 
     * <p>Unique number for this particular query.</p>
     * 
     * <p>Un-merged Business Name: QueryIdentifier</p>
     * 
     * <p>Relationship: QUQI_MT020002AB.QueryByParameter.queryId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Needed to allow continuation of queries and linking of 
     * query requests and responses and therefore mandatory.</p>
     * 
     * <p>Unique number for this particular query.</p>
     */
    public void setQueryId(Identifier queryId) {
        this.queryId.setValue(queryId);
    }


    /**
     * <p>Business Name: ExpeditedQueryIndicator</p>
     * 
     * <p>Un-merged Business Name: ExpeditedQueryIndicator</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020000AB.QueryByParameter.responseModalityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Intended to convey the requested 'packaging' of query 
     * results. This attribute does not affect which rows are 
     * selected by the query, just the manner in which they are 
     * returned. For example, a batch file containing responses, a 
     * response message containing multiple payloads, or a stream 
     * of response messages (notifications) each identifying itself 
     * as a response to a query request.</p>
     * 
     * <p>This allows the sender to indicate to the receiver that 
     * this query should follow an expedited processing flow.</p>
     * 
     * <p>Un-merged Business Name: ExpeditedQueryIndicator</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120006AB.QueryByParameter.responseModalityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Intended to convey the 'packaging' of query results. This 
     * attribute does not affect which rows are selected by the 
     * query, just the manner in which they are returned. For 
     * example, a batch file containing responses, a response 
     * message containing multiple payloads, or a stream of 
     * response messages (notifications) each identifying itself as 
     * a response to a query request.</p>
     * 
     * <p>This allows the sender to indicate to the receiver that 
     * this query should follow an expedited processing flow.</p>
     * 
     * <p>Un-merged Business Name: ExpeditedQueryIndicator</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120008AB.QueryByParameter.responseModalityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Intended to convey the 'packaging' of query results. This 
     * attribute does not affect which rows are selected by the 
     * query, just the manner in which they are returned. For 
     * example, a batch file containing responses, a response 
     * message containing multiple payloads, or a stream of 
     * response messages (notifications) each identifying itself as 
     * a response to a query request.</p>
     * 
     * <p>This allows the sender to indicate to the receiver that 
     * this query should follow an expedited processing flow.</p>
     * 
     * <p>Un-merged Business Name: ExpeditedQueryIndicator</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020002AB.QueryByParameter.responseModalityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Intended to convey the 'packaging' of query results. This 
     * attribute does not affect which rows are selected by the 
     * query, just the manner in which they are returned. For 
     * example, a batch file containing responses, a response 
     * message containing multiple payloads, or a stream of 
     * response messages (notifications) each identifying itself as 
     * a response to a query request.</p>
     * 
     * <p>This allows the sender to indicate to the receiver that 
     * this query should follow an expedited processing flow.</p>
     */
    @Hl7XmlMapping({"responseModalityCode"})
    public ResponseModality getResponseModalityCode() {
        return (ResponseModality) this.responseModalityCode.getValue();
    }

    /**
     * <p>Business Name: ExpeditedQueryIndicator</p>
     * 
     * <p>Un-merged Business Name: ExpeditedQueryIndicator</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020000AB.QueryByParameter.responseModalityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Intended to convey the requested 'packaging' of query 
     * results. This attribute does not affect which rows are 
     * selected by the query, just the manner in which they are 
     * returned. For example, a batch file containing responses, a 
     * response message containing multiple payloads, or a stream 
     * of response messages (notifications) each identifying itself 
     * as a response to a query request.</p>
     * 
     * <p>This allows the sender to indicate to the receiver that 
     * this query should follow an expedited processing flow.</p>
     * 
     * <p>Un-merged Business Name: ExpeditedQueryIndicator</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120006AB.QueryByParameter.responseModalityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Intended to convey the 'packaging' of query results. This 
     * attribute does not affect which rows are selected by the 
     * query, just the manner in which they are returned. For 
     * example, a batch file containing responses, a response 
     * message containing multiple payloads, or a stream of 
     * response messages (notifications) each identifying itself as 
     * a response to a query request.</p>
     * 
     * <p>This allows the sender to indicate to the receiver that 
     * this query should follow an expedited processing flow.</p>
     * 
     * <p>Un-merged Business Name: ExpeditedQueryIndicator</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120008AB.QueryByParameter.responseModalityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Intended to convey the 'packaging' of query results. This 
     * attribute does not affect which rows are selected by the 
     * query, just the manner in which they are returned. For 
     * example, a batch file containing responses, a response 
     * message containing multiple payloads, or a stream of 
     * response messages (notifications) each identifying itself as 
     * a response to a query request.</p>
     * 
     * <p>This allows the sender to indicate to the receiver that 
     * this query should follow an expedited processing flow.</p>
     * 
     * <p>Un-merged Business Name: ExpeditedQueryIndicator</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020002AB.QueryByParameter.responseModalityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Intended to convey the 'packaging' of query results. This 
     * attribute does not affect which rows are selected by the 
     * query, just the manner in which they are returned. For 
     * example, a batch file containing responses, a response 
     * message containing multiple payloads, or a stream of 
     * response messages (notifications) each identifying itself as 
     * a response to a query request.</p>
     * 
     * <p>This allows the sender to indicate to the receiver that 
     * this query should follow an expedited processing flow.</p>
     */
    public void setResponseModalityCode(ResponseModality responseModalityCode) {
        this.responseModalityCode.setValue(responseModalityCode);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020000AB.QueryByParameter.parameterList</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120006AB.QueryByParameter.parameterList</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120008AB.QueryByParameter.parameterList</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020002AB.QueryByParameter.parameterList</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"parameterList"})
    public PL getParameterList() {
        return this.parameterList;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020000AB.QueryByParameter.parameterList</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120006AB.QueryByParameter.parameterList</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120008AB.QueryByParameter.parameterList</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020002AB.QueryByParameter.parameterList</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setParameterList(PL parameterList) {
        this.parameterList = parameterList;
    }

}
