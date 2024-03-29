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

import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;

public abstract class RecordRequestMessageBean<T> extends NewBaseMessageBean {

    private static final long serialVersionUID = -4171299182341789015L;

    private final RecordControlActEventBean<T> controlActEventBean;

    public RecordRequestMessageBean() {
        this.controlActEventBean = new RecordControlActEventBean<T>();
    }

    public RecordRequestMessageBean(RecordControlActEventBean<T> controlActEventBean) {
        this.controlActEventBean = controlActEventBean;
    }

    public RecordControlActEventBean<T> getControlActEvent() {
        return controlActEventBean;
    }

    @Hl7XmlMapping({ "controlActEvent", "controlActProcess" })
    public final RecordControlActEventBean<T> getControlActEventBean() {
        return this.controlActEventBean;
    }

    public AuthorBean getAuthor() {
        return getControlActEvent().getAuthor();
    }

    public AssignedPersonBean getResponsibleParty() {
        return getControlActEvent().getResponsibleParty();
    }

    public T getRecord() {
        return this.controlActEventBean == null ? null : this.controlActEventBean.getRecord();
    }
}
