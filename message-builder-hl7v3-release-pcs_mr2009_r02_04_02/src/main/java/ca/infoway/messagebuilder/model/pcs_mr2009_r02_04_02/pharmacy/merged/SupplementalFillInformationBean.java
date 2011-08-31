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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>PORX_MT010110CA.SupplementalFillInformation: (no business 
 * name)</p>
 * 
 * <p><p>Contains additional information related to the number 
 * of authorized fills and fill quantities.</p></p>
 * 
 * <p><p>Information required by the EHR when applying 
 * prescription rules.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT010110CA.SupplementalFillInformation","PORX_MT060040CA.SupplementalFillInformation"})
public class SupplementalFillInformationBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private INT numberOfFills = new INTImpl();
    private INT fillQuantity = new INTImpl();


    /**
     * <p>NumberOfFills</p>
     * 
     * <p>Number of Fills</p>
     * 
     * <p><p>Allows the prescriber to specify the number of fills 
     * authorized by this prescription.</p></p>
     * 
     * <p><p>A prescription can authorize multiple fills.</p></p>
     */
    @Hl7XmlMapping({"repeatNumber"})
    public Integer getNumberOfFills() {
        return this.numberOfFills.getValue();
    }
    public void setNumberOfFills(Integer numberOfFills) {
        this.numberOfFills.setValue(numberOfFills);
    }


    /**
     * <p>FillQuantity</p>
     * 
     * <p>Fill Quantity</p>
     * 
     * <p><p>Specifies the quantity for each fill.</p></p>
     * 
     * <p><p>The prescription is usually authorized for a specific 
     * quantity for each fill.</p></p>
     */
    @Hl7XmlMapping({"quantity"})
    public Integer getFillQuantity() {
        return this.fillQuantity.getValue();
    }
    public void setFillQuantity(Integer fillQuantity) {
        this.fillQuantity.setValue(fillQuantity);
    }

}
