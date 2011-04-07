/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v01_r04_3.common.coct_mt220110ca;

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
import ca.infoway.messagebuilder.model.v01_r04_3.merged.DispensedInBean;
import ca.infoway.messagebuilder.model.v01_r04_3.merged.DrugContainsBean;
import ca.infoway.messagebuilder.model.v01_r04_3.merged.ManufacturerBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"COCT_MT220110CA.Medication"})
@Hl7RootType
public class DrugProductBean extends MessagePartBean implements ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.porx_mt980040ca.Medication {

    private static final long serialVersionUID = 20110407L;
    private CD drugCode = new CDImpl();
    private ST drugName = new STImpl();
    private ST drugDescription = new STImpl();
    private CV drugForm = new CVImpl();
    private ManufacturerBean playerAsManufacturedProductManufacturer;
    private DispensedInBean playerAsContent;
    private List<DrugContainsBean> playerIngredient = new ArrayList<DrugContainsBean>();


    /**
     * <p>A:Drug Code</p>
     */
    @Hl7XmlMapping({"player/code"})
    public ClinicalDrug getDrugCode() {
        return (ClinicalDrug) this.drugCode.getValue();
    }
    public void setDrugCode(ClinicalDrug drugCode) {
        this.drugCode.setValue(drugCode);
    }


    /**
     * <p>B:Drug Name</p>
     */
    @Hl7XmlMapping({"player/name"})
    public String getDrugName() {
        return this.drugName.getValue();
    }
    public void setDrugName(String drugName) {
        this.drugName.setValue(drugName);
    }


    /**
     * <p>C:Drug Description</p>
     */
    @Hl7XmlMapping({"player/desc"})
    public String getDrugDescription() {
        return this.drugDescription.getValue();
    }
    public void setDrugDescription(String drugDescription) {
        this.drugDescription.setValue(drugDescription);
    }


    /**
     * <p>D:Drug Form</p>
     */
    @Hl7XmlMapping({"player/formCode"})
    public OrderableDrugForm getDrugForm() {
        return (OrderableDrugForm) this.drugForm.getValue();
    }
    public void setDrugForm(OrderableDrugForm drugForm) {
        this.drugForm.setValue(drugForm);
    }


    @Hl7XmlMapping({"player/asManufacturedProduct/manufacturer"})
    public ManufacturerBean getPlayerAsManufacturedProductManufacturer() {
        return this.playerAsManufacturedProductManufacturer;
    }
    public void setPlayerAsManufacturedProductManufacturer(ManufacturerBean playerAsManufacturedProductManufacturer) {
        this.playerAsManufacturedProductManufacturer = playerAsManufacturedProductManufacturer;
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

}
