/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.claims.ficr_mt630000ca;

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
import ca.infoway.messagebuilder.model.merged.AdjudicatedInvoiceElementGroupBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"FICR_MT630000CA.InvoiceElementGroup"})
@Hl7RootType
public class InvoiceElementGroupBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private CV invoiceType = new CVImpl();
    private List<AdjudicatedInvoiceElementGroupBean> referenceAdjudicatedInvoiceElementGroup = new ArrayList<AdjudicatedInvoiceElementGroupBean>();
    private II invoiceGroupID = new IIImpl();
    private MO invoiceSubTotal = new MOImpl();


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
    public Code getInvoiceType() {
        return (Code) this.invoiceType.getValue();
    }
    public void setInvoiceType(Code invoiceType) {
        this.invoiceType.setValue(invoiceType);
    }


    @Hl7XmlMapping({"reference/adjudicatedInvoiceElementGroup"})
    public List<AdjudicatedInvoiceElementGroupBean> getReferenceAdjudicatedInvoiceElementGroup() {
        return this.referenceAdjudicatedInvoiceElementGroup;
    }


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
    public Identifier getInvoiceGroupID() {
        return this.invoiceGroupID.getValue();
    }
    public void setInvoiceGroupID(Identifier invoiceGroupID) {
        this.invoiceGroupID.setValue(invoiceGroupID);
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
    public Money getInvoiceSubTotal() {
        return this.invoiceSubTotal.getValue();
    }
    public void setInvoiceSubTotal(Money invoiceSubTotal) {
        this.invoiceSubTotal.setValue(invoiceSubTotal);
    }

}
