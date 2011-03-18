/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.claims.merged;

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
import ca.infoway.messagebuilder.model.v02_r01.claims.coct_mt490000ca.ManufacturedMaterialKindBean;



@Hl7PartTypeMapping({"COCT_MT290000CA.ManufacturedProduct","COCT_MT490000CA.ManufacturedProduct"})
public class ManufacturedProductBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private ManufacturedMaterialKindBean manufacturedMaterialKind;
    private ST manufacturerManufacturedProductOrganizationName = new STImpl();
    private TEL manufacturerManufacturedProductOrganizationTelecom = new TELImpl();
    private CE manufacturedMaterialCode = new CEImpl();


    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    @Hl7XmlMapping({"code"})
    public RoleCode getCode() {
        return (RoleCode) this.code.getValue();
    }
    public void setCode(RoleCode code) {
        this.code.setValue(code);
    }


    @Hl7XmlMapping({"manufacturedMaterialKind"})
    public ManufacturedMaterialKindBean getManufacturedMaterialKind() {
        return this.manufacturedMaterialKind;
    }
    public void setManufacturedMaterialKind(ManufacturedMaterialKindBean manufacturedMaterialKind) {
        this.manufacturedMaterialKind = manufacturedMaterialKind;
    }


    @Hl7XmlMapping({"manufacturerManufacturedProductOrganization/name"})
    public String getManufacturerManufacturedProductOrganizationName() {
        return this.manufacturerManufacturedProductOrganizationName.getValue();
    }
    public void setManufacturerManufacturedProductOrganizationName(String manufacturerManufacturedProductOrganizationName) {
        this.manufacturerManufacturedProductOrganizationName.setValue(manufacturerManufacturedProductOrganizationName);
    }


    @Hl7XmlMapping({"manufacturerManufacturedProductOrganization/telecom"})
    public TelecommunicationAddress getManufacturerManufacturedProductOrganizationTelecom() {
        return this.manufacturerManufacturedProductOrganizationTelecom.getValue();
    }
    public void setManufacturerManufacturedProductOrganizationTelecom(TelecommunicationAddress manufacturerManufacturedProductOrganizationTelecom) {
        this.manufacturerManufacturedProductOrganizationTelecom.setValue(manufacturerManufacturedProductOrganizationTelecom);
    }


    @Hl7XmlMapping({"manufacturedMaterial/code"})
    public EntityCode getManufacturedMaterialCode() {
        return (EntityCode) this.manufacturedMaterialCode.getValue();
    }
    public void setManufacturedMaterialCode(EntityCode manufacturedMaterialCode) {
        this.manufacturedMaterialCode.setValue(manufacturedMaterialCode);
    }

}
