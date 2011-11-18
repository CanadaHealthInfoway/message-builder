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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.ficr_mt630000ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.AdjudicatedInvoiceElementGroupBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"FICR_MT630000CA.InvoiceElementGroup"})
@Hl7RootType
public class InvoiceElementGroupBean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private MO netAmt = new MOImpl();
    private List<AdjudicatedInvoiceElementGroupBean> referenceAdjudicatedInvoiceElementGroup = new ArrayList<AdjudicatedInvoiceElementGroupBean>();


    /**
     * <p>Invoice Group ID</p>
     * 
     * <p><p>Set of identifiers that uniquely identify the Invoice 
     * Grouping.</p></p>
     * 
     * <p><p>Invoice Grouping Identifier: There are some situations 
     * where more than 1 identifier for this object can be included 
     * in a message.</p></p>
     * 
     * <p><p>May include data centre and sequence numbers</p><p>1. 
     * unique invoice group identifier, independent of adjudicator 
     * recipient.</p><p>2. sequential invoice grouping identifier 
     * by adjudicator.</p><p>Obligation on adjudicator is to return 
     * and communicate about this item with all identifiers (i.e. 
     * identifier 1. and 2.).</p></p>
     * 
     * <p><p>May include data centre and sequence numbers</p><p>1. 
     * unique invoice group identifier, independent of adjudicator 
     * recipient.</p><p>2. sequential invoice grouping identifier 
     * by adjudicator.</p><p>Obligation on adjudicator is to return 
     * and communicate about this item with all identifiers (i.e. 
     * identifier 1. and 2.).</p></p>
     * 
     * <p><p>May include data centre and sequence numbers</p><p>1. 
     * unique invoice group identifier, independent of adjudicator 
     * recipient.</p><p>2. sequential invoice grouping identifier 
     * by adjudicator.</p><p>Obligation on adjudicator is to return 
     * and communicate about this item with all identifiers (i.e. 
     * identifier 1. and 2.).</p></p>
     * 
     * <p><p>May include data centre and sequence numbers</p><p>1. 
     * unique invoice group identifier, independent of adjudicator 
     * recipient.</p><p>2. sequential invoice grouping identifier 
     * by adjudicator.</p><p>Obligation on adjudicator is to return 
     * and communicate about this item with all identifiers (i.e. 
     * identifier 1. and 2.).</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Invoice Type</p>
     * 
     * <p><p>Invoice Type - Health Care Services/Goods, Rx 
     * Dispense, Rx compound, Preferred Accom.</p></p>
     * 
     * <p><p>Invoice Type is the indication to the payor as to the 
     * content rules to apply when processing and adjudicating the 
     * invoice. Basically, the structure of the invoice grouping. 
     * Ie. Clinical Product, Clinical Service, Preferred Accom, Rx 
     * Dispense, Rx Compound</p><p>This is used to indicate the 
     * type of Invoice Grouping.</p><p>Each Invoice Type is used to 
     * specify 1. vocabulary, 2. structure of the Invoice Element 
     * Choice and 3. which Billable Act(s) can be included for the 
     * specified Invoice Type.</p><p>Information on constraints for 
     * the Invoice Type will be found in the NeCST Message 
     * Specifications. Each Benefit Group will indicate which 
     * Invoice Types will be supported by that Benefit 
     * Group.</p><p>Invoice Types will not generate unique and 
     * distinct XML schemas that can tested independent of each 
     * other. They must be tested together within an Message 
     * Type.</p></p>
     * 
     * <p><p>Invoice Type is the indication to the payor as to the 
     * content rules to apply when processing and adjudicating the 
     * invoice. Basically, the structure of the invoice grouping. 
     * Ie. Clinical Product, Clinical Service, Preferred Accom, Rx 
     * Dispense, Rx Compound</p><p>This is used to indicate the 
     * type of Invoice Grouping.</p><p>Each Invoice Type is used to 
     * specify 1. vocabulary, 2. structure of the Invoice Element 
     * Choice and 3. which Billable Act(s) can be included for the 
     * specified Invoice Type.</p><p>Information on constraints for 
     * the Invoice Type will be found in the NeCST Message 
     * Specifications. Each Benefit Group will indicate which 
     * Invoice Types will be supported by that Benefit 
     * Group.</p><p>Invoice Types will not generate unique and 
     * distinct XML schemas that can tested independent of each 
     * other. They must be tested together within an Message 
     * Type.</p></p>
     * 
     * <p><p>Invoice Type is the indication to the payor as to the 
     * content rules to apply when processing and adjudicating the 
     * invoice. Basically, the structure of the invoice grouping. 
     * Ie. Clinical Product, Clinical Service, Preferred Accom, Rx 
     * Dispense, Rx Compound</p><p>This is used to indicate the 
     * type of Invoice Grouping.</p><p>Each Invoice Type is used to 
     * specify 1. vocabulary, 2. structure of the Invoice Element 
     * Choice and 3. which Billable Act(s) can be included for the 
     * specified Invoice Type.</p><p>Information on constraints for 
     * the Invoice Type will be found in the NeCST Message 
     * Specifications. Each Benefit Group will indicate which 
     * Invoice Types will be supported by that Benefit 
     * Group.</p><p>Invoice Types will not generate unique and 
     * distinct XML schemas that can tested independent of each 
     * other. They must be tested together within an Message 
     * Type.</p></p>
     * 
     * <p><p>Invoice Type is the indication to the payor as to the 
     * content rules to apply when processing and adjudicating the 
     * invoice. Basically, the structure of the invoice grouping. 
     * Ie. Clinical Product, Clinical Service, Preferred Accom, Rx 
     * Dispense, Rx Compound</p><p>This is used to indicate the 
     * type of Invoice Grouping.</p><p>Each Invoice Type is used to 
     * specify 1. vocabulary, 2. structure of the Invoice Element 
     * Choice and 3. which Billable Act(s) can be included for the 
     * specified Invoice Type.</p><p>Information on constraints for 
     * the Invoice Type will be found in the NeCST Message 
     * Specifications. Each Benefit Group will indicate which 
     * Invoice Types will be supported by that Benefit 
     * Group.</p><p>Invoice Types will not generate unique and 
     * distinct XML schemas that can tested independent of each 
     * other. They must be tested together within an Message 
     * Type.</p></p>
     * 
     * <p><p>Invoice Type is the indication to the payor as to the 
     * content rules to apply when processing and adjudicating the 
     * invoice. Basically, the structure of the invoice grouping. 
     * Ie. Clinical Product, Clinical Service, Preferred Accom, Rx 
     * Dispense, Rx Compound</p><p>This is used to indicate the 
     * type of Invoice Grouping.</p><p>Each Invoice Type is used to 
     * specify 1. vocabulary, 2. structure of the Invoice Element 
     * Choice and 3. which Billable Act(s) can be included for the 
     * specified Invoice Type.</p><p>Information on constraints for 
     * the Invoice Type will be found in the NeCST Message 
     * Specifications. Each Benefit Group will indicate which 
     * Invoice Types will be supported by that Benefit 
     * Group.</p><p>Invoice Types will not generate unique and 
     * distinct XML schemas that can tested independent of each 
     * other. They must be tested together within an Message 
     * Type.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getCode() {
        return (Code) this.code.getValue();
    }
    public void setCode(Code code) {
        this.code.setValue(code);
    }


    /**
     * <p>Invoice Sub-total</p>
     * 
     * <p><p>Invoice Sub-total - Identifies the total monetary 
     * amount billed for the invoice element.</p></p>
     * 
     * <p><p>This is the sum of the Submitted Invoice Line 
     * amounts.</p></p>
     * 
     * <p><p>For Cancel Request: This would serve as a cross-check 
     * for the Adjudicator for the Invoice Grouping that is being 
     * cancelled.</p><p>Attribute cannot be mandatory as it may not 
     * be present for a Coverage Extension Request.</p></p>
     * 
     * <p><p>For Cancel Request: This would serve as a cross-check 
     * for the Adjudicator for the Invoice Grouping that is being 
     * cancelled.</p><p>Attribute cannot be mandatory as it may not 
     * be present for a Coverage Extension Request.</p></p>
     */
    @Hl7XmlMapping({"netAmt"})
    public Money getNetAmt() {
        return this.netAmt.getValue();
    }
    public void setNetAmt(Money netAmt) {
        this.netAmt.setValue(netAmt);
    }


    @Hl7XmlMapping({"reference/adjudicatedInvoiceElementGroup"})
    public List<AdjudicatedInvoiceElementGroupBean> getReferenceAdjudicatedInvoiceElementGroup() {
        return this.referenceAdjudicatedInvoiceElementGroup;
    }

}
