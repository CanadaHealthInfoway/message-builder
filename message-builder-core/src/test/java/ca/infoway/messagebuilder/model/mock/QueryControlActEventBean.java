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

package ca.infoway.messagebuilder.model.mock;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.lang.Identifier;

@Hl7PartTypeMapping({"MFMI_MT700751CA.ControlActEvent"})
public class QueryControlActEventBean<PL> extends ControlActEventBean implements Serializable {

    private static final long serialVersionUID = 7409413947816976194L;

    private ConsentEventBean consentEvent;
    private QueryByParameterBean<PL> queryByParameter = new QueryByParameterBean<PL>();

    public QueryControlActEventBean() {
    }
    public QueryControlActEventBean(PL criteria) {
        this.queryByParameter.setParameterList(criteria);
    }

    public PL getCriteria() {
        return this.queryByParameter.getParameterList();
    }

    public Identifier getQueryId() {
        return this.queryByParameter.getQueryIdentifier();
    }

    public void setQueryId(Identifier queryId) {
    	this.queryByParameter.setQueryIdentifier(queryId);
    }

    public Integer getQueryLimit() {
        return this.queryByParameter.getQueryLimit();
    }

    public void setQueryLimit(Integer queryLimit) {
        this.queryByParameter.setQueryLimit(queryLimit);
    }

    @Hl7XmlMapping("subjectOf2/consentEvent")
    public ConsentEventBean getConsentEvent() {
        return consentEvent;
    }

    public void setConsentEvent(ConsentEventBean consentEvent) {
        this.consentEvent = consentEvent;
    }

    @Hl7XmlMapping("queryByParameter")
	public QueryByParameterBean<PL> getQueryByParameter() {
		return this.queryByParameter;
	}

	public void setQueryByParameter(QueryByParameterBean<PL> queryByParameter) {
		this.queryByParameter = queryByParameter;
	}
}
