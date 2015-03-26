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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.coct_mt300000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Package Contents</p>
 * 
 * <p>Details of Product being dispensed</p>
 */
@Hl7PartTypeMapping({"COCT_MT300000CA.Content"})
public class PackageContentsBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private PQ quantity = new PQImpl();
    private DrugFormBean containedManufacturedMaterialKind;


    /**
     * <p>Relationship: COCT_MT300000CA.Content.quantity</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>package size</p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getQuantity() {
        return this.quantity.getValue();
    }

    /**
     * <p>Relationship: COCT_MT300000CA.Content.quantity</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>package size</p>
     */
    public void setQuantity(PhysicalQuantity quantity) {
        this.quantity.setValue(quantity);
    }


    /**
     * <p>Relationship: 
     * COCT_MT300000CA.Content.containedManufacturedMaterialKind</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"containedManufacturedMaterialKind"})
    public DrugFormBean getContainedManufacturedMaterialKind() {
        return this.containedManufacturedMaterialKind;
    }

    /**
     * <p>Relationship: 
     * COCT_MT300000CA.Content.containedManufacturedMaterialKind</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setContainedManufacturedMaterialKind(DrugFormBean containedManufacturedMaterialKind) {
        this.containedManufacturedMaterialKind = containedManufacturedMaterialKind;
    }

}
