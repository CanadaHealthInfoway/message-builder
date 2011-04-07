/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v01_r04_3.common.coct_mt220210ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CE;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CEImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ManufacturedDrug;
import ca.infoway.messagebuilder.domainvalue.OrderableDrugForm;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.v01_r04_3.merged.DispensedInBean;
import ca.infoway.messagebuilder.model.v01_r04_3.merged.DrugContainsBean;
import ca.infoway.messagebuilder.model.v01_r04_3.merged.ManufacturerBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"COCT_MT220210CA.Medication"})
@Hl7RootType
public class DrugProductBean extends MessagePartBean implements ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.porx_mt980040ca.Medication {

    private static final long serialVersionUID = 20110407L;
    private CE drugCode = new CEImpl();
    private ST drugName = new STImpl();
    private ST drugDescription = new STImpl();
    private CV drugForm = new CVImpl();
    private ST drugLotNumber = new STImpl();
    private IVL<TS, Interval<Date>> drugExpiryDate = new IVLImpl<TS, Interval<Date>>();
    private ManufacturerBean playerAsManufacturedProductManufacturer;
    private DispensedInBean playerAsContent;
    private List<DrugContainsBean> playerIngredient = new ArrayList<DrugContainsBean>();


    /**
     * <p>A:Drug Code</p>
     */
    @Hl7XmlMapping({"player/code"})
    public ManufacturedDrug getDrugCode() {
        return (ManufacturedDrug) this.drugCode.getValue();
    }
    public void setDrugCode(ManufacturedDrug drugCode) {
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


    /**
     * <p>E:Drug Lot Number</p>
     */
    @Hl7XmlMapping({"player/lotNumberText"})
    public String getDrugLotNumber() {
        return this.drugLotNumber.getValue();
    }
    public void setDrugLotNumber(String drugLotNumber) {
        this.drugLotNumber.setValue(drugLotNumber);
    }


    /**
     * <p>F:Drug Expiry Date</p>
     */
    @Hl7XmlMapping({"player/expirationTime"})
    public Interval<Date> getDrugExpiryDate() {
        return this.drugExpiryDate.getValue();
    }
    public void setDrugExpiryDate(Interval<Date> drugExpiryDate) {
        this.drugExpiryDate.setValue(drugExpiryDate);
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
