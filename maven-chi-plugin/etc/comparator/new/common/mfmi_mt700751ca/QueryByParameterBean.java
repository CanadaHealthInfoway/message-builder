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
package ca.infoway.messagebuilder.model.common.mfmi_mt700751ca;

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
import ca.infoway.messagebuilder.model.merged.SortControlBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



/**
 * <p>Query By Parameter 
 * 
 * <p>Class which describes the query specifics and parameter 
 * list. 
 * 
 * <p>InitialQuantity must only be specified if 
 * InitialQuantityCode is specified. 
 */
@Hl7PartTypeMapping({"MFMI_MT700751CA.QueryByParameter"})
public class QueryByParameterBean<PL> extends MessagePartBean {

    private II queryIdentifier = new IIImpl();
    private CS<ResponseModality> expeditedQueryIndicator = new CSImpl<ResponseModality>();
    private INT queryLimit = new INTImpl();
    private CV<QueryRequestLimit> queryLimitType = new CVImpl<QueryRequestLimit>();
    private PL parameterList;
    private List<SortControlBean> sortControl = new ArrayList<SortControlBean>();

    @Hl7XmlMapping({"queryId"})
    public Identifier getQueryIdentifier() {
        return this.queryIdentifier.getValue();
    }
    public void setQueryIdentifier(Identifier queryIdentifier) {
        this.queryIdentifier.setValue(queryIdentifier);
    }

    @Hl7XmlMapping({"responseModalityCode"})
    public ResponseModality getExpeditedQueryIndicator() {
        return this.expeditedQueryIndicator.getValue();
    }
    public void setExpeditedQueryIndicator(ResponseModality expeditedQueryIndicator) {
        this.expeditedQueryIndicator.setValue(expeditedQueryIndicator);
    }

    @Hl7XmlMapping({"initialQuantity"})
    public java.lang.Integer getQueryLimit() {
        return this.queryLimit.getValue();
    }
    public void setQueryLimit(java.lang.Integer queryLimit) {
        this.queryLimit.setValue(queryLimit);
    }

    @Hl7XmlMapping({"initialQuantityCode"})
    public QueryRequestLimit getQueryLimitType() {
        return this.queryLimitType.getValue();
    }
    public void setQueryLimitType(QueryRequestLimit queryLimitType) {
        this.queryLimitType.setValue(queryLimitType);
    }

    @Hl7XmlMapping({"parameterList"})
    public PL getParameterList() {
        return this.parameterList;
    }
    public void setParameterList(PL parameterList) {
        this.parameterList = parameterList;
    }

    @Hl7XmlMapping({"sortControl"})
    public List<SortControlBean> getSortControl() {
        return this.sortControl;
    }

}
