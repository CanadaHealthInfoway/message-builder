/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.pharmacy.pome_mt010040ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TN;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TNImpl;
import ca.infoway.messagebuilder.datatype.lang.TrivialName;
import ca.infoway.messagebuilder.domainvalue.ClinicalDrug;
import ca.infoway.messagebuilder.domainvalue.OrderableDrugForm;
import ca.infoway.messagebuilder.domainvalue.RoleStatusNormal;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.v02_r01.merged.DrugContainsBean;
import ca.infoway.messagebuilder.model.v02_r01.merged.ManufacturerBean;
import ca.infoway.messagebuilder.model.v02_r01.pharmacy.merged.DispensedInBean;
import ca.infoway.messagebuilder.model.v02_r01.pharmacy.merged.GroupedWithinBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



@Hl7PartTypeMapping({"POME_MT010040CA.Medicine"})
public class DrugOrCompoundBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private CS regulatoryStatusCode = new CSImpl();
    private ST description = new STImpl();
    private CV drugCode = new CVImpl();
    private SET<TN, TrivialName> drugNames = new SETImpl<TN, TrivialName>(TNImpl.class);
    private List<GroupedWithinBean> asSpecializedKind = new ArrayList<GroupedWithinBean>();
    private CV drugForm = new CVImpl();
    private List<DrugContainsBean> ingredient = new ArrayList<DrugContainsBean>();
    private DispensedInBean asContent;
    private ManufacturerBean asManufacturedProductManufacturer;


    /**
     * <p>Regulatory Status Code</p>
     */
    @Hl7XmlMapping({"asRegulatedProduct/statusCode"})
    public RoleStatusNormal getRegulatoryStatusCode() {
        return (RoleStatusNormal) this.regulatoryStatusCode.getValue();
    }
    public void setRegulatoryStatusCode(RoleStatusNormal regulatoryStatusCode) {
        this.regulatoryStatusCode.setValue(regulatoryStatusCode);
    }


    /**
     * <p>Description</p>
     */
    @Hl7XmlMapping({"desc"})
    public String getDescription() {
        return this.description.getValue();
    }
    public void setDescription(String description) {
        this.description.setValue(description);
    }


    /**
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
     * <p>Drug Names</p>
     */
    @Hl7XmlMapping({"name"})
    public Set<TrivialName> getDrugNames() {
        return this.drugNames.rawSet();
    }


    @Hl7XmlMapping({"asSpecializedKind"})
    public List<GroupedWithinBean> getAsSpecializedKind() {
        return this.asSpecializedKind;
    }


    /**
     * <p>Drug Form</p>
     */
    @Hl7XmlMapping({"formCode"})
    public OrderableDrugForm getDrugForm() {
        return (OrderableDrugForm) this.drugForm.getValue();
    }
    public void setDrugForm(OrderableDrugForm drugForm) {
        this.drugForm.setValue(drugForm);
    }


    @Hl7XmlMapping({"ingredient"})
    public List<DrugContainsBean> getIngredient() {
        return this.ingredient;
    }


    @Hl7XmlMapping({"asContent"})
    public DispensedInBean getAsContent() {
        return this.asContent;
    }
    public void setAsContent(DispensedInBean asContent) {
        this.asContent = asContent;
    }


    @Hl7XmlMapping({"asManufacturedProduct/manufacturer"})
    public ManufacturerBean getAsManufacturedProductManufacturer() {
        return this.asManufacturedProductManufacturer;
    }
    public void setAsManufacturedProductManufacturer(ManufacturerBean asManufacturedProductManufacturer) {
        this.asManufacturedProductManufacturer = asManufacturedProductManufacturer;
    }

}