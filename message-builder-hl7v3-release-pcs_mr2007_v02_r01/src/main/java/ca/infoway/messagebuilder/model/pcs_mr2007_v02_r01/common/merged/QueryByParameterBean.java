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

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.QueryRequestLimit;
import ca.infoway.messagebuilder.domainvalue.ResponseModality;
import ca.infoway.messagebuilder.domainvalue.Sequencing;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"MFMI_MT700746CA.QueryByParameter","MFMI_MT700751CA.QueryByParameter","QUQI_MT020000CA.QueryByParameter","QUQI_MT020002CA.QueryByParameter","QUQI_MT120006CA.QueryByParameter","QUQI_MT120008CA.QueryByParameter"})
public class QueryByParameterBean<PL> extends MessagePartBean {

    private static final long serialVersionUID = 20110729L;
    private II queryIdentifier = new IIImpl();
    private CS expeditedQueryIndicator = new CSImpl();
    private INT queryLimit = new INTImpl();
    private CV queryLimitType = new CVImpl();
    private PL parameterList;
    private INT sequenceNumber = new INTImpl();
    private ST sortElementName = new STImpl();
    private CS sortControlDirection = new CSImpl();


    /**
     * <p>QueryIdentifier</p>
     * 
     * <p>H:Query Identifier</p>
     */
    @Hl7XmlMapping({"queryId"})
    public Identifier getQueryIdentifier() {
        return this.queryIdentifier.getValue();
    }
    public void setQueryIdentifier(Identifier queryIdentifier) {
        this.queryIdentifier.setValue(queryIdentifier);
    }


    /**
     * <p>ExpeditedQueryIndicator</p>
     * 
     * <p>K: Expedited Query Indicator</p>
     */
    @Hl7XmlMapping({"responseModalityCode"})
    public ResponseModality getExpeditedQueryIndicator() {
        return (ResponseModality) this.expeditedQueryIndicator.getValue();
    }
    public void setExpeditedQueryIndicator(ResponseModality expeditedQueryIndicator) {
        this.expeditedQueryIndicator.setValue(expeditedQueryIndicator);
    }


    /**
     * <p>QueryLimit</p>
     * 
     * <p>I:Query Limit</p>
     */
    @Hl7XmlMapping({"initialQuantity"})
    public Integer getQueryLimit() {
        return this.queryLimit.getValue();
    }
    public void setQueryLimit(Integer queryLimit) {
        this.queryLimit.setValue(queryLimit);
    }


    /**
     * <p>QueryLimitType</p>
     * 
     * <p>J:Query Limit Type</p>
     */
    @Hl7XmlMapping({"initialQuantityCode"})
    public QueryRequestLimit getQueryLimitType() {
        return (QueryRequestLimit) this.queryLimitType.getValue();
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


    /**
     * <p>SequenceNumber</p>
     * 
     * <p>Sequence Number</p>
     */
    @Hl7XmlMapping({"sortControl/sequenceNumber"})
    public Integer getSequenceNumber() {
        return this.sequenceNumber.getValue();
    }
    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber.setValue(sequenceNumber);
    }


    /**
     * <p>SortElementName</p>
     * 
     * <p>Sort Element Name</p>
     */
    @Hl7XmlMapping({"sortControl/elementName"})
    public String getSortElementName() {
        return this.sortElementName.getValue();
    }
    public void setSortElementName(String sortElementName) {
        this.sortElementName.setValue(sortElementName);
    }


    /**
     * <p>SortControlDirection</p>
     * 
     * <p>Sort Control Direction</p>
     */
    @Hl7XmlMapping({"sortControl/directionCode"})
    public Sequencing getSortControlDirection() {
        return (Sequencing) this.sortControlDirection.getValue();
    }
    public void setSortControlDirection(Sequencing sortControlDirection) {
        this.sortControlDirection.setValue(sortControlDirection);
    }

}
