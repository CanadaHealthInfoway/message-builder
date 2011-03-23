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



/**
 * <p>Manufactured Product</p>
 * 
 * <p>Playing Role of Manufactured Product</p>
 * 
 * <p>Scoped by Manufacturer</p>
 * 
 * <p>Must have Organization if you don'''t have UPC/GTIN or 
 * pseudo UPC</p>
 */
@Hl7PartTypeMapping({"COCT_MT490000CA.ManufacturedProduct"})
public class ManufacturedProductBean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private II productID = new IIImpl();
    private CV productCode = new CVImpl();
    private ManufacturedMaterialKindBean manufacturedMaterialKind;
    private ST organisationName = new STImpl();
    private TEL organisationTelephoneEmail = new TELImpl();

    @Hl7XmlMapping({"id"})
    public Identifier getProductID() {
        return this.productID.getValue();
    }
    public void setProductID(Identifier productID) {
        this.productID.setValue(productID);
    }

    @Hl7XmlMapping({"code"})
    public Code getProductCode() {
        return (Code) this.productCode.getValue();
    }
    public void setProductCode(Code productCode) {
        this.productCode.setValue(productCode);
    }

    @Hl7XmlMapping({"manufacturedMaterialKind"})
    public ManufacturedMaterialKindBean getManufacturedMaterialKind() {
        return this.manufacturedMaterialKind;
    }
    public void setManufacturedMaterialKind(ManufacturedMaterialKindBean manufacturedMaterialKind) {
        this.manufacturedMaterialKind = manufacturedMaterialKind;
    }

    @Hl7XmlMapping({"manufacturerManufacturedProductOrganization/name"})
    public String getOrganisationName() {
        return this.organisationName.getValue();
    }
    public void setOrganisationName(String organisationName) {
        this.organisationName.setValue(organisationName);
    }

    @Hl7XmlMapping({"manufacturerManufacturedProductOrganization/telecom"})
    public TelecommunicationAddress getOrganisationTelephoneEmail() {
        return this.organisationTelephoneEmail.getValue();
    }
    public void setOrganisationTelephoneEmail(TelecommunicationAddress organisationTelephoneEmail) {
        this.organisationTelephoneEmail.setValue(organisationTelephoneEmail);
    }

}
