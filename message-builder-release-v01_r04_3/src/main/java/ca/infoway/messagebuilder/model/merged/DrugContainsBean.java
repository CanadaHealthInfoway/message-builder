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

    private static final long serialVersionUID = 20100614L;
    private BL doesNotContainIndicator = new BLImpl();
    private PQ ingredientQuantity = new PQImpl();
    private CV drugIngredientIdentifier = new CVImpl();
    private ST drugIngredientName = new STImpl();

    @Hl7XmlMapping({"negationInd"})
    public Boolean getDoesNotContainIndicator() {
        return this.doesNotContainIndicator.getValue();
    }
    public void setDoesNotContainIndicator(Boolean doesNotContainIndicator) {
        this.doesNotContainIndicator.setValue(doesNotContainIndicator);
    }

    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getIngredientQuantity() {
        return this.ingredientQuantity.getValue();
    }
    public void setIngredientQuantity(PhysicalQuantity ingredientQuantity) {
        this.ingredientQuantity.setValue(ingredientQuantity);
    }

    @Hl7XmlMapping({"ingredient/code"})
    public ActiveIngredientDrugEntityType getDrugIngredientIdentifier() {
        return (ActiveIngredientDrugEntityType) this.drugIngredientIdentifier.getValue();
    }
    public void setDrugIngredientIdentifier(ActiveIngredientDrugEntityType drugIngredientIdentifier) {
        this.drugIngredientIdentifier.setValue(drugIngredientIdentifier);
    }

    @Hl7XmlMapping({"ingredient/name"})
    public String getDrugIngredientName() {
        return this.drugIngredientName.getValue();
    }
    public void setDrugIngredientName(String drugIngredientName) {
        this.drugIngredientName.setValue(drugIngredientName);
    }

}
