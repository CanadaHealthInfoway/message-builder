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

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.QueryResponse;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "QUQI_MT120006CA.QueryAck" })
public class QueryResultsSummaryBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = 2632243683968632921L;

    private II queryId = new IIImpl();

    private CD queryResponseCode = new CDImpl();

    private INT resultTotalQuantity = new INTImpl();

    private INT resultCurrentQuantity = new INTImpl();

    private INT resultRemainingQuantity = new INTImpl();

    @Hl7XmlMapping("queryId")
    public Identifier getQueryId() {
        return this.queryId.getValue();
    }

    public void setQueryId(Identifier queryId) {
        this.queryId.setValue(queryId);
    }

    @Hl7XmlMapping("queryResponseCode")
    public QueryResponse getQueryResponseCode() {
        return (QueryResponse) this.queryResponseCode.getValue();
    }

    public void setQueryResponseCode(QueryResponse queryResponseCode) {
        this.queryResponseCode.setValue(queryResponseCode);
    }

    @Hl7XmlMapping("resultTotalQuantity")
    public Integer getResultTotalQuantity() {
        return this.resultTotalQuantity.getValue();
    }

    public void setResultTotalQuantity(Integer resultTotalQuantity) {
        this.resultTotalQuantity.setValue(resultTotalQuantity);
    }

    @Hl7XmlMapping("resultCurrentQuantity")
    public Integer getResultCurrentQuantity() {
        return this.resultCurrentQuantity.getValue();
    }

    public void setResultCurrentQuantity(Integer resultCurrentQuantity) {
        this.resultCurrentQuantity.setValue(resultCurrentQuantity);
    }

    @Hl7XmlMapping("resultRemainingQuantity")
    public Integer getResultRemainingQuantity() {
        return this.resultRemainingQuantity.getValue();
    }

    public void setResultRemainingQuantity(Integer resultRemainingQuantity) {
        this.resultRemainingQuantity.setValue(resultRemainingQuantity);
    }
}
