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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"FICR_MT400003CA.MaximumLimits","FICR_MT400004CA.MaximumLimits","FICR_MT490102CA.MaximumLimits"})
public class MaximumLimitsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110901L;
    private INT maximumFillsPermitted = new INTImpl();
    private PQ maximumQuantitySupply = new PQImpl();
    private IVL<TS, Interval<Date>> maximumDaysSupply = new IVLImpl<TS, Interval<Date>>();


    /**
     * <p>MaximumFillsPermitted</p>
     * 
     * <p>Maximum Fills Permitted</p>
     */
    @Hl7XmlMapping({"repeatNumber"})
    public Integer getMaximumFillsPermitted() {
        return this.maximumFillsPermitted.getValue();
    }
    public void setMaximumFillsPermitted(Integer maximumFillsPermitted) {
        this.maximumFillsPermitted.setValue(maximumFillsPermitted);
    }


    /**
     * <p>MaximumQuantitySupply</p>
     * 
     * <p>Maximum Quantity Supply</p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getMaximumQuantitySupply() {
        return this.maximumQuantitySupply.getValue();
    }
    public void setMaximumQuantitySupply(PhysicalQuantity maximumQuantitySupply) {
        this.maximumQuantitySupply.setValue(maximumQuantitySupply);
    }


    /**
     * <p>MaximumDaysSupply</p>
     * 
     * <p>Maximum Days Supply</p>
     */
    @Hl7XmlMapping({"expectedUseTime"})
    public Interval<Date> getMaximumDaysSupply() {
        return this.maximumDaysSupply.getValue();
    }
    public void setMaximumDaysSupply(Interval<Date> maximumDaysSupply) {
        this.maximumDaysSupply.setValue(maximumDaysSupply);
    }

}
