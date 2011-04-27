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
package ca.infoway.messagebuilder.model.common.coct_mt490000ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COCT_MT490000CA.Product"})
public class ProductBean extends MessagePartBean {

    private II productID = new IIImpl();
    private CV<Code> productCode = new CVImpl<Code>();
    private ManufacturedMaterialKindBean manufacturedProductManufacturedMaterialKind;
    private ST organisationName = new STImpl();
    private TEL manufacturedProductManufacturerManufacturedProductOrganizationTelecom = new TELImpl();

    @Hl7XmlMapping({"manufacturedProduct/id"})
    public Identifier getProductID() {
        return this.productID.getValue();
    }
    public void setProductID(Identifier productID) {
        this.productID.setValue(productID);
    }

    @Hl7XmlMapping({"manufacturedProduct/code"})
    public Code getProductCode() {
        return this.productCode.getValue();
    }
    public void setProductCode(Code productCode) {
        this.productCode.setValue(productCode);
    }

    @Hl7XmlMapping({"manufacturedProduct/manufacturedMaterialKind"})
    public ManufacturedMaterialKindBean getManufacturedProductManufacturedMaterialKind() {
        return this.manufacturedProductManufacturedMaterialKind;
    }
    public void setManufacturedProductManufacturedMaterialKind(ManufacturedMaterialKindBean manufacturedProductManufacturedMaterialKind) {
        this.manufacturedProductManufacturedMaterialKind = manufacturedProductManufacturedMaterialKind;
    }

    @Hl7XmlMapping({"manufacturedProduct/manufacturerManufacturedProductOrganization/name"})
    public java.lang.String getOrganisationName() {
        return this.organisationName.getValue();
    }
    public void setOrganisationName(java.lang.String organisationName) {
        this.organisationName.setValue(organisationName);
    }

    @Hl7XmlMapping({"manufacturedProduct/manufacturerManufacturedProductOrganization/telecom"})
    public TelecommunicationAddress getManufacturedProductManufacturerManufacturedProductOrganizationTelecom() {
        return this.manufacturedProductManufacturerManufacturedProductOrganizationTelecom.getValue();
    }
    public void setManufacturedProductManufacturerManufacturedProductOrganizationTelecom(TelecommunicationAddress manufacturedProductManufacturerManufacturedProductOrganizationTelecom) {
        this.manufacturedProductManufacturerManufacturedProductOrganizationTelecom.setValue(manufacturedProductManufacturerManufacturedProductOrganizationTelecom);
    }

}
