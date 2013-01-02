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

package ca.infoway.messagebuilder.model.newfoundland;

import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.lang.Identifier;

public abstract class NewQueryResponseMessageBean<Q extends QueryCriteria, R> extends NewBaseMessageBean implements BaseQueryResponseMessageBean<Q, R> {

    private static final long serialVersionUID = -637892711521645863L;

    private QueryResponseControlActEventBean<Q, R> controlActEventBean;

    public NewQueryResponseMessageBean(Q criteria) {
        this.messageAttributes = new ResponseMessageAttributesBean();
        this.controlActEventBean = new QueryResponseControlActEventBean<Q, R>(criteria);
    }

    public NewQueryResponseMessageBean(ResponseMessageAttributesBean attributes, Q criteria) {
        this.messageAttributes = attributes;
        this.controlActEventBean = new QueryResponseControlActEventBean<Q, R>(criteria);
    }

    @Override
    public ResponseMessageAttributesBean getMessageAttributes() {
        return (ResponseMessageAttributesBean) this.messageAttributes;
    }

    public void setMessageAttributes(ResponseMessageAttributesBean responseMessageAttributesBean) {
        this.messageAttributes = responseMessageAttributesBean;
    }

    public QueryResponseControlActEventBean<Q, R> getControlActEvent() {
        return controlActEventBean;
    }

    @Hl7XmlMapping({ "controlActEvent", "controlActProcess" })
    public final QueryResponseControlActEventBean<Q, R> getControlActEventBean() {
        return this.controlActEventBean;
    }

    public AuthorBean getAuthor() {
        return getControlActEvent().getAuthor();
    }

    public Identifier getQueryId() {
        return getControlActEvent().getQueryId();
    }

    public void setQueryId(Identifier queryId) {
        getControlActEvent().setQueryId(queryId);
    }

    public Q getCriteria() {
        return getControlActEvent().getCriteria();
    }

    public QueryResultsSummaryBean getQuerySummary() {
        return getControlActEvent().getQueryResultsSummary();
    }

    public List<R> getRecords() {
        return getControlActEvent().getRecords();
    }

    public List<RecordBean<R>> getQueryRecords() {
        return getControlActEvent().getQueryRecords();
    }

    @Hl7XmlMapping("acknowledgement")
    public AcknowledgementBean getAcknowledgement() {
        return getMessageAttributes().getAcknowledgement();
    }

    public void setAcknowledgement(AcknowledgementBean acknowledgementBean) {
        getMessageAttributes().setAcknowledgement(acknowledgementBean);
    }

    public void clearControlActEvent() {
        this.controlActEventBean = null;
    }
}
