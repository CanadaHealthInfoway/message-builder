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

package ca.infoway.messagebuilder.model.newfoundland;

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

/**
 * <p>Query By Parameter 
 * 
 * <p>Class which describes the query specifics and parameter 
 * list. 
 * 
 * <p>InitialQuantity must only be specified if 
 * InitialQuantityCode is specified. 
 */
@Hl7PartTypeMapping("MFMI_MT700751CA.QueryByParameter")
public class QueryByParameterBean<Q extends QueryCriteria> extends MessagePartBean {

    private static final long serialVersionUID = -3400214301200401224L;
	private II queryIdentifier = new IIImpl();
    private CS expeditedQueryIndicator = new CSImpl();
    private INT queryLimit = new INTImpl();
    private CV queryLimitType = new CVImpl();
    private Q parameterList;


    /**
     * <p>H:Query Identifier 
     * 
     * <p>Unique number for this particular query. 
     * 
     * <p>Needed to allow continuation of queries and linking of 
     * query requests and responses and therefore mandatory. 
     */
    @Hl7XmlMapping("queryId")
    public Identifier getQueryIdentifier() {
        return this.queryIdentifier.getValue();
    }
    public void setQueryIdentifier(Identifier queryIdentifier) {
        this.queryIdentifier.setValue(queryIdentifier);
    }


    /**
     * <p>K: Expedited Query Indicator 
     * 
     * <p>This allows the sender to indicate to the receiver that 
     * this query should follow an expedited processing flow. 
     * 
     * <p>Intended to convey the requested 'packaging' of query 
     * results. This attribute does not affect which rows are 
     * selected by the query, just the manner in which they are 
     * returned. For example, a batch file containing responses, a 
     * response message containing multiple payloads, or a stream 
     * of response messages (notifications) each identifying itself 
     * as a response to a query request. 
     */
    @Hl7XmlMapping("responseModalityCode")
    public ResponseModality getExpeditedQueryIndicator() {
        return (ResponseModality) this.expeditedQueryIndicator.getValue();
    }
    public void setExpeditedQueryIndicator(ResponseModality expeditedQueryIndicator) {
        this.expeditedQueryIndicator.setValue(expeditedQueryIndicator);
    }


    /**
     * <p>I:Query Limit 
     * 
     * <p>The number of response item repetitions that should be 
     * included in the initial response. 
     * 
     * <p>If not specified, the default behavior is to return all 
     * repetitions. However the recipient of a query may always 
     * choose to limit the quantity returned to be less than the 
     * number requested. Regardless of the number specified here, 
     * the number of rows returned will never exceed the number of 
     * matching rows based on the query parameters. 
     * 
     * <p>There may be a very large number of matching rows. To 
     * manage communication bandwidth, a limited set may initially 
     * be returned with further data retrieved by using query 
     * continuations. 
     */
    @Hl7XmlMapping("initialQuantity")
    public Integer getQueryLimit() {
        return this.queryLimit.getValue();
    }
    public void setQueryLimit(Integer queryLimit) {
        this.queryLimit.setValue(queryLimit);
    }


    /**
     * <p>J:Query Limit Type 
     * 
     * <p>Defines the units associated with the magnitude of the 
     * maximum size limit of a query response that can be accepted 
     * by the requesting application. 
     * 
     * <p>Needed to quantify the types of records requested to be 
     * returned in the query. 
     */
    @Hl7XmlMapping("initialQuantityCode")
    public QueryRequestLimit getQueryLimitType() {
        return (QueryRequestLimit) this.queryLimitType.getValue();
    }
    public void setQueryLimitType(QueryRequestLimit queryLimitType) {
        this.queryLimitType.setValue(queryLimitType);
    }
    @Hl7XmlMapping("parameterList")
	public Q getParameterList() {
		return this.parameterList;
	}
	public void setParameterList(Q parameterList) {
		this.parameterList = parameterList;
	}
}
