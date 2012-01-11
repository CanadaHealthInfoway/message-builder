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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.claims.coct_mt490000ca;

import ca.infoway.messagebuilder.Code;
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
import java.util.Date;



@Hl7PartTypeMapping({"COCT_MT490000CA.ManufacturedMaterialKind"})
public class ManufacturedMaterialKindBean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
    private CV code = new CVImpl();
    private ST desc = new STImpl();
    private IVL<TS, Interval<Date>> asWarrantorEffectiveTime = new IVLImpl<TS, Interval<Date>>();
    private ST asWarrantorWarrantingWarrantorOrganizationName = new STImpl();
    private TEL asWarrantorWarrantingWarrantorOrganizationTelecom = new TELImpl();
    private PQ contentPackagedProductQuantity = new PQImpl();
    private ManufacturedMaterialKindBean contentPackagedProductContainedManufacturedMaterialKind;


    @Hl7XmlMapping({"code"})
    public Code getCode() {
        return (Code) this.code.getValue();
    }
    public void setCode(Code code) {
        this.code.setValue(code);
    }


    @Hl7XmlMapping({"desc"})
    public String getDesc() {
        return this.desc.getValue();
    }
    public void setDesc(String desc) {
        this.desc.setValue(desc);
    }


    @Hl7XmlMapping({"asWarrantor/effectiveTime"})
    public Interval<Date> getAsWarrantorEffectiveTime() {
        return this.asWarrantorEffectiveTime.getValue();
    }
    public void setAsWarrantorEffectiveTime(Interval<Date> asWarrantorEffectiveTime) {
        this.asWarrantorEffectiveTime.setValue(asWarrantorEffectiveTime);
    }


    @Hl7XmlMapping({"asWarrantor/warrantingWarrantorOrganization/name"})
    public String getAsWarrantorWarrantingWarrantorOrganizationName() {
        return this.asWarrantorWarrantingWarrantorOrganizationName.getValue();
    }
    public void setAsWarrantorWarrantingWarrantorOrganizationName(String asWarrantorWarrantingWarrantorOrganizationName) {
        this.asWarrantorWarrantingWarrantorOrganizationName.setValue(asWarrantorWarrantingWarrantorOrganizationName);
    }


    @Hl7XmlMapping({"asWarrantor/warrantingWarrantorOrganization/telecom"})
    public TelecommunicationAddress getAsWarrantorWarrantingWarrantorOrganizationTelecom() {
        return this.asWarrantorWarrantingWarrantorOrganizationTelecom.getValue();
    }
    public void setAsWarrantorWarrantingWarrantorOrganizationTelecom(TelecommunicationAddress asWarrantorWarrantingWarrantorOrganizationTelecom) {
        this.asWarrantorWarrantingWarrantorOrganizationTelecom.setValue(asWarrantorWarrantingWarrantorOrganizationTelecom);
    }


    @Hl7XmlMapping({"contentPackagedProduct/quantity"})
    public PhysicalQuantity getContentPackagedProductQuantity() {
        return this.contentPackagedProductQuantity.getValue();
    }
    public void setContentPackagedProductQuantity(PhysicalQuantity contentPackagedProductQuantity) {
        this.contentPackagedProductQuantity.setValue(contentPackagedProductQuantity);
    }


    @Hl7XmlMapping({"contentPackagedProduct/containedManufacturedMaterialKind"})
    public ManufacturedMaterialKindBean getContentPackagedProductContainedManufacturedMaterialKind() {
        return this.contentPackagedProductContainedManufacturedMaterialKind;
    }
    public void setContentPackagedProductContainedManufacturedMaterialKind(ManufacturedMaterialKindBean contentPackagedProductContainedManufacturedMaterialKind) {
        this.contentPackagedProductContainedManufacturedMaterialKind = contentPackagedProductContainedManufacturedMaterialKind;
    }

}
