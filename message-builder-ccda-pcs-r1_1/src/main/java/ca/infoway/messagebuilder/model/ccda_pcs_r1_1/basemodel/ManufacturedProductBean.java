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
package ca.infoway.messagebuilder.model.ccda_pcs_r1_1.basemodel;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ccda_pcs_r1_1.merged.Organization_1Bean;
import java.util.List;



@Hl7PartTypeMapping({"BaseModel.ManufacturedProduct"})
public class ManufacturedProductBean extends MessagePartBean {

    private static final long serialVersionUID = 20160107L;
    private II typeId = new IIImpl();
    private LIST<II, Identifier> templateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private LIST<II, Identifier> id = new LISTImpl<II, Identifier>(IIImpl.class);
    private ManufacturedProductChoice manufacturedProductChoice;
    private Organization_1Bean manufacturerOrganization;


    /**
     * <p>Relationship: BaseModel.ManufacturedProduct.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeId"})
    public Identifier getTypeId() {
        return this.typeId.getValue();
    }

    /**
     * <p>Relationship: BaseModel.ManufacturedProduct.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Relationship: BaseModel.ManufacturedProduct.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"templateId"})
    public List<Identifier> getTemplateId() {
        return this.templateId.rawList();
    }


    /**
     * <p>Relationship: BaseModel.ManufacturedProduct.id</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"id"})
    public List<Identifier> getId() {
        return this.id.rawList();
    }


    /**
     * <p>Relationship: 
     * BaseModel.ManufacturedProduct.manufacturedProductChoice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"manufacturedProductChoice"})
    public ManufacturedProductChoice getManufacturedProductChoice() {
        return this.manufacturedProductChoice;
    }

    /**
     * <p>Relationship: 
     * BaseModel.ManufacturedProduct.manufacturedProductChoice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setManufacturedProductChoice(ManufacturedProductChoice manufacturedProductChoice) {
        this.manufacturedProductChoice = manufacturedProductChoice;
    }

    public LabeledDrugBean getManufacturedProductChoiceAsManufacturedLabeledDrug() {
        return this.manufacturedProductChoice instanceof LabeledDrugBean ? (LabeledDrugBean) this.manufacturedProductChoice : null;
    }
    public boolean hasManufacturedProductChoiceAsManufacturedLabeledDrug() {
        return (this.manufacturedProductChoice instanceof LabeledDrugBean);
    }

    public MaterialBean getManufacturedProductChoiceAsManufacturedMaterial() {
        return this.manufacturedProductChoice instanceof MaterialBean ? (MaterialBean) this.manufacturedProductChoice : null;
    }
    public boolean hasManufacturedProductChoiceAsManufacturedMaterial() {
        return (this.manufacturedProductChoice instanceof MaterialBean);
    }


    /**
     * <p>Relationship: 
     * BaseModel.ManufacturedProduct.manufacturerOrganization</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"manufacturerOrganization"})
    public Organization_1Bean getManufacturerOrganization() {
        return this.manufacturerOrganization;
    }

    /**
     * <p>Relationship: 
     * BaseModel.ManufacturedProduct.manufacturerOrganization</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setManufacturerOrganization(Organization_1Bean manufacturerOrganization) {
        this.manufacturerOrganization = manufacturerOrganization;
    }

}
