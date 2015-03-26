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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: QueryDefinition</p>
 * 
 * <p>QUQI_MT020000CA.QueryByParameter: Query definition</p>
 * 
 * <p>initialQuantityCode must be populated if and only if 
 * initialQuantity is populated</p>
 * 
 * <p>Identifies the content desired within a query.</p>
 * 
 * <p>Provides support for queries</p>
 * 
 * <p>QUQI_MT120000CA.QueryByParameter: Query definition</p>
 * 
 * <p>initialQuantityCode must be populated if and only if 
 * initialQuantity is populated</p>
 * 
 * <p>Identifies the content desired within a query.</p>
 * 
 * <p>Provides support for queries</p>
 */
@Hl7PartTypeMapping({"QUQI_MT020000CA.QueryByParameter","QUQI_MT120000CA.QueryByParameter"})
public class QueryDefinitionBean<PL> extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private II queryId = new IIImpl();
    private INT initialQuantity = new INTImpl();
    private PL parameterList;


    /**
     * <p>Business Name: QueryIdentifier</p>
     * 
     * <p>Un-merged Business Name: QueryIdentifier</p>
     * 
     * <p>Relationship: QUQI_MT020000CA.QueryByParameter.queryId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Unique number for this particular query.</p>
     * 
     * <p>Needed to allow continuation of queries and linking of 
     * query requests and responses and therefore mandatory.</p>
     * 
     * <p><div>The identifier of the query.</div> <p>PIN will 
     * ignore the contents of this field.&nbsp;</p></p>
     * 
     * <p>Un-merged Business Name: QueryIdentifier</p>
     * 
     * <p>Relationship: QUQI_MT120000CA.QueryByParameter.queryId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Unique number for this particular query.</p>
     * 
     * <p>Needed to allow continuation of queries and linking of 
     * query requests and responses and therefore mandatory.</p>
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
     * <p>Unique number for this particular query.</p>
     * 
     * <p>Needed to allow continuation of queries and linking of 
     * query requests and responses and therefore mandatory.</p>
     * 
     * <p><div>The identifier of the query.</div> <p>PIN will 
     * ignore the contents of this field.&nbsp;</p></p>
     * 
     * <p>Un-merged Business Name: QueryIdentifier</p>
     * 
     * <p>Relationship: QUQI_MT120000CA.QueryByParameter.queryId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Unique number for this particular query.</p>
     * 
     * <p>Needed to allow continuation of queries and linking of 
     * query requests and responses and therefore mandatory.</p>
     */
    public void setQueryId(Identifier queryId) {
        this.queryId.setValue(queryId);
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
     * <p>The number of response item repetitions that should be 
     * included in the initial response.</p>
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
     * <p>Un-merged Business Name: QueryLimit</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120000CA.QueryByParameter.initialQuantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The number of response item repetitions that should be 
     * included in the initial response.</p>
     * 
     * <p>There may be a very large number of matching rows. To 
     * manage communication bandwidth, a limited set may initially 
     * be returned with further data retrieved by using query 
     * continuations. If not specified, the default behavior is to 
     * return all repetitions. However the recipient of a query may 
     * always choose to limit the quantity returned to be less than 
     * the number requested.</p>
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
     * <p>The number of response item repetitions that should be 
     * included in the initial response.</p>
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
     * <p>Un-merged Business Name: QueryLimit</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120000CA.QueryByParameter.initialQuantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The number of response item repetitions that should be 
     * included in the initial response.</p>
     * 
     * <p>There may be a very large number of matching rows. To 
     * manage communication bandwidth, a limited set may initially 
     * be returned with further data retrieved by using query 
     * continuations. If not specified, the default behavior is to 
     * return all repetitions. However the recipient of a query may 
     * always choose to limit the quantity returned to be less than 
     * the number requested.</p>
     */
    public void setInitialQuantity(Integer initialQuantity) {
        this.initialQuantity.setValue(initialQuantity);
    }


    /**
     * <p>Business Name: ParameterList</p>
     * 
     * <p>Un-merged Business Name: ParameterList</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020000CA.QueryByParameter.parameterList</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>&nbsp;This is where the query-specific parameters are</p> 
     * <div>specified.</div>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120000CA.QueryByParameter.parameterList</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p><div>This will simply echo the query parameters from 
     * the</div> <p>original query.&nbsp;</p></p>
     */
    @Hl7XmlMapping({"parameterList"})
    public PL getParameterList() {
        return this.parameterList;
    }

    /**
     * <p>Business Name: ParameterList</p>
     * 
     * <p>Un-merged Business Name: ParameterList</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020000CA.QueryByParameter.parameterList</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>&nbsp;This is where the query-specific parameters are</p> 
     * <div>specified.</div>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT120000CA.QueryByParameter.parameterList</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p><div>This will simply echo the query parameters from 
     * the</div> <p>original query.&nbsp;</p></p>
     */
    public void setParameterList(PL parameterList) {
        this.parameterList = parameterList;
    }

}
