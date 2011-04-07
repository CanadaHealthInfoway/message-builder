/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ClinicalDrug;
import ca.infoway.messagebuilder.domainvalue.OrderableDrugForm;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"FICR_MT400001CA.Medicine","FICR_MT400003CA.Medicine","FICR_MT400004CA.Medicine","FICR_MT490101CA.Medicine"})
public class MedicineBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private CV drugCode = new CVImpl();
    private ST drugName = new STImpl();
    private ST drugDescription = new STImpl();
    private CV drugForm = new CVImpl();
    private DrugContainsBean ingredient;


    /**
     * <p>DrugCode</p>
     * 
     * <p>Drug Code</p>
     */
    @Hl7XmlMapping({"code"})
    public ClinicalDrug getDrugCode() {
        return (ClinicalDrug) this.drugCode.getValue();
    }
    public void setDrugCode(ClinicalDrug drugCode) {
        this.drugCode.setValue(drugCode);
    }


    /**
     * <p>DrugName</p>
     * 
     * <p>Drug Name</p>
     */
    @Hl7XmlMapping({"name"})
    public String getDrugName() {
        return this.drugName.getValue();
    }
    public void setDrugName(String drugName) {
        this.drugName.setValue(drugName);
    }


    /**
     * <p>DrugDescription</p>
     * 
     * <p>Drug Description</p>
     */
    @Hl7XmlMapping({"desc"})
    public String getDrugDescription() {
        return this.drugDescription.getValue();
    }
    public void setDrugDescription(String drugDescription) {
        this.drugDescription.setValue(drugDescription);
    }


    /**
     * <p>DrugForm</p>
     * 
     * <p>Drug Form</p>
     * 
     * <p><p>Indicates the form in which the drug product must be, 
     * or has been manufactured or custom prepared. Examples 
     * include: tablet, suspension, liquid, injectable, capsule, 
     * etc.</p></p>
     */
    @Hl7XmlMapping({"formCode"})
    public OrderableDrugForm getDrugForm() {
        return (OrderableDrugForm) this.drugForm.getValue();
    }
    public void setDrugForm(OrderableDrugForm drugForm) {
        this.drugForm.setValue(drugForm);
    }


    @Hl7XmlMapping({"ingredient"})
    public DrugContainsBean getIngredient() {
        return this.ingredient;
    }
    public void setIngredient(DrugContainsBean ingredient) {
        this.ingredient = ingredient;
    }

}
