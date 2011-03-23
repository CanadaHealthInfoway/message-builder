/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.coct_mt220100ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ClinicalDrug;
import ca.infoway.messagebuilder.domainvalue.OrderableDrugForm;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.merged.DispensedInBean;
import ca.infoway.messagebuilder.model.merged.DrugContainsBean;
import ca.infoway.messagebuilder.model.merged.ManufacturedByBean;
import ca.infoway.messagebuilder.model.pharmacy.porx_mt980040ca.MedicationBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Drug Product</p>
 * 
 * <p>A pharmaceutical product intended to be supplied and/or 
 * administered to a patient. Encompasses manufactured drug 
 * products, generic classifications, prescription medications, 
 * over-the-counter medications and recreational drugs.</p>
 * 
 * <p>Allows drugs to be clearly described and referenced. Also 
 * allows searching for and examining information about 
 * medications that can be or are being used by a patient.</p>
 * 
 * <p>A_BillablePharmacyDispense</p>
 */
@Hl7PartTypeMapping({"COCT_MT220100CA.Medication"})
@Hl7RootType
public class DrugProductBean extends MessagePartBean implements MedicationBean {

    private static final long serialVersionUID = 20100614L;
    private CD drugCode = new CDImpl();
    private ST drugName = new STImpl();
    private ST drugDescription = new STImpl();
    private CV drugForm = new CVImpl();
    private DispensedInBean playerAsContent;
    private List<DrugContainsBean> playerIngredient = new ArrayList<DrugContainsBean>();
    private ManufacturedByBean playerAsManufacturedProduct;

    @Hl7XmlMapping({"player/code"})
    public ClinicalDrug getDrugCode() {
        return (ClinicalDrug) this.drugCode.getValue();
    }
    public void setDrugCode(ClinicalDrug drugCode) {
        this.drugCode.setValue(drugCode);
    }

    @Hl7XmlMapping({"player/name"})
    public String getDrugName() {
        return this.drugName.getValue();
    }
    public void setDrugName(String drugName) {
        this.drugName.setValue(drugName);
    }

    @Hl7XmlMapping({"player/desc"})
    public String getDrugDescription() {
        return this.drugDescription.getValue();
    }
    public void setDrugDescription(String drugDescription) {
        this.drugDescription.setValue(drugDescription);
    }

    @Hl7XmlMapping({"player/formCode"})
    public OrderableDrugForm getDrugForm() {
        return (OrderableDrugForm) this.drugForm.getValue();
    }
    public void setDrugForm(OrderableDrugForm drugForm) {
        this.drugForm.setValue(drugForm);
    }

    @Hl7XmlMapping({"player/asContent"})
    public DispensedInBean getPlayerAsContent() {
        return this.playerAsContent;
    }
    public void setPlayerAsContent(DispensedInBean playerAsContent) {
        this.playerAsContent = playerAsContent;
    }

    @Hl7XmlMapping({"player/ingredient"})
    public List<DrugContainsBean> getPlayerIngredient() {
        return this.playerIngredient;
    }

    @Hl7XmlMapping({"player/asManufacturedProduct"})
    public ManufacturedByBean getPlayerAsManufacturedProduct() {
        return this.playerAsManufacturedProduct;
    }
    public void setPlayerAsManufacturedProduct(ManufacturedByBean playerAsManufacturedProduct) {
        this.playerAsManufacturedProduct = playerAsManufacturedProduct;
    }

}
