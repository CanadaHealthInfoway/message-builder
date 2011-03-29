/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.common.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.EntityCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt490000ca.ManufacturedMaterialKindBean;



/**
 * <p>ManufacturedProduct</p>
 * 
 * <p>COCT_MT490000CA.ManufacturedProduct: Manufactured Product</p>
 * 
 * <p><p>Must have Organization if you don'''t have UPC/GTIN or 
 * pseudo UPC</p></p>
 * 
 * <p><p>Playing Role of Manufactured Product</p></p>
 * 
 * <p><p>Scoped by Manufacturer</p></p>
 * 
 * <p>COCT_MT290000CA.ManufacturedProduct: Manufactured Product</p>
 * 
 * <p><p>Must have Role.cd or ManufacturedMaterial.cd</p></p>
 * 
 * <p><p>Pertinent info about manufactured Product</p></p>
 * 
 * <p><p>Scoped by Manufacturer</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT290000CA.ManufacturedProduct","COCT_MT490000CA.ManufacturedProduct"})
public class ManufacturedProductBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private CV code = new CVImpl();
    private TEL manufacturerManufacturedProductOrganizationTelecom = new TELImpl();
    private ST manufacturerManufacturedProductOrganizationName = new STImpl();
    private ManufacturedMaterialKindBean manufacturedMaterialKind;
    private II id = new IIImpl();
    private CD productNumber = new CDImpl();


    /**
     * <p>Manufactured Product Code</p>
     * 
     * <p><p>(UPC/GTIN/pseudo UPC number manufacturer'''s 
     * item/catalogue number</p></p>
     * 
     * <p>Product Code</p>
     * 
     * <p><p>code denoting product type</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getCode() {
        return (Code) this.code.getValue();
    }
    public void setCode(Code code) {
        this.code.setValue(code);
    }


    /**
     * <p>Manufacturer Telecom</p>
     * 
     * <p><p>Telephone no. for manufacturer</p></p>
     * 
     * <p>Organisation telephone/email</p>
     * 
     * <p><p>Organisation telephone/email</p></p>
     */
    @Hl7XmlMapping({"manufacturerManufacturedProductOrganization/telecom"})
    public TelecommunicationAddress getManufacturerManufacturedProductOrganizationTelecom() {
        return this.manufacturerManufacturedProductOrganizationTelecom.getValue();
    }
    public void setManufacturerManufacturedProductOrganizationTelecom(TelecommunicationAddress manufacturerManufacturedProductOrganizationTelecom) {
        this.manufacturerManufacturedProductOrganizationTelecom.setValue(manufacturerManufacturedProductOrganizationTelecom);
    }


    /**
     * <p>Manufacturer Name</p>
     * 
     * <p><p>Name of manufacturer.</p></p>
     * 
     * <p>Organisation Name</p>
     * 
     * <p><p>Manufacturer Name</p></p>
     */
    @Hl7XmlMapping({"manufacturerManufacturedProductOrganization/name"})
    public String getManufacturerManufacturedProductOrganizationName() {
        return this.manufacturerManufacturedProductOrganizationName.getValue();
    }
    public void setManufacturerManufacturedProductOrganizationName(String manufacturerManufacturedProductOrganizationName) {
        this.manufacturerManufacturedProductOrganizationName.setValue(manufacturerManufacturedProductOrganizationName);
    }


    @Hl7XmlMapping({"manufacturedMaterialKind"})
    public ManufacturedMaterialKindBean getManufacturedMaterialKind() {
        return this.manufacturedMaterialKind;
    }
    public void setManufacturedMaterialKind(ManufacturedMaterialKindBean manufacturedMaterialKind) {
        this.manufacturedMaterialKind = manufacturedMaterialKind;
    }


    /**
     * <p>Product Number</p>
     * 
     * <p><p>serial number</p></p>
     * 
     * <p>Product ID</p>
     * 
     * <p><p>serial number</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>ProductNumber</p>
     * 
     * <p>Product Number</p>
     * 
     * <p><p>Code for manufactured material eg. DIN/PIN</p></p>
     */
    @Hl7XmlMapping({"manufacturedMaterial/code"})
    public EntityCode getProductNumber() {
        return (EntityCode) this.productNumber.getValue();
    }
    public void setProductNumber(EntityCode productNumber) {
        this.productNumber.setValue(productNumber);
    }

}