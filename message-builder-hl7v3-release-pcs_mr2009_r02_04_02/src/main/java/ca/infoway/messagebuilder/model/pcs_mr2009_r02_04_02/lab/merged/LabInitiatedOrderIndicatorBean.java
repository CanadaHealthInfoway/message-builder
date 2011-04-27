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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"POLB_MT001000CA.LabInitiatedOrderIndicator","POLB_MT001001CA.LabInitiatedOrderIndicator","POLB_MT001010CA.LabInitiatedOrderIndicator","POLB_MT001999CA.LabInitiatedOrderIndicator"})
public class LabInitiatedOrderIndicatorBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private BL labInitiatedOrderIndicator = new BLImpl();


    /**
     * <p>LabInitiatedOrderIndicator</p>
     * 
     * <p>Lab Initiated Order Indicator</p>
     * 
     * <p>Lab Initiated Order Indicator</p>
     * 
     * <p><p>A 'true' value indicates that the Order was initiated 
     * by the Lab.</p></p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getLabInitiatedOrderIndicator() {
        return this.labInitiatedOrderIndicator.getValue();
    }
    public void setLabInitiatedOrderIndicator(Boolean labInitiatedOrderIndicator) {
        this.labInitiatedOrderIndicator.setValue(labInitiatedOrderIndicator);
    }

}
