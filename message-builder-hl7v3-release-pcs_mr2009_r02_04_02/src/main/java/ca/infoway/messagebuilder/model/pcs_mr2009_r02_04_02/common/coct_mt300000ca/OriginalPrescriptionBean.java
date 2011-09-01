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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt300000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



/**
 * <p>Original Prescription</p>
 * 
 * <p><p>When number of repeats is unlimited, specify Null 
 * Flavour of positive infinity in expected_use_time</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT300000CA.SupplyOrder"})
public class OriginalPrescriptionBean extends MessagePartBean {

    private static final long serialVersionUID = 20110901L;
    private IVL<TS, Interval<Date>> lastAllowedDispense = new IVLImpl<TS, Interval<Date>>();
    private INT numberOfRefills1 = new INTImpl();


    /**
     * <p>Last Allowed Dispense</p>
     * 
     * <p><p>Only end date of effective_time can be specified</p></p>
     * 
     * <p><p>last allowed dispense</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getLastAllowedDispense() {
        return this.lastAllowedDispense.getValue();
    }
    public void setLastAllowedDispense(Interval<Date> lastAllowedDispense) {
        this.lastAllowedDispense.setValue(lastAllowedDispense);
    }


    /**
     * <p>Number of Refills + 1</p>
     * 
     * <p><p># refills + 1</p></p>
     */
    @Hl7XmlMapping({"repeatNumber"})
    public Integer getNumberOfRefills1() {
        return this.numberOfRefills1.getValue();
    }
    public void setNumberOfRefills1(Integer numberOfRefills1) {
        this.numberOfRefills1.setValue(numberOfRefills1);
    }

}
