/**
 * Copyright 2013 Canada Health Infoway, Inc.
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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03_imm.common.merged;

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
 * <p>Business Name: DrugContains</p>
 * 
 * <p>COCT_MT220200CA.Ingredient: drug contains</p>
 * 
 * <p>Useful to providers in deciding appropriate use 
 * instruction (dosage specification) for patients. Also 
 * important in checking for potential adverse reactions to 
 * non-active ingredients. For compounds, allows 
 * contraindication checking against ingredients of custom 
 * compounds.</p>
 * 
 * <p>Identification of which ingredients are contained (or are 
 * not contained) in a drug, along with their respective 
 * quantities.</p>
 * 
 * <p>COCT_MT220100CA.Ingredient: drug contains</p>
 * 
 * <p>Useful to providers in deciding appropriate use 
 * instruction (dosage specification) for patients. Also 
 * important in checking for potential adverse reactions to 
 * non-active ingredients. For compounds, allows 
 * contraindication checking against ingredients of custom 
 * compounds.</p>
 * 
 * <p>Identification of which ingredients are contained (or are 
 * not contained) in a drug, along with their respective 
 * quantities.</p>
 * 
 * <p>COCT_MT220110CA.Ingredient: drug contains</p>
 * 
 * <p>Useful to providers in deciding appropriate use 
 * instruction (dosage specification) for patients. Also 
 * important in checking for potential adverse reactions to 
 * non-active ingredients. For compounds, allows 
 * contraindication checking against ingredients of custom 
 * compounds.</p>
 * 
 * <p>Identification of which ingredients are contained (or are 
 * not contained) in a drug, along with their respective 
 * quantities.</p>
 * 
 * <p>COCT_MT220210CA.Ingredient: drug contains</p>
 * 
 * <p>Useful to providers in deciding appropriate use 
 * instruction (dosage specification) for patients. Also 
 * important in checking for potential adverse reactions to 
 * non-active ingredients. For compounds, allows 
 * contraindication checking against ingredients of custom 
 * compounds.</p>
 * 
 * <p>Identification of which ingredients are contained (or are 
 * not contained) in a drug, along with their respective 
 * quantities.</p>
 */
@Hl7PartTypeMapping({"COCT_MT220100CA.Ingredient","COCT_MT220110CA.Ingredient","COCT_MT220200CA.Ingredient","COCT_MT220210CA.Ingredient"})
public class DrugContainsBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private BL negationInd = new BLImpl();
    private PQ quantity = new PQImpl();
    private CV ingredientSubstanceCode = new CVImpl();
    private ST ingredientSubstanceName = new STImpl();


    /**
     * <p>Business Name: DrugDoesNotContainIndicator</p>
     * 
     * <p>Un-merged Business Name: DrugDoesNotContainIndicator</p>
     * 
     * <p>Relationship: COCT_MT220200CA.Ingredient.negationInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Useful for filtering searches. Allows providers to search 
     * for drugs not containing a specific active ingredients or 
     * excipients. E.g. lactose-free, gluten-free, etc.</p><p>The 
     * attribute is 'populated' because the distinction between 
     * &quot;does/must contain&quot; and &quot;does/must not 
     * contain&quot; is essential, however in some circumstances it 
     * is necessary to say &quot;may contain&quot;.</p>
     * 
     * <p>An indication that a drug does not contain the specified 
     * ingredient (active or inactive).</p>
     * 
     * <p>Un-merged Business Name: DrugDoesNotContainIndicator</p>
     * 
     * <p>Relationship: COCT_MT220100CA.Ingredient.negationInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Useful for filtering searches. Allows providers to search 
     * for drugs not containing a specific active ingredients or 
     * excipients. E.g. lactose-free, gluten-free, etc.</p><p>The 
     * attribute is 'populated' because the distinction between 
     * &quot;does/must contain&quot; and &quot;does/must not 
     * contain&quot; is essential, however in some circumstances it 
     * is necessary to say &quot;may contain&quot;.</p>
     * 
     * <p>An indication that a drug does not contain the specified 
     * ingredient (active or inactive).</p>
     * 
     * <p>Un-merged Business Name: DrugDoesNotContainIndicator</p>
     * 
     * <p>Relationship: COCT_MT220110CA.Ingredient.negationInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Useful for filtering searches. Allows providers to search 
     * for drugs not containing a specific active ingredients or 
     * excipients. E.g. lactose-free, gluten-free, etc.</p><p>The 
     * attribute is 'populated' because the distinction between 
     * &quot;does/must contain&quot; and &quot;does/must not 
     * contain&quot; is essential, however in some circumstances it 
     * is necessary to say &quot;may contain&quot;.</p>
     * 
     * <p>An indication that a drug does not contain the specified 
     * ingredient (active or inactive).</p>
     * 
     * <p>Un-merged Business Name: DrugDoesNotContainIndicator</p>
     * 
     * <p>Relationship: COCT_MT220210CA.Ingredient.negationInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Useful for filtering searches. Allows providers to search 
     * for drugs not containing a specific active ingredients or 
     * excipients. E.g. lactose-free, gluten-free, etc.</p><p>The 
     * attribute is 'populated' because the distinction between 
     * &quot;does/must contain&quot; and &quot;does/must not 
     * contain&quot; is essential, however in some circumstances it 
     * is necessary to say &quot;may contain&quot;.</p>
     * 
     * <p>An indication that a drug does not contain the specified 
     * ingredient (active or inactive).</p>
     */
    @Hl7XmlMapping({"negationInd"})
    public Boolean getNegationInd() {
        return this.negationInd.getValue();
    }

    /**
     * <p>Business Name: DrugDoesNotContainIndicator</p>
     * 
     * <p>Un-merged Business Name: DrugDoesNotContainIndicator</p>
     * 
     * <p>Relationship: COCT_MT220200CA.Ingredient.negationInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Useful for filtering searches. Allows providers to search 
     * for drugs not containing a specific active ingredients or 
     * excipients. E.g. lactose-free, gluten-free, etc.</p><p>The 
     * attribute is 'populated' because the distinction between 
     * &quot;does/must contain&quot; and &quot;does/must not 
     * contain&quot; is essential, however in some circumstances it 
     * is necessary to say &quot;may contain&quot;.</p>
     * 
     * <p>An indication that a drug does not contain the specified 
     * ingredient (active or inactive).</p>
     * 
     * <p>Un-merged Business Name: DrugDoesNotContainIndicator</p>
     * 
     * <p>Relationship: COCT_MT220100CA.Ingredient.negationInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Useful for filtering searches. Allows providers to search 
     * for drugs not containing a specific active ingredients or 
     * excipients. E.g. lactose-free, gluten-free, etc.</p><p>The 
     * attribute is 'populated' because the distinction between 
     * &quot;does/must contain&quot; and &quot;does/must not 
     * contain&quot; is essential, however in some circumstances it 
     * is necessary to say &quot;may contain&quot;.</p>
     * 
     * <p>An indication that a drug does not contain the specified 
     * ingredient (active or inactive).</p>
     * 
     * <p>Un-merged Business Name: DrugDoesNotContainIndicator</p>
     * 
     * <p>Relationship: COCT_MT220110CA.Ingredient.negationInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Useful for filtering searches. Allows providers to search 
     * for drugs not containing a specific active ingredients or 
     * excipients. E.g. lactose-free, gluten-free, etc.</p><p>The 
     * attribute is 'populated' because the distinction between 
     * &quot;does/must contain&quot; and &quot;does/must not 
     * contain&quot; is essential, however in some circumstances it 
     * is necessary to say &quot;may contain&quot;.</p>
     * 
     * <p>An indication that a drug does not contain the specified 
     * ingredient (active or inactive).</p>
     * 
     * <p>Un-merged Business Name: DrugDoesNotContainIndicator</p>
     * 
     * <p>Relationship: COCT_MT220210CA.Ingredient.negationInd</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Useful for filtering searches. Allows providers to search 
     * for drugs not containing a specific active ingredients or 
     * excipients. E.g. lactose-free, gluten-free, etc.</p><p>The 
     * attribute is 'populated' because the distinction between 
     * &quot;does/must contain&quot; and &quot;does/must not 
     * contain&quot; is essential, however in some circumstances it 
     * is necessary to say &quot;may contain&quot;.</p>
     * 
     * <p>An indication that a drug does not contain the specified 
     * ingredient (active or inactive).</p>
     */
    public void setNegationInd(Boolean negationInd) {
        this.negationInd.setValue(negationInd);
    }


    /**
     * <p>Business Name: DrugIngredientQuantity</p>
     * 
     * <p>Un-merged Business Name: DrugIngredientQuantity</p>
     * 
     * <p>Relationship: COCT_MT220200CA.Ingredient.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>CompoundIngredient.amount(numerator)</p>
     * 
     * <p>CompoundIngredient.proportionOfFinal(e.g. 10% = 
     * .1mg/1mg)</p>
     * 
     * <p>ZPC.4(quantity)</p>
     * 
     * <p>ZPC.5(unit)</p>
     * 
     * <p>ZPJ1.4(quantity)</p>
     * 
     * <p>ZPJ1.5(unit)</p>
     * 
     * <p>ZPJ1.6(e.g. 10% = .1mg/1mg)</p>
     * 
     * <p>ZCP.3</p>
     * 
     * <p>ZDU.4.3</p>
     * 
     * <p>ZDU.6.1.2</p>
     * 
     * <p>Compound.448-ED (quantity)</p>
     * 
     * <p>Compound.451-EG (unit)</p>
     * 
     * <p>Essential for evaluating appropriate dosage based on 
     * strength, as well as for creating custom compounds with 
     * proper composition.</p>
     * 
     * <p>The quantity of the ingredient in a drug. This is 
     * represented/measured in various forms/units including: mg, 
     * mg/vol, %, etc.</p>
     * 
     * <p>Un-merged Business Name: DrugIngredientQuantity</p>
     * 
     * <p>Relationship: COCT_MT220100CA.Ingredient.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>CompoundIngredient.amount(numerator)</p>
     * 
     * <p>CompoundIngredient.proportionOfFinal(e.g. 10% = 
     * .1mg/1mg)</p>
     * 
     * <p>ZPC.4(quantity)</p>
     * 
     * <p>ZPC.5(unit)</p>
     * 
     * <p>ZPJ1.4(quantity)</p>
     * 
     * <p>ZPJ1.5(unit)</p>
     * 
     * <p>ZPJ1.6(e.g. 10% = .1mg/1mg)</p>
     * 
     * <p>ZCP.3</p>
     * 
     * <p>ZDU.4.3</p>
     * 
     * <p>ZDU.6.1.2</p>
     * 
     * <p>Compound.448-ED (quantity)</p>
     * 
     * <p>Compound.451-EG (unit)</p>
     * 
     * <p>Essential for evaluating appropriate dosage based on 
     * strength, as well as for creating custom compounds with 
     * proper composition.</p>
     * 
     * <p>The quantity of the ingredient in a drug. This is 
     * represented/measured in various forms/units including: mg, 
     * mg/vol, %, etc.</p>
     * 
     * <p>Un-merged Business Name: DrugIngredientQuantity</p>
     * 
     * <p>Relationship: COCT_MT220110CA.Ingredient.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>CompoundIngredient.amount(numerator)</p>
     * 
     * <p>CompoundIngredient.proportionOfFinal(e.g. 10% = 
     * .1mg/1mg)</p>
     * 
     * <p>ZPC.4(quantity)</p>
     * 
     * <p>ZPC.5(unit)</p>
     * 
     * <p>ZPJ1.4(quantity)</p>
     * 
     * <p>ZPJ1.5(unit)</p>
     * 
     * <p>ZPJ1.6(e.g. 10% = .1mg/1mg)</p>
     * 
     * <p>ZCP.3</p>
     * 
     * <p>ZDU.4.3</p>
     * 
     * <p>ZDU.6.1.2</p>
     * 
     * <p>Compound.448-ED (quantity)</p>
     * 
     * <p>Compound.451-EG (unit)</p>
     * 
     * <p>Essential for evaluating appropriate dosage based on 
     * strength, as well as for creating custom compounds with 
     * proper composition.</p>
     * 
     * <p>The quantity of the ingredient in a drug. This is 
     * represented/measured in various forms/units including: mg, 
     * mg/vol, %, etc.</p>
     * 
     * <p>Un-merged Business Name: DrugIngredientQuantity</p>
     * 
     * <p>Relationship: COCT_MT220210CA.Ingredient.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>CompoundIngredient.amount(numerator)</p>
     * 
     * <p>CompoundIngredient.proportionOfFinal(e.g. 10% = 
     * .1mg/1mg)</p>
     * 
     * <p>ZPC.4(quantity)</p>
     * 
     * <p>ZPC.5(unit)</p>
     * 
     * <p>ZPJ1.4(quantity)</p>
     * 
     * <p>ZPJ1.5(unit)</p>
     * 
     * <p>ZPJ1.6(e.g. 10% = .1mg/1mg)</p>
     * 
     * <p>ZCP.3</p>
     * 
     * <p>ZDU.4.3</p>
     * 
     * <p>ZDU.6.1.2</p>
     * 
     * <p>Compound.448-ED (quantity)</p>
     * 
     * <p>Compound.451-EG (unit)</p>
     * 
     * <p>Essential for evaluating appropriate dosage based on 
     * strength, as well as for creating custom compounds with 
     * proper composition.</p>
     * 
     * <p>The quantity of the ingredient in a drug. This is 
     * represented/measured in various forms/units including: mg, 
     * mg/vol, %, etc.</p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getQuantity() {
        return this.quantity.getValue();
    }

    /**
     * <p>Business Name: DrugIngredientQuantity</p>
     * 
     * <p>Un-merged Business Name: DrugIngredientQuantity</p>
     * 
     * <p>Relationship: COCT_MT220200CA.Ingredient.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>CompoundIngredient.amount(numerator)</p>
     * 
     * <p>CompoundIngredient.proportionOfFinal(e.g. 10% = 
     * .1mg/1mg)</p>
     * 
     * <p>ZPC.4(quantity)</p>
     * 
     * <p>ZPC.5(unit)</p>
     * 
     * <p>ZPJ1.4(quantity)</p>
     * 
     * <p>ZPJ1.5(unit)</p>
     * 
     * <p>ZPJ1.6(e.g. 10% = .1mg/1mg)</p>
     * 
     * <p>ZCP.3</p>
     * 
     * <p>ZDU.4.3</p>
     * 
     * <p>ZDU.6.1.2</p>
     * 
     * <p>Compound.448-ED (quantity)</p>
     * 
     * <p>Compound.451-EG (unit)</p>
     * 
     * <p>Essential for evaluating appropriate dosage based on 
     * strength, as well as for creating custom compounds with 
     * proper composition.</p>
     * 
     * <p>The quantity of the ingredient in a drug. This is 
     * represented/measured in various forms/units including: mg, 
     * mg/vol, %, etc.</p>
     * 
     * <p>Un-merged Business Name: DrugIngredientQuantity</p>
     * 
     * <p>Relationship: COCT_MT220100CA.Ingredient.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>CompoundIngredient.amount(numerator)</p>
     * 
     * <p>CompoundIngredient.proportionOfFinal(e.g. 10% = 
     * .1mg/1mg)</p>
     * 
     * <p>ZPC.4(quantity)</p>
     * 
     * <p>ZPC.5(unit)</p>
     * 
     * <p>ZPJ1.4(quantity)</p>
     * 
     * <p>ZPJ1.5(unit)</p>
     * 
     * <p>ZPJ1.6(e.g. 10% = .1mg/1mg)</p>
     * 
     * <p>ZCP.3</p>
     * 
     * <p>ZDU.4.3</p>
     * 
     * <p>ZDU.6.1.2</p>
     * 
     * <p>Compound.448-ED (quantity)</p>
     * 
     * <p>Compound.451-EG (unit)</p>
     * 
     * <p>Essential for evaluating appropriate dosage based on 
     * strength, as well as for creating custom compounds with 
     * proper composition.</p>
     * 
     * <p>The quantity of the ingredient in a drug. This is 
     * represented/measured in various forms/units including: mg, 
     * mg/vol, %, etc.</p>
     * 
     * <p>Un-merged Business Name: DrugIngredientQuantity</p>
     * 
     * <p>Relationship: COCT_MT220110CA.Ingredient.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>CompoundIngredient.amount(numerator)</p>
     * 
     * <p>CompoundIngredient.proportionOfFinal(e.g. 10% = 
     * .1mg/1mg)</p>
     * 
     * <p>ZPC.4(quantity)</p>
     * 
     * <p>ZPC.5(unit)</p>
     * 
     * <p>ZPJ1.4(quantity)</p>
     * 
     * <p>ZPJ1.5(unit)</p>
     * 
     * <p>ZPJ1.6(e.g. 10% = .1mg/1mg)</p>
     * 
     * <p>ZCP.3</p>
     * 
     * <p>ZDU.4.3</p>
     * 
     * <p>ZDU.6.1.2</p>
     * 
     * <p>Compound.448-ED (quantity)</p>
     * 
     * <p>Compound.451-EG (unit)</p>
     * 
     * <p>Essential for evaluating appropriate dosage based on 
     * strength, as well as for creating custom compounds with 
     * proper composition.</p>
     * 
     * <p>The quantity of the ingredient in a drug. This is 
     * represented/measured in various forms/units including: mg, 
     * mg/vol, %, etc.</p>
     * 
     * <p>Un-merged Business Name: DrugIngredientQuantity</p>
     * 
     * <p>Relationship: COCT_MT220210CA.Ingredient.quantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>CompoundIngredient.amount(numerator)</p>
     * 
     * <p>CompoundIngredient.proportionOfFinal(e.g. 10% = 
     * .1mg/1mg)</p>
     * 
     * <p>ZPC.4(quantity)</p>
     * 
     * <p>ZPC.5(unit)</p>
     * 
     * <p>ZPJ1.4(quantity)</p>
     * 
     * <p>ZPJ1.5(unit)</p>
     * 
     * <p>ZPJ1.6(e.g. 10% = .1mg/1mg)</p>
     * 
     * <p>ZCP.3</p>
     * 
     * <p>ZDU.4.3</p>
     * 
     * <p>ZDU.6.1.2</p>
     * 
     * <p>Compound.448-ED (quantity)</p>
     * 
     * <p>Compound.451-EG (unit)</p>
     * 
     * <p>Essential for evaluating appropriate dosage based on 
     * strength, as well as for creating custom compounds with 
     * proper composition.</p>
     * 
     * <p>The quantity of the ingredient in a drug. This is 
     * represented/measured in various forms/units including: mg, 
     * mg/vol, %, etc.</p>
     */
    public void setQuantity(PhysicalQuantity quantity) {
        this.quantity.setValue(quantity);
    }


    /**
     * <p>Business Name: DrugIngredientIdentifier</p>
     * 
     * <p>Un-merged Business Name: DrugIngredientIdentifier</p>
     * 
     * <p>Relationship: COCT_MT220200CA.Substance.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.DIN</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.hcAigNumber</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p>
     * 
     * <p>ZPB3.6(mnemonic)</p>
     * 
     * <p>ZPB3.7(print name)</p>
     * 
     * <p>ZPJ1.1(mnemonic)</p>
     * 
     * <p>ZPJ1.2(print name)</p>
     * 
     * <p>ZCP.2</p>
     * 
     * <p>Allows un-ambiguous identification of the ingredients of 
     * a drug for performing various alert checking.</p><p>Also 
     * allows for the identification of antigens as specific class 
     * of ingredients in vaccines.</p>
     * 
     * <p>The unique identifier for the drug or chemical.</p>
     * 
     * <p>Un-merged Business Name: DrugIngredientIdentifier</p>
     * 
     * <p>Relationship: COCT_MT220100CA.Substance.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.DIN</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.hcAigNumber</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p>
     * 
     * <p>ZPB3.6(mnemonic)</p>
     * 
     * <p>ZPB3.7(print name)</p>
     * 
     * <p>ZPJ1.1(mnemonic)</p>
     * 
     * <p>ZPJ1.2(print name)</p>
     * 
     * <p>ZCP.2</p>
     * 
     * <p>Allows un-ambiguous identification of the ingredients of 
     * a drug for performing various alert checking.</p><p>Also 
     * allows for the identification of antigens as class of 
     * ingredients in a vaccine.</p>
     * 
     * <p>The unique identifier for the drug or chemical.</p>
     * 
     * <p>Un-merged Business Name: DrugIngredientIdentifier</p>
     * 
     * <p>Relationship: COCT_MT220110CA.Substance.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.DIN</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.hcAigNumber</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p>
     * 
     * <p>ZPB3.6(mnemonic)</p>
     * 
     * <p>ZPB3.7(print name)</p>
     * 
     * <p>ZPJ1.1(mnemonic)</p>
     * 
     * <p>ZPJ1.2(print name)</p>
     * 
     * <p>ZCP.2</p>
     * 
     * <p>Allows un-ambiguous identification of the ingredients of 
     * a drug for performing various alert checking.</p><p>Also 
     * allows for the identification of antigens as class of 
     * ingredients in a vaccine.</p>
     * 
     * <p>The unique identifier for the drug or chemical.</p>
     * 
     * <p>Un-merged Business Name: DrugIngredientIdentifier</p>
     * 
     * <p>Relationship: COCT_MT220210CA.Substance.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.DIN</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.hcAigNumber</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p>
     * 
     * <p>ZPB3.6(mnemonic)</p>
     * 
     * <p>ZPB3.7(print name)</p>
     * 
     * <p>ZPJ1.1(mnemonic)</p>
     * 
     * <p>ZPJ1.2(print name)</p>
     * 
     * <p>ZCP.2</p>
     * 
     * <p>Allows un-ambiguous identification of the ingredients of 
     * a drug for performing various alert checking.</p><p>Also 
     * allows for the identification of antigens as specific class 
     * of ingredients in vaccines.</p>
     * 
     * <p>The unique identifier for the drug or chemical.</p>
     */
    @Hl7XmlMapping({"ingredientSubstance/code"})
    public ActiveIngredientDrugEntityType getIngredientSubstanceCode() {
        return (ActiveIngredientDrugEntityType) this.ingredientSubstanceCode.getValue();
    }

    /**
     * <p>Business Name: DrugIngredientIdentifier</p>
     * 
     * <p>Un-merged Business Name: DrugIngredientIdentifier</p>
     * 
     * <p>Relationship: COCT_MT220200CA.Substance.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.DIN</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.hcAigNumber</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p>
     * 
     * <p>ZPB3.6(mnemonic)</p>
     * 
     * <p>ZPB3.7(print name)</p>
     * 
     * <p>ZPJ1.1(mnemonic)</p>
     * 
     * <p>ZPJ1.2(print name)</p>
     * 
     * <p>ZCP.2</p>
     * 
     * <p>Allows un-ambiguous identification of the ingredients of 
     * a drug for performing various alert checking.</p><p>Also 
     * allows for the identification of antigens as specific class 
     * of ingredients in vaccines.</p>
     * 
     * <p>The unique identifier for the drug or chemical.</p>
     * 
     * <p>Un-merged Business Name: DrugIngredientIdentifier</p>
     * 
     * <p>Relationship: COCT_MT220100CA.Substance.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.DIN</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.hcAigNumber</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p>
     * 
     * <p>ZPB3.6(mnemonic)</p>
     * 
     * <p>ZPB3.7(print name)</p>
     * 
     * <p>ZPJ1.1(mnemonic)</p>
     * 
     * <p>ZPJ1.2(print name)</p>
     * 
     * <p>ZCP.2</p>
     * 
     * <p>Allows un-ambiguous identification of the ingredients of 
     * a drug for performing various alert checking.</p><p>Also 
     * allows for the identification of antigens as class of 
     * ingredients in a vaccine.</p>
     * 
     * <p>The unique identifier for the drug or chemical.</p>
     * 
     * <p>Un-merged Business Name: DrugIngredientIdentifier</p>
     * 
     * <p>Relationship: COCT_MT220110CA.Substance.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.DIN</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.hcAigNumber</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p>
     * 
     * <p>ZPB3.6(mnemonic)</p>
     * 
     * <p>ZPB3.7(print name)</p>
     * 
     * <p>ZPJ1.1(mnemonic)</p>
     * 
     * <p>ZPJ1.2(print name)</p>
     * 
     * <p>ZCP.2</p>
     * 
     * <p>Allows un-ambiguous identification of the ingredients of 
     * a drug for performing various alert checking.</p><p>Also 
     * allows for the identification of antigens as class of 
     * ingredients in a vaccine.</p>
     * 
     * <p>The unique identifier for the drug or chemical.</p>
     * 
     * <p>Un-merged Business Name: DrugIngredientIdentifier</p>
     * 
     * <p>Relationship: COCT_MT220210CA.Substance.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.DIN</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.hcAigNumber</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p>
     * 
     * <p>ZPB3.6(mnemonic)</p>
     * 
     * <p>ZPB3.7(print name)</p>
     * 
     * <p>ZPJ1.1(mnemonic)</p>
     * 
     * <p>ZPJ1.2(print name)</p>
     * 
     * <p>ZCP.2</p>
     * 
     * <p>Allows un-ambiguous identification of the ingredients of 
     * a drug for performing various alert checking.</p><p>Also 
     * allows for the identification of antigens as specific class 
     * of ingredients in vaccines.</p>
     * 
     * <p>The unique identifier for the drug or chemical.</p>
     */
    public void setIngredientSubstanceCode(ActiveIngredientDrugEntityType ingredientSubstanceCode) {
        this.ingredientSubstanceCode.setValue(ingredientSubstanceCode);
    }


    /**
     * <p>Business Name: DrugIngredientName</p>
     * 
     * <p>Un-merged Business Name: DrugIngredientName</p>
     * 
     * <p>Relationship: COCT_MT220200CA.Substance.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.drugProductName</p>
     * 
     * <p>Used for communication between and display to 
     * providers.</p>
     * 
     * <p>The name of the contained drug or chemical.</p>
     * 
     * <p>Un-merged Business Name: DrugIngredientName</p>
     * 
     * <p>Relationship: COCT_MT220100CA.Substance.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.drugProductName</p>
     * 
     * <p>Used for communication between and display to 
     * providers.</p>
     * 
     * <p>The name of the contained drug or chemical.</p>
     * 
     * <p>Un-merged Business Name: DrugIngredientName</p>
     * 
     * <p>Relationship: COCT_MT220110CA.Substance.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.drugProductName</p>
     * 
     * <p>Used for communication between and display to 
     * providers.</p>
     * 
     * <p>The name of the contained drug or chemical.</p>
     * 
     * <p>Un-merged Business Name: DrugIngredientName</p>
     * 
     * <p>Relationship: COCT_MT220210CA.Substance.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.drugProductName</p>
     * 
     * <p>Used for communication between and display to 
     * providers.</p>
     * 
     * <p>The name of the contained drug or chemical.</p>
     */
    @Hl7XmlMapping({"ingredientSubstance/name"})
    public String getIngredientSubstanceName() {
        return this.ingredientSubstanceName.getValue();
    }

    /**
     * <p>Business Name: DrugIngredientName</p>
     * 
     * <p>Un-merged Business Name: DrugIngredientName</p>
     * 
     * <p>Relationship: COCT_MT220200CA.Substance.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.drugProductName</p>
     * 
     * <p>Used for communication between and display to 
     * providers.</p>
     * 
     * <p>The name of the contained drug or chemical.</p>
     * 
     * <p>Un-merged Business Name: DrugIngredientName</p>
     * 
     * <p>Relationship: COCT_MT220100CA.Substance.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.drugProductName</p>
     * 
     * <p>Used for communication between and display to 
     * providers.</p>
     * 
     * <p>The name of the contained drug or chemical.</p>
     * 
     * <p>Un-merged Business Name: DrugIngredientName</p>
     * 
     * <p>Relationship: COCT_MT220110CA.Substance.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.drugProductName</p>
     * 
     * <p>Used for communication between and display to 
     * providers.</p>
     * 
     * <p>The name of the contained drug or chemical.</p>
     * 
     * <p>Un-merged Business Name: DrugIngredientName</p>
     * 
     * <p>Relationship: COCT_MT220210CA.Substance.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.drugProductName</p>
     * 
     * <p>Used for communication between and display to 
     * providers.</p>
     * 
     * <p>The name of the contained drug or chemical.</p>
     */
    public void setIngredientSubstanceName(String ingredientSubstanceName) {
        this.ingredientSubstanceName.setValue(ingredientSubstanceName);
    }

}
