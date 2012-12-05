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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PORX_MT010110CA.SupplementalFillInformation","PORX_MT060040CA.SupplementalFillInformation"})
public class SupplementalFillInformationBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private INT repeatNumber = new INTImpl();
    private INT quantity = new INTImpl();


    /**
     * <p>Business Name: NumberOfFills</p>
     * 
     * <p>Other Business Name: NumberOfFills</p>
     * 
     * <p>Relationship: 
     * PORX_MT010110CA.SupplementalFillInformation.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Other Business Name: NumberOfFills</p>
     * 
     * <p>Relationship: 
     * PORX_MT060040CA.SupplementalFillInformation.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"repeatNumber"})
    public Integer getRepeatNumber() {
        return this.repeatNumber.getValue();
    }

    /**
     * <p>Business Name: NumberOfFills</p>
     * 
     * <p>Other Business Name: NumberOfFills</p>
     * 
     * <p>Relationship: 
     * PORX_MT010110CA.SupplementalFillInformation.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Other Business Name: NumberOfFills</p>
     * 
     * <p>Relationship: 
     * PORX_MT060040CA.SupplementalFillInformation.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setRepeatNumber(Integer repeatNumber) {
        this.repeatNumber.setValue(repeatNumber);
    }


    /**
     * <p>Business Name: FillQuantity</p>
     * 
     * <p>Other Business Name: FillQuantity</p>
     * 
     * <p>Relationship: 
     * PORX_MT010110CA.SupplementalFillInformation.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Other Business Name: FillQuantity</p>
     * 
     * <p>Relationship: 
     * PORX_MT060040CA.SupplementalFillInformation.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"quantity"})
    public Integer getQuantity() {
        return this.quantity.getValue();
    }

    /**
     * <p>Business Name: FillQuantity</p>
     * 
     * <p>Other Business Name: FillQuantity</p>
     * 
     * <p>Relationship: 
     * PORX_MT010110CA.SupplementalFillInformation.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Other Business Name: FillQuantity</p>
     * 
     * <p>Relationship: 
     * PORX_MT060040CA.SupplementalFillInformation.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setQuantity(Integer quantity) {
        this.quantity.setValue(quantity);
    }

}
