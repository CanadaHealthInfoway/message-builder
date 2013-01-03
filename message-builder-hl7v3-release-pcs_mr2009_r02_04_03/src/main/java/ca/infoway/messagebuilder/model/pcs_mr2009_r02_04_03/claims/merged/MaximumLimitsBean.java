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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"FICR_MT400003CA.MaximumLimits","FICR_MT400004CA.MaximumLimits","FICR_MT490102CA.MaximumLimits"})
public class MaximumLimitsBean extends MessagePartBean {

    private static final long serialVersionUID = 20130103L;
    private INT repeatNumber = new INTImpl();
    private PQ quantity = new PQImpl();
    private IVL<TS, Interval<Date>> expectedUseTime = new IVLImpl<TS, Interval<Date>>();


    /**
     * <p>Business Name: MaximumFillsPermitted</p>
     * 
     * <p>Un-merged Business Name: MaximumFillsPermitted</p>
     * 
     * <p>Relationship: FICR_MT490102CA.MaximumLimits.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: MaximumFillsPermitted</p>
     * 
     * <p>Relationship: FICR_MT400003CA.MaximumLimits.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: MaximumFillsPermitted</p>
     * 
     * <p>Relationship: FICR_MT400004CA.MaximumLimits.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"repeatNumber"})
    public Integer getRepeatNumber() {
        return this.repeatNumber.getValue();
    }

    /**
     * <p>Business Name: MaximumFillsPermitted</p>
     * 
     * <p>Un-merged Business Name: MaximumFillsPermitted</p>
     * 
     * <p>Relationship: FICR_MT490102CA.MaximumLimits.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: MaximumFillsPermitted</p>
     * 
     * <p>Relationship: FICR_MT400003CA.MaximumLimits.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: MaximumFillsPermitted</p>
     * 
     * <p>Relationship: FICR_MT400004CA.MaximumLimits.repeatNumber</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setRepeatNumber(Integer repeatNumber) {
        this.repeatNumber.setValue(repeatNumber);
    }


    /**
     * <p>Business Name: MaximumQuantitySupply</p>
     * 
     * <p>Un-merged Business Name: MaximumQuantitySupply</p>
     * 
     * <p>Relationship: FICR_MT490102CA.MaximumLimits.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: MaximumQuantitySupply</p>
     * 
     * <p>Relationship: FICR_MT400003CA.MaximumLimits.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: MaximumQuantitySupply</p>
     * 
     * <p>Relationship: FICR_MT400004CA.MaximumLimits.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getQuantity() {
        return this.quantity.getValue();
    }

    /**
     * <p>Business Name: MaximumQuantitySupply</p>
     * 
     * <p>Un-merged Business Name: MaximumQuantitySupply</p>
     * 
     * <p>Relationship: FICR_MT490102CA.MaximumLimits.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: MaximumQuantitySupply</p>
     * 
     * <p>Relationship: FICR_MT400003CA.MaximumLimits.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: MaximumQuantitySupply</p>
     * 
     * <p>Relationship: FICR_MT400004CA.MaximumLimits.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setQuantity(PhysicalQuantity quantity) {
        this.quantity.setValue(quantity);
    }


    /**
     * <p>Business Name: MaximumDaysSupply</p>
     * 
     * <p>Un-merged Business Name: MaximumDaysSupply</p>
     * 
     * <p>Relationship: 
     * FICR_MT490102CA.MaximumLimits.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: MaximumDaysSupply</p>
     * 
     * <p>Relationship: 
     * FICR_MT400003CA.MaximumLimits.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: MaximumDaysSupply</p>
     * 
     * <p>Relationship: 
     * FICR_MT400004CA.MaximumLimits.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"expectedUseTime"})
    public Interval<Date> getExpectedUseTime() {
        return this.expectedUseTime.getValue();
    }

    /**
     * <p>Business Name: MaximumDaysSupply</p>
     * 
     * <p>Un-merged Business Name: MaximumDaysSupply</p>
     * 
     * <p>Relationship: 
     * FICR_MT490102CA.MaximumLimits.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: MaximumDaysSupply</p>
     * 
     * <p>Relationship: 
     * FICR_MT400003CA.MaximumLimits.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: MaximumDaysSupply</p>
     * 
     * <p>Relationship: 
     * FICR_MT400004CA.MaximumLimits.expectedUseTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setExpectedUseTime(Interval<Date> expectedUseTime) {
        this.expectedUseTime.setValue(expectedUseTime);
    }

}
