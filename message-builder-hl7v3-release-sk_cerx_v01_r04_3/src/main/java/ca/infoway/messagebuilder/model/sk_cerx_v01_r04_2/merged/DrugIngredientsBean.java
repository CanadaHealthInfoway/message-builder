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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ActiveIngredientDrugEntityType;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: DrugIngredients</p>
 * 
 * <p>COCT_MT220210CA.Substance: Drug Ingredients</p>
 * 
 * <p>Must specify at least one of Drug Ingredient Identifier 
 * and Drug Ingredient Name</p>
 * 
 * <p>A list of drugs, chemicals or excipients that may or may 
 * not be present in a manufactured drug or a custom 
 * compound.</p>
 * 
 * <p>Important for expressing strength of active ingredients 
 * within a drug product, for expressing compound recipes, and 
 * for identifying potential causes for adverse reactions.</p>
 * 
 * <p>COCT_MT220200CA.Substance: Drug Ingredients</p>
 * 
 * <p>Must specify at least one of Drug Ingredient Identifier 
 * and Drug Ingredient Name</p>
 * 
 * <p>A list of drugs, chemicals or excipients that may or may 
 * not be present in a manufactured drug or a custom 
 * compound.</p>
 * 
 * <p>Important for expressing strength of active ingredients 
 * within a drug product, for expressing compound recipes, and 
 * for identifying potential causes for adverse reactions.</p>
 * 
 * <p>POME_MT010100CA.Substance: Drug Ingredients</p>
 * 
 * <p>At least one of ingredient code or ingredient name must 
 * be specified.</p>
 * 
 * <p>A list of drugs or raw chemicals that may be present in a 
 * manufactured drug or a custom compound.</p>
 * 
 * <p>Important for expressing strength of active ingredients 
 * within a drug product, for expressing compound recipes, and 
 * for identifying potential causes for adverse reactions.</p>
 * 
 * <p>COCT_MT220110CA.Substance: Drug Ingredients</p>
 * 
 * <p>Must specify at least one of Drug Ingredient Identifier 
 * and Drug Ingredient Name</p>
 * 
 * <p>A list of drugs, chemicals or excipients that may or may 
 * not be present in a manufactured drug or a custom 
 * compound.</p>
 * 
 * <p>Important for expressing strength of active ingredients 
 * within a drug product, for expressing compound recipes, and 
 * for identifying potential causes for adverse reactions.</p>
 * 
 * <p>COCT_MT220100CA.Substance: Drug Ingredients</p>
 * 
 * <p>Must specify at least one of Drug Ingredient Identifier 
 * and Drug Ingredient Name</p>
 * 
 * <p>A list of drugs, chemicals or excipients that may or may 
 * not be present in a manufactured drug or a custom 
 * compound.</p>
 * 
 * <p>Important for expressing strength of active ingredients 
 * within a drug product, for expressing compound recipes, and 
 * for identifying potential causes for adverse reactions.</p>
 * 
 * <p>POME_MT010040CA.Substance: Drug Ingredients</p>
 * 
 * <p>Either a code or name must be specified.</p>
 * 
 * <p>A list of drugs or raw chemicals that may be present in a 
 * manufactured drug or a custom compound.</p>
 * 
 * <p>Important for expressing strength of active ingredients 
 * within a drug product, for expressing compound recipes, and 
 * for identifying potential causes for adverse reactions.</p>
 */
@Hl7PartTypeMapping({"COCT_MT220100CA.Substance","COCT_MT220110CA.Substance","COCT_MT220200CA.Substance","COCT_MT220210CA.Substance","POME_MT010040CA.Substance","POME_MT010100CA.Substance"})
public class DrugIngredientsBean extends MessagePartBean {

    private static final long serialVersionUID = 20130103L;
    private CV code = new CVImpl();
    private ST name = new STImpl();


    /**
     * <p>Un-merged Business Name: DrugIngredientIdentifier</p>
     * 
     * <p>Relationship: COCT_MT220200CA.Substance.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The unique identifier for the drug or chemical.</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p>
     * 
     * <p>Allows un-ambiguous identification of the ingredients of 
     * a drug for performing various alert checking.</p><p>Also 
     * allows for the identification of antigens as specific class 
     * of ingredients in vaccines.</p>
     * 
     * <p>Allows un-ambiguous identification of the ingredients of 
     * a drug for performing various alert checking.</p><p>Also 
     * allows for the identification of antigens as specific class 
     * of ingredients in vaccines.</p>
     * 
     * <p><div>PIN requires that an ingredient code be given.</div> 
     * <div>Ingredients that do not have a code will not be</div> 
     * <div>sent.</div> <p>This identifier must be the FDB 
     * HIC.&nbsp;</p></p>
     * 
     * <p>Un-merged Business Name: DrugIngredientCode</p>
     * 
     * <p>Relationship: COCT_MT220210CA.Substance.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The unique identifier for the drug or chemical.</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.I
     * ... [rest of documentation truncated due to excessive length]
     */
    @Hl7XmlMapping({"code"})
    public ActiveIngredientDrugEntityType getCode() {
        return (ActiveIngredientDrugEntityType) this.code.getValue();
    }

    /**
     * <p>Un-merged Business Name: DrugIngredientIdentifier</p>
     * 
     * <p>Relationship: COCT_MT220200CA.Substance.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The unique identifier for the drug or chemical.</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p>
     * 
     * <p>Allows un-ambiguous identification of the ingredients of 
     * a drug for performing various alert checking.</p><p>Also 
     * allows for the identification of antigens as specific class 
     * of ingredients in vaccines.</p>
     * 
     * <p>Allows un-ambiguous identification of the ingredients of 
     * a drug for performing various alert checking.</p><p>Also 
     * allows for the identification of antigens as specific class 
     * of ingredients in vaccines.</p>
     * 
     * <p><div>PIN requires that an ingredient code be given.</div> 
     * <div>Ingredients that do not have a code will not be</div> 
     * <div>sent.</div> <p>This identifier must be the FDB 
     * HIC.&nbsp;</p></p>
     * 
     * <p>Un-merged Business Name: DrugIngredientCode</p>
     * 
     * <p>Relationship: COCT_MT220210CA.Substance.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The unique identifier for the drug or chemical.</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.IngredientDrug.DIN</p><p>CompoundIngredient.IngredientDrug.hcAigNumber</p><p>CompoundIngredient.IngredientDrug.standardProductId(mnemonic)</p><p>CompoundIngredient.IngredientDrug.standardProductIdType(code 
     * system)</p><p>ZPB3.6(mnemonic)</p><p>ZPB3.7(print 
     * name)</p><p>ZPJ1.1(mnemonic)</p><p>ZPJ1.2(print 
     * name)</p><p>ZCP.2</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.activeIngredientCode</p><p>CompoundIngredient.I
     * ... [rest of documentation truncated due to excessive length]
     */
    public void setCode(ActiveIngredientDrugEntityType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Un-merged Business Name: DrugIngredientName</p>
     * 
     * <p>Relationship: COCT_MT220200CA.Substance.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The name of the contained drug or chemical.</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.drugProductName</p>
     * 
     * <p>Used for communication between and display to 
     * providers.</p>
     * 
     * <p>Un-merged Business Name: DrugIngredientName</p>
     * 
     * <p>Relationship: COCT_MT220210CA.Substance.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The name of the contained drug or chemical.</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.drugProductName</p>
     * 
     * <p>Used for communication between and display to 
     * providers.</p>
     * 
     * <p>Un-merged Business Name: IngredientName</p>
     * 
     * <p>Relationship: POME_MT010100CA.Substance.name</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>The name of the contained drug or chemical.</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.drugProductName</p>
     * 
     * <p>Used for communication between and display to 
     * providers.</p><p>This attribute is marked as 
     * &quot;populated&quot; as an ingredient name should be 
     * available in most cases.</p>
     * 
     * <p>Used for communication between and display to 
     * providers.</p><p>This attribute is marked as 
     * &quot;populated&quot; as an ingredient name should be 
     * available in most cases.</p>
     * 
     * <p>Un-merged Business Name: DrugIngredientName</p>
     * 
     * <p>Relationship: COCT_MT220100CA.Substance.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The name of the contained drug or chemical.</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.drugProductName</p>
     * 
     * <p>Used for communication between and display to 
     * providers.</p>
     * 
     * <p>Un-merged Business Name: DrugIngredientName</p>
     * 
     * <p>Relationship: COCT_MT220110CA.Substance.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The name of the contained drug or chemical.</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.drugProductName</p>
     * 
     * <p>Used for communication between and display to 
     * providers.</p>
     * 
     * <p>Un-merged Business Name: IngredientName</p>
     * 
     * <p>Relationship: POME_MT010040CA.Substance.name</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>The name of the contained drug or chemical.</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.drugProductName</p>
     * 
     * <p>Used for communication between and display to 
     * providers.</p><p>This attribute is marked as 
     * &quot;populated&quot; as an ingredient name should be 
     * available in most cases.</p>
     * 
     * <p>Used for communication between and display to 
     * providers.</p><p>This attribute is marked as 
     * &quot;populated&quot; as an ingredient name should be 
     * available in most cases.</p>
     */
    @Hl7XmlMapping({"name"})
    public String getName() {
        return this.name.getValue();
    }

    /**
     * <p>Un-merged Business Name: DrugIngredientName</p>
     * 
     * <p>Relationship: COCT_MT220200CA.Substance.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The name of the contained drug or chemical.</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.drugProductName</p>
     * 
     * <p>Used for communication between and display to 
     * providers.</p>
     * 
     * <p>Un-merged Business Name: DrugIngredientName</p>
     * 
     * <p>Relationship: COCT_MT220210CA.Substance.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The name of the contained drug or chemical.</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.drugProductName</p>
     * 
     * <p>Used for communication between and display to 
     * providers.</p>
     * 
     * <p>Un-merged Business Name: IngredientName</p>
     * 
     * <p>Relationship: POME_MT010100CA.Substance.name</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>The name of the contained drug or chemical.</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.drugProductName</p>
     * 
     * <p>Used for communication between and display to 
     * providers.</p><p>This attribute is marked as 
     * &quot;populated&quot; as an ingredient name should be 
     * available in most cases.</p>
     * 
     * <p>Used for communication between and display to 
     * providers.</p><p>This attribute is marked as 
     * &quot;populated&quot; as an ingredient name should be 
     * available in most cases.</p>
     * 
     * <p>Un-merged Business Name: DrugIngredientName</p>
     * 
     * <p>Relationship: COCT_MT220100CA.Substance.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The name of the contained drug or chemical.</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.drugProductName</p>
     * 
     * <p>Used for communication between and display to 
     * providers.</p>
     * 
     * <p>Un-merged Business Name: DrugIngredientName</p>
     * 
     * <p>Relationship: COCT_MT220110CA.Substance.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The name of the contained drug or chemical.</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.drugProductName</p>
     * 
     * <p>Used for communication between and display to 
     * providers.</p>
     * 
     * <p>Un-merged Business Name: IngredientName</p>
     * 
     * <p>Relationship: POME_MT010040CA.Substance.name</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>The name of the contained drug or chemical.</p>
     * 
     * <p>CompoundIngredient.IngredientDrug.drugProductName</p>
     * 
     * <p>Used for communication between and display to 
     * providers.</p><p>This attribute is marked as 
     * &quot;populated&quot; as an ingredient name should be 
     * available in most cases.</p>
     * 
     * <p>Used for communication between and display to 
     * providers.</p><p>This attribute is marked as 
     * &quot;populated&quot; as an ingredient name should be 
     * available in most cases.</p>
     */
    public void setName(String name) {
        this.name.setValue(name);
    }

}
