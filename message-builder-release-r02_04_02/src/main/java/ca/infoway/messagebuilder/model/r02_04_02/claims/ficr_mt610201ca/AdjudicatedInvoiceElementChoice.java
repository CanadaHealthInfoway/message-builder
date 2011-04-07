/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.claims.ficr_mt610201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.r02_04_02.claims.merged.AllowableBean;
import ca.infoway.messagebuilder.model.r02_04_02.merged.AdjudicatedResultOutcomeBean;



/**
 * <p><p>Want sum of all adjudication details (info &amp; 
 * non-info) to equal what was submitted. For example, the 
 * reasons why you refused to pay part of the invoice</p></p>
 */
@Hl7PartTypeMapping({"FICR_MT610201CA.AdjudicatedInvoiceElementChoice"})
public interface AdjudicatedInvoiceElementChoice {

    public AllowableBean getReference1Allowable();
    public void setReference1Allowable(AllowableBean reference1Allowable);

    public AdjudicatedResultOutcomeBean getOutcomeOf();
    public void setOutcomeOf(AdjudicatedResultOutcomeBean outcomeOf);

}
