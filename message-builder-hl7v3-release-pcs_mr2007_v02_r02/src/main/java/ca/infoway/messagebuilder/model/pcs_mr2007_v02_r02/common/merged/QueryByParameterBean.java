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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.QueryRequestLimit;
import ca.infoway.messagebuilder.domainvalue.ResponseModality;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Business Name: QueryByParameter</p>
 * 
 * <p>MFMI_MT700751CA.QueryByParameter: Query By Parameter</p>
 * 
 * <p>InitialQuantity must only be specified if 
 * InitialQuantityCode is specified.</p>
 * 
 * <p>Class which describes the query specifics and parameter 
 * list.</p>
 */
@Hl7PartTypeMapping({"MFMI_MT700746CA.QueryByParameter","MFMI_MT700751CA.QueryByParameter","QUQI_MT020000CA.QueryByParameter","QUQI_MT020002CA.QueryByParameter","QUQI_MT120006CA.QueryByParameter","QUQI_MT120008CA.QueryByParameter"})
public class QueryByParameterBean<PL> extends MessagePartBean {

    private static final long serialVersionUID = 20130613L;
    private II queryId = new IIImpl();
    private CS responseModalityCode = new CSImpl();
    private INT initialQuantity = new INTImpl();
    private CV initialQuantityCode = new CVImpl();
    private PL parameterList;
    private List<SortControlBean> sortControl = new ArrayList<SortControlBean>();


    /**
     * <p>Business Name: QueryIdentifier</p>
     * 
     * <p>Un-merged Business Name: QueryIdentifier</p>
     * 
     * <p>Relationship: QUQI_MT020000CA.QueryByParameter.queryId</p>
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
     * <p>Relationship: MFMI_MT700751CA.QueryByParameter.queryId</p>
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
     * <p>Relationship: MFMI_MT700746CA.QueryByParameter.queryId</p>
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
     * <p>Relationship: QUQI_MT020002CA.QueryByParameter.queryId</p>
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
     * <p>Relationship: QUQI_MT120008CA.QueryByParameter.queryId</p>
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
     * <p>Relationship: QUQI_MT120006CA.QueryByParameter.queryId</p>
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
     * <p>Relationship: QUQI_MT020000CA.QueryByParameter.queryId</p>
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
     * <p>Relationship: MFMI_MT700751CA.QueryByParameter.queryId</p>
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
     * <p>Relationship: MFMI_MT700746CA.QueryByParameter.queryId</p>
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
     * <p>Relationship: QUQI_MT020002CA.QueryByParameter.queryId</p>
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
     * <p>Relationship: QUQI_MT120008CA.QueryByParameter.queryId</p>
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
     * <p>Relationship: QUQI_MT120006CA.QueryByParameter.queryId</p>
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
     * QUQI_MT020000CA.QueryByParameter.responseModalityCode</p>
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
     * MFMI_MT700751CA.QueryByParameter.responseModalityCode</p>
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
     * MFMI_MT700746CA.QueryByParameter.responseModalityCode</p>
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
     * QUQI_MT020002CA.QueryByParameter.responseModalityCode</p>
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
     * QUQI_MT120008CA.QueryByParameter.responseModalityCode</p>
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
     * QUQI_MT120006CA.QueryByParameter.responseModalityCode</p>
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
     * QUQI_MT020000CA.QueryByParameter.responseModalityCode</p>
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
     * MFMI_MT700751CA.QueryByParameter.responseModalityCode</p>
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
     * MFMI_MT700746CA.QueryByParameter.responseModalityCode</p>
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
     * QUQI_MT020002CA.QueryByParameter.responseModalityCode</p>
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
     * QUQI_MT120008CA.QueryByParameter.responseModalityCode</p>
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
     * QUQI_MT120006CA.QueryByParameter.responseModalityCode</p>
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
     * <p>Business Name: QueryLimit</p>
     * 
     * <p>Un-merged Business Name: QueryLimit</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020000CA.QueryByParameter.initialQuantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>There may be a very large number of matching rows. To 
     * manage communication bandwidth, a limited set may initially 
     * be returned with further data retrieved by using query 
     * continuations.</p>
     * 
     * <p>If not specified, the default behavior is to return all 
     * repetitions. However the recipient of a query may always 
     * choose to limit the quantity returned to be less than the 
     * number requested. Regardless of the number specified here, 
     * the number of rows returned will never exceed the number of 
     * matching rows based on the query parameters.</p>
     * 
     * <p>The number of response item repetitions that should be 
     * included in the initial response.</p>
     * 
     * <p>Un-merged Business Name: QueryLimit</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700751CA.QueryByParameter.initialQuantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>There may be a very large number of matching rows. To 
     * manage communication bandwidth, a limited set may initially 
     * be returned with further data retrieved by using query 
     * continuations.</p>
     * 
     * <p>If not specified, the default behavior is to return all 
     * repetitions. However the recipient of a query may always 
     * choose to limit the quantity returned to be less than the 
     * number requested. Regardless of the number specified here, 
     * the number of rows returned will never exceed the number of 
     * matching rows based on the query parameters.</p>
     * 
     * <p>The number of response item repetitions that should be 
     * included in the initial response.</p>
     * 
     * <p>Un-merged Business Name: QueryLimit</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700746CA.QueryByParameter.initialQuantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>There may be a very large number of matching rows. To 
     * manage communication bandwidth, a limited set may initially 
     * be returned with further data retrieved by using query 
     * continuations.</p>
     * 
     * <p>The number of response item repetitions that should be 
     * included in the initial response.</p>
     * 
     * <p>Un-merged Business Name: QueryLimit</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020002CA.QueryByParameter.initialQuantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>There may be a very large number of matching rows. To 
     * manage communication bandwidth, a limited set may initially 
     * be returned with further data retrieved by using query 
     * continuations.</p>
     * 
     * <p>If not specified, the default behavior is to return all 
     * repetitions. However the recipient of a query may always 
     * choose to limit the quantity returned to be less than the 
     * number requested. Regardless of the number specified here, 
     * the number of rows returned will never exceed the number of 
     * matching rows based on the query parameters.</p>
     * 
     * <p>The number of response item repetitions that should be 
     * included in the initial response.</p>
     * 
     * <p>Un-merged Business Name: QueryLimit</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120008CA.QueryByParameter.initialQuantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>There may be a very large number of matching rows. To 
     * manage communication bandwidth, a limited set may initially 
     * be returned with further data retrieved by using query 
     * continuations.</p>
     * 
     * <p>If not specified, the default behavior is to return all 
     * repetitions. However the recipient of a query may always 
     * choose to limit the quantity returned to be less than the 
     * number requested. Regardless of the number specified here, 
     * the number of rows returned will never exceed the number of 
     * matching rows based on the query parameters.</p>
     * 
     * <p>The number of response item repetitions that should be 
     * included in the initial response.</p>
     * 
     * <p>Un-merged Business Name: QueryLimit</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120006CA.QueryByParameter.initialQuantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>There may be a very large number of matching rows. To 
     * manage communication bandwidth, a limited set may initially 
     * be returned with further data retrieved by using query 
     * continuations.</p>
     * 
     * <p>If not specified, the default behavior is to return all 
     * repetitions. However the recipient of a query may always 
     * choose to limit the quantity returned to be less than the 
     * number requested. Regardless of the number specified here, 
     * the number of rows returned will never exceed the number of 
     * matching rows based on the query parameters.</p>
     * 
     * <p>The number of response item repetitions that should be 
     * included in the initial response.</p>
     */
    @Hl7XmlMapping({"initialQuantity"})
    public Integer getInitialQuantity() {
        return this.initialQuantity.getValue();
    }

    /**
     * <p>Business Name: QueryLimit</p>
     * 
     * <p>Un-merged Business Name: QueryLimit</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020000CA.QueryByParameter.initialQuantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>There may be a very large number of matching rows. To 
     * manage communication bandwidth, a limited set may initially 
     * be returned with further data retrieved by using query 
     * continuations.</p>
     * 
     * <p>If not specified, the default behavior is to return all 
     * repetitions. However the recipient of a query may always 
     * choose to limit the quantity returned to be less than the 
     * number requested. Regardless of the number specified here, 
     * the number of rows returned will never exceed the number of 
     * matching rows based on the query parameters.</p>
     * 
     * <p>The number of response item repetitions that should be 
     * included in the initial response.</p>
     * 
     * <p>Un-merged Business Name: QueryLimit</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700751CA.QueryByParameter.initialQuantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>There may be a very large number of matching rows. To 
     * manage communication bandwidth, a limited set may initially 
     * be returned with further data retrieved by using query 
     * continuations.</p>
     * 
     * <p>If not specified, the default behavior is to return all 
     * repetitions. However the recipient of a query may always 
     * choose to limit the quantity returned to be less than the 
     * number requested. Regardless of the number specified here, 
     * the number of rows returned will never exceed the number of 
     * matching rows based on the query parameters.</p>
     * 
     * <p>The number of response item repetitions that should be 
     * included in the initial response.</p>
     * 
     * <p>Un-merged Business Name: QueryLimit</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700746CA.QueryByParameter.initialQuantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>There may be a very large number of matching rows. To 
     * manage communication bandwidth, a limited set may initially 
     * be returned with further data retrieved by using query 
     * continuations.</p>
     * 
     * <p>The number of response item repetitions that should be 
     * included in the initial response.</p>
     * 
     * <p>Un-merged Business Name: QueryLimit</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020002CA.QueryByParameter.initialQuantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>There may be a very large number of matching rows. To 
     * manage communication bandwidth, a limited set may initially 
     * be returned with further data retrieved by using query 
     * continuations.</p>
     * 
     * <p>If not specified, the default behavior is to return all 
     * repetitions. However the recipient of a query may always 
     * choose to limit the quantity returned to be less than the 
     * number requested. Regardless of the number specified here, 
     * the number of rows returned will never exceed the number of 
     * matching rows based on the query parameters.</p>
     * 
     * <p>The number of response item repetitions that should be 
     * included in the initial response.</p>
     * 
     * <p>Un-merged Business Name: QueryLimit</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120008CA.QueryByParameter.initialQuantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>There may be a very large number of matching rows. To 
     * manage communication bandwidth, a limited set may initially 
     * be returned with further data retrieved by using query 
     * continuations.</p>
     * 
     * <p>If not specified, the default behavior is to return all 
     * repetitions. However the recipient of a query may always 
     * choose to limit the quantity returned to be less than the 
     * number requested. Regardless of the number specified here, 
     * the number of rows returned will never exceed the number of 
     * matching rows based on the query parameters.</p>
     * 
     * <p>The number of response item repetitions that should be 
     * included in the initial response.</p>
     * 
     * <p>Un-merged Business Name: QueryLimit</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120006CA.QueryByParameter.initialQuantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>There may be a very large number of matching rows. To 
     * manage communication bandwidth, a limited set may initially 
     * be returned with further data retrieved by using query 
     * continuations.</p>
     * 
     * <p>If not specified, the default behavior is to return all 
     * repetitions. However the recipient of a query may always 
     * choose to limit the quantity returned to be less than the 
     * number requested. Regardless of the number specified here, 
     * the number of rows returned will never exceed the number of 
     * matching rows based on the query parameters.</p>
     * 
     * <p>The number of response item repetitions that should be 
     * included in the initial response.</p>
     */
    public void setInitialQuantity(Integer initialQuantity) {
        this.initialQuantity.setValue(initialQuantity);
    }


    /**
     * <p>Business Name: QueryLimitType</p>
     * 
     * <p>Un-merged Business Name: QueryLimitType</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020000CA.QueryByParameter.initialQuantityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Needed to quantify the types of records requested to be 
     * returned in the query.</p>
     * 
     * <p>Defines the units associated with the magnitude of the 
     * maximum size limit of a query response that can be accepted 
     * by the requesting application.</p>
     * 
     * <p>Un-merged Business Name: QueryLimitType</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700751CA.QueryByParameter.initialQuantityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Needed to quantify the types of records requested to be 
     * returned in the query.</p>
     * 
     * <p>Defines the units associated with the magnitude of the 
     * maximum size limit of a query response that can be accepted 
     * by the requesting application.</p>
     * 
     * <p>Un-merged Business Name: QueryLimitType</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700746CA.QueryByParameter.initialQuantityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Needed to quantify the types of records requested to be 
     * returned in the query.</p>
     * 
     * <p>Defines the units associated with the magnitude of the 
     * maximum size limit of a query response that can be accepted 
     * by the requesting application.</p>
     * 
     * <p>Un-merged Business Name: QueryLimitType</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020002CA.QueryByParameter.initialQuantityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Needed to quantify the types of records requested to be 
     * returned in the query.</p>
     * 
     * <p>Defines the units associated with the magnitude of the 
     * maximum size limit of a query response that can be accepted 
     * by the requesting application.</p>
     * 
     * <p>Un-merged Business Name: QueryLimitType</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120008CA.QueryByParameter.initialQuantityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Needed to quantify the types of records requested to be 
     * returned in the query.</p>
     * 
     * <p>Defines the units associated with the magnitude of the 
     * maximum size limit of a query response that can be accepted 
     * by the requesting application.</p>
     * 
     * <p>Un-merged Business Name: QueryLimitType</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120006CA.QueryByParameter.initialQuantityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Needed to quantify the types of records requested to be 
     * returned in the query.</p>
     * 
     * <p>Defines the units associated with the magnitude of the 
     * maximum size limit of a query response that can be accepted 
     * by the requesting application.</p>
     */
    @Hl7XmlMapping({"initialQuantityCode"})
    public QueryRequestLimit getInitialQuantityCode() {
        return (QueryRequestLimit) this.initialQuantityCode.getValue();
    }

    /**
     * <p>Business Name: QueryLimitType</p>
     * 
     * <p>Un-merged Business Name: QueryLimitType</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020000CA.QueryByParameter.initialQuantityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Needed to quantify the types of records requested to be 
     * returned in the query.</p>
     * 
     * <p>Defines the units associated with the magnitude of the 
     * maximum size limit of a query response that can be accepted 
     * by the requesting application.</p>
     * 
     * <p>Un-merged Business Name: QueryLimitType</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700751CA.QueryByParameter.initialQuantityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Needed to quantify the types of records requested to be 
     * returned in the query.</p>
     * 
     * <p>Defines the units associated with the magnitude of the 
     * maximum size limit of a query response that can be accepted 
     * by the requesting application.</p>
     * 
     * <p>Un-merged Business Name: QueryLimitType</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700746CA.QueryByParameter.initialQuantityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Needed to quantify the types of records requested to be 
     * returned in the query.</p>
     * 
     * <p>Defines the units associated with the magnitude of the 
     * maximum size limit of a query response that can be accepted 
     * by the requesting application.</p>
     * 
     * <p>Un-merged Business Name: QueryLimitType</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020002CA.QueryByParameter.initialQuantityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Needed to quantify the types of records requested to be 
     * returned in the query.</p>
     * 
     * <p>Defines the units associated with the magnitude of the 
     * maximum size limit of a query response that can be accepted 
     * by the requesting application.</p>
     * 
     * <p>Un-merged Business Name: QueryLimitType</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120008CA.QueryByParameter.initialQuantityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Needed to quantify the types of records requested to be 
     * returned in the query.</p>
     * 
     * <p>Defines the units associated with the magnitude of the 
     * maximum size limit of a query response that can be accepted 
     * by the requesting application.</p>
     * 
     * <p>Un-merged Business Name: QueryLimitType</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120006CA.QueryByParameter.initialQuantityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Needed to quantify the types of records requested to be 
     * returned in the query.</p>
     * 
     * <p>Defines the units associated with the magnitude of the 
     * maximum size limit of a query response that can be accepted 
     * by the requesting application.</p>
     */
    public void setInitialQuantityCode(QueryRequestLimit initialQuantityCode) {
        this.initialQuantityCode.setValue(initialQuantityCode);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020000CA.QueryByParameter.parameterList</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700751CA.QueryByParameter.parameterList</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700746CA.QueryByParameter.parameterList</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020002CA.QueryByParameter.parameterList</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120008CA.QueryByParameter.parameterList</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120006CA.QueryByParameter.parameterList</p>
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
     * QUQI_MT020000CA.QueryByParameter.parameterList</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700751CA.QueryByParameter.parameterList</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700746CA.QueryByParameter.parameterList</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020002CA.QueryByParameter.parameterList</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120008CA.QueryByParameter.parameterList</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120006CA.QueryByParameter.parameterList</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setParameterList(PL parameterList) {
        this.parameterList = parameterList;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700751CA.QueryByParameter.sortControl</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-10)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700746CA.QueryByParameter.sortControl</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-10)</p>
     */
    @Hl7XmlMapping({"sortControl"})
    public List<SortControlBean> getSortControl() {
        return this.sortControl;
    }

}
