/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActiveIngredientDrugEntityType;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COCT_MT220100CA.Ingredient","COCT_MT220110CA.Ingredient","COCT_MT220200CA.Ingredient","COCT_MT220210CA.Ingredient","POME_MT010040CA.Ingredient","POME_MT010100CA.Ingredient"})
public class DrugContainsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private CV drugIngredientIdentifier = new CVImpl();
    private ST ingredientName = new STImpl();
    private PQ quantity = new PQImpl();
    private BL negationInd = new BLImpl();


    /**
     * <p>DrugIngredientIdentifier</p>
     * 
     * <p>A:Drug Ingredient Identifier</p>
     * 
     * <p>Drug Ingredient Identifier</p>
     * 
     * <p>J:Drug Ingredient Identifier</p>
     */
    @Hl7XmlMapping({"ingredient/code"})
    public ActiveIngredientDrugEntityType getDrugIngredientIdentifier() {
        return (ActiveIngredientDrugEntityType) this.drugIngredientIdentifier.getValue();
    }
    public void setDrugIngredientIdentifier(ActiveIngredientDrugEntityType drugIngredientIdentifier) {
        this.drugIngredientIdentifier.setValue(drugIngredientIdentifier);
    }


    /**
     * <p>K:Ingredient Name</p>
     * 
     * <p>Ingredient Name</p>
     * 
     * <p>B:Drug Ingredient Name</p>
     */
    @Hl7XmlMapping({"ingredient/name"})
    public String getIngredientName() {
        return this.ingredientName.getValue();
    }
    public void setIngredientName(String ingredientName) {
        this.ingredientName.setValue(ingredientName);
    }


    /**
     * <p>Ingredient Quantity</p>
     * 
     * <p>C:Drug Ingredient Quantity</p>
     * 
     * <p>M:Ingredient Quantity</p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getQuantity() {
        return this.quantity.getValue();
    }
    public void setQuantity(PhysicalQuantity quantity) {
        this.quantity.setValue(quantity);
    }


    /**
     * <p>L:Does Not Contain Indicator</p>
     * 
     * <p>D:Drug Does Not Contain Indicator</p>
     * 
     * <p>Does Not Contain Indicator</p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }

}
