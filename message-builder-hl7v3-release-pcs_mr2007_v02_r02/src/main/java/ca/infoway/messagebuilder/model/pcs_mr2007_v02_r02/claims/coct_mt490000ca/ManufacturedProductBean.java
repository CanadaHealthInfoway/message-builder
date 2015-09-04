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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.claims.coct_mt490000ca;

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
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.domainvalue.ProductRoleType;



/**
 * <p>Business Name: Manufactured Product</p>
 * 
 * <p>Must have Organization if you don'''t have UPC/GTIN or 
 * pseudo UPC</p>
 * 
 * <p>Scoped by Manufacturer</p>
 */
@Hl7PartTypeMapping({"COCT_MT490000CA.ManufacturedProduct"})
public class ManufacturedProductBean extends MessagePartBean {

    private static final long serialVersionUID = 20150903L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private ManufacturedMaterialKindBean manufacturedMaterialKind;
    private ST manufacturerManufacturedProductOrganizationName = new STImpl();
    private TEL manufacturerManufacturedProductOrganizationTelecom = new TELImpl();


    /**
     * <p>Business Name: Product ID</p>
     * 
     * <p>Relationship: COCT_MT490000CA.ManufacturedProduct.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>serial number</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: Product ID</p>
     * 
     * <p>Relationship: COCT_MT490000CA.ManufacturedProduct.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>serial number</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: Product Code</p>
     * 
     * <p>Relationship: COCT_MT490000CA.ManufacturedProduct.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>code denoting product type</p>
     */
    @Hl7XmlMapping({"code"})
    public ProductRoleType getCode() {
        return (ProductRoleType) this.code.getValue();
    }

    /**
     * <p>Business Name: Product Code</p>
     * 
     * <p>Relationship: COCT_MT490000CA.ManufacturedProduct.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>code denoting product type</p>
     */
    public void setCode(ProductRoleType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Relationship: 
     * COCT_MT490000CA.ManufacturedProduct.manufacturedMaterialKind</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"manufacturedMaterialKind"})
    public ManufacturedMaterialKindBean getManufacturedMaterialKind() {
        return this.manufacturedMaterialKind;
    }

    /**
     * <p>Relationship: 
     * COCT_MT490000CA.ManufacturedProduct.manufacturedMaterialKind</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setManufacturedMaterialKind(ManufacturedMaterialKindBean manufacturedMaterialKind) {
        this.manufacturedMaterialKind = manufacturedMaterialKind;
    }


    /**
     * <p>Business Name: Organisation Name</p>
     * 
     * <p>Relationship: 
     * COCT_MT490000CA.ManufacturedProductOrganization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Manufacturer Name</p>
     */
    @Hl7XmlMapping({"manufacturerManufacturedProductOrganization/name"})
    public String getManufacturerManufacturedProductOrganizationName() {
        return this.manufacturerManufacturedProductOrganizationName.getValue();
    }

    /**
     * <p>Business Name: Organisation Name</p>
     * 
     * <p>Relationship: 
     * COCT_MT490000CA.ManufacturedProductOrganization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Manufacturer Name</p>
     */
    public void setManufacturerManufacturedProductOrganizationName(String manufacturerManufacturedProductOrganizationName) {
        this.manufacturerManufacturedProductOrganizationName.setValue(manufacturerManufacturedProductOrganizationName);
    }


    /**
     * <p>Relationship: 
     * COCT_MT490000CA.ManufacturedProductOrganization.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Organisation telephone/email</p>
     */
    @Hl7XmlMapping({"manufacturerManufacturedProductOrganization/telecom"})
    public TelecommunicationAddress getManufacturerManufacturedProductOrganizationTelecom() {
        return this.manufacturerManufacturedProductOrganizationTelecom.getValue();
    }

    /**
     * <p>Relationship: 
     * COCT_MT490000CA.ManufacturedProductOrganization.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Organisation telephone/email</p>
     */
    public void setManufacturerManufacturedProductOrganizationTelecom(TelecommunicationAddress manufacturerManufacturedProductOrganizationTelecom) {
        this.manufacturerManufacturedProductOrganizationTelecom.setValue(manufacturerManufacturedProductOrganizationTelecom);
    }

}
