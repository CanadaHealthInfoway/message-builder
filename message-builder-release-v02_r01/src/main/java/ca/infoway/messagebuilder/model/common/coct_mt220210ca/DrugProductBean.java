/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.coct_mt220210ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ClinicalDrug;
import ca.infoway.messagebuilder.domainvalue.OrderableDrugForm;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt270010ca.MedicationBean;
import ca.infoway.messagebuilder.model.merged.DrugContainsBean;
import ca.infoway.messagebuilder.model.merged.DrugDispensedInBean;
import ca.infoway.messagebuilder.model.merged.ManufacturedByBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Drug Product</p>
 * 
 * <p>A pharmaceutical product to be supplied and/or 
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
@Hl7PartTypeMapping({"COCT_MT220210CA.Medication"})
@Hl7RootType
public class DrugProductBean extends MessagePartBean implements MedicationBean {

    private static final long serialVersionUID = 20100615L;
    private CV drugCode = new CVImpl();
    private ST drugName = new STImpl();
    private ST drugDescription = new STImpl();
    private CV drugForm = new CVImpl();
    private ST drugLotNumber = new STImpl();
    private IVL<TS, Interval<Date>> drugExpiryDate = new IVLImpl<TS, Interval<Date>>();
    private DrugDispensedInBean administerableMedicineAsContent;
    private List<DrugContainsBean> administerableMedicineIngredient = new ArrayList<DrugContainsBean>();
    private ManufacturedByBean administerableMedicineAsManufacturedProduct;

    @Hl7XmlMapping({"administerableMedicine/code"})
    public ClinicalDrug getDrugCode() {
        return (ClinicalDrug) this.drugCode.getValue();
    }
    public void setDrugCode(ClinicalDrug drugCode) {
        this.drugCode.setValue(drugCode);
    }

    @Hl7XmlMapping({"administerableMedicine/name"})
    public String getDrugName() {
        return this.drugName.getValue();
    }
    public void setDrugName(String drugName) {
        this.drugName.setValue(drugName);
    }

    @Hl7XmlMapping({"administerableMedicine/desc"})
    public String getDrugDescription() {
        return this.drugDescription.getValue();
    }
    public void setDrugDescription(String drugDescription) {
        this.drugDescription.setValue(drugDescription);
    }

    @Hl7XmlMapping({"administerableMedicine/formCode"})
    public OrderableDrugForm getDrugForm() {
        return (OrderableDrugForm) this.drugForm.getValue();
    }
    public void setDrugForm(OrderableDrugForm drugForm) {
        this.drugForm.setValue(drugForm);
    }

    @Hl7XmlMapping({"administerableMedicine/lotNumberText"})
    public String getDrugLotNumber() {
        return this.drugLotNumber.getValue();
    }
    public void setDrugLotNumber(String drugLotNumber) {
        this.drugLotNumber.setValue(drugLotNumber);
    }

    @Hl7XmlMapping({"administerableMedicine/expirationTime"})
    public Interval<Date> getDrugExpiryDate() {
        return this.drugExpiryDate.getValue();
    }
    public void setDrugExpiryDate(Interval<Date> drugExpiryDate) {
        this.drugExpiryDate.setValue(drugExpiryDate);
    }

    @Hl7XmlMapping({"administerableMedicine/asContent"})
    public DrugDispensedInBean getAdministerableMedicineAsContent() {
        return this.administerableMedicineAsContent;
    }
    public void setAdministerableMedicineAsContent(DrugDispensedInBean administerableMedicineAsContent) {
        this.administerableMedicineAsContent = administerableMedicineAsContent;
    }

    @Hl7XmlMapping({"administerableMedicine/ingredient"})
    public List<DrugContainsBean> getAdministerableMedicineIngredient() {
        return this.administerableMedicineIngredient;
    }

    @Hl7XmlMapping({"administerableMedicine/asManufacturedProduct"})
    public ManufacturedByBean getAdministerableMedicineAsManufacturedProduct() {
        return this.administerableMedicineAsManufacturedProduct;
    }
    public void setAdministerableMedicineAsManufacturedProduct(ManufacturedByBean administerableMedicineAsManufacturedProduct) {
        this.administerableMedicineAsManufacturedProduct = administerableMedicineAsManufacturedProduct;
    }

}
