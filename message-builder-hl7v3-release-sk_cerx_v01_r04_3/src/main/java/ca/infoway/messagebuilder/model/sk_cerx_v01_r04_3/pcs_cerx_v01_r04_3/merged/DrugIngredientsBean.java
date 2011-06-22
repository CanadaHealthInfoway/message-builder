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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ActiveIngredientDrugEntityType;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>DrugIngredients</p>
 * 
 * <p>COCT_MT220210CA.Substance: Drug Ingredients</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A list of 
 * drugs, chemicals or excipients that may or may not be 
 * present in a manufactured drug or a custom compound.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Important 
 * for expressing strength of active ingredients within a drug 
 * product, for expressing compound recipes, and for 
 * identifying potential causes for adverse reactions.</p></p>
 * 
 * <p>COCT_MT220200CA.Substance: Drug Ingredients</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A list of 
 * drugs, chemicals or excipients that may or may not be 
 * present in a manufactured drug or a custom compound.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Important 
 * for expressing strength of active ingredients within a drug 
 * product, for expressing compound recipes, and for 
 * identifying potential causes for adverse reactions.</p></p>
 * 
 * <p>POME_MT010100CA.Substance: Drug Ingredients</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A list of 
 * drugs or raw chemicals that may be present in a manufactured 
 * drug or a custom compound.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Important 
 * for expressing strength of active ingredients within a drug 
 * product, for expressing compound recipes, and for 
 * identifying potential causes for adverse reactions.</p></p>
 * 
 * <p>COCT_MT220110CA.Substance: Drug Ingredients</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A list of 
 * drugs, chemicals or excipients that may or may not be 
 * present in a manufactured drug or a custom compound.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Important 
 * for expressing strength of active ingredients within a drug 
 * product, for expressing compound recipes, and for 
 * identifying potential causes for adverse reactions.</p></p>
 * 
 * <p>COCT_MT220100CA.Substance: Drug Ingredients</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A list of 
 * drugs, chemicals or excipients that may or may not be 
 * present in a manufactured drug or a custom compound.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Important 
 * for expressing strength of active ingredients within a drug 
 * product, for expressing compound recipes, and for 
 * identifying potential causes for adverse reactions.</p></p>
 * 
 * <p>POME_MT010040CA.Substance: Drug Ingredients</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">A list of 
 * drugs or raw chemicals that may be present in a manufactured 
 * drug or a custom compound.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Important 
 * for expressing strength of active ingredients within a drug 
 * product, for expressing compound recipes, and for 
 * identifying potential causes for adverse reactions.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT220100CA.Substance","COCT_MT220110CA.Substance","COCT_MT220200CA.Substance","COCT_MT220210CA.Substance","POME_MT010040CA.Substance","POME_MT010100CA.Substance"})
public class DrugIngredientsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110621L;
    private CV code = new CVImpl();
    private ST name = new STImpl();


    /**
     * <p>Drug Ingredient Identifier</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The unique 
     * identifier for the drug or chemical.</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.activeIngredientCode</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.DIN</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.hcAigNumber</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.6(mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.7(print 
     * name)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPJ1.1(mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPJ1.2(print 
     * name)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZCP.2</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.activeIngredientCode</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.DIN</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.hcAigNumber</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.6(mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.7(print 
     * name)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPJ1.1(mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPJ1.2(print 
     * name)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZCP.2</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.activeIngredientCode</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.DIN</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.hcAigNumber</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.6(mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.7(print 
     * name)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPJ1.1(mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPJ1.2(print 
     * name)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZCP.2</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.activeIngredientCode</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.DIN</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.hcAigNumber</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.6(mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.7(print 
     * name)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPJ1.1(mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPJ1.2(print 
     * name)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZCP.2</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.activeIngredientCode</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.DIN</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.hcAigNumber</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.6(mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.7(print 
     * name)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPJ1.1(mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPJ1.2(print 
     * name)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZCP.2</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.activeIngredientCode</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.DIN</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.hcAigNumber</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.6(mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.7(print 
     * name)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPJ1.1(mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPJ1.2(print 
     * name)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZCP.2</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.activeIngredientCode</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.DIN</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.hcAigNumber</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.6(mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.7(print 
     * name)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPJ1.1(mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPJ1.2(print 
     * name)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZCP.2</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.activeIngredientCode</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.DIN</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.hcAigNumber</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.6(mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.7(print 
     * name)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPJ1.1(mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPJ1.2(print 
     * name)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZCP.2</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.activeIngredientCode</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.DIN</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.hcAigNumber</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.6(mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.7(print 
     * name)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPJ1.1(mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPJ1.2(print 
     * name)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZCP.2</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.activeIngredientCode</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.DIN</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.hcAigNumber</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.6(mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.7(print 
     * name)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPJ1.1(mnemonic)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPJ1.2(print 
     * name)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZCP.2</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
     * un-ambiguous identification of the ingredients of a drug for 
     * performing various alert checking.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Also allows for 
     * the identifi
     * ... [rest of documentation truncated due to excessive length]
     */
    @Hl7XmlMapping({"code"})
    public ActiveIngredientDrugEntityType getCode() {
        return (ActiveIngredientDrugEntityType) this.code.getValue();
    }
    public void setCode(ActiveIngredientDrugEntityType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Ingredient Name</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The name of 
     * the contained drug or chemical.</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.drugProductName</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Used for 
     * communication between and display to providers.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">This attribute is 
     * marked as &quot;populated&quot; as an ingredient name should 
     * be available in most cases.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Used for 
     * communication between and display to providers.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">This attribute is 
     * marked as &quot;populated&quot; as an ingredient name should 
     * be available in most cases.</p></p>
     * 
     * <p>B:Drug Ingredient Name</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The name of 
     * the contained drug or chemical.</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.drugProductName</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Used for 
     * communication between and display to providers.</p></p>
     * 
     * <p>K:Ingredient Name</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The name of 
     * the contained drug or chemical.</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">CompoundIngredient.IngredientDrug.drugProductName</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Used for 
     * communication between and display to providers.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">This attribute is 
     * marked as &quot;populated&quot; as an ingredient name should 
     * be available in most cases.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Used for 
     * communication between and display to providers.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">This attribute is 
     * marked as &quot;populated&quot; as an ingredient name should 
     * be available in most cases.</p></p>
     */
    @Hl7XmlMapping({"name"})
    public String getName() {
        return this.name.getValue();
    }
    public void setName(String name) {
        this.name.setValue(name);
    }

}
