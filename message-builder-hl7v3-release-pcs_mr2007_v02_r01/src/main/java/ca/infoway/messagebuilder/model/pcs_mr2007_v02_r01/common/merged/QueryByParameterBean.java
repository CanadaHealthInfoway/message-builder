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

    private static final long serialVersionUID = 20111117L;
    private II queryId = new IIImpl();
    private CS responseModalityCode = new CSImpl();
    private INT initialQuantity = new INTImpl();
    private CV initialQuantityCode = new CVImpl();
    private PL parameterList;
    private INT sortControlSequenceNumber = new INTImpl();
    private ST sortControlElementName = new STImpl();
    private CS sortControlDirectionCode = new CSImpl();


    /**
     * <p>QueryIdentifier</p>
     * 
     * <p>H:Query Identifier</p>
     */
    @Hl7XmlMapping({"queryId"})
    public Identifier getQueryId() {
        return this.queryId.getValue();
    }
    public void setQueryId(Identifier queryId) {
        this.queryId.setValue(queryId);
    }


    /**
     * <p>ExpeditedQueryIndicator</p>
     * 
     * <p>K: Expedited Query Indicator</p>
     */
    @Hl7XmlMapping({"responseModalityCode"})
    public ResponseModality getResponseModalityCode() {
        return (ResponseModality) this.responseModalityCode.getValue();
    }
    public void setResponseModalityCode(ResponseModality responseModalityCode) {
        this.responseModalityCode.setValue(responseModalityCode);
    }


    /**
     * <p>QueryLimit</p>
     * 
     * <p>I:Query Limit</p>
     */
    @Hl7XmlMapping({"initialQuantity"})
    public Integer getInitialQuantity() {
        return this.initialQuantity.getValue();
    }
    public void setInitialQuantity(Integer initialQuantity) {
        this.initialQuantity.setValue(initialQuantity);
    }


    /**
     * <p>QueryLimitType</p>
     * 
     * <p>J:Query Limit Type</p>
     */
    @Hl7XmlMapping({"initialQuantityCode"})
    public QueryRequestLimit getInitialQuantityCode() {
        return (QueryRequestLimit) this.initialQuantityCode.getValue();
    }
    public void setInitialQuantityCode(QueryRequestLimit initialQuantityCode) {
        this.initialQuantityCode.setValue(initialQuantityCode);
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
    public Integer getSortControlSequenceNumber() {
        return this.sortControlSequenceNumber.getValue();
    }
    public void setSortControlSequenceNumber(Integer sortControlSequenceNumber) {
        this.sortControlSequenceNumber.setValue(sortControlSequenceNumber);
    }


    /**
     * <p>SortElementName</p>
     * 
     * <p>Sort Element Name</p>
     */
    @Hl7XmlMapping({"sortControl/elementName"})
    public String getSortControlElementName() {
        return this.sortControlElementName.getValue();
    }
    public void setSortControlElementName(String sortControlElementName) {
        this.sortControlElementName.setValue(sortControlElementName);
    }


    /**
     * <p>SortControlDirection</p>
     * 
     * <p>Sort Control Direction</p>
     */
    @Hl7XmlMapping({"sortControl/directionCode"})
    public Sequencing getSortControlDirectionCode() {
        return (Sequencing) this.sortControlDirectionCode.getValue();
    }
    public void setSortControlDirectionCode(Sequencing sortControlDirectionCode) {
        this.sortControlDirectionCode.setValue(sortControlDirectionCode);
    }

}
