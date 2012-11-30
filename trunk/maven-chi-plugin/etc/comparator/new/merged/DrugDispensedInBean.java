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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.OrderableDrugForm;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COCT_MT220100CA.Content","COCT_MT220110CA.Content","COCT_MT220200CA.Content","COCT_MT220210CA.Content","COCT_MT300000CA.Content"})
public class DrugDispensedInBean extends MessagePartBean {

    private PQ drugPackageQuantity = new PQImpl();
    private DrugPackageBean containerPackagedMedicine;
    private CV<OrderableDrugForm> drugForm = new CVImpl<OrderableDrugForm>();

    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getDrugPackageQuantity() {
        return this.drugPackageQuantity.getValue();
    }
    public void setDrugPackageQuantity(PhysicalQuantity drugPackageQuantity) {
        this.drugPackageQuantity.setValue(drugPackageQuantity);
    }

    @Hl7XmlMapping({"containerPackagedMedicine"})
    public DrugPackageBean getContainerPackagedMedicine() {
        return this.containerPackagedMedicine;
    }
    public void setContainerPackagedMedicine(DrugPackageBean containerPackagedMedicine) {
        this.containerPackagedMedicine = containerPackagedMedicine;
    }

    @Hl7XmlMapping({"containedManufacturedMaterialKind/formCode"})
    public OrderableDrugForm getDrugForm() {
        return this.drugForm.getValue();
    }
    public void setDrugForm(OrderableDrugForm drugForm) {
        this.drugForm.setValue(drugForm);
    }

}
