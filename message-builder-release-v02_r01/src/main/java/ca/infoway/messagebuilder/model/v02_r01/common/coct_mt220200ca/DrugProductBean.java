/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.common.coct_mt220200ca;

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
import ca.infoway.messagebuilder.domainvalue.ManufacturedDrug;
import ca.infoway.messagebuilder.domainvalue.OrderableDrugForm;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.v02_r01.merged.DrugContainsBean;
import ca.infoway.messagebuilder.model.v02_r01.merged.DrugDispensedInBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"COCT_MT220200CA.Medication"})
@Hl7RootType
public class DrugProductBean extends MessagePartBean implements ca.infoway.messagebuilder.model.v02_r01.common.coct_mt270010ca.Medication {

    private static final long serialVersionUID = 20110318L;
    private ST drugDescription = new STImpl();
    private ST drugLotNumber = new STImpl();
    private CV drugCode = new CVImpl();
    private ST drugName = new STImpl();
    private IVL<TS, Interval<Date>> drugExpiryDate = new IVLImpl<TS, Interval<Date>>();
    private DrugDispensedInBean administerableMedicineAsContent;
    private CV drugForm = new CVImpl();
    private List<DrugContainsBean> administerableMedicineIngredient = new ArrayList<DrugContainsBean>();


    /**
     * <p>C:Drug Description</p>
     */
    @Hl7XmlMapping({"administerableMedicine/desc"})
    public String getDrugDescription() {
        return this.drugDescription.getValue();
    }
    public void setDrugDescription(String drugDescription) {
        this.drugDescription.setValue(drugDescription);
    }


    /**
     * <p>E:Drug Lot Number</p>
     */
    @Hl7XmlMapping({"administerableMedicine/lotNumberText"})
    public String getDrugLotNumber() {
        return this.drugLotNumber.getValue();
    }
    public void setDrugLotNumber(String drugLotNumber) {
        this.drugLotNumber.setValue(drugLotNumber);
    }


    /**
     * <p>A:Drug Code</p>
     */
    @Hl7XmlMapping({"administerableMedicine/code"})
    public ManufacturedDrug getDrugCode() {
        return (ManufacturedDrug) this.drugCode.getValue();
    }
    public void setDrugCode(ManufacturedDrug drugCode) {
        this.drugCode.setValue(drugCode);
    }


    /**
     * <p>B:Drug Name</p>
     */
    @Hl7XmlMapping({"administerableMedicine/name"})
    public String getDrugName() {
        return this.drugName.getValue();
    }
    public void setDrugName(String drugName) {
        this.drugName.setValue(drugName);
    }


    /**
     * <p>F:Drug Expiry Date</p>
     */
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


    /**
     * <p>D:Drug Form</p>
     */
    @Hl7XmlMapping({"administerableMedicine/formCode"})
    public OrderableDrugForm getDrugForm() {
        return (OrderableDrugForm) this.drugForm.getValue();
    }
    public void setDrugForm(OrderableDrugForm drugForm) {
        this.drugForm.setValue(drugForm);
    }


    @Hl7XmlMapping({"administerableMedicine/ingredient"})
    public List<DrugContainsBean> getAdministerableMedicineIngredient() {
        return this.administerableMedicineIngredient;
    }

}
