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
package ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03_imm.common.coct_mt490000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03_imm.domainvalue.MaterialEntityClassType;
import java.util.Date;



/**
 * <p>Business Name: Manufactured Material Kind</p>
 * 
 * <p>Type of Product</p>
 */
@Hl7PartTypeMapping({"COCT_MT490000CA.ManufacturedMaterialKind"})
public class ManufacturedMaterialKindBean extends MessagePartBean {

    private static final long serialVersionUID = 20150902L;
    private CV code = new CVImpl();
    private ST desc = new STImpl();
    private IVL<TS, Interval<Date>> asWarrantorEffectiveTime = new IVLImpl<TS, Interval<Date>>();
    private ST asWarrantorWarrantingWarrantorOrganizationName = new STImpl();
    private TEL asWarrantorWarrantingWarrantorOrganizationTelecom = new TELImpl();
    private PQ contentPackagedProductQuantity = new PQImpl();
    private ManufacturedMaterialKindBean contentPackagedProductContainedManufacturedMaterialKind;


    /**
     * <p>Business Name: Manufactured material code</p>
     * 
     * <p>Relationship: 
     * COCT_MT490000CA.ManufacturedMaterialKind.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Code for manufactured material</p>
     */
    @Hl7XmlMapping({"code"})
    public MaterialEntityClassType getCode() {
        return (MaterialEntityClassType) this.code.getValue();
    }

    /**
     * <p>Business Name: Manufactured material code</p>
     * 
     * <p>Relationship: 
     * COCT_MT490000CA.ManufacturedMaterialKind.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Code for manufactured material</p>
     */
    public void setCode(MaterialEntityClassType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Package description</p>
     * 
     * <p>Relationship: 
     * COCT_MT490000CA.ManufacturedMaterialKind.desc</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>box, blister pack, compliance packaging, etc. HC-PCS?</p>
     */
    @Hl7XmlMapping({"desc"})
    public String getDesc() {
        return this.desc.getValue();
    }

    /**
     * <p>Business Name: Package description</p>
     * 
     * <p>Relationship: 
     * COCT_MT490000CA.ManufacturedMaterialKind.desc</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>box, blister pack, compliance packaging, etc. HC-PCS?</p>
     */
    public void setDesc(String desc) {
        this.desc.setValue(desc);
    }


    /**
     * <p>Business Name: Time of warranty</p>
     * 
     * <p>Relationship: COCT_MT490000CA.Warrantor.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>time of warranty</p>
     */
    @Hl7XmlMapping({"asWarrantor/effectiveTime"})
    public Interval<Date> getAsWarrantorEffectiveTime() {
        return this.asWarrantorEffectiveTime.getValue();
    }

    /**
     * <p>Business Name: Time of warranty</p>
     * 
     * <p>Relationship: COCT_MT490000CA.Warrantor.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>time of warranty</p>
     */
    public void setAsWarrantorEffectiveTime(Interval<Date> asWarrantorEffectiveTime) {
        this.asWarrantorEffectiveTime.setValue(asWarrantorEffectiveTime);
    }


    /**
     * <p>Business Name: Warrantor Organisation Name</p>
     * 
     * <p>Relationship: COCT_MT490000CA.WarrantorOrganization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>name of Organization that holds warranty</p>
     */
    @Hl7XmlMapping({"asWarrantor/warrantingWarrantorOrganization/name"})
    public String getAsWarrantorWarrantingWarrantorOrganizationName() {
        return this.asWarrantorWarrantingWarrantorOrganizationName.getValue();
    }

    /**
     * <p>Business Name: Warrantor Organisation Name</p>
     * 
     * <p>Relationship: COCT_MT490000CA.WarrantorOrganization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>name of Organization that holds warranty</p>
     */
    public void setAsWarrantorWarrantingWarrantorOrganizationName(String asWarrantorWarrantingWarrantorOrganizationName) {
        this.asWarrantorWarrantingWarrantorOrganizationName.setValue(asWarrantorWarrantingWarrantorOrganizationName);
    }


    /**
     * <p>Business Name: Warrantor Organisation telecom</p>
     * 
     * <p>Relationship: 
     * COCT_MT490000CA.WarrantorOrganization.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Warrantor Organization telephone number</p>
     */
    @Hl7XmlMapping({"asWarrantor/warrantingWarrantorOrganization/telecom"})
    public TelecommunicationAddress getAsWarrantorWarrantingWarrantorOrganizationTelecom() {
        return this.asWarrantorWarrantingWarrantorOrganizationTelecom.getValue();
    }

    /**
     * <p>Business Name: Warrantor Organisation telecom</p>
     * 
     * <p>Relationship: 
     * COCT_MT490000CA.WarrantorOrganization.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Warrantor Organization telephone number</p>
     */
    public void setAsWarrantorWarrantingWarrantorOrganizationTelecom(TelecommunicationAddress asWarrantorWarrantingWarrantorOrganizationTelecom) {
        this.asWarrantorWarrantingWarrantorOrganizationTelecom.setValue(asWarrantorWarrantingWarrantorOrganizationTelecom);
    }


    /**
     * <p>Business Name: Package Quantity</p>
     * 
     * <p>Relationship: 
     * COCT_MT490000CA.ContentPackagedProduct.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>number of items in the package</p>
     */
    @Hl7XmlMapping({"contentPackagedProduct/quantity"})
    public PhysicalQuantity getContentPackagedProductQuantity() {
        return this.contentPackagedProductQuantity.getValue();
    }

    /**
     * <p>Business Name: Package Quantity</p>
     * 
     * <p>Relationship: 
     * COCT_MT490000CA.ContentPackagedProduct.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>number of items in the package</p>
     */
    public void setContentPackagedProductQuantity(PhysicalQuantity contentPackagedProductQuantity) {
        this.contentPackagedProductQuantity.setValue(contentPackagedProductQuantity);
    }


    /**
     * <p>Relationship: 
     * COCT_MT490000CA.ContentPackagedProduct.containedManufacturedMaterialKind</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"contentPackagedProduct/containedManufacturedMaterialKind"})
    public ManufacturedMaterialKindBean getContentPackagedProductContainedManufacturedMaterialKind() {
        return this.contentPackagedProductContainedManufacturedMaterialKind;
    }

    /**
     * <p>Relationship: 
     * COCT_MT490000CA.ContentPackagedProduct.containedManufacturedMaterialKind</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setContentPackagedProductContainedManufacturedMaterialKind(ManufacturedMaterialKindBean contentPackagedProductContainedManufacturedMaterialKind) {
        this.contentPackagedProductContainedManufacturedMaterialKind = contentPackagedProductContainedManufacturedMaterialKind;
    }

}
