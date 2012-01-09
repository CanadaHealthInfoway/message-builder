/**
 * Copyright 2011 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged;

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



/**
 * <p>DrugContains</p>
 * 
 * <p>POME_MT010040CA.Ingredient: drug contains</p>
 * 
 * <p><p>Identification of which ingredients are contained (or 
 * are not contained) in a drug, along with their respective 
 * quantities.</p></p>
 * 
 * <p><p>Useful to providers in deciding appropriate use 
 * instruction (dosage specification) for patients. Also 
 * important in checking for potential adverse reactions to 
 * non-active ingredients. For compounds, allows 
 * contraindication checking against ingredients of custom 
 * compounds.</p></p>
 * 
 * <p>POME_MT010100CA.Ingredient: drug contains</p>
 * 
 * <p><p>Identification of which ingredients are contained (or 
 * are not contained) in a drug, along with their respective 
 * quantities.</p></p>
 * 
 * <p><p>Useful to providers in deciding appropriate use 
 * instruction (dosage specification) for patients. Also 
 * important in checking for potential adverse reactions to 
 * non-active ingredients. For compounds, allows 
 * contraindication checking against ingredients of custom 
 * compounds.</p></p>
 * 
 * <p>COCT_MT220100CA.Ingredient: drug contains</p>
 * 
 * <p><p>Identification of which ingredients are contained (or 
 * are not contained) in a drug, along with their respective 
 * quantities.</p></p>
 * 
 * <p><p>Useful to providers in deciding appropriate use 
 * instruction (dosage specification) for patients. Also 
 * important in checking for potential adverse reactions to 
 * non-active ingredients. For compounds, allows 
 * contraindication checking against ingredients of custom 
 * compounds.</p></p>
 * 
 * <p>COCT_MT220200CA.Ingredient: drug contains</p>
 * 
 * <p><p>Identification of which ingredients are contained (or 
 * are not contained) in a drug, along with their respective 
 * quantities.</p></p>
 * 
 * <p><p>Useful to providers in deciding appropriate use 
 * instruction (dosage specification) for patients. Also 
 * important in checking for potential adverse reactions to 
 * non-active ingredients. For compounds, allows 
 * contraindication checking against ingredients of custom 
 * compounds.</p></p>
 * 
 * <p>COCT_MT220210CA.Ingredient: drug contains</p>
 * 
 * <p><p>Identification of which ingredients are contained (or 
 * are not contained) in a drug, along with their respective 
 * quantities.</p></p>
 * 
 * <p><p>Useful to providers in deciding appropriate use 
 * instruction (dosage specification) for patients. Also 
 * important in checking for potential adverse reactions to 
 * non-active ingredients. For compounds, allows 
 * contraindication checking against ingredients of custom 
 * compounds.</p></p>
 * 
 * <p>COCT_MT220110CA.Ingredient: drug contains</p>
 * 
 * <p><p>Identification of which ingredients are contained (or 
 * are not contained) in a drug, along with their respective 
 * quantities.</p></p>
 * 
 * <p><p>Useful to providers in deciding appropriate use 
 * instruction (dosage specification) for patients. Also 
 * important in checking for potential adverse reactions to 
 * non-active ingredients. For compounds, allows 
 * contraindication checking against ingredients of custom 
 * compounds.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT220100CA.Ingredient","COCT_MT220110CA.Ingredient","COCT_MT220200CA.Ingredient","COCT_MT220210CA.Ingredient","FICR_MT400003CA.Ingredient","FICR_MT400004CA.Ingredient","FICR_MT490102CA.Ingredient","POME_MT010040CA.Ingredient","POME_MT010100CA.Ingredient"})
public class DrugContainsBean extends MessagePartBean {

    private static final long serialVersionUID = 20120106L;
    private BL negationInd = new BLImpl();
    private PQ quantity = new PQImpl();
    private CV ingredientCode = new CVImpl();
    private ST ingredientName = new STImpl();


    /**
     * <p>D:Drug Does Not Contain Indicator</p>
     * 
     * <p><p>An indication that a drug does not contain the 
     * specified ingredient (active or inactive).</p></p>
     * 
     * <p><p>Useful for filtering searches. Allows providers to 
     * search for drugs not containing a specific active 
     * ingredients or excipients. E.g. lactose-free, gluten-free, 
     * etc.</p><p>The attribute is 'populated' because the 
     * distinction between &quot;does/must contain&quot; and 
     * &quot;does/must not contain&quot; is essential, however in 
     * some circumstances it is necessary to say &quot;may 
     * contain&quot;.</p></p>
     * 
     * <p><p>Useful for filtering searches. Allows providers to 
     * search for drugs not containing a specific active 
     * ingredients or excipients. E.g. lactose-free, gluten-free, 
     * etc.</p><p>The attribute is 'populated' because the 
     * distinction between &quot;does/must contain&quot; and 
     * &quot;does/must not contain&quot; is essential, however in 
     * some circumstances it is necessary to say &quot;may 
     * contain&quot;.</p></p>
     * 
     * <p>L:Does Not Contain Indicator</p>
     * 
     * <p><p>An indication that a drug does not contain the 
     * specified ingredient (active or inactive).</p></p>
     * 
     * <p><p>Useful for filtering searches. Allows providers to 
     * search for drugs not containing a specific active 
     * ingredients or excipients. E.g. lactose-free, gluten-free, 
     * etc.</p><p>Because product descriptions (particularly 
     * herbals) occasionally use the phrase &quot;may 
     * contain&quot;, this attribute allows null values.</p></p>
     * 
     * <p><p>Useful for filtering searches. Allows providers to 
     * search for drugs not containing a specific active 
     * ingredients or excipients. E.g. lactose-free, gluten-free, 
     * etc.</p><p>Because product descriptions (particularly 
     * herbals) occasionally use the phrase &quot;may 
     * contain&quot;, this attribute allows null values.</p></p>
     * 
     * <p>Does Not Contain Indicator</p>
     * 
     * <p><p>An indication that a drug does not contain the 
     * specified ingredient (active or inactive).</p></p>
     * 
     * <p><p>Useful for filtering searches. Allows providers to 
     * search for drugs not containing a specific active 
     * ingredients or excipients. E.g. lactose-free, gluten-free, 
     * etc.</p><p>Because product descriptions (particularly 
     * herbals) occasionally use the phrase &quot;may 
     * contain&quot;, this attribute allows null values.</p></p>
     * 
     * <p><p>Useful for filtering searches. Allows providers to 
     * search for drugs not containing a specific active 
     * ingredients or excipients. E.g. lactose-free, gluten-free, 
     * etc.</p><p>Because product descriptions (particularly 
     * herbals) occasionally use the phrase &quot;may 
     * contain&quot;, this attribute allows null values.</p></p>
     * 
     * <p>Drug Does Not Contain Indicator</p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }


    /**
     * <p>C:Drug Ingredient Quantity</p>
     * 
     * <p><p>The quantity of the ingredient in a drug. This is 
     * represented/measured in various forms/units including: mg, 
     * mg/vol, %, etc.</p></p>
     * 
     * <p><p>CompoundIngredient.amount(numerator)</p><p>CompoundIngredient.proportionOfFinal(e.g. 
     * 10% = 
     * .1mg/1mg)</p><p>ZPC.4(quantity)</p><p>ZPC.5(unit)</p><p>ZPJ1.4(quantity)</p><p>ZPJ1.5(unit)</p><p>ZPJ1.6(e.g. 
     * 10% = 
     * .1mg/1mg)</p><p>ZCP.3</p><p>ZDU.4.3</p><p>ZDU.6.1.2</p><p>Compound.448-ED 
     * (quantity)</p><p>Compound.451-EG (unit)</p></p>
     * 
     * <p><p>CompoundIngredient.amount(numerator)</p><p>CompoundIngredient.proportionOfFinal(e.g. 
     * 10% = 
     * .1mg/1mg)</p><p>ZPC.4(quantity)</p><p>ZPC.5(unit)</p><p>ZPJ1.4(quantity)</p><p>ZPJ1.5(unit)</p><p>ZPJ1.6(e.g. 
     * 10% = 
     * .1mg/1mg)</p><p>ZCP.3</p><p>ZDU.4.3</p><p>ZDU.6.1.2</p><p>Compound.448-ED 
     * (quantity)</p><p>Compound.451-EG (unit)</p></p>
     * 
     * <p><p>CompoundIngredient.amount(numerator)</p><p>CompoundIngredient.proportionOfFinal(e.g. 
     * 10% = 
     * .1mg/1mg)</p><p>ZPC.4(quantity)</p><p>ZPC.5(unit)</p><p>ZPJ1.4(quantity)</p><p>ZPJ1.5(unit)</p><p>ZPJ1.6(e.g. 
     * 10% = 
     * .1mg/1mg)</p><p>ZCP.3</p><p>ZDU.4.3</p><p>ZDU.6.1.2</p><p>Compound.448-ED 
     * (quantity)</p><p>Compound.451-EG (unit)</p></p>
     * 
     * <p><p>CompoundIngredient.amount(numerator)</p><p>CompoundIngredient.proportionOfFinal(e.g. 
     * 10% = 
     * .1mg/1mg)</p><p>ZPC.4(quantity)</p><p>ZPC.5(unit)</p><p>ZPJ1.4(quantity)</p><p>ZPJ1.5(unit)</p><p>ZPJ1.6(e.g. 
     * 10% = 
     * .1mg/1mg)</p><p>ZCP.3</p><p>ZDU.4.3</p><p>ZDU.6.1.2</p><p>Compound.448-ED 
     * (quantity)</p><p>Compound.451-EG (unit)</p></p>
     * 
     * <p><p>CompoundIngredient.amount(numerator)</p><p>CompoundIngredient.proportionOfFinal(e.g. 
     * 10% = 
     * .1mg/1mg)</p><p>ZPC.4(quantity)</p><p>ZPC.5(unit)</p><p>ZPJ1.4(quantity)</p><p>ZPJ1.5(unit)</p><p>ZPJ1.6(e.g. 
     * 10% = 
     * .1mg/1mg)</p><p>ZCP.3</p><p>ZDU.4.3</p><p>ZDU.6.1.2</p><p>Compound.448-ED 
     * (quantity)</p><p>Compound.451-EG (unit)</p></p>
     * 
     * <p><p>CompoundIngredient.amount(numerator)</p><p>CompoundIngredient.proportionOfFinal(e.g. 
     * 10% = 
     * .1mg/1mg)</p><p>ZPC.4(quantity)</p><p>ZPC.5(unit)</p><p>ZPJ1.4(quantity)</p><p>ZPJ1.5(unit)</p><p>ZPJ1.6(e.g. 
     * 10% = 
     * .1mg/1mg)</p><p>ZCP.3</p><p>ZDU.4.3</p><p>ZDU.6.1.2</p><p>Compound.448-ED 
     * (quantity)</p><p>Compound.451-EG (unit)</p></p>
     * 
     * <p><p>CompoundIngredient.amount(numerator)</p><p>CompoundIngredient.proportionOfFinal(e.g. 
     * 10% = 
     * .1mg/1mg)</p><p>ZPC.4(quantity)</p><p>ZPC.5(unit)</p><p>ZPJ1.4(quantity)</p><p>ZPJ1.5(unit)</p><p>ZPJ1.6(e.g. 
     * 10% = 
     * .1mg/1mg)</p><p>ZCP.3</p><p>ZDU.4.3</p><p>ZDU.6.1.2</p><p>Compound.448-ED 
     * (quantity)</p><p>Compound.451-EG (unit)</p></p>
     * 
     * <p><p>CompoundIngredient.amount(numerator)</p><p>CompoundIngredient.proportionOfFinal(e.g. 
     * 10% = 
     * .1mg/1mg)</p><p>ZPC.4(quantity)</p><p>ZPC.5(unit)</p><p>ZPJ1.4(quantity)</p><p>ZPJ1.5(unit)</p><p>ZPJ1.6(e.g. 
     * 10% = 
     * .1mg/1mg)</p><p>ZCP.3</p><p>ZDU.4.3</p><p>ZDU.6.1.2</p><p>Compound.448-ED 
     * (quantity)</p><p>Compound.451-EG (unit)</p></p>
     * 
     * <p><p>CompoundIngredient.amount(numerator)</p><p>CompoundIngredient.proportionOfFinal(e.g. 
     * 10% = 
     * .1mg/1mg)</p><p>ZPC.4(quantity)</p><p>ZPC.5(unit)</p><p>ZPJ1.4(quantity)</p><p>ZPJ1.5(unit)</p><p>ZPJ1.6(e.g. 
     * 10% = 
     * .1mg/1mg)</p><p>ZCP.3</p><p>ZDU.4.3</p><p>ZDU.6.1.2</p><p>Compound.448-ED 
     * (quantity)</p><p>Compound.451-EG (unit)</p></p>
     * 
     * <p><p>CompoundIngredient.amount(numerator)</p><p>CompoundIngredient.proportionOfFinal(e.g. 
     * 10% = 
     * .1mg/1mg)</p><p>ZPC.4(quantity)</p><p>ZPC.5(unit)</p><p>ZPJ1.4(quantity)</p><p>ZPJ1.5(unit)</p><p>ZPJ1.6(e.g. 
     * 10% = 
     * .1mg/1mg)</p><p>ZCP.3</p><p>ZDU.4.3</p><p>ZDU.6.1.2</p><p>Compound.448-ED 
     * (quantity)</p><p>Compound.451-EG (unit)</p></p>
     * 
     * <p><p>CompoundIngredient.amount(numerator)</p><p>CompoundIngredient.proportionOfFinal(e.g. 
     * 10% = 
     * .1mg/1mg)</p><p>ZPC.4(quantity)</p><p>ZPC.5(unit)</p><p>ZPJ1.4(quantity)</p><p>ZPJ1.5(unit)</p><p>ZPJ1.6(e.g. 
     * 10% = 
     * .1mg/1mg)</p><p>ZCP.3</p><p>ZDU.4.3</p><p>ZDU.6.1.2</p><p>Compound.448-ED 
     * (quantity)</p><p>Compound.451-EG (unit)</p></p>
     * 
     * <p><p>CompoundIngredient.amount(numerator)</p><p>CompoundIngredient.proportionOfFinal(e.g. 
     * 10% = 
     * .1mg/1mg)</p><p>ZPC.4(quantity)</p><p>ZPC.5(unit)</p><p>ZPJ1.4(quantity)</p><p>ZPJ1.5(unit)</p><p>ZPJ1.6(e.g. 
     * 10% = 
     * .1mg/1mg)</p><p>ZCP.3</p><p>ZDU.4.3</p><p>ZDU.6.1.2</p><p>Compound.448-ED 
     * (quantity)</p><p>Compound.451-EG (unit)</p></p>
     * 
     * <p><p>Essential for evaluating appropriate dosage based on 
     * strength, as well as for creating custom compounds with 
     * proper composition.</p></p>
     * 
     * <p>M:Ingredient Quantity</p>
     * 
     * <p><p>The quantity of the ingredient in a drug. This is 
     * represented/measured in various forms/units including: mg, 
     * mg/vol, %, etc.</p></p>
     * 
     * <p><p>Essential for evaluating appropriate dosage based on 
     * strength, as well as for creating custom compounds with 
     * proper composition.</p></p>
     * 
     * <p>Drug Ingredient Quantity</p>
     * 
     * <p>Ingredient Quantity</p>
     * 
     * <p><p>The quantity of the ingredient in a drug. This is 
     * represented/measured in various forms/units including: mg, 
     * mg/vol, %, etc.</p></p>
     * 
     * <p><p>Essential for evaluating appropriate dosage based on 
     * strength, as well as for creating custom compounds with 
     * proper composition.</p></p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getQuantity() {
        return this.quantity.getValue();
    }
    public void setQuantity(PhysicalQuantity quantity) {
        this.quantity.setValue(quantity);
    }


    /**
     * <p>DrugIngredientIdentifier</p>
     * 
     * <p>J:Drug Ingredient Identifier</p>
     * 
     * <p><p>The unique identifier for the drug or chemical.</p></p>
     * 
     * <p><p>Allows un-ambiguous identification of the ingredients 
     * of a drug for performing various alert checking.</p><p>Also 
     * allows for the identification of antigens as class of 
     * ingredients in vaccines.</p><p>This attribute is marked as 
     * &quot;populated&quot; as an ingredient code should be 
     * available in most cases.</p></p>
     * 
     * <p><p>Allows un-ambiguous identification of the ingredients 
     * of a drug for performing various alert checking.</p><p>Also 
     * allows for the identification of antigens as class of 
     * ingredients in vaccines.</p><p>This attribute is marked as 
     * &quot;populated&quot; as an ingredient code should be 
     * available in most cases.</p></p>
     * 
     * <p><p>Allows un-ambiguous identification of the ingredients 
     * of a drug for performing various alert checking.</p><p>Also 
     * allows for the identification of antigens as class of 
     * ingredients in vaccines.</p><p>This attribute is marked as 
     * &quot;populated&quot; as an ingredient code should be 
     * available in most cases.</p></p>
     * 
     * <p>A:Drug Ingredient Identifier</p>
     * 
     * <p><p>The unique identifier for the drug or chemical.</p></p>
     * 
     * <p><p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p></p>
     * 
     * <p><p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p></p>
     * 
     * <p><p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p></p>
     * 
     * <p><p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p></p>
     * 
     * <p><p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p></p>
     * 
     * <p><p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p></p>
     * 
     * <p><p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p></p>
     * 
     * <p><p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p></p>
     * 
     * <p><p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p></p>
     * 
     * <p><p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p></p>
     * 
     * <p><p>Allows un-ambiguous identification of the ingredients 
     * of a drug for performing various alert checking.</p><p>Also 
     * allows for the identification of antigens as specific class 
     * of ingredients in vaccines.</p></p>
     * 
     * <p><p>Allows un-ambiguous identification of the ingredients 
     * of a drug for performing various alert checking.</p><p>Also 
     * allows for the identification of antigens as specific class 
     * of ingredients in vaccines.</p></p>
     * 
     * <p>Drug Ingredient Identifier</p>
     * 
     * <p><p>The unique identifier for the drug or chemical.</p></p>
     * 
     * <p><p>Allows un-ambiguous identification of the ingredients 
     * of a drug for performing various alert checking.</p><p>Also 
     * allows for the identification of antigens as specific class 
     * of ingredients in vaccines.</p><p>This attribute is marked 
     * as &quot;populated&quot; as an ingredient code should be 
     * available in most cases.</p></p>
     * 
     * <p><p>Allows un-ambiguous identification of the ingredients 
     * of a drug for performing various alert checking.</p><p>Also 
     * allows for the identification of antigens as specific class 
     * of ingredients in vaccines.</p><p>This attribute is marked 
     * as &quot;populated&quot; as an ingredient code should be 
     * available in most cases.</p></p>
     * 
     * <p><p>Allows un-ambiguous identification of the ingredients 
     * of a drug for performing various alert checking.</p><p>Also 
     * allows for the identification of antigens as specific class 
     * of ingredients in vaccines.</p><p>This attribute is marked 
     * as &quot;populated&quot; as an ingredient code should be 
     * available in most cases.</p></p>
     * 
     * <p>A:Drug Ingredient Identifier</p>
     * 
     * <p><p>The unique identifier for the drug or chemical.</p></p>
     * 
     * <p><p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p></p>
     * 
     * <p><p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p></p>
     * 
     * <p><p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p></p>
     * 
     * <p><p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p></p>
     * 
     * <p><p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.
     * ... [rest of documentation truncated due to excessive length]
     */
    @Hl7XmlMapping({"ingredient/code"})
    public ActiveIngredientDrugEntityType getIngredientCode() {
        return (ActiveIngredientDrugEntityType) this.ingredientCode.getValue();
    }
    public void setIngredientCode(ActiveIngredientDrugEntityType ingredientCode) {
        this.ingredientCode.setValue(ingredientCode);
    }


    /**
     * <p>K:Ingredient Name</p>
     * 
     * <p><p>The name of the contained drug or chemical.</p></p>
     * 
     * <p><p>Used for communication between and display to 
     * providers.</p><p>This attribute is marked as 
     * &quot;populated&quot; as an ingredient name should be 
     * available in most cases.</p></p>
     * 
     * <p><p>Used for communication between and display to 
     * providers.</p><p>This attribute is marked as 
     * &quot;populated&quot; as an ingredient name should be 
     * available in most cases.</p></p>
     * 
     * <p>Ingredient Name</p>
     * 
     * <p><p>The name of the contained drug or chemical.</p></p>
     * 
     * <p><p>Used for communication between and display to 
     * providers.</p><p>This attribute is marked as 
     * &quot;populated&quot; as an ingredient name should be 
     * available in most cases.</p></p>
     * 
     * <p><p>Used for communication between and display to 
     * providers.</p><p>This attribute is marked as 
     * &quot;populated&quot; as an ingredient name should be 
     * available in most cases.</p></p>
     * 
     * <p>B:Drug Ingredient Name</p>
     * 
     * <p>B:Drug Ingredient Name</p>
     * 
     * <p><p>The name of the contained drug or chemical.</p></p>
     * 
     * <p><p>CompoundIngredient.IngredientDrug.drugProductName</p></p>
     * 
     * <p><p>Used for communication between and display to 
     * providers.</p></p>
     */
    @Hl7XmlMapping({"ingredient/name"})
    public String getIngredientName() {
        return this.ingredientName.getValue();
    }
    public void setIngredientName(String ingredientName) {
        this.ingredientName.setValue(ingredientName);
    }

}
