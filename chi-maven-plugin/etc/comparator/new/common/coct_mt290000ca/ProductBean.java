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
package ca.infoway.messagebuilder.model.common.coct_mt290000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CE;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.CEImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.EntityCode;
import ca.infoway.messagebuilder.domainvalue.RoleCode;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Repaired wheelchair, service provided but prescription 
 * (product) not filled (e.g. may due to harm to patient), etc. 
 */
@Hl7PartTypeMapping({"COCT_MT290000CA.Product"})
public class ProductBean extends MessagePartBean {

    private II productNumber = new IIImpl();
    private CV<RoleCode> productNumberCode = new CVImpl<RoleCode>();
    private CE<EntityCode> manufacturedProductManufacturedMaterialCode = new CEImpl<EntityCode>();
    private ST manufacturerName = new STImpl();
    private TEL manufacturerTelecom = new TELImpl();

    @Hl7XmlMapping({"manufacturedProduct/id"})
    public Identifier getProductNumber() {
        return this.productNumber.getValue();
    }
    public void setProductNumber(Identifier productNumber) {
        this.productNumber.setValue(productNumber);
    }

    @Hl7XmlMapping({"manufacturedProduct/code"})
    public RoleCode getProductNumberCode() {
        return this.productNumberCode.getValue();
    }
    public void setProductNumberCode(RoleCode productNumberCode) {
        this.productNumberCode.setValue(productNumberCode);
    }

    @Hl7XmlMapping({"manufacturedProduct/manufacturedMaterial/code"})
    public EntityCode getManufacturedProductManufacturedMaterialCode() {
        return this.manufacturedProductManufacturedMaterialCode.getValue();
    }
    public void setManufacturedProductManufacturedMaterialCode(EntityCode manufacturedProductManufacturedMaterialCode) {
        this.manufacturedProductManufacturedMaterialCode.setValue(manufacturedProductManufacturedMaterialCode);
    }

    @Hl7XmlMapping({"manufacturedProduct/manufacturerManufacturedProductOrganization/name"})
    public java.lang.String getManufacturerName() {
        return this.manufacturerName.getValue();
    }
    public void setManufacturerName(java.lang.String manufacturerName) {
        this.manufacturerName.setValue(manufacturerName);
    }

    @Hl7XmlMapping({"manufacturedProduct/manufacturerManufacturedProductOrganization/telecom"})
    public TelecommunicationAddress getManufacturerTelecom() {
        return this.manufacturerTelecom.getValue();
    }
    public void setManufacturerTelecom(TelecommunicationAddress manufacturerTelecom) {
        this.manufacturerTelecom.setValue(manufacturerTelecom);
    }

}
