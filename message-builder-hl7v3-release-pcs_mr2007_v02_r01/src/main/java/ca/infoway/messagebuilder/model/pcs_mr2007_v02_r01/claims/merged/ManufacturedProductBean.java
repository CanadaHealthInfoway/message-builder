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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.merged;

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
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.coct_mt490000ca.ManufacturedMaterialKindBean;



/**
 * <p>COCT_MT490000CA.ManufacturedProduct: (no business name)</p>
 * 
 * <p>Must have Organization if you dont have UPC/GTIN or 
 * pseudo UPC</p>
 * 
 * <p>Scoped by Manufacturer</p>
 * 
 * <p>COCT_MT290000CA.ManufacturedProduct: (no business name)</p>
 * 
 * <p>Must have Role.cd or ManufacturedMaterial.cd</p>
 * 
 * <p>Scoped by Manufacturer</p>
 */
@Hl7PartTypeMapping({"COCT_MT290000CA.ManufacturedProduct","COCT_MT490000CA.ManufacturedProduct"})
public class ManufacturedProductBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private ManufacturedMaterialKindBean manufacturedMaterialKind;
    private ST manufacturerManufacturedProductOrganizationName = new STImpl();
    private TEL manufacturerManufacturedProductOrganizationTelecom = new TELImpl();
    private CE manufacturedMaterialCode = new CEImpl();


    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT490000CA.ManufacturedProduct.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>serial number</p>
     * 
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT290000CA.ManufacturedProduct.id</p>
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
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT490000CA.ManufacturedProduct.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>serial number</p>
     * 
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT290000CA.ManufacturedProduct.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>serial number</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT490000CA.ManufacturedProduct.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT290000CA.ManufacturedProduct.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>(UPC/GTIN/pseudo UPC number manufacturers item/catalogue 
     * number</p>
     */
    @Hl7XmlMapping({"code"})
    public RoleCode getCode() {
        return (RoleCode) this.code.getValue();
    }

    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT490000CA.ManufacturedProduct.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT290000CA.ManufacturedProduct.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>(UPC/GTIN/pseudo UPC number manufacturers item/catalogue 
     * number</p>
     */
    public void setCode(RoleCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
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
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT490000CA.ManufacturedProduct.manufacturedMaterialKind</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setManufacturedMaterialKind(ManufacturedMaterialKindBean manufacturedMaterialKind) {
        this.manufacturedMaterialKind = manufacturedMaterialKind;
    }


    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT490000CA.ManufacturedProductOrganization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Organisation Name</p>
     * 
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT290000CA.ManufacturedProductOrganization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"manufacturerManufacturedProductOrganization/name"})
    public String getManufacturerManufacturedProductOrganizationName() {
        return this.manufacturerManufacturedProductOrganizationName.getValue();
    }

    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT490000CA.ManufacturedProductOrganization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Organisation Name</p>
     * 
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT290000CA.ManufacturedProductOrganization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setManufacturerManufacturedProductOrganizationName(String manufacturerManufacturedProductOrganizationName) {
        this.manufacturerManufacturedProductOrganizationName.setValue(manufacturerManufacturedProductOrganizationName);
    }


    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT490000CA.ManufacturedProductOrganization.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Organisation telephone/email</p>
     * 
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT290000CA.ManufacturedProductOrganization.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"manufacturerManufacturedProductOrganization/telecom"})
    public TelecommunicationAddress getManufacturerManufacturedProductOrganizationTelecom() {
        return this.manufacturerManufacturedProductOrganizationTelecom.getValue();
    }

    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT490000CA.ManufacturedProductOrganization.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Organisation telephone/email</p>
     * 
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT290000CA.ManufacturedProductOrganization.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setManufacturerManufacturedProductOrganizationTelecom(TelecommunicationAddress manufacturerManufacturedProductOrganizationTelecom) {
        this.manufacturerManufacturedProductOrganizationTelecom.setValue(manufacturerManufacturedProductOrganizationTelecom);
    }


    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT290000CA.ManufacturedMaterial.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>DIN/PIN</p>
     */
    @Hl7XmlMapping({"manufacturedMaterial/code"})
    public EntityCode getManufacturedMaterialCode() {
        return (EntityCode) this.manufacturedMaterialCode.getValue();
    }

    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: COCT_MT290000CA.ManufacturedMaterial.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>DIN/PIN</p>
     */
    public void setManufacturedMaterialCode(EntityCode manufacturedMaterialCode) {
        this.manufacturedMaterialCode.setValue(manufacturedMaterialCode);
    }

}
