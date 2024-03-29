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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.porx_mt010140ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt220100ca.DrugProductBean;



/**
 * <p>Business Name: Remaining Dispenses</p>
 * 
 * <p>Allows updating the quantity remaining to be 
 * dispensed.</p>
 * 
 * <p>Indicates dispenses yet to be made against the 
 * prescription</p>
 */
@Hl7PartTypeMapping({"PORX_MT010140CA.SupplyEvent"})
public class RemainingDispensesBean extends MessagePartBean {

    private static final long serialVersionUID = 20190730L;
    private PQ quantity = new PQImpl();
    private DrugProductBean productMedication;


    /**
     * <p>Business Name: C:Remaining Quantity</p>
     * 
     * <p>Relationship: PORX_MT010140CA.SupplyEvent.quantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to adjust quantity asserted with the electronic 
     * version of a prescription when fills have been issued by 
     * non-electronic pharmacies. Particularly important when the 
     * electronic version is being made 'authoritative' again.</p>
     * 
     * <p>The specified remaining fill quantity may never be 
     * greater than the remaining quantity recorded in the 
     * electronic system. If not specified, the quantity remaining 
     * will be left unchanged.</p>
     * 
     * <p>Indicates the remaining quantity to be dispensed.</p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getQuantity() {
        return this.quantity.getValue();
    }

    /**
     * <p>Business Name: C:Remaining Quantity</p>
     * 
     * <p>Relationship: PORX_MT010140CA.SupplyEvent.quantity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Used to adjust quantity asserted with the electronic 
     * version of a prescription when fills have been issued by 
     * non-electronic pharmacies. Particularly important when the 
     * electronic version is being made 'authoritative' again.</p>
     * 
     * <p>The specified remaining fill quantity may never be 
     * greater than the remaining quantity recorded in the 
     * electronic system. If not specified, the quantity remaining 
     * will be left unchanged.</p>
     * 
     * <p>Indicates the remaining quantity to be dispensed.</p>
     */
    public void setQuantity(PhysicalQuantity quantity) {
        this.quantity.setValue(quantity);
    }


    /**
     * <p>Relationship: PORX_MT010140CA.Product.medication</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"product/medication"})
    public DrugProductBean getProductMedication() {
        return this.productMedication;
    }

    /**
     * <p>Relationship: PORX_MT010140CA.Product.medication</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setProductMedication(DrugProductBean productMedication) {
        this.productMedication = productMedication;
    }

}
