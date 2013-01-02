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

import ca.infoway.messagebuilder.annotation.Hl7BusinessName;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.lang.Identifier;

public abstract class NewQueryMessageBean<Q extends QueryCriteria> extends NewBaseMessageBean implements BaseQueryMessageBean<Q> {

    private static final long serialVersionUID = 3941752675494132716L;

    @Hl7BusinessName("controlActEvent")
    private final QueryControlActEventBean<Q> controlActEventBean;

    public NewQueryMessageBean(Q criteria) {
        this.controlActEventBean = new QueryControlActEventBean<Q>(criteria);
    }

    public QueryControlActEventBean<Q> getControlActEvent() {
        return controlActEventBean;
    }

    @Hl7XmlMapping({ "controlActEvent", "controlActProcess" })
    public final QueryControlActEventBean<Q> getControlActEventBean() {
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
}
