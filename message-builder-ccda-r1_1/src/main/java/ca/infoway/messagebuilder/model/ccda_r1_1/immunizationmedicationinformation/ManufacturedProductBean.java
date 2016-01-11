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
package ca.infoway.messagebuilder.model.ccda_r1_1.immunizationmedicationinformation;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CE_R2;
import ca.infoway.messagebuilder.datatype.EN;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CE_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.ENImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.datatype.lang.EntityName;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ccda_r1_1.domainvalue.VaccineAdministered;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.Organization_1Bean;
import java.util.List;



@Hl7PartTypeMapping({"ImmunizationMedicationInformation.ManufacturedProduct"})
@Hl7RootType
public class ManufacturedProductBean extends MessagePartBean {

    private static final long serialVersionUID = 20160107L;
    private II typeId = new IIImpl();
    private LIST<II, Identifier> templateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private LIST<II, Identifier> id = new LISTImpl<II, Identifier>(IIImpl.class);
    private II manufacturedMaterialTypeId = new IIImpl();
    private LIST<II, Identifier> manufacturedMaterialTemplateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private CE_R2<VaccineAdministered> manufacturedMaterialCode = new CE_R2Impl<VaccineAdministered>();
    private EN<EntityName> manufacturedMaterialName = new ENImpl<EntityName>();
    private ST manufacturedMaterialLotNumberText = new STImpl();
    private Organization_1Bean manufacturerOrganization;


    /**
     * <p>Relationship: 
     * ImmunizationMedicationInformation.ManufacturedProduct.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeId"})
    public Identifier getTypeId() {
        return this.typeId.getValue();
    }

    /**
     * <p>Relationship: 
     * ImmunizationMedicationInformation.ManufacturedProduct.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Relationship: 
     * ImmunizationMedicationInformation.ManufacturedProduct.templateId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (*)</p>
     */
    @Hl7XmlMapping({"templateId"})
    public List<Identifier> getTemplateId() {
        return this.templateId.rawList();
    }


    /**
     * <p>Relationship: 
     * ImmunizationMedicationInformation.ManufacturedProduct.id</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"id"})
    public List<Identifier> getId() {
        return this.id.rawList();
    }


    /**
     * <p>Relationship: 
     * ImmunizationMedicationInformation.Material.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"manufacturedMaterial/typeId"})
    public Identifier getManufacturedMaterialTypeId() {
        return this.manufacturedMaterialTypeId.getValue();
    }

    /**
     * <p>Relationship: 
     * ImmunizationMedicationInformation.Material.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setManufacturedMaterialTypeId(Identifier manufacturedMaterialTypeId) {
        this.manufacturedMaterialTypeId.setValue(manufacturedMaterialTypeId);
    }


    /**
     * <p>Relationship: 
     * ImmunizationMedicationInformation.Material.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"manufacturedMaterial/templateId"})
    public List<Identifier> getManufacturedMaterialTemplateId() {
        return this.manufacturedMaterialTemplateId.rawList();
    }


    /**
     * <p>Relationship: 
     * ImmunizationMedicationInformation.Material.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"manufacturedMaterial/code"})
    public CodedTypeR2<VaccineAdministered> getManufacturedMaterialCode() {
        return (CodedTypeR2<VaccineAdministered>) this.manufacturedMaterialCode.getValue();
    }

    /**
     * <p>Relationship: 
     * ImmunizationMedicationInformation.Material.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setManufacturedMaterialCode(CodedTypeR2<VaccineAdministered> manufacturedMaterialCode) {
        this.manufacturedMaterialCode.setValue(manufacturedMaterialCode);
    }


    /**
     * <p>Relationship: 
     * ImmunizationMedicationInformation.Material.name</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"manufacturedMaterial/name"})
    public EntityName getManufacturedMaterialName() {
        return this.manufacturedMaterialName.getValue();
    }

    /**
     * <p>Relationship: 
     * ImmunizationMedicationInformation.Material.name</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setManufacturedMaterialName(EntityName manufacturedMaterialName) {
        this.manufacturedMaterialName.setValue(manufacturedMaterialName);
    }


    /**
     * <p>Relationship: 
     * ImmunizationMedicationInformation.Material.lotNumberText</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"manufacturedMaterial/lotNumberText"})
    public String getManufacturedMaterialLotNumberText() {
        return this.manufacturedMaterialLotNumberText.getValue();
    }

    /**
     * <p>Relationship: 
     * ImmunizationMedicationInformation.Material.lotNumberText</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setManufacturedMaterialLotNumberText(String manufacturedMaterialLotNumberText) {
        this.manufacturedMaterialLotNumberText.setValue(manufacturedMaterialLotNumberText);
    }


    /**
     * <p>Relationship: 
     * ImmunizationMedicationInformation.ManufacturedProduct.manufacturerOrganization</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"manufacturerOrganization"})
    public Organization_1Bean getManufacturerOrganization() {
        return this.manufacturerOrganization;
    }

    /**
     * <p>Relationship: 
     * ImmunizationMedicationInformation.ManufacturedProduct.manufacturerOrganization</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setManufacturerOrganization(Organization_1Bean manufacturerOrganization) {
        this.manufacturerOrganization = manufacturerOrganization;
    }

}
