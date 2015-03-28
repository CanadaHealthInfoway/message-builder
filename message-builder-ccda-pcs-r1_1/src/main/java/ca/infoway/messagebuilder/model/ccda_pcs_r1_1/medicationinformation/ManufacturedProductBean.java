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
package ca.infoway.messagebuilder.model.ccda_pcs_r1_1.medicationinformation;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CE;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.EN;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CEImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.ENImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.EntityName;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ccda_pcs_r1_1.domainvalue.MedicationClinicalDrugName;
import ca.infoway.messagebuilder.model.ccda_pcs_r1_1.merged.Organization_1Bean;
import java.util.List;



@Hl7PartTypeMapping({"MedicationInformation.ManufacturedProduct"})
@Hl7RootType
public class ManufacturedProductBean extends MessagePartBean {

    private static final long serialVersionUID = 20150328L;
    private LIST<CS, Code> realmCode = new LISTImpl<CS, Code>(CSImpl.class);
    private II typeId = new IIImpl();
    private LIST<II, Identifier> templateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private LIST<II, Identifier> id = new LISTImpl<II, Identifier>(IIImpl.class);
    private LIST<CS, Code> manufacturedMaterialRealmCode = new LISTImpl<CS, Code>(CSImpl.class);
    private II manufacturedMaterialTypeId = new IIImpl();
    private LIST<II, Identifier> manufacturedMaterialTemplateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private CE manufacturedMaterialCode = new CEImpl();
    private EN<EntityName> manufacturedMaterialName = new ENImpl<EntityName>();
    private ST manufacturedMaterialLotNumberText = new STImpl();
    private Organization_1Bean manufacturerOrganization;


    /**
     * <p>Relationship: 
     * MedicationInformation.ManufacturedProduct.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"realmCode"})
    public List<Code> getRealmCode() {
        return this.realmCode.rawList(Code.class);
    }


    /**
     * <p>Relationship: 
     * MedicationInformation.ManufacturedProduct.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeId"})
    public Identifier getTypeId() {
        return this.typeId.getValue();
    }

    /**
     * <p>Relationship: 
     * MedicationInformation.ManufacturedProduct.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Relationship: 
     * MedicationInformation.ManufacturedProduct.templateId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (*)</p>
     */
    @Hl7XmlMapping({"templateId"})
    public List<Identifier> getTemplateId() {
        return this.templateId.rawList();
    }


    /**
     * <p>Relationship: 
     * MedicationInformation.ManufacturedProduct.id</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"id"})
    public List<Identifier> getId() {
        return this.id.rawList();
    }


    /**
     * <p>Relationship: MedicationInformation.Material.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"manufacturedMaterial/realmCode"})
    public List<Code> getManufacturedMaterialRealmCode() {
        return this.manufacturedMaterialRealmCode.rawList(Code.class);
    }


    /**
     * <p>Relationship: MedicationInformation.Material.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"manufacturedMaterial/typeId"})
    public Identifier getManufacturedMaterialTypeId() {
        return this.manufacturedMaterialTypeId.getValue();
    }

    /**
     * <p>Relationship: MedicationInformation.Material.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setManufacturedMaterialTypeId(Identifier manufacturedMaterialTypeId) {
        this.manufacturedMaterialTypeId.setValue(manufacturedMaterialTypeId);
    }


    /**
     * <p>Relationship: MedicationInformation.Material.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"manufacturedMaterial/templateId"})
    public List<Identifier> getManufacturedMaterialTemplateId() {
        return this.manufacturedMaterialTemplateId.rawList();
    }


    /**
     * <p>Relationship: MedicationInformation.Material.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"manufacturedMaterial/code"})
    public MedicationClinicalDrugName getManufacturedMaterialCode() {
        return (MedicationClinicalDrugName) this.manufacturedMaterialCode.getValue();
    }

    /**
     * <p>Relationship: MedicationInformation.Material.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setManufacturedMaterialCode(MedicationClinicalDrugName manufacturedMaterialCode) {
        this.manufacturedMaterialCode.setValue(manufacturedMaterialCode);
    }


    /**
     * <p>Relationship: MedicationInformation.Material.name</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"manufacturedMaterial/name"})
    public EntityName getManufacturedMaterialName() {
        return this.manufacturedMaterialName.getValue();
    }

    /**
     * <p>Relationship: MedicationInformation.Material.name</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setManufacturedMaterialName(EntityName manufacturedMaterialName) {
        this.manufacturedMaterialName.setValue(manufacturedMaterialName);
    }


    /**
     * <p>Relationship: 
     * MedicationInformation.Material.lotNumberText</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"manufacturedMaterial/lotNumberText"})
    public String getManufacturedMaterialLotNumberText() {
        return this.manufacturedMaterialLotNumberText.getValue();
    }

    /**
     * <p>Relationship: 
     * MedicationInformation.Material.lotNumberText</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setManufacturedMaterialLotNumberText(String manufacturedMaterialLotNumberText) {
        this.manufacturedMaterialLotNumberText.setValue(manufacturedMaterialLotNumberText);
    }


    /**
     * <p>Relationship: 
     * MedicationInformation.ManufacturedProduct.manufacturerOrganization</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"manufacturerOrganization"})
    public Organization_1Bean getManufacturerOrganization() {
        return this.manufacturerOrganization;
    }

    /**
     * <p>Relationship: 
     * MedicationInformation.ManufacturedProduct.manufacturerOrganization</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setManufacturerOrganization(Organization_1Bean manufacturerOrganization) {
        this.manufacturerOrganization = manufacturerOrganization;
    }

}
